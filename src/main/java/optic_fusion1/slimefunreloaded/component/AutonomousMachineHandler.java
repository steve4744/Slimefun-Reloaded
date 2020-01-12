package optic_fusion1.slimefunreloaded.component;

import org.bukkit.block.Block;
import org.bukkit.block.Dispenser;
import org.bukkit.event.block.BlockDispenseEvent;

@FunctionalInterface
public interface AutonomousMachineHandler{

  boolean onBlockDispense(BlockDispenseEvent event, Block block, Dispenser dispenser, Block relativeBlock, Block chest, SlimefunReloadedComponent machine);

}
