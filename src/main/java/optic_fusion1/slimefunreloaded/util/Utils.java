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

  public static boolean isInteger(String string) {
    try {
      int i = Integer.valueOf(string);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

}
