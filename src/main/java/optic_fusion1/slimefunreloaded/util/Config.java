package optic_fusion1.slimefunreloaded.util;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class Config {

  private File file;
  private FileConfiguration config;

  public Config(File file) {
    this.file = file;
    if (!file.exists()) {
      try {
        file.createNewFile();
      } catch (IOException ex) {
        Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    config = YamlConfiguration.loadConfiguration(file);
  }

  public File getFile() {
    return file;
  }

  public FileConfiguration getConfig() {
    return config;
  }

}
