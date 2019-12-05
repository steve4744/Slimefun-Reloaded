package optic_fusion1.slimefunreloaded.component.item.impl;

import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.component.RecipeType;
import optic_fusion1.slimefunreloaded.component.item.SlimefunReloadedItem;
import optic_fusion1.slimefunreloaded.component.item.interfaces.Soulbound;
import optic_fusion1.slimefunreloaded.util.SlimefunReloadedItemStack;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

public class SoulboundItem extends SlimefunReloadedItem implements Soulbound {

  public SoulboundItem(NamespacedKey key, Category category, SlimefunReloadedItemStack item, ItemStack[] recipe) {
    super(key, category, item, RecipeType.MAGIC_WORKBENCH, recipe);
  }

}
