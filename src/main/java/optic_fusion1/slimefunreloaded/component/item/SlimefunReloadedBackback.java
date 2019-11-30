package optic_fusion1.slimefunreloaded.component.item;

import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.component.RecipeType;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

public class SlimefunReloadedBackback extends SlimefunReloadedItem {

  private int size;

  public SlimefunReloadedBackback(NamespacedKey key, Category category, ItemStack item, RecipeType recipeType, ItemStack[] recipe, int size) {
    super(key, category, item, recipeType, recipe);
    this.size = size;
  }

  public int getSize() {
    return size;
  }

}
