package optic_fusion1.slimefunreloaded.listener;

import optic_fusion1.slimefunreloaded.component.AutonomousMachineHandler;
import optic_fusion1.slimefunreloaded.component.SlimefunReloadedComponent;
import optic_fusion1.slimefunreloaded.util.BlockStorage;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Dispenser;
import org.bukkit.block.data.Directional;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDispenseEvent;

public class AutonomousToolsListener implements Listener {

  @EventHandler
  public void onBlockDispensing(BlockDispenseEvent event) {
    Block block = event.getBlock();
    if (block.getType() == Material.DISPENSER) {
      Dispenser dispenser = (Dispenser) block.getState();
      BlockFace blockFace = ((Directional) block.getBlockData()).getFacing();
      Block relativeBlock = block.getRelative(blockFace);
      Block chest = block.getRelative(blockFace.getOppositeFace());
      SlimefunReloadedComponent component = BlockStorage.check(block);
      if (component != null && component instanceof AutonomousMachineHandler) {
        ((AutonomousMachineHandler) component).onBlockDispense(event, block, dispenser, relativeBlock, chest, component);
      }
    }
  }
}
