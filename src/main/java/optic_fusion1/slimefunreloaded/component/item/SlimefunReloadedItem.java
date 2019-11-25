package optic_fusion1.slimefunreloaded.component.item;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.component.SlimefunReloadedComponent;

/**
 * Represents an item component collectible in the player's inventory with which they may
 * interact and use.
 *
 * @author Parker "Choco" Hawke
 */
public abstract class SlimefunReloadedItem extends SlimefunReloadedComponent {

  protected SlimefunReloadedItem(NamespacedKey key, Category category, ItemStack item) {
    super(key, category, item);
  }

  /**
   * Called when a player interacts with this item.
   *
   * @param player the player
   * @param item the item
   *
   * @return true if success, false otherwise
   */
  public boolean onInteract(Player player, ItemStack item) {
    return true;
  }

  /**
   * Called when a player picks up this item.
   *
   * @param player the player
   * @param item the item
   */
  public void onPickup(Player player, ItemStack item) { }

  /**
   * Called when a player drops this item.
   *
   * @param player the player
   * @param item the item
   *
   * @return true if success, false otherwise. If false, the item will not be dropped
   */
  public boolean onDrop(Player player, ItemStack item) {
    return true;
  }

  /**
   * Called when a player breaks this item. Note that the item must be a durable type in
   * order for this item to be called. For example, pickaxes and swords will have this
   * method invoked when their durability reaches 0.
   *
   * @param player the player
   * @param item the item
   */
  public void onBreak(Player player, ItemStack item) { }

}
