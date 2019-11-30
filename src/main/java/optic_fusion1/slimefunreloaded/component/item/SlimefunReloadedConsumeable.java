package optic_fusion1.slimefunreloaded.component.item;

import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.component.RecipeType;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public abstract class SlimefunReloadedConsumeable extends SlimefunReloadedItem {

  public SlimefunReloadedConsumeable(NamespacedKey key, Category category, ItemStack item, RecipeType recipeType, ItemStack[] recipe) {
    super(key, category, item, recipeType, recipe);
  }

  /**
   * Called when a player consumes this item.
   *
   * @param player the player
   * @param item the item
   */
  public boolean onConsume(Player player, ItemStack item) {
    return true;
  }

}
