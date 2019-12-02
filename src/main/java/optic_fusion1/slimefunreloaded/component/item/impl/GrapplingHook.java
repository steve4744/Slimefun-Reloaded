package optic_fusion1.slimefunreloaded.component.item.impl;

import java.util.UUID;
import optic_fusion1.slimefunreloaded.Slimefun;
import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.component.RecipeType;
import optic_fusion1.slimefunreloaded.component.item.SlimefunReloadedItem;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Bat;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class GrapplingHook extends SlimefunReloadedItem {

  private long despawnTicks;

  public GrapplingHook(NamespacedKey key, Category category, ItemStack item, RecipeType recipeType, ItemStack[] recipe) {
    super(key, category, item, recipeType, recipe);
    despawnTicks = (int) Slimefun.getItemValue(getID(), "despawn-seconds") * 20L;
  }

  @Override
  public boolean onInteract(Player player, ItemStack item, Action action, Block clickedBlock) {
    UUID uuid = player.getUniqueId();

    if (clickedBlock == null && !Slimefun.getJumpState().containsKey(uuid)) {
      
      if (player.getInventory().getItemInOffHand().getType() == Material.BOW) {
        // Cancel, to fix dupe #740
        return false;
      }
      Slimefun.getJumpState().put(uuid, player.getInventory().getItemInMainHand().getType() != Material.SHEARS);

      if (item.getType() == Material.LEAD) {
        item.setAmount(item.getAmount() - 1);
      }

      Vector direction = player.getEyeLocation().getDirection().multiply(2.0);
      Arrow arrow = player.getWorld().spawn(player.getEyeLocation().add(direction.getX(), direction.getY(), direction.getZ()), Arrow.class);
      arrow.setShooter(player);
      arrow.setVelocity(direction);

      Bat b = (Bat) player.getWorld().spawnEntity(player.getLocation(), EntityType.BAT);
      b.setCanPickupItems(false);
      b.setAI(false);
      b.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 100000, 100000));
      b.setLeashHolder(arrow);

      Slimefun.getDamage().add(uuid);
      Slimefun.getRemove().put(uuid, new Entity[]{b, arrow});

      // To fix issue #253
      Bukkit.getScheduler().scheduleSyncDelayedTask(Slimefun.getSlimefunReloaded(), () -> {
        if (Slimefun.getJumpState().containsKey(uuid)) {
          Slimefun.getArrows().remove(uuid);

          for (Entity n : Slimefun.getRemove().get(uuid)) {
            if (n.isValid()) {
              n.remove();
            }
          }

          Bukkit.getScheduler().scheduleSyncDelayedTask(Slimefun.getSlimefunReloaded(), () -> {
            Slimefun.getDamage().remove(uuid);
            Slimefun.getJumpState().remove(uuid);
            Slimefun.getRemove().remove(uuid);
          }, 20L);
        }
      }, despawnTicks);
    }
    return true;
  }

}
