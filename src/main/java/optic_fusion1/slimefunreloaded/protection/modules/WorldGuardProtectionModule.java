package optic_fusion1.slimefunreloaded.protection.modules;

import java.util.Set;

import org.bukkit.Location;
import org.bukkit.OfflinePlayer;

import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldguard.LocalPlayer;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.internal.platform.WorldGuardPlatform;
import com.sk89q.worldguard.protection.flags.Flags;
import com.sk89q.worldguard.protection.flags.StateFlag;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import com.sk89q.worldguard.protection.regions.RegionContainer;

import optic_fusion1.slimefunreloaded.protection.ProtectableAction;
import static optic_fusion1.slimefunreloaded.protection.ProtectableAction.ACCESS_INVENTORIES;
import static optic_fusion1.slimefunreloaded.protection.ProtectableAction.BREAK_BLOCK;
import static optic_fusion1.slimefunreloaded.protection.ProtectableAction.PLACE_BLOCK;
import static optic_fusion1.slimefunreloaded.protection.ProtectableAction.PVP;
import optic_fusion1.slimefunreloaded.protection.ProtectionModule;

public class WorldGuardProtectionModule implements ProtectionModule {

  private WorldGuardPlugin worldguard;
  private WorldGuardPlatform platform;
  private RegionContainer container;

  @Override
  public void load() {
    worldguard = WorldGuardPlugin.inst();
    platform = WorldGuard.getInstance().getPlatform();
    container = platform.getRegionContainer();
  }

  @Override
  public String getName() {
    return "WorldGuard";
  }

  @Override
  public boolean hasPermission(OfflinePlayer p, Location l, ProtectableAction action) {
    com.sk89q.worldedit.util.Location loc = BukkitAdapter.adapt(l);
    com.sk89q.worldedit.world.World world = BukkitAdapter.adapt(l.getWorld());
    LocalPlayer player = worldguard.wrapOfflinePlayer(p);

    /*
		if (platform.getSessionManager().hasBypass(player, world)) {
			return true;
		}
     */
    if (!action.isBlockAction()) {
      Set<ProtectedRegion> regions = container.get(world).getApplicableRegions(BlockVector3.at(l.getX(), l.getY(), l.getZ())).getRegions();

      if (regions.isEmpty()) {
        return true;
      } else {
        return container.createQuery().testState(loc, player, convert(action));
      }
    } else {
      return container.createQuery().testBuild(loc, player, convert(action));
    }
  }

  private StateFlag convert(ProtectableAction action) {
    switch (action) {
      case PVP:
        return Flags.PVP;
      case ACCESS_INVENTORIES:
        return Flags.USE;
      case BREAK_BLOCK:
        return Flags.BLOCK_BREAK;
      case PLACE_BLOCK:
        return Flags.BLOCK_PLACE;
      default:
        return Flags.BUILD;
    }
  }
}
