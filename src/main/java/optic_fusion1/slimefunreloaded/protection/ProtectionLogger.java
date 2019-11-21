package optic_fusion1.slimefunreloaded.protection;

import org.bukkit.OfflinePlayer;
import org.bukkit.block.Block;

public interface ProtectionLogger {

  void load();

  String getName();

  void logAction(OfflinePlayer p, Block b, ProtectableAction action);

}
