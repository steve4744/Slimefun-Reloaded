package optic_fusion1.slimefunreloaded.protection.modules;

import com.massivecraft.factions.entity.Faction;
import com.massivecraft.factions.entity.BoardColl;
import com.massivecraft.factions.entity.MPlayer;
import com.massivecraft.massivecore.ps.PS;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import optic_fusion1.slimefunreloaded.protection.ProtectableAction;
import optic_fusion1.slimefunreloaded.protection.ProtectionModule;

public class FactionsProtectionModule implements ProtectionModule {

  private BoardColl board;

  @Override
  public void load() {
    board = BoardColl.get();
  }

  @Override
  public boolean hasPermission(OfflinePlayer p, Location l, ProtectableAction action) {
    Faction faction = board.getFactionAt(PS.valueOf(l));
    if (faction == null || faction.getId().equals("none")) {
      return true;
    }
    if (!(p instanceof Player)) {
      return false;
    }

    MPlayer mp = MPlayer.get(p);
    return faction.getId().equals(mp.getFaction().getId());
  }

  @Override
  public String getName() {
    return "Factions";
  }

}
