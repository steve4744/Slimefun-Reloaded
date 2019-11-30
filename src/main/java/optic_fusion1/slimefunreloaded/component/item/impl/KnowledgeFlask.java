package optic_fusion1.slimefunreloaded.component.item.impl;

import optic_fusion1.slimefunreloaded.builder.ItemStackBuilder;
import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.component.RecipeType;
import optic_fusion1.slimefunreloaded.component.item.SlimefunReloadedItem;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.Container;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemStack;

public class KnowledgeFlask extends SlimefunReloadedItem {

  public KnowledgeFlask(NamespacedKey key, Category category, ItemStack item, RecipeType recipeType, ItemStack[] recipe) {
    super(key, category, item, recipeType, recipe);
  }

  @Override
  public boolean onInteract(Player player, ItemStack item, Action action, Block clickedBlock) {
    if (player.getLevel() >= 1) {
      if (clickedBlock == null || !(clickedBlock.getState() instanceof Container)) {
        player.setLevel(player.getLevel() - 1);
        player.getInventory().addItem(new ItemStackBuilder(Material.EXPERIENCE_BOTTLE)
         .setName("&aFlask of Knowledge").asBukkitItemStack());
        player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 0.5F);
        item.setAmount(item.getAmount() - 1);
      }
    }
    return true;
  }

}
