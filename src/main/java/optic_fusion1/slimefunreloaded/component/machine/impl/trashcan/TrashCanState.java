package optic_fusion1.slimefunreloaded.component.machine.impl.trashcan;

import optic_fusion1.slimefunreloaded.component.machine.SlimefunReloadedMachine;
import optic_fusion1.slimefunreloaded.machine.MachineContainer;
import optic_fusion1.slimefunreloaded.machine.MachineStateContainer;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class TrashCanState extends MachineStateContainer {

  public TrashCanState(SlimefunReloadedMachine<?> machine, Block block) {
    super(machine, block);
  }

  @Override
  public MachineContainer createContainer(Player player) {
    return new TrashCanContainer(this);
  }

}
