package optic_fusion1.slimefunreloaded.util.database.implementation;

import java.io.File;
import optic_fusion1.slimefunreloaded.util.database.Database.DatabaseLoader;
import optic_fusion1.slimefunreloaded.util.database.LocalSQLDatabase;
import org.bukkit.plugin.Plugin;

public class H2Database extends LocalSQLDatabase<H2Database> {

  public H2Database(Plugin plugin, String name, DatabaseLoader<H2Database> callback) {
    super(plugin, name, callback);
  }

  @Override
  public String getType() {
    return "H2";
  }

  @Override
  public String getIP() {
    return "jdbc:h2:" + new File("plugins/" + plugin.getName(), this.name + ".db").getAbsolutePath();
  }

  @Override
  public String getDriver() {
    return "org.h2.Driver";
  }
}
