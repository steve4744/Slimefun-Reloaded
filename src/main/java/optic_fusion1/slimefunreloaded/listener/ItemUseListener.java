package optic_fusion1.slimefunreloaded.listener;

import optic_fusion1.slimefunreloaded.event.ItemUseEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class ItemUseListener implements Listener {

  @EventHandler
  public void onRightClick(PlayerInteractEvent e) throws Exception {
    if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
      ItemUseEvent event = new ItemUseEvent(e, e.getAction() == Action.RIGHT_CLICK_BLOCK ? e.getClickedBlock() : null);
      Bukkit.getPluginManager().callEvent(event);
      if (!e.isCancelled()) {
        e.setCancelled(event.isCancelled());
      }
    }
  }

}
