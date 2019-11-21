package optic_fusion1.slimefunreloaded.item;

import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.research.Research;
import org.bukkit.inventory.ItemStack;

public abstract class SlimefunReloadedItem {

  private String id;
  private ItemState state;
  private ItemStack item;
  private Category category;
  private ItemStack[] recipe;
//  private RecipeType recipeType;
  protected ItemStack recipeOutput;
  private Research research;

  
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
