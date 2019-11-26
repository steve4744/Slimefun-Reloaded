package optic_fusion1.slimefunreloaded.component.machine.impl.test;

import optic_fusion1.slimefunreloaded.Slimefun;
import optic_fusion1.slimefunreloaded.SlimefunReloaded;
import optic_fusion1.slimefunreloaded.component.machine.SlimefunReloadedMachine;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;

public class TrashCan extends SlimefunReloadedMachine<TrashCanState> {

  public TrashCan(SlimefunReloaded plugin) {
    super(new NamespacedKey(plugin, "TrashCan"), Slimefun.getCategoryManager().getCategoryByName("Machines"), null);
  }

  @Override
  public TrashCanState createState(Block block) {
    return new TrashCanState(this, block);
  }

}
