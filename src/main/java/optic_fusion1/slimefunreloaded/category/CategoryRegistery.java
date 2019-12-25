package optic_fusion1.slimefunreloaded.category;

import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.Slimefun;
import optic_fusion1.slimefunreloaded.category.type.LockedCategory;
import optic_fusion1.slimefunreloaded.category.type.SeasonalCategory;
import optic_fusion1.slimefunreloaded.util.CustomItem;
import optic_fusion1.slimefunreloaded.util.SlimefunReloadedItems;
import org.bukkit.Material;

public class CategoryRegistery {

  private static final CategoryManager CATEGORY_MANAGER = Slimefun.getCategoryManager();
  private static final String LORE = "&a> Click to open";

  public static void registerCategories() {
    register(new Category("WEAPONS", new CustomItem(Material.GOLDEN_SWORD, "&7Weapons", LORE), 1));
    register(new Category("PORTABLE", new CustomItem(SlimefunReloadedItems.BACKPACK_MEDIUM, "&7Items", "", LORE), 1));
    register(new Category("FOOD", new CustomItem(Material.APPLE, "&7Food", "", LORE), 2));
    Category MACHINES_1 = new Category("BASIC_MACHINES", new CustomItem(Material.SMITHING_TABLE, "&7Basic Machines", "", LORE), 1);
    register(MACHINES_1);
    register(new LockedCategory("ELECTRICITY", new CustomItem(SlimefunReloadedItems.NUCLEAR_REACTOR, "&bEnergy and Electricity", "", LORE), 4, MACHINES_1));
    register(new LockedCategory("GPS", new CustomItem(SlimefunReloadedItems.GPS_TRANSMITTER, "&bGPS-based Machines", "", LORE), 4, MACHINES_1));
    register(new Category("ARMOR", new CustomItem(Material.IRON_CHESTPLATE, "&7Armor", "", LORE)));
    register(new Category("LUMPS_AND_MAGIC", new CustomItem(SlimefunReloadedItems.RUNE_ENDER, "&7Magical Items", "", LORE), 2));
    register(new Category("MAGIC", new CustomItem(Material.ELYTRA, "&7Magical Gadgets", "", LORE)));
    register(new Category("MISC", new CustomItem(SlimefunReloadedItems.CAN, "&7Miscellaneous", "", LORE), 2));
    register(new Category("TECH", new CustomItem(Material.LEATHER_CHESTPLATE, "&7Technical Gadgets"), 3));
    register(new Category("RESOURCES", new CustomItem(SlimefunReloadedItems.SYNTHETIC_SAPPHIRE, "&7Resources", "", LORE), 1));
    register(new LockedCategory("CARGO", new CustomItem(SlimefunReloadedItems.CARGO_MANAGER, "&cCargo Management", "", LORE), 4, MACHINES_1));
    register(new Category("TECH_MISC", new CustomItem(SlimefunReloadedItems.HEATING_COIL, "&7Technical Components", "", LORE), 2));
    register(new Category("MAGIC_ARMOR", new CustomItem(SlimefunReloadedItems.ENDER_HELMET, "&7Magical Armor", "", LORE), 2));
    Category TALISMANS_1 = new Category("TALISMANS_1", new CustomItem(Material.EMERALD, "&7Talismans - &aTier I", "", LORE), 2);
    register(TALISMANS_1);
    register(new LockedCategory("TALISMANS_2", new CustomItem(Material.EMERALD, "&7Talismans - &aTier II", "", LORE), 3, TALISMANS_1));
    register(new Category("TOOLS", new CustomItem(Material.EMERALD, "&7Tools", "", LORE), 1));

    // Seasonal Categories
    register(new SeasonalCategory("CHRISTMAS", new CustomItem(Material.NETHER_STAR, "Christmas", "", "&c> Click to help &aSanta"), 1, 12));
    register(new SeasonalCategory("VALENTINES DAY", new CustomItem(Material.POPPY, "&dValentine's Day", "", "&d> Click here to celebrate love"), 2, 2));
    register(new SeasonalCategory("EASTER", new CustomItem(Material.EGG, "&6Easter", "", "&a> Click to paint some eggs"), 4, 2));
  }

  public static void register(Category category) {
    CATEGORY_MANAGER.addCategory(category);
  }

}
