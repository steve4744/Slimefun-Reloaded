package optic_fusion1.slimefunreloaded.component.item;

import java.util.ArrayList;
import java.util.List;
import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.component.RecipeType;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

public class SlimefunReloadedGadget extends SlimefunReloadedItem {

  public SlimefunReloadedGadget(NamespacedKey key, Category category, ItemStack item, RecipeType recipeType, ItemStack[] recipe) {
    super(key, category, item, recipeType, recipe);
  }

  public List<ItemStack[]> getRecipes() {
    return new ArrayList<>();
//    return this.recipes;
  }

}
