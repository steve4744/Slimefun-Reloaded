package optic_fusion1.slimefunreloaded.category;

import optic_fusion1.slimefunreloaded.category.type.Category;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.bukkit.inventory.ItemStack;

public class CategoryManager {

  private List<Category> categories = new ArrayList<>();
  private CategorySorter categorySorter = new CategorySorter();

  public boolean categoryExists(String name) {
    return categories.stream().anyMatch((category) -> (category.getName().equals(name)));
  }

  public List<Category> getAllEnabledCategories() {
    List<Category> enabledCategories = new ArrayList<>();
    categories.stream().filter((category) -> (category.isEnabled())).forEachOrdered((category) -> {
      enabledCategories.add(category);
    });
    return enabledCategories;
  }

  public void addCategory(Category category) {
    if (!categoryExists(category.getName())) {
      categories.add(category);
      Collections.sort(categories, categorySorter);
    }
  }

  public List<Category> getCategories() {
    return Collections.unmodifiableList(categories);
  }

  public Category getCategoryByItem(ItemStack item) {
    for (Category category : categories) {
      if (category.getItem().isSimilar(item)) {
        return category;
      }
    }
    return null;
  }

}
