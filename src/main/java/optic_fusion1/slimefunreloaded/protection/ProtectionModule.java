package optic_fusion1.slimefunreloaded.protection;

import org.bukkit.Location;
import org.bukkit.OfflinePlayer;

public interface ProtectionModule {

  void load();

  String getName();

  boolean hasPermission(OfflinePlayer p, Location l, ProtectableAction action);

}
