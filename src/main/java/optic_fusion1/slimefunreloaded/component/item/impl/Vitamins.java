package optic_fusion1.slimefunreloaded.component.item.impl;

import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.component.RecipeType;
import optic_fusion1.slimefunreloaded.component.item.SlimefunReloadedItem;
import optic_fusion1.slimefunreloaded.util.ItemUtils;
import optic_fusion1.slimefunreloaded.util.SlimefunReloadedItemStack;
import org.bukkit.GameMode;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Vitamins extends SlimefunReloadedItem {

  public Vitamins(NamespacedKey key, Category category, ItemStack item, RecipeType recipeType, ItemStack[] recipe) {
    super(key, category, item, recipeType, recipe);
  }

  public Vitamins(NamespacedKey key, Category category, ItemStack item, RecipeType recipeType, ItemStack[] recipe, String[] keys, Object[] values) {
    super(key, category, item, recipeType, recipe, keys, values);
  }

  @Override
  public boolean onInteract(Player player, ItemStack item, Action action, Block clickedBlock) {
    if (action == Action.RIGHT_CLICK_BLOCK || action == Action.RIGHT_CLICK_AIR) {
      if (player.getGameMode() != GameMode.CREATIVE) {
        ItemUtils.consumeItem(item, false);
      }
      player.getWorld().playSound(player.getLocation(), Sound.ENTITY_GENERIC_EAT, 1, 1);
      if (player.hasPotionEffect(PotionEffectType.POISON)) {
        player.removePotionEffect(PotionEffectType.POISON);
      }
      if (player.hasPotionEffect(PotionEffectType.WITHER)) {
        player.removePotionEffect(PotionEffectType.WITHER);
      }
      if (player.hasPotionEffect(PotionEffectType.SLOW)) {
        player.removePotionEffect(PotionEffectType.SLOW);
      }
      if (player.hasPotionEffect(PotionEffectType.SLOW_DIGGING)) {
        player.removePotionEffect(PotionEffectType.SLOW_DIGGING);
      }
      if (player.hasPotionEffect(PotionEffectType.WEAKNESS)) {
        player.removePotionEffect(PotionEffectType.WEAKNESS);
      }
      if (player.hasPotionEffect(PotionEffectType.CONFUSION)) {
        player.removePotionEffect(PotionEffectType.CONFUSION);
      }
      if (player.hasPotionEffect(PotionEffectType.BLINDNESS)) {
        player.removePotionEffect(PotionEffectType.BLINDNESS);
      }
      player.setFireTicks(0);
      player.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 1, 2));
      //e.setCancelled(true);
      return true;
    }
    return false;
  }

}
