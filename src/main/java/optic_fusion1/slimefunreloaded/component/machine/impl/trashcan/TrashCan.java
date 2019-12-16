package optic_fusion1.slimefunreloaded.component.machine.impl.trashcan;

import optic_fusion1.slimefunreloaded.Slimefun;
import optic_fusion1.slimefunreloaded.SlimefunReloaded;
import optic_fusion1.slimefunreloaded.component.RecipeType;
import optic_fusion1.slimefunreloaded.component.machine.SlimefunReloadedMachine;
import optic_fusion1.slimefunreloaded.util.SlimefunReloadedItemStack;
import optic_fusion1.slimefunreloaded.util.SlimefunReloadedItems;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

public class TrashCan extends SlimefunReloadedMachine<TrashCanState> {

  public TrashCan(SlimefunReloaded plugin) {
    super(new NamespacedKey(plugin, "TrashCan"), Slimefun.getCategoryManager().getCategoryByName("Cargo"), (SlimefunReloadedItemStack) SlimefunReloadedItems.TRASH_CAN, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{null, SlimefunReloadedItems.PORTABLE_DUSTBIN, null, SlimefunReloadedItems.LEAD_INGOT, SlimefunReloadedItems.CARGO_MOTOR, SlimefunReloadedItems.LEAD_INGOT, SlimefunReloadedItems.ALUMINUM_INGOT, SlimefunReloadedItems.LEAD_INGOT, SlimefunReloadedItems.ALUMINUM_INGOT});
  }

  @Override
  public TrashCanState createState(Block block) {
    return new TrashCanState(this, block);
  }

}
