package optic_fusion1.slimefunreloaded.component.item.impl;

import java.util.List;
import optic_fusion1.slimefunreloaded.Slimefun;
import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.component.RecipeType;
import optic_fusion1.slimefunreloaded.component.item.SlimefunReloadedItem;
import optic_fusion1.slimefunreloaded.component.item.interfaces.DamageableItem;
import optic_fusion1.slimefunreloaded.protection.ProtectableAction;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ExplosiveShovel extends SlimefunReloadedItem implements DamageableItem{

  private boolean damageOnUse;
  
  public ExplosiveShovel(NamespacedKey key, Category category, ItemStack item, RecipeType recipeType, ItemStack[] recipe) {
    super(key, category, item, recipeType, recipe);
    damageOnUse = ((boolean) Slimefun.getItemValue(getID(), "damage-on-use"));
  }

  @Override
  public void onBlockBreak(Player player, ItemStack item, Block brokenBlock, List<ItemStack> drops, int fortune) {
    brokenBlock.getWorld().createExplosion(brokenBlock.getLocation(), 0.0F);
    brokenBlock.getWorld().playSound(brokenBlock.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 0.3F, 1F);

    for (int x = -1; x <= 1; x++) {
      for (int y = -1; y <= 1; y++) {
        for (int z = -1; z <= 1; z++) {
          if (x == 0 && y == 0 && z == 0) {
            continue;
          }

          Block b = brokenBlock.getRelative(x, y, z);

          if (MaterialTools.getBreakableByShovel().contains(b.getType()) && Slimefun.getProtectionManager().hasPermission(player, b.getLocation(), ProtectableAction.BREAK_BLOCK)) {
            Slimefun.getProtectionManager().logAction(player, b, ProtectableAction.BREAK_BLOCK);

            b.getWorld().playEffect(b.getLocation(), Effect.STEP_SOUND, b.getType());

            for (ItemStack drop : b.getDrops()) {
              if (drop != null) {
                b.getWorld().dropItemNaturally(b.getLocation(), drop);
              }
            }

            b.setType(Material.AIR);
            damageItem(player, item);
          }
        }
      }
    }
  }

  @Override
  public boolean isDamageable() {
    return damageOnUse;
  }

}
