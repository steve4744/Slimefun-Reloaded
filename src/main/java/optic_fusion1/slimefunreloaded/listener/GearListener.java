package optic_fusion1.slimefunreloaded.listener;

import optic_fusion1.slimefunreloaded.Slimefun;
import optic_fusion1.slimefunreloaded.component.ComponentManager;
import optic_fusion1.slimefunreloaded.component.SlimefunReloadedComponent;
import optic_fusion1.slimefunreloaded.component.item.impl.JetBoots;
import optic_fusion1.slimefunreloaded.component.item.impl.Jetpack;
import optic_fusion1.slimefunreloaded.component.item.task.JetBootsTask;
import optic_fusion1.slimefunreloaded.component.item.task.JetpackTask;
import optic_fusion1.slimefunreloaded.component.item.task.MagnetTask;
import optic_fusion1.slimefunreloaded.component.item.task.ParachuteTask;
import optic_fusion1.slimefunreloaded.util.InvUtils;
import optic_fusion1.slimefunreloaded.util.SlimefunReloadedItems;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;

public class GearListener implements Listener {

  private ComponentManager componentManager = Slimefun.getComponentManager();

  @EventHandler
  public void onToggleSneak(PlayerToggleSneakEvent event) {
    if (event.isSneaking()) {
      Player player = event.getPlayer();
      SlimefunReloadedComponent chestplate = componentManager.getComponentByItem(player.getInventory().getChestplate());
      SlimefunReloadedComponent boots = componentManager.getComponentByItem(player.getInventory().getBoots());
      if (chestplate != null) {
        if (chestplate instanceof Jetpack) {
          if (Slimefun.hasUnlocked(player, chestplate, true)) {
            double thrust = ((Jetpack) chestplate).getThrust();
            if (thrust > 0.2) {
              JetpackTask task = new JetpackTask(player, thrust);
              task.setID(Bukkit.getScheduler().scheduleSyncRepeatingTask(Slimefun.getSlimefunReloaded(), task, 0L, 3L));
            }
          }
        }
      } else if (chestplate.getID().equals("PARACHUTE") && Slimefun.hasUnlocked(player, chestplate, true)) {
        ParachuteTask task = new ParachuteTask(player);
        task.setID(Bukkit.getScheduler().scheduleSyncRepeatingTask(Slimefun.getSlimefunReloaded(), task, 0L, 3L));
      }
      if (boots != null && boots instanceof JetBoots && Slimefun.hasUnlocked(player, boots, true)) {
        double speed = ((JetBoots) boots).getSpeed();
        if (speed > 0.2) {
          JetBootsTask task = new JetBootsTask(player, speed);
          task.setID(Bukkit.getScheduler().scheduleSyncRepeatingTask(Slimefun.getSlimefunReloaded(), task, 0L, 2L));
        }
      }
      if (InvUtils.containsSimilarItem(player.getInventory(), SlimefunReloadedItems.INFUSED_MAGNET, true)) {
        MagnetTask task = new MagnetTask(player);
        task.setID(Bukkit.getScheduler().scheduleSyncRepeatingTask(Slimefun.getSlimefunReloaded(), task, 0L, 8L));
      }
    }
  }
}
