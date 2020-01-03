package optic_fusion1.slimefunreloaded.component.item.task;

import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public abstract class SlimefunReloadedTask implements Runnable {

  protected UUID uuid;
  protected int id;

  public SlimefunReloadedTask(Player player) {
    this.uuid = player.getUniqueId();
  }

  public void setID(int id) {
    this.id = id;
  }

  @Override
  public void run() {
    if (cancelTask()) {
      return;
    }
    executeTask();
  }

  protected boolean cancelTask() {
    if (Bukkit.getPlayer(uuid) == null) {
      return true;
    }
    Player target = Bukkit.getPlayer(uuid);
    if (target.isDead() || !target.isSneaking()) {
      Bukkit.getScheduler().cancelTask(id);
      return true;
    }
    return false;
  }

  abstract void executeTask();

}
