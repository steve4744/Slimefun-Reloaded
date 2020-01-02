package optic_fusion1.slimefunreloaded.component.item.impl;

import java.util.List;
import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.component.RecipeType;
import optic_fusion1.slimefunreloaded.component.SlimefunReloadedComponent;
import optic_fusion1.slimefunreloaded.component.item.SlimefunReloadedItem;
import optic_fusion1.slimefunreloaded.util.CustomItem;
import optic_fusion1.slimefunreloaded.util.SlimefunReloadedItems;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class HerculesPickaxe extends SlimefunReloadedItem {

  public HerculesPickaxe(NamespacedKey key, Category category, ItemStack item, RecipeType recipeType, ItemStack[] recipe) {
    super(key, category, item, recipeType, recipe);
  }

  @Override
  public void onBlockBreak(BlockBreakEvent event, Player player, Block brokenBlock, ItemStack item, int fortune, SlimefunReloadedComponent component) {
    switch (brokenBlock.getType()) {
      case IRON_ORE:
        brokenBlock.getDrops().add(new CustomItem(SlimefunReloadedItems.IRON_DUST, 2));
        break;
      case GOLD_ORE:
        brokenBlock.getDrops().add(new CustomItem(SlimefunReloadedItems.GOLD_DUST, 2));
        break;
      default:
        brokenBlock.getDrops().forEach((drop) -> {
          brokenBlock.getDrops().add(new CustomItem(drop, drop.getAmount() * 2));
        });
        break;
    }
  }

}
