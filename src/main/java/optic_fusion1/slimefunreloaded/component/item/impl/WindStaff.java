package optic_fusion1.slimefunreloaded.component.item.impl;

import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.component.item.SlimefunReloadedItem;
import optic_fusion1.slimefunreloaded.util.I18n;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.inventory.ItemStack;

public class WindStaff extends SlimefunReloadedItem {

  public WindStaff(NamespacedKey key, Category category, ItemStack item) {
    super(key, category, item);
  }

  @Override
  public boolean onInteract(Player player, ItemStack item) {
    if (item.isSimilar(getItem())) {
      if (player.getFoodLevel() <= 2) {
        I18n.tl(player, "messages.hungry");
        return true;
      }
      if (player.getInventory().getItemInMainHand().getType() == Material.SHEARS && player.getGameMode() == GameMode.CREATIVE) {
        player.setVelocity(player.getEyeLocation().getDirection().multiply(4));
        World playerWorld = player.getWorld();
        playerWorld.playSound(player.getLocation(), Sound.ENTITY_TNT_PRIMED, 1, 1);
        playerWorld.playEffect(player.getLocation(), Effect.SMOKE, 1);
        player.setFallDistance(0F);
        return true;
      }
      FoodLevelChangeEvent event = new FoodLevelChangeEvent(player, player.getFoodLevel() - 2);
      Bukkit.getPluginManager().callEvent(event);
      player.setFoodLevel(event.getFoodLevel());
    }
    return true;
  }

}
