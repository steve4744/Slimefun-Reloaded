package optic_fusion1.slimefunreloaded.util;

import java.io.UnsupportedEncodingException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.UnaryOperator;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import optic_fusion1.slimefunreloaded.Slimefun;
import optic_fusion1.slimefunreloaded.SlimefunReloaded;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class I18n {

  private static FileConfiguration config;
  private static transient Locale defaultLocale = Locale.getDefault();
  private static transient Locale currentLocale = defaultLocale;
  private static transient Map<String, MessageFormat> messageFormatCache = new HashMap<>();
  private static Pattern NODOUBLEMARK = Pattern.compile("''");
  private static final SlimefunReloaded SLIMEFUN_RELOADED = Slimefun.getSlimefunReloaded();
  private static final Logger LOGGER = SLIMEFUN_RELOADED.getLogger();

  public I18n() {
    updateLocale("en_US");
  }

  public Locale getCurrentLocale() {
    return currentLocale;
  }

  private static String translate(String string) {
    return config.getString(string);
  }

  public static void tl(Player player, String string) {
    player.sendMessage(tl(string));
  }

  public static void tl(Player player, String string, UnaryOperator<String> function) {
    player.sendMessage(tl(function.apply(string)));
  }

  public static void tl(Player player, String string, Object... objects) {
    player.sendMessage(tl(string, objects));
  }

  public static String tl(String string) {
    return tl(string, (Object[]) null);
  }

  public static String tl(String string, Object... objects) {
    if (objects == null || objects.length == 0) {
      return NODOUBLEMARK.matcher(translate(string)).replaceAll("'");
    } else {
      return format(string, objects);
    }
  }

  public static String format(String string, Object... objects) {
    String format = translate(string);
    MessageFormat messageFormat = messageFormatCache.get(format);
    if (messageFormat == null) {
      try {
        messageFormat = new MessageFormat(format);
      } catch (IllegalArgumentException e) {
        LOGGER.log(Level.SEVERE, "Invalid Translation key for ''{0}'':{1}", new Object[]{e.getMessage(), string});
        format = format.replaceAll("\\{(\\D*?)\\}", "\\[$1\\]");
        messageFormat = new MessageFormat(format);
      }
      messageFormatCache.put(format, messageFormat);
    }
    return messageFormat.format(objects).replace(' ', ' '); // replace nbsp with a space
  }

  public static void updateLocale(String loc) {
    if (loc != null && !loc.isEmpty()) {
      String[] parts = loc.split("[_\\.]");
      if (parts.length == 1) {
        currentLocale = new Locale(parts[0]);
      }
      if (parts.length == 2) {
        currentLocale = new Locale(parts[0], parts[1]);
      }
      if (parts.length == 3) {
        currentLocale = new Locale(parts[0], parts[1], parts[2]);
      }
    }
    messageFormatCache = new HashMap<>();
    LOGGER.log(Level.INFO, "Using locale {0}", currentLocale.toString());
    try {
      config = Utils.inputStreamToFileConfiguration(
       SLIMEFUN_RELOADED.getResource("messages_" + currentLocale.toString() + ".yml"));
    } catch (UnsupportedEncodingException ex) {
      Logger.getLogger(I18n.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public static String capitalCase(String input) {
    return input == null || input.length() == 0 ? input : input.toUpperCase(Locale.ENGLISH).charAt(0) + input.toLowerCase(Locale.ENGLISH).substring(1);
  }

  public static List<String> getMessages(String path) {
    return config.getStringList(path);
  }

}
