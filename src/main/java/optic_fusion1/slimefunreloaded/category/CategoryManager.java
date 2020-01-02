package optic_fusion1.slimefunreloaded.category;

import com.google.common.base.Preconditions;
import optic_fusion1.slimefunreloaded.category.type.Category;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import optic_fusion1.slimefunreloaded.category.type.SeasonalCategory;
import org.bukkit.inventory.ItemStack;

public class CategoryManager {

  private List<Category> categories = new ArrayList<>();
  private CategorySorter categorySorter = new CategorySorter();

  public boolean categoryWithKeyExists(String key) {
    return categories.stream().anyMatch((category) -> (category.getKey().getKey().toLowerCase().equals(key.toLowerCase())));
  }

  public List<Category> getCategories() {
    return categories;
  }

  public List<Category> getEnabledCategories() {
    List<Category> enabledCategories = new ArrayList<>();
    categories.stream().filter((category) -> (category.isEnabled())).forEachOrdered((category) -> {
      enabledCategories.add(category);
    });
    return enabledCategories;
  }

  public void addCategory(Category category) {
    Preconditions.checkArgument(category != null, "Expected Category, received null");
    if (!categoryWithKeyExists(category.getKey().getKey())) {
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

  public Category getCategoryByItem(ItemStack item) {
    for (Category category : categories) {
      if (category.getItem().isSimilar(item)) {
        return category;
      }
    }
    return null;
  }

  public Category getCategoryByKey(String key){
    for(Category category : categories){
      if(category.getKey().getKey().toLowerCase().equals(key.toLowerCase())){
        return category;
      }
    }
    return null;
  }
  
}
