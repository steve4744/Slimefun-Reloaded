package optic_fusion1.slimefunreloaded.component.item.impl;

import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.component.RecipeType;
import optic_fusion1.slimefunreloaded.component.item.SlimefunReloadedItem;
import optic_fusion1.slimefunreloaded.util.SlimefunReloadedItemStack;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemStack;

public class PortableCrafter extends SlimefunReloadedItem {

  public PortableCrafter(NamespacedKey key, Category category, ItemStack item, RecipeType recipeType, ItemStack[] recipe) {
    super(key, category, item, recipeType, recipe);
  }

  @Override
  public boolean onInteract(Player player, ItemStack item, Action action, Block clickedBlock) {
    //e.setCancelled(true);
    player.openWorkbench(player.getLocation(), true);
    player.getWorld().playSound(player.getLocation(), Sound.BLOCK_WOODEN_BUTTON_CLICK_ON, 1, 1);
    return true;
  }

}
