package optic_fusion1.slimefunreloaded.component.item.impl;

import java.util.List;
import optic_fusion1.slimefunreloaded.Slimefun;
import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.component.RecipeType;
import optic_fusion1.slimefunreloaded.component.SlimefunReloadedComponent;
import optic_fusion1.slimefunreloaded.component.item.SlimefunReloadedItem;
import optic_fusion1.slimefunreloaded.component.item.interfaces.DamageableItem;
import optic_fusion1.slimefunreloaded.protection.ProtectableAction;
import optic_fusion1.slimefunreloaded.util.BlockStorage;
import optic_fusion1.slimefunreloaded.util.CustomItem;
import optic_fusion1.slimefunreloaded.util.StringUtils;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ExplosivePickaxe extends SlimefunReloadedItem implements DamageableItem {

  private String[] blacklist;
  private boolean damageOnUse;

  public ExplosivePickaxe(NamespacedKey key, Category category, ItemStack item, RecipeType recipeType, ItemStack[] recipe) {
    super(key, category, item, recipeType, recipe);
    damageOnUse = ((boolean) Slimefun.getItemValue(getID(), "damage-on-use"));

    List<?> list = (List<?>) Slimefun.getItemValue(getID(), "unbreakable-blocks");
    blacklist = list.toArray(new String[list.size()]);
  }

  @Override
  public void onBlockBreak(Player player, ItemStack item, Block brokenBlock, List<ItemStack> drops, int fortune) {
    World world = brokenBlock.getWorld();
    world.createExplosion(brokenBlock.getLocation(), 0.0F);
    world.playSound(brokenBlock.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 0.3F, 1F);
    for (int x = -1; x <= 1; x++) {
      for (int y = -1; y <= 1; y++) {
        for (int z = -1; z <= 1; z++) {
          if (x == 0 && y == 0 && z == 0) {
            continue;
          }

          Block b = brokenBlock.getRelative(x, y, z);

          if (b.getType() != Material.AIR && !b.isLiquid() && !StringUtils.equals(b.getType().toString(), blacklist) && Slimefun.getProtectionManager().hasPermission(player, b.getLocation(), ProtectableAction.BREAK_BLOCK)) {
            Slimefun.getProtectionManager().logAction(player, b, ProtectableAction.BREAK_BLOCK);

            b.getWorld().playEffect(b.getLocation(), Effect.STEP_SOUND, b.getType());
            SlimefunReloadedComponent sfItem = BlockStorage.check(b);
            boolean allow = false;

            if (sfItem != null && !(sfItem instanceof HandledBlock)) {
              if (Slimefun.getBlockHandlers().containsKey(sfItem.getID())) {
                allow = Slimefun.getBlockHandlers().get(sfItem.getID()).onBreak(player, brokenBlock, sfItem, UnregisterReason.PLAYER_BREAK);
              }
              if (allow) {
                drops.add(BlockStorage.retrieve(brokenBlock));
              }
            } else if (b.getType() == Material.PLAYER_HEAD) {
              b.breakNaturally();
            } else if (b.getType().name().endsWith("_SHULKER_BOX")) {
              b.breakNaturally();
            } else {
              for (ItemStack drop : b.getDrops()) {
                b.getWorld().dropItemNaturally(b.getLocation(), (b.getType().toString().endsWith("_ORE") && b.getType() != Material.IRON_ORE && b.getType() != Material.GOLD_ORE) ? new CustomItem(drop, fortune) : drop);
              }
              b.setType(Material.AIR);
            }

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
