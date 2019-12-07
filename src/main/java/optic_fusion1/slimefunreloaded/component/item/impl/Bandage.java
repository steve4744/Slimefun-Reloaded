package optic_fusion1.slimefunreloaded.component.item.impl;

import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.component.RecipeType;
import optic_fusion1.slimefunreloaded.component.item.SlimefunReloadedItem;
import optic_fusion1.slimefunreloaded.util.CustomItem;
import optic_fusion1.slimefunreloaded.util.ItemUtils;
import optic_fusion1.slimefunreloaded.util.SlimefunReloadedItemStack;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Bandage extends SlimefunReloadedItem {

  public Bandage(NamespacedKey key, Category category, ItemStack item, RecipeType recipeType, ItemStack[] recipe) {
    super(key, category, item, recipeType, recipe);
  }

  public Bandage(NamespacedKey key, Category category, ItemStack item, RecipeType recipeType, ItemStack[] recipe, String[] keys, Object[] values) {
    super(key, category, item, recipeType, recipe, keys, values);
  }

  public Bandage(NamespacedKey key, Category category, ItemStack item, RecipeType recipeType, ItemStack[] recipe, CustomItem customItem, String[] keys, Object[] values) {
    super(key, category, item, recipeType, recipe, customItem, keys, values);
  }

  @Override
  public boolean onInteract(Player player, ItemStack item, Action action, Block clickedBlock) {
    if (action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
      if (player.getGameMode() != GameMode.CREATIVE) {
        ItemUtils.consumeItem(item, false);
      }
      player.getWorld().playEffect(player.getLocation(), Effect.STEP_SOUND, Material.WHITE_WOOL);
      player.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 1, 1));
      player.setFireTicks(0);
      return true;
    }
    return false;
  }

}
