package optic_fusion1.slimefunreloaded.component;

import optic_fusion1.slimefunreloaded.Slimefun;
import optic_fusion1.slimefunreloaded.category.CategoryManager;
import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.component.item.impl.PortableCrafter;
import optic_fusion1.slimefunreloaded.component.item.impl.PortableDustbin;
import optic_fusion1.slimefunreloaded.component.item.impl.SimpleSlimefunReloadedItem;
import optic_fusion1.slimefunreloaded.component.item.impl.SoulboundItem;
import optic_fusion1.slimefunreloaded.component.item.impl.SwordOfBeheading;
import optic_fusion1.slimefunreloaded.util.SlimefunReloadedItemStack;
import optic_fusion1.slimefunreloaded.util.SlimefunReloadedItems;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public final class ComponentRegistry {

  private static final ComponentManager COMPONENT_MANAGER = Slimefun.getComponentManager();
  private static final CategoryManager CATEGORY_MANAGER = Slimefun.getCategoryManager();

  private ComponentRegistry() {
  }

  public static void registerComponents() {
    //Weapon Registery
    Category WEAPONS = CATEGORY_MANAGER.getCategoryByName("Weapons");
    new SimpleSlimefunReloadedItem(WEAPONS, (SlimefunReloadedItemStack) SlimefunReloadedItems.GRANDMAS_WALKING_STICK, RecipeType.ENHANCED_CRAFTING_TABLE,
     new ItemStack[]{null, new ItemStack(Material.OAK_LOG), null, null, new ItemStack(Material.OAK_LOG), null, null, new ItemStack(Material.OAK_LOG), null});
    new SimpleSlimefunReloadedItem(WEAPONS, (SlimefunReloadedItemStack) SlimefunReloadedItems.GRANDPAS_WALKING_STICK, RecipeType.ENHANCED_CRAFTING_TABLE,
     new ItemStack[]{new ItemStack(Material.LEATHER), new ItemStack(Material.OAK_LOG), new ItemStack(Material.LEATHER), null, new ItemStack(Material.OAK_LOG), null, null, new ItemStack(Material.OAK_LOG), null});
    new SwordOfBeheading(WEAPONS, (SlimefunReloadedItemStack) SlimefunReloadedItems.SWORD_OF_BEHEADING, RecipeType.ENHANCED_CRAFTING_TABLE,
     new ItemStack[]{null, new ItemStack(Material.EMERALD), null, SlimefunReloadedItems.MAGIC_LUMP_2, new ItemStack(Material.EMERALD), SlimefunReloadedItems.MAGIC_LUMP_2, null, new ItemStack(Material.BLAZE_ROD), null}, new String[]{"chance.PLAYER", "chance.SKELETON", "chance.WITHER_SKELETON", "chance.ZOMBIE", "chance.CREEPER"}, new Integer[]{70, 40, 25, 40, 40});
    new SoulboundItem(WEAPONS, (SlimefunReloadedItemStack) SlimefunReloadedItems.SOULBOUND_SWORD,
     new ItemStack[]{null, SlimefunReloadedItems.ESSENCE_OF_AFTERLIFE, null, null, new ItemStack(Material.DIAMOND_SWORD), null, null, SlimefunReloadedItems.ESSENCE_OF_AFTERLIFE, null});
    new SoulboundItem(WEAPONS, (SlimefunReloadedItemStack) SlimefunReloadedItems.SOULBOUND_BOW,
     new ItemStack[]{null, SlimefunReloadedItems.ESSENCE_OF_AFTERLIFE, null, null, new ItemStack(Material.BOW), null, null, SlimefunReloadedItems.ESSENCE_OF_AFTERLIFE, null});
    Category PORTABLE = CATEGORY_MANAGER.getCategoryByName("Portable");
    new PortableCrafter(PORTABLE, (SlimefunReloadedItemStack) SlimefunReloadedItems.PORTABLE_CRAFTER, RecipeType.ENHANCED_CRAFTING_TABLE,
     new ItemStack[]{new ItemStack(Material.BOOK), new ItemStack(Material.CRAFTING_TABLE), null, null, null, null, null, null, null});
    new PortableDustbin(PORTABLE, (SlimefunReloadedItemStack) SlimefunReloadedItems.PORTABLE_DUSTBIN, RecipeType.ENHANCED_CRAFTING_TABLE,
     new ItemStack[]{new ItemStack(Material.IRON_INGOT), new ItemStack(Material.IRON_INGOT), new ItemStack(Material.IRON_INGOT), new ItemStack(Material.IRON_INGOT), null, new ItemStack(Material.IRON_INGOT), new ItemStack(Material.IRON_INGOT), new ItemStack(Material.IRON_INGOT), new ItemStack(Material.IRON_INGOT)});

  }

  private void register(SlimefunReloadedComponent component) {
    COMPONENT_MANAGER.registerComponent(component);
  }

}
