package optic_fusion1.slimefunreloaded.component.item;

import optic_fusion1.slimefunreloaded.Slimefun;
import optic_fusion1.slimefunreloaded.SlimefunReloaded;
import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.component.RecipeType;
import optic_fusion1.slimefunreloaded.util.CustomItem;
import optic_fusion1.slimefunreloaded.util.SlimefunReloadedItemStack;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

public class SlimefunReloadedTalisman extends SlimefunReloadedItem {

  protected final String suffix;
  protected final boolean consumable;
  protected final boolean cancel;
  protected final PotionEffect[] effects;
  protected final int chance;
  private static final Category TALISMANS_1 = Slimefun.getCategoryManager().getCategoryByKey("TALISMANS_1");
  private static final SlimefunReloaded PLUGIN = Slimefun.getSlimefunReloaded();

  public SlimefunReloadedTalisman(String namespace, SlimefunReloadedItemStack item, ItemStack[] recipe, boolean consumable, boolean cancelEvent, String messageSuffix, PotionEffect... effects) {
    this(namespace, item, recipe, consumable, cancelEvent, messageSuffix, 100, effects);
  }

  public SlimefunReloadedTalisman(String namespace, SlimefunReloadedItemStack item, ItemStack[] recipe, String messageSuffix, int chance, PotionEffect... effects) {
    this(namespace, item, recipe, true, true, messageSuffix, chance, effects);
  }

  public SlimefunReloadedTalisman(String namespace, SlimefunReloadedItemStack item, ItemStack[] recipe, boolean consumable, boolean cancelEvent, String messageSuffix, int chance, PotionEffect... effects) {
    this(namespace, TALISMANS_1, item, recipe, consumable, cancelEvent, messageSuffix, chance, effects);
  }

  protected SlimefunReloadedTalisman(String namespace, Category category, SlimefunReloadedItemStack item, ItemStack[] recipe, boolean consumable, boolean cancelEvent, String messageSuffix, int chance, PotionEffect... effects) {
    super(new NamespacedKey(PLUGIN, namespace), category, item, RecipeType.MAGIC_WORKBENCH, recipe, new CustomItem(item, consumable ? 4 : 1));

    this.consumable = consumable;
    this.cancel = cancelEvent;
    this.suffix = messageSuffix;
    this.effects = effects;
    this.chance = chance;
  }
}
