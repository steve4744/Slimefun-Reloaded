package optic_fusion1.slimefunreloaded.component.item.impl;

import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.component.RecipeType;
import optic_fusion1.slimefunreloaded.component.item.SlimefunReloadedItem;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemStack;

public class MagicEyeOfEnder extends SlimefunReloadedItem {

  public MagicEyeOfEnder(NamespacedKey key, Category category, ItemStack item, RecipeType recipeType, ItemStack[] recipe) {
    super(key, category, item, recipeType, recipe);
  }

  @Override
  public boolean onInteract(Player player, ItemStack item, Action action, Block clickedBlock) {
    if (player.getInventory().getHelmet() != null && player.getInventory().getChestplate() != null && player.getInventory().getLeggings() != null && player.getInventory().getBoots() != null && SlimefunManager.isItemSimiliar(player.getInventory().getHelmet(), SlimefunReloadedItems.ENDER_HELMET, true) && SlimefunManager.isItemSimiliar(player.getInventory().getChestplate(), SlimefunReloadedItems.ENDER_CHESTPLATE, true) && SlimefunManager.isItemSimiliar(player.getInventory().getLeggings(), SlimefunReloadedItems.ENDER_LEGGINGS, true) && SlimefunManager.isItemSimiliar(player.getInventory().getBoots(), SlimefunReloadedItems.ENDER_BOOTS, true)) {
      player.launchProjectile(EnderPearl.class);
      player.getWorld().playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1, 1);
    }
    return true;
  }

}
