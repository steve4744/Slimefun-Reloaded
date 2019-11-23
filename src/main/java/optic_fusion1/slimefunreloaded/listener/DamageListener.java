package optic_fusion1.slimefunreloaded.listener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import optic_fusion1.slimefunreloaded.Slimefun;
import optic_fusion1.slimefunreloaded.SlimefunReloaded;
import optic_fusion1.slimefunreloaded.item.SlimefunReloadedItem;
import optic_fusion1.slimefunreloaded.item.handler.EntityKillHandler;
import optic_fusion1.slimefunreloaded.item.handler.ItemHandler;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

public class DamageListener implements Listener {

  private SimpleDateFormat format = new SimpleDateFormat("(MMM d, yyyy @ hh:mm)");

  public DamageListener(SlimefunReloaded plugin) {
    plugin.getServer().getPluginManager().registerEvents(this, plugin);
  }

  @EventHandler
  public void onDamage(EntityDeathEvent e) {
    if (e.getEntity() instanceof Player) {
      Player p = (Player) e.getEntity();
      if (p.getInventory().containsAtLeast(SlimefunReloadedItems.GPS_EMERGENCY_TRANSMITTER, 1)) {
        Slimefun.getGPSNetwork().addWaypoint(p, "&4Deathpoint &7" + format.format(new Date()), p.getLocation().getBlock().getLocation());
      }

      for (int slot = 0; slot < p.getInventory().getSize(); slot++) {
        ItemStack item = p.getInventory().getItem(slot);

        if (SlimefunManager.isItemSoulbound(item)) {
          Soul.storeItem(p.getUniqueId(), slot, item);
        }
      }

      Iterator<ItemStack> drops = e.getDrops().iterator();
      while (drops.hasNext()) {
        ItemStack item = drops.next();
        if (SlimefunManager.isItemSoulbound(item)) {
          drops.remove();
        }
      }

    }

    if (e.getEntity().getKiller() instanceof Player) {
      Player p = e.getEntity().getKiller();
      ItemStack item = p.getInventory().getItemInMainHand();

      if (SlimefunReloaded.getUtilities().drops.containsKey(e.getEntity().getType())) {
        for (ItemStack drop : SlimefunReloaded.getUtilities().drops.get(e.getEntity().getType())) {
          if (Slimefun.hasUnlocked(p, drop, true)) {
            e.getDrops().add(drop);
          }
        }
      }

      if (item != null && item.getType() != null && item.getType() != Material.AIR && Slimefun.hasUnlocked(p, item, true)) {
        for (ItemHandler handler : SlimefunReloadedItem.getHandlers("EntityKillHandler")) {
          if (((EntityKillHandler) handler).onKill(e, e.getEntity(), p, item)) {
            return;
          }
        }
      }
    }
  }

  @EventHandler
  public void onArrowHit(EntityDamageEvent e) {
    if (e.getEntity() instanceof Player && e.getCause() == DamageCause.FALL && SlimefunReloaded.getUtilities().damage.contains(e.getEntity().getUniqueId())) {
      e.setCancelled(true);
      SlimefunReloaded.getUtilities().damage.remove(e.getEntity().getUniqueId());
    }
  }

  @EventHandler
  public void onRespawn(PlayerRespawnEvent e) {
    Soul.retrieveItems(e.getPlayer());
  }
}
