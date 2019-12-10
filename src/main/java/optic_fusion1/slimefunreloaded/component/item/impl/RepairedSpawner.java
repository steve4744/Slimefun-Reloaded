package optic_fusion1.slimefunreloaded.component.item.impl;

import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.component.RecipeType;
import optic_fusion1.slimefunreloaded.component.item.SlimefunReloadedPlaceableItem;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class RepairedSpawner extends SlimefunReloadedPlaceableItem {

  public RepairedSpawner(NamespacedKey key, Category category, ItemStack item, RecipeType recipeType, ItemStack[] recipe) {
    super(key, category, item, recipeType, recipe);
  }

  public RepairedSpawner(NamespacedKey key, Category category, ItemStack item, RecipeType recipeType, ItemStack[] recipe, String[] keys, Object[] values) {
    super(key, category, item, recipeType, recipe, keys, values);
  }

  @Override
  public void onPlace(Player player, ItemStack item, Block block) {
    EntityType type = null;

    for (String line : item.getItemMeta().getLore()) {
      if (ChatColor.stripColor(line).startsWith("Type: ") && !line.contains("<Type>")) {
        type = EntityType.valueOf(ChatColor.stripColor(line).replace("Type: ", "").replace(' ', '_').toUpperCase());
      }
    }

    if (type != null) {
      CreatureSpawner spawner = (CreatureSpawner) block.getState();
      spawner.setSpawnedType(type);
      spawner.update(true, false);
    }

  }

}
