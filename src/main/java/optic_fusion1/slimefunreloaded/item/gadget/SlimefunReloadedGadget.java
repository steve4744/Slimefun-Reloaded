package optic_fusion1.slimefunreloaded.item.gadget;

import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.item.RecipeDisplayItem;
import optic_fusion1.slimefunreloaded.item.SlimefunReloadedItem;
import org.bukkit.inventory.ItemStack;

public abstract class SlimefunReloadedGadget extends SlimefunReloadedItem implements RecipeDisplayItem {

  public SlimefunReloadedGadget(Category category, ItemStack item, String id) {
    super(category, item, id);
  }

}
