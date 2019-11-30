package optic_fusion1.slimefunreloaded;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import optic_fusion1.slimefunreloaded.category.CategoryManager;
import optic_fusion1.slimefunreloaded.component.ComponentManager;
import optic_fusion1.slimefunreloaded.research.ResearchManager;
import optic_fusion1.slimefunreloaded.util.BlockStorage;
import optic_fusion1.slimefunreloaded.util.Config;
import org.bukkit.Location;

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

  public static ComponentManager getComponentManager() {
    return plugin.getComponentManager();
  }

  public static CategoryManager getCategoryManager() {
    return plugin.getCategoryManager();
  }

  public static ResearchManager getResearchManager() {
    return plugin.getResearchManager();
  }

  public static boolean isPrintOutLoading() {
    return plugin.isPrintOutLoading();
  }

  public static boolean isResearchesEnabled() {
    return plugin.isResearchesEnabled();
  }

  public static boolean isResearchesFreeInCreative() {
    return plugin.isResearchesFreeInCreative();
  }

  public static List<String> getResearchesTitles() {
    return plugin.getResearchesTitles();
  }

  public static int getBlocksAutoSaveDelay() {
    return plugin.getBlocksAutoSaveDelay();
  }

  public static boolean isGuideShowVanillaRecipes() {
    return plugin.isGuideShowVanillaRecipes();
  }

  public static int getEmeraldEnchantsLimit() {
    return plugin.getEmeraldEnchantsLimit();
  }

  public static boolean isLegacyDustWasher() {
    return plugin.isLegacyDustWasher();
  }

  public static boolean isLegacyOreGrinder() {
    return plugin.isLegacyOreGrinder();
  }

  public static boolean isLegacyOreWasher() {
    return plugin.isLegacyOreWasher();
  }

  public static int getSmelteryFireBreakChance() {
    return plugin.getSmelteryFireBreakChance();
  }

  public static Logger getLogger() {
    return plugin.getLogger();
  }

  public static int getBlocksInfoLoadingDelay() {
    return plugin.getBlocksInfoLoadingDelay();
  }

  public static Map<String, BlockStorage> getWorlds() {
    return plugin.getWorlds();
  }

  public static Set<String> getTickers() {
    return plugin.getTickers();
  }

  public static Map<String, Set<Location>> getTickingChunks() {
    return plugin.getTickingChunks();
  }

  public static Set<String> getLoadedTickers() {
    return plugin.getLoadedTickers();
  }

  public static Map<String, BlockInfoConfig> getMapChunks() {
    return plugin.getMapChunks();
  }
  
   public static Map<String, UniversalBlockMenu> getUniversalInventories() {
    return plugin.getUniversalInventories();
  }

}
