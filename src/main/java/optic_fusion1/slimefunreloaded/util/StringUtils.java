package optic_fusion1.slimefunreloaded.util;

import org.bukkit.ChatColor;

public final class StringUtils {

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

}
