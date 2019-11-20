package optic_fusion1.slimefunreloaded.item.food;

import optic_fusion1.slimefunreloaded.Slimefun;
import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.item.SlimefunReloadedItem;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public abstract class SlimefunReloadedFoodItem extends SlimefunReloadedItem {

  private static final Category CATEGORY = Slimefun.getCategoryManager().getCategoryByName("Food");
  private int saturation;

  public SlimefunReloadedFoodItem(ItemStack item, String id, int saturation) {
    super(CATEGORY, item, id);
    this.saturation = saturation;
  }

  public int getSaturation() {
    return saturation;
  }
  
  public abstract void handle(ItemStack item, Player player);

}
