package optic_fusion1.slimefunreloaded.listener;

import optic_fusion1.slimefunreloaded.SlimefunReloaded;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.inventory.InventoryPickupItemEvent;

public class ItemPickupListener implements Listener {

  public ItemPickupListener(SlimefunReloaded plugin) {
    plugin.getServer().getPluginManager().registerEvents(this, plugin);
  }

  @EventHandler
  public void onPickup(EntityPickupItemEvent e) {
    if (e.getItem().hasMetadata("no_pickup")) {
      e.setCancelled(true);
    } else if (!e.getItem().hasMetadata("no_pickup") && e.getItem().getItemStack().hasItemMeta() && e.getItem().getItemStack().getItemMeta().hasDisplayName() && e.getItem().getItemStack().getItemMeta().getDisplayName().startsWith(ChatColor.translateAlternateColorCodes('&', "&5&dALTAR &3Probe - &e"))) {
      e.setCancelled(true);
      e.getItem().remove();
    }
  }

  @EventHandler
  public void onMinecartPickup(InventoryPickupItemEvent e) {
    if (e.getItem().hasMetadata("no_pickup")) {
      e.setCancelled(true);
    } else if (!e.getItem().hasMetadata("no_pickup") && e.getItem().getItemStack().hasItemMeta() && e.getItem().getItemStack().getItemMeta().hasDisplayName() && e.getItem().getItemStack().getItemMeta().getDisplayName().startsWith(ChatColor.translateAlternateColorCodes('&', "&5&dALTAR &3Probe - &e"))) {
      e.setCancelled(true);
      e.getItem().remove();
    }
  }
}
