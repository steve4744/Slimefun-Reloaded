package optic_fusion1.slimefunreloaded.machine;

import org.bukkit.block.Block;

import optic_fusion1.slimefunreloaded.component.machine.SlimefunReloadedMachine;

public interface MachineState {

  public SlimefunReloadedMachine<? extends MachineState> getMachine();

  public Block getBlock();

}
