package optic_fusion1.slimefunreloaded.item.food.impl;

import optic_fusion1.slimefunreloaded.item.food.SlimefunReloadedFoodItem;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class MeatJerky extends SlimefunReloadedFoodItem {

  public MeatJerky(ItemStack item, String id, int saturation) {
    super(item, id, saturation);
  }

  @Override
  public void onConsume(ItemStack item, Player player) {
//    if (isItem(item)) {
//      player.setSaturation(getSaturation());
//    }
  }

}
