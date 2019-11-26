package optic_fusion1.slimefunreloaded.component.item.impl;

import java.util.Random;
import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.component.item.SlimefunReloadedItem;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.WitherSkeleton;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class SwordOfBeheading extends SlimefunReloadedItem {

  private final Random random = new Random();

  private int chanceZombie;
  private int chanceSkeleton;
  private int chanceCreeper;
  private int chanceWitherSkeleton;
  private int chancePlayer;

  public SwordOfBeheading(NamespacedKey key, Category category, ItemStack item) {
    super(key, category, item);
    /*
    chanceZombie = (int) Slimefun.getItemValue(getID(), "chance.ZOMBIE");
		chanceSkeleton = (int) Slimefun.getItemValue(getID(), "chance.SKELETON");
		chanceCreeper = (int) Slimefun.getItemValue(getID(), "chance.CREEPER");
		chanceWitherSkeleton = (int) Slimefun.getItemValue(getID(), "chance.WITHER_SKELETON");
		chancePlayer = (int) Slimefun.getItemValue(getID(), "chance.PLAYER");
     */
  }

  @Override
  public void onKill(Player player, Entity entity, ItemStack item) {
    if (entity instanceof Zombie) {
      if (random.nextInt(100) < chanceZombie) {
        //e.getDrops().add(new ItemStack(Material.ZOMBIE_HEAD));
      }
    }
    if (entity instanceof WitherSkeleton) {
      if (random.nextInt(100) < chanceWitherSkeleton) {
        //e.getDrops().add(new ItemStack(Material.WITHER_SKELETON_SKULL));
      }
    }
    if (entity instanceof Skeleton) {
      if (random.nextInt(100) < chanceSkeleton) {
        //e.getDrops().add(new ItemStack(Material.SKELETON_SKULL));
      }
    }
    if (entity instanceof Creeper) {
      if (random.nextInt(100) < chanceCreeper) {
        //e.getDrops().add(new ItemStack(Material.CREEPER_HEAD));
      }
    }
    if (entity instanceof Player) {
      if (random.nextInt(100) < chancePlayer) {
        ItemStack skull = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) skull.getItemMeta();
        meta.setOwningPlayer((Player) entity);
        skull.setItemMeta(meta);
        //e.getDrops().add(skull);
      }
    }
    return;
  }
}
