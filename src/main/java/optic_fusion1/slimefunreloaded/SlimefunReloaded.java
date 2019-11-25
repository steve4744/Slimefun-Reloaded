package optic_fusion1.slimefunreloaded;

import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.FileConfigurationOptions;
import org.bukkit.plugin.java.JavaPlugin;

import optic_fusion1.slimefunreloaded.category.CategoryManager;
import optic_fusion1.slimefunreloaded.component.ComponentManager;
import optic_fusion1.slimefunreloaded.component.ComponentRegistry;
import optic_fusion1.slimefunreloaded.hooks.SlimefunReloadedHooks;
import optic_fusion1.slimefunreloaded.metrics.MetricsLite;
import optic_fusion1.slimefunreloaded.protection.ProtectionManager;
import optic_fusion1.slimefunreloaded.recipe.RecipeSnapshot;
import optic_fusion1.slimefunreloaded.research.ResearchManager;
import optic_fusion1.slimefunreloaded.research.ResearchRegistry;
import optic_fusion1.slimefunreloaded.updater.Updater;
import optic_fusion1.slimefunreloaded.util.Config;
import optic_fusion1.slimefunreloaded.util.I18n;
import optic_fusion1.slimefunreloaded.util.ReflectionUtils;

public class SlimefunReloaded extends JavaPlugin {

  private RecipeSnapshot recipeSnapshot;

//  private final CustomItemDataService itemDataService = new CustomItemDataService(this, "slimefun_item");
//  private final CustomTextureService textureService = new CustomTextureService(this);
//    private TickerTask ticker;
  private final File DATA_FOLDER = new File("plugins/SlimefunReloaded");
  private final File DATABASE_FOLDER = new File(DATA_FOLDER, "data-storage/Players");
  private Config CONFIG;
  private final Config RESEARCHES_CONFIG = new Config(new File(DATA_FOLDER, "Researches.yml"));
  private final Config ITEMS_CONFIG = new Config(new File(DATA_FOLDER, "Items.yml"));
  private final Config WHITELIST_CONFIG = new Config(new File(DATA_FOLDER, "whitelist.yml"));
  private final ComponentManager COMPONENT_MANAGER = new ComponentManager();
  private final CategoryManager CATEGORY_MANAGER = new CategoryManager();
  private final ResearchManager RESEARCH_MANAGER = new ResearchManager();

//  private GPSNetwork gps;
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

  @Override
  public void onEnable() {
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
//    gps = new GPSNetwork();
    if (CONFIG.getBoolean("options.auto-update")) {
      Updater updater = new Updater(this, 0, false);
      updater.downloadUpdate();
    }
    createFiles();
//    MiscSetup.loadDescriptions();
    ResearchRegistry.registerResearches();
    ComponentRegistry.registerComponents();
  }

  /*
			MiscSetup.setupMisc();
			WikiSetup.addWikiPages(this);
			textureService.setup(utilities.allItems);

			getLogger().log(Level.INFO, "Loading World Generators...");

			// Generating Oil as an OreGenResource (its a cool API)
			OreGenSystem.registerResource(new OilResource());
			OreGenSystem.registerResource(new NetherIceResource());
			OreGenSystem.registerResource(new UraniumResource());

			// Setting up GitHub Connectors...

			GitHubSetup.setup();

			// All Slimefun Listeners
			new ArmorListener(this);
			new ItemListener(this);
			new BlockListener(this);
			new GearListener(this);
			new AutonomousToolsListener(this);
			new DamageListener(this);
			new BowListener(this);
			new ToolListener(this);
			new FurnaceListener(this);
			new TeleporterListener(this);
			new AndroidKillingListener(this);
			new NetworkListener(this);
			new ItemPickupListener(this);

			// Toggleable Listeners for performance
			if (config.getBoolean("items.talismans")) new TalismanListener(this);
			if (config.getBoolean("items.backpacks")) new BackpackListener(this);
			if (config.getBoolean("items.coolers")) new CoolerListener(this);

			// Handle Slimefun Guide being given on Join
			if (config.getBoolean("options.give-guide-on-first-join")) new GuideOnJoinListener(this);

			// Load/Unload Worlds in Slimefun
			new WorldListener(this);

			// Clear the Slimefun Guide History upon Player Leaving
			new PlayerQuitListener(this);

			// Initiating various Stuff and all Items with a slightly delay (0ms after the Server finished loading)
			getServer().getScheduler().scheduleSyncDelayedTask(this, () -> {
				recipeSnapshot = new RecipeSnapshot(this);
				protections = new ProtectionManager(getServer());
				MiscSetup.loadItems(settings);

				for (World world: Bukkit.getWorlds()) {
					new BlockStorage(world);
				}

				if (SlimefunReloadedItem.getByID("ANCIENT_ALTAR") != null) new AncientAltarListener((SlimefunReloaded) instance);
			}, 0);
			
			SlimefunCommand command = new SlimefunCommand(this);

			getCommand("slimefun").setExecutor(command);
			getCommand("slimefun").setTabCompleter(new SlimefunTabCompleter(command));

			// Armor Update Task
			if (config.getBoolean("options.enable-armor-effects")) {
				getServer().getScheduler().runTaskTimerAsynchronously(this, new ArmorTask(), 0L, config.getInt("options.armor-update-interval") * 20L);
			}

			ticker = new TickerTask();

			getServer().getScheduler().runTaskTimer(this, new PlayerAutoSaver(), 2000L, settings.blocksAutoSaveDelay * 60L * 20L);

			// Starting all ASYNC Tasks
			getServer().getScheduler().runTaskTimerAsynchronously(this, new BlockAutoSaver(), 2000L, settings.blocksAutoSaveDelay * 60L * 20L);
			getServer().getScheduler().runTaskTimerAsynchronously(this, () -> {
				try {
					ticker.run();
				}
				catch(Throwable x) {
					getLogger().log(Level.SEVERE, "An Exception was caught while ticking the Block Tickers Task for Slimefun v" + Slimefun.getVersion(), x);
					ticker.abortTick();
				}
			}, 100L, config.getInt("URID.custom-ticker-delay"));

			getServer().getScheduler().runTaskTimerAsynchronously(this, () -> utilities.connectors.forEach(GitHubConnector::pullFile), 80L, 60 * 60 * 20L);

			// Hooray!
			getLogger().log(Level.INFO, "Finished!");
			hooks = new SlimefunHooks(this);
			
			utilities.oreWasherOutputs = new ItemStack[] {SlimefunReloadedItems.IRON_DUST, SlimefunReloadedItems.GOLD_DUST, SlimefunReloadedItems.ALUMINUM_DUST, SlimefunReloadedItems.COPPER_DUST, SlimefunReloadedItems.ZINC_DUST, SlimefunReloadedItems.TIN_DUST, SlimefunReloadedItems.LEAD_DUST, SlimefunReloadedItems.SILVER_DUST, SlimefunReloadedItems.MAGNESIUM_DUST};

			// Do not show /sf elevator command in our Log, it could get quite spammy
			CSCoreLib.getLib().filterLog("([A-Za-z0-9_]{3,16}) issued server command: /sf elevator (.{0,})");
		}
		else {
			getCommand("slimefun").setExecutor((sender, cmd, label, args) -> {
				sender.sendMessage("You have forgotten to install CS-CoreLib! Slimefun is disabled.");
				sender.sendMessage("https://dev.bukkit.org/projects/cs-corelib");
				return true;
			});
		}
	}

	@Override
	public void onDisable() {
		// CS-CoreLib wasn't loaded, just disabling
		if (instance == null) return;
		
		Bukkit.getScheduler().cancelTasks(this);

		if (ticker != null) {
			// Finishes all started movements/removals of block data
			ticker.halt();
			ticker.run();
		}
		
		PlayerProfile.iterator().forEachRemaining(profile -> {
			if (profile.isDirty()) profile.save();
		});
		
		for (World world: Bukkit.getWorlds()) {
			try {
				BlockStorage storage = BlockStorage.getStorage(world);
				
				if (storage != null) {
					storage.save(true);
				}
				else {
					getLogger().log(Level.SEVERE, "Could not save Slimefun Blocks for World \"" + world.getName() + "\"");
				}
			} catch (Exception x) {
				getLogger().log(Level.SEVERE, "An Error occured while saving Slimefun-Blocks in World '" + world.getName() + "' for Slimefun " + Slimefun.getVersion());
			}
		}
		
		for (UniversalBlockMenu menu: utilities.universalInventories.values()) {
			menu.save();
		}
		
		SlimefunBackup.start();

		// Prevent Memory Leaks
		AContainer.processing = null;
		AContainer.progress = null;
		
		AGenerator.processing = null;
		AGenerator.progress = null;
		
		AReactor.processing = null;
		AReactor.progress = null;

		instance = null;

		for (Player p: Bukkit.getOnlinePlayers()) {
			p.closeInventory();
		}
	}

	private void createDir(String path) {
		File file = new File(path);
		if (!file.exists()) file.mkdirs();
	}

	public static Config getCfg() {
		return instance.config;
	}

	public static Config getResearchCfg() {
		return instance.researches;
	}

	public static Config getItemCfg() {
		return instance.items;
	}

	public static Config getWhitelist() {
		return instance.whitelist;
	}

	@Deprecated
	public static int randomize(int max) {
		if (max < 1) return 0;
		return CSCoreLib.randomizer().nextInt(max);
	}

	@Deprecated
	public static boolean chance(int max, int percentage) {
		if (max < 1) return false;
		return CSCoreLib.randomizer().nextInt(max) <= percentage;
	}

	public GPSNetwork getGPS() {
		return gps;
	}

	public static SlimefunHooks getHooks() {
		return instance.hooks;
	}
	
	public static Utilities getUtilities() {
		return instance.utilities;
	}
	
	public static Settings getSettings() {
		return instance.settings;
	}
	
	public static TickerTask getTicker() {
		return instance.ticker;
	}
	
	public static boolean isActive() {
		return instance != null;
	}

	public static ProtectionManager getProtectionManager() {
		return instance.protections;
	}

	public static SlimefunLocalization getLocal() {
		return instance.local;
	}
	
	public static RecipeSnapshot getMinecraftRecipes() {
		return instance.recipeSnapshot;
	}
	
	public static CustomItemDataService getItemDataService() {
		return instance.itemDataService;
	}
	
	public static CustomTextureService getItemTextureService() {
		return instance.textureService;
	}

}
   */
//  private FileConfiguration config;
//  private Logger logger;
//  private final File DATA_FOLDER = new File("plugins/SlimefunReloaded");
//  private final Config RESEARCHES_CONFIG = new Config(new File(DATA_FOLDER, "Researches.yml"));
//  private final Config ITEMS_CONFIG = new Config(new File(DATA_FOLDER, "Items.yml"));
//  private final File DATABASE_FOLDER = new File(DATA_FOLDER, "Players");
//  private final Config WHITELIST_CONFIG = new Config(new File(DATA_FOLDER, "whitelist.yml"));
//  private final CategoryManager CATEGORY_MANAGER = new CategoryManager();
//  private final ResearchManager RESEARCH_MANAGER = new ResearchManager();
//
//  @Override
//  public void onEnable() {
//    String version = ReflectionUtils.getVersion();
//    if (!version.startsWith("v1_14")) {
//      logger.severe("Slimefun Reloaded was not installed correctly!");
//      logger.severe("You are using the wrong version of Minecraft!");
//      logger.log(Level.SEVERE, "You are using Minecraft {0}", version);
//      logger.log(Level.SEVERE, "but Slimefun Reloaded v{0} requires you to be using", getDescription().getVersion());
//      logger.severe("Minecraft 1.14");
//      logger.severe("Please use an older version of Slimefun or Slimefun Reloaded and disable auto-updating");
//      logger.severe("or consider updating your server software");
//      Bukkit.getPluginManager().disablePlugin(this);
//      return;
//    }
//    Slimefun.setSlimefunReloaded(this);
//    logger = getLogger();
//    new I18n();
//    new MetricsLite(this);
//    File configFile = new File(getDataFolder(), "config.yml");
//    if (!configFile.exists()) {
//      saveDefaultConfig();
//    }
//    if (!DATABASE_FOLDER.exists()) {
//      DATABASE_FOLDER.mkdirs();
//    }
//    config = getConfig();
//    handleUpdate();
//    new CategoryRegistery().registerCategories();
//    new ResearchRegistery().registerResearches();
//  }
//
//  @Override
//  public void onDisable() {
//  }
//
//  private void handleUpdate() {
//    //TODO: Replace with a valid resource id, this requires the resource to be uploaded to spigot
//    Updater updater = new Updater(this, -1, false);
//    if (updater.getResult() == UPDATE_AVAILABLE) {
//      if (config.getBoolean("options.auto-update")) {
//        updater.downloadUpdate();
//      } else {
//        logger.info("************************");
//        logger.info("This build of Slimefun Reloaded outdated");
//        logger.log(Level.INFO, "{0}Current Version:  New Version: {1}",
//         new Object[]{updater.getOldVersion(), updater.getVersion()});
//        //TODO: replace with valid link, this requires the resource to be uploaded to spigot
//        logger.info("You can get the latest build here: <insert link here>");
//        logger.info("************************");
//      }
//    }
//  }
//
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
    File database = new File("data-storage/Slimefun/Players");
    if (database.exists() && !DATABASE_FOLDER.exists()) {
      database.renameTo(DATABASE_FOLDER);
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

}
