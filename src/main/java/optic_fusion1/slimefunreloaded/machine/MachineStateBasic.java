package optic_fusion1.slimefunreloaded.machine;

import org.bukkit.block.Block;

import optic_fusion1.slimefunreloaded.component.machine.SlimefunReloadedMachine;

public class MachineStateBasic implements MachineState {

  private final SlimefunReloadedMachine<?> machine;
  private final Block block;

  public MachineStateBasic(SlimefunReloadedMachine<?> machine, Block block) {
    this.machine = machine;
    this.block = block;
  }

  @Override
  public final SlimefunReloadedMachine<?> getMachine() {
    return machine;
  }

  @Override
  public final Block getBlock() {
    return block;
  }

}
