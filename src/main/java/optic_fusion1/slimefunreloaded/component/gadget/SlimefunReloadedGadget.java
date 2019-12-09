package optic_fusion1.slimefunreloaded.component.gadget;

import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.component.RecipeType;
import optic_fusion1.slimefunreloaded.component.SlimefunReloadedComponent;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

public abstract class SlimefunReloadedGadget extends SlimefunReloadedComponent {

  public SlimefunReloadedGadget(NamespacedKey key, Category category, ItemStack item, RecipeType recipeType, ItemStack[] recipe) {
    super(key, category, item, recipeType, recipe);
  }

  public SlimefunReloadedGadget(NamespacedKey key, Category category, ItemStack item, RecipeType recipeType, ItemStack[] recipe, String[] keys, Object[] values) {
    super(key, category, item, recipeType, recipe, keys, values);
  }

}
