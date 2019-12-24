package optic_fusion1.slimefunreloaded.listener;

import java.util.logging.Level;
import optic_fusion1.slimefunreloaded.Slimefun;
import optic_fusion1.slimefunreloaded.util.BlockStorage;
import optic_fusion1.slimefunreloaded.util.Config;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.WorldLoadEvent;
import org.bukkit.event.world.WorldUnloadEvent;

public class WorldListener implements Listener {

  private static final Config WHITELIST_CONFIG = Slimefun.getWhitelistConfig();

  @EventHandler
  public void on(WorldLoadEvent event) {
    BlockStorage.getForcedStorage(event.getWorld());
    String worldName = event.getWorld().getName();
    WHITELIST_CONFIG.setDefaultValue(worldName + ".enabled", true);
    WHITELIST_CONFIG.setDefaultValue(worldName + ".enabled-items.SLIMEFUN_GUIDE", true);
    WHITELIST_CONFIG.save();
  }

  @EventHandler
  public void on(WorldUnloadEvent event) {
    World world = event.getWorld();
    BlockStorage storage = BlockStorage.getStorage(world);
    if (storage != null) {
      storage.save(true);
    } else {
      Slimefun.getLogger().log(Level.SEVERE, "Could not save Slimefun Reloaded Blocks for World \"{0}\"", world.getName());
    }
  }

}
