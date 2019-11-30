package optic_fusion1.slimefunreloaded.component.item.impl;

import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.component.RecipeType;
import optic_fusion1.slimefunreloaded.component.item.SlimefunReloadedItem;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemStack;

public class TelepositionScroll extends SlimefunReloadedItem {

  public TelepositionScroll(NamespacedKey key, Category category, ItemStack item, RecipeType recipeType, ItemStack[] recipe) {
    super(key, category, item, recipeType, recipe);
  }

  @Override
  public boolean onInteract(Player player, ItemStack item, Action action, Block clickedBlock) {
    for (Entity entity : player.getNearbyEntities(10.0, 10.0, 10.0)) {
      if (entity instanceof LivingEntity && !(entity instanceof ArmorStand) && entity.getUniqueId().equals(player.getUniqueId())) {
        float yaw = entity.getLocation().getYaw() + 180.0F;
        if (yaw > 360.0F) {
          yaw = yaw - 360.0F;
        }
        Location newLocation = entity.getLocation();
        newLocation.setYaw(yaw);
        entity.teleport(newLocation);
      }
    }
    return true;
  }

}
