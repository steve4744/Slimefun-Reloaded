package optic_fusion1.slimefunreloaded.machine;

import java.util.function.Supplier;

import com.google.common.base.Preconditions;
import optic_fusion1.slimefunreloaded.menu.BaseMenu;

import org.apache.commons.lang.Validate;

public class MachineContainer {

  protected static final int[] EMPTY_SLOT_ARRAY = {};

  private final BaseMenu menu;

  public MachineContainer(Supplier<BaseMenu> menuCreator) {
    Preconditions.checkArgument(menuCreator != null, "BaseMenu must not be null");
    this.menu = menuCreator.get();
    Validate.isTrue(menu != null, "Cannot create null baseMenu");
  }

  public BaseMenu getMenu() {
    return menu;
  }

  public int[] getInputSlots() {
    return EMPTY_SLOT_ARRAY;
  }

  public int[] getOutputSlots() {
    return EMPTY_SLOT_ARRAY;
  }

}
