package examples;

import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

import optic_fusion1.slimefunreloaded.machine.BasicMachineState;

// (parent interface of "MachineState")
public final class MyCustomMachineState extends BasicMachineState {

  private int someValue;
  private ItemStack containsThisItem;

  public MyCustomMachineState(MyCustomMachine machine, Block block) {
    super(machine, block);
  }

  public void setSomeValue(int someValue) {
    this.someValue = someValue;
  }

  public int getSomeValue() {
    return someValue;
  }

  public void setContainsThisItem(ItemStack containsThisItem) {
    this.containsThisItem = containsThisItem;
  }

  public ItemStack getContainsThisItem() {
    return containsThisItem;
  }

  public boolean hasItem() {
    return containsThisItem != null;
  }

}
