package optic_fusion1.slimefunreloaded.component.item.impl;

import static java.lang.Math.random;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.component.RecipeType;
import optic_fusion1.slimefunreloaded.component.item.SlimefunReloadedItem;
import optic_fusion1.slimefunreloaded.util.CustomItem;
import optic_fusion1.slimefunreloaded.util.FireworkShow;
import optic_fusion1.slimefunreloaded.util.ItemUtils;
import optic_fusion1.slimefunreloaded.util.SlimefunReloadedItems;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemStack;

public class EasterEgg extends SlimefunReloadedItem {

  private Random random = new Random();
  
  public EasterEgg(NamespacedKey key, Category category, ItemStack item, RecipeType recipeType, ItemStack[] recipe) {
    super(key, category, item, recipeType, recipe);
  }

  public EasterEgg(NamespacedKey key, Category category, ItemStack item, RecipeType recipeType, ItemStack[] recipe, String[] keys, Object[] values) {
    super(key, category, item, recipeType, recipe, keys, values);
  }

  @Override
  public boolean onInteract(Player player, ItemStack item, Action action, Block clickedBlock) {
    if (action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
      //e.setCancelled(true);
      if (player.getGameMode() != GameMode.CREATIVE) {
        consumeItem(item, false);
      }
      FireworkShow.launchRandom(player, 2);
      List<ItemStack> gifts = new ArrayList<>();

      for (int i = 0; i < 2; i++) {
        gifts.add(new CustomItem(SlimefunReloadedItems.EASTER_CARROT_PIE, 4));
        gifts.add(new CustomItem(SlimefunReloadedItems.CARROT_JUICE, 1));
        gifts.add(new ItemStack(Material.EMERALD));
        gifts.add(new ItemStack(Material.CAKE));
        gifts.add(new ItemStack(Material.RABBIT_FOOT));
        gifts.add(new ItemStack(Material.GOLDEN_CARROT, 4));
      }

      player.getWorld().dropItemNaturally(player.getLocation(), gifts.get(random.nextInt(gifts.size())));
    }
    return true;
  }

}
