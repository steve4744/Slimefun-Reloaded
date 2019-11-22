package optic_fusion1.slimefunreloaded;

import java.io.File;
import optic_fusion1.slimefunreloaded.category.CategoryManager;
import optic_fusion1.slimefunreloaded.item.ItemManager;
import optic_fusion1.slimefunreloaded.research.ResearchManager;
import optic_fusion1.slimefunreloaded.util.Config;

public final class Slimefun {

  private Slimefun() {
  }

  private static SlimefunReloaded plugin;

  public static void setSlimefunReloaded(SlimefunReloaded plugin) {
    if (Slimefun.plugin != null) {
      throw new UnsupportedOperationException("Cannot redefine singleton SlimefunReloaded");
    }
    Slimefun.plugin = plugin;
  }

  public static SlimefunReloaded getSlimefunReloaded() {
    return plugin;
  }

  public static Config getResearchesConfig() {
    return plugin.getResearchesConfig();
  }

  public static Config getItemsConfig() {
    return plugin.getItemsConfig();
  }

  public static File getDatabaseFolder() {
    return plugin.getDatabaseFolder();
  }

  public static Config getWhitelistConfig() {
    return plugin.getWhitelistConfig();
  }

  public static CategoryManager getCategoryManager() {
    return plugin.getCategoryManager();
  }

  public static ResearchManager getResearchManager() {
    return plugin.getResearchManager();
  }

  public static ItemManager getItemManager(){
    return plugin.getItemManager();
  }
  
}
