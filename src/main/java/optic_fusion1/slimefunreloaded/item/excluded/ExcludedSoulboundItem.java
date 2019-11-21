package optic_fusion1.slimefunreloaded.item.excluded;

import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.item.NotPlaceable;
import optic_fusion1.slimefunreloaded.item.soulbound.SlimefunReloadedSoulboundItem;
import org.bukkit.inventory.ItemStack;

public class ExcludedSoulboundItem extends SlimefunReloadedSoulboundItem implements NotPlaceable{

  public ExcludedSoulboundItem(Category category, ItemStack item, String id) {
    super(category, item, id);
  }

}
