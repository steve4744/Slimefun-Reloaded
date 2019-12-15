package optic_fusion1.slimefunreloaded.component.item;

import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.component.RecipeType;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

public class DamagableChargableItem extends SlimefunReloadedItem {

  private String chargeType;

  public DamagableChargableItem(NamespacedKey key, Category category, ItemStack item, RecipeType recipeType, ItemStack[] recipe, String chargeType) {
    super(key, category, item, recipeType, recipe);
    this.chargeType = chargeType;
  }

  public DamagableChargableItem(NamespacedKey key, Category category, ItemStack item, RecipeType recipeType, ItemStack[] recipe, String[] keys, Object[] values, String chargeType) {
    super(key, category, item, recipeType, recipe, keys, values);
    this.chargeType = chargeType;
  }

  public String getChargeType() {
    return chargeType;
  }

}
