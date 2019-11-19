package optic_fusion1.slimefunreloaded.updater;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import javax.net.ssl.HttpsURLConnection;
import static optic_fusion1.slimefunreloaded.updater.Updater.UpdateResult.UPDATE_AVAILABLE;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * The Class Updater.
 */
public class Updater {

  /**
   * The Enum UpdateResult.
   */
  public enum UpdateResult {

    /**
     * The bad resourceid.
     */
    BAD_RESOURCEID,
    /**
     * The disabled.
     */
    DISABLED,
    /**
     * The fail noversion.
     */
    FAIL_NOVERSION,
    /**
     * The fail spigot.
     */
    FAIL_SPIGOT,
    /**
     * The no update.
     */
    NO_UPDATE,
    /**
     * The update available.
     */
    UPDATE_AVAILABLE
  }

  /**
   * The old version.
   */
  private String oldVersion;

  /**
   * The plugin.
   */
  private JavaPlugin plugin;

  /**
   * The resource id.
   */
  private String RESOURCE_ID = "";

  /**
   * The result.
   */
  private Updater.UpdateResult result = Updater.UpdateResult.DISABLED;

  /**
   * The version.
   */
  private String version;

  /**
   * Instantiates a new updater.
   *
   * @param plugin the plugin
   * @param resourceId the resource id
   * @param disabled the disabled
   */
  public Updater(JavaPlugin plugin, int resourceId, boolean disabled) {
    RESOURCE_ID = resourceId + "";
    this.plugin = plugin;
    oldVersion = this.plugin.getDescription().getVersion();

    if (disabled || resourceId == -1) {
      result = UpdateResult.DISABLED;
      return;
    }

    run();
  }

  /**
   * Gets the result.
   *
   * @return the result
   */
  public UpdateResult getResult() {
    return result;
  }

  /**
   * Gets the version.
   *
   * @return the version
   */
  public String getVersion() {
    return version;
  }

  /**
   * Gets the old version.
   *
   * @return the version
   */
  public String getOldVersion() {
    return oldVersion;
  }

  private void run() {
    try {
      HttpsURLConnection connection = (HttpsURLConnection) new URL(
       "https://api.spigotmc.org/legacy/update.php?resource=" + RESOURCE_ID).openConnection();
      int timed_out = 2000;
      connection.setConnectTimeout(timed_out);
      connection.setReadTimeout(timed_out);
      this.version = new BufferedReader(new InputStreamReader(connection.getInputStream())).readLine();
      connection.disconnect();
      versionCheck();
      return;
    } catch (Exception e) {
      result = UpdateResult.FAIL_SPIGOT;
    }
    result = UpdateResult.FAIL_SPIGOT;
  }

  /**
   * Should update.
   *
   * @param localVersion the local version
   * @param remoteVersion the remote version
   * @return true, if successful
   */
  public boolean shouldUpdate(String localVersion, String remoteVersion) {
    return versionCompare(localVersion, remoteVersion) == 2;
  }

  /**
   * Version check.
   */
  private void versionCheck() {
    if (shouldUpdate(oldVersion, version)) {
      result = UpdateResult.UPDATE_AVAILABLE;
    } else {
      result = UpdateResult.NO_UPDATE;
    }
  }

  /**
   * Compares two version strings.
   *
   * Use this instead of String.compareTo() for a non-lexicographical comparison that works for version strings. e.g. "1.10".compareTo("1.6").
   *
   * @param v1 a string of alpha numerals separated by decimal points.
   * @param v2 a string of alpha numerals separated by decimal points.
   * @return The result is 1 if v1 is greater than v2. The result is 2 if v2 is greater than v1. The result is -1 if the version format is unrecognized. The result is zero if the strings are equal.
   */
  public int versionCompare(String v1, String v2) {
    int v1Len = StringUtils.countMatches(v1, ".");
    int v2Len = StringUtils.countMatches(v2, ".");

    if (v1Len != v2Len) {
      int count = Math.abs(v1Len - v2Len);
      if (v1Len > v2Len) {
        for (int i = 1; i <= count; i++) {
          v2 += ".0";
        }
      } else {
        for (int i = 1; i <= count; i++) {
          v1 += ".0";
        }
      }
    }

    if (v1.equals(v2)) {
      return 0;
    }

    String[] v1Str = StringUtils.split(v1, ".");
    String[] v2Str = StringUtils.split(v2, ".");
    for (int i = 0; i < v1Str.length; i++) {
      String str1 = "", str2 = "";
      for (char c : v1Str[i].toCharArray()) {
        if (Character.isLetter(c)) {
          int u = c - 'a' + 1;
          if (u < 10) {
            str1 += String.valueOf("0" + u);
          } else {
            str1 += String.valueOf(u);
          }
        } else {
          str1 += String.valueOf(c);
        }
      }
      for (char c : v2Str[i].toCharArray()) {
        if (Character.isLetter(c)) {
          int u = c - 'a' + 1;
          if (u < 10) {
            str2 += String.valueOf("0" + u);
          } else {
            str2 += String.valueOf(u);
          }
        } else {
          str2 += String.valueOf(c);
        }
      }
      v1Str[i] = "1" + str1;
      v2Str[i] = "1" + str2;

      int num1 = Integer.parseInt(v1Str[i]);
      int num2 = Integer.parseInt(v2Str[i]);

      if (num1 != num2) {
        if (num1 > num2) {
          return 1;
        } else {
          return 2;
        }
      }
    }
    return -1;
  }

  public void downloadUpdate() {
    if (result == UPDATE_AVAILABLE) {
      download(plugin, Integer.valueOf(RESOURCE_ID));
      plugin.getLogger().info("Downloaded jar automatically, restart to update. Note: Updates take 30-40 minutes to load");
    }
  }

  public boolean download(Plugin plugin, int resourceId) {
    try {
      download(new URL("https://api.spiget.org/v2/resources/" + resourceId + "/download"),
       new File(Bukkit.getServer().getUpdateFolderFile(), plugin.getDescription().getName() + ".jar"));
      return true;
    } catch (IOException e) {
      plugin.getLogger().warning("Unable to download jar");
      e.printStackTrace();
      return false;
    }
  }

  private void download(URL url, File target) throws IOException {
    target.getParentFile().mkdirs();
    target.createNewFile();
    ReadableByteChannel rbc = Channels.newChannel(url.openStream());
    FileOutputStream fos = new FileOutputStream(target);
    fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
    fos.close();
    rbc.close();
  }
}
