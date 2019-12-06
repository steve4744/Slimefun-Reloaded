package optic_fusion1.slimefunreloaded.util;

import java.lang.reflect.Method;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;

public final class StringUtils {

  private static Method copy, getName, toString;

  static {
    try {
      copy = ReflectionUtils.getClass(PackageName.OBC, "inventory.CraftItemStack").getMethod("asNMSCopy", ItemStack.class);
      getName = ReflectionUtils.getMethod(ReflectionUtils.getClass(PackageName.NMS, "ItemStack"), "getName");

      if (ReflectionUtils.isVersion("v1_13_", "v1_14_")) {
        toString = ReflectionUtils.getMethod(ReflectionUtils.getClass(PackageName.NMS, "IChatBaseComponent"), "getString");
      }
    } catch (Exception x) {
      x.printStackTrace();
    }
  }

  private StringUtils() {
  }

  /**
   * This is just a simple shortcut for: <code>ChatColor.translateAlternateColorCodes('&amp;', input)</code>
   *
   * @param input	The String that should be colored
   * @return	The colored String
   */
  public static String color(String input) {
    return ChatColor.translateAlternateColorCodes('&', input);
  }

  /**
   * This method colors the given String in alternating Colors. <code>ChatColors.alternating("Hello World", ChatColor.YELLOW, ChatColor.RED)</code> will yield a String where each letter is yellow or red (in alternating patterns).
   *
   * @param text	The String that should be colored
   * @param colors	The Colors that should be applied
   * @return	The colored String
   */
  public static String alternating(String text, ChatColor... colors) {
    int i = 0;
    StringBuilder builder = new StringBuilder(text.length() * 3);

    for (char c : text.toCharArray()) {
      builder.append(c).append(colors[i % colors.length].toString());
      i++;
    }

    return builder.toString();
  }

  public static String christmas(String string) {
    StringBuilder xmas = new StringBuilder("");
    for (int i = 0; i < string.length(); i++) {
      xmas.append((i % 2 == 0 ? "&a" : "&c"));
      xmas.append(string.charAt(i));
    }
    return ChatColor.translateAlternateColorCodes('&', xmas.toString());
  }

  public static String format(String string) {
    string = string.toLowerCase();
    StringBuilder builder = new StringBuilder();
    int i = 0;
    for (String s : string.split("_")) {
      if (i == 0) {
        builder.append(Character.toUpperCase(s.charAt(0))).append(s.substring(1));
      } else {
        builder.append(" ").append(Character.toUpperCase(s.charAt(0))).append(s.substring(1));
      }
      i++;
    }
    return builder.toString();
  }

  public static String formatItemName(ItemStack item, boolean includePlural) {
    String name = item.getType().toString();
    try {
      Object instance = copy.invoke(null, item);

      if (toString == null) {
        name = (String) getName.invoke(instance);
      } else {
        name = (String) toString.invoke(getName.invoke(instance));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    if (item.hasItemMeta() && item.getItemMeta().hasDisplayName()) {
      name = item.getItemMeta().getDisplayName();
    }
    if (includePlural) {
      name = item.getAmount() + " " + name + "/s";
    }
    return name;
  }

  public static boolean equals(String string, String... equal) {
    for (String s : equal) {
      if (string.equals(s)) {
        return true;
      }
    }
    return false;
  }

}
