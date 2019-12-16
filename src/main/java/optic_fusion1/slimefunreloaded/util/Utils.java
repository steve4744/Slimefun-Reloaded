package optic_fusion1.slimefunreloaded.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Objects;
import optic_fusion1.slimefunreloaded.util.material.MaterialCollections;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;

public final class Utils {

  private Utils() {
  }

  public static FileConfiguration inputStreamToFileConfiguration(InputStream input) throws UnsupportedEncodingException {
    return YamlConfiguration.loadConfiguration(new BufferedReader(new InputStreamReader(input, "UTF-8")));
  }

  public static void requireNonNull(Object... objects) {
    for (int i = 0; i < objects.length; i++) {
      if (objects[i] == null) {
        throw new NullPointerException("Array Number " + i + " is null");
      }
    }
  }

  public static void consumeItem(ItemStack item, boolean replaceConsumables) {
    consumeItem(item, 1, replaceConsumables);
  }

  public static void consumeItem(ItemStack item, int amount, boolean replaceConsumables) {
    Objects.requireNonNull(item, "Required item, received null instead");
    if (item.getType() != Material.AIR && item.getAmount() > 0) {
      if (MaterialCollections.getAllFilledBuckets().contains(item.getType()) && replaceConsumables) {
        item.setType(Material.BUCKET);
        item.setAmount(1);
      } else if (item.getType() == Material.POTION && replaceConsumables) {
        item.setType(Material.GLASS_BOTTLE);
        item.setAmount(1);
      } else if (item.getAmount() <= amount) {
        item.setAmount(0);
      } else {
        item.setAmount(item.getAmount() - amount);
      }
    }
  }

}
