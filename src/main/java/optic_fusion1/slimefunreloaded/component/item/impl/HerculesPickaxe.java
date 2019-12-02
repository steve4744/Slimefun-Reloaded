package optic_fusion1.slimefunreloaded.component.item.impl;

import java.util.List;
import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.component.RecipeType;
import optic_fusion1.slimefunreloaded.component.item.SlimefunReloadedItem;
import optic_fusion1.slimefunreloaded.util.CustomItem;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class HerculesPickaxe extends SlimefunReloadedItem {

  public HerculesPickaxe(NamespacedKey key, Category category, ItemStack item, RecipeType recipeType, ItemStack[] recipe) {
    super(key, category, item, recipeType, recipe);
  }

  @Override
  public void onBlockBreak(Player player, ItemStack item, Block brokenBlock, List<ItemStack> drops, int fortune) {
    switch (brokenBlock.getType()) {
      case IRON_ORE:
        drops.add(new CustomItem(SlimefunReloadedItems.IRON_DUST, 2));
        break;
      case GOLD_ORE:
        drops.add(new CustomItem(SlimefunReloadedItems.GOLD_DUST, 2));
        break;
      default:
        brokenBlock.getDrops().forEach((drop) -> {
          drops.add(new CustomItem(drop, drop.getAmount() * 2));
        });
        break;

    }
  }

}
