package optic_fusion1.slimefunreloaded.component.machine.impl.trashcan;

import optic_fusion1.slimefunreloaded.machine.MachineContainer;
import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryType;

public class TrashCanContainer extends MachineContainer {

  private final TrashCanState state;

  public TrashCanContainer(TrashCanState state) {
    super(() -> Bukkit.createInventory(null, InventoryType.CHEST));
    this.state = state;
  }

  public TrashCanState getState() {
    return state;
  }

  @Override
  public int[] getInputSlots() {
    return EMPTY_SLOT_ARRAY;
  }

  @Override
  public int[] getOutputSlots() {
    return EMPTY_SLOT_ARRAY;
  }

}
