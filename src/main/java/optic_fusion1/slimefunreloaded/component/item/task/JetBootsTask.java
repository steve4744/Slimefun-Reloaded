package optic_fusion1.slimefunreloaded.component.item.task;

import java.text.DecimalFormat;
import java.util.Random;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class JetBootsTask extends SlimefunReloadedTask {

  private double speed;

  public JetBootsTask(Player player, double speed) {
    super(player);
    this.speed = speed;
  }

  //TODO: FINSIH
  @Override
  void executeTask() {
//    Player player = Bukkit.getPlayer(uuid);
//    float cost = 0.075F;
//    float charge = ItemEnergy.getStoredEnergy(player.getInventory().getBoots());
//    double accuracy = Double.parseDouble(new DecimalFormat("##.##").format(speed - 0.7).replace(',', '.'));
//    if (charge >= cost) {
//      player.getInventory().setBoots(ItemEnergy.chargeItem(player.getInventory().getBoots()), -cost);
//      player.getWorld().playSound(player.getLocation(), Sound.ENTITY_TNT_PRIMED, (float) 0.25, 1);
//      player.getWorld().playEffect(player.getLocation(), Effect.SMOKE, 1, 1);
//      player.setFallDistance(0F);
//      double gravity = 0.04;
//      double offset = new Random().nextInt(2) == 1 ? accuracy : -accuracy;
//      Vector vector = new Vector(player.getEyeLocation().getDirection().getX() * speed + offset, gravity, player.getEyeLocation().getDirection().getZ() * speed - offset);
//      player.setVelocity(vector);
//    } else {
//      Bukkit.getScheduler().cancelTask(id);
//    }
  }

}
