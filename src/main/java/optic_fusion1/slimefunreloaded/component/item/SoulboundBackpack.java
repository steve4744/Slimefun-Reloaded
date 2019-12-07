package optic_fusion1.slimefunreloaded.component.item;

import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.component.RecipeType;
import optic_fusion1.slimefunreloaded.component.item.interfaces.Soulbound;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

public class SoulboundBackpack extends SlimefunReloadedBackpack implements Soulbound {

  public SoulboundBackpack(NamespacedKey key, Category category, ItemStack item, RecipeType recipeType, ItemStack[] recipe, int size) {
    super(key, category, item, recipeType, recipe, size);
  }

}
