package optic_fusion1.slimefunreloaded.component.item;

import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.component.RecipeType;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class SlimefunReloadedPlaceableItem extends SlimefunReloadedItem {

  public SlimefunReloadedPlaceableItem(NamespacedKey key, Category category, ItemStack item, RecipeType recipeType, ItemStack[] recipe) {
    super(key, category, item, recipeType, recipe);
  }

  public SlimefunReloadedPlaceableItem(NamespacedKey key, Category category, ItemStack item, RecipeType recipeType, ItemStack[] recipe, String[] keys, Object[] values) {
    super(key, category, item, recipeType, recipe, keys, values);
  }

  public void onPlace(Player player, ItemStack item, Block block) {
  }

}
