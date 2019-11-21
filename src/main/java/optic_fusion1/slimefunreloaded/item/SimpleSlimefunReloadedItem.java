package optic_fusion1.slimefunreloaded.item;

import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.item.handler.ItemHandler;
import org.bukkit.inventory.ItemStack;

public class SimpleSlimefunReloadedItem<T extends ItemHandler> extends SlimefunReloadedItem {

  public SimpleSlimefunReloadedItem(Category category, ItemStack item, String id) {
    super(category, item, id);
  }

}
