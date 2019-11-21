package optic_fusion1.slimefunreloaded.hooks;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import optic_fusion1.slimefunreloaded.Slimefun;
import org.apache.commons.lang.StringUtils;
import org.bukkit.entity.Player;

public class PlaceholderAPIHook extends PlaceholderExpansion {

  @Override
  public String getIdentifier() {
    return "slimefunreloaded";
  }

  @Override
  public String getPlugin() {
    return "Slimefun-Reloaded";
  }

  @Override
  public String getAuthor() {
    return StringUtils.join(Slimefun.getSlimefunReloaded().getDescription().getAuthors(), ", ");
  }

  @Override
  public String getVersion() {
    return Slimefun.getSlimefunReloaded().getDescription().getVersion();
  }

  @Override
  public String onPlaceholderRequest(Player p, String params) {
//    if (params.equals("researches_total_xp_levels_spent")) {
//      Stream<Research> stream = PlayerProfile.get(p).getResearches().stream();
//      return String.valueOf(stream.mapToInt(Research::getCost).sum());
//    }
//
//    if (params.equals("researches_total_researches_unlocked")) {
//      Set<Research> set = PlayerProfile.get(p).getResearches();
//      return String.valueOf(set.size());
//    }
//
//    if (params.equals("researches_total_researches")) {
//      return String.valueOf(Research.list());
//    }
//
//    if (params.equals("researches_percentage_researches_unlocked")) {
//      Set<Research> set = PlayerProfile.get(p).getResearches();
//      return String.valueOf(Math.round(((set.size() * 100.0F) / Research.list().size()) * 100.0F) / 100.0F);
//    }
//
//    if (params.equals("researches_title")) {
//      return PlayerProfile.get(p).getTitle();
//    }
//
//    if (params.equals("gps_complexity")) {
//      return String.valueOf(Slimefun.getGPSNetwork().getNetworkComplexity(p.getUniqueId()));
//    }
//
//    if (params.equals("timings_lag")) {
//      return SlimefunPlugin.getTicker().getTime() + "ms";
//    }

    return null;
  }

}
