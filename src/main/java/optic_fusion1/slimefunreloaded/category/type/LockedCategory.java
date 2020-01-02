package optic_fusion1.slimefunreloaded.category.type;

import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import optic_fusion1.slimefunreloaded.Slimefun;
import optic_fusion1.slimefunreloaded.component.SlimefunReloadedComponent;
import optic_fusion1.slimefunreloaded.util.PlayerProfile;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class LockedCategory extends Category {

  private List<Category> parents = new ArrayList<>();

  public LockedCategory(NamespacedKey key, ItemStack itemStack, Category... parents) {
    this(key, itemStack, 3, parents);
  }

  public LockedCategory(NamespacedKey key, ItemStack item, int tier, Category... parents) {
    super(key, item, tier);
    this.parents = Arrays.asList(parents);
  }

  public List<Category> getParents() {
    return parents;
  }

  public void addParent(Category category) {
    Preconditions.checkArgument(category != null, "Expected Category, received null");
    if (category == this) {
      throw new IllegalArgumentException("Category '" + getItem().getItemMeta().getDisplayName() + "' cannot be a parent of itself.");
    }
  }

  public void removeParent(Category category) {
    Preconditions.checkArgument(category != null, "Expected Category, received null");
    parents.remove(category);
  }

  public boolean hasUnlocked(Player player) {
    return hasUnlocked(player, PlayerProfile.get(player));
  }

  public boolean hasUnlocked(Player player, PlayerProfile profile) {
    for (Category category : parents) {
      for (SlimefunReloadedComponent component : category.getComponents()) {
        if (Slimefun.isEnabled(player, component, false)
         && Slimefun.hasPermission(player, component, false)
         && component.getResearch() != null
         && !profile.hasUnlocked(component.getResearch())) {
          return false;
        }
      }
    }
    return true;
  }

}
