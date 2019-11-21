package optic_fusion1.slimefunreloaded.util.database.implementation;

import optic_fusion1.slimefunreloaded.util.database.AuthenticatedSQLDatabase;
import optic_fusion1.slimefunreloaded.util.database.Database.DatabaseLoader;
import org.bukkit.plugin.Plugin;

public class PostgreSQLDatabase extends AuthenticatedSQLDatabase<PostgreSQLDatabase> {

  public PostgreSQLDatabase(Plugin plugin, DatabaseLoader<PostgreSQLDatabase> callback) {
    super(plugin, callback);
  }

  @Override
  public String getType() {
    return "PostgreSQL";
  }

  @Override
  public int getDefaultPort() {
    return 5432;
  }

  @Override
  public String getDriver() {
    return "org.postgresql.Driver";
  }

  @Override
  public String getIP() {
    return "jdbc:postgresql://" + this.host + ":" + this.port + "/" + this.database;
  }
}
