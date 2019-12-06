package optic_fusion1.slimefunreloaded.component;

import optic_fusion1.slimefunreloaded.Slimefun;
import optic_fusion1.slimefunreloaded.SlimefunReloaded;
import optic_fusion1.slimefunreloaded.category.CategoryManager;
import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.component.item.impl.SimpleSlimefunReloadedItem;
import optic_fusion1.slimefunreloaded.component.item.impl.SoulboundItem;
import optic_fusion1.slimefunreloaded.util.SlimefunReloadedItemStack;
import optic_fusion1.slimefunreloaded.util.SlimefunReloadedItems;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

public final class ComponentRegistry {

  private static final ComponentManager COMPONENT_MANAGER = Slimefun.getComponentManager();
  private static final CategoryManager CATEGORY_MANAGER = Slimefun.getCategoryManager();
  private static final SlimefunReloaded plugin = Slimefun.getSlimefunReloaded();

  private ComponentRegistry() {
  }

  //TODO: Clean this up
  public static void registerComponents() {
    //Weapon Registery
    Category WEAPONS = CATEGORY_MANAGER.getCategoryByName("Weapons");
    registerSimpleSlimefunReloadedItem("grandmas_walking_stick", WEAPONS, SlimefunReloadedItems.GRANDMAS_WALKING_STICK, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{null, new ItemStack(Material.OAK_LOG), null, null, new ItemStack(Material.OAK_LOG), null, null, new ItemStack(Material.OAK_LOG), null});
    registerSimpleSlimefunReloadedItem("grandpas_walking_stick", WEAPONS, SlimefunReloadedItems.GRANDPAS_WALKING_STICK, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{new ItemStack(Material.LEATHER), new ItemStack(Material.OAK_LOG), new ItemStack(Material.LEATHER), null, new ItemStack(Material.OAK_LOG), null, null, new ItemStack(Material.OAK_LOG), null});
    registerSimpleSlimefunReloadedItem("sword_of_beheading", WEAPONS, SlimefunReloadedItems.SWORD_OF_BEHEADING, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{null, new ItemStack(Material.EMERALD), null, SlimefunReloadedItems.MAGIC_LUMP_2, new ItemStack(Material.EMERALD), SlimefunReloadedItems.MAGIC_LUMP_2, null, new ItemStack(Material.BLAZE_ROD), null}, new String[]{"chance.PLAYER", "chance.SKELETON", "chance.WITHER_SKELETON", "chance.ZOMBIE", "chance.CREEPER"}, new Integer[]{70, 40, 25, 40, 40});
  }

  private static void registerSimpleSlimefunReloadedItem(String namespace, Category category, ItemStack item, RecipeType type,
   ItemStack[] recipe, String[] keys, Object[] values) {
    register(new SimpleSlimefunReloadedItem(new NamespacedKey(plugin, namespace), category, item, type, recipe, keys, values));
  }

  private static void registerSimpleSlimefunReloadedItem(String namespace, Category category, ItemStack item, RecipeType type,
   ItemStack[] recipe) {
    register(new SimpleSlimefunReloadedItem(new NamespacedKey(plugin, namespace), category, item, type, recipe));
  }

  private static void register(SlimefunReloadedComponent component) {
    COMPONENT_MANAGER.registerComponent(component);
  }

}
