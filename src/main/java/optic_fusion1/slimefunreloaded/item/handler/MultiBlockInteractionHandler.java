package optic_fusion1.slimefunreloaded.item.handler;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public interface MultiBlockInteractionHandler extends ItemHandler {

  boolean onInteract(Player p, MultiBlock mb, Block b);

  default String toCodename() {
    return "MultiBlockInteractionHandler";
  }
}
