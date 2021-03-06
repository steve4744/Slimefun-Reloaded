package optic_fusion1.slimefunreloaded.GPS;

import java.util.UUID;
import java.util.logging.Level;
import optic_fusion1.slimefunreloaded.Slimefun;
import optic_fusion1.slimefunreloaded.util.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public final class TeleportationSequence {

  private TeleportationSequence() {
  }

  public static void start(UUID uuid, int complexity, Location source, Location destination, boolean resistance) {
    Slimefun.getTeleporterUsers().add(uuid);

    updateProgress(uuid, getSpeed(complexity, source, destination), 1, source, destination, resistance);
  }

  public static int getSpeed(int complexity, Location source, Location destination) {
    int speed = complexity / 200;
    if (speed > 50) {
      speed = 50;
    }
    speed = speed - (distance(source, destination) / 200);

    return speed < 1 ? 1 : speed;
  }

  private static int distance(Location source, Location destination) {
    if (source.getWorld().getName().equals(destination.getWorld().getName())) {
      int distance = (int) source.distance(destination);
      return distance > 8000 ? 8000 : distance;
    } else {
      return 8000;
    }
  }

  private static boolean isValid(Player p, Location source) {
    return p != null && p.getLocation().distanceSquared(source) < 2.0;
  }

  private static void cancel(UUID uuid, Player p) {
    Slimefun.getTeleporterUsers().remove(uuid);

    if (p != null) {
      p.sendTitle(StringUtils.color("&4Teleportation cancelled"), StringUtils.color("&40%"), 20, 60, 20);
    }
  }

  private static void updateProgress(final UUID uuid, final int speed, final int progress, final Location source, final Location destination, final boolean resistance) {
    Player player = Bukkit.getPlayer(uuid);
    if (!isValid(player, source)) {
      cancel(uuid, player);
    }

    if (progress > 99) {
      player.sendTitle(StringUtils.color("&3Teleported!"), StringUtils.color("&b100%"), 20, 60, 20);

      player.teleport(destination);

      if (resistance) {
        player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 600, 20));
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&lYou have been given 30 Seconds of Invulnerability!"));
      }

      destination.getWorld().spawnParticle(Particle.PORTAL, new Location(destination.getWorld(), destination.getX(), destination.getY() + 1, destination.getZ()), progress * 2, 0.2F, 0.8F, 0.2F);
      destination.getWorld().playSound(destination, Sound.ENTITY_BLAZE_DEATH, 1F, 1.4F);
      Slimefun.getTeleporterUsers().remove(uuid);
    } else {
      player.sendTitle(StringUtils.color("&3Tleporting..."), StringUtils.color("&b" + progress + "%"), 20, 60, 20);

      source.getWorld().spawnParticle(Particle.PORTAL, source, progress * 2, 0.2F, 0.8F, 0.2F);
      source.getWorld().playSound(source, Sound.UI_BUTTON_CLICK, 1F, 0.6F);

      Bukkit.getScheduler().scheduleSyncDelayedTask(Slimefun.getSlimefunReloaded(), () -> updateProgress(uuid, speed, progress + speed, source, destination, resistance), 10L);
    }
  }

}
