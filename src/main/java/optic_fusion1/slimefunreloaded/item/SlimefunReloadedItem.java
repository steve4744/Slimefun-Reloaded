package optic_fusion1.slimefunreloaded.item;

import optic_fusion1.slimefunreloaded.category.type.Category;
import org.bukkit.inventory.ItemStack;

public abstract class SlimefunReloadedItem {

  private String id;
  private ItemState state;
  private ItemStack item;
  private Category category;

  public SlimefunReloadedItem(Category category, ItemStack item, String id) {
    this.category = category;
    this.item = item;
    this.id = id;
  }

  public String getId() {
    return id;
  }

  public ItemState getState() {
    return state;
  }

  public ItemStack getItem() {
    return item;
  }

  public Category getCategory() {
    return category;
  }

}
