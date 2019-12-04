package optic_fusion1.slimefunreloaded.component.item.impl;

import java.util.Arrays;
import java.util.List;
import optic_fusion1.slimefunreloaded.Slimefun;
import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.component.RecipeType;
import optic_fusion1.slimefunreloaded.component.item.SlimefunReloadedItem;
import optic_fusion1.slimefunreloaded.protection.ProtectableAction;
import optic_fusion1.slimefunreloaded.util.SlimefunReloadedItems;
import optic_fusion1.slimefunreloaded.util.collection.RandomizedSet;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemStack;

public class GoldPan extends SlimefunReloadedItem {

  private final List<ItemStack> recipes;
  private final RandomizedSet<ItemStack> randomizer = new RandomizedSet<>();
  private int weights;

  public GoldPan(NamespacedKey key, Category category, ItemStack item, RecipeType recipeType, ItemStack[] recipe) {
    super(key, category, item, recipeType, recipe/*, new String[] {"chance.FLINT", "chance.CLAY", "chance.SIFTED_ORE", "chance.IRON_NUGGET"}, new Integer[] {40, 20, 35, 5}*/);
    recipes = Arrays.asList(
     new ItemStack(Material.GRAVEL), new ItemStack(Material.FLINT),
     new ItemStack(Material.GRAVEL), new ItemStack(Material.CLAY_BALL),
     //     new ItemStack(Material.GRAVEL), SlimefunItems.SIFTED_ORE,
     new ItemStack(Material.GRAVEL), new ItemStack(Material.IRON_NUGGET)
    );
    add(SlimefunReloadedItems.SIFTED_ORE, (int) Slimefun.getItemValue(getID(), "chance.SIFTED_ORE"));
    add(new ItemStack(Material.CLAY_BALL), (int) Slimefun.getItemValue(getID(), "chance.CLAY"));
    add(new ItemStack(Material.FLINT), (int) Slimefun.getItemValue(getID(), "chance.FLINT"));
    add(new ItemStack(Material.IRON_NUGGET), (int) Slimefun.getItemValue(getID(), "chance.IRON_NUGGET"));

    if (weights < 100) {
      add(new ItemStack(Material.AIR), 100 - weights);
    }
  }

  private void add(ItemStack item, int chance) {
    randomizer.add(item, chance);
    weights += chance;
  }

  @Override
  public boolean onInteract(Player player, ItemStack item, Action action, Block clickedBlock) {
    if (clickedBlock != null && clickedBlock.getType() == Material.GRAVEL && Slimefun.getProtectionManager().hasPermission(player, clickedBlock.getLocation(), ProtectableAction.BREAK_BLOCK)) {
      ItemStack output = randomizer.getRandom();

      clickedBlock.getWorld().playEffect(clickedBlock.getLocation(), Effect.STEP_SOUND, clickedBlock.getType());
      clickedBlock.setType(Material.AIR);

      if (output.getType() != Material.AIR) {
        clickedBlock.getWorld().dropItemNaturally(clickedBlock.getLocation(), output.clone());
      }
    }
    //e.setCancelled(true);
    return true;
  }

}
