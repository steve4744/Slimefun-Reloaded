package optic_fusion1.slimefunreloaded.item.food.impl;

import java.util.List;
import java.util.Random;
import optic_fusion1.slimefunreloaded.item.food.SlimefunReloadedFoodItem;
import optic_fusion1.slimefunreloaded.util.I18n;
import optic_fusion1.slimefunreloaded.util.StringUtils;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class FortuneCookie extends SlimefunReloadedFoodItem {

  private Random random = new Random();
  
  public FortuneCookie(ItemStack item, String id) {
    super(item, id, 0);
  }

  @Override
  public void onConsume(ItemStack item, Player player) {
    if (item.isSimilar(getItem())) {
      List<String> messages = I18n.getMessages("messages.fortune-cookie");
      String message = messages.get(random.nextInt(messages.size()));
      player.sendMessage(StringUtils.color(message));
    }
  }

}
