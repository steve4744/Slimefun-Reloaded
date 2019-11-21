package optic_fusion1.slimefunreloaded.hooks;

import java.util.Iterator;
import me.minebuilders.clearlag.events.EntityRemoveEvent;
import optic_fusion1.slimefunreloaded.Slimefun;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class ClearLagHook implements Listener {

  public ClearLagHook() {
    Bukkit.getPluginManager().registerEvents(this, Slimefun.getSlimefunReloaded());
  }

  @EventHandler
  public void onEntityRemove(EntityRemoveEvent e) {
    Iterator<Entity> iterator = e.getEntityList().iterator();
    while (iterator.hasNext()) {
      Entity n = iterator.next();
      if (n instanceof Item && n.hasMetadata("no_pickup")) {
        iterator.remove();
      }
    }
  }

}
