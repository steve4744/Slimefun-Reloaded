package optic_fusion1.slimefunreloaded.category;

import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.Slimefun;
import optic_fusion1.slimefunreloaded.SlimefunReloaded;
import optic_fusion1.slimefunreloaded.category.type.LockedCategory;
import optic_fusion1.slimefunreloaded.category.type.SeasonalCategory;
import optic_fusion1.slimefunreloaded.util.CustomItem;
import optic_fusion1.slimefunreloaded.util.SlimefunReloadedItems;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

public class CategoryRegistery {

  private static final CategoryManager CATEGORY_MANAGER = Slimefun.getCategoryManager();
  private static final String LORE = "&a> Click to open";
  private static final SlimefunReloaded PLUGIN = Slimefun.getSlimefunReloaded();

  public static void registerCategories() {
    register("WEAPONS", new CustomItem(Material.GOLDEN_SWORD, "&7Weapons", LORE), 1);
    register("PORTABLE", new CustomItem(SlimefunReloadedItems.BACKPACK_MEDIUM, "&7Items", "", LORE), 1);
    register("FOOD", new CustomItem(Material.APPLE, "&7Food", "", LORE), 2);
    Category MACHINES_1 = new Category(new NamespacedKey(PLUGIN, "BASIC_MACHINES"), new CustomItem(Material.SMITHING_TABLE, "&7Basic Machines", "", LORE), 1);
    register(MACHINES_1);
    registerLockedCategory("ELECTRICITY", new CustomItem(SlimefunReloadedItems.NUCLEAR_REACTOR, "&bEnergy and Electricity", "", LORE), 4, MACHINES_1);
    registerLockedCategory("GPS", new CustomItem(SlimefunReloadedItems.GPS_TRANSMITTER, "&bGPS-based Machines", "", LORE), 4, MACHINES_1);
    register("ARMOR", new CustomItem(Material.IRON_CHESTPLATE, "&7Armor", "", LORE), 2);
    register("LUMPS_AND_MAGIC", new CustomItem(SlimefunReloadedItems.RUNE_ENDER, "&7Magical Items", "", LORE), 2);
    register("MAGICAL_GADGETS", new CustomItem(Material.ELYTRA, "&7Magical Gadgets", "", LORE), 2);
    register("MISC", new CustomItem(SlimefunReloadedItems.CAN, "&7Miscellaneous", "", LORE), 2);
    register("TECHNICAL_GADGETS", new CustomItem(Material.LEATHER_CHESTPLATE, "&7Technical Gadgets"), 3);
    register("RESOURCES", new CustomItem(SlimefunReloadedItems.SYNTHETIC_SAPPHIRE, "&7Resources", "", LORE), 1);
    registerLockedCategory("CARGO", new CustomItem(SlimefunReloadedItems.CARGO_MANAGER, "&cCargo Management", "", LORE), 4, MACHINES_1);
    register("TECHNICAL_COMPONENTS", new CustomItem(SlimefunReloadedItems.HEATING_COIL, "&7Technical Components", "", LORE), 2);
    register("MAGICAL_ARMOR", new CustomItem(SlimefunReloadedItems.ENDER_HELMET, "&7Magical Armor", "", LORE), 2);
    Category TALISMANS_1 = new Category(new NamespacedKey(PLUGIN, "TALISMANS_1"), new CustomItem(Material.EMERALD, "&7Talismans - &aTier I", "", LORE), 2);
    register(TALISMANS_1);
    registerLockedCategory("TALISMANS_2", new CustomItem(Material.EMERALD, "&7Talismans - &aTier II", "", LORE), 3, TALISMANS_1);
    register("TOOLS", new CustomItem(Material.EMERALD, "&7Tools", "", LORE), 1);
    //Seasonal Categories
    registerSeasonalCategory("CHRISTMAS", new CustomItem(Material.NETHER_STAR, "Christmas", "", "&c>Click to help &aSanta"), 1, 12);
    registerSeasonalCategory("VALENTINES_DAY", new CustomItem(Material.POPPY, "&dValentine's Day", "", "&d> Click here to celebrate love"), 2, 2);
    registerSeasonalCategory("EASTER", new CustomItem(Material.EGG, "&6Easter", "", "&a> Click to paint some eggs"), 4, 2);
  }

  private static void registerSeasonalCategory(String namespace, ItemStack item, int tier, int month){
    register(new SeasonalCategory(new NamespacedKey(PLUGIN, namespace), item, tier, month));
  }
  
  private static void registerLockedCategory(String namespace, ItemStack item, int tier, Category... parents) {
    register(new LockedCategory(new NamespacedKey(PLUGIN, namespace), item, tier, parents));
  }

  private static void register(String namespace, ItemStack item, int tier) {
    register(new Category(new NamespacedKey(PLUGIN, namespace), item, tier));
  }

  private static void register(Category category) {
    CATEGORY_MANAGER.addCategory(category);
  }

}
