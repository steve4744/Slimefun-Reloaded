package optic_fusion1.slimefunreloaded.hooks;

import java.util.logging.Level;
import optic_fusion1.slimefunreloaded.Slimefun;
import optic_fusion1.slimefunreloaded.SlimefunReloaded;

public final class SlimefunReloadedHooks {

  private SlimefunReloaded plugin;

  private boolean exoticGarden = false;
  private boolean emeraldEnchants = false;
  private boolean coreProtect = false;
  private boolean clearLag = false;
  private boolean worldEdit = false;
  private boolean placeHolderAPI = false;

  public SlimefunReloadedHooks(SlimefunReloaded plugin) {
    this.plugin = plugin;

    if (isPluginInstalled("PlaceholderAPI")) {
      placeHolderAPI = true;
      new PlaceholderAPIHook().register();
    }

    /*
		 *  These Items are not marked as soft-dependencies and 
		 *  therefore need to be loaded after the Server has finished 
		 *  loading all plugins
     */
    plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, () -> {
      if (isPluginInstalled("ClearLag")) {
        clearLag = true;
        new ClearLagHook();
      }

      exoticGarden = isPluginInstalled("ExoticGarden");
      emeraldEnchants = isPluginInstalled("EmeraldEnchants");

      // WorldEdit Hook to clear Slimefun Data upon //set 0 //cut or any other equivalent
      if (isPluginInstalled("WorldEdit")) {
        try {
          Class.forName("com.sk89q.worldedit.extent.Extent");
          worldEdit = true;
          new WorldEditHook();
        } catch (Exception x) {
          plugin.getLogger().log(Level.WARNING, "Failed to hook into WorldEdit!");
          plugin.getLogger().log(Level.WARNING, "Maybe consider updating WorldEdit or Slimefun?");
        }
      }
    });
  }

  private boolean isPluginInstalled(String hook) {
    if (plugin.getServer().getPluginManager().isPluginEnabled(hook)) {
      plugin.getLogger().log(Level.INFO, "Hooked into Plugin: " + hook);
      return true;
    } else {
      return false;
    }
  }

  public boolean isExoticGardenInstalled() {
    return exoticGarden;
  }

  public boolean isEmeraldEnchantsInstalled() {
    return emeraldEnchants;
  }

  public boolean isCoreProtectInstalled() {
    return coreProtect;
  }

  public boolean isClearLagInstalled() {
    return clearLag;
  }

  public boolean isWorldEditInstalled() {
    return worldEdit;
  }

  public boolean isPlaceholderAPIInstalled() {
    return placeHolderAPI;
  }

}
