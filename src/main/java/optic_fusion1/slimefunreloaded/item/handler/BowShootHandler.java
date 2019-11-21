package optic_fusion1.slimefunreloaded.item.handler;

import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public interface BowShootHandler extends ItemHandler {

  boolean onHit(EntityDamageByEntityEvent e, LivingEntity n);

  default String toCodename() {
    return "BowShootHandler";
  }
}
