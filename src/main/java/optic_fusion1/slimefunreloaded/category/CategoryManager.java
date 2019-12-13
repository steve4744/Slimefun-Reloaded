package optic_fusion1.slimefunreloaded.category;

import optic_fusion1.slimefunreloaded.category.type.Category;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import optic_fusion1.slimefunreloaded.category.type.SeasonalCategory;
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
      Collections.sort(categories, categorySorter);
      if (category instanceof SeasonalCategory) {
        if (((SeasonalCategory) category).isUnlocked()) {
          categories.add(category);
        }
      } else {
        categories.add(category);
      }
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

  public Category getCategoryByName(String name) {
    for (Category category : categories) {
      if (category.getName().equals(name)) {
        return category;
      }
    }
    return null;
  }

}
