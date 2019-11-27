package optic_fusion1.slimefunreloaded.component.item.impl;

import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.component.item.SlimefunReloadedConsumeable;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class MeatJerky extends SlimefunReloadedConsumeable {

  private int saturation;

  public MeatJerky(int saturation, NamespacedKey key, Category category, ItemStack item) {
    super(key, category, item);
    this.saturation = saturation;
  }

  @Override
  public boolean onConsume(Player player, ItemStack item) {
    player.setSaturation(saturation);
    return true;
  }

}
