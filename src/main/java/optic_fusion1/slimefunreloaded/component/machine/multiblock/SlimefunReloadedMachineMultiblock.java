package optic_fusion1.slimefunreloaded.component.machine.multiblock;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.component.RecipeType;
import optic_fusion1.slimefunreloaded.component.machine.SlimefunReloadedMachine;
import optic_fusion1.slimefunreloaded.machine.MachineState;

/**
 * A special type of {@link SlimefunReloadedMachine} composed of multiple blocks.
 *
 * @param <T> the type of {@link MachineState} created by this machine
 *
 * @author Parker "Choco" Hawke
 */
public abstract class SlimefunReloadedMachineMultiblock<T extends MachineState> extends SlimefunReloadedMachine<T> {

  // TODO: Implement multiblock-related machine components here
  protected SlimefunReloadedMachineMultiblock(NamespacedKey key, Category category, ItemStack item, RecipeType recipeType, ItemStack[] recipe) {
    super(key, category, item, recipeType, recipe);
  }

}
