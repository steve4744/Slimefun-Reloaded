package optic_fusion1.slimefunreloaded.component.item;

import optic_fusion1.slimefunreloaded.category.type.Category;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

public class SlimefunReloadedBackback extends SlimefunReloadedItem {

  private int size;
  
  public SlimefunReloadedBackback(int size, NamespacedKey key, Category category, ItemStack item) {
    super(key, category, item);
    this.size = size;
  }
  
  public int getSize(){
    return size;
  }

}
