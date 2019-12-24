package optic_fusion1.slimefunreloaded.listener;

import optic_fusion1.slimefunreloaded.util.PlayerProfile;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {

  @EventHandler
  public void on(PlayerQuitEvent event) {
    Player player = event.getPlayer();
    if (PlayerProfile.isLoaded(player.getUniqueId())) {
      PlayerProfile.get(player).markForDeletion();
    }
  }

}
