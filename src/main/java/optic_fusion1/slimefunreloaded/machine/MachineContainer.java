package optic_fusion1.slimefunreloaded.machine;

import java.util.function.Supplier;

import com.google.common.base.Preconditions;

import org.apache.commons.lang.Validate;
import org.bukkit.inventory.Inventory;

public class MachineContainer {

  protected static final int[] EMPTY_SLOT_ARRAY = { };

  private final Inventory inventory;

  public MachineContainer(Supplier<Inventory> inventoryCreator) {
    Preconditions.checkArgument(inventoryCreator != null, "Inventory creator must not be null");

    this.inventory = inventoryCreator.get();

    Validate.isTrue(inventory != null, "Cannot create null inventory");
  }

  public Inventory getInventory() {
    return inventory;
  }

  public int[] getInputSlots() {
    return EMPTY_SLOT_ARRAY;
  }

  public int[] getOutputSlots() {
    return EMPTY_SLOT_ARRAY;
  }

}
