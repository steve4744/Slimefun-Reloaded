package optic_fusion1.slimefunreloaded.item.chargable;

import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.item.SlimefunReloadedItem;
import org.bukkit.inventory.ItemStack;

public abstract class SlimefunReloadedChargableItem extends SlimefunReloadedItem{

  public SlimefunReloadedChargableItem(Category category, ItemStack item, String id) {
    super(category, item, id);
  }

}