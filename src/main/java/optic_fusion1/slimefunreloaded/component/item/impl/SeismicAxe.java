package optic_fusion1.slimefunreloaded.component.item.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import optic_fusion1.slimefunreloaded.Slimefun;
import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.component.RecipeType;
import optic_fusion1.slimefunreloaded.component.item.SlimefunReloadedItem;
import optic_fusion1.slimefunreloaded.component.item.interfaces.DamageableItem;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class SeismicAxe extends SlimefunReloadedItem implements DamageableItem {

  private List<UUID> blocks = new ArrayList<>();
  
  public SeismicAxe(NamespacedKey key, Category category, ItemStack item, RecipeType recipeType, ItemStack[] recipe) {
    super(key, category, item, recipeType, recipe);
  }

  @Override
  public boolean onInteract(Player player, ItemStack item, Action action, Block clickedBlock) {
    List<Block> blocks = player.getLineOfSight(null, 10);
    for (int i = 0; i < blocks.size(); i++) {
      Block b = blocks.get(i);
      Location ground = b.getLocation();

      if (b.getType() == null || b.getType() == Material.AIR) {
        for (int y = ground.getBlockY(); y > 0; y--) {
          if (b.getWorld().getBlockAt(b.getX(), y, b.getZ()) != null && b.getWorld().getBlockAt(b.getX(), y, b.getZ()).getType() != null && b.getWorld().getBlockAt(b.getX(), y, b.getZ()).getType() != Material.AIR) {
            ground = new Location(b.getWorld(), b.getX(), y, b.getZ());
            break;
          }
        }
      }

      b.getWorld().playEffect(ground, Effect.STEP_SOUND, ground.getBlock().getType());

      if (ground.getBlock().getRelative(BlockFace.UP).getType() == null || ground.getBlock().getRelative(BlockFace.UP).getType() == Material.AIR) {
        Location loc = ground.getBlock().getRelative(BlockFace.UP).getLocation().add(0.5, 0.0, 0.5);
        FallingBlock block = ground.getWorld().spawnFallingBlock(loc, ground.getBlock().getBlockData());
        block.setDropItem(false);
        block.setVelocity(new Vector(0, 0.4 + i * 0.01, 0));
        //TODO: Figure out wtf this is for
        this.blocks.add(block.getUniqueId());
      }
      for (Entity n : ground.getChunk().getEntities()) {
        if (n instanceof LivingEntity && n.getLocation().distance(ground) <= 2.0D && !n.getUniqueId().equals(player.getUniqueId())) {
          Vector vector = n.getLocation().toVector().subtract(player.getLocation().toVector()).normalize().multiply(1.4);
          vector.setY(0.9);
          n.setVelocity(vector);

          if (player.getWorld().getPVP()) {
            EntityDamageByEntityEvent event = new EntityDamageByEntityEvent(player, n, DamageCause.ENTITY_ATTACK, 6D);
            Bukkit.getPluginManager().callEvent(event);
            if (!event.isCancelled()) {
              ((LivingEntity) n).damage(6D);
            }
          }
        }
      }
    }

    for (int i = 0; i < 4; i++) {
      damageItem(player, item);
    }

    return true;
  }

  @Override
  public boolean isDamageable() {
    return true;
  }

}
