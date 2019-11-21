package optic_fusion1.slimefunreloaded.util.database.implementation;

import optic_fusion1.slimefunreloaded.util.database.AuthenticatedSQLDatabase;
import optic_fusion1.slimefunreloaded.util.database.Database.DatabaseLoader;
import org.bukkit.plugin.Plugin;

public class MariaDBDatabase extends AuthenticatedSQLDatabase<MariaDBDatabase> {

  public MariaDBDatabase(Plugin plugin, DatabaseLoader<MariaDBDatabase> callback) {
    super(plugin, callback);
  }

  @Override
  public String getType() {
    return "MariaDB";
  }

  @Override
  public int getDefaultPort() {
    return 3306;
  }

  @Override
  public String getDriver() {
    return "org.mariadb.jdbc.Driver";
  }

  @Override
  public String getIP() {
    return "jdbc:mariadb://" + this.host + ":" + this.port + "/" + this.database;
  }
}
