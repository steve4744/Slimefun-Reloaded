package optic_fusion1.slimefunreloaded.category.type;

import java.util.Calendar;
import org.bukkit.inventory.ItemStack;

public class SeasonalCategory extends Category {

  private int month = -1;

  public SeasonalCategory(String name, ItemStack item, int month) {
    this(name, item, 3, month);
  }

  public SeasonalCategory(String name, ItemStack item, int tier, int month) {
    super(name, item, tier);
    this.month = month - 1;
  }

  public int getMonth() {
    return this.month;
  }

  public boolean isUnlocked() {
    if (month == -1) {
      return true;
    }
    Calendar calendar = Calendar.getInstance();
    return month == calendar.get(Calendar.MONTH);
  }
}
