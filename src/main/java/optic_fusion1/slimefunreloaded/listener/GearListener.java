package optic_fusion1.slimefunreloaded.listener;

import optic_fusion1.slimefunreloaded.Slimefun;
import optic_fusion1.slimefunreloaded.item.chargable.impl.JetBoots;
import optic_fusion1.slimefunreloaded.item.chargable.impl.Jetpack;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;

public class GearListener implements Listener {

  public GearListener(SlimefunPlugin plugin) {
    plugin.getServer().getPluginManager().registerEvents(this, plugin);
  }

  @EventHandler
  public void onToggleSneak(PlayerToggleSneakEvent e) {
    if (e.isSneaking()) {
      final Player p = e.getPlayer();
      final SlimefunItem chestplate = SlimefunItem.getByItem(p.getInventory().getChestplate());
      final SlimefunItem boots = SlimefunItem.getByItem(p.getInventory().getBoots());

      if (chestplate != null) {
        if (chestplate instanceof Jetpack) {
          if (Slimefun.hasUnlocked(p, chestplate, true)) {
            double thrust = ((Jetpack) chestplate).getThrust();

            if (thrust > 0.2) {
              JetpackTask task = new JetpackTask(p, thrust);
              task.setID(Bukkit.getScheduler().scheduleSyncRepeatingTask(SlimefunPlugin.instance, task, 0L, 3L));
            }
          }
        } else if (chestplate.getID().equals("PARACHUTE") && Slimefun.hasUnlocked(p, chestplate, true)) {
          ParachuteTask task = new ParachuteTask(p);
          task.setID(Bukkit.getScheduler().scheduleSyncRepeatingTask(SlimefunPlugin.instance, task, 0L, 3L));
        }
      }

      if (boots instanceof JetBoots && Slimefun.hasUnlocked(p, boots, true)) {
        double speed = ((JetBoots) boots).getSpeed();

        if (speed > 0.2) {
          JetBootsTask task = new JetBootsTask(p, speed);
          task.setID(Bukkit.getScheduler().scheduleSyncRepeatingTask(SlimefunPlugin.instance, task, 0L, 2L));
        }
      }

      if (SlimefunManager.containsSimilarItem(p.getInventory(), SlimefunItems.INFUSED_MAGNET, true)) {
        MagnetTask task = new MagnetTask(p);
        task.setID(Bukkit.getScheduler().scheduleSyncRepeatingTask(SlimefunPlugin.instance, task, 0L, 8L));
      }
    }
  }

}
