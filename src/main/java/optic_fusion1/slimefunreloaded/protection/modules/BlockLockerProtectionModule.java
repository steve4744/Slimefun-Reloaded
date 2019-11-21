package optic_fusion1.slimefunreloaded.protection.modules;

import com.google.common.base.Optional;
import nl.rutgerkok.blocklocker.BlockLockerAPI;
import nl.rutgerkok.blocklocker.BlockLockerPlugin;
import nl.rutgerkok.blocklocker.profile.Profile;
import nl.rutgerkok.blocklocker.protection.Protection;
import optic_fusion1.slimefunreloaded.protection.ProtectableAction;
import optic_fusion1.slimefunreloaded.protection.ProtectionModule;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;

public class BlockLockerProtectionModule implements ProtectionModule {

  private BlockLockerPlugin plugin;

  @Override
  public void load() {
    plugin = BlockLockerAPI.getPlugin();
  }

  @Override
  public String getName() {
    return "BlockLocker";
  }

  @Override
  public boolean hasPermission(OfflinePlayer p, Location l, ProtectableAction action) {
    if (!action.isBlockAction()) {
      return true;
    }

    Optional<Protection> protection = plugin.getProtectionFinder().findProtection(l.getBlock());

    if (protection.isPresent()) {
      Profile profile = plugin.getProfileFactory().fromNameAndUniqueId(p.getName(), Optional.of(p.getUniqueId()));
      return protection.get().isAllowed(profile);
    } else {
      return true;
    }

  }
}
