package optic_fusion1.slimefunreloaded.component.item.impl;

import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.component.RecipeType;
import optic_fusion1.slimefunreloaded.component.item.SlimefunReloadedItem;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemStack;

public class InfernalBonemeal extends SlimefunReloadedItem {

  public InfernalBonemeal(NamespacedKey key, Category category, ItemStack item, RecipeType recipeType, ItemStack[] recipe) {
    super(key, category, item, recipeType, recipe);
  }

  @Override
  public boolean onInteract(Player player, ItemStack item, Action action, Block clickedBlock) {
    if (clickedBlock != null && clickedBlock.getType() == Material.NETHER_WART) {
      Ageable ageable = (Ageable) clickedBlock.getBlockData();
      if (ageable.getAge() < ageable.getMaximumAge()) {
        ageable.setAge(ageable.getMaximumAge());
        clickedBlock.setBlockData(ageable);
        clickedBlock.getWorld().playEffect(clickedBlock.getLocation(), Effect.STEP_SOUND, Material.REDSTONE_BLOCK);

        if (player.getGameMode() != GameMode.CREATIVE) {
          consumeItem(item, false);
        }
      }
    }
    return true;
  }

}
