package optic_fusion1.slimefunreloaded.component.item.impl;

import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.component.RecipeType;
import optic_fusion1.slimefunreloaded.component.item.SlimefunReloadedItem;
import optic_fusion1.slimefunreloaded.util.DoubleHandler;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemStack;

public class Multimeter extends SlimefunReloadedItem {

  public Multimeter(NamespacedKey key, Category category, ItemStack item, RecipeType recipeType, ItemStack[] recipe) {
    super(key, category, item, recipeType, recipe);
  }

  @Override
  public boolean onInteract(Player player, ItemStack item, Action action, Block clickedBlock) {
    if (clickedBlock != null && ChargableBlock.isChargable(clickedBlock)) {
      player.sendMessage("");
      player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&bStored Energy: &3" + DoubleHandler.getFancyDouble(ChargableBlock.getCharge(clickedBlock)) + " J"));
      player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&bCapacity: &3" + DoubleHandler.getFancyDouble(ChargableBlock.getMaxCharge(clickedBlock)) + " J"));
      player.sendMessage("");
    }
    return true;
  }

}
