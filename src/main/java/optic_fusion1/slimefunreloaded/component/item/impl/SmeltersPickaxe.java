package optic_fusion1.slimefunreloaded.component.item.impl;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import optic_fusion1.slimefunreloaded.Slimefun;
import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.component.RecipeType;
import optic_fusion1.slimefunreloaded.component.item.SlimefunReloadedItem;
import optic_fusion1.slimefunreloaded.recipe.MinecraftRecipe;
import optic_fusion1.slimefunreloaded.util.BlockStorage;
import optic_fusion1.slimefunreloaded.util.material.MaterialCollections;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class SmeltersPickaxe extends SlimefunReloadedItem {

  public SmeltersPickaxe(NamespacedKey key, Category category, ItemStack item, RecipeType recipeType, ItemStack[] recipe) {
    super(key, category, item, recipeType, recipe);
  }

  @Override
  public void onBlockBreak(Player player, ItemStack item, Block brokenBlock, List<ItemStack> drops, int fortune) {
    if (BlockStorage.hasBlockInfo(brokenBlock)) {
      return;
    }
    if (brokenBlock.getType() == Material.PLAYER_HEAD) {
      return;
    }

    Collection<ItemStack> blockDrops = brokenBlock.getDrops();
    for (ItemStack drop : blockDrops) {
      if (drop != null) {
        ItemStack output = drop;

        if (MaterialCollections.getAllOres().contains(brokenBlock.getType())) {
          output.setAmount(fortune);

          Optional<ItemStack> furnaceOutput = Slimefun.getMinecraftRecipes().getRecipeOutput(MinecraftRecipe.FURNACE, drop);
          if (furnaceOutput.isPresent()) {
            brokenBlock.getWorld().playEffect(brokenBlock.getLocation(), Effect.MOBSPAWNER_FLAMES, 1);
            output.setType(furnaceOutput.get().getType());
          }
        }

        drops.add(output);
      }
    }
  }

}
