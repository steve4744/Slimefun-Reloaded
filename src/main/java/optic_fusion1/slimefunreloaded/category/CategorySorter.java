package optic_fusion1.slimefunreloaded.category;

import optic_fusion1.slimefunreloaded.category.type.Category;
import java.util.Comparator;

public class CategorySorter implements Comparator<Category> {

  @Override
  public int compare(Category categoryOne, Category categoryTwo) {
    return Integer.compare(categoryOne.getTier(), categoryTwo.getTier());
  }

}
