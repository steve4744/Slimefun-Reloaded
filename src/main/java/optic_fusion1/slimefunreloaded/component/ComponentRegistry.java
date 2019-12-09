package optic_fusion1.slimefunreloaded.component;

import optic_fusion1.slimefunreloaded.Slimefun;
import optic_fusion1.slimefunreloaded.SlimefunReloaded;
import optic_fusion1.slimefunreloaded.category.CategoryManager;
import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.component.gadget.impl.Composter;
import optic_fusion1.slimefunreloaded.component.item.SlimefunReloadedBackpack;
import optic_fusion1.slimefunreloaded.component.item.SlimefunReloadedJuice;
import optic_fusion1.slimefunreloaded.component.item.SoulboundBackpack;
import optic_fusion1.slimefunreloaded.component.item.impl.Bandage;
import optic_fusion1.slimefunreloaded.component.item.impl.DietCookie;
import optic_fusion1.slimefunreloaded.component.item.impl.FortuneCookie;
import optic_fusion1.slimefunreloaded.component.item.impl.MagicSugar;
import optic_fusion1.slimefunreloaded.component.item.impl.MeatJerky;
import optic_fusion1.slimefunreloaded.component.item.impl.Medicine;
import optic_fusion1.slimefunreloaded.component.item.impl.MonsterJerky;
import optic_fusion1.slimefunreloaded.component.item.impl.PortableCrafter;
import optic_fusion1.slimefunreloaded.component.item.impl.PortableDustbin;
import optic_fusion1.slimefunreloaded.component.item.impl.Rag;
import optic_fusion1.slimefunreloaded.component.item.impl.SimpleSlimefunReloadedItem;
import optic_fusion1.slimefunreloaded.component.item.impl.SoulboundItem;
import optic_fusion1.slimefunreloaded.component.item.impl.SoulboundRune;
import optic_fusion1.slimefunreloaded.component.item.impl.Splint;
import optic_fusion1.slimefunreloaded.component.item.impl.Vitamins;
import optic_fusion1.slimefunreloaded.util.CustomItem;
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
    registerSoulboundItem("soulbound_sword", WEAPONS, (SlimefunReloadedItemStack) SlimefunReloadedItems.SOULBOUND_SWORD, new ItemStack[]{null, SlimefunReloadedItems.ESSENCE_OF_AFTERLIFE, null, null, new ItemStack(Material.DIAMOND_SWORD), null, null, SlimefunReloadedItems.ESSENCE_OF_AFTERLIFE, null});
    registerSoulboundItem("soulbound_bow", WEAPONS, (SlimefunReloadedItemStack) SlimefunReloadedItems.SOULBOUND_BOW, new ItemStack[]{null, SlimefunReloadedItems.ESSENCE_OF_AFTERLIFE, null, null, new ItemStack(Material.DIAMOND_PICKAXE), null, null, SlimefunReloadedItems.ESSENCE_OF_AFTERLIFE, null});
    //Portable Registery
    Category PORTABLE = CATEGORY_MANAGER.getCategoryByName("Portable");
    register(new PortableCrafter(new NamespacedKey(plugin, "portable_crafter"), PORTABLE, (SlimefunReloadedItemStack) SlimefunReloadedItems.PORTABLE_CRAFTER, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{new ItemStack(Material.BOOK), new ItemStack(Material.CRAFTING_TABLE), null, null, null, null, null, null, null}));
    register(new PortableDustbin(new NamespacedKey(plugin, "portable_dustbin"), PORTABLE, (SlimefunReloadedItemStack) SlimefunReloadedItems.PORTABLE_DUSTBIN, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{new ItemStack(Material.IRON_INGOT), new ItemStack(Material.IRON_INGOT), new ItemStack(Material.IRON_INGOT), new ItemStack(Material.IRON_INGOT), null, new ItemStack(Material.IRON_INGOT), new ItemStack(Material.IRON_INGOT), new ItemStack(Material.IRON_INGOT), new ItemStack(Material.IRON_INGOT)}));
    register(new Rag(new NamespacedKey(plugin, "rag"), PORTABLE, (SlimefunReloadedItemStack) SlimefunReloadedItems.RAG, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{SlimefunReloadedItems.CLOTH, SlimefunReloadedItems.CLOTH, SlimefunReloadedItems.CLOTH, new ItemStack(Material.STRING), null, new ItemStack(Material.STRING), SlimefunReloadedItems.CLOTH, SlimefunReloadedItems.CLOTH, SlimefunReloadedItems.CLOTH}));
    register(new Bandage(new NamespacedKey(plugin, "bandage"), PORTABLE, (SlimefunReloadedItemStack) SlimefunReloadedItems.BANDAGE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{SlimefunReloadedItems.RAG, new ItemStack(Material.STRING), SlimefunReloadedItems.RAG, null, null, null, null, null, null}, new CustomItem(SlimefunReloadedItems.BANDAGE, 4), new String[]{"enable-bleeding"}, new Boolean[]{true}));
    register(new Splint(new NamespacedKey(plugin, "splint"), PORTABLE, (SlimefunReloadedItemStack) SlimefunReloadedItems.SPLINT, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{null, new ItemStack(Material.IRON_INGOT), null, new ItemStack(Material.STICK), new ItemStack(Material.STICK), new ItemStack(Material.STICK), null, new ItemStack(Material.IRON_INGOT), null}, new CustomItem(SlimefunReloadedItems.SPLINT, 4), new String[]{"enable-broken-legs"}, new Boolean[]{true}));
    register(new Vitamins(new NamespacedKey(plugin, "vitamins"), WEAPONS, (SlimefunReloadedItemStack) SlimefunReloadedItems.VITAMINS, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{SlimefunReloadedItems.CAN, new ItemStack(Material.APPLE), new ItemStack(Material.RED_MUSHROOM), new ItemStack(Material.SUGAR), null, null, null, null, null}));
    register(new Medicine(new NamespacedKey(plugin, "medicine"), PORTABLE, (SlimefunReloadedItemStack) SlimefunReloadedItems.MEDICINE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{SlimefunReloadedItems.VITAMINS, new ItemStack(Material.GLASS_BOTTLE), SlimefunReloadedItems.HEAVY_CREAM, null, null, null, null, null, null}));
    registerBackpack("backpack_small", PORTABLE, (SlimefunReloadedItemStack) SlimefunReloadedItems.BACKPACK_SMALL, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{new ItemStack(Material.LEATHER), null, new ItemStack(Material.LEATHER), SlimefunReloadedItems.GOLD_6K, new ItemStack(Material.CHEST), SlimefunReloadedItems.GOLD_6K, new ItemStack(Material.LEATHER), new ItemStack(Material.LEATHER), new ItemStack(Material.LEATHER)}, 9);
    registerBackpack("backpack_medium", PORTABLE, (SlimefunReloadedItemStack) SlimefunReloadedItems.BACKPACK_MEDIUM, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{new ItemStack(Material.LEATHER), null, new ItemStack(Material.LEATHER), SlimefunReloadedItems.GOLD_10K, SlimefunReloadedItems.BACKPACK_SMALL, SlimefunReloadedItems.GOLD_10K, new ItemStack(Material.LEATHER), new ItemStack(Material.LEATHER), new ItemStack(Material.LEATHER)}, 18);
    registerBackpack("backpack_large", PORTABLE, (SlimefunReloadedItemStack) SlimefunReloadedItems.BACKPACK_LARGE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{new ItemStack(Material.LEATHER), null, new ItemStack(Material.LEATHER), SlimefunReloadedItems.GOLD_14K, SlimefunReloadedItems.BACKPACK_MEDIUM, SlimefunReloadedItems.GOLD_14K, new ItemStack(Material.LEATHER), new ItemStack(Material.LEATHER), new ItemStack(Material.LEATHER)}, 27);
    registerBackpack("backpack_cloth", PORTABLE, (SlimefunReloadedItemStack) SlimefunReloadedItems.WOVEN_BACKPACK, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{SlimefunReloadedItems.CLOTH, null, SlimefunReloadedItems.CLOTH, SlimefunReloadedItems.GOLD_16K, SlimefunReloadedItems.BACKPACK_LARGE, SlimefunReloadedItems.GOLD_16K, SlimefunReloadedItems.CLOTH, SlimefunReloadedItems.CLOTH, SlimefunReloadedItems.CLOTH}, 36);
    registerBackpack("backpack_gilded", PORTABLE, (SlimefunReloadedItemStack) SlimefunReloadedItems.GILDED_BACKPACK, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{SlimefunReloadedItems.GOLD_22K, null, SlimefunReloadedItems.GOLD_22K, new ItemStack(Material.LEATHER), SlimefunReloadedItems.WOVEN_BACKPACK, new ItemStack(Material.LEATHER), SlimefunReloadedItems.GOLD_22K, null, SlimefunReloadedItems.GOLD_22K}, 45);
    registerBackpack("backpack_radiant", PORTABLE, (SlimefunReloadedItemStack) SlimefunReloadedItems.RADIANT_BACKPACK, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{SlimefunReloadedItems.GOLD_24K, null, SlimefunReloadedItems.GOLD_24K, new ItemStack(Material.LEATHER), SlimefunReloadedItems.GILDED_BACKPACK, new ItemStack(Material.LEATHER), SlimefunReloadedItems.GOLD_24K, null, SlimefunReloadedItems.GOLD_24K}, 54);
    register(new SoulboundBackpack(new NamespacedKey(plugin, "backpack_soulbound"), PORTABLE, (SlimefunReloadedItemStack) SlimefunReloadedItems.BOUND_BACKPACK, null, new ItemStack[]{SlimefunReloadedItems.ENDER_LUMP_2, null, SlimefunReloadedItems.ENDER_LUMP_2, SlimefunReloadedItems.ESSENCE_OF_AFTERLIFE, SlimefunReloadedItems.WOVEN_BACKPACK, SlimefunReloadedItems.ESSENCE_OF_AFTERLIFE, SlimefunReloadedItems.ENDER_LUMP_2, null, SlimefunReloadedItems.ENDER_LUMP_2}, 36));
    //FOOD Registery
    Category FOOD = CATEGORY_MANAGER.getCategoryByName("Food");
    register(new FortuneCookie(new NamespacedKey(plugin, "fortune_cookie"), FOOD, (SlimefunReloadedItemStack) SlimefunReloadedItems.FORTUNE_COOKIE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{new ItemStack(Material.COOKIE), new ItemStack(Material.PAPER), null, null, null, null, null, null, null}));
    register(new DietCookie(new NamespacedKey(plugin, "diet_cookie"), FOOD, (SlimefunReloadedItemStack) SlimefunReloadedItems.DIET_COOKIE, RecipeType.MAGIC_WORKBENCH, new ItemStack[]{new ItemStack(Material.COOKIE), SlimefunReloadedItems.ELYTRA_SCALE, null, null, null, null, null, null, null}));
    registerMeatJerky("beef_jerky", FOOD, (SlimefunReloadedItemStack) SlimefunReloadedItems.BEEF_JERKY, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{SlimefunReloadedItems.SALT, new ItemStack(Material.COOKED_BEEF), null, null, null, null, null, null, null});
    registerMeatJerky("pork_jerky", FOOD, (SlimefunReloadedItemStack) SlimefunReloadedItems.PORK_JERKY, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{SlimefunReloadedItems.SALT, new ItemStack(Material.COOKED_PORKCHOP), null, null, null, null, null, null, null});
    registerMeatJerky("chicken_jerky", FOOD, (SlimefunReloadedItemStack) SlimefunReloadedItems.CHICKEN_JERKY, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{SlimefunReloadedItems.SALT, new ItemStack(Material.COOKED_CHICKEN), null, null, null, null, null, null, null});
    registerMeatJerky("mutton_jerky", FOOD, (SlimefunReloadedItemStack) SlimefunReloadedItems.MUTTON_JERKY, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{SlimefunReloadedItems.SALT, new ItemStack(Material.COOKED_MUTTON), null, null, null, null, null, null, null});
    registerMeatJerky("rabbit_jerky", FOOD, (SlimefunReloadedItemStack) SlimefunReloadedItems.RABBIT_JERKY, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{SlimefunReloadedItems.SALT, new ItemStack(Material.COOKED_RABBIT), null, null, null, null, null, null, null});
    registerMeatJerky("fish_jerky", FOOD, (SlimefunReloadedItemStack) SlimefunReloadedItems.FISH_JERKY, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{SlimefunReloadedItems.SALT, new ItemStack(Material.COOKED_COD), null, null, null, null, null, null, null});
    register(new MagicSugar(new NamespacedKey(plugin, "magic_sugar"), FOOD, (SlimefunReloadedItemStack) SlimefunReloadedItems.MAGIC_SUGAR, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{new ItemStack(Material.SUGAR), new ItemStack(Material.REDSTONE), new ItemStack(Material.GLOWSTONE_DUST), null, null, null, null, null, null}, new String[]{"effects.SPEED"}, new Integer[]{4}));
    register(new MonsterJerky(new NamespacedKey(plugin, "monster_jerky"), FOOD, (SlimefunReloadedItemStack) SlimefunReloadedItems.MONSTER_JERKY, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{SlimefunReloadedItems.SALT, new ItemStack(Material.ROTTEN_FLESH), null, null, null, null, null, null, null}));
    registerJuice("apple_juice", FOOD, (SlimefunReloadedItemStack) SlimefunReloadedItems.APPLE_JUICE, RecipeType.JUICER, new ItemStack[]{new ItemStack(Material.APPLE), null, null, null, null, null, null, null, null});
    registerJuice("carrot_juice", FOOD, (SlimefunReloadedItemStack) SlimefunReloadedItems.CARROT_JUICE, RecipeType.JUICER, new ItemStack[]{new ItemStack(Material.CARROT), null, null, null, null, null, null, null, null});
    registerJuice("melon_juice", FOOD, (SlimefunReloadedItemStack) SlimefunReloadedItems.MELON_JUICE, RecipeType.JUICER, new ItemStack[]{new ItemStack(Material.MELON), null, null, null, null, null, null, null, null});
    registerJuice("pumpkin_juice", FOOD, (SlimefunReloadedItemStack) SlimefunReloadedItems.PUMPKIN_JUICE, RecipeType.JUICER, new ItemStack[]{new ItemStack(Material.PUMPKIN), null, null, null, null, null, null, null, null});
    registerJuice("sweet_berry_juice", FOOD, (SlimefunReloadedItemStack) SlimefunReloadedItems.SWEET_BERRY_JUICE, RecipeType.JUICER, new ItemStack[]{new ItemStack(Material.SWEET_BERRIES), null, null, null, null, null, null, null, null});
    registerJuice("golden_apple_juice", FOOD, (SlimefunReloadedItemStack) SlimefunReloadedItems.GOLDEN_APPLE_JUICE, RecipeType.JUICER, new ItemStack[]{new ItemStack(Material.GOLDEN_APPLE), null, null, null, null, null, null, null, null});
    //MACHINES_1 Registery
    Category MACHINES_1 = CATEGORY_MANAGER.getCategoryByName("Machines_1");
    registerSimpleSlimefunReloadedItem("output_chest", MACHINES_1, (SlimefunReloadedItemStack) SlimefunReloadedItems.OUTPUT_CHEST, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{SlimefunReloadedItems.LEAD_INGOT, new ItemStack(Material.HOPPER), SlimefunReloadedItems.LEAD_INGOT, SlimefunReloadedItems.LEAD_INGOT, new ItemStack(Material.CHEST), SlimefunReloadedItems.LEAD_INGOT, null, SlimefunReloadedItems.LEAD_INGOT, null});
    registerSimpleSlimefunReloadedItem("ignition_chamber", MACHINES_1, (SlimefunReloadedItemStack) SlimefunReloadedItems.IGNITION_CHAMBER, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{SlimefunReloadedItems.STEEL_PLATE, SlimefunReloadedItems.BASIC_CIRCUIT_BOARD, new ItemStack(Material.FLINT_AND_STEEL), SlimefunReloadedItems.ELECTRIC_MOTOR, SlimefunReloadedItems.STEEL_PLATE, SlimefunReloadedItems.ELECTRIC_MOTOR, null, new ItemStack(Material.HOPPER), null});
    register(new Composter(new NamespacedKey(plugin, "composter"), MACHINES_1, (SlimefunReloadedItemStack) SlimefunReloadedItems.COMPOSTER, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{new ItemStack(Material.OAK_SLAB), null, new ItemStack(Material.OAK_SLAB), new ItemStack(Material.OAK_SLAB), null, new ItemStack(Material.OAK_SLAB), new ItemStack(Material.OAK_SLAB), new ItemStack(Material.CAULDRON), new ItemStack(Material.OAK_SLAB)}));
    //LUMPS_AND_MAGIC Registery
    Category LUMPS_AND_MAGIC = CATEGORY_MANAGER.getCategoryByName("Lumps_and_magic");
    registerSimpleSlimefunReloadedItem("magic_lump_1", LUMPS_AND_MAGIC, (SlimefunReloadedItemStack) SlimefunReloadedItems.MAGIC_LUMP_1, RecipeType.GRIND_STONE, new ItemStack[]{new ItemStack(Material.NETHER_WART), null, null, null, null, null, null, null, null}, new CustomItem(SlimefunReloadedItems.MAGIC_LUMP_1, 2));
    registerSimpleSlimefunReloadedItem("magic_lump_2", LUMPS_AND_MAGIC, (SlimefunReloadedItemStack) SlimefunReloadedItems.MAGIC_LUMP_2, RecipeType.GRIND_STONE, new ItemStack[]{SlimefunReloadedItems.MAGIC_LUMP_1, SlimefunReloadedItems.MAGIC_LUMP_1, null, SlimefunReloadedItems.MAGIC_LUMP_1, SlimefunReloadedItems.MAGIC_LUMP_1, null, null, null, null});
    registerSimpleSlimefunReloadedItem("magic_lump_3", LUMPS_AND_MAGIC, (SlimefunReloadedItemStack) SlimefunReloadedItems.MAGIC_LUMP_3, RecipeType.GRIND_STONE, new ItemStack[]{SlimefunReloadedItems.MAGIC_LUMP_2, SlimefunReloadedItems.MAGIC_LUMP_2, null, SlimefunReloadedItems.MAGIC_LUMP_2, SlimefunReloadedItems.MAGIC_LUMP_2, null, null, null, null});
    registerSimpleSlimefunReloadedItem("ender_lump_1", LUMPS_AND_MAGIC, (SlimefunReloadedItemStack) SlimefunReloadedItems.ENDER_LUMP_1, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{null, null, null, null, new ItemStack(Material.ENDER_EYE), null, null, null, null}, new CustomItem(SlimefunReloadedItems.ENDER_LUMP_1, 2));
    registerSimpleSlimefunReloadedItem("ender_lump_2", LUMPS_AND_MAGIC, (SlimefunReloadedItemStack) SlimefunReloadedItems.ENDER_LUMP_2, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{SlimefunReloadedItems.ENDER_LUMP_1, SlimefunReloadedItems.ENDER_LUMP_1, null, SlimefunReloadedItems.ENDER_LUMP_1, SlimefunReloadedItems.ENDER_LUMP_1, null, null, null, null});
    registerSimpleSlimefunReloadedItem("ender_lump_3", LUMPS_AND_MAGIC, (SlimefunReloadedItemStack) SlimefunReloadedItems.ENDER_LUMP_3, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{SlimefunReloadedItems.ENDER_LUMP_2, SlimefunReloadedItems.ENDER_LUMP_2, null, SlimefunReloadedItems.ENDER_LUMP_2, SlimefunReloadedItems.ENDER_LUMP_2, null, null, null, null});
    registerSimpleSlimefunReloadedItem("magic_book_cover", LUMPS_AND_MAGIC, (SlimefunReloadedItemStack) SlimefunReloadedItems.MAGICAL_BOOK_COVER, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{null, SlimefunReloadedItems.MAGIC_LUMP_2, null, SlimefunReloadedItems.MAGIC_LUMP_2, new ItemStack(Material.BOOK), SlimefunReloadedItems.MAGIC_LUMP_2, null, SlimefunReloadedItems.MAGIC_LUMP_2, null});
    registerSimpleSlimefunReloadedItem("lava_crystal", LUMPS_AND_MAGIC, (SlimefunReloadedItemStack) SlimefunReloadedItems.LAVA_CRYSTAL, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{SlimefunReloadedItems.MAGIC_LUMP_1, new ItemStack(Material.BLAZE_POWDER), SlimefunReloadedItems.MAGIC_LUMP_1, new ItemStack(Material.BLAZE_POWDER), SlimefunReloadedItems.RUNE_FIRE, new ItemStack(Material.BLAZE_POWDER), SlimefunReloadedItems.MAGIC_LUMP_1, new ItemStack(Material.BLAZE_POWDER), SlimefunReloadedItems.MAGIC_LUMP_1});
    registerSimpleSlimefunReloadedItem("talisman", LUMPS_AND_MAGIC, (SlimefunReloadedItemStack) SlimefunReloadedItems.TALISMAN, RecipeType.MAGIC_WORKBENCH, new ItemStack[]{SlimefunReloadedItems.MAGIC_LUMP_2, SlimefunReloadedItems.GOLD_8K, SlimefunReloadedItems.MAGIC_LUMP_2, null, new ItemStack(Material.EMERALD), null, SlimefunReloadedItems.MAGIC_LUMP_2, SlimefunReloadedItems.GOLD_8K, SlimefunReloadedItems.MAGIC_LUMP_2}, new String[]{"recipe-requires-nether-stars"}, new Boolean[]{false});
    registerSimpleSlimefunReloadedItem("necrotic_skull", LUMPS_AND_MAGIC, (SlimefunReloadedItemStack) SlimefunReloadedItems.NECROTIC_SKULL, RecipeType.MAGIC_WORKBENCH, new ItemStack[]{SlimefunReloadedItems.MAGIC_LUMP_3, null, SlimefunReloadedItems.MAGIC_LUMP_3, null, new ItemStack(Material.WITHER_SKELETON_SKULL), null, SlimefunReloadedItems.MAGIC_LUMP_3, null, SlimefunReloadedItems.MAGIC_LUMP_3});
    registerSimpleSlimefunReloadedItem("essence_of_afterlife", LUMPS_AND_MAGIC, (SlimefunReloadedItemStack) SlimefunReloadedItems.ESSENCE_OF_AFTERLIFE, RecipeType.ANCIENT_ALTAR, new ItemStack[]{SlimefunReloadedItems.ENDER_LUMP_3, SlimefunReloadedItems.RUNE_AIR, SlimefunReloadedItems.ENDER_LUMP_3, SlimefunReloadedItems.RUNE_EARTH, SlimefunReloadedItems.NECROTIC_SKULL, SlimefunReloadedItems.RUNE_FIRE, SlimefunReloadedItems.ENDER_LUMP_3, SlimefunReloadedItems.RUNE_WATER, SlimefunReloadedItems.ENDER_LUMP_3});
    registerSimpleSlimefunReloadedItem("blank_rune", LUMPS_AND_MAGIC, (SlimefunReloadedItemStack) SlimefunReloadedItems.BLANK_RUNE, RecipeType.ANCIENT_ALTAR, new ItemStack[]{new ItemStack(Material.STONE), SlimefunReloadedItems.MAGIC_LUMP_1, new ItemStack(Material.STONE), SlimefunReloadedItems.MAGIC_LUMP_1, new ItemStack(Material.OBSIDIAN), SlimefunReloadedItems.MAGIC_LUMP_1, new ItemStack(Material.STONE), SlimefunReloadedItems.MAGIC_LUMP_1, new ItemStack(Material.STONE)});
    registerSimpleSlimefunReloadedItem("rune_air", LUMPS_AND_MAGIC, (SlimefunReloadedItemStack) SlimefunReloadedItems.RUNE_AIR, RecipeType.ANCIENT_ALTAR, new ItemStack[]{new ItemStack(Material.FEATHER), SlimefunReloadedItems.MAGIC_LUMP_1, new ItemStack(Material.FEATHER), new ItemStack(Material.GHAST_TEAR), SlimefunReloadedItems.BLANK_RUNE, new ItemStack(Material.GHAST_TEAR), new ItemStack(Material.FEATHER), SlimefunReloadedItems.MAGIC_LUMP_1, new ItemStack(Material.FEATHER)}, new CustomItem(SlimefunReloadedItems.RUNE_AIR, 4));
    registerSimpleSlimefunReloadedItem("rune_earth", LUMPS_AND_MAGIC, (SlimefunReloadedItemStack) SlimefunReloadedItems.RUNE_EARTH, RecipeType.ANCIENT_ALTAR, new ItemStack[]{new ItemStack(Material.DIRT), SlimefunReloadedItems.MAGIC_LUMP_1, new ItemStack(Material.STONE), new ItemStack(Material.OBSIDIAN), SlimefunReloadedItems.BLANK_RUNE, new ItemStack(Material.OBSIDIAN), new ItemStack(Material.STONE), SlimefunReloadedItems.MAGIC_LUMP_1, new ItemStack(Material.DIRT)}, new CustomItem(SlimefunReloadedItems.RUNE_EARTH, 4));
    registerSimpleSlimefunReloadedItem("rune_fire", LUMPS_AND_MAGIC, (SlimefunReloadedItemStack) SlimefunReloadedItems.RUNE_FIRE, RecipeType.ANCIENT_ALTAR, new ItemStack[]{new ItemStack(Material.FIRE_CHARGE), SlimefunReloadedItems.MAGIC_LUMP_2, new ItemStack(Material.FIRE_CHARGE), new ItemStack(Material.BLAZE_POWDER), SlimefunReloadedItems.RUNE_EARTH, new ItemStack(Material.FLINT_AND_STEEL), new ItemStack(Material.FIRE_CHARGE), SlimefunReloadedItems.MAGIC_LUMP_2, new ItemStack(Material.FIRE_CHARGE)}, new CustomItem(SlimefunReloadedItems.RUNE_FIRE, 4));
    registerSimpleSlimefunReloadedItem("rune_water", LUMPS_AND_MAGIC, (SlimefunReloadedItemStack) SlimefunReloadedItems.RUNE_WATER, RecipeType.ANCIENT_ALTAR, new ItemStack[]{new ItemStack(Material.SALMON), SlimefunReloadedItems.MAGIC_LUMP_2, new ItemStack(Material.WATER_BUCKET), new ItemStack(Material.SAND), SlimefunReloadedItems.BLANK_RUNE, new ItemStack(Material.SAND), new ItemStack(Material.WATER_BUCKET), SlimefunReloadedItems.MAGIC_LUMP_2, new ItemStack(Material.COD)}, new CustomItem(SlimefunReloadedItems.RUNE_WATER, 4));
    registerSimpleSlimefunReloadedItem("rune_ender", LUMPS_AND_MAGIC, (SlimefunReloadedItemStack) SlimefunReloadedItems.RUNE_ENDER, RecipeType.ANCIENT_ALTAR, new ItemStack[]{new ItemStack(Material.ENDER_PEARL), SlimefunReloadedItems.ENDER_LUMP_3, new ItemStack(Material.ENDER_PEARL), new ItemStack(Material.ENDER_EYE), SlimefunReloadedItems.BLANK_RUNE, new ItemStack(Material.ENDER_EYE), new ItemStack(Material.ENDER_PEARL), SlimefunReloadedItems.ENDER_LUMP_3, new ItemStack(Material.ENDER_PEARL)}, new CustomItem(SlimefunReloadedItems.RUNE_ENDER, 6));
    registerSimpleSlimefunReloadedItem("rune_lightning", LUMPS_AND_MAGIC, (SlimefunReloadedItemStack) SlimefunReloadedItems.RUNE_LIGHTNING, RecipeType.ANCIENT_ALTAR, new ItemStack[]{new ItemStack(Material.IRON_INGOT), SlimefunReloadedItems.MAGIC_LUMP_3, new ItemStack(Material.IRON_INGOT), SlimefunReloadedItems.RUNE_AIR, new ItemStack(Material.PHANTOM_MEMBRANE), SlimefunReloadedItems.RUNE_WATER, new ItemStack(Material.IRON_INGOT), SlimefunReloadedItems.MAGIC_LUMP_3, new ItemStack(Material.IRON_INGOT)}, new CustomItem(SlimefunReloadedItems.RUNE_LIGHTNING, 4));
    registerSimpleSlimefunReloadedItem("rune_rainbow", LUMPS_AND_MAGIC, (SlimefunReloadedItemStack) SlimefunReloadedItems.RUNE_RAINBOW, RecipeType.ANCIENT_ALTAR, new ItemStack[]{new ItemStack(Material.RED_DYE), SlimefunReloadedItems.MAGIC_LUMP_3, new ItemStack(Material.CYAN_DYE), new ItemStack(Material.WHITE_WOOL), SlimefunReloadedItems.RUNE_ENDER, new ItemStack(Material.WHITE_WOOL), new ItemStack(Material.YELLOW_DYE), SlimefunReloadedItems.ENDER_LUMP_3, new ItemStack(Material.MAGENTA_DYE)});
    register(new SoulboundRune(new NamespacedKey(plugin, "rune_soulbound"), LUMPS_AND_MAGIC, (SlimefunReloadedItemStack) SlimefunReloadedItems.RUNE_SOULBOUND, RecipeType.ANCIENT_ALTAR, new ItemStack[]{SlimefunReloadedItems.MAGIC_LUMP_3, SlimefunReloadedItems.ESSENCE_OF_AFTERLIFE, SlimefunReloadedItems.MAGIC_LUMP_3, SlimefunReloadedItems.ENDER_LUMP_3, SlimefunReloadedItems.RUNE_ENDER, SlimefunReloadedItems.ENDER_LUMP_3, SlimefunReloadedItems.MAGIC_LUMP_3, SlimefunReloadedItems.ESSENCE_OF_AFTERLIFE, SlimefunReloadedItems.MAGIC_LUMP_3}));
  }

  private static void registerJuice(String namespace, Category category, ItemStack item, RecipeType type,
   ItemStack[] recipe) {
    register(new SlimefunReloadedJuice(new NamespacedKey(plugin, namespace), category, item, type, recipe));
  }

  private static void registerMeatJerky(String namespace, Category category, ItemStack item, RecipeType type,
   ItemStack[] recipe) {
    register(new MeatJerky(new NamespacedKey(plugin, namespace), category, item, type, recipe, 0));
  }

  private static void registerBackpack(String namespace, Category category, SlimefunReloadedItemStack item, RecipeType type, ItemStack[] recipe, int size) {
    register(new SlimefunReloadedBackpack(new NamespacedKey(plugin, namespace), category, item, recipe, size));
  }

  private static void registerSoulboundItem(String namespace, Category category, SlimefunReloadedItemStack item, ItemStack[] recipe) {
    register(new SoulboundItem(new NamespacedKey(plugin, namespace), category, item, recipe));
  }

  private static void registerSimpleSlimefunReloadedItem(String namespace, Category category, ItemStack item, RecipeType type,
   ItemStack[] recipe, String[] keys, Object[] values) {
    register(new SimpleSlimefunReloadedItem(new NamespacedKey(plugin, namespace), category, item, type, recipe, keys, values));
  }

  private static void registerSimpleSlimefunReloadedItem(String namespace, Category category, ItemStack item, RecipeType type,
   ItemStack[] recipe) {
    register(new SimpleSlimefunReloadedItem(new NamespacedKey(plugin, namespace), category, item, type, recipe));
  }

  private static void registerSimpleSlimefunReloadedItem(String namespace, Category category, ItemStack item, RecipeType type,
   ItemStack[] recipe, CustomItem customItem) {
    register(new SimpleSlimefunReloadedItem(new NamespacedKey(plugin, namespace), category, item, type, recipe, customItem));
  }

  private static void register(SlimefunReloadedComponent component) {
    COMPONENT_MANAGER.registerComponent(component);
  }

}
