package optic_fusion1.slimefunreloaded.item.handler;

import java.util.List;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public interface BlockBreakHandler extends ItemHandler {

  boolean onBlockBreak(BlockBreakEvent e, ItemStack item, int fortune, List<ItemStack> drops);

  default String toCodename() {
    return "BlockBreakHandler";
  }
}
