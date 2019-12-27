package optic_fusion1.slimefunreloaded;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import optic_fusion1.slimefunreloaded.ancient_altar.AltarRecipe;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.FileConfigurationOptions;
import org.bukkit.plugin.java.JavaPlugin;
import optic_fusion1.slimefunreloaded.GPS.GPSNetwork;
import optic_fusion1.slimefunreloaded.category.CategoryManager;
import optic_fusion1.slimefunreloaded.category.CategoryRegistery;
import optic_fusion1.slimefunreloaded.component.ComponentManager;
import optic_fusion1.slimefunreloaded.component.ComponentRegistry;
import optic_fusion1.slimefunreloaded.component.ComponentState;
import optic_fusion1.slimefunreloaded.component.SlimefunReloadedComponent;
import optic_fusion1.slimefunreloaded.component.item.VanillaItem;
import optic_fusion1.slimefunreloaded.hooks.SlimefunReloadedHooks;
import optic_fusion1.slimefunreloaded.inventory.BlockMenuPreset;
import optic_fusion1.slimefunreloaded.inventory.UniversalBlockMenu;
import optic_fusion1.slimefunreloaded.listener.ItemUseListener;
import optic_fusion1.slimefunreloaded.listener.PlayerQuitListener;
import optic_fusion1.slimefunreloaded.listener.ToolListener;
import optic_fusion1.slimefunreloaded.listener.WorldListener;
import optic_fusion1.slimefunreloaded.metrics.MetricsLite;
import optic_fusion1.slimefunreloaded.protection.ProtectionManager;
import optic_fusion1.slimefunreloaded.recipe.RecipeSnapshot;
import optic_fusion1.slimefunreloaded.research.ResearchManager;
import optic_fusion1.slimefunreloaded.research.ResearchRegistry;
import optic_fusion1.slimefunreloaded.updater.Updater;
import optic_fusion1.slimefunreloaded.util.BlockInfoConfig;
import optic_fusion1.slimefunreloaded.util.BlockStorage;
import optic_fusion1.slimefunreloaded.util.Config;
import optic_fusion1.slimefunreloaded.util.CustomItemDataService;
import optic_fusion1.slimefunreloaded.util.CustomTextureService;
import optic_fusion1.slimefunreloaded.util.I18n;
import optic_fusion1.slimefunreloaded.util.PlayerProfile;
import optic_fusion1.slimefunreloaded.util.ReflectionUtils;
import optic_fusion1.slimefunreloaded.util.SlimefunReloadedItems;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;

//TODO: Finish & clean this class up see me.mrCookieSlime.Slimefun.SlimefunPlugin for the Slimefun equivalent of this class
public class SlimefunReloaded extends JavaPlugin {

  private RecipeSnapshot recipeSnapshot;

  private final CustomItemDataService itemDataService = new CustomItemDataService(this, "slimefunreloaded_item");
  private final CustomTextureService textureService = new CustomTextureService(this);
//    private TickerTask ticker;
  private final File DATA_FOLDER = new File("plugins/SlimefunReloaded");
  private final File DATABASE_FOLDER = new File(DATA_FOLDER, "data-storage/Players");
  private final File PATH_BLOCKS = new File(DATA_FOLDER, "data-storage/stored-blocks");
  private final File PATH_CHUNKS = new File(DATA_FOLDER, "data-storage/stored-chunks");
  private final File STORED_INVENTORIES = new File(DATA_FOLDER, "data-storage/stored-inventories");
  private final File UNIVERSAL_INVENTORIES = new File(DATA_FOLDER, "data-storage/universal-inventories");
  private Config CONFIG;
  private final Config RESEARCHES_CONFIG = new Config(new File(DATA_FOLDER, "Researches.yml"));
  private final Config ITEMS_CONFIG = new Config(new File(DATA_FOLDER, "Items.yml"));
  private final Config WHITELIST_CONFIG = new Config(new File(DATA_FOLDER, "whitelist.yml"));
  private ComponentManager COMPONENT_MANAGER;
  private CategoryManager CATEGORY_MANAGER;
  private ResearchManager RESEARCH_MANAGER;

  private GPSNetwork gps;
  private ProtectionManager protectionManager;
  private SlimefunReloadedHooks slimefunReloadedHooks;
  private Logger logger;

  private boolean printOutLoading;
  private boolean researchesEnabled;
  private boolean researchesFreeInCreative;
  private List<String> researchesTitles;
  private int blocksInfoLoadingDelay;
  private int blocksAutoSaveDelay;
  private boolean guideShowVanillaRecipes;
  private int emeraldEnchantsLimit;
  private boolean legacyDustWasher;
  private boolean legacyOreGrinder;
  private boolean legacyOreWasher;
  private int smelteryFireBreakChance;
  private final Map<String, BlockStorage> worlds = new HashMap<>();
  private final Set<String> tickers = new HashSet<>();
  private final Map<String, Set<Location>> tickingChunks = new HashMap<>();
  private final Set<String> loadedTickers = new HashSet<>();
  private final Map<String, BlockInfoConfig> mapChunks = new HashMap<>();
  private final Map<String, UniversalBlockMenu> universalInventories = new HashMap<>();
  private String version;
  public final Map<UUID, PlayerProfile> profiles = new HashMap<>();

  public final Set<Location> altarinuse = new HashSet<>();
  public final Set<AltarRecipe> altarRecipes = new HashSet<>();
  public final Map<String, BlockMenuPreset> blockMenuPresets = new HashMap<>();
  public final Set<UUID> teleporterUsers = new HashSet<>();
  public final Set<UUID> elevatorUsers = new HashSet<>();
  public final Map<String, SlimefunReloadedComponent> itemIDs = new HashMap<>();
  private static final PluginManager PLUGIN_MANAGER = Bukkit.getPluginManager();

  @Override
  public void onEnable() {
    version = getDescription().getVersion();
    logger = getLogger();
    String nmsVersion = ReflectionUtils.getVersion();
    if (!nmsVersion.startsWith("v1_15")) {
      logger.severe("Slimefun Reloaded was not installed correctly!");
      logger.severe("You are using the wrong version of Minecraft!");
      logger.log(Level.SEVERE, "You are using Minecraft {0}", nmsVersion);
      logger.log(Level.SEVERE, "but Slimefun Reloaded v{0} requires you to be using", getDescription().getVersion());
      logger.severe("Minecraft 1.15");
      logger.severe("Please use an older version of Slimefun or Slimefun Reloaded and disable auto-updating");
      logger.severe("or consider updating your server software");
      Bukkit.getPluginManager().disablePlugin(this);
      return;
    }
    Slimefun.setSlimefunReloaded(this);
    new I18n();
    logger.info("Loading files...");
    a();
    cleanup();
    logger.info("loading config...");
    setupConfig();
    loadSettings();
    new MetricsLite(this);
    gps = new GPSNetwork();
    if (CONFIG.getBoolean("options.auto-update")) {
      Updater updater = new Updater(this, 73726, false);
      updater.downloadUpdate();
    }
    createFiles();
    logger.info("Loading Items...");
    setupItemSettings();
    loadDescriptions();
    logger.info("Loading Researches...");
    RESEARCH_MANAGER = new ResearchManager();
    ResearchRegistry.registerResearches();
    logger.log(Level.INFO, "Loaded {0} Researches", RESEARCH_MANAGER.getResearches().size());
    logger.info("Loading categories...");
    CATEGORY_MANAGER = new CategoryManager();
    CategoryRegistery.registerCategories();
    logger.log(Level.INFO, "Loaded {0} Categories", CATEGORY_MANAGER.getCategories().size());
    logger.info("Loading components...");
    COMPONENT_MANAGER = new ComponentManager();
    ComponentRegistry.registerComponents();
    logger.log(Level.INFO, "Loaded {0} Components ({1} Components are enabled)", new Object[]{COMPONENT_MANAGER.getComponents().size(), COMPONENT_MANAGER.getEnabledComponents().size()});
    System.out.println("Components: " + COMPONENT_MANAGER.getComponents().size());
    System.out.println("Enabled Components: " + COMPONENT_MANAGER.getEnabledComponents().size());
    setupMisc();
    addWikiPages();
    textureService.setup(COMPONENT_MANAGER.getComponents());

    //All Slimefun Reloaded Listeners
    registerListener(new WorldListener());
    registerListener(new PlayerQuitListener());
    registerListener(new ItemUseListener());
    registerListener(new ToolListener());

    // Initiating various Stuff and all Items with a slightly delay (0ms after the Server finished loading)
    Slimefun.runSync(() -> {
      recipeSnapshot = new RecipeSnapshot(this);
      protectionManager = new ProtectionManager(getServer());
//      MiscSetup.loadItems(settings);

      for (World world : Bukkit.getWorlds()) {
        new BlockStorage(world);
      }

//      if (SlimefunItem.getByID("ANCIENT_ALTAR") != null) {
//        new AncientAltarListener((SlimefunPlugin) instance);
//      }
    }, 0);
  }

  @Override
  public void onDisable() {
    Bukkit.getScheduler().cancelTasks(this);
//    if(ticker != null){
//      //Finishes all started movements/removals of block data
//      ticker.halt();
//      ticker.run();
//    }
    PlayerProfile.iterator().forEachRemaining(profile -> {
      if (profile.isDirty()) {
        profile.save();
      }
    });

    for (World world : Bukkit.getWorlds()) {
      BlockStorage storage = BlockStorage.getStorage(world);
      if (storage == null) {
        logger.severe("Couldn't save Slimefun Reloaded Blocks for World " + world.getName());
      } else {
        storage.save(true);
      }
    }
    for (UniversalBlockMenu menu : universalInventories.values()) {
      menu.save();
    }
//    SlimefunReloadedBackup.start();
    /*
		// Prevent Memory Leaks
		AContainer.processing = null;
		AContainer.progress = null;
		
		AGenerator.processing = null;
		AGenerator.progress = null;
		
		AReactor.processing = null;
		AReactor.progress = null;

		instance = null;
     */
    for (Player p : Bukkit.getOnlinePlayers()) {
      p.closeInventory();
    }
  }

  private void registerListener(Listener listener) {
    PLUGIN_MANAGER.registerEvents(listener, this);
  }

  private void addWikiPages() {
    JsonParser parser = new JsonParser();
    Slimefun.getLogger().log(Level.INFO, "Loading Wiki pages...");

    try (BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/wiki.json")))) {
      JsonElement element = parser.parse(reader.lines().collect(Collectors.joining("")));
      JsonObject json = element.getAsJsonObject();

      for (Map.Entry<String, JsonElement> entry : json.entrySet()) {
        SlimefunReloadedComponent component = COMPONENT_MANAGER.getComponentByKey(entry.getKey());

        if (component != null) {
//          component.addWikipage(entry.getValue().getAsString());
        }
      }
    } catch (IOException e) {
      Slimefun.getLogger().log(Level.SEVERE, "Failed to load wiki.json file", e);
    }
  }

  private void setupMisc() {
    SlimefunReloadedComponent talisman = COMPONENT_MANAGER.getComponentByKey("COMMON_TALISMAN");
    if (talisman != null && (boolean) getItemValue(talisman.getID(), "recipe-requires-nether-stars")) {
      talisman.setRecipe(new ItemStack[]{SlimefunReloadedItems.MAGIC_LUMP_2, SlimefunReloadedItems.GOLD_8K, SlimefunReloadedItems.MAGIC_LUMP_2, null, new ItemStack(Material.NETHER_STAR), null, SlimefunReloadedItems.MAGIC_LUMP_2, SlimefunReloadedItems.GOLD_8K, SlimefunReloadedItems.MAGIC_LUMP_2});
    }
    //    SlimefunItem.setRadioactive(SlimefunReloadedItems.URANIUM);
//    SlimefunItem.setRadioactive(SlimefunReloadedItems.SMALL_URANIUM);
//    SlimefunItem.setRadioactive(SlimefunReloadedItems.BLISTERING_INGOT);
//    SlimefunItem.setRadioactive(SlimefunReloadedItems.BLISTERING_INGOT_2);
//    SlimefunItem.setRadioactive(SlimefunReloadedItems.BLISTERING_INGOT_3);
//    SlimefunItem.setRadioactive(SlimefunReloadedItems.NETHER_ICE);
//    SlimefunItem.setRadioactive(SlimefunReloadedItems.ENRICHED_NETHER_ICE);
  }

  private void loadDescriptions() {
//    Slimefun.addYoutubeVideo("ANCIENT_ALTAR", "https://youtu.be/mx2Y5DP8uZI");
//    Slimefun.addYoutubeVideo("ANCIENT_PEDESTAL", "https://youtu.be/mx2Y5DP8uZI");
//
//    Slimefun.addYoutubeVideo("BLISTERING_INGOT", "https://youtu.be/mPhKUv4JR_Y");
//    Slimefun.addYoutubeVideo("BLISTERING_INGOT_2", "https://youtu.be/mPhKUv4JR_Y");
//    Slimefun.addYoutubeVideo("BLISTERING_INGOT_3", "https://youtu.be/mPhKUv4JR_Y");
//
//    Slimefun.addYoutubeVideo("INFERNAL_BONEMEAL", "https://youtu.be/gKxWqMlJDXY");
//
//    Slimefun.addYoutubeVideo("RAINBOW_WOOL", "https://youtu.be/csvb0CxofdA");
//    Slimefun.addYoutubeVideo("RAINBOW_GLASS", "https://youtu.be/csvb0CxofdA");
//    Slimefun.addYoutubeVideo("RAINBOW_CLAY", "https://youtu.be/csvb0CxofdA");
//    Slimefun.addYoutubeVideo("RAINBOW_GLASS_PANE", "https://youtu.be/csvb0CxofdA");
//
//    Slimefun.addYoutubeVideo("RAINBOW_WOOL_XMAS", "https://youtu.be/l4pKk4SDE");
//    Slimefun.addYoutubeVideo("RAINBOW_GLASS_XMAS", "https://youtu.be/l4pKk4SDE");
//    Slimefun.addYoutubeVideo("RAINBOW_CLAY_XMAS", "https://youtu.be/l4pKk4SDE");
//    Slimefun.addYoutubeVideo("RAINBOW_GLASS_PANE_XMAS", "https://youtu.be/l4pKk4SDE");
//
//    Slimefun.addYoutubeVideo("OIL_PUMP", "https://youtu.be/_XmJ6hrv9uY");
//    Slimefun.addYoutubeVideo("GPS_GEO_SCANNER", "https://youtu.be/_XmJ6hrv9uY");
//    Slimefun.addYoutubeVideo("REFINERY", "https://youtu.be/_XmJ6hrv9uY");
//    Slimefun.addYoutubeVideo("BUCKET_OF_OIL", "https://youtu.be/_XmJ6hrv9uY");
//    Slimefun.addYoutubeVideo("BUCKET_OF_FUEL", "https://youtu.be/_XmJ6hrv9uY");
//
//    Slimefun.addYoutubeVideo("GPS_TELEPORTER_PYLON", "https://youtu.be/ZnEhG8Kw6zU");
//    Slimefun.addYoutubeVideo("GPS_TELEPORTATION_MATRIX", "https://youtu.be/ZnEhG8Kw6zU");
//    Slimefun.addYoutubeVideo("GPS_TELEPORTER_PYLON", "https://youtu.be/ZnEhG8Kw6zU");
//
//    Slimefun.addYoutubeVideo("PROGRAMMABLE_ANDROID_WOODCUTTER", "https://youtu.be/AGLsWSMs6A0");
//    Slimefun.addYoutubeVideo("PROGRAMMABLE_ANDROID_BUTCHER", "https://youtu.be/G-re3qV-LJQ");
//    Slimefun.addYoutubeVideo("PROGRAMMABLE_ANDROID_2_BUTCHER", "https://youtu.be/G-re3qV-LJQ");
//
//    Slimefun.addYoutubeVideo("INFUSED_HOPPER", "https://youtu.be/_H2HGwkfBh8");
//
//    Slimefun.addYoutubeVideo("ELEVATOR_PLATE", "https://youtu.be/OdKMjo6vNIs");
//
//    Slimefun.addYoutubeVideo("ENERGY_REGULATOR", "https://youtu.be/QvSUfBYagXk");
//    Slimefun.addYoutubeVideo("COMBUSTION_REACTOR", "https://youtu.be/QvSUfBYagXk");
//    Slimefun.addYoutubeVideo("MULTIMETER", "https://youtu.be/QvSUfBYagXk");
//
//    Slimefun.addYoutubeVideo("FOOD_FABRICATOR", "https://youtu.be/qJdFfvTGOmI");
//    Slimefun.addYoutubeVideo("AUTO_BREEDER", "https://youtu.be/qJdFfvTGOmI");
//    Slimefun.addYoutubeVideo("ORGANIC_FOOD_MELON", "https://youtu.be/qJdFfvTGOmI");
//    Slimefun.addYoutubeVideo("ORGANIC_FOOD_WHEAT", "https://youtu.be/qJdFfvTGOmI");
//    Slimefun.addYoutubeVideo("ORGANIC_FOOD_APPLE", "https://youtu.be/qJdFfvTGOmI");
//    Slimefun.addYoutubeVideo("ORGANIC_FOOD_CARROT", "https://youtu.be/qJdFfvTGOmI");
//    Slimefun.addYoutubeVideo("ORGANIC_FOOD_SEEDS", "https://youtu.be/qJdFfvTGOmI");
//    Slimefun.addYoutubeVideo("ORGANIC_FOOD_BEETROOT", "https://youtu.be/qJdFfvTGOmI");
//    Slimefun.addYoutubeVideo("ORGANIC_FOOD_POTATO", "https://youtu.be/qJdFfvTGOmI");
//    Slimefun.addYoutubeVideo("ANIMAL_GROWTH_ACCELERATOR", "https://youtu.be/bV4wEaSxXFw");
//
//    Slimefun.addYoutubeVideo("FOOD_COMPOSTER", "https://youtu.be/LjzUlFKAHCI");
//    Slimefun.addYoutubeVideo("FERTILIZER_WHEAT", "https://youtu.be/LjzUlFKAHCI");
//    Slimefun.addYoutubeVideo("FERTILIZER_APPLE", "https://youtu.be/LjzUlFKAHCI");
//    Slimefun.addYoutubeVideo("FERTILIZER_POTATO", "https://youtu.be/LjzUlFKAHCI");
//    Slimefun.addYoutubeVideo("FERTILIZER_CARROT", "https://youtu.be/LjzUlFKAHCI");
//    Slimefun.addYoutubeVideo("FERTILIZER_SEEDS", "https://youtu.be/LjzUlFKAHCI");
//    Slimefun.addYoutubeVideo("FERTILIZER_BEETROOT", "https://youtu.be/LjzUlFKAHCI");
//    Slimefun.addYoutubeVideo("FERTILIZER_MELON", "https://youtu.be/LjzUlFKAHCI");
//    Slimefun.addYoutubeVideo("CROP_GROWTH_ACCELERATOR", "https://youtu.be/LjzUlFKAHCI");
//
//    Slimefun.addYoutubeVideo("XP_COLLECTOR", "https://youtu.be/fHtJDPeLMlg");
//
//    Slimefun.addYoutubeVideo("ELECTRIC_ORE_GRINDER", "https://youtu.be/A6OuK7sfnaI");
//    Slimefun.addYoutubeVideo("ELECTRIC_GOLD_PAN", "https://youtu.be/A6OuK7sfnaI");
//    Slimefun.addYoutubeVideo("ELECTRIC_DUST_WASHER", "https://youtu.be/A6OuK7sfnaI");
//    Slimefun.addYoutubeVideo("ELECTRIC_INGOT_FACTORY", "https://youtu.be/A6OuK7sfnaI");
//
//    Slimefun.addYoutubeVideo("AUTOMATED_CRAFTING_CHAMBER", "https://youtu.be/FZj7nu9sOYA");
//
//    Slimefun.addYoutubeVideo("CARGO_MANAGER", "https://youtu.be/Lt2aGw5lQPI");
//    Slimefun.addYoutubeVideo("CARGO_NODE_INPUT", "https://youtu.be/Lt2aGw5lQPI");
//    Slimefun.addYoutubeVideo("CARGO_NODE_OUTPUT", "https://youtu.be/Lt2aGw5lQPI");
//
//    Slimefun.addYoutubeVideo("GPS_CONTROL_PANEL", "https://youtu.be/kOopBkiRzjs");
//
//    Slimefun.addYoutubeVideo("GPS_TRANSMITTER", "https://youtu.be/kOopBkiRzjs");
//    Slimefun.addYoutubeVideo("GPS_TRANSMITTER_2", "https://youtu.be/kOopBkiRzjs");
//    Slimefun.addYoutubeVideo("GPS_TRANSMITTER_3", "https://youtu.be/kOopBkiRzjs");
//    Slimefun.addYoutubeVideo("GPS_TRANSMITTER_4", "https://youtu.be/kOopBkiRzjs");
//
//    Slimefun.addYoutubeVideo("SOLAR_GENERATOR", "https://youtu.be/kOopBkiRzjs");
//    Slimefun.addYoutubeVideo("SOLAR_GENERATOR_2", "https://youtu.be/kOopBkiRzjs");
//    Slimefun.addYoutubeVideo("SOLAR_GENERATOR_3", "https://youtu.be/kOopBkiRzjs");
//    Slimefun.addYoutubeVideo("SOLAR_GENERATOR_4", "https://youtu.be/kOopBkiRzjs");
  }

  private void cleanup() {
    if (!RESEARCHES_CONFIG.getFile().exists()) {
      Slimefun.getLogger().log(Level.WARNING, "###############################################");
      Slimefun.getLogger().log(Level.WARNING, "############## = -  INFO  - = #################");
      Slimefun.getLogger().log(Level.WARNING, "###############################################");
      Slimefun.getLogger().log(Level.WARNING, " ");
      Slimefun.getLogger().log(Level.WARNING, "Slimefun Reloaded Warning:");
      Slimefun.getLogger().log(Level.WARNING, " ");
      Slimefun.getLogger().log(Level.WARNING, "Slimefun Reloaded has detected that your Files are either");
      Slimefun.getLogger().log(Level.WARNING, "outdated or do not exist. We generated new Files");
      Slimefun.getLogger().log(Level.WARNING, "instead otherwise Slimefun Reloaded would not work. If you");
      Slimefun.getLogger().log(Level.WARNING, "have used Slimefun Reloaded before, your Settings are now");
      Slimefun.getLogger().log(Level.WARNING, "gone. But therefore Slimefun Reloaded works!");
      new File("plugins/SlimefunReloaded").delete();
      new File("plugins/SlimefunReloaded/data-storage").delete();
    }
    if (!DATABASE_FOLDER.exists()) {
      DATABASE_FOLDER.mkdirs();
    }
  }

  private void createFiles() {
    String[] storage = {"blocks", "stored-blocks", "stored-inventories", "stored-chunks", "universal-inventories", "waypoints", "block-backups"};
    String[] general = {"scripts", "generators", "error-reports"};
    for (String s : storage) {
      createDir("plugins/SlimefunReloaded/data-storage/" + s);
    }
    for (String s : general) {
      createDir("plugins/SlimefunReloaded/" + s);
    }
  }

  private void createDir(String string) {
    File file = new File(string);
    if (!file.exists()) {
      file.mkdirs();
    }
  }

  private void loadSettings() {
    printOutLoading = CONFIG.getBoolean("options.print-out-loading");
    researchesFreeInCreative = CONFIG.getBoolean("options.allow-free-creative-research");
    researchesTitles = CONFIG.getStringList("research-ranks");
    blocksInfoLoadingDelay = CONFIG.getInt("URID-info.delay");
    blocksAutoSaveDelay = CONFIG.getInt("options.auto-save-delay-in-minutes");
    guideShowVanillaRecipes = CONFIG.getBoolean("options.show-vanilla-recipes-in-guide");
    emeraldEnchantsLimit = CONFIG.getInt("options.emerald-enchantment-limit");
    legacyDustWasher = CONFIG.getBoolean("options.legacy-dust-washer");
    legacyOreWasher = CONFIG.getBoolean("options.legacy-ore-washer");
    legacyOreGrinder = CONFIG.getBoolean("options.legacy-ore-grinder");
    researchesEnabled = RESEARCHES_CONFIG.getBoolean("enable-researching");
    smelteryFireBreakChance = ITEMS_CONFIG.getInt("SMELTERY.chance.fireBreak");
  }

  private void setupConfig() {
    FileConfiguration config = getConfig();
    FileConfigurationOptions options = config.options();
    options.copyDefaults(true);
    saveConfig();
    CONFIG = new Config(this);
  }

  //TODO: GIVE THIS METHOD A BETTER NAME
  private void a() {
    File researches = new File("plugins/Slimefun/Researches.yml");
    if (researches.exists() && !RESEARCHES_CONFIG.getFile().exists()) {
      researches.renameTo(RESEARCHES_CONFIG.getFile());
    } else {
      if (!RESEARCHES_CONFIG.getFile().exists()) {
        RESEARCHES_CONFIG.createFile();
      }
    }
    File config = new File("plugins/Slimefun/config.yml");
    if (config.exists() && !CONFIG.getFile().exists()) {
      config.renameTo(CONFIG.getFile());
    }
    File items = new File("plugins/Slimefun/Items.yml");
    if (items.exists() && !ITEMS_CONFIG.getFile().exists()) {
      items.renameTo(ITEMS_CONFIG.getFile());
    } else {
      if (!ITEMS_CONFIG.getFile().exists()) {
        ITEMS_CONFIG.createFile();
      }
    }
    File playerDatabase = new File("data-storage/Slimefun/Players");
    if (playerDatabase.exists() && !DATABASE_FOLDER.exists()) {
      playerDatabase.renameTo(DATABASE_FOLDER);
    }
    File storedBlocks = new File("data-storage/Slimefun/stored-blocks");
    if (storedBlocks.exists() && !PATH_BLOCKS.exists()) {
      storedBlocks.renameTo(PATH_BLOCKS);
    }
    File storedChunks = new File("data-storage/Slimefun/stored-chunks");
    if (storedChunks.exists() && !PATH_CHUNKS.exists()) {
      storedChunks.renameTo(PATH_CHUNKS);
    }
    File storedInventories = new File("data-storage/Slimefun/stored-inventories");
    if (storedInventories.exists() && !STORED_INVENTORIES.exists()) {
      storedInventories.renameTo(STORED_INVENTORIES);
    }
    File universalInventories = new File("data-storage/Slimefun/universal-inventories");
    if (universalInventories.exists() && !UNIVERSAL_INVENTORIES.exists()) {
      universalInventories.renameTo(UNIVERSAL_INVENTORIES);
    }
    File whitelist = new File("plugins/Slimefun/whitelist.yml");
    if (whitelist.exists() && !WHITELIST_CONFIG.getFile().exists()) {
      whitelist.renameTo(WHITELIST_CONFIG.getFile());
    } else {
      if (!WHITELIST_CONFIG.getFile().exists()) {
        WHITELIST_CONFIG.createFile();
      }
    }
  }

  public Config getResearchesConfig() {
    return RESEARCHES_CONFIG;
  }

  public Config getItemsConfig() {
    return ITEMS_CONFIG;
  }

  public File getDatabaseFolder() {
    return DATABASE_FOLDER;
  }

  public Config getWhitelistConfig() {
    return WHITELIST_CONFIG;
  }

  public ComponentManager getComponentManager() {
    return COMPONENT_MANAGER;
  }

  public CategoryManager getCategoryManager() {
    return CATEGORY_MANAGER;
  }

  public ResearchManager getResearchManager() {
    return RESEARCH_MANAGER;
  }

  public boolean isPrintOutLoading() {
    return printOutLoading;
  }

  public boolean isResearchesEnabled() {
    return researchesEnabled;
  }

  public boolean isResearchesFreeInCreative() {
    return researchesFreeInCreative;
  }

  public List<String> getResearchesTitles() {
    return researchesTitles;
  }

  public int getBlocksAutoSaveDelay() {
    return blocksAutoSaveDelay;
  }

  public boolean isGuideShowVanillaRecipes() {
    return guideShowVanillaRecipes;
  }

  public int getEmeraldEnchantsLimit() {
    return emeraldEnchantsLimit;
  }

  public boolean isLegacyDustWasher() {
    return legacyDustWasher;
  }

  public boolean isLegacyOreGrinder() {
    return legacyOreGrinder;
  }

  public boolean isLegacyOreWasher() {
    return legacyOreWasher;
  }

  public int getSmelteryFireBreakChance() {
    return smelteryFireBreakChance;
  }

  public int getBlocksInfoLoadingDelay() {
    return blocksInfoLoadingDelay;
  }

  public Map<String, BlockStorage> getWorlds() {
    return worlds;
  }

  public Set<String> getTickers() {
    return tickers;
  }

  public Map<String, Set<Location>> getTickingChunks() {
    return tickingChunks;
  }

  public Set<String> getLoadedTickers() {
    return loadedTickers;
  }

  public Map<String, BlockInfoConfig> getMapChunks() {
    return mapChunks;
  }

  @Deprecated
  public Map<String, UniversalBlockMenu> getUniversalInventories() {
    return universalInventories;
  }

  public String getVersion() {
    return version;
  }

  public Map<UUID, PlayerProfile> getProfiles() {
    return profiles;
  }

  public Config getCfg() {
    return CONFIG;
  }

  public RecipeSnapshot getRecipeSnapshot() {
    return recipeSnapshot;
  }

  public ProtectionManager getProtectionManager() {
    return protectionManager;
  }

  public SlimefunReloadedHooks getSlimefunReloadedHooks() {
    return slimefunReloadedHooks;
  }

  public RecipeSnapshot getMinecraftRecipes() {
    return recipeSnapshot;
  }

  public Set<Location> getAltarinuse() {
    return altarinuse;
  }

  public Set<AltarRecipe> getAltarRecipes() {
    return altarRecipes;
  }

  public CustomItemDataService getItemDataService() {
    return itemDataService;
  }

  public CustomTextureService getItemTextureService() {
    return textureService;
  }

  @Deprecated
  public Map<String, BlockMenuPreset> getBlockMenuPresets() {
    return blockMenuPresets;
  }

  public Object getItemValue(String id, String key) {
    return ITEMS_CONFIG.getValue(id + "." + key);
  }

  public void setItemVariable(String id, String key, Object value) {
    ITEMS_CONFIG.setDefaultValue(id + '.' + key, value);
  }

  public Set<UUID> getTeleporterUsers() {
    return teleporterUsers;
  }

  public Map<String, SlimefunReloadedComponent> getItemIds() {
    return itemIDs;
  }

  public Set<UUID> getElevatorUsers() {
    return elevatorUsers;
  }

  public GPSNetwork getGPSNetwork() {
    return gps;
  }

  public boolean hasUnlocked(Player player, ItemStack item, boolean sendMessage) {
    SlimefunReloadedComponent component = COMPONENT_MANAGER.getComponentByItem(item);
    ComponentState state = component.getState();
    if (component == null) {
      if (state != ComponentState.ENABLED) {
        if (sendMessage && state != ComponentState.VANILLA) {
          I18n.tl(player, "messages.disabled-item");
        }
        return false;
      } else {
        return true;
      }
    } else if (isEnabled(player, item, sendMessage) && hasPermission(player, component, sendMessage)) {
      if (component.getResearch() == null) {
        return true;
      } else if (PlayerProfile.get(player).hasUnlocked(component.getResearch())) {
        return true;
      } else {
        if (sendMessage && !(component instanceof VanillaItem)) {
          I18n.tl(player, "messages.not-researched");
        }
      }
    }
    return false;
  }

  public boolean hasUnlocked(Player player, SlimefunReloadedComponent component, boolean sendMessage) {
    if (isEnabled(player, component, sendMessage) && hasPermission(player, component, sendMessage)) {
      if (component.getResearch() == null) {
        return true;
      } else if (PlayerProfile.get(player).hasUnlocked(component.getResearch())) {
        return true;
      } else {
        if (sendMessage && !(component instanceof VanillaItem)) {
          I18n.tl(player, "messages.not-researched");
          return false;
        }
      }
    }
    return false;
  }

  public boolean hasPermission(Player player, SlimefunReloadedComponent component, boolean sendMessage) {
    if (component == null) {
      return true;
    } else if (component.getPermission().equalsIgnoreCase("")) {
      return true;
    } else if (player.hasPermission(component.getPermission())) {
      return true;
    } else {
      if (sendMessage) {
        I18n.tl(player, "messages.no-permission");
      }
      return false;
    }
  }

  public boolean isEnabled(Player player, ItemStack item, boolean sendMessage) {
    SlimefunReloadedComponent component = COMPONENT_MANAGER.getComponentByItem(item);
    if (component == null) {
      return !component.isDisabled();
    } else {
      return isEnabled(player, component, sendMessage);
    }
  }

  public boolean isEnabled(Player player, SlimefunReloadedComponent component, boolean sendMessage) {
    if (component.isDisabled()) {
      if (sendMessage) {
        I18n.tl(player, "messages.disabled-in-world");
      }
      return false;
    }
    String worldName = player.getWorld().getName();
    if (WHITELIST_CONFIG.contains(worldName + ".enabled")) {
      if (WHITELIST_CONFIG.getBoolean(worldName + ".enabled")) {
        if (!WHITELIST_CONFIG.contains(worldName + ".enabled-items." + component.getID())) {
          WHITELIST_CONFIG.setDefaultValue(worldName + ".enabled-items." + component.getID(), true);
          WHITELIST_CONFIG.save();
        }
        if (WHITELIST_CONFIG.getBoolean(worldName + ".enabled-items." + component.getID())) {
          return true;
        } else {
          if (sendMessage) {
            I18n.tl(player, "messages.disabled-in-world");
          }
          return false;
        }
      } else {
        if (sendMessage) {
          I18n.tl(player, "messages.disabled-in-world");
        }
        return false;
      }
    }
    return true;
  }

  private void setupItemSettings() {
    for (World world : Bukkit.getWorlds()) {
      WHITELIST_CONFIG.setDefaultValue(world.getName() + ".enabled-items.SLIMEFUN_GUIDE", true);
    }
    WHITELIST_CONFIG.save();
    setItemVariable("ORE_CRUSHER", "double-ores", true);

    for (Enchantment e : Enchantment.values()) {
      for (int i = 1; i <= e.getMaxLevel(); i++) {
        setItemVariable("MAGICIAN_TALISMAN", "allow-enchantments." + e.getKey().getKey() + ".level." + i, true);
      }
    }
  }

  public void runSync(Runnable r) {
    Bukkit.getScheduler().runTask(this, r);
  }

  public void runSync(Runnable r, long delay) {
    Bukkit.getScheduler().runTaskLater(this, r, delay);
  }

}
