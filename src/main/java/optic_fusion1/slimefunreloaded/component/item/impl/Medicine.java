package optic_fusion1.slimefunreloaded.component.item.impl;

import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.component.RecipeType;
import optic_fusion1.slimefunreloaded.component.item.SlimefunReloadedConsumeable;
import optic_fusion1.slimefunreloaded.util.ItemUtils;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Medicine extends SlimefunReloadedConsumeable {

  public Medicine(NamespacedKey key, Category category, ItemStack item, RecipeType recipeType, ItemStack[] recipe) {
    super(key, category, item, recipeType, recipe);
  }

  @Override
  public boolean onConsume(Player player, ItemStack item) {
    if (player.getGameMode() != GameMode.CREATIVE) {
      consumeItem(item, false);
    }
    player.getWorld().playEffect(player.getLocation(), Effect.STEP_SOUND, Material.WHITE_WOOL);
    player.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 1, 1));
    player.setFireTicks(0);
    return true;
  }

}
