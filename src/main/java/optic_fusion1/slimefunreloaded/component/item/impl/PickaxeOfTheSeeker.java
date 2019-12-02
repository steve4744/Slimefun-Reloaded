package optic_fusion1.slimefunreloaded.component.item.impl;

import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.component.RecipeType;
import optic_fusion1.slimefunreloaded.component.item.SlimefunReloadedItem;
import optic_fusion1.slimefunreloaded.component.item.interfaces.DamageableItem;
import optic_fusion1.slimefunreloaded.util.I18n;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemStack;

public class PickaxeOfTheSeeker extends SlimefunReloadedItem implements DamageableItem {

  public PickaxeOfTheSeeker(NamespacedKey key, Category category, ItemStack item, RecipeType recipeType, ItemStack[] recipe) {
    super(key, category, item, recipeType, recipe);
  }

  @Override
  public boolean onInteract(Player player, ItemStack item, Action action, Block clickedBlock) {
    Block closest = null;

    for (int x = -4; x <= 4; x++) {
      for (int y = -4; y <= 4; y++) {
        for (int z = -4; z <= 4; z++) {
          if (MaterialCollections.getAllOres().contains(player.getLocation().getBlock().getRelative(x, y, z).getType()) && (closest == null || player.getLocation().distanceSquared(closest.getLocation()) > player.getLocation().distanceSquared(player.getLocation().getBlock().getRelative(x, y, z).getLocation()))) {
            closest = player.getLocation().getBlock().getRelative(x, y, z);
          }
        }
      }
    }

    if (closest == null) {
      I18n.tl(player, "miner.no-ores");
    } else {
      double l = closest.getX() + 0.5 - player.getLocation().getX();
      double w = closest.getZ() + 0.5 - player.getLocation().getZ();
      float yaw;
      float pitch;
      double c = Math.sqrt(l * l + w * w);
      double alpha1 = -Math.asin(l / c) / Math.PI * 180;
      double alpha2 = Math.acos(w / c) / Math.PI * 180;
      if (alpha2 > 90) {
        yaw = (float) (180 - alpha1);
      } else {
        yaw = (float) alpha1;
      }
      pitch = (float) ((-Math.atan((closest.getY() - 0.5 - player.getLocation().getY()) / Math.sqrt(l * l + w * w))) * 180F / Math.PI);

      player.teleport(new Location(player.getWorld(), player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ(), yaw, pitch));
    }

    damageItem(player, item);
    return true;
  }

  @Override
  public boolean isDamageable() {
    return true;
  }

}
