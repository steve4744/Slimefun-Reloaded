package optic_fusion1.slimefunreloaded.component.item.impl;

import optic_fusion1.slimefunreloaded.Slimefun;
import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.component.RecipeType;
import optic_fusion1.slimefunreloaded.component.item.SlimefunReloadedConsumeable;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class MonsterJerky extends SlimefunReloadedConsumeable {

  public MonsterJerky(NamespacedKey key, Category category, ItemStack item, RecipeType recipeType, ItemStack[] recipe) {
    super(key, category, item, recipeType, recipe);
  }

  @Override
  public boolean onConsume(Player player, ItemStack item) {
    Bukkit.getScheduler().runTaskLater(Slimefun.getSlimefunReloaded(), () -> {
      if (player.hasPotionEffect(PotionEffectType.HUNGER)) {
        player.removePotionEffect(PotionEffectType.HUNGER);
      }

      player.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 5, 0));
    }, 1L);
    return true;
  }

}
