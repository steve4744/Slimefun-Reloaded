package optic_fusion1.slimefunreloaded.item.handler;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;

public interface ItemConsumptionHandler extends ItemHandler {

  boolean onConsume(PlayerItemConsumeEvent e, Player p, ItemStack item);

  default String toCodename() {
    return "ItemConsumptionHandler";
  }

}
