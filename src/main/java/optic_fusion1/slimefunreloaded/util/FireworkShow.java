package optic_fusion1.slimefunreloaded.util;

import java.lang.reflect.InvocationTargetException;
import java.util.Random;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;

public final class FireworkShow {

  private static final Random RANDOM = new Random();
  
  private FireworkShow(){
  
  }
  
  public static void launchFirework(Location l, Color color) {
    Firework fw = (Firework) l.getWorld().spawnEntity(l, EntityType.FIREWORK);
    FireworkMeta meta = fw.getFireworkMeta();
    FireworkEffect effect = FireworkEffect.builder().flicker(RANDOM.nextBoolean()).withColor(color).with(RANDOM.nextInt(3) + 1 == 1 ? Type.BALL : Type.BALL_LARGE).trail(RANDOM.nextBoolean()).build();
    meta.addEffect(effect);
    meta.setPower(RANDOM.nextInt(2) + 1);
    fw.setFireworkMeta(meta);
  }

  public static Firework createFirework(Location l, Color color) {
    Firework fw = (Firework) l.getWorld().spawnEntity(l, EntityType.FIREWORK);
    FireworkMeta meta = fw.getFireworkMeta();
    FireworkEffect effect = FireworkEffect.builder().flicker(RANDOM.nextBoolean()).withColor(color).with(RANDOM.nextInt(3) + 1 == 1 ? Type.BALL : Type.BALL_LARGE).trail(RANDOM.nextBoolean()).build();
    meta.addEffect(effect);
    meta.setPower(RANDOM.nextInt(2) + 1);
    fw.setFireworkMeta(meta);
    return fw;
  }

  public static void launchRandom(Player p, int amount) {
    for (int i = 0; i < amount; i++) {
      Location l = p.getLocation().clone();
      l.setX(l.getX() + RANDOM.nextInt(amount));
      l.setX(l.getX() - RANDOM.nextInt(amount));
      l.setZ(l.getZ() + RANDOM.nextInt(amount));
      l.setZ(l.getZ() - RANDOM.nextInt(amount));

      launchFirework(l, getColors()[RANDOM.nextInt(getColors().length)]);
    }
  }

  public static Color[] getColors() {
    return new Color[]{Color.AQUA, Color.BLACK, Color.BLUE, Color.FUCHSIA, Color.GRAY, Color.GREEN, Color.LIME, Color.MAROON, Color.NAVY, Color.OLIVE, Color.ORANGE, Color.PURPLE, Color.RED, Color.SILVER, Color.TEAL, Color.WHITE, Color.YELLOW};
  }

  public static void playEffect(Location l, Color color) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
    Firework fw = l.getWorld().spawn(l, Firework.class);
    Object worldObject = ReflectionUtils.getMethod(l.getWorld().getClass(), "getHandle").invoke(l.getWorld(), (Object[]) null);

    FireworkMeta meta = fw.getFireworkMeta();
    meta.addEffect(FireworkEffect.builder().with(Type.BURST).flicker(false).trail(false).withColor(color).withFade(Color.WHITE).build());
    fw.setFireworkMeta(meta);

    ReflectionUtils.getMethod(worldObject.getClass(), "broadcastEntityEffect").invoke(worldObject, new Object[]{ReflectionUtils.getMethod(fw.getClass(), "getHandle").invoke(fw, (Object[]) null), (byte) 17});
    fw.remove();
  }
}
