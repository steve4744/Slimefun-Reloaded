package optic_fusion1.slimefunreloaded.item;

import optic_fusion1.slimefunreloaded.category.type.Category;
import org.bukkit.inventory.ItemStack;

public class VanillaItem extends SlimefunReloadedItem {

  public VanillaItem(Category category, ItemStack item, String id) {
    super(category, item, id);
    usableInWorkbench = true;
  }

}
