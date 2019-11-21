package optic_fusion1.slimefunreloaded.item.handler;

import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

public interface BlockPlaceHandler extends ItemHandler {

  boolean onBlockPlace(BlockPlaceEvent e, ItemStack item);

  default String toCodename() {
    return "BlockPlaceHandler";
  }
}

