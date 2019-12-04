package optic_fusion1.slimefunreloaded.ancient_altar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import optic_fusion1.slimefunreloaded.Slimefun;
import optic_fusion1.slimefunreloaded.util.BlockStorage;
import optic_fusion1.slimefunreloaded.util.SlimefunReloadedItems;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public final class Pedestals {

  private Pedestals() {
  }

  public static List<Block> getPedestals(Block altar) {
    String pedestal = "ANCIENT_PEDESTAL";
    List<Block> list = new ArrayList<>();

    if (BlockStorage.check(altar.getRelative(2, 0, -2), pedestal)) {
      list.add(altar.getRelative(2, 0, -2));
    }
    if (BlockStorage.check(altar.getRelative(3, 0, 0), pedestal)) {
      list.add(altar.getRelative(3, 0, 0));
    }
    if (BlockStorage.check(altar.getRelative(2, 0, 2), pedestal)) {
      list.add(altar.getRelative(2, 0, 2));
    }
    if (BlockStorage.check(altar.getRelative(0, 0, 3), pedestal)) {
      list.add(altar.getRelative(0, 0, 3));
    }
    if (BlockStorage.check(altar.getRelative(-2, 0, 2), pedestal)) {
      list.add(altar.getRelative(-2, 0, 2));
    }
    if (BlockStorage.check(altar.getRelative(-3, 0, 0), pedestal)) {
      list.add(altar.getRelative(-3, 0, 0));
    }
    if (BlockStorage.check(altar.getRelative(-2, 0, -2), pedestal)) {
      list.add(altar.getRelative(-2, 0, -2));
    }
    if (BlockStorage.check(altar.getRelative(0, 0, -3), pedestal)) {
      list.add(altar.getRelative(0, 0, -3));
    }

    return list;
  }

  public static ItemStack getRecipeOutput(ItemStack catalyst, List<ItemStack> input) {
    if (input.size() != 8) {
      return null;
    }

    if (catalyst.isSimilar(SlimefunReloadedItems.BROKEN_SPAWNER)) {
      if (checkRecipe(SlimefunReloadedItems.BROKEN_SPAWNER, input) == null) {
        return null;
      }
      final ItemStack spawner = SlimefunReloadedItems.REPAIRED_SPAWNER.clone();
      ItemMeta im = spawner.getItemMeta();
      im.setLore(Arrays.asList(catalyst.getItemMeta().getLore().get(0)));
      spawner.setItemMeta(im);
      return spawner;
    }

    return checkRecipe(catalyst, input);
  }

  private static ItemStack checkRecipe(ItemStack catalyst, List<ItemStack> items) {
    for (AltarRecipe recipe : Slimefun.getAltarRecipes()) {
      if (catalyst.isSimilar(recipe.getCatalyst())) {
        for (int i = 0; i < 8; i++) {
          if (items.get(i).isSimilar(recipe.getInput().get(0))) {
            for (int j = 1; j < 8; j++) {
              if (!items.get((i + j) % items.size()).isSimilar(recipe.getInput().get(j))) {
                break;
              } else if (j == 7) {
                return recipe.getOutput();
              }
            }
          }
        }
      }
    }

    return null;
  }
}
