package optic_fusion1.slimefunreloaded.protection.modules;

import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import net.sacredlabyrinth.Phaed.PreciousStones.PreciousStones;
import net.sacredlabyrinth.Phaed.PreciousStones.api.IApi;
import net.sacredlabyrinth.Phaed.PreciousStones.field.FieldFlag;
import optic_fusion1.slimefunreloaded.protection.ProtectableAction;
import static optic_fusion1.slimefunreloaded.protection.ProtectableAction.ACCESS_INVENTORIES;
import static optic_fusion1.slimefunreloaded.protection.ProtectableAction.BREAK_BLOCK;
import static optic_fusion1.slimefunreloaded.protection.ProtectableAction.PLACE_BLOCK;
import static optic_fusion1.slimefunreloaded.protection.ProtectableAction.PVP;
import optic_fusion1.slimefunreloaded.protection.ProtectionModule;

public class PreciousStonesProtectionModule implements ProtectionModule {

  private IApi api;

  @Override
  public void load() {
    api = PreciousStones.API();
  }

  @Override
  public String getName() {
    return "PreciousStones";
  }

  @Override
  public boolean hasPermission(OfflinePlayer p, Location l, ProtectableAction action) {
    if (!(p instanceof Player)) {
      return false;
    }

    switch (action) {
      case PVP:
        return !api.flagAppliesToPlayer((Player) p, FieldFlag.PREVENT_PVP, l);
      case BREAK_BLOCK:
        return api.canBreak((Player) p, l);
      case ACCESS_INVENTORIES:
      case PLACE_BLOCK:
        return api.canPlace((Player) p, l);
      default:
        return false;
    }
  }
}
