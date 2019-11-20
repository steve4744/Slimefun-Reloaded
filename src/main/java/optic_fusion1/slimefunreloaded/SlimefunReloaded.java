package optic_fusion1.slimefunreloaded;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import optic_fusion1.slimefunreloaded.category.CategoryManager;
import optic_fusion1.slimefunreloaded.category.CategoryRegistery;
import optic_fusion1.slimefunreloaded.metrics.MetricsLite;
import optic_fusion1.slimefunreloaded.research.ResearchManager;
import optic_fusion1.slimefunreloaded.research.ResearchRegistery;
import optic_fusion1.slimefunreloaded.updater.Updater;
import static optic_fusion1.slimefunreloaded.updater.Updater.UpdateResult.UPDATE_AVAILABLE;
import optic_fusion1.slimefunreloaded.util.Config;
import optic_fusion1.slimefunreloaded.util.I18n;
import optic_fusion1.slimefunreloaded.util.ReflectionUtils;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class SlimefunReloaded extends JavaPlugin {

  private FileConfiguration config;
  private Logger logger;
  private final File DATA_FOLDER = new File("plugins/SlimefunReloaded");
  private final Config RESEARCHES_CONFIG = new Config(new File(DATA_FOLDER, "Researches.yml"));
  private final Config ITEMS_CONFIG = new Config(new File(DATA_FOLDER, "Items.yml"));
  private final File DATABASE_FOLDER = new File(DATA_FOLDER, "Players");
  private final Config WHITELIST_CONFIG = new Config(new File(DATA_FOLDER, "whitelist.yml"));
  private final CategoryManager CATEGORY_MANAGER = new CategoryManager();
  private final ResearchManager RESEARCH_MANAGER = new ResearchManager();

  @Override
  public void onEnable() {
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
    logger = getLogger();
    new I18n();
    new MetricsLite(this);
    File configFile = new File(getDataFolder(), "config.yml");
    if (!configFile.exists()) {
      saveDefaultConfig();
    }
    if (!DATABASE_FOLDER.exists()) {
      DATABASE_FOLDER.mkdirs();
    }
    config = getConfig();
    handleUpdate();
    new CategoryRegistery().registerCategories();
    new ResearchRegistery().registerResearches();
  }

  @Override
  public void onDisable() {
  }

  private void handleUpdate() {
    //TODO: Replace with a valid resource id, this requires the resource to be uploaded to spigot
    Updater updater = new Updater(this, -1, false);
    if (updater.getResult() == UPDATE_AVAILABLE) {
      if (config.getBoolean("options.auto-update")) {
        updater.downloadUpdate();
      } else {
        logger.info("************************");
        logger.info("This build of Slimefun Reloaded outdated");
        logger.log(Level.INFO, "{0}Current Version:  New Version: {1}",
         new Object[]{updater.getOldVersion(), updater.getVersion()});
        //TODO: replace with valid link, this requires the resource to be uploaded to spigot
        logger.info("You can get the latest build here: <insert link here>");
        logger.info("************************");
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

  public CategoryManager getCategoryManager() {
    return CATEGORY_MANAGER;
  }

  public ResearchManager getResearchManager() {
    return RESEARCH_MANAGER;
  }

}
