package optic_fusion1.slimefunreloaded.listener;

import optic_fusion1.slimefunreloaded.Slimefun;
import optic_fusion1.slimefunreloaded.util.Config;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

//TODO: Finish this
public class GuideOnJoinListener implements Listener {

  @EventHandler
  public void onJoin(PlayerJoinEvent event) {
    if (!event.getPlayer().hasPlayedBefore()) {
      Player player = event.getPlayer();
      String worldName = player.getWorld().getName();
      Config whitelistConfig = Slimefun.getWhitelistConfig();
      if(!whitelistConfig.getBoolean(worldName + ".enabled")){
        return;
      }
      if(!whitelistConfig.getBoolean(worldName + ".enabled-items.SLIMEFUN_GUIDE")){
        return;
      }
//      SlimefunGuideLayout type = SlimefunPlugin.getCfg().getBoolean("guide.default-view-book") ? SlimefunGuideLayout.BOOK : SlimefunGuideLayout.CHEST;
//      p.getInventory().addItem(SlimefunGuide.getItem(type));
    }
  }

}
