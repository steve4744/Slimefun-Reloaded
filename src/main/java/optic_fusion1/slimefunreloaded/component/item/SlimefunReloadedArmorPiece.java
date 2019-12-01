package optic_fusion1.slimefunreloaded.component.item;

import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.component.RecipeType;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

public class SlimefunReloadedArmorPiece extends SlimefunReloadedItem {

  private PotionEffect[] effects;

  public SlimefunReloadedArmorPiece(NamespacedKey key, Category category, ItemStack item, RecipeType recipeType, ItemStack[] recipe, PotionEffect[] effects) {
    super(key, category, item, recipeType, recipe);
    this.effects = effects;
  }

  public PotionEffect[] getEffects() {
    return this.effects;
  }

}
