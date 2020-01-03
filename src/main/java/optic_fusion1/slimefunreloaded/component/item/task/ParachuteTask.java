package optic_fusion1.slimefunreloaded.component.item.task;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class ParachuteTask extends SlimefunReloadedTask {

  public ParachuteTask(Player player) {
    super(player);
  }

  @Override
  void executeTask() {
    Player player = Bukkit.getPlayer(uuid);
    Vector vector = new Vector(0, 1, 0);
    vector.multiply(-0.1);
    player.setVelocity(vector);
    player.setFallDistance(0F);
    if (!player.isSneaking()) {
      Bukkit.getScheduler().cancelTask(id);
    }
  }

}
