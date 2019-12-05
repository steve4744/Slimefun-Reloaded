package optic_fusion1.slimefunreloaded;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Logger;
import optic_fusion1.slimefunreloaded.ancient_altar.AltarRecipe;

import optic_fusion1.slimefunreloaded.category.CategoryManager;
import optic_fusion1.slimefunreloaded.component.ComponentManager;
import optic_fusion1.slimefunreloaded.hooks.SlimefunReloadedHooks;
import optic_fusion1.slimefunreloaded.inventory.BlockMenuPreset;
import optic_fusion1.slimefunreloaded.inventory.UniversalBlockMenu;
import optic_fusion1.slimefunreloaded.protection.ProtectionManager;
import optic_fusion1.slimefunreloaded.recipe.RecipeSnapshot;
import optic_fusion1.slimefunreloaded.research.ResearchManager;
import optic_fusion1.slimefunreloaded.util.BlockInfoConfig;
import optic_fusion1.slimefunreloaded.util.BlockStorage;
import optic_fusion1.slimefunreloaded.util.Config;
import optic_fusion1.slimefunreloaded.util.CustomItemDataService;
import optic_fusion1.slimefunreloaded.util.CustomTextureService;
import optic_fusion1.slimefunreloaded.util.PlayerProfile;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

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

  @Deprecated
  public static Map<String, UniversalBlockMenu> getUniversalInventories() {
    return plugin.getUniversalInventories();
  }

  public static String getVersion() {
    return plugin.getVersion();
  }

  public static Map<UUID, PlayerProfile> getProfiles() {
    return plugin.getProfiles();
  }

  public static Config getCfg() {
    return plugin.getCfg();
  }

  public static RecipeSnapshot getRecipeSnapshot() {
    return plugin.getRecipeSnapshot();
  }

  public static ProtectionManager getProtectionManager() {
    return plugin.getProtectionManager();
  }

  public static SlimefunReloadedHooks getSlimefunReloadedHooks() {
    return plugin.getSlimefunReloadedHooks();
  }

  //Required for the GrapplingHook
  public static Map<UUID, Boolean> getJumpState() {
    return plugin.getJumpState();
  }

  //Required for the GrapplingHook
  public static Map<UUID, ItemStack> getArrows() {
    return plugin.getArrows();
  }

  //Required for the GrapplingHook
  public static Set<UUID> getDamage() {
    return plugin.getDamage();
  }

  //Required for the GrapplingHook
  public static Map<UUID, Entity[]> getRemove() {
    return plugin.getRemove();
  }

  public static RecipeSnapshot getMinecraftRecipes() {
    return plugin.getMinecraftRecipes();
  }

  public static List<UUID> getBlocks() {
    return plugin.getBlocks();
  }

  public static Set<Location> getAltarinuse() {
    return plugin.getAltarinuse();
  }

  public static Set<AltarRecipe> getAltarRecipes() {
    return plugin.getAltarRecipes();
  }

  public static CustomItemDataService getItemDataService() {
    return plugin.getItemDataService();
  }

  public static CustomTextureService getItemTextureService() {
    return plugin.getItemTextureService();
  }

  @Deprecated
  public static Map<String, BlockMenuPreset> getBlockMenuPresets() {
    return plugin.getBlockMenuPresets();
  }

  public static Object getItemValue(String id, String key) {
    return plugin.getItemValue(id, key);
  }

  public static Set<UUID> getTeleporterUsers() {
    return plugin.getTeleporterUsers();
  }

}
