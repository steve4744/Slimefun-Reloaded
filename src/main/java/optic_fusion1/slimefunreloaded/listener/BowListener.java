package optic_fusion1.slimefunreloaded.listener;

import java.util.Vector;
import optic_fusion1.slimefunreloaded.SlimefunReloaded;
import optic_fusion1.slimefunreloaded.item.SlimefunReloadedItem;
import optic_fusion1.slimefunreloaded.item.handler.BowShootHandler;
import optic_fusion1.slimefunreloaded.item.handler.ItemHandler;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;

public class BowListener implements Listener {

  public BowListener(SlimefunReloaded plugin) {
    plugin.getServer().getPluginManager().registerEvents(this, plugin);
  }

  @EventHandler
  public void onBowUse(EntityShootBowEvent e) {
    if (e.getEntity() instanceof Player && e.getProjectile() instanceof Arrow && SlimefunReloadedItem.getByItem(e.getBow()) != null) {
      SlimefunReloaded.getUtilities().arrows.put(e.getProjectile().getUniqueId(), e.getBow());
    }
  }

  @EventHandler
  public void onArrowHit(final ProjectileHitEvent e) {
    Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunReloaded.instance, () -> {
      if (!e.getEntity().isValid()) {
        return;
      }
      SlimefunReloaded.getUtilities().arrows.remove(e.getEntity().getUniqueId());
      if (e.getEntity() instanceof Arrow) {
        handleGrapplingHook((Arrow) e.getEntity());
      }
    }, 4L);
  }

  private void handleGrapplingHook(Arrow arrow) {
    if (arrow != null && arrow.getShooter() instanceof Player && SlimefunReloaded.getUtilities().jumpState.containsKey(((Player) arrow.getShooter()).getUniqueId())) {
      final Player p = (Player) arrow.getShooter();

      if (p.getGameMode() != GameMode.CREATIVE && (boolean) SlimefunReloaded.getUtilities().jumpState.get(p.getUniqueId())) {
        arrow.getWorld().dropItem(arrow.getLocation(), SlimefunReloadedItems.GRAPPLING_HOOK);
      }

      if (p.getLocation().distance(arrow.getLocation()) < 3.0D) {
        if (arrow.getLocation().getY() > p.getLocation().getY()) {
          p.setVelocity(new Vector(0.0D, 0.25D, 0.0D));
        } else {
          p.setVelocity(arrow.getLocation().toVector().subtract(p.getLocation().toVector()));
        }

        for (Entity n : SlimefunReloaded.getUtilities().remove.get(p.getUniqueId())) {
          if (n.isValid()) {
            n.remove();
          }
        }

        Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunReloaded.instance, () -> {
          SlimefunReloaded.getUtilities().jumpState.remove(p.getUniqueId());
          SlimefunReloaded.getUtilities().remove.remove(p.getUniqueId());
        }, 20L);
      } else {
        Location l = p.getLocation();
        l.setY(l.getY() + 0.5D);
        p.teleport(l);

        double g = -0.08D;
        double d = arrow.getLocation().distance(l);
        double t = d;
        double vX = (1.0D + 0.08000000000000001D * t) * (arrow.getLocation().getX() - l.getX()) / t;
        double vY = (1.0D + 0.04D * t) * (arrow.getLocation().getY() - l.getY()) / t - 0.5D * g * t;
        double vZ = (1.0D + 0.08000000000000001D * t) * (arrow.getLocation().getZ() - l.getZ()) / t;

        Vector v = p.getVelocity();

        v.setX(vX);
        v.setY(vY);
        v.setZ(vZ);

        p.setVelocity(v);

        for (Entity n : SlimefunReloaded.getUtilities().remove.get(p.getUniqueId())) {
          if (n.isValid()) {
            n.remove();
          }
        }

        Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunReloaded.instance, () -> {
          SlimefunReloaded.getUtilities().jumpState.remove(p.getUniqueId());
          SlimefunReloaded.getUtilities().remove.remove(p.getUniqueId());
        }, 20L);
      }
    }
  }

  @EventHandler
  public void onArrowSuccessfulHit(EntityDamageByEntityEvent e) {
    if (e.getDamager() instanceof Arrow) {
      if (SlimefunReloaded.getUtilities().arrows.containsKey(e.getDamager().getUniqueId()) && e.getEntity() instanceof LivingEntity) {
        for (ItemHandler handler : SlimefunReloadedItem.getHandlers("BowShootHandler")) {
          if (((BowShootHandler) handler).onHit(e, (LivingEntity) e.getEntity())) {
            break;
          }
        }

        SlimefunReloaded.getUtilities().arrows.remove(e.getDamager().getUniqueId());
      }

      handleGrapplingHook((Arrow) e.getDamager());
    }
  }

}
