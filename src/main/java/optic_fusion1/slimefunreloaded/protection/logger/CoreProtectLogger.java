package optic_fusion1.slimefunreloaded.protection.logger;

import optic_fusion1.slimefunreloaded.protection.ProtectableAction;
import static optic_fusion1.slimefunreloaded.protection.ProtectableAction.ACCESS_INVENTORIES;
import static optic_fusion1.slimefunreloaded.protection.ProtectableAction.BREAK_BLOCK;
import static optic_fusion1.slimefunreloaded.protection.ProtectableAction.PLACE_BLOCK;
import optic_fusion1.slimefunreloaded.protection.ProtectionLogger;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.block.Block;
import net.coreprotect.CoreProtect;
import net.coreprotect.CoreProtectAPI;

public class CoreProtectLogger implements ProtectionLogger {

  private CoreProtectAPI coreprotect;

  @Override
  public void load() {
    coreprotect = ((CoreProtect) Bukkit.getPluginManager().getPlugin("CoreProtect")).getAPI();
  }

  @Override
  public String getName() {
    return "CoreProtect";
  }

  @Override
  public void logAction(OfflinePlayer p, Block b, ProtectableAction action) {
    switch (action) {
      case ACCESS_INVENTORIES:
        coreprotect.logContainerTransaction(p.getName(), b.getLocation());
        break;
      case BREAK_BLOCK:
        coreprotect.logRemoval(p.getName(), b.getLocation(), b.getType(), b.getBlockData());
        break;
      case PLACE_BLOCK:
        coreprotect.logPlacement(p.getName(), b.getLocation(), b.getType(), b.getBlockData());
        break;
      default:
        break;
    }
  }

}
