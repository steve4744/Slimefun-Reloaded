package optic_fusion1.slimefunreloaded;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import optic_fusion1.slimefunreloaded.ancient_altar.AltarRecipe;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.FileConfigurationOptions;
import org.bukkit.plugin.java.JavaPlugin;
import optic_fusion1.slimefunreloaded.gps.GPSNetwork;
import optic_fusion1.slimefunreloaded.category.CategoryManager;
import optic_fusion1.slimefunreloaded.component.ComponentManager;
import optic_fusion1.slimefunreloaded.component.ComponentRegistry;
import optic_fusion1.slimefunreloaded.hooks.SlimefunReloadedHooks;
import optic_fusion1.slimefunreloaded.inventory.BlockMenuPreset;
import optic_fusion1.slimefunreloaded.inventory.UniversalBlockMenu;
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
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;


//TODO: Clean this class up
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
  private final ComponentManager COMPONENT_MANAGER = new ComponentManager();
  private final CategoryManager CATEGORY_MANAGER = new CategoryManager();
  private final ResearchManager RESEARCH_MANAGER = new ResearchManager();

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

  //Required for the GrapplingHook
  public final Map<UUID, Boolean> jumpState = new HashMap<>();
  //Required for the GrapplingHook
  public final Map<UUID, ItemStack> arrows = new HashMap<>();
  //Required for the GrapplingHook
  public final Set<UUID> damage = new HashSet<>();
  //Required for the GrapplingHook
  public final Map<UUID, Entity[]> remove = new HashMap<>();
  //Required for the SeismicAxe
  public final List<UUID> blocks = new ArrayList<>();

  public final Set<Location> altarinuse = new HashSet<>();
  public final Set<AltarRecipe> altarRecipes = new HashSet<>();
  public final Map<String, BlockMenuPreset> blockMenuPresets = new HashMap<>();
  public final Set<UUID> teleporterUsers = new HashSet<>();
  public final Set<UUID> elevatorUsers = new HashSet<>();

  @Override
  public void onEnable() {
    version = getDescription().getVersion();
    logger = getLogger();
    String version = ReflectionUtils.getVersion();
    if (!version.startsWith("v1_14")) {
      logger.severe("Slimefun Reloaded was not installed correctly!");
      logger.severe("You are using the wrong version of Minecraft!");
      logger.log(Level.SEVERE, "You are using Minecraft {0}", version);
      logger.log(Level.SEVERE, "but Slimefun Reloaded v{0} requires you to be using", getDescription().getVersion());
      logger.severe("Minecraft 1.14");
      logger.severe("Please use an older version of Slimefun or Slimefun Reloaded and disable auto-updating");
      logger.severe("or consider updating your server software");
      Bukkit.getPluginManager().disablePlugin(this);
      return;
    }
    Slimefun.setSlimefunReloaded(this);
    new I18n();
    new MetricsLite(this);
    if (!DATABASE_FOLDER.exists()) {
      DATABASE_FOLDER.mkdirs();
    }
    a();
    setupConfig();
    loadSettings();
    gps = new GPSNetwork();
    if (CONFIG.getBoolean("options.auto-update")) {
      Updater updater = new Updater(this, 0, false);
      updater.downloadUpdate();
    }
    createFiles();
//    MiscSetup.loadDescriptions();
    ResearchRegistry.registerResearches();
    ComponentRegistry.registerComponents();
  }

  @Override
  public void onDisable() {
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
    }
    File config = new File("plugins/Slimefun/config.yml");
    if (config.exists() && !CONFIG.getFile().exists()) {
      config.renameTo(CONFIG.getFile());
    }
    File items = new File("plugins/Slimefun/Items.yml");
    if (items.exists() && !ITEMS_CONFIG.getFile().exists()) {
      items.renameTo(ITEMS_CONFIG.getFile());
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

  //Required for the GrapplingHook
  public Map<UUID, Boolean> getJumpState() {
    return jumpState;
  }

  //Required for the GrapplingHook
  public Map<UUID, ItemStack> getArrows() {
    return arrows;
  }

  //Required for the GrapplingHook
  public Set<UUID> getDamage() {
    return damage;
  }

  //Required for the GrapplingHook
  public Map<UUID, Entity[]> getRemove() {
    return remove;
  }

  public RecipeSnapshot getMinecraftRecipes() {
    return recipeSnapshot;
  }

  public List<UUID> getBlocks() {
    return blocks;
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
  
  public Set<UUID> getTeleporterUsers(){
    return teleporterUsers;
  }

}
