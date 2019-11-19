package optic_fusion1.slimefunreloaded;

import optic_fusion1.slimefunreloaded.metrics.MetricsLite;
import org.bukkit.plugin.java.JavaPlugin;

public class SlimefunReloaded extends JavaPlugin {

  @Override
  public void onEnable() {
    Slimefun.setSlimefunReloaded(this);
    new MetricsLite(this);
  }

  @Override
  public void onDisable() {
  }

}
