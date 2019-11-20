package optic_fusion1.slimefunreloaded.item.food.impl;

import optic_fusion1.slimefunreloaded.Slimefun;
import optic_fusion1.slimefunreloaded.item.food.SlimefunReloadedFoodItem;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class MonsterJerky extends SlimefunReloadedFoodItem {

  public MonsterJerky(ItemStack item, String id, int saturation) {
    super(item, id, saturation);
  }

  @Override
  public void onConsume(ItemStack item, Player player) {
    if (item.isSimilar(getItem())) {
      Bukkit.getScheduler().runTaskLater(Slimefun.getSlimefunReloaded(), () -> {
        if (player.hasPotionEffect(PotionEffectType.HUNGER)) {
          player.removePotionEffect(PotionEffectType.HUNGER);
        }

        player.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 5, 0));
      }, 1L);
    }
  }

}
