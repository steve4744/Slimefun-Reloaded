package optic_fusion1.slimefunreloaded;

import java.io.File;
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

  public Config getResearchesConfig() {
    return plugin.getResearchesConfig();
  }

  public Config getItemsConfig() {
    return plugin.getItemsConfig();
  }

  public File getDatabaseFolder() {
    return plugin.getDatabaseFolder();
  }

  public Config getWhitelistConfig() {
    return plugin.getWhitelistConfig();
  }

}
