package optic_fusion1.slimefunreloaded.component.item.impl;

import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.component.item.SlimefunReloadedItem;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemStack;

public class EnderBackpack extends SlimefunReloadedItem {

  public EnderBackpack(NamespacedKey key, Category category, ItemStack item) {
    super(key, category, item);
  }

  @Override
  public boolean onInteract(Player player, ItemStack item, Action action, Block clickedBlock) {
    player.openInventory(player.getEnderChest());
    player.getWorld().playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1, 1);
    return true;
  }

}
