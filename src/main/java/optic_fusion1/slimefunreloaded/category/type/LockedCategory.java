package optic_fusion1.slimefunreloaded.category.type;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.bukkit.inventory.ItemStack;

public class LockedCategory extends Category {

  private List<Category> parents = new ArrayList<>();

  public LockedCategory(String name, ItemStack item, Category... parents) {
    this(name, item, 3, parents);
  }

  public LockedCategory(String name, ItemStack item, int tier, Category... parents) {
    super(name, item, tier);
    this.parents = Arrays.asList(parents);
  }

  public List<Category> getParents() {
    return parents;
  }

  public void addParent(Category category) {
    Objects.requireNonNull(category);
    if (category == this) {
      throw new IllegalArgumentException("Category '" + this.getItem().getItemMeta().getDisplayName() + "' cannot be a parent of itself.");
    }
    this.parents.add(category);
  }

  public void removeParent(Category category){
    Objects.requireNonNull(category);
    this.parents.remove(category);
  }
  
//  @SuppressWarnings("deprecation")
//  public boolean hasUnlocked(Player p) {
//    return hasUnlocked(p, PlayerProfile.get(p));
//  }
//
//  public boolean hasUnlocked(Player p, PlayerProfile profile) {
//    for (Category category : parents) {
//      for (SlimefunReloadedItem item : category.getItems()) {
//        if (Slimefun.isEnabled(p, item, false)
//         && Slimefun.hasPermission(p, item, false)
//         && item.getResearch() != null
//         && !profile.hasUnlocked(item.getResearch())) {
//          return false;
//        }
//      }
//    }
//    return true;
//  }
}
