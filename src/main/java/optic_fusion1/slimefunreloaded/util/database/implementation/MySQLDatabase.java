package optic_fusion1.slimefunreloaded.util.database.implementation;

import optic_fusion1.slimefunreloaded.util.database.AuthenticatedSQLDatabase;
import optic_fusion1.slimefunreloaded.util.database.Database.DatabaseLoader;
import org.bukkit.plugin.Plugin;

public class MySQLDatabase extends AuthenticatedSQLDatabase<MySQLDatabase> {

  public MySQLDatabase(Plugin plugin, DatabaseLoader<MySQLDatabase> callback) {
    super(plugin, callback);
  }

  @Override
  public String getType() {
    return "MySQL";
  }

  @Override
  public int getDefaultPort() {
    return 3306;
  }

  @Override
  public String getDriver() {
    return "com.mysql.jdbc.Driver";
  }

  @Override
  public String getIP() {
    return "jdbc:mysql://" + this.host + ":" + this.port + "/" + this.database;
  }
}
