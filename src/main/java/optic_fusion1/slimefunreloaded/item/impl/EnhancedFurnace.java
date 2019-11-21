package optic_fusion1.slimefunreloaded.item.impl;

import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.item.SimpleSlimefunReloadedItem;
import optic_fusion1.slimefunreloaded.item.handler.BlockTicker;
import org.bukkit.inventory.ItemStack;

public class EnhancedFurnace extends SimpleSlimefunReloadedItem<BlockTicker>{

  public EnhancedFurnace(Category category, ItemStack item, String id) {
    super(category, item, id);
  }

}
