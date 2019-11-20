package optic_fusion1.slimefunreloaded.item.food.impl;

import optic_fusion1.slimefunreloaded.item.food.SlimefunReloadedFoodItem;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;

public class DietCookie extends SlimefunReloadedFoodItem {

  public DietCookie(ItemStack item, String id) {
    super(item, id, 0);
  }

  @Override
  public void handle(ItemStack item, Player player) {
    if (item.isSimilar(getItem())) {
      player.sendMessage(ChatColor.YELLOW + "You feel so light...");
      player.playSound(player.getLocation(), Sound.ENTITY_GENERIC_EAT, 1, 1);

      if (player.hasPotionEffect(PotionEffectType.LEVITATION)) {
        player.removePotionEffect(PotionEffectType.LEVITATION);
      }
      player.addPotionEffect(PotionEffectType.LEVITATION.createEffect(60, 1));
    }
  }

}
