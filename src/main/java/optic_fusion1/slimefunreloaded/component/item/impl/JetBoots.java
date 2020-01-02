package optic_fusion1.slimefunreloaded.component.item.impl;

import optic_fusion1.slimefunreloaded.Slimefun;
import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.component.RecipeType;
import optic_fusion1.slimefunreloaded.component.item.DamagableChargableItem;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

public class JetBoots extends DamagableChargableItem {

  private static final Category CATEGORY = Slimefun.getCategoryManager().getCategoryByKey("TECHNICAL_GADGETS");
  private double speed;

  public JetBoots(NamespacedKey key, ItemStack item, ItemStack[] recipe, double speed) {
    super(key, CATEGORY, item, RecipeType.ENHANCED_CRAFTING_TABLE, recipe, "Jet Boots");
    this.speed = speed;
  }

  public JetBoots(NamespacedKey key, ItemStack item, ItemStack[] recipe, String[] keys, Object[] values, double speed) {
    super(key, CATEGORY, item, RecipeType.ENHANCED_CRAFTING_TABLE, recipe, keys, values, "Jet Boots");
    this.speed = speed;
  }

  public double getSpeed() {
    return speed;
  }

}
