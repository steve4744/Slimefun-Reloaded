package optic_fusion1.slimefunreloaded.component.item;

import java.util.List;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.component.SlimefunReloadedComponent;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.event.block.Action;

/**
 * Represents an item component collectible in the player's inventory with which they may interact and use.
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
   * @param action the action
   * @param clickedBlock the clicked block
   *
   * @return true if success, false otherwise
   */
  public boolean onInteract(Player player, ItemStack item, Action action, Block clickedBlock) {
    return true;
  }

  /**
   * Called when a player picks up this item.
   *
   * @param player the player
   * @param item the item
   */
  public void onPickup(Player player, ItemStack item) {
  }

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
   * Called when a player breaks this item. Note that the item must be a durable type in order for this item to be called. For example, pickaxes and swords will have this method invoked when their durability reaches 0.
   *
   * @param player the player
   * @param item the item
   */
  public void onBreak(Player player, ItemStack item) {
  }

  /**
   * Called when a player kills an entity.
   *
   * @param player the player
   * @param entity the entity killed
   * @param item the item
   */
  public void onKill(Player player, Entity entity, ItemStack item, List<ItemStack> drops) {
  }

  /**
   * Called when a player breaks a block.
   *
   * @param player the player
   * @param brokenBlock the block
   * @param item the item
   */
  public void onBlockBreak(Player player, ItemStack item, Block brokenBlock) {
  }

}
