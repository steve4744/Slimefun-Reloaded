package optic_fusion1.slimefunreloaded.component.item;

import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.component.RecipeType;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

@Deprecated
public class ReplacingItem extends SlimefunReloadedItem {

  public ReplacingItem(NamespacedKey key, Category category, ItemStack item, RecipeType recipeType, ItemStack[] recipe) {
    super(key, category, item, recipeType, recipe);
//    this.setReplacing(true);
  }

}
