package optic_fusion1.slimefunreloaded.protection.modules;

import com.wasteofplastic.askyblock.ASkyBlockAPI;
import com.wasteofplastic.askyblock.Island;
import java.util.UUID;
import optic_fusion1.slimefunreloaded.protection.ProtectableAction;
import optic_fusion1.slimefunreloaded.protection.ProtectionModule;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;

public class ASkyBlockProtectionModule implements ProtectionModule {

  private ASkyBlockAPI api;

  @Override
  public void load() {
    api = ASkyBlockAPI.getInstance();
  }

  @Override
  public boolean hasPermission(OfflinePlayer p, Location l, ProtectableAction action) {
    Island island = api.getIslandAt(l);
    if (island == null) {
      return true;
    }
    if (p.getUniqueId().equals(island.getOwner())) {
      return true;
    }

    for (UUID member : island.getMembers()) {
      if (p.getUniqueId().equals(member)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public String getName() {
    return "ASkyBlock";
  }

}
