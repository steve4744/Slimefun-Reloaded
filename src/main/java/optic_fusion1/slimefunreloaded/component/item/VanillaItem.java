package optic_fusion1.slimefunreloaded.component.item;

import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.component.RecipeType;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

public class VanillaItem extends SlimefunReloadedItem {

  public VanillaItem(NamespacedKey key, Category category, ItemStack item, RecipeType recipeType, ItemStack[] recipe) {
    super(key, category, item, recipeType, recipe);
  }

  public VanillaItem(NamespacedKey key, Category category, ItemStack item, RecipeType recipeType, ItemStack[] recipe, String[] keys, Object[] values) {
    super(key, category, item, recipeType, recipe, keys, values);
  }

}
