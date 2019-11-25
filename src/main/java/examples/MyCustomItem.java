package examples;

import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.component.item.SlimefunReloadedItem;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class MyCustomItem extends SlimefunReloadedItem {

  public MyCustomItem(NamespacedKey key, Category category, ItemStack item) {
    super(key, category, item);
  }

  @Override
  public void onBreak(Player player, ItemStack item) {
    player.sendMessage("I broke");
  }

  @Override
  public boolean onDrop(Player player, ItemStack item) {
    player.sendMessage("You dropped me");
    return true;
  }

  @Override
  public void onPickup(Player player, ItemStack item) {
    player.sendMessage("You picked me up");
  }

  @Override
  public boolean onInteract(Player player, ItemStack item) {
    player.sendMessage("You interacted with me");
    return true;
  }

}
