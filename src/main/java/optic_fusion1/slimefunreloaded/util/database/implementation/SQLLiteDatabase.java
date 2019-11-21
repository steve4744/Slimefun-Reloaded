package optic_fusion1.slimefunreloaded.util.database.implementation;

import java.io.File;
import optic_fusion1.slimefunreloaded.util.database.Database.DatabaseLoader;
import optic_fusion1.slimefunreloaded.util.database.LocalSQLDatabase;
import org.bukkit.plugin.Plugin;

public class SQLLiteDatabase extends LocalSQLDatabase<SQLLiteDatabase> {

  public SQLLiteDatabase(Plugin plugin, String name, DatabaseLoader<SQLLiteDatabase> callback) {
    super(plugin, name, callback);
  }

  @Override
  public String getType() {
    return "SQLLite";
  }

  @Override
  public String getIP() {
    return "jdbc:sqlite:" + new File("plugins/" + plugin.getName(), this.name + ".db").getAbsolutePath();
  }

  @Override
  public String getDriver() {
    return "org.sqlite.JDBC";
  }
}
