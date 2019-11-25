package optic_fusion1.slimefunreloaded.component.machine;

import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.component.SlimefunReloadedComponent;
import optic_fusion1.slimefunreloaded.machine.MachineState;

/**
 * Represents a machine component capable of performing tasks in the world and storing
 * a state with which the player may interact.
 *
 * @param <T> the type of {@link MachineState} created by this machine
 *
 * @author Parker "Choco" Hawke
 */
public abstract class SlimefunReloadedMachine<T extends MachineState> extends SlimefunReloadedComponent {

  protected SlimefunReloadedMachine(NamespacedKey key, Category category, ItemStack item) {
    super(key, category, item);
  }

  /**
   * Initialize the machine state after it's been created and placed in the world.
   *
   * @param state the state to init
   * @param player the player that placed the state
   */
  public void initState(T state, Player player) { }

  /**
   * Called when a player interacts with this machine.
   *
   * @param state the machine state with which the player interacted
   * @param player the player
   * @param hand the hand used
   * @param face the face on which the interaction was made
   *
   * @return true if success, false otherwise
   */
  public boolean onInteract(T state, Player player, EquipmentSlot hand, BlockFace face) {
    return true;
  }

  /**
   * Called when a player performs an action with this machine (punching).
   *
   * @param state the machine state with which the player acted
   * @param player the player
   * @param face the face on which the action was made
   *
   * @return true if success, false otherwise
   */
  public boolean onAction(T state, Player player, BlockFace face) {
    return true;
  }

  /**
   * Called on the destruction of this machine.
   *
   * @param state the machine state to be destroyed
   * @param player the player that destroyed the machine
   * @param item the item used to destroy the machine
   * @param face the face on which the destruction took place
   */
  public void onDestroy(T state, Player player, ItemStack item, BlockFace face) { }

  /**
   * Create a new state for this machine. Cannot return null.
   *
   * @param block the block wrapped by the machine state
   *
   * @return the newly created machine state
   */
  public abstract T createState(Block block);

}
