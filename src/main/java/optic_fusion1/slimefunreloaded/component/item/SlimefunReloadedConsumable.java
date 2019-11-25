package optic_fusion1.slimefunreloaded.component.item;

import optic_fusion1.slimefunreloaded.category.type.Category;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public abstract class SlimefunReloadedConsumable extends SlimefunReloadedItem {

  public SlimefunReloadedConsumable(NamespacedKey key, Category category, ItemStack item) {
    super(key, category, item);
  }

  /**
   * Called when a player picks up this item.
   *
   * @param player the player
   * @param item the item
   */
  public boolean onConsume(Player player, ItemStack item) {
    return true;
  }

}
