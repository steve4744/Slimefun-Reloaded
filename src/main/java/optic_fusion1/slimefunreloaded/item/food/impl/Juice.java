package optic_fusion1.slimefunreloaded.item.food.impl;

import optic_fusion1.slimefunreloaded.item.food.SlimefunReloadedFoodItem;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Juice extends SlimefunReloadedFoodItem {

  public Juice(ItemStack item, String id, int saturation) {
    super(item, id, saturation);
  }

  @Override
  public void onConsume(ItemStack item, Player player) {
  }

}
