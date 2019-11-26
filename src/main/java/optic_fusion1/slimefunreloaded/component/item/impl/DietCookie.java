package optic_fusion1.slimefunreloaded.component.item.impl;

import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.component.item.SlimefunReloadedConsumable;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;

public class DietCookie extends SlimefunReloadedConsumable {

  public DietCookie(NamespacedKey key, Category category, ItemStack item) {
    super(key, category, item);
  }

  @Override
  public boolean onConsume(Player player, ItemStack item) {
    player.sendMessage(ChatColor.YELLOW + "You feel so light...");
    player.playSound(player.getLocation(), Sound.ENTITY_GENERIC_EAT, 1, 1);
    if (player.hasPotionEffect(PotionEffectType.LEVITATION)) {
      player.removePotionEffect(PotionEffectType.LEVITATION);
    }
    player.addPotionEffect(PotionEffectType.LEVITATION.createEffect(60, 1));
    return true;
  }

}
