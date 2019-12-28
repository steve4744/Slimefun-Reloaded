package optic_fusion1.slimefunreloaded.component.item;

import java.util.List;
import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.component.RecipeType;
import optic_fusion1.slimefunreloaded.component.SlimefunReloadedComponent;
import optic_fusion1.slimefunreloaded.component.UnregisterReason;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

public class SlimefunReloadedBlock extends SlimefunReloadedItem {

  public SlimefunReloadedBlock(NamespacedKey key, Category category, ItemStack item, RecipeType recipeType, ItemStack[] recipe) {
    super(key, category, item, recipeType, recipe);
  }

  public SlimefunReloadedBlock(NamespacedKey key, Category category, ItemStack item, RecipeType recipeType, ItemStack[] recipe, String[] keys, Object[] values) {
    super(key, category, item, recipeType, recipe, keys, values);
  }

  public SlimefunReloadedBlock(NamespacedKey key, Category category, ItemStack item, RecipeType recipeType, ItemStack[] recipe, ItemStack recipeOutput) {
    super(key, category, item, recipeType, recipe, recipeOutput);
  }

  public void onBlockPlace(Player player, Block block, SlimefunReloadedComponent item) {
  }

  public boolean onBlockPlace(BlockPlaceEvent e, ItemStack item) {
    return false;
  }

  public boolean onBlockBreak(Player player, Block block, SlimefunReloadedComponent item, UnregisterReason reason) {
    return true;
  }

  public boolean onBlockBreak(BlockBreakEvent e, ItemStack item, int fortune, List<ItemStack> drops) {
    return false;
  }
}