package optic_fusion1.slimefunreloaded.component.item.impl;

import java.util.List;
import optic_fusion1.slimefunreloaded.Slimefun;
import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.component.RecipeType;
import optic_fusion1.slimefunreloaded.component.SlimefunReloadedComponent;
import optic_fusion1.slimefunreloaded.component.item.SlimefunReloadedItem;
import optic_fusion1.slimefunreloaded.protection.ProtectableAction;
import optic_fusion1.slimefunreloaded.util.CustomItem;
import optic_fusion1.slimefunreloaded.util.block.Vein;
import optic_fusion1.slimefunreloaded.util.material.MaterialCollections;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class PickaxeOfVeinMining extends SlimefunReloadedItem {

  public PickaxeOfVeinMining(NamespacedKey key, Category category, ItemStack item, RecipeType recipeType, ItemStack[] recipe) {
    super(key, category, item, recipeType, recipe);
  }

  @Override
  public void onBlockBreak(BlockBreakEvent event, Player player, Block brokenBlock, ItemStack item, int fortune, SlimefunReloadedComponent component) {
    if (MaterialCollections.getAllOres().contains(brokenBlock.getType())) {
      List<Block> blocks = Vein.find(brokenBlock, 16, MaterialCollections.getAllOres());

      for (Block b : blocks) {
        if (Slimefun.getProtectionManager().hasPermission(player, b.getLocation(), ProtectableAction.BREAK_BLOCK)) {
          b.getWorld().playEffect(b.getLocation(), Effect.STEP_SOUND, b.getType());

          for (ItemStack drop : b.getDrops()) {
            b.getWorld().dropItemNaturally(b.getLocation(), drop.getType().isBlock() ? drop : new CustomItem(drop, fortune));
          }

          b.setType(Material.AIR);
        }
      }
    }
  }

}
