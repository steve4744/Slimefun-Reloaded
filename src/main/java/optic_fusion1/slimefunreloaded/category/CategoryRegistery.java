package optic_fusion1.slimefunreloaded.category;

import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.Slimefun;
import optic_fusion1.slimefunreloaded.builder.ItemStackBuilder;
import optic_fusion1.slimefunreloaded.category.type.LockedCategory;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class CategoryRegistery {

  private static final CategoryManager CATEGORY_MANAGER = Slimefun.getCategoryManager();
  private static final String LORE = "&a> Click to open";

  public void registerCategories() {
    ItemStack weapons = new ItemStackBuilder(Material.GOLDEN_SWORD).setDisplayName("&7Weapons").addLore("").addLore(LORE).build();
    Category weaponsCategory = new Category("Weapons", weapons, 1);
    register(weaponsCategory);
    //public static final Category PORTABLE = new Category(new CustomItem(SlimefunReloadedItems.BACKPACK_MEDIUM, "&7Items", "", LORE), 1);
    ItemStack food = new ItemStackBuilder(Material.APPLE).setDisplayName("&7Food").addLore("").addLore(LORE).build();
    Category foodCategory = new Category("Food", food, 2);
    register(foodCategory);
    ItemStack machines = new ItemStackBuilder(Material.SMITHING_TABLE).setDisplayName("&7Basic Machines").addLore("").addLore(LORE).build();
    Category machinesCategory = new Category("Machines", machines, 1);
    register(machinesCategory);
//    	public static final LockedCategory ELECTRICITY = new LockedCategory(new CustomItem(SlimefunReloadedItems.NUCLEAR_REACTOR, "&bEnergy and Electricity", "", LORE), 4, MACHINES_1);
//	public static final LockedCategory GPS = new LockedCategory(new CustomItem(SlimefunReloadedItems.GPS_TRANSMITTER, "&bGPS-based Machines", "", LORE), 4, MACHINES_1);
    ItemStack armor = new ItemStackBuilder(Material.IRON_CHESTPLATE).setDisplayName("&7Armor").addLore("").addLore(LORE).build();
    Category armorCategory = new Category("Armor", armor, 2);
    register(armorCategory);
//    	public static final Category LUMPS_AND_MAGIC = new Category(new CustomItem(SlimefunReloadedItems.RUNE_ENDER, "&7Magical Items", "", LORE), 2);
    ItemStack magic = new ItemStackBuilder(Material.ELYTRA).setDisplayName("&7Magical Gadgets").addLore("").addLore(LORE).build();
    Category magicCategory = new Category("Magic", magic, 3);
    register(magicCategory);
    //	public static final Category MISC = new Category(new CustomItem(SlimefunReloadedItems.CAN, "&7Miscellaneous", "", LORE), 2);
    ItemStack tech = new ItemStackBuilder(Material.LEATHER_CHESTPLATE)/*.setColor(Color.SILVER)*/.setDisplayName("&7Technical Gadgets").addLore("").addLore(LORE).build();
    Category techCategory = new Category("Tech", tech, 3);
    register(techCategory);
//    	public static final Category RESOURCES = new Category(new CustomItem(SlimefunReloadedItems.SYNTHETIC_SAPPHIRE, "&7Resources", "", LORE), 1);
//	public static final Category CARGO = new LockedCategory(new CustomItem(SlimefunReloadedItems.CARGO_MANAGER, "&cCargo Management", "", LORE), 4, MACHINES_1);
//	public static final Category TECH_MISC = new Category(new CustomItem(SlimefunReloadedItems.HEATING_COIL, "&7Technical Components", "", LORE), 2);
//	public static final Category MAGIC_ARMOR = new Category(new CustomItem(SlimefunReloadedItems.ENDER_HELMET, "&7Magical Armor", "", LORE), 2);
    ItemStack talismans_1 = new ItemStackBuilder(Material.EMERALD).setDisplayName("&7Talismans - &aTier I").addLore("").addLore(LORE).build();
    Category talismans_1Category = new Category("Talismans I", talismans_1, 2);
    register(talismans_1Category);
    ItemStack talismans_2 = new ItemStackBuilder(Material.EMERALD).setDisplayName("&7Talismans - &aTier II").addLore("").addLore(LORE).build();
    LockedCategory talismans_2Category = new LockedCategory("Talismans II", talismans_2, 3, talismans_1Category);
    register(talismans_2Category);
    ItemStack tools = new ItemStackBuilder(Material.GOLDEN_PICKAXE).setDisplayName("&7Tools").addLore("").addLore(LORE).build();
    Category toolsCategory = new Category("Tools", tools, 1);
    register(toolsCategory);
    // Seasonal Categories
//	public static final SeasonalCategory CHRISTMAS = new SeasonalCategory(12, 1, new CustomItem(Material.NETHER_STAR, Christmas.color("Christmas"), "", "&c> Click to help &aSanta"));
//	public static final SeasonalCategory VALENTINES_DAY = new SeasonalCategory(2, 2, new CustomItem(Material.POPPY, "&dValentine's Day", "", "&d> Click to celebrate Love"));
//	public static final SeasonalCategory EASTER = new SeasonalCategory(4, 2, new CustomItem(Material.EGG, "&6Easter", "", "&a> Click to paint some Eggs"));
//	public static final SeasonalCategory BIRTHDAY = new SeasonalCategory(10, 1, new CustomItem(Material.FIREWORK_ROCKET, "&a&lTheBusyBiscuit's Birthday &7(26th October)", "", "&a> Click to celebrate with me"));
  }

  private void register(Category category) {
    CATEGORY_MANAGER.addCategory(category);
  }

}
