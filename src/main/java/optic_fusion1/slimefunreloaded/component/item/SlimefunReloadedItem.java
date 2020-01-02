package optic_fusion1.slimefunreloaded.component.item;

import java.util.List;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.component.RecipeType;
import optic_fusion1.slimefunreloaded.component.SlimefunReloadedComponent;
import optic_fusion1.slimefunreloaded.util.ItemUtils;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * Represents an item component collectible in the player's inventory with which they may interact and use.
 *
 * @author Parker "Choco" Hawke
 */
public abstract class SlimefunReloadedItem extends SlimefunReloadedComponent {

  protected SlimefunReloadedItem(NamespacedKey key, Category category, ItemStack item, RecipeType recipeType, ItemStack[] recipe) {
    super(key, category, item, recipeType, recipe);
  }

  protected SlimefunReloadedItem(NamespacedKey key, Category category, ItemStack item, RecipeType recipeType, ItemStack[] recipe, String[] keys, Object[] values) {
    super(key, category, item, recipeType, recipe, keys, values);
  }

  protected SlimefunReloadedItem(NamespacedKey key, Category category, ItemStack item, RecipeType recipeType, ItemStack[] recipe, ItemStack recipeOutput) {
    super(key, category, item, recipeType, recipe, recipeOutput);
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
  public boolean onDrop(Player player, Item item) {
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
   * @param drops the entity drops
   */
  public void onKill(Player player, Entity entity, ItemStack item, List<ItemStack> drops) {
  }

  /**
   * Called when a player breaks a block.
   *
   * @param event the event
   * @param player the player
   * @param brokenBlock the block
   * @param item the item
   * @param fortune the item fortune level
   * @param component the component
   */
  public void onBlockBreak(BlockBreakEvent event, Player player, Block brokenBlock, ItemStack item, int fortune, SlimefunReloadedComponent component) {
  }

  /**
   * This Method will consume the Item in the specified slot. See {@link ItemUtils#consumeItem(ItemStack, int, boolean)} for further details.
   *
   * @param item The Item to consume
   * @param replaceConsumables Whether Consumable Items should be replaced with their "empty" version, see {@link ItemUtils#consumeItem(ItemStack, int, boolean)}
   */
  public static void consumeItem(@NonNull ItemStack item, boolean replaceConsumables) {
    consumeItem(item, 1, replaceConsumables);
  }

  /**
   * This Method consumes a specified amount of items from the specified slot.
   *
   * The items will be removed from the slot, if the slot does not hold enough items, it will be replaced with null. Note that this does not check whether there are enough Items present, if you specify a bigger amount than present, it will simply set the Item to null.
   *
   * If replaceConsumables is true, the following things will not be replaced with 'null': null null null null null null null   {@code Buckets -> new ItemStack(Material.BUCKET)}
	 * {@code Potions -> new ItemStack(Material.GLASS_BOTTLE)}
   *
   * @param item	The Item to consume
   * @param amount	How many Items should be removed
   * @param replaceConsumables	Whether Items should be replaced with their "empty" version
   */
  public static void consumeItem(ItemStack item, int amount, boolean replaceConsumables) {
    ItemUtils.consumeItem(item, amount, replaceConsumables);
  }

}
