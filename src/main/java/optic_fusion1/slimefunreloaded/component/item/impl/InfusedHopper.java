package optic_fusion1.slimefunreloaded.component.item.impl;

import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.component.RecipeType;
import optic_fusion1.slimefunreloaded.component.SlimefunReloadedComponent;
import optic_fusion1.slimefunreloaded.component.TickableComponent;
import optic_fusion1.slimefunreloaded.util.BlockStorage;
import optic_fusion1.slimefunreloaded.util.Config;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class InfusedHopper extends SimpleSlimefunReloadedItem implements TickableComponent {

  public InfusedHopper(NamespacedKey key, Category category, ItemStack item, RecipeType recipeType, ItemStack[] recipe) {
    super(key, category, item, recipeType, recipe);
  }

  public InfusedHopper(NamespacedKey key, Category category, ItemStack item, RecipeType recipeType, ItemStack[] recipe, String[] keys, Object[] values) {
    super(key, category, item, recipeType, recipe, keys, values);
  }

  public InfusedHopper(NamespacedKey key, Category category, ItemStack item, RecipeType recipeType, ItemStack[] recipe, ItemStack recipeOutput) {
    super(key, category, item, recipeType, recipe, recipeOutput);
  }

  @Override
  public void tick(Block block, SlimefunReloadedComponent component, Config data) {
    if (block.getType() != Material.HOPPER) {
      //We're no longer a hopper, we were probably destroyed. Skipping this tick.
      BlockStorage.clearBlockInfo(block);
      return;
    }
    Location location = block.getLocation().add(0.5, 1.2, 0.5);
    boolean sound = false;
    for (Entity item : block.getWorld().getNearbyEntities(location, 3.5D, 3.5D, 3.5D, n -> n instanceof Item && n.isValid() && !n.hasMetadata("no_pickup") && n.getLocation().distanceSquared(location) > 0.1)) {
      item.setVelocity(new Vector(0, 0.1, 0));
      item.teleport(location);
      sound = true;
    }

    if (sound) {
      block.getWorld().playSound(block.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1F, 2F);
    }
  }

}
