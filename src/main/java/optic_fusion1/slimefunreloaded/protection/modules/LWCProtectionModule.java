package optic_fusion1.slimefunreloaded.protection.modules;

import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import com.griefcraft.lwc.LWC;

import optic_fusion1.slimefunreloaded.protection.ProtectableAction;
import optic_fusion1.slimefunreloaded.protection.ProtectionModule;

public class LWCProtectionModule implements ProtectionModule {

  private LWC lwc;

  @Override
  public void load() {
    lwc = LWC.getInstance();
  }

  @Override
  public String getName() {
    return "LWC";
  }

  @Override
  public boolean hasPermission(OfflinePlayer p, Location l, ProtectableAction action) {
    if (!action.isBlockAction()) {
      return true;
    }
    if (!lwc.isProtectable(l.getBlock())) {
      return true;
    }
    if (lwc.getProtectionCache().getProtection(l.getBlock()) == null) {
      return true;
    }

    return p instanceof Player && lwc.canAccessProtection((Player) p, l.getBlock());
  }
}
