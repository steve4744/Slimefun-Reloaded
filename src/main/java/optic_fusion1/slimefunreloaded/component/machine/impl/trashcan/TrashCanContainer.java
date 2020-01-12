package optic_fusion1.slimefunreloaded.component.machine.impl.trashcan;

import optic_fusion1.slimefunreloaded.machine.MachineContainer;
import optic_fusion1.slimefunreloaded.menu.border.impl.SimpleBorder;
import optic_fusion1.slimefunreloaded.menu.impl.SimpleMenu;
import optic_fusion1.slimefunreloaded.util.CustomItem;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class TrashCanContainer extends MachineContainer {

  private final TrashCanState state;
  private final int[] BORDER = {0, 1, 2, 3, 5, 4, 6, 7, 8, 9, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26};
  private final CustomItem ITEM_STACK = new CustomItem(new ItemStack(Material.RED_STAINED_GLASS_PANE), " ");

  public TrashCanContainer(TrashCanState state) {
    super(() -> new SimpleMenu("&4Trash Can"));
    new SimpleBorder(BORDER, ITEM_STACK).applyTo(getMenu());
    this.state = state;
  }

  public TrashCanState getState() {
    return state;
  }

  @Override
  public int[] getInputSlots() {
    return new int[]{10, 11, 12, 13, 14, 15, 16};
  }

  @Override
  public int[] getOutputSlots() {
    return new int[0];
  }

}
