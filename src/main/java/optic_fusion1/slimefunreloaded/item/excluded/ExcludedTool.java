package optic_fusion1.slimefunreloaded.item.excluded;

import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.item.NotPlaceable;
import optic_fusion1.slimefunreloaded.item.SlimefunReloadedItem;
import org.bukkit.inventory.ItemStack;

public class ExcludedTool extends SlimefunReloadedItem implements NotPlaceable {

  public ExcludedTool(Category category, ItemStack item, String id) {
    super(category, item, id);
  }

}
