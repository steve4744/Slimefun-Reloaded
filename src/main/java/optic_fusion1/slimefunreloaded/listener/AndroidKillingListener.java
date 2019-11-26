//package optic_fusion1.slimefunreloaded.listener;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//import optic_fusion1.slimefunreloaded.Slimefun;
//import optic_fusion1.slimefunreloaded.SlimefunReloaded;
//import org.bukkit.Bukkit;
//import org.bukkit.Material;
//import org.bukkit.entity.Entity;
//import org.bukkit.entity.EntityType;
//import static org.bukkit.entity.EntityType.BLAZE;
//import static org.bukkit.entity.EntityType.PIG_ZOMBIE;
//import static org.bukkit.entity.EntityType.WITHER_SKELETON;
//import org.bukkit.entity.ExperienceOrb;
//import org.bukkit.entity.Item;
//import org.bukkit.event.EventHandler;
//import org.bukkit.event.EventPriority;
//import org.bukkit.event.Listener;
//import org.bukkit.event.entity.EntityDeathEvent;
//import org.bukkit.inventory.ItemStack;
//
//public class AndroidKillingListener implements Listener {
//
//  private final Random random = new Random();
//
//  public AndroidKillingListener(SlimefunReloaded plugin) {
//    plugin.getServer().getPluginManager().registerEvents(this, plugin);
//  }
//
//  @EventHandler(priority = EventPriority.HIGHEST)
//  public void onDeath(final EntityDeathEvent e) {
//    if (e.getEntity().hasMetadata("android_killer")) {
//      final AndroidObject obj = (AndroidObject) e.getEntity().getMetadata("android_killer").get(0).value();
//
//      Bukkit.getScheduler().scheduleSyncDelayedTask(Slimefun.getSlimefunReloaded(), () -> {
//        List<ItemStack> items = new ArrayList<>();
//
//        for (Entity n : e.getEntity().getNearbyEntities(0.5D, 0.5D, 0.5D)) {
//          if (n instanceof Item && !n.hasMetadata("no_pickup")) {
//            items.add(((Item) n).getItemStack());
//            n.remove();
//          }
//        }
//
//        switch (e.getEntityType()) {
//          case BLAZE:
//            items.add(new ItemStack(Material.BLAZE_ROD, 1 + random.nextInt(2)));
//            break;
//          case PIG_ZOMBIE:
//            items.add(new ItemStack(Material.GOLD_NUGGET, 1 + random.nextInt(3)));
//            break;
//          case WITHER_SKELETON:
//            if (random.nextInt(250) < 2) {
//              items.add(new ItemStack(Material.WITHER_SKELETON_SKULL));
//            }
//            break;
//          default:
//            break;
//        }
//
//        obj.getAndroid().addItems(obj.getBlock(), items.toArray(new ItemStack[items.size()]));
//        ExperienceOrb exp = (ExperienceOrb) e.getEntity().getWorld().spawnEntity(e.getEntity().getLocation(), EntityType.EXPERIENCE_ORB);
//        exp.setExperience(1 + random.nextInt(6));
//      }, 1L);
//    }
//  }
//}
