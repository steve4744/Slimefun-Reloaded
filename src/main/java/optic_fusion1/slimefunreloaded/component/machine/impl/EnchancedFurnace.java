package optic_fusion1.slimefunreloaded.component.machine.impl;

import java.util.concurrent.ThreadLocalRandom;
import optic_fusion1.slimefunreloaded.Slimefun;
import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.component.RecipeType;
import optic_fusion1.slimefunreloaded.component.SlimefunReloadedComponent;
import optic_fusion1.slimefunreloaded.component.TickableComponent;
import optic_fusion1.slimefunreloaded.component.item.impl.SimpleSlimefunReloadedItem;
import optic_fusion1.slimefunreloaded.util.BlockStorage;
import optic_fusion1.slimefunreloaded.util.Config;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.block.Furnace;
import org.bukkit.inventory.ItemStack;

public class EnchancedFurnace extends SimpleSlimefunReloadedItem implements TickableComponent {

  private static final Category MACHINES_1 = Slimefun.getCategoryManager().getCategoryByKey("MACHINES_1");
  private final int speed;
  private final int efficiency;
  private final int fortune;

  public EnchancedFurnace(NamespacedKey key, ItemStack item, ItemStack[] recipe, int speed, int efficiency, int fortune) {
    super(key, MACHINES_1, item, RecipeType.ENHANCED_CRAFTING_TABLE, recipe);
    this.speed = speed - 1;
    this.efficiency = efficiency - 1;
    this.fortune = fortune - 1;
  }

  public int getSpeed() {
    return speed;
  }

  public int getFuelEfficiency() {
    return efficiency;
  }

  public int getOutput() {
    int bonus = this.fortune;
    bonus = ThreadLocalRandom.current().nextInt(bonus + 2) - 1;
    if (bonus <= 0) {
      bonus = 0;
    }
    bonus++;
    return bonus;
  }

  @Override
  public void tick(Block block, SlimefunReloadedComponent component, Config data) {
    if (!(block.getState() instanceof Furnace)) {
      // The Furnace has been destroyed, we can clear the block data
      BlockStorage.clearBlockInfo(block);
    } else if (((Furnace) block.getState()).getCookTime() > 0) {
      Furnace furnace = (Furnace) block.getState();

      int newCookTime = furnace.getCookTime() + getSpeed() * 10;

      if (newCookTime > 200) {
        furnace.setCookTime((short) 188);
      } else {
        furnace.setCookTime((short) newCookTime);
      }

      furnace.update(true, false);
    }
  }

  @Override
  public boolean isSynchronized() {
    return true;
  }

}
