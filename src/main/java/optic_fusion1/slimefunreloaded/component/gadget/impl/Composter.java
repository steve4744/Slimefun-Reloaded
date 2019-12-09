package optic_fusion1.slimefunreloaded.component.gadget.impl;

import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.component.RecipeType;
import optic_fusion1.slimefunreloaded.component.item.SlimefunReloadedGadget;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

public class Composter extends SlimefunReloadedGadget {

  public Composter(NamespacedKey key, Category category, ItemStack item, RecipeType recipeType, ItemStack[] recipe) {
    super(key, category, item, recipeType, recipe);
  }

}
