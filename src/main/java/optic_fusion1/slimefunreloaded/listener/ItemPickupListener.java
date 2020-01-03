package optic_fusion1.slimefunreloaded.listener;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.inventory.InventoryPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemPickupListener implements Listener {

  @EventHandler
  public void onEntitPickup(EntityPickupItemEvent event) {
    if (event.getItem().hasMetadata("no_pickup")) {
      event.setCancelled(true);
      return;
    }
    ItemStack itemStack = event.getItem().getItemStack();
    if (itemStack.hasItemMeta()) {
      ItemMeta itemMeta = itemStack.getItemMeta();
      if (itemMeta.hasDisplayName() && itemMeta.getDisplayName().startsWith(ChatColor.translateAlternateColorCodes('&', "&5&dALTAR &3Probe - &e"))) {
        event.setCancelled(true);
        event.getItem().remove();
      }
    }
  }

  @EventHandler
  public void onInventoryPickup(InventoryPickupItemEvent event) {
    if (event.getItem().hasMetadata("no_pickup")) {
      event.setCancelled(true);
      return;
    }
    ItemStack itemStack = event.getItem().getItemStack();
    if (itemStack.hasItemMeta()) {
      ItemMeta itemMeta = itemStack.getItemMeta();
      if (itemMeta.hasDisplayName() && itemMeta.getDisplayName().startsWith(ChatColor.translateAlternateColorCodes('&', "&5&dALTAR &3Probe - &e"))) {
        event.setCancelled(true);
        event.getItem().remove();
      }
    }
  }

}
