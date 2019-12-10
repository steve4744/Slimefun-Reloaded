package optic_fusion1.slimefunreloaded.component.item.impl;

import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.component.RecipeType;
import optic_fusion1.slimefunreloaded.component.item.SlimefunReloadedItem;
import optic_fusion1.slimefunreloaded.util.I18n;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemStack;

public class WaterStaff extends SlimefunReloadedItem {

  public WaterStaff(NamespacedKey key, Category category, ItemStack item, RecipeType recipeType, ItemStack[] recipe) {
    super(key, category, item, recipeType, recipe);
  }

  public WaterStaff(NamespacedKey key, Category category, ItemStack item, RecipeType recipeType, ItemStack[] recipe, String[] keys, Object[] values) {
    super(key, category, item, recipeType, recipe, keys, values);
  }

  @Override
  public boolean onInteract(Player player, ItemStack item, Action action, Block clickedBlock) {
    if (action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
      player.setFireTicks(0);
      I18n.tl(player, "messages.fire-extinugish");
      return true;
    }
    return true;
  }

}
