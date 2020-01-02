package optic_fusion1.slimefunreloaded.component.item.impl;

import java.util.List;
import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.component.RecipeType;
import optic_fusion1.slimefunreloaded.component.SlimefunReloadedComponent;
import optic_fusion1.slimefunreloaded.component.item.SlimefunReloadedItem;
import optic_fusion1.slimefunreloaded.util.BlockStorage;
import optic_fusion1.slimefunreloaded.util.SlimefunReloadedItems;
import optic_fusion1.slimefunreloaded.util.StringUtils;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PickaxeOfContainment extends SlimefunReloadedItem {

  public PickaxeOfContainment(NamespacedKey key, Category category, ItemStack item, RecipeType recipeType, ItemStack[] recipe) {
    super(key, category, item, recipeType, recipe);
  }

  @Override
  public void onBlockBreak(BlockBreakEvent event, Player player, Block brokenBlock, ItemStack item, int fortune, SlimefunReloadedComponent component) {
    if (brokenBlock.getType() != Material.SPAWNER) {
      return;
    }

    // If the spawner's BlockStorage has BlockInfo, then it's not a vanilla spawner and shouldn't give a broken spawner.
    ItemStack spawner = SlimefunReloadedItems.BROKEN_SPAWNER.clone();
    if (BlockStorage.hasBlockInfo(brokenBlock)) {
      spawner = SlimefunReloadedItems.REPAIRED_SPAWNER.clone();
    }

    ItemMeta im = spawner.getItemMeta();
    List<String> lore = im.getLore();

    for (int i = 0; i < lore.size(); i++) {
      if (lore.get(i).contains("<Type>")) {
        lore.set(i, lore.get(i).replace("<Type>", StringUtils.format(((CreatureSpawner) brokenBlock.getState()).getSpawnedType().toString())));
      }
    }

    im.setLore(lore);
    spawner.setItemMeta(im);
    brokenBlock.getLocation().getWorld().dropItemNaturally(brokenBlock.getLocation(), spawner);
    event.setExpToDrop(0);
    event.setDropItems(false);
  }

}
