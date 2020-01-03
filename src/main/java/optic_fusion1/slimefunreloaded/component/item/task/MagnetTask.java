package optic_fusion1.slimefunreloaded.component.item.task;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;

public class MagnetTask extends SlimefunReloadedTask {

  public MagnetTask(Player player) {
    super(player);
  }

  @Override
  void executeTask() {
    for (Entity item : Bukkit.getPlayer(uuid).getNearbyEntities(6D, 6D, 6D)) {
      if (item instanceof Item && !item.hasMetadata("no_pickup") && ((Item) item).getPickupDelay() <= 0) {
        item.teleport(Bukkit.getPlayer(uuid).getEyeLocation());
        Bukkit.getPlayer(uuid).getWorld().playSound(Bukkit.getPlayer(uuid).getEyeLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1F, 2F);
      }
    }
  }

  @Override
  protected boolean cancelTask() {
    return super.cancelTask() || Bukkit.getPlayer(uuid).getGameMode() == GameMode.SPECTATOR;
  }

}
