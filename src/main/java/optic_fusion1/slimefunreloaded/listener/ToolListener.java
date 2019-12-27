package optic_fusion1.slimefunreloaded.listener;

import java.util.ArrayList;
import java.util.List;
import optic_fusion1.slimefunreloaded.component.SlimefunReloadedComponent;
import optic_fusion1.slimefunreloaded.component.item.SlimefunReloadedBlock;
import optic_fusion1.slimefunreloaded.component.item.SlimefunReloadedItem;
import optic_fusion1.slimefunreloaded.util.BlockStorage;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class ToolListener implements Listener {

  @EventHandler
  public void on(BlockBreakEvent event) {
    List<ItemStack> drops = new ArrayList<>();
    ItemStack item = event.getPlayer().getInventory().getItemInMainHand();
    int fortune = 1;

    SlimefunReloadedComponent component = BlockStorage.check(event.getBlock());
    if (component instanceof SlimefunReloadedBlock) {
      SlimefunReloadedBlock componentBlock = (SlimefunReloadedBlock) component;
      componentBlock.onBlockBreak(event, item, fortune, drops);
    }
  }

}
