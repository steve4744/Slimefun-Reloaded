package optic_fusion1.slimefunreloaded.component.item.impl;

import java.util.List;
import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.component.RecipeType;
import optic_fusion1.slimefunreloaded.component.item.SlimefunReloadedItem;
import optic_fusion1.slimefunreloaded.util.BlockStorage;
import optic_fusion1.slimefunreloaded.util.SlimefunReloadedItems;
import optic_fusion1.slimefunreloaded.util.StringUtils;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PickaxeOfContainment extends SlimefunReloadedItem {

  public PickaxeOfContainment(NamespacedKey key, Category category, ItemStack item, RecipeType recipeType, ItemStack[] recipe) {
    super(key, category, item, recipeType, recipe);
  }

  @Override
  public void onBlockBreak(Player player, ItemStack item, Block brokenBlock, List<ItemStack> drops, int fortune) {
    // Refactored it into this so we don't need to call e.getBlock() all the time.
    Block b = brokenBlock;
    if (b.getType() != Material.SPAWNER) {
      return;
    }

    // If the spawner's BlockStorage has BlockInfo, then it's not a vanilla spawner and shouldn't give a broken spawner.
    ItemStack spawner = SlimefunReloadedItems.BROKEN_SPAWNER.clone();
    if (BlockStorage.hasBlockInfo(b)) {
      spawner = SlimefunReloadedItems.REPAIRED_SPAWNER.clone();
    }

    ItemMeta im = spawner.getItemMeta();
    List<String> lore = im.getLore();

    for (int i = 0; i < lore.size(); i++) {
      if (lore.get(i).contains("<Type>")) {
        lore.set(i, lore.get(i).replace("<Type>", StringUtils.format(((CreatureSpawner) b.getState()).getSpawnedType().toString())));
      }
    }

    im.setLore(lore);
    spawner.setItemMeta(im);
    b.getLocation().getWorld().dropItemNaturally(b.getLocation(), spawner);
//    e.setExpToDrop(0);
//    e.setDropItems(false);
  }

}
