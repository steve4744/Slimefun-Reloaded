package optic_fusion1.slimefunreloaded.menu.layout.impl;

import optic_fusion1.slimefunreloaded.menu.BaseMenu;
import optic_fusion1.slimefunreloaded.menu.layout.BaseLayout;
import optic_fusion1.slimefunreloaded.util.CustomItem;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ContainerLayout extends BaseLayout {

  private static final int[] BORDER = {0, 1, 2, 3, 4, 5, 6, 7, 8, 13, 31, 36, 37, 38, 39, 40, 41, 42, 43, 44};
  private static final int[] BORDER_IN = {9, 10, 11, 12, 18, 21, 27, 28, 29, 30};
  private static final int[] BORDER_OUT = {14, 15, 16, 17, 23, 26, 32, 33, 34, 35};
  private static final CustomItem BORDER_ITEM_STACK = new CustomItem(new ItemStack(Material.GRAY_STAINED_GLASS_PANE), " ");
  private static final CustomItem BORDER_IN_ITEM_STACK = new CustomItem(new ItemStack(Material.CYAN_STAINED_GLASS_PANE), " ");
  private static final CustomItem BORDER_OUT_ITEM_STACK = new CustomItem(new ItemStack(Material.ORANGE_STAINED_GLASS_PANE), " ");

  public ContainerLayout(BaseMenu menu) {
    super(menu);
    for (int slot : BORDER) {
      menu.setItem(slot, BORDER_ITEM_STACK);
    }
    for (int slot : BORDER_IN) {
      menu.setItem(slot, BORDER_IN_ITEM_STACK);
    }
    for (int slot : BORDER_OUT) {
      menu.setItem(slot, BORDER_OUT_ITEM_STACK);
    }
    menu.setItem(22, new CustomItem(new ItemStack(Material.BLACK_STAINED_GLASS_PANE), " "));
  }

}
