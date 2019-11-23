package optic_fusion1.slimefunreloaded.listener;

import optic_fusion1.slimefunreloaded.SlimefunReloaded;
import optic_fusion1.slimefunreloaded.item.SlimefunReloadedItem;
import optic_fusion1.slimefunreloaded.item.handler.AutonomousMachineHandler;
import optic_fusion1.slimefunreloaded.item.handler.ItemHandler;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Dispenser;
import org.bukkit.block.data.Directional;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDispenseEvent;

public class AutonomousToolsListener implements Listener {

  public AutonomousToolsListener(SlimefunReloaded plugin) {
    plugin.getServer().getPluginManager().registerEvents(this, plugin);
  }

  @EventHandler
  public void onBlockDispensing(final BlockDispenseEvent e) {
    Block dispenser = e.getBlock();
    if (dispenser.getType() == Material.DISPENSER) {
      final Dispenser d = (Dispenser) dispenser.getState();

      BlockFace face = ((Directional) dispenser.getBlockData()).getFacing();

      Block block = dispenser.getRelative(face);
      Block chest = dispenser.getRelative(face.getOppositeFace());
      SlimefunReloadedItem machine = BlockStorage.check(dispenser);

      if (machine != null) {
        for (ItemHandler handler : SlimefunReloadedItem.getHandlers("AutonomousMachineHandler")) {
          if (((AutonomousMachineHandler) handler).onBlockDispense(e, dispenser, d, block, chest, machine)) {
            break;
          }
        }
      }
    }
  }

}
