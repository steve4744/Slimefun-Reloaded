package optic_fusion1.slimefunreloaded.component.item.impl;

import java.util.Arrays;
import java.util.List;
import optic_fusion1.slimefunreloaded.Slimefun;
import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.component.RecipeType;
import optic_fusion1.slimefunreloaded.component.item.SlimefunReloadedItem;
import optic_fusion1.slimefunreloaded.protection.ProtectableAction;
import optic_fusion1.slimefunreloaded.util.collection.RandomizedSet;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemStack;

public class NetherGoldPan extends SlimefunReloadedItem {

  private final List<ItemStack> recipes;
  private final RandomizedSet<ItemStack> randomizer = new RandomizedSet<>();
  private int weights;

  public NetherGoldPan(NamespacedKey key, Category category, ItemStack item, RecipeType recipeType, ItemStack[] recipe) {
    super(key, category, item, recipeType, recipe, new String[] {"chance.QUARTZ", "chance.GOLD_NUGGET", "chance.NETHER_WART", "chance.BLAZE_POWDER", "chance.GLOWSTONE_DUST", "chance.GHAST_TEAR"}, new Integer[] {50, 25, 10, 8, 5, 2});
    recipes = Arrays.asList(
     new ItemStack(Material.SOUL_SAND), new ItemStack(Material.QUARTZ),
     new ItemStack(Material.SOUL_SAND), new ItemStack(Material.GOLD_NUGGET),
     new ItemStack(Material.SOUL_SAND), new ItemStack(Material.NETHER_WART),
     new ItemStack(Material.SOUL_SAND), new ItemStack(Material.BLAZE_POWDER),
     new ItemStack(Material.SOUL_SAND), new ItemStack(Material.GLOWSTONE_DUST),
     new ItemStack(Material.SOUL_SAND), new ItemStack(Material.GHAST_TEAR)
    );
    add(new ItemStack(Material.QUARTZ), (int) Slimefun.getItemValue(getID(), "chance.QUARTZ"));
    add(new ItemStack(Material.GOLD_NUGGET), (int) Slimefun.getItemValue(getID(), "chance.GOLD_NUGGET"));
    add(new ItemStack(Material.NETHER_WART), (int) Slimefun.getItemValue(getID(), "chance.NETHER_WART"));
    add(new ItemStack(Material.BLAZE_POWDER), (int) Slimefun.getItemValue(getID(), "chance.BLAZE_POWDER"));
    add(new ItemStack(Material.GLOWSTONE_DUST), (int) Slimefun.getItemValue(getID(), "chance.GLOWSTONE_DUST"));
    add(new ItemStack(Material.GHAST_TEAR), (int) Slimefun.getItemValue(getID(), "chance.GHAST_TEAR"));

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
    if (clickedBlock != null && clickedBlock.getType() == Material.SOUL_SAND && Slimefun.getProtectionManager().hasPermission(player, clickedBlock.getLocation(), ProtectableAction.BREAK_BLOCK)) {
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
