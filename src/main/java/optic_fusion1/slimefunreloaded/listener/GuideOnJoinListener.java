package optic_fusion1.slimefunreloaded.listener;

import optic_fusion1.slimefunreloaded.Slimefun;
import optic_fusion1.slimefunreloaded.SlimefunReloaded;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class GuideOnJoinListener implements Listener {

  public GuideOnJoinListener(SlimefunReloaded plugin) {
    plugin.getServer().getPluginManager().registerEvents(this, plugin);
  }

  @EventHandler
  public void onJoin(PlayerJoinEvent e) {
    if (!e.getPlayer().hasPlayedBefore()) {
      Player p = e.getPlayer();
      if (!Slimefun.getWhitelistConfig().getBoolean(p.getWorld().getName() + ".enabled")) {
        return;
      }
      if (!Slimefun.getWhitelistConfig().getBoolean(p.getWorld().getName() + ".enabled-items.SLIMEFUN_GUIDE")) {
        return;
      }

      SlimefunGuideLayout type = SlimefunReloaded.getCfg().getBoolean("guide.default-view-book") ? SlimefunGuideLayout.BOOK : SlimefunGuideLayout.CHEST;
      p.getInventory().addItem(SlimefunGuide.getItem(type));
    }
  }

}
