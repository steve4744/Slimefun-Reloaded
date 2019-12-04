package optic_fusion1.slimefunreloaded.component.item.impl;

import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.component.RecipeType;
import optic_fusion1.slimefunreloaded.component.item.SlimefunReloadedItem;
import optic_fusion1.slimefunreloaded.util.SlimefunReloadedItems;
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
    //e.getParentEvent().setCancelled(true);
    if (player.getInventory().getHelmet() != null && player.getInventory().getChestplate() != null && player.getInventory().getLeggings() != null && player.getInventory().getBoots() != null && player.getInventory().getHelmet().isSimilar(SlimefunReloadedItems.ENDER_HELMET) && player.getInventory().getChestplate().isSimilar(SlimefunReloadedItems.ENDER_CHESTPLATE) && player.getInventory().getLeggings().isSimilar(SlimefunReloadedItems.ENDER_LEGGINGS) && player.getInventory().getBoots().isSimilar(SlimefunReloadedItems.ENDER_BOOTS)) {
      player.launchProjectile(EnderPearl.class);
      player.getWorld().playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1, 1);
    }
    return true;
  }

}
