package optic_fusion1.slimefunreloaded.protection.modules;

import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import com.palmergames.bukkit.towny.object.TownyPermission.ActionType;
import com.palmergames.bukkit.towny.utils.PlayerCacheUtil;

import optic_fusion1.slimefunreloaded.protection.ProtectableAction;
import static optic_fusion1.slimefunreloaded.protection.ProtectableAction.ACCESS_INVENTORIES;
import static optic_fusion1.slimefunreloaded.protection.ProtectableAction.BREAK_BLOCK;
import static optic_fusion1.slimefunreloaded.protection.ProtectableAction.PLACE_BLOCK;
import static optic_fusion1.slimefunreloaded.protection.ProtectableAction.PVP;
import optic_fusion1.slimefunreloaded.protection.ProtectionModule;

public class TownyProtectionModule implements ProtectionModule {

  @Override
  public void load() {
    // We don't need to load any APIs, everything is static
  }

  @Override
  public String getName() {
    return "Towny";
  }

  @Override
  public boolean hasPermission(OfflinePlayer p, Location l, ProtectableAction action) {
    if (!(p instanceof Player)) {
      return false;
    }

    Player player = (Player) p;
    return PlayerCacheUtil.getCachePermission(player, l, l.getBlock().getType(), convert(action));
  }

  private ActionType convert(ProtectableAction action) {
    switch (action) {
      case ACCESS_INVENTORIES:
      case PVP:
        return ActionType.ITEM_USE;
      case BREAK_BLOCK:
        return ActionType.DESTROY;
      case PLACE_BLOCK:
      default:
        return ActionType.BUILD;
    }
  }

}
