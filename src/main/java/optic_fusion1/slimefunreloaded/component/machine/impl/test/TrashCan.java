package optic_fusion1.slimefunreloaded.component.machine.impl.test;

import optic_fusion1.slimefunreloaded.Slimefun;
import optic_fusion1.slimefunreloaded.SlimefunReloaded;
import optic_fusion1.slimefunreloaded.component.machine.SlimefunReloadedMachine;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;

public class TrashCan extends SlimefunReloadedMachine<TrashCanState> {

  public TrashCan(SlimefunReloaded plugin) {
    super(new NamespacedKey(plugin, "TrashCan"), Slimefun.getCategoryManager().getCategoryByName("Cargo"),
     null, null, null);
  }

  /*
  This is what it should be, however certain things aren't properly implemented yet
  super(new NamespacedKey(plugin, "TrashCan"), Slimefun.getCategoryManager().getCategoryByName("Cargo"),
     (SlimefunItemStack) SlimefunItems.TRASH_CAN, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {null, SlimefunItems.PORTABLE_DUSTBIN, null, SlimefunItems.LEAD_INGOT, SlimefunItems.CARGO_MOTOR, SlimefunItems.LEAD_INGOT, SlimefunItems.ALUMINUM_INGOT, SlimefunItems.LEAD_INGOT, SlimefunItems.ALUMINUM_INGOT});
     */
  @Override
  public TrashCanState createState(Block block) {
    return new TrashCanState(this, block);
  }

}
