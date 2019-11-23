package optic_fusion1.slimefunreloaded.listener;

import java.util.logging.Level;
import optic_fusion1.slimefunreloaded.Slimefun;
import optic_fusion1.slimefunreloaded.SlimefunReloaded;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.WorldLoadEvent;
import org.bukkit.event.world.WorldUnloadEvent;

public class WorldListener implements Listener {

  public WorldListener(SlimefunReloaded plugin) {
    plugin.getServer().getPluginManager().registerEvents(this, plugin);
  }

  @EventHandler
  public void onWorldLoad(WorldLoadEvent e) {
    BlockStorage.getForcedStorage(e.getWorld());

    Slimefun.getWhitelistConfig().setDefaultValue(e.getWorld().getName() + ".enabled", true);
    Slimefun.getWhitelistConfig().setDefaultValue(e.getWorld().getName() + ".enabled-items.SLIMEFUN_GUIDE", true);
    Slimefun.getWhitelistConfig().save();
  }

  @EventHandler
  public void onWorldUnload(WorldUnloadEvent e) {
    BlockStorage storage = BlockStorage.getStorage(e.getWorld());
    if (storage != null) {
      storage.save(true);
    } else {
      Slimefun.getSlimefunReloaded().getLogger().log(Level.SEVERE, "Could not save Slimefun Blocks for World \"" + e.getWorld().getName() + "\"");
    }
  }

}
