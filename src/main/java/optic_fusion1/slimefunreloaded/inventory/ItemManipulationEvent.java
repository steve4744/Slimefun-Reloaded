package optic_fusion1.slimefunreloaded.inventory;

import org.bukkit.inventory.ItemStack;

@Deprecated
@FunctionalInterface
public interface ItemManipulationEvent {

  ItemStack onEvent(int slot, ItemStack previous, ItemStack next);

}
