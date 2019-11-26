package optic_fusion1.slimefunreloaded.machine;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import optic_fusion1.slimefunreloaded.component.machine.SlimefunReloadedMachine;

public abstract class MachineStateContainer extends MachineStateBasic {

  public MachineStateContainer(SlimefunReloadedMachine<?> machine, Block block) {
    super(machine, block);
  }

  public abstract MachineContainer createContainer(Player player);

}
