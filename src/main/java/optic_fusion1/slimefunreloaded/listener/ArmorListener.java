package optic_fusion1.slimefunreloaded.listener;

import optic_fusion1.slimefunreloaded.Slimefun;
import optic_fusion1.slimefunreloaded.component.ComponentManager;
import optic_fusion1.slimefunreloaded.component.SlimefunReloadedComponent;
import optic_fusion1.slimefunreloaded.protection.ProtectableAction;
import optic_fusion1.slimefunreloaded.util.SlimefunReloadedItems;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class ArmorListener implements Listener {

  private ComponentManager componentManager = Slimefun.getComponentManager();

  @EventHandler(priority = EventPriority.MONITOR)
  public void onDamage(EntityDamageEvent event) {
    if (event.isCancelled()) {
      return;
    }
    if (event.getEntity() instanceof Player) {
      Player player = (Player) event.getEntity();
      SlimefunReloadedComponent component = componentManager.getComponentByItem(player.getInventory().getBoots());
      if (component != null) {
        if (component.getID().equals("ENDER_BOOTS")
         && Slimefun.hasUnlocked(player, component, true)
         && event instanceof EntityDamageByEntityEvent
         && ((EntityDamageByEntityEvent) event).getDamager() instanceof EnderPearl) {
          event.setCancelled(true);
        } else if (component.getID().equals("SLIME_BOOTS")
         && Slimefun.hasUnlocked(player, component, true)
         && event.getCause() == DamageCause.FALL) {
          event.setCancelled(true);
        } else if (component.getID().equals("BOOTS_OF_THE_STOMPER")
         && Slimefun.hasUnlocked(player, component, true)
         && event.getCause() == DamageCause.FALL) {
          event.setCancelled(true);
          player.getWorld().playSound(player.getLocation(), Sound.ENTITY_ZOMBIE_BREAK_WOODEN_DOOR, 1F, 2F);
          player.setVelocity(new Vector(0.0, 0.7, 0.0));
          for (Entity entity : player.getNearbyEntities(4, 4, 4)) {
            if (entity instanceof LivingEntity & !entity.getUniqueId().equals(player.getUniqueId())) {
              entity.setVelocity(entity.getLocation().toVector().subtract(player.getLocation().toVector())
               .normalize().multiply(1.4));
              if (player.getWorld().getPVP() && Slimefun.getProtectionManager().hasPermission(player, entity.getLocation(), ProtectableAction.PVP)) {
                EntityDamageByEntityEvent damgeByEntityEvent = new EntityDamageByEntityEvent(player, entity,
                 DamageCause.ENTITY_ATTACK, event.getDamage() / 2);
                Bukkit.getPluginManager().callEvent(damgeByEntityEvent);
                if (!damgeByEntityEvent.isCancelled()) {
                  ((LivingEntity) entity).damage(damgeByEntityEvent.getDamage() / 2);
                }
              }
            }
          }

          for (BlockFace face : BlockFace.values()) {
            Block b = player.getLocation().getBlock().getRelative(BlockFace.DOWN).getRelative(face);
            player.getWorld().playEffect(b.getLocation(), Effect.STEP_SOUND, b.getType());
          }
        } else if (component.getID().equals("SLIME_STEEL_BOOTS")
         && Slimefun.hasUnlocked(player, component, true)
         && event.getCause() == DamageCause.FALL) {
          event.setCancelled(true);
        }
      }
    }
  }

  @EventHandler
  public void onTrample(PlayerInteractEvent event) {
    if (event.getAction() == Action.PHYSICAL) {
      Block clickedBlock = event.getClickedBlock();
      if (clickedBlock != null && clickedBlock.getType() == Material.FARMLAND) {
        ItemStack itemStack = event.getPlayer().getInventory().getBoots();
        if (itemStack != null && itemStack.isSimilar(SlimefunReloadedItems.FARMER_SHOES)) {
          event.setCancelled(true);
        }
      }
    }
  }
}
