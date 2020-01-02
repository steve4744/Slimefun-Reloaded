package optic_fusion1.slimefunreloaded.category.type;

import java.util.Calendar;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

public class SeasonalCategory extends Category {

  private int month = -1;

  public SeasonalCategory(NamespacedKey key, ItemStack itemStack, int month) {
    this(key, itemStack, 3, month);
  }

  public SeasonalCategory(NamespacedKey key, ItemStack item, int tier, int month) {
    super(key, item, tier);
    this.month = month;
  }

  public int getMonth() {
    return month;
  }

  public boolean isUnlocked() {
    if (month == -1) {
      return true;
    }
    Calendar calendar = Calendar.getInstance();
    return month == calendar.get(Calendar.MONTH);
  }

}
