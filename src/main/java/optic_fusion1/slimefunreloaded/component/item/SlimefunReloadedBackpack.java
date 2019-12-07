package optic_fusion1.slimefunreloaded.component.item;

import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.component.RecipeType;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

public class SlimefunReloadedBackpack extends SlimefunReloadedItem {

  private int size;

  public SlimefunReloadedBackpack(NamespacedKey key, Category category, ItemStack item, ItemStack[] recipe, int size) {
    this(key, category, item, null, recipe, size);
  }
  
  public SlimefunReloadedBackpack(NamespacedKey key, Category category, ItemStack item, RecipeType recipeType, ItemStack[] recipe, int size) {
    super(key, category, item, recipeType, recipe);
    this.size = size;
  }

  public int getSize() {
    return size;
  }

}
