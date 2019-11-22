package optic_fusion1.slimefunreloaded.item.handler;

import optic_fusion1.slimefunreloaded.event.ItemUseEvent;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public interface ItemInteractionHandler extends ItemHandler {

  boolean onRightClick(ItemUseEvent e, Player p, ItemStack item);

  default String toCodename() {
    return "ItemInteractionHandler";
  }

}
