package optic_fusion1.slimefunreloaded.item.handler;

import optic_fusion1.slimefunreloaded.item.SlimefunReloadedItem;
import org.bukkit.block.Block;
import org.bukkit.block.Dispenser;
import org.bukkit.event.block.BlockDispenseEvent;

public interface AutonomousMachineHandler extends ItemHandler {

  boolean onBlockDispense(BlockDispenseEvent e, Block dispenser, Dispenser d, Block block, Block chest, SlimefunReloadedItem machine);

  default String toCodename() {
    return "AutonomousMachineHandler";
  }
}
