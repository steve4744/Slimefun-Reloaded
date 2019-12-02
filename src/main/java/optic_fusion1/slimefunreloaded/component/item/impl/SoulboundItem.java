package optic_fusion1.slimefunreloaded.component.item.impl;

import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.component.RecipeType;
import optic_fusion1.slimefunreloaded.component.item.SlimefunReloadedItem;
import optic_fusion1.slimefunreloaded.component.item.interfaces.Soulbound;
import optic_fusion1.slimefunreloaded.util.SlimefunReloadedItemStack;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

public class SoulboundItem extends SlimefunReloadedItem implements Soulbound {

  public SoulboundItem(Category category, SlimefunReloadedItemStack item, ItemStack[] recipe) {
    super(category, item, RecipeType.MAGIC_WORKBENCH, recipe);
  }

  public SoulboundItem(NamespacedKey key, Category category, ItemStack item, RecipeType recipeType, ItemStack[] recipe) {
    super(key, category, item, recipeType, recipe);
  }

}
