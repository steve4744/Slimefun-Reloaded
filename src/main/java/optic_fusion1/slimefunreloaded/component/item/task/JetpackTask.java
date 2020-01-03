package optic_fusion1.slimefunreloaded.component.item.task;

import org.bukkit.entity.Player;

public class JetpackTask extends SlimefunReloadedTask {

  private double thrust;

  public JetpackTask(Player player, double thrust) {
    super(player);
    this.thrust = thrust;
  }

  //TODO: FINISH
  @Override
  void executeTask() {
//    Player player = Bukkit.getPlayer(uuid);
//    float cost = 0.08F;
//    float charge = ItemEnergy.getStoredEnergy(player.getInventory().getChestPlate());
//    if (charge >= cost) {
//      player.getInventory().setChestplate(ItemEnergy.chargeItem(player.getInventory().getChestplate(), -cost));
//      player.getWorld().playSound(player.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, (float) 0.25, 1);
//      player.getWorld().playEffect(player.getLocation(), Effect.SMOKE, 1, 1);
//      player.setFallDistance(0F);
//      Vector vector = new Vector(0, 1, 0);
//      vector.multiply(thrust);
//      vector.add(player.getEyeLocation().getDirection().multiply(0.2F));
//      player.setVelocity(vector);
//    } else {
//      Bukkit.getScheduler().cancelTask(id);
//    }
  }

}
