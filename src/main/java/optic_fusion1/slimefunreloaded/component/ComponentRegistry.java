package optic_fusion1.slimefunreloaded.component;

import optic_fusion1.slimefunreloaded.component.machine.impl.InfusedHopper;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import optic_fusion1.slimefunreloaded.Slimefun;
import optic_fusion1.slimefunreloaded.SlimefunReloaded;
import optic_fusion1.slimefunreloaded.category.CategoryManager;
import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.component.gadget.impl.Composter;
import optic_fusion1.slimefunreloaded.component.gadget.impl.Crucible;
import optic_fusion1.slimefunreloaded.component.item.ReplacingItem;
import optic_fusion1.slimefunreloaded.component.item.SlimefunReloadedArmorPiece;
import optic_fusion1.slimefunreloaded.component.item.SlimefunReloadedBackpack;
import optic_fusion1.slimefunreloaded.component.item.SlimefunReloadedJuice;
import optic_fusion1.slimefunreloaded.component.item.SoulboundBackpack;
import optic_fusion1.slimefunreloaded.component.item.VanillaItem;
import optic_fusion1.slimefunreloaded.component.item.impl.Alloy;
import optic_fusion1.slimefunreloaded.component.item.impl.DietCookie;
import optic_fusion1.slimefunreloaded.component.item.impl.EasterEgg;
import optic_fusion1.slimefunreloaded.component.item.impl.EnderBackpack;
import optic_fusion1.slimefunreloaded.component.item.impl.ExplosivePickaxe;
import optic_fusion1.slimefunreloaded.component.item.impl.ExplosiveShovel;
import optic_fusion1.slimefunreloaded.component.item.impl.FortuneCookie;
import optic_fusion1.slimefunreloaded.component.item.impl.GoldPan;
import optic_fusion1.slimefunreloaded.component.item.impl.GrapplingHook;
import optic_fusion1.slimefunreloaded.component.item.impl.HerculesPickaxe;
import optic_fusion1.slimefunreloaded.component.item.impl.InfernalBonemeal;
import optic_fusion1.slimefunreloaded.component.item.impl.JetBoots;
import optic_fusion1.slimefunreloaded.component.item.impl.Jetpack;
import optic_fusion1.slimefunreloaded.component.item.impl.KnowledgeFlask;
import optic_fusion1.slimefunreloaded.component.item.impl.KnowledgeTome;
import optic_fusion1.slimefunreloaded.component.item.impl.LumberAxe;
import optic_fusion1.slimefunreloaded.component.item.impl.MagicEyeOfEnder;
import optic_fusion1.slimefunreloaded.component.item.impl.MagicSugar;
import optic_fusion1.slimefunreloaded.component.item.impl.MeatJerky;
import optic_fusion1.slimefunreloaded.component.item.impl.Medicine;
import optic_fusion1.slimefunreloaded.component.item.impl.MonsterJerky;
import optic_fusion1.slimefunreloaded.component.item.impl.NetherGoldPan;
import optic_fusion1.slimefunreloaded.component.item.impl.PickaxeOfContainment;
import optic_fusion1.slimefunreloaded.component.item.impl.PickaxeOfVeinMining;
import optic_fusion1.slimefunreloaded.component.item.impl.PortableCrafter;
import optic_fusion1.slimefunreloaded.component.item.impl.PortableDustbin;
import optic_fusion1.slimefunreloaded.component.item.impl.Rag;
import optic_fusion1.slimefunreloaded.component.item.impl.RepairedSpawner;
import optic_fusion1.slimefunreloaded.component.item.impl.SeismicAxe;
import optic_fusion1.slimefunreloaded.component.item.impl.SimpleSlimefunReloadedItem;
import optic_fusion1.slimefunreloaded.component.item.impl.SmeltersPickaxe;
import optic_fusion1.slimefunreloaded.component.item.impl.SoulboundItem;
import optic_fusion1.slimefunreloaded.component.item.impl.SoulboundRune;
import optic_fusion1.slimefunreloaded.component.item.impl.StormStaff;
import optic_fusion1.slimefunreloaded.component.item.impl.Vitamins;
import optic_fusion1.slimefunreloaded.component.item.impl.WaterStaff;
import optic_fusion1.slimefunreloaded.component.item.impl.WindStaff;
import optic_fusion1.slimefunreloaded.component.machine.impl.EnchancedFurnace;
import optic_fusion1.slimefunreloaded.util.CustomItem;
import optic_fusion1.slimefunreloaded.util.SlimefunReloadedItemStack;
import optic_fusion1.slimefunreloaded.util.SlimefunReloadedItems;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public final class ComponentRegistry {

  private static final ComponentManager COMPONENT_MANAGER = Slimefun.getComponentManager();
  private static final CategoryManager CATEGORY_MANAGER = Slimefun.getCategoryManager();
  private static final SlimefunReloaded plugin = Slimefun.getSlimefunReloaded();

  private ComponentRegistry() {
  }

  public static void registerComponents() {
    //Weapon Registery
    Category WEAPONS = CATEGORY_MANAGER.getCategoryByKey("WEAPONS");
    registerSimpleSlimefunReloadedItem("grandmas_walking_stick", WEAPONS, SlimefunReloadedItems.GRANDMAS_WALKING_STICK, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{null, new ItemStack(Material.OAK_LOG), null, null, new ItemStack(Material.OAK_LOG), null, null, new ItemStack(Material.OAK_LOG), null});
    registerSimpleSlimefunReloadedItem("grandpas_walking_stick", WEAPONS, SlimefunReloadedItems.GRANDPAS_WALKING_STICK, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{new ItemStack(Material.LEATHER), new ItemStack(Material.OAK_LOG), new ItemStack(Material.LEATHER), null, new ItemStack(Material.OAK_LOG), null, null, new ItemStack(Material.OAK_LOG), null});
    registerSimpleSlimefunReloadedItem("sword_of_beheading", WEAPONS, SlimefunReloadedItems.SWORD_OF_BEHEADING, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{null, new ItemStack(Material.EMERALD), null, SlimefunReloadedItems.MAGIC_LUMP_2, new ItemStack(Material.EMERALD), SlimefunReloadedItems.MAGIC_LUMP_2, null, new ItemStack(Material.BLAZE_ROD), null}, new String[]{"chance.PLAYER", "chance.SKELETON", "chance.WITHER_SKELETON", "chance.ZOMBIE", "chance.CREEPER"}, new Integer[]{70, 40, 25, 40, 40});
    registerSimpleSlimefunReloadedItem("blade_of_vampires", WEAPONS, (SlimefunReloadedItemStack) SlimefunReloadedItems.BLADE_OF_VAMPIRES, RecipeType.MAGIC_WORKBENCH, new ItemStack[]{null, new ItemStack(Material.WITHER_SKELETON_SKULL), null, null, new ItemStack(Material.WITHER_SKELETON_SKULL), null, null, new ItemStack(Material.BLAZE_ROD), null});
    register(new SeismicAxe(new NamespacedKey(plugin, "seismic_axe"), WEAPONS, (SlimefunReloadedItemStack) SlimefunReloadedItems.SEISMIC_AXE, RecipeType.MAGIC_WORKBENCH, new ItemStack[]{SlimefunReloadedItems.HARDENED_METAL_INGOT, SlimefunReloadedItems.HARDENED_METAL_INGOT, null, SlimefunReloadedItems.HARDENED_METAL_INGOT, SlimefunReloadedItems.STAFF_ELEMENTAL, null, null, SlimefunReloadedItems.STAFF_ELEMENTAL, null}));
    registerSoulboundItem("soulbound_sword", WEAPONS, (SlimefunReloadedItemStack) SlimefunReloadedItems.SOULBOUND_SWORD, new ItemStack[]{null, SlimefunReloadedItems.ESSENCE_OF_AFTERLIFE, null, null, new ItemStack(Material.DIAMOND_SWORD), null, null, SlimefunReloadedItems.ESSENCE_OF_AFTERLIFE, null});
    registerSoulboundItem("soulbound_bow", WEAPONS, (SlimefunReloadedItemStack) SlimefunReloadedItems.SOULBOUND_BOW, new ItemStack[]{null, SlimefunReloadedItems.ESSENCE_OF_AFTERLIFE, null, null, new ItemStack(Material.DIAMOND_PICKAXE), null, null, SlimefunReloadedItems.ESSENCE_OF_AFTERLIFE, null});
    //Portable Registery
    Category PORTABLE = CATEGORY_MANAGER.getCategoryByKey("PORTABLE");
    register(new PortableCrafter(new NamespacedKey(plugin, "portable_crafter"), PORTABLE, (SlimefunReloadedItemStack) SlimefunReloadedItems.PORTABLE_CRAFTER, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{new ItemStack(Material.BOOK), new ItemStack(Material.CRAFTING_TABLE), null, null, null, null, null, null, null}));
    register(new PortableDustbin(new NamespacedKey(plugin, "portable_dustbin"), PORTABLE, (SlimefunReloadedItemStack) SlimefunReloadedItems.PORTABLE_DUSTBIN, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{new ItemStack(Material.IRON_INGOT), new ItemStack(Material.IRON_INGOT), new ItemStack(Material.IRON_INGOT), new ItemStack(Material.IRON_INGOT), null, new ItemStack(Material.IRON_INGOT), new ItemStack(Material.IRON_INGOT), new ItemStack(Material.IRON_INGOT), new ItemStack(Material.IRON_INGOT)}));
    register(new Rag(new NamespacedKey(plugin, "rag"), PORTABLE, (SlimefunReloadedItemStack) SlimefunReloadedItems.RAG, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{SlimefunReloadedItems.CLOTH, SlimefunReloadedItems.CLOTH, SlimefunReloadedItems.CLOTH, new ItemStack(Material.STRING), null, new ItemStack(Material.STRING), SlimefunReloadedItems.CLOTH, SlimefunReloadedItems.CLOTH, SlimefunReloadedItems.CLOTH}));
//    register(new Bandage(new NamespacedKey(plugin, "bandage"), PORTABLE, (SlimefunReloadedItemStack) SlimefunReloadedItems.BANDAGE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{SlimefunReloadedItems.RAG, new ItemStack(Material.STRING), SlimefunReloadedItems.RAG, null, null, null, null, null, null}, new CustomItem(SlimefunReloadedItems.BANDAGE, 4), new String[]{"enable-bleeding"}, new Boolean[]{true}));
//    register(new Splint(new NamespacedKey(plugin, "splint"), PORTABLE, (SlimefunReloadedItemStack) SlimefunReloadedItems.SPLINT, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{null, new ItemStack(Material.IRON_INGOT), null, new ItemStack(Material.STICK), new ItemStack(Material.STICK), new ItemStack(Material.STICK), null, new ItemStack(Material.IRON_INGOT), null}, new CustomItem(SlimefunReloadedItems.SPLINT, 4), new String[]{"enable-broken-legs"}, new Boolean[]{true}));
    register(new Vitamins(new NamespacedKey(plugin, "vitamins"), WEAPONS, (SlimefunReloadedItemStack) SlimefunReloadedItems.VITAMINS, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{SlimefunReloadedItems.CAN, new ItemStack(Material.APPLE), new ItemStack(Material.RED_MUSHROOM), new ItemStack(Material.SUGAR), null, null, null, null, null}));
    register(new Medicine(new NamespacedKey(plugin, "medicine"), PORTABLE, (SlimefunReloadedItemStack) SlimefunReloadedItems.MEDICINE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{SlimefunReloadedItems.VITAMINS, new ItemStack(Material.GLASS_BOTTLE), SlimefunReloadedItems.HEAVY_CREAM, null, null, null, null, null, null}));
    registerBackpack("backpack_small", PORTABLE, (SlimefunReloadedItemStack) SlimefunReloadedItems.BACKPACK_SMALL, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{new ItemStack(Material.LEATHER), null, new ItemStack(Material.LEATHER), SlimefunReloadedItems.GOLD_6K, new ItemStack(Material.CHEST), SlimefunReloadedItems.GOLD_6K, new ItemStack(Material.LEATHER), new ItemStack(Material.LEATHER), new ItemStack(Material.LEATHER)}, 9);
    registerBackpack("backpack_medium", PORTABLE, (SlimefunReloadedItemStack) SlimefunReloadedItems.BACKPACK_MEDIUM, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{new ItemStack(Material.LEATHER), null, new ItemStack(Material.LEATHER), SlimefunReloadedItems.GOLD_10K, SlimefunReloadedItems.BACKPACK_SMALL, SlimefunReloadedItems.GOLD_10K, new ItemStack(Material.LEATHER), new ItemStack(Material.LEATHER), new ItemStack(Material.LEATHER)}, 18);
    registerBackpack("backpack_large", PORTABLE, (SlimefunReloadedItemStack) SlimefunReloadedItems.BACKPACK_LARGE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{new ItemStack(Material.LEATHER), null, new ItemStack(Material.LEATHER), SlimefunReloadedItems.GOLD_14K, SlimefunReloadedItems.BACKPACK_MEDIUM, SlimefunReloadedItems.GOLD_14K, new ItemStack(Material.LEATHER), new ItemStack(Material.LEATHER), new ItemStack(Material.LEATHER)}, 27);
    registerBackpack("backpack_cloth", PORTABLE, (SlimefunReloadedItemStack) SlimefunReloadedItems.WOVEN_BACKPACK, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{SlimefunReloadedItems.CLOTH, null, SlimefunReloadedItems.CLOTH, SlimefunReloadedItems.GOLD_16K, SlimefunReloadedItems.BACKPACK_LARGE, SlimefunReloadedItems.GOLD_16K, SlimefunReloadedItems.CLOTH, SlimefunReloadedItems.CLOTH, SlimefunReloadedItems.CLOTH}, 36);
    registerBackpack("backpack_gilded", PORTABLE, (SlimefunReloadedItemStack) SlimefunReloadedItems.GILDED_BACKPACK, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{SlimefunReloadedItems.GOLD_22K, null, SlimefunReloadedItems.GOLD_22K, new ItemStack(Material.LEATHER), SlimefunReloadedItems.WOVEN_BACKPACK, new ItemStack(Material.LEATHER), SlimefunReloadedItems.GOLD_22K, null, SlimefunReloadedItems.GOLD_22K}, 45);
    registerBackpack("backpack_radiant", PORTABLE, (SlimefunReloadedItemStack) SlimefunReloadedItems.RADIANT_BACKPACK, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{SlimefunReloadedItems.GOLD_24K, null, SlimefunReloadedItems.GOLD_24K, new ItemStack(Material.LEATHER), SlimefunReloadedItems.GILDED_BACKPACK, new ItemStack(Material.LEATHER), SlimefunReloadedItems.GOLD_24K, null, SlimefunReloadedItems.GOLD_24K}, 54);
    registerBackpack("backpack_cooler", PORTABLE, (SlimefunReloadedItemStack) SlimefunReloadedItems.COOLER, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{SlimefunReloadedItems.CLOTH, SlimefunReloadedItems.CLOTH, SlimefunReloadedItems.CLOTH, SlimefunReloadedItems.ALUMINUM_INGOT, SlimefunReloadedItems.COOLING_UNIT, SlimefunReloadedItems.ALUMINUM_INGOT, SlimefunReloadedItems.ALUMINUM_INGOT, SlimefunReloadedItems.ALUMINUM_INGOT, SlimefunReloadedItems.ALUMINUM_INGOT}, 27);
    register(new SoulboundBackpack(new NamespacedKey(plugin, "backpack_soulbound"), PORTABLE, (SlimefunReloadedItemStack) SlimefunReloadedItems.BOUND_BACKPACK, null, new ItemStack[]{SlimefunReloadedItems.ENDER_LUMP_2, null, SlimefunReloadedItems.ENDER_LUMP_2, SlimefunReloadedItems.ESSENCE_OF_AFTERLIFE, SlimefunReloadedItems.WOVEN_BACKPACK, SlimefunReloadedItems.ESSENCE_OF_AFTERLIFE, SlimefunReloadedItems.ENDER_LUMP_2, null, SlimefunReloadedItems.ENDER_LUMP_2}, 36));
    //FOOD Registery
    Category FOOD = CATEGORY_MANAGER.getCategoryByKey("FOOD");
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
    Category MACHINES_1 = CATEGORY_MANAGER.getCategoryByKey("MACHINES_1");
    registerSimpleSlimefunReloadedItem("output_chest", MACHINES_1, (SlimefunReloadedItemStack) SlimefunReloadedItems.OUTPUT_CHEST, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{SlimefunReloadedItems.LEAD_INGOT, new ItemStack(Material.HOPPER), SlimefunReloadedItems.LEAD_INGOT, SlimefunReloadedItems.LEAD_INGOT, new ItemStack(Material.CHEST), SlimefunReloadedItems.LEAD_INGOT, null, SlimefunReloadedItems.LEAD_INGOT, null});
    registerSimpleSlimefunReloadedItem("ignition_chamber", MACHINES_1, (SlimefunReloadedItemStack) SlimefunReloadedItems.IGNITION_CHAMBER, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{SlimefunReloadedItems.STEEL_PLATE, SlimefunReloadedItems.BASIC_CIRCUIT_BOARD, new ItemStack(Material.FLINT_AND_STEEL), SlimefunReloadedItems.ELECTRIC_MOTOR, SlimefunReloadedItems.STEEL_PLATE, SlimefunReloadedItems.ELECTRIC_MOTOR, null, new ItemStack(Material.HOPPER), null});
    /*
    new SlimefunMachine(MACHINES_1, SlimefunReloadedItems.DIGITAL_MINER, "DIGITAL_MINER",
		new ItemStack[] {SlimefunReloadedItems.SOLAR_PANEL, new ItemStack(Material.CHEST), SlimefunReloadedItems.SOLAR_PANEL, new ItemStack(Material.IRON_BLOCK), new ItemStack(Material.DISPENSER), new ItemStack(Material.IRON_BLOCK), new ItemStack(Material.IRON_BLOCK), new ItemStack(Material.HOPPER), new ItemStack(Material.IRON_BLOCK)},
		new ItemStack[0], BlockFace.SELF)
		.register(true, new MultiBlockInteractionHandler() {

			@Override
			public boolean onInteract(final Player p, MultiBlock mb, final Block b) {
				if (mb.isMultiBlock(SlimefunReloadedItems.getByID("DIGITAL_MINER"))) {
					p.sendMessage(ChatColor.DARK_RED + "THIS MACHINE WILL SOON BE REMOVED!");
					if (CSCoreLib.getLib().getProtectionManager().canAccessChest(p.getUniqueId(), b, true) && Slimefun.hasUnlocked(p, SlimefunReloadedItems.DIGITAL_MINER, true)) {
						Block chestBlock = b.getRelative(BlockFace.UP);

						if(!(BlockStorage.check(chestBlock.getRelative(BlockFace.WEST), "SOLAR_PANEL") && BlockStorage.check(chestBlock.getRelative(BlockFace.EAST), "SOLAR_PANEL")) &&
								!(BlockStorage.check(chestBlock.getRelative(BlockFace.NORTH), "SOLAR_PANEL") && BlockStorage.check(chestBlock.getRelative(BlockFace.SOUTH), "SOLAR_PANEL"))) {
							return false;
						}

						Chest chest = (Chest) chestBlock.getState();
						final Inventory inv = chest.getInventory();
						List<Location> ores = new ArrayList<>();

						for (int x = b.getX() - 4; x <= b.getX() + 4; x++) {
							for (int z = b.getZ() - 4; z <= b.getZ() + 4; z++) {
								for (int y = b.getY(); y > 0; y--) {
									if (b.getWorld().getBlockAt(x, y, z).getType().toString().endsWith("_ORE")) {
										ores.add(b.getWorld().getBlockAt(x, y, z).getLocation());
									}
								}
							}
						}
						if (!ores.isEmpty()) {
							final Material ore = ores.get(0).getBlock().getType();
							final ItemStack adding = new ItemStack(ore);
							ores.get(0).getBlock().setType(Material.AIR);
							ores.clear();
							if (InvUtils.fits(inv, adding)) {
								for (int i = 0; i < 4; i++) {
									int j = i;
									Bukkit.getScheduler().runTaskLater(SlimefunPlugin.instance, () -> {
										if (j < 3) {
											b.getWorld().playEffect(b.getLocation(), Effect.STEP_SOUND, ore);
										} else {
											p.getWorld().playSound(p.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 1F, 1F);
											inv.addItem(adding);
										}
									}, i*20L);
								}
							}
							else SlimefunPlugin.getLocal().sendMessage(p, "machines.full-inventory", true);
						}
						else SlimefunPlugin.getLocal().sendMessage(p, "miner.no-ores", true);
					}
					return true;
				}
				else return false;
			}
		});

		new SlimefunMachine(MACHINES_1, SlimefunReloadedItems.ADVANCED_DIGITAL_MINER, "ADVANCED_DIGITAL_MINER",
		new ItemStack[] {SlimefunReloadedItems.SOLAR_PANEL, new ItemStack(Material.CHEST), SlimefunReloadedItems.SOLAR_PANEL, SlimefunReloadedItems.GOLD_24K_BLOCK, new ItemStack(Material.DISPENSER), SlimefunReloadedItems.GOLD_24K_BLOCK, SlimefunReloadedItems.GOLD_24K_BLOCK, new ItemStack(Material.HOPPER), SlimefunReloadedItems.GOLD_24K_BLOCK},
		new ItemStack[0], BlockFace.SELF)
		.register(true, new MultiBlockInteractionHandler() {

			@Override
			public boolean onInteract(final Player p, MultiBlock mb, final Block b) {
				if (mb.isMultiBlock(SlimefunReloadedItems.getByID("ADVANCED_DIGITAL_MINER"))) {
					p.sendMessage(ChatColor.DARK_RED + "THIS MACHINE WILL SOON BE REMOVED!");
					if (CSCoreLib.getLib().getProtectionManager().canAccessChest(p.getUniqueId(), b, true) && Slimefun.hasUnlocked(p, SlimefunReloadedItems.ADVANCED_DIGITAL_MINER, true)) {
						Block chestBlock = b.getRelative(BlockFace.UP);

						if(!(BlockStorage.check(chestBlock.getRelative(BlockFace.WEST), "SOLAR_PANEL") && BlockStorage.check(chestBlock.getRelative(BlockFace.EAST), "SOLAR_PANEL")) &&
								!(BlockStorage.check(chestBlock.getRelative(BlockFace.NORTH), "SOLAR_PANEL") && BlockStorage.check(chestBlock.getRelative(BlockFace.SOUTH), "SOLAR_PANEL"))) {
							return false;
						}

						Chest chest = (Chest) chestBlock.getState();
						final Inventory inv = chest.getInventory();
						List<Location> ores = new ArrayList<>();

						for (int x = b.getX() - 6; x <= b.getX() + 6; x++) {
							for (int z = b.getZ() - 6; z <= b.getZ() + 6; z++) {
								for (int y = b.getY(); y > 0; y--) {
									if (b.getWorld().getBlockAt(x, y, z).getType().toString().endsWith("_ORE")) {
										ores.add(b.getWorld().getBlockAt(x, y, z).getLocation());
									}
								}
							}
						}
						if (!ores.isEmpty()) {
							final Material ore = ores.get(0).getBlock().getType();
							ItemStack drop = new ItemStack(ore);
							if (ore == Material.COAL_ORE)  drop = new ItemStack(Material.COAL, 4);
							else if (ore == Material.IRON_ORE) drop = new CustomItem(SlimefunReloadedItems.IRON_DUST, 2);
							else if (ore == Material.GOLD_ORE)  drop = new CustomItem(SlimefunReloadedItems.GOLD_DUST, 2);
							else if (ore == Material.REDSTONE_ORE)  drop = new ItemStack(Material.REDSTONE, 8);
							else if (ore == Material.NETHER_QUARTZ_ORE)  drop = new ItemStack(Material.QUARTZ, 4);
							else if (ore == Material.LAPIS_ORE)  drop = new ItemStack(Material.LAPIS_LAZULI, 12);
							else {
								for (ItemStack drops: ores.get(0).getBlock().getDrops()) {
									if (!drops.getType().isBlock()) drop = new CustomItem(drops, 2);
								}
							}
							final ItemStack adding = drop;
							ores.get(0).getBlock().setType(Material.AIR);
							ores.clear();
							if (InvUtils.fits(inv, adding)) {
								for (int i = 0; i < 4; i++) {
									int j = i;
									Bukkit.getScheduler().runTaskLater(SlimefunPlugin.instance, () -> {
										if (j < 3) {
											b.getWorld().playEffect(b.getLocation(), Effect.STEP_SOUND, ore);
										} 
										else {
											p.getWorld().playSound(p.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 1F, 1F);
											inv.addItem(adding);
										}
									}, i*20L);
								}
							}
							else SlimefunPlugin.getLocal().sendMessage(p, "machines.full-inventory", true);
						}
						else SlimefunPlugin.getLocal().sendMessage(p, "miner.no-ores", true);
					}
					return true;
				}
				else return false;
			}
		});
     */
    register(new Composter(new NamespacedKey(plugin, "composter"), MACHINES_1, (SlimefunReloadedItemStack) SlimefunReloadedItems.COMPOSTER, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{new ItemStack(Material.OAK_SLAB), null, new ItemStack(Material.OAK_SLAB), new ItemStack(Material.OAK_SLAB), null, new ItemStack(Material.OAK_SLAB), new ItemStack(Material.OAK_SLAB), new ItemStack(Material.CAULDRON), new ItemStack(Material.OAK_SLAB)}));
    register(new Crucible(new NamespacedKey(plugin, "crucible"), MACHINES_1, (SlimefunReloadedItemStack) SlimefunReloadedItems.CRUCIBLE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{new ItemStack(Material.TERRACOTTA), null, new ItemStack(Material.TERRACOTTA), new ItemStack(Material.TERRACOTTA), null, new ItemStack(Material.TERRACOTTA), new ItemStack(Material.TERRACOTTA), new ItemStack(Material.FLINT_AND_STEEL), new ItemStack(Material.TERRACOTTA)}));
    /*
    new BlockPlacer(MACHINES_1, (SlimefunReloadedItemStack) SlimefunReloadedItems.BLOCK_PLACER, RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {SlimefunReloadedItems.GOLD_4K, new ItemStack(Material.PISTON), SlimefunReloadedItems.GOLD_4K, new ItemStack(Material.IRON_INGOT), SlimefunReloadedItems.ELECTRIC_MOTOR, new ItemStack(Material.IRON_INGOT), SlimefunReloadedItems.GOLD_4K, new ItemStack(Material.PISTON), SlimefunReloadedItems.GOLD_4K}, 
		new String[] {"unplaceable-blocks"}, new Object[] {Stream.of(Material.STRUCTURE_BLOCK, Material.COMMAND_BLOCK, Material.CHAIN_COMMAND_BLOCK, Material.REPEATING_COMMAND_BLOCK).map(Material::toString).collect(Collectors.toList())})
		.register(true);
     */
    //LUMPS_AND_MAGIC Registery
    Category LUMPS_AND_MAGIC = CATEGORY_MANAGER.getCategoryByKey("LUMPS_AND_MAGIC");
    registerSimpleSlimefunReloadedItem("magic_lump_1", LUMPS_AND_MAGIC, (SlimefunReloadedItemStack) SlimefunReloadedItems.MAGIC_LUMP_1, RecipeType.GRIND_STONE, new ItemStack[]{new ItemStack(Material.NETHER_WART), null, null, null, null, null, null, null, null}, new CustomItem(SlimefunReloadedItems.MAGIC_LUMP_1, 2));
    registerSimpleSlimefunReloadedItem("magic_lump_2", LUMPS_AND_MAGIC, (SlimefunReloadedItemStack) SlimefunReloadedItems.MAGIC_LUMP_2, RecipeType.GRIND_STONE, new ItemStack[]{SlimefunReloadedItems.MAGIC_LUMP_1, SlimefunReloadedItems.MAGIC_LUMP_1, null, SlimefunReloadedItems.MAGIC_LUMP_1, SlimefunReloadedItems.MAGIC_LUMP_1, null, null, null, null});
    registerSimpleSlimefunReloadedItem("magic_lump_3", LUMPS_AND_MAGIC, (SlimefunReloadedItemStack) SlimefunReloadedItems.MAGIC_LUMP_3, RecipeType.GRIND_STONE, new ItemStack[]{SlimefunReloadedItems.MAGIC_LUMP_2, SlimefunReloadedItems.MAGIC_LUMP_2, null, SlimefunReloadedItems.MAGIC_LUMP_2, SlimefunReloadedItems.MAGIC_LUMP_2, null, null, null, null});
    registerSimpleSlimefunReloadedItem("ender_lump_1", LUMPS_AND_MAGIC, (SlimefunReloadedItemStack) SlimefunReloadedItems.ENDER_LUMP_1, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{null, null, null, null, new ItemStack(Material.ENDER_EYE), null, null, null, null}, new CustomItem(SlimefunReloadedItems.ENDER_LUMP_1, 2));
    registerSimpleSlimefunReloadedItem("ender_lump_2", LUMPS_AND_MAGIC, (SlimefunReloadedItemStack) SlimefunReloadedItems.ENDER_LUMP_2, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{SlimefunReloadedItems.ENDER_LUMP_1, SlimefunReloadedItems.ENDER_LUMP_1, null, SlimefunReloadedItems.ENDER_LUMP_1, SlimefunReloadedItems.ENDER_LUMP_1, null, null, null, null});
    registerSimpleSlimefunReloadedItem("ender_lump_3", LUMPS_AND_MAGIC, (SlimefunReloadedItemStack) SlimefunReloadedItems.ENDER_LUMP_3, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{SlimefunReloadedItems.ENDER_LUMP_2, SlimefunReloadedItems.ENDER_LUMP_2, null, SlimefunReloadedItems.ENDER_LUMP_2, SlimefunReloadedItems.ENDER_LUMP_2, null, null, null, null});
    registerSimpleSlimefunReloadedItem("magical_book_cover", LUMPS_AND_MAGIC, (SlimefunReloadedItemStack) SlimefunReloadedItems.MAGICAL_BOOK_COVER, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{null, SlimefunReloadedItems.MAGIC_LUMP_2, null, SlimefunReloadedItems.MAGIC_LUMP_2, new ItemStack(Material.BOOK), SlimefunReloadedItems.MAGIC_LUMP_2, null, SlimefunReloadedItems.MAGIC_LUMP_2, null});
    registerSimpleSlimefunReloadedItem("lava_crystal", LUMPS_AND_MAGIC, (SlimefunReloadedItemStack) SlimefunReloadedItems.LAVA_CRYSTAL, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{SlimefunReloadedItems.MAGIC_LUMP_1, new ItemStack(Material.BLAZE_POWDER), SlimefunReloadedItems.MAGIC_LUMP_1, new ItemStack(Material.BLAZE_POWDER), SlimefunReloadedItems.RUNE_FIRE, new ItemStack(Material.BLAZE_POWDER), SlimefunReloadedItems.MAGIC_LUMP_1, new ItemStack(Material.BLAZE_POWDER), SlimefunReloadedItems.MAGIC_LUMP_1});
    registerSimpleSlimefunReloadedItem("talisman", LUMPS_AND_MAGIC, (SlimefunReloadedItemStack) SlimefunReloadedItems.TALISMAN, RecipeType.MAGIC_WORKBENCH, new ItemStack[]{SlimefunReloadedItems.MAGIC_LUMP_2, SlimefunReloadedItems.GOLD_8K, SlimefunReloadedItems.MAGIC_LUMP_2, null, new ItemStack(Material.EMERALD), null, SlimefunReloadedItems.MAGIC_LUMP_2, SlimefunReloadedItems.GOLD_8K, SlimefunReloadedItems.MAGIC_LUMP_2}, new String[]{"recipe-requires-nether-stars"}, new Boolean[]{false});
    registerSimpleSlimefunReloadedItem("necrotic_skull", LUMPS_AND_MAGIC, (SlimefunReloadedItemStack) SlimefunReloadedItems.NECROTIC_SKULL, RecipeType.MAGIC_WORKBENCH, new ItemStack[]{SlimefunReloadedItems.MAGIC_LUMP_3, null, SlimefunReloadedItems.MAGIC_LUMP_3, null, new ItemStack(Material.WITHER_SKELETON_SKULL), null, SlimefunReloadedItems.MAGIC_LUMP_3, null, SlimefunReloadedItems.MAGIC_LUMP_3});
    registerSimpleSlimefunReloadedItem("essence_of_afterlife", LUMPS_AND_MAGIC, (SlimefunReloadedItemStack) SlimefunReloadedItems.ESSENCE_OF_AFTERLIFE, RecipeType.ANCIENT_ALTAR, new ItemStack[]{SlimefunReloadedItems.ENDER_LUMP_3, SlimefunReloadedItems.RUNE_AIR, SlimefunReloadedItems.ENDER_LUMP_3, SlimefunReloadedItems.RUNE_EARTH, SlimefunReloadedItems.NECROTIC_SKULL, SlimefunReloadedItems.RUNE_FIRE, SlimefunReloadedItems.ENDER_LUMP_3, SlimefunReloadedItems.RUNE_WATER, SlimefunReloadedItems.ENDER_LUMP_3});
    registerSimpleSlimefunReloadedItem("broken_spawner", LUMPS_AND_MAGIC, (SlimefunReloadedItemStack) SlimefunReloadedItems.BROKEN_SPAWNER, new RecipeType(SlimefunReloadedItems.PICKAXE_OF_CONTAINMENT), new ItemStack[]{null, null, null, null, new ItemStack(Material.SPAWNER), null, null, null, null});
    /*
		new AncientPedestal(LUMPS_AND_MAGIC, (SlimefunReloadedItemStack) SlimefunReloadedItems.ANCIENT_PEDESTAL, RecipeType.MAGIC_WORKBENCH,
		new ItemStack[] {new ItemStack(Material.OBSIDIAN), SlimefunReloadedItems.GOLD_8K, new ItemStack(Material.OBSIDIAN), null, new ItemStack(Material.STONE), null, new ItemStack(Material.OBSIDIAN), SlimefunReloadedItems.GOLD_8K, new ItemStack(Material.OBSIDIAN)}, new CustomItem(SlimefunReloadedItems.ANCIENT_PEDESTAL, 4))
		.register(true);

     */
    registerSimpleSlimefunReloadedItem("blank_rune", LUMPS_AND_MAGIC, (SlimefunReloadedItemStack) SlimefunReloadedItems.BLANK_RUNE, RecipeType.ANCIENT_ALTAR, new ItemStack[]{new ItemStack(Material.STONE), SlimefunReloadedItems.MAGIC_LUMP_1, new ItemStack(Material.STONE), SlimefunReloadedItems.MAGIC_LUMP_1, new ItemStack(Material.OBSIDIAN), SlimefunReloadedItems.MAGIC_LUMP_1, new ItemStack(Material.STONE), SlimefunReloadedItems.MAGIC_LUMP_1, new ItemStack(Material.STONE)});
    registerSimpleSlimefunReloadedItem("rune_air", LUMPS_AND_MAGIC, (SlimefunReloadedItemStack) SlimefunReloadedItems.RUNE_AIR, RecipeType.ANCIENT_ALTAR, new ItemStack[]{new ItemStack(Material.FEATHER), SlimefunReloadedItems.MAGIC_LUMP_1, new ItemStack(Material.FEATHER), new ItemStack(Material.GHAST_TEAR), SlimefunReloadedItems.BLANK_RUNE, new ItemStack(Material.GHAST_TEAR), new ItemStack(Material.FEATHER), SlimefunReloadedItems.MAGIC_LUMP_1, new ItemStack(Material.FEATHER)}, new CustomItem(SlimefunReloadedItems.RUNE_AIR, 4));
    registerSimpleSlimefunReloadedItem("rune_earth", LUMPS_AND_MAGIC, (SlimefunReloadedItemStack) SlimefunReloadedItems.RUNE_EARTH, RecipeType.ANCIENT_ALTAR, new ItemStack[]{new ItemStack(Material.DIRT), SlimefunReloadedItems.MAGIC_LUMP_1, new ItemStack(Material.STONE), new ItemStack(Material.OBSIDIAN), SlimefunReloadedItems.BLANK_RUNE, new ItemStack(Material.OBSIDIAN), new ItemStack(Material.STONE), SlimefunReloadedItems.MAGIC_LUMP_1, new ItemStack(Material.DIRT)}, new CustomItem(SlimefunReloadedItems.RUNE_EARTH, 4));
    registerSimpleSlimefunReloadedItem("rune_fire", LUMPS_AND_MAGIC, (SlimefunReloadedItemStack) SlimefunReloadedItems.RUNE_FIRE, RecipeType.ANCIENT_ALTAR, new ItemStack[]{new ItemStack(Material.FIRE_CHARGE), SlimefunReloadedItems.MAGIC_LUMP_2, new ItemStack(Material.FIRE_CHARGE), new ItemStack(Material.BLAZE_POWDER), SlimefunReloadedItems.RUNE_EARTH, new ItemStack(Material.FLINT_AND_STEEL), new ItemStack(Material.FIRE_CHARGE), SlimefunReloadedItems.MAGIC_LUMP_2, new ItemStack(Material.FIRE_CHARGE)}, new CustomItem(SlimefunReloadedItems.RUNE_FIRE, 4));
    registerSimpleSlimefunReloadedItem("rune_water", LUMPS_AND_MAGIC, (SlimefunReloadedItemStack) SlimefunReloadedItems.RUNE_WATER, RecipeType.ANCIENT_ALTAR, new ItemStack[]{new ItemStack(Material.SALMON), SlimefunReloadedItems.MAGIC_LUMP_2, new ItemStack(Material.WATER_BUCKET), new ItemStack(Material.SAND), SlimefunReloadedItems.BLANK_RUNE, new ItemStack(Material.SAND), new ItemStack(Material.WATER_BUCKET), SlimefunReloadedItems.MAGIC_LUMP_2, new ItemStack(Material.COD)}, new CustomItem(SlimefunReloadedItems.RUNE_WATER, 4));
    registerSimpleSlimefunReloadedItem("rune_ender", LUMPS_AND_MAGIC, (SlimefunReloadedItemStack) SlimefunReloadedItems.RUNE_ENDER, RecipeType.ANCIENT_ALTAR, new ItemStack[]{new ItemStack(Material.ENDER_PEARL), SlimefunReloadedItems.ENDER_LUMP_3, new ItemStack(Material.ENDER_PEARL), new ItemStack(Material.ENDER_EYE), SlimefunReloadedItems.BLANK_RUNE, new ItemStack(Material.ENDER_EYE), new ItemStack(Material.ENDER_PEARL), SlimefunReloadedItems.ENDER_LUMP_3, new ItemStack(Material.ENDER_PEARL)}, new CustomItem(SlimefunReloadedItems.RUNE_ENDER, 6));
    registerSimpleSlimefunReloadedItem("rune_lightning", LUMPS_AND_MAGIC, (SlimefunReloadedItemStack) SlimefunReloadedItems.RUNE_LIGHTNING, RecipeType.ANCIENT_ALTAR, new ItemStack[]{new ItemStack(Material.IRON_INGOT), SlimefunReloadedItems.MAGIC_LUMP_3, new ItemStack(Material.IRON_INGOT), SlimefunReloadedItems.RUNE_AIR, new ItemStack(Material.PHANTOM_MEMBRANE), SlimefunReloadedItems.RUNE_WATER, new ItemStack(Material.IRON_INGOT), SlimefunReloadedItems.MAGIC_LUMP_3, new ItemStack(Material.IRON_INGOT)}, new CustomItem(SlimefunReloadedItems.RUNE_LIGHTNING, 4));
    registerSimpleSlimefunReloadedItem("rune_rainbow", LUMPS_AND_MAGIC, (SlimefunReloadedItemStack) SlimefunReloadedItems.RUNE_RAINBOW, RecipeType.ANCIENT_ALTAR, new ItemStack[]{new ItemStack(Material.RED_DYE), SlimefunReloadedItems.MAGIC_LUMP_3, new ItemStack(Material.CYAN_DYE), new ItemStack(Material.WHITE_WOOL), SlimefunReloadedItems.RUNE_ENDER, new ItemStack(Material.WHITE_WOOL), new ItemStack(Material.YELLOW_DYE), SlimefunReloadedItems.ENDER_LUMP_3, new ItemStack(Material.MAGENTA_DYE)});
    register(new SoulboundRune(new NamespacedKey(plugin, "rune_soulbound"), LUMPS_AND_MAGIC, (SlimefunReloadedItemStack) SlimefunReloadedItems.RUNE_SOULBOUND, RecipeType.ANCIENT_ALTAR, new ItemStack[]{SlimefunReloadedItems.MAGIC_LUMP_3, SlimefunReloadedItems.ESSENCE_OF_AFTERLIFE, SlimefunReloadedItems.MAGIC_LUMP_3, SlimefunReloadedItems.ENDER_LUMP_3, SlimefunReloadedItems.RUNE_ENDER, SlimefunReloadedItems.ENDER_LUMP_3, SlimefunReloadedItems.MAGIC_LUMP_3, SlimefunReloadedItems.ESSENCE_OF_AFTERLIFE, SlimefunReloadedItems.MAGIC_LUMP_3}));
    //MAGIC Registery
    Category MAGIC = CATEGORY_MANAGER.getCategoryByKey("MAGICAL_GADGETS");
    register(new InfusedHopper(new NamespacedKey(plugin, "infused_hopper"), MAGIC, (SlimefunReloadedItemStack) SlimefunReloadedItems.INFUSED_HOPPER, RecipeType.ANCIENT_ALTAR, new ItemStack[]{new ItemStack(Material.OBSIDIAN), SlimefunReloadedItems.RUNE_EARTH, new ItemStack(Material.HOPPER), SlimefunReloadedItems.RUNE_ENDER, SlimefunReloadedItems.INFUSED_MAGNET, SlimefunReloadedItems.RUNE_ENDER, new ItemStack(Material.HOPPER), SlimefunReloadedItems.RUNE_EARTH, new ItemStack(Material.OBSIDIAN)}));
    register(new EnderBackpack(new NamespacedKey(plugin, "ender_backpack"), MAGIC, (SlimefunReloadedItemStack) SlimefunReloadedItems.ENDER_BACKPACK, RecipeType.MAGIC_WORKBENCH, new ItemStack[]{SlimefunReloadedItems.ENDER_LUMP_2, new ItemStack(Material.LEATHER), SlimefunReloadedItems.ENDER_LUMP_2, new ItemStack(Material.LEATHER), new ItemStack(Material.CHEST), new ItemStack(Material.LEATHER), SlimefunReloadedItems.ENDER_LUMP_2, new ItemStack(Material.LEATHER), SlimefunReloadedItems.ENDER_LUMP_2}));
    register(new MagicEyeOfEnder(new NamespacedKey(plugin, "magic_eye_of_ender"), MAGIC, (SlimefunReloadedItemStack) SlimefunReloadedItems.MAGIC_EYE_OF_ENDER, RecipeType.MAGIC_WORKBENCH, new ItemStack[]{SlimefunReloadedItems.ENDER_LUMP_2, new ItemStack(Material.ENDER_PEARL), SlimefunReloadedItems.ENDER_LUMP_2, new ItemStack(Material.ENDER_PEARL), new ItemStack(Material.ENDER_EYE), new ItemStack(Material.ENDER_PEARL), SlimefunReloadedItems.ENDER_LUMP_2, new ItemStack(Material.ENDER_PEARL), SlimefunReloadedItems.ENDER_LUMP_2}));
    registerSimpleSlimefunReloadedItem("staff_elemental", MAGIC, (SlimefunReloadedItemStack) SlimefunReloadedItems.STAFF_ELEMENTAL, RecipeType.MAGIC_WORKBENCH, new ItemStack[]{null, SlimefunReloadedItems.MAGICAL_BOOK_COVER, SlimefunReloadedItems.MAGIC_LUMP_3, null, new ItemStack(Material.STICK), SlimefunReloadedItems.MAGICAL_BOOK_COVER, SlimefunReloadedItems.MAGIC_LUMP_3, null, null});
    register(new WindStaff(new NamespacedKey(plugin, "wind_staff"), MAGIC, (SlimefunReloadedItemStack) SlimefunReloadedItems.STAFF_WIND, RecipeType.MAGIC_WORKBENCH, new ItemStack[]{null, new ItemStack(Material.FEATHER), SlimefunReloadedItems.ENDER_LUMP_3, null, SlimefunReloadedItems.STAFF_ELEMENTAL, new ItemStack(Material.FEATHER), SlimefunReloadedItems.STAFF_ELEMENTAL, null, null}));
    register(new WaterStaff(new NamespacedKey(plugin, "water_staff"), MAGIC, (SlimefunReloadedItemStack) SlimefunReloadedItems.STAFF_WATER, RecipeType.MAGIC_WORKBENCH, new ItemStack[]{null, new ItemStack(Material.LILY_PAD), SlimefunReloadedItems.MAGIC_LUMP_2, null, SlimefunReloadedItems.STAFF_ELEMENTAL, new ItemStack(Material.LILY_PAD), SlimefunReloadedItems.STAFF_ELEMENTAL, null, null}));
    registerSimpleSlimefunReloadedItem("staff_fire", MAGIC, (SlimefunReloadedItemStack) SlimefunReloadedItems.STAFF_FIRE, RecipeType.MAGIC_WORKBENCH, new ItemStack[]{null, null, SlimefunReloadedItems.LAVA_CRYSTAL, null, SlimefunReloadedItems.STAFF_ELEMENTAL, null, SlimefunReloadedItems.STAFF_ELEMENTAL, null, null});
    register(new StormStaff(new NamespacedKey(plugin, "storm-staff"), MAGIC, (SlimefunReloadedItemStack) SlimefunReloadedItems.STAFF_STORM, RecipeType.ANCIENT_ALTAR, new ItemStack[]{SlimefunReloadedItems.RUNE_LIGHTNING, SlimefunReloadedItems.ENDER_LUMP_3, SlimefunReloadedItems.RUNE_LIGHTNING, SlimefunReloadedItems.STAFF_WATER, SlimefunReloadedItems.MAGIC_SUGAR, SlimefunReloadedItems.STAFF_WIND, SlimefunReloadedItems.RUNE_LIGHTNING, SlimefunReloadedItems.ENDER_LUMP_3, SlimefunReloadedItems.RUNE_LIGHTNING}));
    registerSimpleSlimefunReloadedItem("infused_magnet", MAGIC, (SlimefunReloadedItemStack) SlimefunReloadedItems.INFUSED_MAGNET, RecipeType.MAGIC_WORKBENCH, new ItemStack[]{SlimefunReloadedItems.MAGIC_LUMP_3, null, SlimefunReloadedItems.MAGIC_LUMP_3, SlimefunReloadedItems.ENDER_LUMP_2, SlimefunReloadedItems.MAGNET, SlimefunReloadedItems.ENDER_LUMP_2, SlimefunReloadedItems.MAGIC_LUMP_3, null, SlimefunReloadedItems.MAGIC_LUMP_3});
    register(new RepairedSpawner(new NamespacedKey(plugin, "repaired_spawner"), MAGIC, (SlimefunReloadedItemStack) SlimefunReloadedItems.REPAIRED_SPAWNER, RecipeType.ANCIENT_ALTAR, new ItemStack[]{SlimefunReloadedItems.RUNE_ENDER, new CustomItem(Material.EXPERIENCE_BOTTLE, "&aFlask of Knowledge"), SlimefunReloadedItems.ESSENCE_OF_AFTERLIFE, new CustomItem(Material.EXPERIENCE_BOTTLE, "&aFlask of Knowledge"), SlimefunReloadedItems.BROKEN_SPAWNER, new CustomItem(Material.EXPERIENCE_BOTTLE, "&aFlask of Knowledge"), SlimefunReloadedItems.ESSENCE_OF_AFTERLIFE, new CustomItem(Material.EXPERIENCE_BOTTLE, "&aFlask of Knowledge"), SlimefunReloadedItems.RUNE_ENDER}));
    register(new KnowledgeTome(new NamespacedKey(plugin, "knowledge_tome"), MAGIC, (SlimefunReloadedItemStack) SlimefunReloadedItems.TOME_OF_KNOWLEDGE_SHARING, RecipeType.MAGIC_WORKBENCH, new ItemStack[]{null, new ItemStack(Material.FEATHER), null, new ItemStack(Material.INK_SAC), SlimefunReloadedItems.MAGICAL_BOOK_COVER, new ItemStack(Material.GLASS_BOTTLE), null, new ItemStack(Material.WRITABLE_BOOK), null}));
    register(new KnowledgeFlask(new NamespacedKey(plugin, "knowledge_flask"), MAGIC, (SlimefunReloadedItemStack) SlimefunReloadedItems.FLASK_OF_KNOWLEDGE, RecipeType.MAGIC_WORKBENCH, new ItemStack[]{null, null, null, SlimefunReloadedItems.MAGIC_LUMP_2, new ItemStack(Material.GLASS_PANE), SlimefunReloadedItems.MAGIC_LUMP_2, null, SlimefunReloadedItems.MAGIC_LUMP_2, null}, new CustomItem(SlimefunReloadedItems.FLASK_OF_KNOWLEDGE, 8)));
    registerSimpleSlimefunReloadedItem("ancient_altar", MAGIC, (SlimefunReloadedItemStack) SlimefunReloadedItems.ANCIENT_ALTAR, RecipeType.MAGIC_WORKBENCH, new ItemStack[]{null, new ItemStack(Material.ENCHANTING_TABLE), null, SlimefunReloadedItems.MAGIC_LUMP_3, SlimefunReloadedItems.GOLD_8K, SlimefunReloadedItems.MAGIC_LUMP_3, new ItemStack(Material.OBSIDIAN), SlimefunReloadedItems.GOLD_8K, new ItemStack(Material.OBSIDIAN)});
    register(new InfernalBonemeal(new NamespacedKey(plugin, "infernal_bonemeal"), MAGIC, (SlimefunReloadedItemStack) SlimefunReloadedItems.INFERNAL_BONEMEAL, RecipeType.ANCIENT_ALTAR, new ItemStack[]{new ItemStack(Material.NETHER_WART), SlimefunReloadedItems.RUNE_EARTH, new ItemStack(Material.NETHER_WART), SlimefunReloadedItems.MAGIC_LUMP_2, new ItemStack(Material.BONE_MEAL), SlimefunReloadedItems.MAGIC_LUMP_2, new ItemStack(Material.NETHER_WART), new ItemStack(Material.BLAZE_POWDER), new ItemStack(Material.NETHER_WART)}, new CustomItem(SlimefunReloadedItems.INFERNAL_BONEMEAL, 8)));
    registerSimpleSlimefunReloadedItem("elytra_scale", MAGIC, SlimefunReloadedItems.ELYTRA_SCALE, RecipeType.ANCIENT_ALTAR, new ItemStack[]{SlimefunReloadedItems.ENDER_LUMP_3, SlimefunReloadedItems.RUNE_AIR, SlimefunReloadedItems.ENDER_LUMP_3, new ItemStack(Material.PHANTOM_MEMBRANE), new ItemStack(Material.FEATHER), new ItemStack(Material.PHANTOM_MEMBRANE), SlimefunReloadedItems.ENDER_LUMP_3, SlimefunReloadedItems.RUNE_AIR, SlimefunReloadedItems.ENDER_LUMP_3});
    register(new VanillaItem(new NamespacedKey(plugin, "elytra"), MAGIC, SlimefunReloadedItems.ELYTRA, RecipeType.ANCIENT_ALTAR, new ItemStack[]{SlimefunReloadedItems.ELYTRA_SCALE, SlimefunReloadedItems.RUNE_AIR, SlimefunReloadedItems.ELYTRA_SCALE, SlimefunReloadedItems.RUNE_AIR, new ItemStack(Material.LEATHER_CHESTPLATE), SlimefunReloadedItems.RUNE_AIR, SlimefunReloadedItems.ELYTRA_SCALE, SlimefunReloadedItems.RUNE_AIR, SlimefunReloadedItems.ELYTRA_SCALE}));
    registerSimpleSlimefunReloadedItem("infused_elyta", MAGIC, SlimefunReloadedItems.INFUSED_ELYTRA, RecipeType.ANCIENT_ALTAR, new ItemStack[]{SlimefunReloadedItems.FLASK_OF_KNOWLEDGE, SlimefunReloadedItems.ELYTRA_SCALE, SlimefunReloadedItems.FLASK_OF_KNOWLEDGE, SlimefunReloadedItems.FLASK_OF_KNOWLEDGE, SlimefunReloadedItems.ELYTRA, SlimefunReloadedItems.FLASK_OF_KNOWLEDGE, SlimefunReloadedItems.FLASK_OF_KNOWLEDGE, SlimefunReloadedItems.ELYTRA_SCALE, SlimefunReloadedItems.FLASK_OF_KNOWLEDGE});
    registerSoulboundItem("soulbound_elyta", MAGIC, SlimefunReloadedItems.SOULBOUND_ELYTRA, RecipeType.ANCIENT_ALTAR, new ItemStack[]{SlimefunReloadedItems.FLASK_OF_KNOWLEDGE, SlimefunReloadedItems.ESSENCE_OF_AFTERLIFE, SlimefunReloadedItems.FLASK_OF_KNOWLEDGE, SlimefunReloadedItems.ELYTRA_SCALE, SlimefunReloadedItems.ELYTRA, SlimefunReloadedItems.ELYTRA_SCALE, SlimefunReloadedItems.FLASK_OF_KNOWLEDGE, SlimefunReloadedItems.ESSENCE_OF_AFTERLIFE, SlimefunReloadedItems.FLASK_OF_KNOWLEDGE});
//    register(new VanillaItem(new NamespacedKey(plugin, "totem_of_undying"), SlimefunReloadedItems.TOTEM_OF_UNDYING, RecipeType.ANCIENT_ALTAR, new ItemStack[]{SlimefunReloadedItems.ESSENCE_OF_AFTERLIFE, new ItemStack(Material.EMERALD_BLOCK), SlimefunReloadedItems.ESSENCE_OF_AFTERLIFE, SlimefunReloadedItems.MAGIC_LUMP_3, SlimefunReloadedItems.TALISMAN, SlimefunReloadedItems.MAGIC_LUMP_3, SlimefunReloadedItems.ESSENCE_OF_AFTERLIFE, new ItemStack(Material.EMERALD_BLOCK), SlimefunReloadedItems.ESSENCE_OF_AFTERLIFE}));
    /*
    RainbowTicker rainbow = new RainbowTicker();

		new SlimefunReloadedItems(MAGIC, (SlimefunReloadedItemStack) SlimefunReloadedItems.RAINBOW_WOOL, RecipeType.ANCIENT_ALTAR,
		new ItemStack[] {new ItemStack(Material.WHITE_WOOL), new ItemStack(Material.WHITE_WOOL), new ItemStack(Material.WHITE_WOOL), new ItemStack(Material.WHITE_WOOL), SlimefunReloadedItems.RUNE_RAINBOW, new ItemStack(Material.WHITE_WOOL), new ItemStack(Material.WHITE_WOOL), new ItemStack(Material.WHITE_WOOL), new ItemStack(Material.WHITE_WOOL)}, new CustomItem(SlimefunReloadedItems.RAINBOW_WOOL, 8))
		.register(true, rainbow);

		new SlimefunReloadedItems(MAGIC, (SlimefunReloadedItemStack) SlimefunReloadedItems.RAINBOW_GLASS, RecipeType.ANCIENT_ALTAR,
		new ItemStack[] {new ItemStack(Material.WHITE_STAINED_GLASS), new ItemStack(Material.WHITE_STAINED_GLASS), new ItemStack(Material.WHITE_STAINED_GLASS), new ItemStack(Material.WHITE_STAINED_GLASS), SlimefunReloadedItems.RUNE_RAINBOW, new ItemStack(Material.WHITE_STAINED_GLASS), new ItemStack(Material.WHITE_STAINED_GLASS), new ItemStack(Material.WHITE_STAINED_GLASS), new ItemStack(Material.WHITE_STAINED_GLASS)}, new CustomItem(SlimefunReloadedItems.RAINBOW_GLASS, 8))
		.register(true, rainbow);

		new SlimefunReloadedItems(MAGIC, (SlimefunReloadedItemStack) SlimefunReloadedItems.RAINBOW_GLASS_PANE, RecipeType.ANCIENT_ALTAR,
		new ItemStack[] {new ItemStack(Material.WHITE_STAINED_GLASS_PANE), new ItemStack(Material.WHITE_STAINED_GLASS_PANE), new ItemStack(Material.WHITE_STAINED_GLASS_PANE), new ItemStack(Material.WHITE_STAINED_GLASS_PANE), SlimefunReloadedItems.RUNE_RAINBOW, new ItemStack(Material.WHITE_STAINED_GLASS_PANE), new ItemStack(Material.WHITE_STAINED_GLASS_PANE), new ItemStack(Material.WHITE_STAINED_GLASS_PANE), new ItemStack(Material.WHITE_STAINED_GLASS_PANE)}, new CustomItem(SlimefunReloadedItems.RAINBOW_GLASS_PANE, 8))
		.register(true, rainbow);

		new SlimefunReloadedItems(MAGIC, (SlimefunReloadedItemStack) SlimefunReloadedItems.RAINBOW_CLAY, RecipeType.ANCIENT_ALTAR,
		new ItemStack[] {new ItemStack(Material.WHITE_TERRACOTTA), new ItemStack(Material.WHITE_TERRACOTTA), new ItemStack(Material.WHITE_TERRACOTTA), new ItemStack(Material.WHITE_TERRACOTTA), SlimefunReloadedItems.RUNE_RAINBOW, new ItemStack(Material.WHITE_TERRACOTTA), new ItemStack(Material.WHITE_TERRACOTTA), new ItemStack(Material.WHITE_TERRACOTTA), new ItemStack(Material.WHITE_TERRACOTTA)}, new CustomItem(SlimefunReloadedItems.RAINBOW_CLAY, 8))
		.register(true, rainbow);

     */
    //MagicArmor Registery
    Category MAGIC_ARMOR = CATEGORY_MANAGER.getCategoryByKey("MAGIC_ARMOR");
    registerSimpleSlimefunReloadedItem("ender_helmet", MAGIC_ARMOR, (SlimefunReloadedItemStack) SlimefunReloadedItems.ENDER_HELMET, RecipeType.ARMOR_FORGE, new ItemStack[]{SlimefunReloadedItems.ENDER_LUMP_1, new ItemStack(Material.ENDER_EYE), SlimefunReloadedItems.ENDER_LUMP_1, new ItemStack(Material.OBSIDIAN), null, new ItemStack(Material.OBSIDIAN), null, null, null});
    registerSimpleSlimefunReloadedItem("ender_chestplate", MAGIC_ARMOR, (SlimefunReloadedItemStack) SlimefunReloadedItems.ENDER_CHESTPLATE, RecipeType.ARMOR_FORGE, new ItemStack[]{SlimefunReloadedItems.ENDER_LUMP_1, null, SlimefunReloadedItems.ENDER_LUMP_1, new ItemStack(Material.OBSIDIAN), new ItemStack(Material.ENDER_EYE), new ItemStack(Material.OBSIDIAN), new ItemStack(Material.OBSIDIAN), new ItemStack(Material.OBSIDIAN), new ItemStack(Material.OBSIDIAN)});
    registerSimpleSlimefunReloadedItem("ender_leggings", MAGIC_ARMOR, (SlimefunReloadedItemStack) SlimefunReloadedItems.ENDER_LEGGINGS, RecipeType.ARMOR_FORGE, new ItemStack[]{SlimefunReloadedItems.ENDER_LUMP_1, new ItemStack(Material.ENDER_EYE), SlimefunReloadedItems.ENDER_LUMP_1, new ItemStack(Material.OBSIDIAN), null, new ItemStack(Material.OBSIDIAN), new ItemStack(Material.OBSIDIAN), null, new ItemStack(Material.OBSIDIAN)});
    registerSimpleSlimefunReloadedItem("ender_boots", MAGIC_ARMOR, (SlimefunReloadedItemStack) SlimefunReloadedItems.ENDER_BOOTS, RecipeType.ARMOR_FORGE, new ItemStack[]{null, null, null, SlimefunReloadedItems.ENDER_LUMP_1, null, SlimefunReloadedItems.ENDER_LUMP_1, new ItemStack(Material.OBSIDIAN), null, new ItemStack(Material.OBSIDIAN)});
    registerSimpleSlimefunReloadedItem("slime_helmet", MAGIC_ARMOR, (SlimefunReloadedItemStack) SlimefunReloadedItems.SLIME_HELMET, RecipeType.ARMOR_FORGE, new ItemStack[]{new ItemStack(Material.SLIME_BALL), new ItemStack(Material.IRON_INGOT), new ItemStack(Material.SLIME_BALL), new ItemStack(Material.IRON_INGOT), null, new ItemStack(Material.IRON_INGOT), null, null, null});
    registerSimpleSlimefunReloadedItem("slime_chestplate", MAGIC_ARMOR, (SlimefunReloadedItemStack) SlimefunReloadedItems.SLIME_CHESTPLATE, RecipeType.ARMOR_FORGE, new ItemStack[]{new ItemStack(Material.SLIME_BALL), null, new ItemStack(Material.SLIME_BALL), new ItemStack(Material.IRON_INGOT), new ItemStack(Material.SLIME_BALL), new ItemStack(Material.IRON_INGOT), new ItemStack(Material.IRON_INGOT), new ItemStack(Material.SLIME_BALL), new ItemStack(Material.IRON_INGOT)});
    registerSlimefunReloadedArmorPiece("slime_leggings", MAGIC_ARMOR, (SlimefunReloadedItemStack) SlimefunReloadedItems.SLIME_LEGGINGS, RecipeType.ARMOR_FORGE, new ItemStack[]{new ItemStack(Material.SLIME_BALL), new ItemStack(Material.IRON_INGOT), new ItemStack(Material.SLIME_BALL), new ItemStack(Material.IRON_INGOT), null, new ItemStack(Material.IRON_INGOT), new ItemStack(Material.IRON_INGOT), null, new ItemStack(Material.IRON_INGOT)}, new PotionEffect[]{new PotionEffect(PotionEffectType.SPEED, 300, 2)});
    registerSlimefunReloadedArmorPiece("slime_boots", MAGIC_ARMOR, (SlimefunReloadedItemStack) SlimefunReloadedItems.SLIME_BOOTS, RecipeType.ARMOR_FORGE, new ItemStack[]{null, null, null, new ItemStack(Material.SLIME_BALL), null, new ItemStack(Material.SLIME_BALL), new ItemStack(Material.IRON_INGOT), null, new ItemStack(Material.IRON_INGOT)}, new PotionEffect[]{new PotionEffect(PotionEffectType.JUMP, 300, 5)});
    registerSimpleSlimefunReloadedItem("slime_helmet_steel", MAGIC_ARMOR, (SlimefunReloadedItemStack) SlimefunReloadedItems.SLIME_HELMET_STEEL, RecipeType.ARMOR_FORGE, new ItemStack[]{new ItemStack(Material.SLIME_BALL), SlimefunReloadedItems.STEEL_PLATE, new ItemStack(Material.SLIME_BALL), new ItemStack(Material.SLIME_BALL), null, new ItemStack(Material.SLIME_BALL), null, null, null});
    registerSimpleSlimefunReloadedItem("slime_chestplate_steel", MAGIC_ARMOR, (SlimefunReloadedItemStack) SlimefunReloadedItems.SLIME_CHESTPLATE_STEEL, RecipeType.ARMOR_FORGE, new ItemStack[]{new ItemStack(Material.SLIME_BALL), null, new ItemStack(Material.SLIME_BALL), new ItemStack(Material.SLIME_BALL), SlimefunReloadedItems.STEEL_PLATE, new ItemStack(Material.SLIME_BALL), new ItemStack(Material.SLIME_BALL), new ItemStack(Material.SLIME_BALL), new ItemStack(Material.SLIME_BALL)});
    registerSlimefunReloadedArmorPiece("slime_leggings_steel", MAGIC_ARMOR, (SlimefunReloadedItemStack) SlimefunReloadedItems.SLIME_LEGGINGS_STEEL, RecipeType.ARMOR_FORGE, new ItemStack[]{new ItemStack(Material.SLIME_BALL), SlimefunReloadedItems.STEEL_PLATE, new ItemStack(Material.SLIME_BALL), new ItemStack(Material.SLIME_BALL), null, new ItemStack(Material.SLIME_BALL), new ItemStack(Material.SLIME_BALL), null, new ItemStack(Material.SLIME_BALL)}, new PotionEffect[]{new PotionEffect(PotionEffectType.SPEED, 300, 2)});
    registerSlimefunReloadedArmorPiece("slime_boots_steel", MAGIC_ARMOR, (SlimefunReloadedItemStack) SlimefunReloadedItems.SLIME_BOOTS_STEEL, RecipeType.ARMOR_FORGE, new ItemStack[]{null, null, null, new ItemStack(Material.SLIME_BALL), null, new ItemStack(Material.SLIME_BALL), new ItemStack(Material.SLIME_BALL), SlimefunReloadedItems.STEEL_PLATE, new ItemStack(Material.SLIME_BALL)}, new PotionEffect[]{new PotionEffect(PotionEffectType.JUMP, 300, 5)});
    registerSimpleSlimefunReloadedItem("farmer_shoes", MAGIC_ARMOR, (SlimefunReloadedItemStack) SlimefunReloadedItems.FARMER_SHOES, RecipeType.ARMOR_FORGE, new ItemStack[]{null, null, null, new ItemStack(Material.HAY_BLOCK), null, new ItemStack(Material.HAY_BLOCK), new ItemStack(Material.HAY_BLOCK), null, new ItemStack(Material.HAY_BLOCK)});
    registerSimpleSlimefunReloadedItem("boots_of_the_stomper", MAGIC, (SlimefunReloadedItemStack) SlimefunReloadedItems.BOOTS_OF_THE_STOMPER, RecipeType.ARMOR_FORGE, new ItemStack[]{null, null, null, new ItemStack(Material.YELLOW_WOOL), null, new ItemStack(Material.YELLOW_WOOL), new ItemStack(Material.PISTON), null, new ItemStack(Material.PISTON)});
    registerSoulboundItem("soulbound_helmet", MAGIC_ARMOR, (SlimefunReloadedItemStack) SlimefunReloadedItems.SOULBOUND_HELMET, new ItemStack[]{null, SlimefunReloadedItems.ESSENCE_OF_AFTERLIFE, null, null, new ItemStack(Material.DIAMOND_HELMET), null, null, SlimefunReloadedItems.ESSENCE_OF_AFTERLIFE, null});
    registerSoulboundItem("soulbound_chestplate", MAGIC_ARMOR, (SlimefunReloadedItemStack) SlimefunReloadedItems.SOULBOUND_CHESTPLATE, new ItemStack[]{null, SlimefunReloadedItems.ESSENCE_OF_AFTERLIFE, null, null, new ItemStack(Material.DIAMOND_CHESTPLATE), null, null, SlimefunReloadedItems.ESSENCE_OF_AFTERLIFE, null});
    registerSoulboundItem("soulbound_leggings", MAGIC_ARMOR, (SlimefunReloadedItemStack) SlimefunReloadedItems.SOULBOUND_LEGGINGS, new ItemStack[]{null, SlimefunReloadedItems.ESSENCE_OF_AFTERLIFE, null, null, new ItemStack(Material.DIAMOND_LEGGINGS), null, null, SlimefunReloadedItems.ESSENCE_OF_AFTERLIFE, null});
    registerSoulboundItem("soulbound_boots", MAGIC_ARMOR, (SlimefunReloadedItemStack) SlimefunReloadedItems.SOULBOUND_BOOTS, new ItemStack[]{null, SlimefunReloadedItems.ESSENCE_OF_AFTERLIFE, null, null, new ItemStack(Material.DIAMOND_BOOTS), null, null, SlimefunReloadedItems.ESSENCE_OF_AFTERLIFE, null});
    //TECH_MISC Registery
    Category TECH_MISC = CATEGORY_MANAGER.getCategoryByKey("TECHNICAL_COMPONENTS");
    registerSimpleSlimefunReloadedItem("basic_circuit_board", TECH_MISC, (SlimefunReloadedItemStack) SlimefunReloadedItems.BASIC_CIRCUIT_BOARD, RecipeType.MOB_DROP, new ItemStack[]{null, null, null, null, new CustomItem(new ItemStack(Material.POPPY), "&a&oIron Golem"), null, null, null, null});
    registerSimpleSlimefunReloadedItem("advanced_circuit_board", TECH_MISC, (SlimefunReloadedItemStack) SlimefunReloadedItems.ADVANCED_CIRCUIT_BOARD, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{new ItemStack(Material.LAPIS_BLOCK), new ItemStack(Material.LAPIS_BLOCK), new ItemStack(Material.LAPIS_BLOCK), new ItemStack(Material.REDSTONE_BLOCK), SlimefunReloadedItems.BASIC_CIRCUIT_BOARD, new ItemStack(Material.REDSTONE_BLOCK), new ItemStack(Material.LAPIS_BLOCK), new ItemStack(Material.LAPIS_BLOCK), new ItemStack(Material.LAPIS_BLOCK)});
    registerSimpleSlimefunReloadedItem("battery", TECH_MISC, (SlimefunReloadedItemStack) SlimefunReloadedItems.BATTERY, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{null, new ItemStack(Material.REDSTONE), null, SlimefunReloadedItems.ZINC_INGOT, SlimefunReloadedItems.SULFATE, SlimefunReloadedItems.COPPER_INGOT, SlimefunReloadedItems.ZINC_INGOT, SlimefunReloadedItems.SULFATE, SlimefunReloadedItems.COPPER_INGOT});
    registerSimpleSlimefunReloadedItem("steel_thruster", TECH_MISC, (SlimefunReloadedItemStack) SlimefunReloadedItems.STEEL_THRUSTER, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{null, new ItemStack(Material.REDSTONE), null, SlimefunReloadedItems.ALUMINUM_BRONZE_INGOT, SlimefunReloadedItems.ALUMINUM_BRONZE_INGOT, SlimefunReloadedItems.ALUMINUM_BRONZE_INGOT, SlimefunReloadedItems.STEEL_PLATE, new ItemStack(Material.FIRE_CHARGE), SlimefunReloadedItems.STEEL_PLATE});
    registerSimpleSlimefunReloadedItem("power_crystal", TECH_MISC, (SlimefunReloadedItemStack) SlimefunReloadedItems.POWER_CRYSTAL, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{new ItemStack(Material.REDSTONE), SlimefunReloadedItems.SYNTHETIC_SAPPHIRE, new ItemStack(Material.REDSTONE), SlimefunReloadedItems.SYNTHETIC_SAPPHIRE, SlimefunReloadedItems.SYNTHETIC_DIAMOND, SlimefunReloadedItems.SYNTHETIC_SAPPHIRE, new ItemStack(Material.REDSTONE), SlimefunReloadedItems.SYNTHETIC_SAPPHIRE, new ItemStack(Material.REDSTONE)});
    registerSimpleSlimefunReloadedItem("solar_panel", TECH_MISC, (SlimefunReloadedItemStack) SlimefunReloadedItems.SOLAR_PANEL, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{new ItemStack(Material.GLASS), new ItemStack(Material.GLASS), new ItemStack(Material.GLASS), SlimefunReloadedItems.SILICON, SlimefunReloadedItems.SILICON, SlimefunReloadedItems.SILICON, SlimefunReloadedItems.FERROSILICON, SlimefunReloadedItems.FERROSILICON, SlimefunReloadedItems.FERROSILICON});
    registerSlimefunReloadedAlloy("magnet", TECH_MISC, (SlimefunReloadedItemStack) SlimefunReloadedItems.MAGNET, new ItemStack[]{SlimefunReloadedItems.NICKEL_INGOT, SlimefunReloadedItems.ALUMINUM_DUST, SlimefunReloadedItems.IRON_DUST, SlimefunReloadedItems.COBALT_INGOT, null, null, null, null, null});
    registerSimpleSlimefunReloadedItem("electro_magnet", TECH_MISC, (SlimefunReloadedItemStack) SlimefunReloadedItems.ELECTRO_MAGNET, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{SlimefunReloadedItems.NICKEL_INGOT, SlimefunReloadedItems.MAGNET, SlimefunReloadedItems.COBALT_INGOT, null, SlimefunReloadedItems.BATTERY, null, null, null, null});
    registerSimpleSlimefunReloadedItem("electric_motor", TECH_MISC, (SlimefunReloadedItemStack) SlimefunReloadedItems.ELECTRIC_MOTOR, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{SlimefunReloadedItems.COPPER_WIRE, SlimefunReloadedItems.COPPER_WIRE, SlimefunReloadedItems.COPPER_WIRE, null, SlimefunReloadedItems.ELECTRO_MAGNET, null, SlimefunReloadedItems.COPPER_WIRE, SlimefunReloadedItems.COPPER_WIRE, SlimefunReloadedItems.COPPER_WIRE});
    registerSimpleSlimefunReloadedItem("heating_coil", TECH_MISC, (SlimefunReloadedItemStack) SlimefunReloadedItems.HEATING_COIL, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{SlimefunReloadedItems.COPPER_WIRE, SlimefunReloadedItems.COPPER_WIRE, SlimefunReloadedItems.COPPER_WIRE, SlimefunReloadedItems.COPPER_WIRE, SlimefunReloadedItems.ELECTRIC_MOTOR, SlimefunReloadedItems.COPPER_WIRE, SlimefunReloadedItems.COPPER_WIRE, SlimefunReloadedItems.COPPER_WIRE, SlimefunReloadedItems.COPPER_WIRE});
    registerSimpleSlimefunReloadedItem("copper_wire", TECH_MISC, (SlimefunReloadedItemStack) SlimefunReloadedItems.COPPER_WIRE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{null, null, null, SlimefunReloadedItems.COPPER_INGOT, SlimefunReloadedItems.COPPER_INGOT, SlimefunReloadedItems.COPPER_INGOT, null, null, null}, new CustomItem(SlimefunReloadedItems.COPPER_WIRE, 8));
    registerSimpleSlimefunReloadedItem("harden_glass", TECH_MISC, (SlimefunReloadedItemStack) SlimefunReloadedItems.HARDENED_GLASS, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{new ItemStack(Material.GLASS), new ItemStack(Material.GLASS), new ItemStack(Material.GLASS), new ItemStack(Material.GLASS), SlimefunReloadedItems.REINFORCED_PLATE, new ItemStack(Material.GLASS), new ItemStack(Material.GLASS), new ItemStack(Material.GLASS), new ItemStack(Material.GLASS)}, new CustomItem(SlimefunReloadedItems.HARDENED_GLASS, 16));
    registerSimpleSlimefunReloadedItem("solar_array", TECH_MISC, (SlimefunReloadedItemStack) SlimefunReloadedItems.SOLAR_ARRAY, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{SlimefunReloadedItems.HARDENED_GLASS, SlimefunReloadedItems.HARDENED_GLASS, SlimefunReloadedItems.HARDENED_GLASS, SlimefunReloadedItems.SOLAR_PANEL, SlimefunReloadedItems.SOLAR_PANEL, SlimefunReloadedItems.SOLAR_PANEL, SlimefunReloadedItems.HARDENED_GLASS, SlimefunReloadedItems.HARDENED_GLASS, SlimefunReloadedItems.HARDENED_GLASS});
    registerSimpleSlimefunReloadedItem("cooling_unit", TECH_MISC, (SlimefunReloadedItemStack) SlimefunReloadedItems.COOLING_UNIT, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{new ItemStack(Material.ICE), new ItemStack(Material.ICE), new ItemStack(Material.ICE), SlimefunReloadedItems.ALUMINUM_INGOT, SlimefunReloadedItems.ELECTRIC_MOTOR, SlimefunReloadedItems.ALUMINUM_INGOT, new ItemStack(Material.ICE), new ItemStack(Material.ICE), new ItemStack(Material.ICE)});
    registerSimpleSlimefunReloadedItem("wither_proof_obsidian", TECH_MISC, (SlimefunReloadedItemStack) SlimefunReloadedItems.WITHER_PROOF_OBSIDIAN, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{SlimefunReloadedItems.LEAD_INGOT, new ItemStack(Material.OBSIDIAN), SlimefunReloadedItems.LEAD_INGOT, new ItemStack(Material.OBSIDIAN), SlimefunReloadedItems.HARDENED_GLASS, new ItemStack(Material.OBSIDIAN), SlimefunReloadedItems.LEAD_INGOT, new ItemStack(Material.OBSIDIAN), SlimefunReloadedItems.LEAD_INGOT}, new CustomItem(SlimefunReloadedItems.WITHER_PROOF_OBSIDIAN, 4));
    registerSimpleSlimefunReloadedItem("wither_proof_glass", MAGIC, (SlimefunReloadedItemStack) SlimefunReloadedItems.WITHER_PROOF_GLASS, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{SlimefunReloadedItems.LEAD_INGOT, SlimefunReloadedItems.WITHER_PROOF_OBSIDIAN, SlimefunReloadedItems.LEAD_INGOT, SlimefunReloadedItems.WITHER_PROOF_OBSIDIAN, SlimefunReloadedItems.HARDENED_GLASS, SlimefunReloadedItems.WITHER_PROOF_OBSIDIAN, SlimefunReloadedItems.LEAD_INGOT, SlimefunReloadedItems.WITHER_PROOF_OBSIDIAN, SlimefunReloadedItems.LEAD_INGOT}, new CustomItem(SlimefunReloadedItems.WITHER_PROOF_GLASS, 4));
    registerSimpleSlimefunReloadedItem("reactor_coolant_cell", TECH_MISC, (SlimefunReloadedItemStack) SlimefunReloadedItems.REACTOR_COOLANT_CELL, new RecipeType(SlimefunReloadedItems.FREEZER), new ItemStack[]{new ItemStack(Material.BLUE_ICE), null, null, null, null, null, null, null, null});
    registerSimpleSlimefunReloadedItem("nether_ice_coolant_cell", MAGIC, (SlimefunReloadedItemStack) SlimefunReloadedItems.NETHER_ICE_COOLANT_CELL, new RecipeType(SlimefunReloadedItems.HEATED_PRESSURE_CHAMBER), new ItemStack[]{SlimefunReloadedItems.ENRICHED_NETHER_ICE, null, null, null, null, null, null, null, null});
    //RESOURCE Registery
    Category RESOURCES = CATEGORY_MANAGER.getCategoryByKey("RESOURCES");
    register(new ReplacingItem(new NamespacedKey(plugin, "synthetic_diamond"), RESOURCES, SlimefunReloadedItems.SYNTHETIC_DIAMOND, RecipeType.PRESSURE_CHAMBER, new ItemStack[]{SlimefunReloadedItems.CARBON_CHUNK, null, null, null, null, null, null, null, null}));
    registerSimpleSlimefunReloadedItem("carbonado", RESOURCES, (SlimefunReloadedItemStack) SlimefunReloadedItems.CARBONADO, RecipeType.PRESSURE_CHAMBER, new ItemStack[]{SlimefunReloadedItems.RAW_CARBONADO, null, null, null, null, null, null, null, null});
    registerSimpleSlimefunReloadedItem("iron_dust", RESOURCES, (SlimefunReloadedItemStack) SlimefunReloadedItems.IRON_DUST, RecipeType.ORE_CRUSHER, new ItemStack[]{new ItemStack(Material.IRON_ORE), null, null, null, null, null, null, null, null}, new CustomItem(SlimefunReloadedItems.IRON_DUST, (boolean) Slimefun.getItemValue("ORE_CRUSHER", "double-ores") ? 2 : 1));
    registerSimpleSlimefunReloadedItem("gold_dust", RESOURCES, (SlimefunReloadedItemStack) SlimefunReloadedItems.GOLD_DUST, RecipeType.ORE_CRUSHER, new ItemStack[]{new ItemStack(Material.GOLD_ORE), null, null, null, null, null, null, null, null}, new CustomItem(SlimefunReloadedItems.GOLD_DUST, (boolean) Slimefun.getItemValue("ORE_CRUSHER", "double-ores") ? 2 : 1));
    registerSimpleSlimefunReloadedItem("copper_dust", RESOURCES, (SlimefunReloadedItemStack) SlimefunReloadedItems.COPPER_DUST, RecipeType.ORE_WASHER, new ItemStack[]{SlimefunReloadedItems.SIFTED_ORE, null, null, null, null, null, null, null, null});
    registerSimpleSlimefunReloadedItem("tin_dust", RESOURCES, (SlimefunReloadedItemStack) SlimefunReloadedItems.TIN_DUST, RecipeType.ORE_WASHER, new ItemStack[]{SlimefunReloadedItems.SIFTED_ORE, null, null, null, null, null, null, null, null});
    registerSimpleSlimefunReloadedItem("lead_dust", RESOURCES, (SlimefunReloadedItemStack) SlimefunReloadedItems.LEAD_DUST, RecipeType.ORE_WASHER, new ItemStack[]{SlimefunReloadedItems.SIFTED_ORE, null, null, null, null, null, null, null, null});
    registerSimpleSlimefunReloadedItem("silver_dust", RESOURCES, (SlimefunReloadedItemStack) SlimefunReloadedItems.SILVER_DUST, RecipeType.ORE_WASHER, new ItemStack[]{SlimefunReloadedItems.SIFTED_ORE, null, null, null, null, null, null, null, null});
    registerSimpleSlimefunReloadedItem("aluminum_dust", RESOURCES, (SlimefunReloadedItemStack) SlimefunReloadedItems.ALUMINUM_DUST, RecipeType.ORE_WASHER, new ItemStack[]{SlimefunReloadedItems.SIFTED_ORE, null, null, null, null, null, null, null, null});
    registerSimpleSlimefunReloadedItem("zinc_dust", MAGIC, (SlimefunReloadedItemStack) SlimefunReloadedItems.ZINC_DUST, RecipeType.ORE_WASHER, new ItemStack[]{SlimefunReloadedItems.SIFTED_ORE, null, null, null, null, null, null, null, null});
    registerSimpleSlimefunReloadedItem("magnesium_dust", MAGIC, (SlimefunReloadedItemStack) SlimefunReloadedItems.MAGNESIUM_DUST, RecipeType.ORE_WASHER, new ItemStack[]{SlimefunReloadedItems.SIFTED_ORE, null, null, null, null, null, null, null, null});
    registerSimpleSlimefunReloadedItem("copper_ingot", RESOURCES, (SlimefunReloadedItemStack) SlimefunReloadedItems.COPPER_INGOT, RecipeType.SMELTERY, new ItemStack[]{SlimefunReloadedItems.COPPER_DUST, null, null, null, null, null, null, null, null});
    registerSimpleSlimefunReloadedItem("tin_ingot", RESOURCES, (SlimefunReloadedItemStack) SlimefunReloadedItems.TIN_INGOT, RecipeType.SMELTERY, new ItemStack[]{SlimefunReloadedItems.TIN_DUST, null, null, null, null, null, null, null, null});
    registerSimpleSlimefunReloadedItem("silver_ingot", RESOURCES, (SlimefunReloadedItemStack) SlimefunReloadedItems.SILVER_INGOT, RecipeType.SMELTERY, new ItemStack[]{SlimefunReloadedItems.SILVER_DUST, null, null, null, null, null, null, null, null});
    registerSimpleSlimefunReloadedItem("lead_ingot", RESOURCES, (SlimefunReloadedItemStack) SlimefunReloadedItems.LEAD_INGOT, RecipeType.SMELTERY, new ItemStack[]{SlimefunReloadedItems.LEAD_DUST, null, null, null, null, null, null, null, null});
    registerSimpleSlimefunReloadedItem("aluminum_ingot", RESOURCES, (SlimefunReloadedItemStack) SlimefunReloadedItems.ALUMINUM_INGOT, RecipeType.SMELTERY, new ItemStack[]{SlimefunReloadedItems.ALUMINUM_DUST, null, null, null, null, null, null, null, null});
    registerSimpleSlimefunReloadedItem("zinc_ingot", RESOURCES, (SlimefunReloadedItemStack) SlimefunReloadedItems.ZINC_INGOT, RecipeType.SMELTERY, new ItemStack[]{SlimefunReloadedItems.ZINC_DUST, null, null, null, null, null, null, null, null});
    registerSimpleSlimefunReloadedItem("magnesium_ingot", RESOURCES, (SlimefunReloadedItemStack) SlimefunReloadedItems.MAGNESIUM_INGOT, RecipeType.SMELTERY, new ItemStack[]{SlimefunReloadedItems.MAGNESIUM_DUST, null, null, null, null, null, null, null, null});
    registerSimpleSlimefunReloadedItem("sulfate", RESOURCES, (SlimefunReloadedItemStack) SlimefunReloadedItems.SULFATE, RecipeType.ORE_CRUSHER, new ItemStack[]{new ItemStack(Material.NETHERRACK, 16), null, null, null, null, null, null, null, null});
    registerSimpleSlimefunReloadedItem("carbon", RESOURCES, (SlimefunReloadedItemStack) SlimefunReloadedItems.CARBON, RecipeType.COMPRESSOR, new ItemStack[]{new ItemStack(Material.COAL, 8), null, null, null, null, null, null, null, null});
    registerSimpleSlimefunReloadedItem("compressed_carbon", RESOURCES, (SlimefunReloadedItemStack) SlimefunReloadedItems.COMPRESSED_CARBON, RecipeType.COMPRESSOR, new ItemStack[]{new CustomItem(SlimefunReloadedItems.CARBON, 4), null, null, null, null, null, null, null, null});
    registerSimpleSlimefunReloadedItem("carbon_chunk", RESOURCES, (SlimefunReloadedItemStack) SlimefunReloadedItems.CARBON_CHUNK, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{SlimefunReloadedItems.COMPRESSED_CARBON, SlimefunReloadedItems.COMPRESSED_CARBON, SlimefunReloadedItems.COMPRESSED_CARBON, SlimefunReloadedItems.COMPRESSED_CARBON, new ItemStack(Material.FLINT), SlimefunReloadedItems.COMPRESSED_CARBON, SlimefunReloadedItems.COMPRESSED_CARBON, SlimefunReloadedItems.COMPRESSED_CARBON, SlimefunReloadedItems.COMPRESSED_CARBON});
    registerSimpleSlimefunReloadedItem("gold_24k", RESOURCES, (SlimefunReloadedItemStack) SlimefunReloadedItems.GOLD_24K, RecipeType.SMELTERY, new ItemStack[]{SlimefunReloadedItems.GOLD_DUST, SlimefunReloadedItems.GOLD_22K, null, null, null, null, null, null, null});
    registerSimpleSlimefunReloadedItem("gold_22k", RESOURCES, (SlimefunReloadedItemStack) SlimefunReloadedItems.GOLD_22K, RecipeType.SMELTERY, new ItemStack[]{SlimefunReloadedItems.GOLD_DUST, SlimefunReloadedItems.GOLD_20K, null, null, null, null, null, null, null});
    registerSimpleSlimefunReloadedItem("gold_20k", RESOURCES, (SlimefunReloadedItemStack) SlimefunReloadedItems.GOLD_20K, RecipeType.SMELTERY, new ItemStack[]{SlimefunReloadedItems.GOLD_DUST, SlimefunReloadedItems.GOLD_18K, null, null, null, null, null, null, null});
    registerSimpleSlimefunReloadedItem("gold_18k", RESOURCES, (SlimefunReloadedItemStack) SlimefunReloadedItems.GOLD_18K, RecipeType.SMELTERY, new ItemStack[]{SlimefunReloadedItems.GOLD_DUST, SlimefunReloadedItems.GOLD_16K, null, null, null, null, null, null, null});
    registerSimpleSlimefunReloadedItem("gold_16k", RESOURCES, (SlimefunReloadedItemStack) SlimefunReloadedItems.GOLD_16K, RecipeType.SMELTERY, new ItemStack[]{SlimefunReloadedItems.GOLD_DUST, SlimefunReloadedItems.GOLD_14K, null, null, null, null, null, null, null});
    registerSimpleSlimefunReloadedItem("gold_14k", RESOURCES, (SlimefunReloadedItemStack) SlimefunReloadedItems.GOLD_14K, RecipeType.SMELTERY, new ItemStack[]{SlimefunReloadedItems.GOLD_DUST, SlimefunReloadedItems.GOLD_12K, null, null, null, null, null, null, null});
    registerSimpleSlimefunReloadedItem("gold_12k", RESOURCES, (SlimefunReloadedItemStack) SlimefunReloadedItems.GOLD_12K, RecipeType.SMELTERY, new ItemStack[]{SlimefunReloadedItems.GOLD_DUST, SlimefunReloadedItems.GOLD_10K, null, null, null, null, null, null, null});
    registerSimpleSlimefunReloadedItem("gold_10k", RESOURCES, (SlimefunReloadedItemStack) SlimefunReloadedItems.GOLD_10K, RecipeType.SMELTERY, new ItemStack[]{SlimefunReloadedItems.GOLD_DUST, SlimefunReloadedItems.GOLD_8K, null, null, null, null, null, null, null});
    registerSimpleSlimefunReloadedItem("gold_8k", RESOURCES, (SlimefunReloadedItemStack) SlimefunReloadedItems.GOLD_8K, RecipeType.SMELTERY, new ItemStack[]{SlimefunReloadedItems.GOLD_DUST, SlimefunReloadedItems.GOLD_6K, null, null, null, null, null, null, null});
    registerSimpleSlimefunReloadedItem("gold_6k", RESOURCES, (SlimefunReloadedItemStack) SlimefunReloadedItems.GOLD_6K, RecipeType.SMELTERY, new ItemStack[]{SlimefunReloadedItems.GOLD_DUST, SlimefunReloadedItems.GOLD_4K, null, null, null, null, null, null, null});
    registerSimpleSlimefunReloadedItem("gold_4k", RESOURCES, (SlimefunReloadedItemStack) SlimefunReloadedItems.GOLD_4K, RecipeType.SMELTERY, new ItemStack[]{SlimefunReloadedItems.GOLD_DUST, null, null, null, null, null, null, null, null});
    registerSimpleSlimefunReloadedItem("stone_chunk", RESOURCES, (SlimefunReloadedItemStack) SlimefunReloadedItems.STONE_CHUNK, RecipeType.ORE_WASHER, new ItemStack[]{SlimefunReloadedItems.SIFTED_ORE, null, null, null, null, null, null, null, null});
    registerSimpleSlimefunReloadedItem("silicon", RESOURCES, (SlimefunReloadedItemStack) SlimefunReloadedItems.SILICON, RecipeType.SMELTERY, new ItemStack[]{new ItemStack(Material.QUARTZ_BLOCK), null, null, null, null, null, null, null, null});
    registerSimpleSlimefunReloadedItem("uranium", RESOURCES, (SlimefunReloadedItemStack) SlimefunReloadedItems.URANIUM, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{SlimefunReloadedItems.SMALL_URANIUM, SlimefunReloadedItems.SMALL_URANIUM, null, SlimefunReloadedItems.SMALL_URANIUM, SlimefunReloadedItems.SMALL_URANIUM, null, null, null, null});
    registerSimpleSlimefunReloadedItem("bucket_of_oil", RESOURCES, (SlimefunReloadedItemStack) SlimefunReloadedItems.BUCKET_OF_OIL, new RecipeType(SlimefunReloadedItems.OIL_PUMP), new ItemStack[]{null, null, null, null, new ItemStack(Material.BUCKET), null, null, null, null});
    registerSimpleSlimefunReloadedItem("bucket_of_fuel", RESOURCES, (SlimefunReloadedItemStack) SlimefunReloadedItems.BUCKET_OF_FUEL, new RecipeType(SlimefunReloadedItems.REFINERY), new ItemStack[]{null, null, null, null, SlimefunReloadedItems.BUCKET_OF_OIL, null, null, null, null});
    registerSimpleSlimefunReloadedItem("nether_ice", RESOURCES, (SlimefunReloadedItemStack) SlimefunReloadedItems.NETHER_ICE, new RecipeType(SlimefunReloadedItems.GEO_MINER), new ItemStack[]{null, null, null, null, null, null, null, null});
    registerSimpleSlimefunReloadedItem("blistering_ingot", RESOURCES, (SlimefunReloadedItemStack) SlimefunReloadedItems.BLISTERING_INGOT, RecipeType.HEATED_PRESSURE_CHAMBER, new ItemStack[]{SlimefunReloadedItems.GOLD_24K, SlimefunReloadedItems.URANIUM, null, null, null, null, null, null, null});
    registerSimpleSlimefunReloadedItem("blistering_ingot_2", RESOURCES, (SlimefunReloadedItemStack) SlimefunReloadedItems.BLISTERING_INGOT_2, RecipeType.HEATED_PRESSURE_CHAMBER, new ItemStack[]{SlimefunReloadedItems.BLISTERING_INGOT, SlimefunReloadedItems.CARBONADO, null, null, null, null, null, null, null});
    registerSimpleSlimefunReloadedItem("blistering_ingot_3", RESOURCES, (SlimefunReloadedItemStack) SlimefunReloadedItems.BLISTERING_INGOT_3, RecipeType.HEATED_PRESSURE_CHAMBER, new ItemStack[]{SlimefunReloadedItems.BLISTERING_INGOT_2, new ItemStack(Material.NETHER_STAR), null, null, null, null, null, null, null});
    registerSimpleSlimefunReloadedItem("enriched_nether_ice", RESOURCES, (SlimefunReloadedItemStack) SlimefunReloadedItems.ENRICHED_NETHER_ICE, RecipeType.HEATED_PRESSURE_CHAMBER, new ItemStack[]{SlimefunReloadedItems.NETHER_ICE, SlimefunReloadedItems.PLUTONIUM, null, null, null, null, null, null, null});
    registerSimpleSlimefunReloadedItem("neptunium", RESOURCES, (SlimefunReloadedItemStack) SlimefunReloadedItems.NEPTUNIUM, new RecipeType(SlimefunReloadedItems.NUCLEAR_REACTOR), new ItemStack[]{SlimefunReloadedItems.URANIUM, null, null, null, null, null, null, null, null});
    //SlimefunReloadedItems.setRadioactive(SlimefunReloadedItems.NEPTUNIUM);
    registerSimpleSlimefunReloadedItem("plutonium", RESOURCES, (SlimefunReloadedItemStack) SlimefunReloadedItems.PLUTONIUM, new RecipeType(SlimefunReloadedItems.NUCLEAR_REACTOR), new ItemStack[]{SlimefunReloadedItems.NEPTUNIUM, null, null, null, null, null, null, null, null});
    //SlimefunReloadedItems.setRadioactive(SlimefunReloadedItems.PLUTONIUM);
    registerSimpleSlimefunReloadedItem("boosted_uranium", RESOURCES, (SlimefunReloadedItemStack) SlimefunReloadedItems.BOOSTED_URANIUM, RecipeType.HEATED_PRESSURE_CHAMBER, new ItemStack[]{SlimefunReloadedItems.PLUTONIUM, SlimefunReloadedItems.URANIUM, null, null, null, null, null, null, null});
    //TOOLS Registery
    Category TOOLS = CATEGORY_MANAGER.getCategoryByKey("TOOLS");
    register(new GoldPan(new NamespacedKey(plugin, "gold_pan"), TOOLS, (SlimefunReloadedItemStack) SlimefunReloadedItems.GOLD_PAN, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{null, null, null, new ItemStack(Material.STONE), new ItemStack(Material.BOWL), new ItemStack(Material.STONE), new ItemStack(Material.STONE), new ItemStack(Material.STONE), new ItemStack(Material.STONE)}));
    register(new NetherGoldPan(new NamespacedKey(plugin, "nether_gold_pan"), TOOLS, (SlimefunReloadedItemStack) SlimefunReloadedItems.NETHER_GOLD_PAN, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{null, null, null, new ItemStack(Material.NETHER_BRICK), SlimefunReloadedItems.GOLD_PAN, new ItemStack(Material.NETHER_BRICK), new ItemStack(Material.NETHER_BRICK), new ItemStack(Material.NETHER_BRICK), new ItemStack(Material.NETHER_BRICK)}));
    register(new GrapplingHook(new NamespacedKey(plugin, "grappling_hook"), TOOLS, (SlimefunReloadedItemStack) SlimefunReloadedItems.GRAPPLING_HOOK, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{null, null, SlimefunReloadedItems.HOOK, null, SlimefunReloadedItems.CHAIN, null, SlimefunReloadedItems.CHAIN, null, null}, new String[]{"despawn-seconds"}, new Object[]{60}));
    register(new SmeltersPickaxe(new NamespacedKey(plugin, "smelters_pickaxe"), TOOLS, (SlimefunReloadedItemStack) SlimefunReloadedItems.AUTO_SMELT_PICKAXE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{SlimefunReloadedItems.LAVA_CRYSTAL, SlimefunReloadedItems.LAVA_CRYSTAL, SlimefunReloadedItems.LAVA_CRYSTAL, null, SlimefunReloadedItems.FERROSILICON, null, null, SlimefunReloadedItems.FERROSILICON, null}));
    register(new LumberAxe(new NamespacedKey(plugin, "lumber_axe"), TOOLS, (SlimefunReloadedItemStack) SlimefunReloadedItems.LUMBER_AXE, RecipeType.MAGIC_WORKBENCH, new ItemStack[]{SlimefunReloadedItems.SYNTHETIC_DIAMOND, SlimefunReloadedItems.SYNTHETIC_DIAMOND, null, SlimefunReloadedItems.SYNTHETIC_EMERALD, SlimefunReloadedItems.GILDED_IRON, null, null, SlimefunReloadedItems.GILDED_IRON, null}));
    register(new PickaxeOfContainment(new NamespacedKey(plugin, "pickaxe_of_containment"), TOOLS, (SlimefunReloadedItemStack) SlimefunReloadedItems.PICKAXE_OF_CONTAINMENT, RecipeType.MAGIC_WORKBENCH, new ItemStack[]{SlimefunReloadedItems.FERROSILICON, SlimefunReloadedItems.FERROSILICON, SlimefunReloadedItems.FERROSILICON, null, SlimefunReloadedItems.GILDED_IRON, null, null, SlimefunReloadedItems.GILDED_IRON, null}));
    register(new HerculesPickaxe(new NamespacedKey(plugin, "hercules_pickaxe"), TOOLS, (SlimefunReloadedItemStack) SlimefunReloadedItems.HERCULES_PICKAXE, RecipeType.MAGIC_WORKBENCH, new ItemStack[]{SlimefunReloadedItems.HARDENED_METAL_INGOT, SlimefunReloadedItems.HARDENED_METAL_INGOT, SlimefunReloadedItems.HARDENED_METAL_INGOT, null, SlimefunReloadedItems.FERROSILICON, null, null, SlimefunReloadedItems.FERROSILICON, null}));
    register(new ExplosivePickaxe(new NamespacedKey(plugin, "explosive_pickaxe"), TOOLS, (SlimefunReloadedItemStack) SlimefunReloadedItems.EXPLOSIVE_PICKAXE, RecipeType.MAGIC_WORKBENCH, new ItemStack[]{new ItemStack(Material.TNT), SlimefunReloadedItems.SYNTHETIC_DIAMOND, new ItemStack(Material.TNT), null, SlimefunReloadedItems.FERROSILICON, null, null, SlimefunReloadedItems.FERROSILICON, null}, new String[]{"unbreakable-blocks", "damage-on-use"}, new Object[]{Stream.of(Material.BEDROCK, Material.END_PORTAL_FRAME, Material.END_PORTAL, Material.NETHER_PORTAL, Material.BARRIER, Material.STRUCTURE_BLOCK, Material.COMMAND_BLOCK, Material.CHAIN_COMMAND_BLOCK, Material.REPEATING_COMMAND_BLOCK).map(Material::toString).collect(Collectors.toList()), Boolean.FALSE}));
    register(new ExplosiveShovel(new NamespacedKey(plugin, "explosive_shovel"), TOOLS, (SlimefunReloadedItemStack) SlimefunReloadedItems.EXPLOSIVE_SHOVEL, RecipeType.MAGIC_WORKBENCH, new ItemStack[]{null, SlimefunReloadedItems.SYNTHETIC_DIAMOND, null, null, new ItemStack(Material.TNT), null, null, SlimefunReloadedItems.FERROSILICON, null}, new String[]{"damage-on-use"}, new Object[]{Boolean.FALSE}));
    registerSimpleSlimefunReloadedItem("cobalt_pickaxe", TOOLS, (SlimefunReloadedItemStack) SlimefunReloadedItems.COBALT_PICKAXE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{SlimefunReloadedItems.COBALT_INGOT, SlimefunReloadedItems.COBALT_INGOT, SlimefunReloadedItems.COBALT_INGOT, null, SlimefunReloadedItems.NICKEL_INGOT, null, null, SlimefunReloadedItems.NICKEL_INGOT, null});
    register(new PickaxeOfVeinMining(new NamespacedKey(plugin, "pickaxe_of_vein_mining"), TOOLS, (SlimefunReloadedItemStack) SlimefunReloadedItems.PICKAXE_OF_VEIN_MINING, RecipeType.MAGIC_WORKBENCH, new ItemStack[]{new ItemStack(Material.EMERALD_ORE), SlimefunReloadedItems.SYNTHETIC_DIAMOND, new ItemStack(Material.EMERALD_ORE), null, SlimefunReloadedItems.GILDED_IRON, null, null, SlimefunReloadedItems.GILDED_IRON, null}));
    registerSoulboundItem("soulbound_pickaxe", TOOLS, (SlimefunReloadedItemStack) SlimefunReloadedItems.SOULBOUND_PICKAXE, new ItemStack[]{null, SlimefunReloadedItems.ESSENCE_OF_AFTERLIFE, null, null, new ItemStack(Material.DIAMOND_PICKAXE), null, null, SlimefunReloadedItems.ESSENCE_OF_AFTERLIFE, null});
    /*
		new ExcludedSoulboundTool(TOOLS, (SlimefunReloadedItemStack) SlimefunReloadedItems.SOULBOUND_AXE,
		new ItemStack[] {null, SlimefunReloadedItems.ESSENCE_OF_AFTERLIFE, null, null, new ItemStack(Material.DIAMOND_AXE), null, null, SlimefunReloadedItems.ESSENCE_OF_AFTERLIFE, null})
		.register(true);

		new ExcludedSoulboundTool(TOOLS, (SlimefunReloadedItemStack) SlimefunReloadedItems.SOULBOUND_SHOVEL,
		new ItemStack[] {null, SlimefunReloadedItems.ESSENCE_OF_AFTERLIFE, null, null, new ItemStack(Material.DIAMOND_SHOVEL), null, null, SlimefunReloadedItems.ESSENCE_OF_AFTERLIFE, null})
		.register(true);

		new ExcludedSoulboundTool(TOOLS, (SlimefunReloadedItemStack) SlimefunReloadedItems.SOULBOUND_HOE,
		new ItemStack[] {null, SlimefunReloadedItems.ESSENCE_OF_AFTERLIFE, null, null, new ItemStack(Material.DIAMOND_HOE), null, null, SlimefunReloadedItems.ESSENCE_OF_AFTERLIFE, null})
		.register(true);
     */
    //MISC Registery
    Category MISC = CATEGORY_MANAGER.getCategoryByKey("MISC");
    registerSimpleSlimefunReloadedItem("sifted_ore", MISC, (SlimefunReloadedItemStack) SlimefunReloadedItems.SIFTED_ORE, RecipeType.GOLD_PAN, new ItemStack[]{new ItemStack(Material.GRAVEL), null, null, null, null, null, null, null, null});
    registerSimpleSlimefunReloadedItem("wheat_flour", MISC, (SlimefunReloadedItemStack) SlimefunReloadedItems.WHEAT_FLOUR, RecipeType.GRIND_STONE, new ItemStack[]{new ItemStack(Material.WHEAT), null, null, null, null, null, null, null, null});
    registerSimpleSlimefunReloadedItem("steel_plate", MISC, (SlimefunReloadedItemStack) SlimefunReloadedItems.STEEL_PLATE, RecipeType.COMPRESSOR, new ItemStack[]{new CustomItem(SlimefunReloadedItems.STEEL_INGOT, 8), null, null, null, null, null, null, null, null});
    registerSimpleSlimefunReloadedItem("chain", MISC, (SlimefunReloadedItemStack) SlimefunReloadedItems.CHAIN, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{null, null, SlimefunReloadedItems.STEEL_INGOT, null, SlimefunReloadedItems.STEEL_INGOT, null, SlimefunReloadedItems.STEEL_INGOT, null, null}, new CustomItem(SlimefunReloadedItems.CHAIN, 8));
    registerSimpleSlimefunReloadedItem("hook", MISC, (SlimefunReloadedItemStack) SlimefunReloadedItems.HOOK, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{null, SlimefunReloadedItems.STEEL_INGOT, null, SlimefunReloadedItems.STEEL_INGOT, null, SlimefunReloadedItems.STEEL_INGOT, null, null, null});
    registerSimpleSlimefunReloadedItem("salt", MISC, (SlimefunReloadedItemStack) SlimefunReloadedItems.SALT, RecipeType.ORE_WASHER, new ItemStack[]{null, null, null, null, new ItemStack(Material.SAND, 4), null, null, null, null});
    registerSimpleSlimefunReloadedItem("heavy_cream", MISC, (SlimefunReloadedItemStack) SlimefunReloadedItems.HEAVY_CREAM, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{new ItemStack(Material.MILK_BUCKET), null, null, null, null, null, null, null, null}, new CustomItem(SlimefunReloadedItems.HEAVY_CREAM, 2));
    registerSimpleSlimefunReloadedItem("chese", MISC, (SlimefunReloadedItemStack) SlimefunReloadedItems.CHEESE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{new ItemStack(Material.MILK_BUCKET), SlimefunReloadedItems.SALT, null, null, null, null, null, null, null});
    registerSimpleSlimefunReloadedItem("butter", MISC, (SlimefunReloadedItemStack) SlimefunReloadedItems.BUTTER, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{SlimefunReloadedItems.HEAVY_CREAM, SlimefunReloadedItems.SALT, null, null, null, null, null, null, null});
    registerSimpleSlimefunReloadedItem("crushed_ore", MISC, (SlimefunReloadedItemStack) SlimefunReloadedItems.CRUSHED_ORE, RecipeType.ORE_CRUSHER, new ItemStack[]{SlimefunReloadedItems.SIFTED_ORE, null, null, null, null, null, null, null, null});
    registerSimpleSlimefunReloadedItem("pulverized_ore", MISC, (SlimefunReloadedItemStack) SlimefunReloadedItems.PULVERIZED_ORE, RecipeType.ORE_CRUSHER, new ItemStack[]{SlimefunReloadedItems.CRUSHED_ORE, null, null, null, null, null, null, null, null});
    registerSimpleSlimefunReloadedItem("pure_ore_cluster", MISC, (SlimefunReloadedItemStack) SlimefunReloadedItems.PURE_ORE_CLUSTER, RecipeType.ORE_WASHER, new ItemStack[]{SlimefunReloadedItems.PULVERIZED_ORE, null, null, null, null, null, null, null, null});
    registerSimpleSlimefunReloadedItem("tiny_uranium", MISC, (SlimefunReloadedItemStack) SlimefunReloadedItems.TINY_URANIUM, RecipeType.ORE_CRUSHER, new ItemStack[]{SlimefunReloadedItems.PURE_ORE_CLUSTER, null, null, null, null, null, null, null, null});
    registerSimpleSlimefunReloadedItem("small_uranium", MISC, (SlimefunReloadedItemStack) SlimefunReloadedItems.SMALL_URANIUM, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{SlimefunReloadedItems.TINY_URANIUM, SlimefunReloadedItems.TINY_URANIUM, SlimefunReloadedItems.TINY_URANIUM, SlimefunReloadedItems.TINY_URANIUM, SlimefunReloadedItems.TINY_URANIUM, SlimefunReloadedItems.TINY_URANIUM, SlimefunReloadedItems.TINY_URANIUM, SlimefunReloadedItems.TINY_URANIUM, SlimefunReloadedItems.TINY_URANIUM});
    registerSimpleSlimefunReloadedItem("cloth", MISC, (SlimefunReloadedItemStack) SlimefunReloadedItems.CLOTH, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{new ItemStack(Material.WHITE_WOOL), null, null, null, null, null, null, null, null}, new CustomItem(SlimefunReloadedItems.CLOTH, 8));
    registerSimpleSlimefunReloadedItem("can", MISC, (SlimefunReloadedItemStack) SlimefunReloadedItems.CAN, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{SlimefunReloadedItems.TIN_INGOT, SlimefunReloadedItems.TIN_INGOT, SlimefunReloadedItems.TIN_INGOT, SlimefunReloadedItems.TIN_INGOT, null, SlimefunReloadedItems.TIN_INGOT, SlimefunReloadedItems.TIN_INGOT, SlimefunReloadedItems.TIN_INGOT, SlimefunReloadedItems.TIN_INGOT}, new CustomItem(SlimefunReloadedItems.CAN, 4));
    registerSimpleSlimefunReloadedItem("gold_24k_block", MISC, (SlimefunReloadedItemStack) SlimefunReloadedItems.GOLD_24K_BLOCK, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{SlimefunReloadedItems.GOLD_24K, SlimefunReloadedItems.GOLD_24K, SlimefunReloadedItems.GOLD_24K, SlimefunReloadedItems.GOLD_24K, SlimefunReloadedItems.GOLD_24K, SlimefunReloadedItems.GOLD_24K, SlimefunReloadedItems.GOLD_24K, SlimefunReloadedItems.GOLD_24K, SlimefunReloadedItems.GOLD_24K});
    registerSimpleSlimefunReloadedItem("reinforced_plate", MISC, (SlimefunReloadedItemStack) SlimefunReloadedItems.REINFORCED_PLATE, RecipeType.COMPRESSOR, new ItemStack[]{new CustomItem(SlimefunReloadedItems.REINFORCED_ALLOY_INGOT, 8), null, null, null, null, null, null, null, null});
    registerSimpleSlimefunReloadedItem("duct_tape", MISC, (SlimefunReloadedItemStack) SlimefunReloadedItems.DUCT_TAPE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{SlimefunReloadedItems.ALUMINUM_DUST, SlimefunReloadedItems.ALUMINUM_DUST, SlimefunReloadedItems.ALUMINUM_DUST, new ItemStack(Material.SLIME_BALL), new ItemStack(Material.WHITE_WOOL), new ItemStack(Material.SLIME_BALL), new ItemStack(Material.PAPER), new ItemStack(Material.PAPER), new ItemStack(Material.PAPER)}, new CustomItem(SlimefunReloadedItems.DUCT_TAPE, 2));
    registerSimpleSlimefunReloadedItem("plastic_sheet", MISC, (SlimefunReloadedItemStack) SlimefunReloadedItems.PLASTIC_SHEET, RecipeType.HEATED_PRESSURE_CHAMBER, new ItemStack[]{null, null, null, null, SlimefunReloadedItems.BUCKET_OF_OIL, null, null, null, null});
    registerSimpleSlimefunReloadedItem("android_memory_core", MISC, (SlimefunReloadedItemStack) SlimefunReloadedItems.ANDROID_MEMORY_CORE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{SlimefunReloadedItems.BRASS_INGOT, new ItemStack(Material.ORANGE_STAINED_GLASS), SlimefunReloadedItems.BRASS_INGOT, SlimefunReloadedItems.POWER_CRYSTAL, SlimefunReloadedItems.TIN_DUST, SlimefunReloadedItems.POWER_CRYSTAL, SlimefunReloadedItems.BRASS_INGOT, new ItemStack(Material.ORANGE_STAINED_GLASS), SlimefunReloadedItems.BRASS_INGOT});
    registerSimpleSlimefunReloadedItem("wheat_organic_food", MISC, (SlimefunReloadedItemStack) SlimefunReloadedItems.WHEAT_ORGANIC_FOOD, new RecipeType(SlimefunReloadedItems.FOOD_FABRICATOR), new ItemStack[]{SlimefunReloadedItems.CAN, new ItemStack(Material.WHEAT), null, null, null, null, null, null, null});
    registerSimpleSlimefunReloadedItem("carrot_organic_food", MISC, (SlimefunReloadedItemStack) SlimefunReloadedItems.CARROT_ORGANIC_FOOD, new RecipeType(SlimefunReloadedItems.FOOD_FABRICATOR), new ItemStack[]{SlimefunReloadedItems.CAN, new ItemStack(Material.CARROT), null, null, null, null, null, null, null});
    registerSimpleSlimefunReloadedItem("potato_organic_food", MISC, (SlimefunReloadedItemStack) SlimefunReloadedItems.POTATO_ORGANIC_FOOD, new RecipeType(SlimefunReloadedItems.FOOD_FABRICATOR), new ItemStack[]{SlimefunReloadedItems.CAN, new ItemStack(Material.POTATO), null, null, null, null, null, null, null});
    registerSimpleSlimefunReloadedItem("seeds_organic_food", MISC, (SlimefunReloadedItemStack) SlimefunReloadedItems.SEEDS_ORGANIC_FOOD, new RecipeType(SlimefunReloadedItems.FOOD_FABRICATOR), new ItemStack[]{SlimefunReloadedItems.CAN, new ItemStack(Material.WHEAT_SEEDS), null, null, null, null, null, null, null});
    registerSimpleSlimefunReloadedItem("beetroot_organic_food", MISC, (SlimefunReloadedItemStack) SlimefunReloadedItems.BEETROOT_ORGANIC_FOOD, new RecipeType(SlimefunReloadedItems.FOOD_FABRICATOR), new ItemStack[]{SlimefunReloadedItems.CAN, new ItemStack(Material.BEETROOT), null, null, null, null, null, null, null});
    registerSimpleSlimefunReloadedItem("melon_organic_food", MISC, (SlimefunReloadedItemStack) SlimefunReloadedItems.MELON_ORGANIC_FOOD, new RecipeType(SlimefunReloadedItems.FOOD_FABRICATOR), new ItemStack[]{SlimefunReloadedItems.CAN, new ItemStack(Material.MELON), null, null, null, null, null, null, null});
    registerSimpleSlimefunReloadedItem("apple_organic_food", MISC, (SlimefunReloadedItemStack) SlimefunReloadedItems.APPLE_ORGANIC_FOOD, new RecipeType(SlimefunReloadedItems.FOOD_FABRICATOR), new ItemStack[]{SlimefunReloadedItems.CAN, new ItemStack(Material.APPLE), null, null, null, null, null, null, null});
    registerSimpleSlimefunReloadedItem("sweet_berries_organic_food", MISC, (SlimefunReloadedItemStack) SlimefunReloadedItems.SWEET_BERRIES_ORGANIC_FOOD, new RecipeType(SlimefunReloadedItems.FOOD_FABRICATOR), new ItemStack[]{SlimefunReloadedItems.CAN, new ItemStack(Material.SWEET_BERRIES), null, null, null, null, null, null, null});
    //TECH Registery
    Category TECH = CATEGORY_MANAGER.getCategoryByKey("TECHNICAL_GADGETS");
    registerSimpleSlimefunReloadedItem("parachute", TECH, (SlimefunReloadedItemStack) SlimefunReloadedItems.PARACHUTE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{SlimefunReloadedItems.CLOTH, SlimefunReloadedItems.CLOTH, SlimefunReloadedItems.CLOTH, SlimefunReloadedItems.CHAIN, null, SlimefunReloadedItems.CHAIN, null, null, null});
    /*
		new HologramProjector(TECH, (SlimefunReloadedItemStack) SlimefunReloadedItems.HOLOGRAM_PROJECTOR, RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {null, SlimefunReloadedItems.POWER_CRYSTAL, null, SlimefunReloadedItems.ALUMINUM_BRASS_INGOT, SlimefunReloadedItems.ELECTRIC_MOTOR, SlimefunReloadedItems.ALUMINUM_BRASS_INGOT, null, SlimefunReloadedItems.ALUMINUM_BRASS_INGOT, null}, new CustomItem(SlimefunReloadedItems.HOLOGRAM_PROJECTOR, 3))
		.register(true);
    new SolarHelmet(TECH, (SlimefunReloadedItemStack) SlimefunReloadedItems.SOLAR_HELMET, RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {SlimefunReloadedItems.REINFORCED_ALLOY_INGOT, SlimefunReloadedItems.SOLAR_PANEL, SlimefunReloadedItems.REINFORCED_ALLOY_INGOT, SlimefunReloadedItems.REINFORCED_ALLOY_INGOT, null, SlimefunReloadedItems.REINFORCED_ALLOY_INGOT, SlimefunReloadedItems.MEDIUM_CAPACITOR, null, SlimefunReloadedItems.MEDIUM_CAPACITOR},
		new String[] {"charge-amount"}, new Double[] {0.1})
		.register(true);
    new SlimefunArmorPiece(TECH, (SlimefunReloadedItemStack) SlimefunReloadedItems.NIGHT_VISION_GOGGLES, RecipeType.ARMOR_FORGE,
		new ItemStack[] {new ItemStack(Material.COAL_BLOCK), new ItemStack(Material.COAL_BLOCK), new ItemStack(Material.COAL_BLOCK), new ItemStack(Material.LIME_STAINED_GLASS_PANE), new ItemStack(Material.COAL_BLOCK), new ItemStack(Material.LIME_STAINED_GLASS_PANE), new ItemStack(Material.COAL_BLOCK), null, new ItemStack(Material.COAL_BLOCK)},
		new PotionEffect[] {new PotionEffect(PotionEffectType.NIGHT_VISION, 600, 20)})
		.register(true);
     */
    //ELECTRICITY Registery
    Category ELECTRICITY = CATEGORY_MANAGER.getCategoryByKey("ELECTRICITY");
    /*
         new EnergyRegulator(ELECTRICITY, (SlimefunReloadedItemStack) SlimefunReloadedItems.ENERGY_REGULATOR, RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {SlimefunReloadedItems.SILVER_INGOT, SlimefunReloadedItems.DAMASCUS_STEEL_INGOT, SlimefunReloadedItems.SILVER_INGOT, SlimefunReloadedItems.DAMASCUS_STEEL_INGOT, SlimefunReloadedItems.ELECTRIC_MOTOR, SlimefunReloadedItems.DAMASCUS_STEEL_INGOT, SlimefunReloadedItems.SILVER_INGOT, SlimefunReloadedItems.DAMASCUS_STEEL_INGOT, SlimefunReloadedItems.SILVER_INGOT})
		.register(true);
    new SlimefunReloadedItems(ELECTRICITY, (SlimefunReloadedItemStack) SlimefunReloadedItems.SMALL_CAPACITOR, RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {SlimefunReloadedItems.DURALUMIN_INGOT, SlimefunReloadedItems.REDSTONE_ALLOY, SlimefunReloadedItems.DURALUMIN_INGOT, new ItemStack(Material.REDSTONE), SlimefunReloadedItems.SULFATE, new ItemStack(Material.REDSTONE), SlimefunReloadedItems.DURALUMIN_INGOT, SlimefunReloadedItems.REDSTONE_ALLOY, SlimefunReloadedItems.DURALUMIN_INGOT})
		.registerDistibutingCapacitor(true, 128);

		new SlimefunReloadedItems(ELECTRICITY, (SlimefunReloadedItemStack) SlimefunReloadedItems.MEDIUM_CAPACITOR, RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {SlimefunReloadedItems.BILLON_INGOT, SlimefunReloadedItems.REDSTONE_ALLOY, SlimefunReloadedItems.BILLON_INGOT, new ItemStack(Material.REDSTONE), SlimefunReloadedItems.SMALL_CAPACITOR, new ItemStack(Material.REDSTONE), SlimefunReloadedItems.BILLON_INGOT, SlimefunReloadedItems.REDSTONE_ALLOY, SlimefunReloadedItems.BILLON_INGOT})
		.registerDistibutingCapacitor(true, 512);

		new SlimefunReloadedItems(ELECTRICITY, (SlimefunReloadedItemStack) SlimefunReloadedItems.BIG_CAPACITOR, RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {SlimefunReloadedItems.STEEL_INGOT, SlimefunReloadedItems.REDSTONE_ALLOY, SlimefunReloadedItems.STEEL_INGOT, new ItemStack(Material.REDSTONE), SlimefunReloadedItems.MEDIUM_CAPACITOR, new ItemStack(Material.REDSTONE), SlimefunReloadedItems.STEEL_INGOT, SlimefunReloadedItems.REDSTONE_ALLOY, SlimefunReloadedItems.STEEL_INGOT})
		.registerDistibutingCapacitor(true, 1024);

		new SlimefunReloadedItems(ELECTRICITY, (SlimefunReloadedItemStack) SlimefunReloadedItems.LARGE_CAPACITOR, RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {SlimefunReloadedItems.REINFORCED_ALLOY_INGOT, SlimefunReloadedItems.REDSTONE_ALLOY, SlimefunReloadedItems.REINFORCED_ALLOY_INGOT, new ItemStack(Material.REDSTONE), SlimefunReloadedItems.BIG_CAPACITOR, new ItemStack(Material.REDSTONE), SlimefunReloadedItems.REINFORCED_ALLOY_INGOT, SlimefunReloadedItems.REDSTONE_ALLOY, SlimefunReloadedItems.REINFORCED_ALLOY_INGOT})
		.registerDistibutingCapacitor(true, 8192);

		new SlimefunReloadedItems(ELECTRICITY, (SlimefunReloadedItemStack) SlimefunReloadedItems.CARBONADO_EDGED_CAPACITOR, RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {SlimefunReloadedItems.CARBONADO, SlimefunReloadedItems.REDSTONE_ALLOY, SlimefunReloadedItems.CARBONADO, new ItemStack(Material.REDSTONE), SlimefunReloadedItems.LARGE_CAPACITOR, new ItemStack(Material.REDSTONE), SlimefunReloadedItems.CARBONADO, SlimefunReloadedItems.REDSTONE_ALLOY, SlimefunReloadedItems.CARBONADO})
		.registerDistibutingCapacitor(true, 65536);

		new SlimefunReloadedItems(ELECTRICITY, (SlimefunReloadedItemStack) SlimefunReloadedItems.SOLAR_GENERATOR, RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {SlimefunReloadedItems.SOLAR_PANEL, SlimefunReloadedItems.SOLAR_PANEL, SlimefunReloadedItems.SOLAR_PANEL, SlimefunReloadedItems.ALUMINUM_INGOT, SlimefunReloadedItems.ELECTRIC_MOTOR, SlimefunReloadedItems.ALUMINUM_INGOT, null, SlimefunReloadedItems.ALUMINUM_INGOT, null})
		.register(true, new EnergyTicker() {

			@Override
			public double generateEnergy(Location l, SlimefunReloadedItems item, Config data) {
				if (!l.getWorld().isChunkLoaded(l.getBlockX() >> 4, l.getBlockZ() >> 4) || l.getBlock().getLightFromSky() != 15) return 0D;
				if (l.getWorld().getTime() < 12300 || l.getWorld().getTime() > 23850) return 2D;
				return 0D;
			}

			@Override
			public boolean explode(Location l) {
				return false;
			}
		});

		new SlimefunReloadedItems(ELECTRICITY, (SlimefunReloadedItemStack) SlimefunReloadedItems.SOLAR_GENERATOR_2, RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {SlimefunReloadedItems.SOLAR_GENERATOR, SlimefunReloadedItems.ALUMINUM_INGOT, SlimefunReloadedItems.SOLAR_GENERATOR, SlimefunReloadedItems.ALUMINUM_INGOT, new ItemStack(Material.REDSTONE), SlimefunReloadedItems.ALUMINUM_INGOT, SlimefunReloadedItems.SOLAR_GENERATOR, SlimefunReloadedItems.ALUMINUM_INGOT, SlimefunReloadedItems.SOLAR_GENERATOR})
		.register(true, new EnergyTicker() {

			@Override
			public double generateEnergy(Location l, SlimefunReloadedItems item, Config data) {
				if (!l.getWorld().isChunkLoaded(l.getBlockX() >> 4, l.getBlockZ() >> 4) || l.getBlock().getLightFromSky() != 15) return 0D;
				if (l.getWorld().getTime() < 12300 || l.getWorld().getTime() > 23850) return 8;
				return 0D;
			}

			@Override
			public boolean explode(Location l) {
				return false;
			}
		});

		new SlimefunReloadedItems(ELECTRICITY, (SlimefunReloadedItemStack) SlimefunReloadedItems.SOLAR_GENERATOR_3, RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {SlimefunReloadedItems.SOLAR_GENERATOR_2, SlimefunReloadedItems.ALUMINUM_INGOT, SlimefunReloadedItems.SOLAR_GENERATOR_2, SlimefunReloadedItems.ALUMINUM_INGOT, SlimefunReloadedItems.CARBONADO, SlimefunReloadedItems.ALUMINUM_INGOT, SlimefunReloadedItems.SOLAR_GENERATOR_2, SlimefunReloadedItems.ALUMINUM_INGOT, SlimefunReloadedItems.SOLAR_GENERATOR_2})
		.register(true, new EnergyTicker() {

			@Override
			public double generateEnergy(Location l, SlimefunReloadedItems item, Config data) {
				if (!l.getWorld().isChunkLoaded(l.getBlockX() >> 4, l.getBlockZ() >> 4) || l.getBlock().getLightFromSky() != 15) return 0D;
				if (l.getWorld().getTime() < 12300 || l.getWorld().getTime() > 23850) return 32;
				return 0D;
			}

			@Override
			public boolean explode(Location l) {
				return false;
			}
		});

		new SlimefunReloadedItems(ELECTRICITY, (SlimefunReloadedItemStack) SlimefunReloadedItems.SOLAR_GENERATOR_4, RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {SlimefunReloadedItems.SOLAR_GENERATOR_3, SlimefunReloadedItems.BLISTERING_INGOT_3, SlimefunReloadedItems.SOLAR_GENERATOR_3, SlimefunReloadedItems.BLISTERING_INGOT_3, SlimefunReloadedItems.ELECTRO_MAGNET, SlimefunReloadedItems.BLISTERING_INGOT_3, SlimefunReloadedItems.SOLAR_GENERATOR_3, SlimefunReloadedItems.BLISTERING_INGOT_3, SlimefunReloadedItems.SOLAR_GENERATOR_3})
		.register(true, new EnergyTicker() {

			@Override
			public double generateEnergy(Location l, SlimefunReloadedItems item, Config data) {
				if (!l.getWorld().isChunkLoaded(l.getBlockX() >> 4, l.getBlockZ() >> 4) || l.getBlock().getLightFromSky() != 15) return 0D;
				if (l.getWorld().getTime() < 12300 || l.getWorld().getTime() > 23850) return 128;
				return 64D;
			}

			@Override
			public boolean explode(Location l) {
				return false;
			}
		});
		
		new ChargingBench(ELECTRICITY, (SlimefunReloadedItemStack) SlimefunReloadedItems.CHARGING_BENCH, RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {null, SlimefunReloadedItems.ELECTRO_MAGNET, null, SlimefunReloadedItems.BATTERY, new ItemStack(Material.CRAFTING_TABLE), SlimefunReloadedItems.BATTERY, null, SlimefunReloadedItems.SMALL_CAPACITOR, null})
		.registerChargeableBlock(true, 128);

		new ElectricFurnace(ELECTRICITY, (SlimefunReloadedItemStack) SlimefunReloadedItems.ELECTRIC_FURNACE, RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {null, new ItemStack(Material.FURNACE), null, SlimefunReloadedItems.GILDED_IRON, SlimefunReloadedItems.HEATING_COIL, SlimefunReloadedItems.GILDED_IRON, SlimefunReloadedItems.GILDED_IRON, SlimefunReloadedItems.ELECTRIC_MOTOR, SlimefunReloadedItems.GILDED_IRON}) {
			
			@Override
			public int getEnergyConsumption() {
				return 2;
			}

			@Override
			public int getSpeed() {
				return 1;
			}

		}.registerChargeableBlock(true, 64);

		new ElectricFurnace(ELECTRICITY, (SlimefunReloadedItemStack) SlimefunReloadedItems.ELECTRIC_FURNACE_2, RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {null, SlimefunReloadedItems.ELECTRIC_MOTOR, null, SlimefunReloadedItems.GILDED_IRON, SlimefunReloadedItems.ELECTRIC_FURNACE, SlimefunReloadedItems.GILDED_IRON, SlimefunReloadedItems.GILDED_IRON, SlimefunReloadedItems.HEATING_COIL, SlimefunReloadedItems.GILDED_IRON}) {

			@Override
			public int getEnergyConsumption() {
				return 3;
			}

			@Override
			public int getSpeed() {
				return 2;
			}

		}.registerChargeableBlock(true, 128);

		new ElectricFurnace(ELECTRICITY, (SlimefunReloadedItemStack) SlimefunReloadedItems.ELECTRIC_FURNACE_3, RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {null, SlimefunReloadedItems.ELECTRIC_MOTOR, null, SlimefunReloadedItems.STEEL_INGOT, SlimefunReloadedItems.ELECTRIC_FURNACE_2, SlimefunReloadedItems.STEEL_INGOT, SlimefunReloadedItems.GILDED_IRON, SlimefunReloadedItems.HEATING_COIL, SlimefunReloadedItems.GILDED_IRON}) {

			@Override
			public int getEnergyConsumption() {
				return 5;
			}

			@Override
			public int getSpeed() {
				return 4;
			}

		}.registerChargeableBlock(true, 128);

		new ElectricGoldPan(ELECTRICITY, (SlimefunReloadedItemStack) SlimefunReloadedItems.ELECTRIC_GOLD_PAN, RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {null, SlimefunReloadedItems.GOLD_PAN, null, new ItemStack(Material.FLINT), SlimefunReloadedItems.ELECTRIC_MOTOR, new ItemStack(Material.FLINT), SlimefunReloadedItems.ALUMINUM_INGOT, SlimefunReloadedItems.ALUMINUM_INGOT, SlimefunReloadedItems.ALUMINUM_INGOT}) {

			@Override
			public int getEnergyConsumption() {
				return 1;
			}

			@Override
			public int getSpeed() {
				return 1;
			}
			
		}.registerChargeableBlock(true, 128);

		new ElectricGoldPan(ELECTRICITY, (SlimefunReloadedItemStack) SlimefunReloadedItems.ELECTRIC_GOLD_PAN_2, RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {null, SlimefunReloadedItems.GOLD_PAN, null, new ItemStack(Material.IRON_INGOT), SlimefunReloadedItems.ELECTRIC_GOLD_PAN, new ItemStack(Material.IRON_INGOT), SlimefunReloadedItems.DURALUMIN_INGOT, SlimefunReloadedItems.DURALUMIN_INGOT, SlimefunReloadedItems.DURALUMIN_INGOT}) {

			@Override
			public int getEnergyConsumption() {
				return 2;
			}

			@Override
			public int getSpeed() {
				return 3;
			}
			
		}.registerChargeableBlock(true, 128);

		new ElectricGoldPan(ELECTRICITY, (SlimefunReloadedItemStack) SlimefunReloadedItems.ELECTRIC_GOLD_PAN_3, RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {null, SlimefunReloadedItems.GOLD_PAN, null, SlimefunReloadedItems.ELECTRIC_MOTOR, SlimefunReloadedItems.ELECTRIC_GOLD_PAN_2, SlimefunReloadedItems.ELECTRIC_MOTOR, SlimefunReloadedItems.COBALT_INGOT, SlimefunReloadedItems.BLISTERING_INGOT_3, SlimefunReloadedItems.COBALT_INGOT}) {

			@Override
			public int getEnergyConsumption() {
				return 7;
			}

			@Override
			public int getSpeed() {
				return 10;
			}
			
		}.registerChargeableBlock(true, 512);

		new ElectricDustWasher(ELECTRICITY, (SlimefunReloadedItemStack) SlimefunReloadedItems.ELECTRIC_DUST_WASHER, RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {null, new ItemStack(Material.WATER_BUCKET), null, SlimefunReloadedItems.ELECTRO_MAGNET, SlimefunReloadedItems.ELECTRIC_GOLD_PAN, SlimefunReloadedItems.ELECTRO_MAGNET, SlimefunReloadedItems.COPPER_INGOT, SlimefunReloadedItems.COPPER_INGOT, SlimefunReloadedItems.COPPER_INGOT}) {

			@Override
			public int getEnergyConsumption() {
				return 3;
			}

			@Override
			public int getSpeed() {
				return 1;
			}
			
		}.registerChargeableBlock(true, 128);

		new ElectricDustWasher(ELECTRICITY, (SlimefunReloadedItemStack) SlimefunReloadedItems.ELECTRIC_DUST_WASHER_2, RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {null, new ItemStack(Material.WATER_BUCKET), null, SlimefunReloadedItems.ELECTRO_MAGNET, SlimefunReloadedItems.ELECTRIC_DUST_WASHER, SlimefunReloadedItems.ELECTRO_MAGNET, SlimefunReloadedItems.DAMASCUS_STEEL_INGOT, SlimefunReloadedItems.DAMASCUS_STEEL_INGOT, SlimefunReloadedItems.DAMASCUS_STEEL_INGOT}) {

			@Override
			public int getEnergyConsumption() {
				return 5;
			}

			@Override
			public int getSpeed() {
				return 2;
			}
			
		}.registerChargeableBlock(true, 128);

		new ElectricDustWasher(ELECTRICITY, (SlimefunReloadedItemStack) SlimefunReloadedItems.ELECTRIC_DUST_WASHER_3, RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {null, new ItemStack(Material.WATER_BUCKET), null, SlimefunReloadedItems.ELECTRO_MAGNET, SlimefunReloadedItems.ELECTRIC_DUST_WASHER_2, SlimefunReloadedItems.ELECTRO_MAGNET, SlimefunReloadedItems.CORINTHIAN_BRONZE_INGOT, SlimefunReloadedItems.BLISTERING_INGOT_3, SlimefunReloadedItems.CORINTHIAN_BRONZE_INGOT}) {

			@Override
			public int getEnergyConsumption() {
				return 15;
			}

			@Override
			public int getSpeed() {
				return 10;
			}
			
		}.registerChargeableBlock(true, 512);

		new ElectricIngotFactory(ELECTRICITY, (SlimefunReloadedItemStack) SlimefunReloadedItems.ELECTRIC_INGOT_FACTORY, RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {null, new ItemStack(Material.FLINT_AND_STEEL), null, SlimefunReloadedItems.HEATING_COIL, SlimefunReloadedItems.ELECTRIC_DUST_WASHER, SlimefunReloadedItems.HEATING_COIL, SlimefunReloadedItems.DAMASCUS_STEEL_INGOT, SlimefunReloadedItems.ELECTRIC_MOTOR, SlimefunReloadedItems.DAMASCUS_STEEL_INGOT}) {
			
			@Override
			public int getEnergyConsumption() {
				return 4;
			}

			@Override
			public int getSpeed() {
				return 1;
			}

		}.registerChargeableBlock(true, 256);

		new ElectricIngotFactory(ELECTRICITY, (SlimefunReloadedItemStack) SlimefunReloadedItems.ELECTRIC_INGOT_FACTORY_2, RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {SlimefunReloadedItems.GILDED_IRON, new ItemStack(Material.FLINT_AND_STEEL), SlimefunReloadedItems.GILDED_IRON, SlimefunReloadedItems.HEATING_COIL, SlimefunReloadedItems.ELECTRIC_INGOT_FACTORY, SlimefunReloadedItems.HEATING_COIL, SlimefunReloadedItems.BRASS_INGOT, SlimefunReloadedItems.ELECTRIC_MOTOR, SlimefunReloadedItems.BRASS_INGOT}) {

			@Override
			public int getEnergyConsumption() {
				return 7;
			}

			@Override
			public int getSpeed() {
				return 2;
			}

		}.registerChargeableBlock(true, 256);

		new ElectricIngotFactory(ELECTRICITY, (SlimefunReloadedItemStack) SlimefunReloadedItems.ELECTRIC_INGOT_FACTORY_3, RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {SlimefunReloadedItems.GILDED_IRON, new ItemStack(Material.FLINT_AND_STEEL), SlimefunReloadedItems.GILDED_IRON, SlimefunReloadedItems.HEATING_COIL, SlimefunReloadedItems.ELECTRIC_INGOT_FACTORY_2, SlimefunReloadedItems.HEATING_COIL, SlimefunReloadedItems.BRASS_INGOT, SlimefunReloadedItems.BLISTERING_INGOT_3, SlimefunReloadedItems.BRASS_INGOT}) {

			@Override
			public int getEnergyConsumption() {
				return 20;
			}

			@Override
			public int getSpeed() {
				return 8;
			}

		}.registerChargeableBlock(true, 512);

		new ElectrifiedCrucible(ELECTRICITY, (SlimefunReloadedItemStack) SlimefunReloadedItems.ELECTRIFIED_CRUCIBLE, RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {SlimefunReloadedItems.LEAD_INGOT, SlimefunReloadedItems.CRUCIBLE, SlimefunReloadedItems.LEAD_INGOT, SlimefunReloadedItems.DAMASCUS_STEEL_INGOT, SlimefunReloadedItems.HEATING_COIL, SlimefunReloadedItems.DAMASCUS_STEEL_INGOT, SlimefunReloadedItems.LEAD_INGOT, SlimefunReloadedItems.LARGE_CAPACITOR, SlimefunReloadedItems.LEAD_INGOT}) {

			@Override
			public int getEnergyConsumption() {
				return 24;
			}

			@Override
			public int getSpeed() {
				return 1;
			}

		}.registerChargeableBlock(true, 1024);

		new ElectrifiedCrucible(ELECTRICITY, (SlimefunReloadedItemStack) SlimefunReloadedItems.ELECTRIFIED_CRUCIBLE_2, RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {SlimefunReloadedItems.CORINTHIAN_BRONZE_INGOT, SlimefunReloadedItems.ELECTRIFIED_CRUCIBLE, SlimefunReloadedItems.CORINTHIAN_BRONZE_INGOT, SlimefunReloadedItems.DAMASCUS_STEEL_INGOT, SlimefunReloadedItems.ELECTRIC_MOTOR, SlimefunReloadedItems.DAMASCUS_STEEL_INGOT, SlimefunReloadedItems.LEAD_INGOT, SlimefunReloadedItems.HEATING_COIL, SlimefunReloadedItems.LEAD_INGOT}) {

			@Override
			public int getEnergyConsumption() {
				return 40;
			}

			@Override
			public int getSpeed() {
				return 2;
			}

		}.registerChargeableBlock(true, 1024);

		new ElectrifiedCrucible(ELECTRICITY, (SlimefunReloadedItemStack) SlimefunReloadedItems.ELECTRIFIED_CRUCIBLE_3, RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {SlimefunReloadedItems.CORINTHIAN_BRONZE_INGOT, SlimefunReloadedItems.ELECTRIFIED_CRUCIBLE_2, SlimefunReloadedItems.CORINTHIAN_BRONZE_INGOT, SlimefunReloadedItems.STEEL_PLATE, SlimefunReloadedItems.POWER_CRYSTAL, SlimefunReloadedItems.STEEL_PLATE, SlimefunReloadedItems.LEAD_INGOT, SlimefunReloadedItems.LEAD_INGOT, SlimefunReloadedItems.LEAD_INGOT}) {

			@Override
			public int getEnergyConsumption() {
				return 60;
			}

			@Override
			public int getSpeed() {
				return 4;
			}

		}.registerChargeableBlock(true, 1024);

		new ElectricOreGrinder(ELECTRICITY, (SlimefunReloadedItemStack) SlimefunReloadedItems.ELECTRIC_ORE_GRINDER, RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {null, new ItemStack(Material.DIAMOND_PICKAXE), null, SlimefunReloadedItems.GILDED_IRON, SlimefunReloadedItems.HEATING_COIL, SlimefunReloadedItems.GILDED_IRON, SlimefunReloadedItems.GILDED_IRON, SlimefunReloadedItems.ELECTRIC_MOTOR, SlimefunReloadedItems.GILDED_IRON}) {
			
			@Override
			public int getEnergyConsumption() {
				return 6;
			}

			@Override
			public int getSpeed() {
				return 1;
			}

		}.registerChargeableBlock(true, 128);

		new ElectricOreGrinder(ELECTRICITY, (SlimefunReloadedItemStack) SlimefunReloadedItems.ELECTRIC_ORE_GRINDER_2, RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {null, new ItemStack(Material.DIAMOND_PICKAXE), null, SlimefunReloadedItems.HEATING_COIL, SlimefunReloadedItems.ELECTRIC_ORE_GRINDER, SlimefunReloadedItems.HEATING_COIL, SlimefunReloadedItems.GILDED_IRON, SlimefunReloadedItems.BLISTERING_INGOT_3, SlimefunReloadedItems.GILDED_IRON}) {

			@Override
			public int getEnergyConsumption() {
				return 15;
			}

			@Override
			public int getSpeed() {
				return 4;
			}

		}.registerChargeableBlock(true, 512);

		new HeatedPressureChamber(ELECTRICITY, (SlimefunReloadedItemStack) SlimefunReloadedItems.HEATED_PRESSURE_CHAMBER, RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {SlimefunReloadedItems.LEAD_INGOT, SlimefunReloadedItems.ELECTRIC_MOTOR, SlimefunReloadedItems.LEAD_INGOT, SlimefunReloadedItems.LEAD_INGOT, new ItemStack(Material.GLASS), SlimefunReloadedItems.LEAD_INGOT, SlimefunReloadedItems.LEAD_INGOT, SlimefunReloadedItems.HEATING_COIL, SlimefunReloadedItems.LEAD_INGOT}) {
			
			@Override
			public int getEnergyConsumption() {
				return 5;
			}

			@Override
			public int getSpeed() {
				return 1;
			}

		}.registerChargeableBlock(true, 128);

		new HeatedPressureChamber(ELECTRICITY, (SlimefunReloadedItemStack) SlimefunReloadedItems.HEATED_PRESSURE_CHAMBER_2, RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {SlimefunReloadedItems.LEAD_INGOT, SlimefunReloadedItems.ELECTRIC_MOTOR, SlimefunReloadedItems.LEAD_INGOT, SlimefunReloadedItems.LEAD_INGOT, SlimefunReloadedItems.HEATED_PRESSURE_CHAMBER, SlimefunReloadedItems.LEAD_INGOT, SlimefunReloadedItems.REINFORCED_ALLOY_INGOT, SlimefunReloadedItems.HEATING_COIL, SlimefunReloadedItems.REINFORCED_ALLOY_INGOT}) {

			@Override
			public int getEnergyConsumption() {
				return 22;
			}

			@Override
			public int getSpeed() {
				return 5;
			}

		}.registerChargeableBlock(true, 256);

		new ElectricIngotPulverizer(ELECTRICITY, (SlimefunReloadedItemStack) SlimefunReloadedItems.ELECTRIC_INGOT_PULVERIZER, RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {null, SlimefunReloadedItems.ELECTRIC_ORE_GRINDER, null, SlimefunReloadedItems.LEAD_INGOT, SlimefunReloadedItems.MEDIUM_CAPACITOR, SlimefunReloadedItems.LEAD_INGOT, SlimefunReloadedItems.LEAD_INGOT, SlimefunReloadedItems.HEATING_COIL, SlimefunReloadedItems.LEAD_INGOT})
		.registerChargeableBlock(true, 512);

		new CoalGenerator(ELECTRICITY, (SlimefunReloadedItemStack) SlimefunReloadedItems.COAL_GENERATOR, RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {SlimefunReloadedItems.HEATING_COIL, new ItemStack(Material.FURNACE), SlimefunReloadedItems.HEATING_COIL, SlimefunReloadedItems.NICKEL_INGOT, SlimefunReloadedItems.ELECTRIC_MOTOR, SlimefunReloadedItems.NICKEL_INGOT, null, SlimefunReloadedItems.NICKEL_INGOT, null}) {
			
			@Override
			public int getEnergyProduction() {
				return 8;
			}

		}.registerUnrechargeableBlock(true, 64);

		new CoalGenerator(ELECTRICITY, (SlimefunReloadedItemStack) SlimefunReloadedItems.COAL_GENERATOR_2, RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {new ItemStack(Material.MAGMA_BLOCK), SlimefunReloadedItems.HEATING_COIL, new ItemStack(Material.MAGMA_BLOCK), SlimefunReloadedItems.HARDENED_METAL_INGOT, SlimefunReloadedItems.COAL_GENERATOR, SlimefunReloadedItems.HARDENED_METAL_INGOT, null, SlimefunReloadedItems.ELECTRIC_MOTOR, null}) {
			
			@Override
			public int getEnergyProduction() {
				return 15;
			}

		}.registerUnrechargeableBlock(true, 256);

		new BioGenerator(ELECTRICITY, (SlimefunReloadedItemStack) SlimefunReloadedItems.BIO_REACTOR, RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {SlimefunReloadedItems.HEATING_COIL, SlimefunReloadedItems.COMPOSTER, SlimefunReloadedItems.HEATING_COIL, SlimefunReloadedItems.ALUMINUM_BRASS_INGOT, SlimefunReloadedItems.ELECTRIC_MOTOR, SlimefunReloadedItems.ALUMINUM_BRASS_INGOT, null, SlimefunReloadedItems.ALUMINUM_BRASS_INGOT, null}) {

			@Override
			public int getEnergyProduction() {
				return 4;
			}

		}.registerUnrechargeableBlock(true, 128);

		new AutoDrier(ELECTRICITY, (SlimefunReloadedItemStack) SlimefunReloadedItems.AUTO_DRIER, RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {null, null, null, SlimefunReloadedItems.HEATING_COIL, new ItemStack(Material.SMOKER), SlimefunReloadedItems.HEATING_COIL, null, new ItemStack(Material.CAMPFIRE), null})
		.registerChargeableBlock(true, 128);

		new ElectricPress(ELECTRICITY, (SlimefunReloadedItemStack) SlimefunReloadedItems.ELECTRIC_PRESS, RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {new ItemStack(Material.PISTON), SlimefunReloadedItems.ELECTRIC_MOTOR, new ItemStack(Material.PISTON), null, SlimefunReloadedItems.MEDIUM_CAPACITOR, null, SlimefunReloadedItems.DAMASCUS_STEEL_INGOT, SlimefunReloadedItems.DAMASCUS_STEEL_INGOT, SlimefunReloadedItems.DAMASCUS_STEEL_INGOT}) {

			@Override
			public int getEnergyConsumption() {
				return 8;
			}

			@Override
			public int getSpeed() {
				return 1;
			}

		}.registerChargeableBlock(true, 256);

		new ElectricPress(ELECTRICITY, (SlimefunReloadedItemStack) SlimefunReloadedItems.ELECTRIC_PRESS_2, RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {new ItemStack(Material.STICKY_PISTON), SlimefunReloadedItems.ELECTRIC_PRESS, new ItemStack(Material.STICKY_PISTON), SlimefunReloadedItems.DAMASCUS_STEEL_INGOT, SlimefunReloadedItems.BIG_CAPACITOR, SlimefunReloadedItems.DAMASCUS_STEEL_INGOT, SlimefunReloadedItems.DAMASCUS_STEEL_INGOT, SlimefunReloadedItems.DAMASCUS_STEEL_INGOT, SlimefunReloadedItems.DAMASCUS_STEEL_INGOT}) {

			@Override
			public int getEnergyConsumption() {
				return 20;
			}

			@Override
			public int getSpeed() {
				return 3;
			}

		}.registerChargeableBlock(true, 1024);

		new AutoEnchanter(ELECTRICITY, (SlimefunReloadedItemStack) SlimefunReloadedItems.AUTO_ENCHANTER, RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {null, new ItemStack(Material.ENCHANTING_TABLE), null, SlimefunReloadedItems.CARBONADO, SlimefunReloadedItems.ELECTRIC_MOTOR, SlimefunReloadedItems.CARBONADO, SlimefunReloadedItems.WITHER_PROOF_OBSIDIAN, SlimefunReloadedItems.WITHER_PROOF_OBSIDIAN, SlimefunReloadedItems.WITHER_PROOF_OBSIDIAN})
		.registerChargeableBlock(true, 128);

		new AutoDisenchanter(ELECTRICITY, (SlimefunReloadedItemStack) SlimefunReloadedItems.AUTO_DISENCHANTER, RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {new ItemStack(Material.REDSTONE), new ItemStack(Material.ANVIL), new ItemStack(Material.REDSTONE), SlimefunReloadedItems.CARBONADO, SlimefunReloadedItems.AUTO_ENCHANTER, SlimefunReloadedItems.CARBONADO, SlimefunReloadedItems.WITHER_PROOF_OBSIDIAN, SlimefunReloadedItems.WITHER_PROOF_OBSIDIAN, SlimefunReloadedItems.WITHER_PROOF_OBSIDIAN})
		.registerChargeableBlock(true, 128);

		new AutoAnvil(ELECTRICITY, (SlimefunReloadedItemStack) SlimefunReloadedItems.AUTO_ANVIL, RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {null, new ItemStack(Material.ANVIL), null, SlimefunReloadedItems.REINFORCED_ALLOY_INGOT, SlimefunReloadedItems.ELECTRIC_MOTOR, SlimefunReloadedItems.REINFORCED_ALLOY_INGOT, new ItemStack(Material.IRON_BLOCK), new ItemStack(Material.IRON_BLOCK), new ItemStack(Material.IRON_BLOCK)}) {

			@Override
			public int getRepairFactor() {
				return 10;
			}

			@Override
			public int getEnergyConsumption() {
				return 12;
			}

		}.registerChargeableBlock(true, 128);

		new AutoAnvil(ELECTRICITY, (SlimefunReloadedItemStack) SlimefunReloadedItems.AUTO_ANVIL_2, RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {null, SlimefunReloadedItems.AUTO_ANVIL, null, SlimefunReloadedItems.STEEL_PLATE, SlimefunReloadedItems.HEATING_COIL, SlimefunReloadedItems.STEEL_PLATE, new ItemStack(Material.IRON_BLOCK), new ItemStack(Material.IRON_BLOCK), new ItemStack(Material.IRON_BLOCK)}) {

			@Override
			public int getRepairFactor() {
				return 4;
			}

			@Override
			public int getEnergyConsumption() {
				return 16;
			}

		}.registerChargeableBlock(true, 256);

		new Multimeter(ELECTRICITY, (SlimefunReloadedItemStack) SlimefunReloadedItems.MULTIMETER, RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {SlimefunReloadedItems.COPPER_INGOT, null, SlimefunReloadedItems.COPPER_INGOT, null, SlimefunReloadedItems.REDSTONE_ALLOY, null, null, SlimefunReloadedItems.GOLD_6K, null})
		.register(true);
    new ProgrammableAndroid(ELECTRICITY, SlimefunReloadedItems.PROGRAMMABLE_ANDROID, "PROGRAMMABLE_ANDROID", RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {SlimefunReloadedItems.PLASTIC_SHEET, SlimefunReloadedItems.ANDROID_MEMORY_CORE, SlimefunReloadedItems.PLASTIC_SHEET, SlimefunReloadedItems.COAL_GENERATOR, SlimefunReloadedItems.ELECTRIC_MOTOR, new ItemStack(Material.CHEST), SlimefunReloadedItems.PLASTIC_SHEET, SlimefunReloadedItems.PLASTIC_SHEET, SlimefunReloadedItems.PLASTIC_SHEET}) {

			@Override
			public AndroidType getAndroidType() {
				return AndroidType.NONE;
			}

			@Override
			public float getFuelEfficiency() {
				return 1;
			}

			@Override
			public int getTier() {
				return 1;
			}

		}
		.register(true);

		new ProgrammableAndroid(ELECTRICITY, SlimefunReloadedItems.PROGRAMMABLE_ANDROID_MINER, "PROGRAMMABLE_ANDROID_MINER", RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {null, null, null, new ItemStack(Material.DIAMOND_PICKAXE), SlimefunReloadedItems.PROGRAMMABLE_ANDROID, new ItemStack(Material.DIAMOND_PICKAXE), null, SlimefunReloadedItems.ELECTRIC_MOTOR, null}) {

			@Override
			public AndroidType getAndroidType() {
				return AndroidType.MINER;
			}

			@Override
			public float getFuelEfficiency() {
				return 1;
			}

			@Override
			public int getTier() {
				return 1;
			}

		}
		.register(true);

		new ProgrammableAndroid(ELECTRICITY, SlimefunReloadedItems.PROGRAMMABLE_ANDROID_FARMER, "PROGRAMMABLE_ANDROID_FARMER", RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {null, null, null, new ItemStack(Material.DIAMOND_HOE), SlimefunReloadedItems.PROGRAMMABLE_ANDROID, new ItemStack(Material.DIAMOND_HOE), null, SlimefunReloadedItems.ELECTRIC_MOTOR, null}) {

			@Override
			public AndroidType getAndroidType() {
				return AndroidType.FARMER;
			}

			@Override
			public float getFuelEfficiency() {
				return 1;
			}

			@Override
			public int getTier() {
				return 1;
			}

		}
		.register(true);

		new ProgrammableAndroid(ELECTRICITY, SlimefunReloadedItems.PROGRAMMABLE_ANDROID_WOODCUTTER, "PROGRAMMABLE_ANDROID_WOODCUTTER", RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {null, null, null, new ItemStack(Material.DIAMOND_AXE), SlimefunReloadedItems.PROGRAMMABLE_ANDROID, new ItemStack(Material.DIAMOND_AXE), null, SlimefunReloadedItems.ELECTRIC_MOTOR, null}) {

			@Override
			public AndroidType getAndroidType() {
				return AndroidType.WOODCUTTER;
			}

			@Override
			public float getFuelEfficiency() {
				return 1;
			}

			@Override
			public int getTier() {
				return 1;
			}

		}
		.register(true);

		new ProgrammableAndroid(ELECTRICITY, SlimefunReloadedItems.PROGRAMMABLE_ANDROID_FISHERMAN, "PROGRAMMABLE_ANDROID_FISHERMAN", RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {null, null, null, new ItemStack(Material.FISHING_ROD), SlimefunReloadedItems.PROGRAMMABLE_ANDROID, new ItemStack(Material.FISHING_ROD), null, SlimefunReloadedItems.ELECTRIC_MOTOR, null}) {

			@Override
			public AndroidType getAndroidType() {
				return AndroidType.FISHERMAN;
			}

			@Override
			public float getFuelEfficiency() {
				return 1;
			}

			@Override
			public int getTier() {
				return 1;
			}

		}
		.register(true);

		new ProgrammableAndroid(ELECTRICITY, SlimefunReloadedItems.PROGRAMMABLE_ANDROID_BUTCHER, "PROGRAMMABLE_ANDROID_BUTCHER", RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {null, SlimefunReloadedItems.GPS_TRANSMITTER, null, new ItemStack(Material.DIAMOND_SWORD), SlimefunReloadedItems.PROGRAMMABLE_ANDROID, new ItemStack(Material.DIAMOND_SWORD), null, SlimefunReloadedItems.ELECTRIC_MOTOR, null}) {

			@Override
			public AndroidType getAndroidType() {
				return AndroidType.FIGHTER;
			}

			@Override
			public float getFuelEfficiency() {
				return 1;
			}

			@Override
			public int getTier() {
				return 1;
			}

		}
		.register(true);

		new SlimefunReloadedItems(ELECTRICITY, SlimefunReloadedItems.ANDROID_INTERFACE_ITEMS, "ANDROID_INTERFACE_ITEMS", RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {SlimefunReloadedItems.PLASTIC_SHEET, SlimefunReloadedItems.PLASTIC_SHEET, SlimefunReloadedItems.PLASTIC_SHEET, SlimefunReloadedItems.PLASTIC_SHEET, SlimefunReloadedItems.BASIC_CIRCUIT_BOARD, new ItemStack(Material.BLUE_STAINED_GLASS), SlimefunReloadedItems.PLASTIC_SHEET, SlimefunReloadedItems.PLASTIC_SHEET, SlimefunReloadedItems.PLASTIC_SHEET})
		.register(true);

		new SlimefunReloadedItems(ELECTRICITY, SlimefunReloadedItems.ANDROID_INTERFACE_FUEL, "ANDROID_INTERFACE_FUEL", RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {SlimefunReloadedItems.PLASTIC_SHEET, SlimefunReloadedItems.PLASTIC_SHEET, SlimefunReloadedItems.PLASTIC_SHEET, new ItemStack(Material.RED_STAINED_GLASS), SlimefunReloadedItems.BASIC_CIRCUIT_BOARD, SlimefunReloadedItems.PLASTIC_SHEET, SlimefunReloadedItems.PLASTIC_SHEET, SlimefunReloadedItems.PLASTIC_SHEET, SlimefunReloadedItems.PLASTIC_SHEET})
		.register(true);


		new ProgrammableAndroid(ELECTRICITY, SlimefunReloadedItems.PROGRAMMABLE_ANDROID_2, "PROGRAMMABLE_ANDROID_2", RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {SlimefunReloadedItems.PLASTIC_SHEET, SlimefunReloadedItems.ANDROID_MEMORY_CORE, SlimefunReloadedItems.PLASTIC_SHEET, SlimefunReloadedItems.COMBUSTION_REACTOR, SlimefunReloadedItems.PROGRAMMABLE_ANDROID, new ItemStack(Material.CHEST), SlimefunReloadedItems.PLASTIC_SHEET, SlimefunReloadedItems.POWER_CRYSTAL, SlimefunReloadedItems.PLASTIC_SHEET}) {

			@Override
			public AndroidType getAndroidType() {
				return AndroidType.NONE;
			}

			@Override
			public float getFuelEfficiency() {
				return 1.5F;
			}

			@Override
			public int getTier() {
				return 2;
			}

		}
		.register(true);

		new ProgrammableAndroid(ELECTRICITY, SlimefunReloadedItems.PROGRAMMABLE_ANDROID_2_FISHERMAN, "PROGRAMMABLE_ANDROID_2_FISHERMAN", RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {null, null, null, new ItemStack(Material.FISHING_ROD), SlimefunReloadedItems.PROGRAMMABLE_ANDROID_2, new ItemStack(Material.FISHING_ROD), null, SlimefunReloadedItems.ELECTRIC_MOTOR, null}) {

			@Override
			public AndroidType getAndroidType() {
				return AndroidType.FISHERMAN;
			}

			@Override
			public float getFuelEfficiency() {
				return 1.5F;
			}

			@Override
			public int getTier() {
				return 2;
			}

		}
		.register(true);

		new ProgrammableAndroid(ELECTRICITY, SlimefunReloadedItems.PROGRAMMABLE_ANDROID_2_BUTCHER, "PROGRAMMABLE_ANDROID_2_BUTCHER", RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {null, SlimefunReloadedItems.GPS_TRANSMITTER, null, new ItemStack(Material.DIAMOND_SWORD), SlimefunReloadedItems.PROGRAMMABLE_ANDROID_2, new ItemStack(Material.DIAMOND_SWORD), null, SlimefunReloadedItems.ELECTRIC_MOTOR, null}) {

			@Override
			public AndroidType getAndroidType() {
				return AndroidType.FIGHTER;
			}

			@Override
			public float getFuelEfficiency() {
				return 1.5F;
			}

			@Override
			public int getTier() {
				return 2;
			}

		}
		.register(true);

		new ProgrammableAndroid(ELECTRICITY, SlimefunReloadedItems.PROGRAMMABLE_ANDROID_2_FARMER, "PROGRAMMABLE_ANDROID_2_FARMER", RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {null, SlimefunReloadedItems.GPS_TRANSMITTER, null, new ItemStack(Material.DIAMOND_HOE), SlimefunReloadedItems.PROGRAMMABLE_ANDROID_2, new ItemStack(Material.DIAMOND_HOE), null, SlimefunReloadedItems.ELECTRIC_MOTOR, null}) {

			@Override
			public AndroidType getAndroidType() {
				return AndroidType.ADVANCED_FARMER;
			}

			@Override
			public float getFuelEfficiency() {
				return 1.5F;
			}

			@Override
			public int getTier() {
				return 2;
			}

		}
		.register(true);


		new ProgrammableAndroid(ELECTRICITY, SlimefunReloadedItems.PROGRAMMABLE_ANDROID_3, "PROGRAMMABLE_ANDROID_3", RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {SlimefunReloadedItems.PLASTIC_SHEET, SlimefunReloadedItems.ANDROID_MEMORY_CORE, SlimefunReloadedItems.PLASTIC_SHEET, SlimefunReloadedItems.NUCLEAR_REACTOR, SlimefunReloadedItems.PROGRAMMABLE_ANDROID_2, new ItemStack(Material.CHEST), SlimefunReloadedItems.BLISTERING_INGOT_3, SlimefunReloadedItems.POWER_CRYSTAL, SlimefunReloadedItems.BLISTERING_INGOT_3}) {

			@Override
			public AndroidType getAndroidType() {
				return AndroidType.NONE;
			}

			@Override
			public float getFuelEfficiency() {
				return 1F;
			}

			@Override
			public int getTier() {
				return 3;
			}

		}
		.register(true);

		new ProgrammableAndroid(ELECTRICITY, SlimefunReloadedItems.PROGRAMMABLE_ANDROID_3_FISHERMAN, "PROGRAMMABLE_ANDROID_3_FISHERMAN", RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {null, null, null, new ItemStack(Material.FISHING_ROD), SlimefunReloadedItems.PROGRAMMABLE_ANDROID_3, new ItemStack(Material.FISHING_ROD), null, SlimefunReloadedItems.ELECTRIC_MOTOR, null}) {

			@Override
			public AndroidType getAndroidType() {
				return AndroidType.FISHERMAN;
			}

			@Override
			public float getFuelEfficiency() {
				return 1F;
			}

			@Override
			public int getTier() {
				return 3;
			}

		}
		.register(true);

		new ProgrammableAndroid(ELECTRICITY, SlimefunReloadedItems.PROGRAMMABLE_ANDROID_3_BUTCHER, "PROGRAMMABLE_ANDROID_3_BUTCHER", RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {null, SlimefunReloadedItems.GPS_TRANSMITTER_3, null, new ItemStack(Material.DIAMOND_SWORD), SlimefunReloadedItems.PROGRAMMABLE_ANDROID_3, new ItemStack(Material.DIAMOND_SWORD), null, SlimefunReloadedItems.ELECTRIC_MOTOR, null}) {

			@Override
			public AndroidType getAndroidType() {
				return AndroidType.FIGHTER;
			}

			@Override
			public float getFuelEfficiency() {
				return 1F;
			}

			@Override
			public int getTier() {
				return 3;
			}

		}
		.register(true);
    new SlimefunReloadedItems(ELECTRICITY, SlimefunReloadedItems.ANDROID_INTERFACE_ITEMS, "ANDROID_INTERFACE_ITEMS", RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {SlimefunReloadedItems.PLASTIC_SHEET, SlimefunReloadedItems.PLASTIC_SHEET, SlimefunReloadedItems.PLASTIC_SHEET, SlimefunReloadedItems.PLASTIC_SHEET, SlimefunReloadedItems.BASIC_CIRCUIT_BOARD, new ItemStack(Material.BLUE_STAINED_GLASS), SlimefunReloadedItems.PLASTIC_SHEET, SlimefunReloadedItems.PLASTIC_SHEET, SlimefunReloadedItems.PLASTIC_SHEET})
		.register(true);

		new SlimefunReloadedItems(ELECTRICITY, SlimefunReloadedItems.ANDROID_INTERFACE_FUEL, "ANDROID_INTERFACE_FUEL", RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {SlimefunReloadedItems.PLASTIC_SHEET, SlimefunReloadedItems.PLASTIC_SHEET, SlimefunReloadedItems.PLASTIC_SHEET, new ItemStack(Material.RED_STAINED_GLASS), SlimefunReloadedItems.BASIC_CIRCUIT_BOARD, SlimefunReloadedItems.PLASTIC_SHEET, SlimefunReloadedItems.PLASTIC_SHEET, SlimefunReloadedItems.PLASTIC_SHEET, SlimefunReloadedItems.PLASTIC_SHEET})
		.register(true);


		new ProgrammableAndroid(ELECTRICITY, SlimefunReloadedItems.PROGRAMMABLE_ANDROID_2, "PROGRAMMABLE_ANDROID_2", RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {SlimefunReloadedItems.PLASTIC_SHEET, SlimefunReloadedItems.ANDROID_MEMORY_CORE, SlimefunReloadedItems.PLASTIC_SHEET, SlimefunReloadedItems.COMBUSTION_REACTOR, SlimefunReloadedItems.PROGRAMMABLE_ANDROID, new ItemStack(Material.CHEST), SlimefunReloadedItems.PLASTIC_SHEET, SlimefunReloadedItems.POWER_CRYSTAL, SlimefunReloadedItems.PLASTIC_SHEET}) {

			@Override
			public AndroidType getAndroidType() {
				return AndroidType.NONE;
			}

			@Override
			public float getFuelEfficiency() {
				return 1.5F;
			}

			@Override
			public int getTier() {
				return 2;
			}

		}
		.register(true);

		new ProgrammableAndroid(ELECTRICITY, SlimefunReloadedItems.PROGRAMMABLE_ANDROID_2_FISHERMAN, "PROGRAMMABLE_ANDROID_2_FISHERMAN", RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {null, null, null, new ItemStack(Material.FISHING_ROD), SlimefunReloadedItems.PROGRAMMABLE_ANDROID_2, new ItemStack(Material.FISHING_ROD), null, SlimefunReloadedItems.ELECTRIC_MOTOR, null}) {

			@Override
			public AndroidType getAndroidType() {
				return AndroidType.FISHERMAN;
			}

			@Override
			public float getFuelEfficiency() {
				return 1.5F;
			}

			@Override
			public int getTier() {
				return 2;
			}

		}
		.register(true);

		new ProgrammableAndroid(ELECTRICITY, SlimefunReloadedItems.PROGRAMMABLE_ANDROID_2_BUTCHER, "PROGRAMMABLE_ANDROID_2_BUTCHER", RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {null, SlimefunReloadedItems.GPS_TRANSMITTER, null, new ItemStack(Material.DIAMOND_SWORD), SlimefunReloadedItems.PROGRAMMABLE_ANDROID_2, new ItemStack(Material.DIAMOND_SWORD), null, SlimefunReloadedItems.ELECTRIC_MOTOR, null}) {

			@Override
			public AndroidType getAndroidType() {
				return AndroidType.FIGHTER;
			}

			@Override
			public float getFuelEfficiency() {
				return 1.5F;
			}

			@Override
			public int getTier() {
				return 2;
			}

		}
		.register(true);

		new ProgrammableAndroid(ELECTRICITY, SlimefunReloadedItems.PROGRAMMABLE_ANDROID_2_FARMER, "PROGRAMMABLE_ANDROID_2_FARMER", RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {null, SlimefunReloadedItems.GPS_TRANSMITTER, null, new ItemStack(Material.DIAMOND_HOE), SlimefunReloadedItems.PROGRAMMABLE_ANDROID_2, new ItemStack(Material.DIAMOND_HOE), null, SlimefunReloadedItems.ELECTRIC_MOTOR, null}) {

			@Override
			public AndroidType getAndroidType() {
				return AndroidType.ADVANCED_FARMER;
			}

			@Override
			public float getFuelEfficiency() {
				return 1.5F;
			}

			@Override
			public int getTier() {
				return 2;
			}

		}
		.register(true);


		new ProgrammableAndroid(ELECTRICITY, SlimefunReloadedItems.PROGRAMMABLE_ANDROID_3, "PROGRAMMABLE_ANDROID_3", RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {SlimefunReloadedItems.PLASTIC_SHEET, SlimefunReloadedItems.ANDROID_MEMORY_CORE, SlimefunReloadedItems.PLASTIC_SHEET, SlimefunReloadedItems.NUCLEAR_REACTOR, SlimefunReloadedItems.PROGRAMMABLE_ANDROID_2, new ItemStack(Material.CHEST), SlimefunReloadedItems.BLISTERING_INGOT_3, SlimefunReloadedItems.POWER_CRYSTAL, SlimefunReloadedItems.BLISTERING_INGOT_3}) {

			@Override
			public AndroidType getAndroidType() {
				return AndroidType.NONE;
			}

			@Override
			public float getFuelEfficiency() {
				return 1F;
			}

			@Override
			public int getTier() {
				return 3;
			}

		}
		.register(true);

		new ProgrammableAndroid(ELECTRICITY, SlimefunReloadedItems.PROGRAMMABLE_ANDROID_3_FISHERMAN, "PROGRAMMABLE_ANDROID_3_FISHERMAN", RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {null, null, null, new ItemStack(Material.FISHING_ROD), SlimefunReloadedItems.PROGRAMMABLE_ANDROID_3, new ItemStack(Material.FISHING_ROD), null, SlimefunReloadedItems.ELECTRIC_MOTOR, null}) {

			@Override
			public AndroidType getAndroidType() {
				return AndroidType.FISHERMAN;
			}

			@Override
			public float getFuelEfficiency() {
				return 1F;
			}

			@Override
			public int getTier() {
				return 3;
			}

		}
		.register(true);

		new ProgrammableAndroid(ELECTRICITY, SlimefunReloadedItems.PROGRAMMABLE_ANDROID_3_BUTCHER, "PROGRAMMABLE_ANDROID_3_BUTCHER", RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {null, SlimefunReloadedItems.GPS_TRANSMITTER_3, null, new ItemStack(Material.DIAMOND_SWORD), SlimefunReloadedItems.PROGRAMMABLE_ANDROID_3, new ItemStack(Material.DIAMOND_SWORD), null, SlimefunReloadedItems.ELECTRIC_MOTOR, null}) {

			@Override
			public AndroidType getAndroidType() {
				return AndroidType.FIGHTER;
			}

			@Override
			public float getFuelEfficiency() {
				return 1F;
			}

			@Override
			public int getTier() {
				return 3;
			}

		}
		.register(true);
    new Refinery(ELECTRICITY, (SlimefunReloadedItemStack) SlimefunReloadedItems.REFINERY, RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {SlimefunReloadedItems.HARDENED_GLASS, SlimefunReloadedItems.REDSTONE_ALLOY, SlimefunReloadedItems.HARDENED_GLASS, SlimefunReloadedItems.HARDENED_GLASS, SlimefunReloadedItems.REDSTONE_ALLOY, SlimefunReloadedItems.HARDENED_GLASS, new ItemStack(Material.PISTON), SlimefunReloadedItems.ELECTRIC_MOTOR, new ItemStack(Material.PISTON)}) {

			@Override
			public int getEnergyConsumption() {
				return 16;
			}

			@Override
			public int getSpeed() {
				return 1;
			}

		}.registerChargeableBlock(true, 256);

		new LavaGenerator(ELECTRICITY, (SlimefunReloadedItemStack) SlimefunReloadedItems.LAVA_GENERATOR, RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {null, SlimefunReloadedItems.GOLD_16K, null, SlimefunReloadedItems.DAMASCUS_STEEL_INGOT, SlimefunReloadedItems.ELECTRIC_MOTOR, SlimefunReloadedItems.DAMASCUS_STEEL_INGOT, SlimefunReloadedItems.HEATING_COIL, SlimefunReloadedItems.DAMASCUS_STEEL_INGOT, SlimefunReloadedItems.HEATING_COIL}) {
			
			@Override
			public int getEnergyProduction() {
				return 10;
			}

		}.registerUnrechargeableBlock(true, 512);

		new LavaGenerator(ELECTRICITY, (SlimefunReloadedItemStack) SlimefunReloadedItems.LAVA_GENERATOR_2, RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {SlimefunReloadedItems.CORINTHIAN_BRONZE_INGOT, SlimefunReloadedItems.CORINTHIAN_BRONZE_INGOT, SlimefunReloadedItems.CORINTHIAN_BRONZE_INGOT, SlimefunReloadedItems.COMPRESSED_CARBON, SlimefunReloadedItems.LAVA_GENERATOR, SlimefunReloadedItems.COMPRESSED_CARBON, SlimefunReloadedItems.HEATING_COIL, SlimefunReloadedItems.COMPRESSED_CARBON, SlimefunReloadedItems.HEATING_COIL}) {
			
			@Override
			public int getEnergyProduction() {
				return 20;
			}

		}.registerUnrechargeableBlock(true, 1024);

		new CombustionGenerator(ELECTRICITY, (SlimefunReloadedItemStack) SlimefunReloadedItems.COMBUSTION_REACTOR, RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {null, SlimefunReloadedItems.STEEL_INGOT, null, SlimefunReloadedItems.STEEL_INGOT, SlimefunReloadedItems.ELECTRIC_MOTOR, SlimefunReloadedItems.STEEL_INGOT, SlimefunReloadedItems.HEATING_COIL, SlimefunReloadedItems.STEEL_INGOT, SlimefunReloadedItems.HEATING_COIL}) {
			
			@Override
			public int getEnergyProduction() {
				return 12;
			}

		}.registerUnrechargeableBlock(true, 256);
    new FoodFabricator(ELECTRICITY, (SlimefunReloadedItemStack) SlimefunReloadedItems.FOOD_FABRICATOR, RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {SlimefunReloadedItems.BILLON_INGOT, SlimefunReloadedItems.SILVER_INGOT, SlimefunReloadedItems.BILLON_INGOT, SlimefunReloadedItems.CAN, SlimefunReloadedItems.SMALL_CAPACITOR, SlimefunReloadedItems.CAN, null, SlimefunReloadedItems.ELECTRIC_MOTOR, null}) {

			@Override
			public int getEnergyConsumption() {
				return 7;
			}

			@Override
			public int getSpeed() {
				return 1;
			}

		}.registerChargeableBlock(true, 256);

		new FoodFabricator(ELECTRICITY, (SlimefunReloadedItemStack) SlimefunReloadedItems.FOOD_FABRICATOR_2, RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {SlimefunReloadedItems.HARDENED_METAL_INGOT, SlimefunReloadedItems.REINFORCED_ALLOY_INGOT, SlimefunReloadedItems.HARDENED_METAL_INGOT, SlimefunReloadedItems.ELECTRIC_MOTOR, SlimefunReloadedItems.FOOD_FABRICATOR, SlimefunReloadedItems.ELECTRIC_MOTOR, null, SlimefunReloadedItems.ELECTRO_MAGNET, null}) {
			
			@Override
			public int getEnergyConsumption() {
				return 24;
			}

			@Override
			public int getSpeed() {
				return 6;
			}

		}.registerChargeableBlock(true, 512);
    new CropGrowthAccelerator(ELECTRICITY, (SlimefunReloadedItemStack) SlimefunReloadedItems.CROP_GROWTH_ACCELERATOR, RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {null, SlimefunReloadedItems.BLISTERING_INGOT_3, null, SlimefunReloadedItems.ELECTRIC_MOTOR, SlimefunReloadedItems.PROGRAMMABLE_ANDROID_FARMER, SlimefunReloadedItems.ELECTRIC_MOTOR, SlimefunReloadedItems.ELECTRO_MAGNET, SlimefunReloadedItems.ANIMAL_GROWTH_ACCELERATOR, SlimefunReloadedItems.ELECTRO_MAGNET}) {

			@Override
			public int getEnergyConsumption() {
				return 25;
			}

			@Override
			public int getRadius() {
				return 3;
			}

			@Override
			public int getSpeed() {
				return 3;
			}

		}.registerChargeableBlock(true, 1024);

		new CropGrowthAccelerator(ELECTRICITY, (SlimefunReloadedItemStack) SlimefunReloadedItems.CROP_GROWTH_ACCELERATOR_2, RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {null, SlimefunReloadedItems.BLISTERING_INGOT_3, null, SlimefunReloadedItems.ELECTRIC_MOTOR, SlimefunReloadedItems.CROP_GROWTH_ACCELERATOR, SlimefunReloadedItems.ELECTRIC_MOTOR, SlimefunReloadedItems.ELECTRO_MAGNET, SlimefunReloadedItems.ADVANCED_CIRCUIT_BOARD, SlimefunReloadedItems.ELECTRO_MAGNET}) {

			@Override
			public int getEnergyConsumption() {
				return 30;
			}

			@Override
			public int getRadius() {
				return 4;
			}

			@Override
			public int getSpeed() {
				return 4;
			}

		}.registerChargeableBlock(true, 1024);

		new Freezer(ELECTRICITY, (SlimefunReloadedItemStack) SlimefunReloadedItems.FREEZER, RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {null, SlimefunReloadedItems.SILVER_INGOT, null, SlimefunReloadedItems.ELECTRIC_MOTOR, new ItemStack(Material.PACKED_ICE), SlimefunReloadedItems.ELECTRIC_MOTOR, SlimefunReloadedItems.COOLING_UNIT, SlimefunReloadedItems.MEDIUM_CAPACITOR, SlimefunReloadedItems.COOLING_UNIT}) {
			
			@Override
			public int getEnergyConsumption() {
				return 9;
			}

			@Override
			public int getSpeed() {
				return 1;
			}

		}.registerChargeableBlock(true, 256);

		new Freezer(ELECTRICITY, (SlimefunReloadedItemStack) SlimefunReloadedItems.FREEZER_2, RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {null, SlimefunReloadedItems.SILVER_INGOT, null, SlimefunReloadedItems.ELECTRO_MAGNET, SlimefunReloadedItems.FREEZER, SlimefunReloadedItems.ELECTRO_MAGNET, SlimefunReloadedItems.COOLING_UNIT, SlimefunReloadedItems.ALUMINUM_BRASS_INGOT, SlimefunReloadedItems.COOLING_UNIT}) {

			@Override
			public int getEnergyConsumption() {
				return 15;
			}

			@Override
			public int getSpeed() {
				return 2;
			}

		}.registerChargeableBlock(true, 256);
    new AReactor(ELECTRICITY, (SlimefunReloadedItemStack) SlimefunReloadedItems.NUCLEAR_REACTOR, RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {SlimefunReloadedItems.BLISTERING_INGOT_3, SlimefunReloadedItems.CARBONADO_EDGED_CAPACITOR, SlimefunReloadedItems.BLISTERING_INGOT_3, SlimefunReloadedItems.REINFORCED_PLATE, SlimefunReloadedItems.COOLING_UNIT, SlimefunReloadedItems.REINFORCED_PLATE, SlimefunReloadedItems.LEAD_INGOT, SlimefunReloadedItems.REINFORCED_PLATE, SlimefunReloadedItems.LEAD_INGOT}){

            @Override
			public String getInventoryTitle() {
				return "&2Nuclear Reactor";
			}

			@Override
			public void registerDefaultRecipes() {
				registerFuel(new MachineFuel(1200, SlimefunReloadedItems.URANIUM, SlimefunReloadedItems.NEPTUNIUM));
				registerFuel(new MachineFuel(600, SlimefunReloadedItems.NEPTUNIUM, SlimefunReloadedItems.PLUTONIUM));
				registerFuel(new MachineFuel(1500, SlimefunReloadedItems.BOOSTED_URANIUM, null));
			}

			@Override
			public int getEnergyProduction() {
				return 250;
			}

			@Override
			public ItemStack getProgressBar() {
				try {
					return CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTNhZDhlZTg0OWVkZjA0ZWQ5YTI2Y2EzMzQxZjYwMzNiZDc2ZGNjNDIzMWVkMWVhNjNiNzU2NTc1MWIyN2FjIn19fQ==");
				} catch (Exception e) {
					Slimefun.getLogger().log(Level.SEVERE, "An Error occured while creating the Progressbar of a Reactor for Slimefun " + Slimefun.getVersion());
					return new ItemStack(Material.BLAZE_POWDER);
				}
			}

            @Override
            public ItemStack getCoolant() {
                return SlimefunReloadedItems.REACTOR_COOLANT_CELL;
            }

			@Override
			public void extraTick(Location l) {
				// This machine does not need to perform anything while ticking
				// The Nether Star Reactor uses this method to generate the Wither Effect
			}
		}
		.registerChargeableBlock(true, 16384);

		new AReactor(ELECTRICITY, (SlimefunReloadedItemStack) SlimefunReloadedItems.NETHERSTAR_REACTOR, RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[]{SlimefunReloadedItems.BOOSTED_URANIUM, SlimefunReloadedItems.CARBONADO_EDGED_CAPACITOR, SlimefunReloadedItems.BOOSTED_URANIUM, SlimefunReloadedItems.REINFORCED_PLATE, new ItemStack(Material.NETHER_STAR), SlimefunReloadedItems.REINFORCED_PLATE, SlimefunReloadedItems.CORINTHIAN_BRONZE_INGOT, SlimefunReloadedItems.REINFORCED_PLATE, SlimefunReloadedItems.CORINTHIAN_BRONZE_INGOT}){

			@Override
			public String getInventoryTitle() {
				return "&fNether Star Reactor";
			}

			@Override
			public void registerDefaultRecipes() {
				registerFuel(new MachineFuel(1800, new ItemStack(Material.NETHER_STAR)));
			}

			@Override
			public int getEnergyProduction() {
				return 512;
			}

			@Override
			public void extraTick(final Location l) {
				Bukkit.getScheduler().runTaskLater(SlimefunPlugin.instance, () -> {
					for (Entity entity : ReactorHologram.getArmorStand(l, true).getNearbyEntities(5, 5, 5)) {
						if (entity instanceof LivingEntity) {
							((LivingEntity) entity).addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 60, 1));
						}
					}
				}, 0L);
			}

            @Override
            public ItemStack getCoolant() {
                return SlimefunReloadedItems.NETHER_ICE_COOLANT_CELL;
            }

            @Override
			public ItemStack getProgressBar() {
				return new ItemStack(Material.NETHER_STAR);
			}

		}.registerChargeableBlock(true, 32768);
    new AutomatedCraftingChamber(ELECTRICITY, SlimefunReloadedItems.AUTOMATED_CRAFTING_CHAMBER, "AUTOMATED_CRAFTING_CHAMBER", RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {null, new ItemStack(Material.CRAFTING_TABLE), null, SlimefunReloadedItems.CARGO_MOTOR, SlimefunReloadedItems.BLISTERING_INGOT_3, SlimefunReloadedItems.CARGO_MOTOR, null, SlimefunReloadedItems.ELECTRIC_MOTOR, null}) {

			@Override
			public int getEnergyConsumption() {
				return 10;
			}
			
		}.registerChargeableBlock(true, 256);

		new ReactorAccessPort(ELECTRICITY, SlimefunReloadedItems.REACTOR_ACCESS_PORT, "REACTOR_ACCESS_PORT", RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {null, SlimefunReloadedItems.BLISTERING_INGOT_3, null, SlimefunReloadedItems.LEAD_INGOT, SlimefunReloadedItems.CARGO_MOTOR, SlimefunReloadedItems.LEAD_INGOT, null, SlimefunReloadedItems.ELECTRIC_MOTOR, null})
		.register(true);

		new FluidPump(ELECTRICITY, (SlimefunReloadedItemStack) SlimefunReloadedItems.FLUID_PUMP, RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {null, SlimefunReloadedItems.MEDIUM_CAPACITOR, null, new ItemStack(Material.BUCKET), SlimefunReloadedItems.CARGO_MOTOR, new ItemStack(Material.BUCKET), null, SlimefunReloadedItems.OIL_PUMP, null})
		.registerChargeableBlock(true, 512);

    new CarbonPress(ELECTRICITY, SlimefunReloadedItems.CARBON_PRESS, "CARBON_PRESS", RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {SlimefunReloadedItems.CARBON, SlimefunReloadedItems.ELECTRIC_MOTOR, SlimefunReloadedItems.CARBON, SlimefunReloadedItems.CARBON, SlimefunReloadedItems.HEATED_PRESSURE_CHAMBER, SlimefunReloadedItems.CARBON, SlimefunReloadedItems.HEATING_COIL, SlimefunReloadedItems.CARBONADO, SlimefunReloadedItems.HEATING_COIL}) {

			@Override
			public int getEnergyConsumption() {
				return 10;
			}

			@Override
			public int getSpeed() {
				return 1;
			}

		}.registerChargeableBlock(true, 256);

		new CarbonPress(ELECTRICITY, SlimefunReloadedItems.CARBON_PRESS_2, "CARBON_PRESS_2", RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {SlimefunReloadedItems.CARBONADO, SlimefunReloadedItems.ELECTRIC_MOTOR, SlimefunReloadedItems.CARBONADO, SlimefunReloadedItems.CARBON, SlimefunReloadedItems.CARBON_PRESS, SlimefunReloadedItems.CARBON, SlimefunReloadedItems.HEATING_COIL, SlimefunReloadedItems.ELECTRO_MAGNET, SlimefunReloadedItems.HEATING_COIL}) {

			@Override
			public int getEnergyConsumption() {
				return 25;
			}

			@Override
			public int getSpeed() {
				return 3;
			}

		}.registerChargeableBlock(true, 512);

		new CarbonPress(ELECTRICITY, SlimefunReloadedItems.CARBON_PRESS_3, "CARBON_PRESS_3", RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {SlimefunReloadedItems.CARBONADO, SlimefunReloadedItems.ELECTRIC_MOTOR, SlimefunReloadedItems.CARBONADO, SlimefunReloadedItems.REINFORCED_ALLOY_INGOT, SlimefunReloadedItems.CARBON_PRESS_2, SlimefunReloadedItems.REINFORCED_ALLOY_INGOT, SlimefunReloadedItems.HEATING_COIL, SlimefunReloadedItems.ELECTRO_MAGNET, SlimefunReloadedItems.HEATING_COIL}) {

			@Override
			public int getEnergyConsumption() {
				return 90;
			}

			@Override
			public int getSpeed() {
				return 15;
			}

		}.registerChargeableBlock(true, 512);

		new ElectricSmeltery(ELECTRICITY, SlimefunReloadedItems.ELECTRIC_SMELTERY, "ELECTRIC_SMELTERY", RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {new ItemStack(Material.NETHER_BRICKS), SlimefunReloadedItems.ELECTRIC_MOTOR, new ItemStack(Material.NETHER_BRICKS), SlimefunReloadedItems.HEATING_COIL, SlimefunReloadedItems.ELECTRIC_INGOT_FACTORY, SlimefunReloadedItems.HEATING_COIL, SlimefunReloadedItems.GILDED_IRON, SlimefunReloadedItems.ELECTRIC_MOTOR, SlimefunReloadedItems.GILDED_IRON}) {

			@Override
			public int getEnergyConsumption() {
				return 10;
			}

			@Override
			public int getSpeed() {
				return 1;
			}

		}.registerChargeableBlock(true, 512);

		new ElectricSmeltery(ELECTRICITY, SlimefunReloadedItems.ELECTRIC_SMELTERY_2, "ELECTRIC_SMELTERY_2", RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {SlimefunReloadedItems.DAMASCUS_STEEL_INGOT, SlimefunReloadedItems.POWER_CRYSTAL, SlimefunReloadedItems.DAMASCUS_STEEL_INGOT, SlimefunReloadedItems.HEATING_COIL, SlimefunReloadedItems.ELECTRIC_SMELTERY, SlimefunReloadedItems.HEATING_COIL, SlimefunReloadedItems.GILDED_IRON, SlimefunReloadedItems.ELECTRIC_MOTOR, SlimefunReloadedItems.GILDED_IRON}) {
			
			@Override
			public int getEnergyConsumption() {
				return 20;
			}

			@Override
			public int getSpeed() {
				return 3;
			}

		}.registerChargeableBlock(true, 1024);

		new WitherAssembler(ELECTRICITY, SlimefunReloadedItems.WITHER_ASSEMBLER, "WITHER_ASSEMBLER", RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {SlimefunReloadedItems.BLISTERING_INGOT_3, new ItemStack(Material.NETHER_STAR), SlimefunReloadedItems.BLISTERING_INGOT_3, SlimefunReloadedItems.WITHER_PROOF_OBSIDIAN, SlimefunReloadedItems.ANDROID_MEMORY_CORE, SlimefunReloadedItems.WITHER_PROOF_OBSIDIAN, SlimefunReloadedItems.ELECTRIC_MOTOR, SlimefunReloadedItems.REINFORCED_ALLOY_INGOT, SlimefunReloadedItems.CARBONADO_EDGED_CAPACITOR})
		.registerChargeableBlock(true, 4096);

     */
    //ArmorPiece Registery
    Category ARMOR = CATEGORY_MANAGER.getCategoryByKey("ARMOR");
    registerSlimefunReloadedArmorPiece("scuba_helmet", ARMOR, (SlimefunReloadedItemStack) SlimefunReloadedItems.SCUBA_HELMET, RecipeType.ARMOR_FORGE, new ItemStack[]{new ItemStack(Material.ORANGE_WOOL), new ItemStack(Material.ORANGE_WOOL), new ItemStack(Material.ORANGE_WOOL), new ItemStack(Material.BLACK_WOOL), new ItemStack(Material.GLASS_PANE), new ItemStack(Material.BLACK_WOOL), null, null, null}, new PotionEffect[]{new PotionEffect(PotionEffectType.WATER_BREATHING, 300, 1)});
    registerSlimefunReloadedArmorPiece("hazmatsuit_chestplate", ARMOR, (SlimefunReloadedItemStack) SlimefunReloadedItems.HAZMATSUIT_CHESTPLATE, RecipeType.ARMOR_FORGE, new ItemStack[]{new ItemStack(Material.ORANGE_WOOL), null, new ItemStack(Material.ORANGE_WOOL), new ItemStack(Material.ORANGE_WOOL), new ItemStack(Material.ORANGE_WOOL), new ItemStack(Material.ORANGE_WOOL), new ItemStack(Material.BLACK_WOOL), new ItemStack(Material.BLACK_WOOL), new ItemStack(Material.BLACK_WOOL)}, new PotionEffect[]{new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 300, 1)});
    registerSlimefunReloadedArmorPiece("hazmatsuit_leggings", ARMOR, (SlimefunReloadedItemStack) SlimefunReloadedItems.HAZMATSUIT_LEGGINGS, RecipeType.ARMOR_FORGE, new ItemStack[]{new ItemStack(Material.BLACK_WOOL), new ItemStack(Material.BLACK_WOOL), new ItemStack(Material.BLACK_WOOL), new ItemStack(Material.ORANGE_WOOL), null, new ItemStack(Material.ORANGE_WOOL), new ItemStack(Material.ORANGE_WOOL), null, new ItemStack(Material.ORANGE_WOOL)}, new PotionEffect[]{});
    registerSlimefunReloadedArmorPiece("rubber_boots", ARMOR, (SlimefunReloadedItemStack) SlimefunReloadedItems.RUBBER_BOOTS, RecipeType.ARMOR_FORGE, new ItemStack[]{null, null, null, new ItemStack(Material.BLACK_WOOL), null, new ItemStack(Material.BLACK_WOOL), new ItemStack(Material.BLACK_WOOL), null, new ItemStack(Material.BLACK_WOOL)}, new PotionEffect[]{});
    //Christmas Registery
    Category CHRISTMAS = CATEGORY_MANAGER.getCategoryByKey("CHRISTMAS");
    registerSimpleSlimefunReloadedItem("christmas_milk", CHRISTMAS, SlimefunReloadedItems.CHRISTMAS_MILK, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{new ItemStack(Material.MILK_BUCKET), new ItemStack(Material.GLASS_BOTTLE), null, null, null, null, null, null, null}, new CustomItem(SlimefunReloadedItems.CHRISTMAS_MILK, 4));
    registerSimpleSlimefunReloadedItem("christmas_chocolate_milk", CHRISTMAS, SlimefunReloadedItems.CHRISTMAS_CHOCOLATE_MILK, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{SlimefunReloadedItems.CHRISTMAS_MILK, new ItemStack(Material.COCOA_BEANS), null, null, null, null, null, null, null}, new CustomItem(SlimefunReloadedItems.CHRISTMAS_CHOCOLATE_MILK, 2));
    registerSimpleSlimefunReloadedItem("christmas_egg_nog", CHRISTMAS, SlimefunReloadedItems.CHRISTMAS_EGG_NOG, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{SlimefunReloadedItems.CHRISTMAS_MILK, new ItemStack(Material.EGG), null, null, null, null, null, null, null}, new CustomItem(SlimefunReloadedItems.CHRISTMAS_EGG_NOG, 2));
    registerSimpleSlimefunReloadedItem("christmas_apple_cider", CHRISTMAS, SlimefunReloadedItems.CHRISTMAS_APPLE_CIDER, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{SlimefunReloadedItems.APPLE_JUICE, new ItemStack(Material.SUGAR), null, null, null, null, null, null, null}, new CustomItem(SlimefunReloadedItems.CHRISTMAS_APPLE_CIDER, 2));
    registerSimpleSlimefunReloadedItem("christmas_cookie", CHRISTMAS, SlimefunReloadedItems.CHRISTMAS_COOKIE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{new ItemStack(Material.COOKIE), new ItemStack(Material.SUGAR), new ItemStack(Material.LIME_DYE), null, null, null, null, null, null}, new CustomItem(SlimefunReloadedItems.CHRISTMAS_COOKIE, 16));
    registerSimpleSlimefunReloadedItem("christmas_fruit_cake", CHRISTMAS, SlimefunReloadedItems.CHRISTMAS_FRUIT_CAKE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{new ItemStack(Material.EGG), new ItemStack(Material.APPLE), new ItemStack(Material.MELON), new ItemStack(Material.SUGAR), null, null, null, null, null}, new CustomItem(SlimefunReloadedItems.CHRISTMAS_FRUIT_CAKE, 4));
    registerSimpleSlimefunReloadedItem("christmas_apple_pie", CHRISTMAS, SlimefunReloadedItems.CHRISTMAS_APPLE_PIE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{new ItemStack(Material.SUGAR), new ItemStack(Material.APPLE), new ItemStack(Material.EGG), null, null, null, null, null, null}, new CustomItem(SlimefunReloadedItems.CHRISTMAS_APPLE_PIE, 2));
    registerSimpleSlimefunReloadedItem("christmas_hot_chocolate", CHRISTMAS, SlimefunReloadedItems.CHRISTMAS_HOT_CHOCOLATE, RecipeType.SMELTERY, new ItemStack[]{SlimefunReloadedItems.CHRISTMAS_CHOCOLATE_MILK, null, null, null, null, null, null, null, null}, new CustomItem(SlimefunReloadedItems.CHRISTMAS_HOT_CHOCOLATE));
    registerSimpleSlimefunReloadedItem("christmas_cake", CHRISTMAS, SlimefunReloadedItems.CHRISTMAS_CAKE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{new ItemStack(Material.EGG), new ItemStack(Material.SUGAR), SlimefunReloadedItems.WHEAT_FLOUR, new ItemStack(Material.MILK_BUCKET), null, null, null, null, null}, new CustomItem(SlimefunReloadedItems.CHRISTMAS_CAKE, 4));
    registerSimpleSlimefunReloadedItem("christmas_caramel", CHRISTMAS, SlimefunReloadedItems.CHRISTMAS_CARAMEL, RecipeType.SMELTERY, new ItemStack[]{new ItemStack(Material.SUGAR), new ItemStack(Material.SUGAR), null, null, null, null, null, null, null}, new CustomItem(SlimefunReloadedItems.CHRISTMAS_CARAMEL, 4));
    registerSimpleSlimefunReloadedItem("christmas_caramel_apple", CHRISTMAS, SlimefunReloadedItems.CHRISTMAS_CARAMEL_APPLE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{null, new ItemStack(Material.SUGAR), null, null, new ItemStack(Material.APPLE), null, null, new ItemStack(Material.STICK), null}, new CustomItem(SlimefunReloadedItems.CHRISTMAS_CARAMEL_APPLE, 2));
    registerSimpleSlimefunReloadedItem("christmas_chocolate_apple", CHRISTMAS, SlimefunReloadedItems.CHRISTMAS_CHOCOLATE_APPLE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{null, new ItemStack(Material.COCOA_BEANS), null, null, new ItemStack(Material.APPLE), null, null, new ItemStack(Material.STICK), null}, new CustomItem(SlimefunReloadedItems.CHRISTMAS_CHOCOLATE_APPLE, 2));
    registerSimpleSlimefunReloadedItem("christmas_present", CHRISTMAS, SlimefunReloadedItems.CHRISTMAS_PRESENT, RecipeType.MAGIC_WORKBENCH, new ItemStack[]{null, new ItemStack(Material.NAME_TAG), null, new ItemStack(Material.RED_WOOL), new ItemStack(Material.GREEN_WOOL), new ItemStack(Material.RED_WOOL), new ItemStack(Material.RED_WOOL), new ItemStack(Material.GREEN_WOOL), new ItemStack(Material.RED_WOOL)});
    /*
    RainbowTicker xmas = new RainbowTicker(13, 14);

		new SlimefunReloadedItems(CHRISTMAS, (SlimefunReloadedItemStack) SlimefunReloadedItems.RAINBOW_WOOL_XMAS, RecipeType.ANCIENT_ALTAR,
		new ItemStack[] {new ItemStack(Material.RED_DYE), SlimefunReloadedItems.CHRISTMAS_COOKIE, new ItemStack(Material.GREEN_DYE), new ItemStack(Material.WHITE_WOOL), SlimefunReloadedItems.RUNE_RAINBOW, new ItemStack(Material.WHITE_WOOL), new ItemStack(Material.GREEN_DYE), SlimefunReloadedItems.CHRISTMAS_COOKIE, new ItemStack(Material.RED_DYE)}, new CustomItem(SlimefunReloadedItems.RAINBOW_WOOL_XMAS, 2))
		.register(true, xmas);

		new SlimefunReloadedItems(CHRISTMAS, (SlimefunReloadedItemStack) SlimefunReloadedItems.RAINBOW_GLASS_XMAS, RecipeType.ANCIENT_ALTAR,
		new ItemStack[] {new ItemStack(Material.RED_DYE), SlimefunReloadedItems.CHRISTMAS_COOKIE, new ItemStack(Material.GREEN_DYE), new ItemStack(Material.WHITE_STAINED_GLASS), SlimefunReloadedItems.RUNE_RAINBOW, new ItemStack(Material.WHITE_STAINED_GLASS), new ItemStack(Material.GREEN_DYE), SlimefunReloadedItems.CHRISTMAS_COOKIE, new ItemStack(Material.RED_DYE)}, new CustomItem(SlimefunReloadedItems.RAINBOW_GLASS_XMAS, 2))
		.register(true, xmas);

		new SlimefunReloadedItems(CHRISTMAS, (SlimefunReloadedItemStack) SlimefunReloadedItems.RAINBOW_GLASS_PANE_XMAS, RecipeType.ANCIENT_ALTAR,
		new ItemStack[] {new ItemStack(Material.RED_DYE), SlimefunReloadedItems.CHRISTMAS_COOKIE, new ItemStack(Material.GREEN_DYE), new ItemStack(Material.WHITE_STAINED_GLASS_PANE), SlimefunReloadedItems.RUNE_RAINBOW, new ItemStack(Material.WHITE_STAINED_GLASS_PANE), new ItemStack(Material.GREEN_DYE), SlimefunReloadedItems.CHRISTMAS_COOKIE, new ItemStack(Material.RED_DYE)}, new CustomItem(SlimefunReloadedItems.RAINBOW_GLASS_PANE_XMAS, 2))
		.register(true, xmas);

		new SlimefunReloadedItems(CHRISTMAS, (SlimefunReloadedItemStack) SlimefunReloadedItems.RAINBOW_CLAY_XMAS, RecipeType.ANCIENT_ALTAR,
		new ItemStack[] {new ItemStack(Material.RED_DYE), SlimefunReloadedItems.CHRISTMAS_COOKIE, new ItemStack(Material.GREEN_DYE), new ItemStack(Material.WHITE_TERRACOTTA), SlimefunReloadedItems.RUNE_RAINBOW, new ItemStack(Material.WHITE_TERRACOTTA), new ItemStack(Material.GREEN_DYE), SlimefunReloadedItems.CHRISTMAS_COOKIE, new ItemStack(Material.RED_DYE)}, new CustomItem(SlimefunReloadedItems.RAINBOW_CLAY_XMAS, 2))
		.register(true, xmas);

     */
    //Easter Registery
    Category EASTER = CATEGORY_MANAGER.getCategoryByKey("EASTER");
    registerSimpleSlimefunReloadedItem("easter_carrot_pie", EASTER, SlimefunReloadedItems.EASTER_CARROT_PIE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{new ItemStack(Material.SUGAR), new ItemStack(Material.CARROT), new ItemStack(Material.EGG), null, null, null, null, null, null}, new CustomItem(SlimefunReloadedItems.EASTER_CARROT_PIE, 2));
    registerSimpleSlimefunReloadedItem("easter_apple_pie", EASTER, SlimefunReloadedItems.CHRISTMAS_APPLE_PIE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{new ItemStack(Material.SUGAR), new ItemStack(Material.APPLE), new ItemStack(Material.EGG), null, null, null, null, null, null}, new CustomItem(SlimefunReloadedItems.CHRISTMAS_APPLE_PIE, 2));
    register(new EasterEgg(new NamespacedKey(plugin, "easter_egg"), EASTER, (SlimefunReloadedItemStack) SlimefunReloadedItems.EASTER_EGG, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{null, null, null, new ItemStack(Material.LIME_DYE), new ItemStack(Material.EGG), new ItemStack(Material.PURPLE_DYE), null, null, null}, new CustomItem(SlimefunReloadedItems.EASTER_EGG, 2)));
    /*
		RainbowTicker valentine = new RainbowTicker(2, 6, 10);

		new SlimefunReloadedItems(VALENTINES_DAY, (SlimefunReloadedItemStack) SlimefunReloadedItems.RAINBOW_WOOL_VALENTINE, RecipeType.ANCIENT_ALTAR,
		new ItemStack[] {new ItemStack(Material.RED_DYE), new ItemStack(Material.POPPY), new ItemStack(Material.PINK_DYE), new ItemStack(Material.WHITE_WOOL), SlimefunReloadedItems.RUNE_RAINBOW, new ItemStack(Material.WHITE_WOOL), new ItemStack(Material.PINK_DYE), new ItemStack(Material.POPPY), new ItemStack(Material.RED_DYE)}, new CustomItem(SlimefunReloadedItems.RAINBOW_WOOL_VALENTINE, 2))
		.register(true, valentine);

		new SlimefunReloadedItems(VALENTINES_DAY, (SlimefunReloadedItemStack) SlimefunReloadedItems.RAINBOW_GLASS_VALENTINE, RecipeType.ANCIENT_ALTAR,
		new ItemStack[] {new ItemStack(Material.RED_DYE), new ItemStack(Material.POPPY), new ItemStack(Material.PINK_DYE), new ItemStack(Material.WHITE_STAINED_GLASS), SlimefunReloadedItems.RUNE_RAINBOW, new ItemStack(Material.WHITE_STAINED_GLASS), new ItemStack(Material.PINK_DYE), new ItemStack(Material.POPPY), new ItemStack(Material.RED_DYE)}, new CustomItem(SlimefunReloadedItems.RAINBOW_GLASS_VALENTINE, 2))
		.register(true, valentine);

		new SlimefunReloadedItems(VALENTINES_DAY, (SlimefunReloadedItemStack) SlimefunReloadedItems.RAINBOW_GLASS_PANE_VALENTINE, RecipeType.ANCIENT_ALTAR,
		new ItemStack[] {new ItemStack(Material.RED_DYE), new ItemStack(Material.POPPY), new ItemStack(Material.PINK_DYE), new ItemStack(Material.WHITE_STAINED_GLASS_PANE), SlimefunReloadedItems.RUNE_RAINBOW, new ItemStack(Material.WHITE_STAINED_GLASS_PANE), new ItemStack(Material.PINK_DYE), new ItemStack(Material.POPPY), new ItemStack(Material.RED_DYE)}, new CustomItem(SlimefunReloadedItems.RAINBOW_GLASS_PANE_VALENTINE, 2))
		.register(true, valentine);

		new SlimefunReloadedItems(VALENTINES_DAY, (SlimefunReloadedItemStack) SlimefunReloadedItems.RAINBOW_CLAY_VALENTINE, RecipeType.ANCIENT_ALTAR,
		new ItemStack[] {new ItemStack(Material.RED_DYE), new ItemStack(Material.POPPY), new ItemStack(Material.PINK_DYE), new ItemStack(Material.WHITE_TERRACOTTA), SlimefunReloadedItems.RUNE_RAINBOW, new ItemStack(Material.WHITE_TERRACOTTA), new ItemStack(Material.PINK_DYE), new ItemStack(Material.POPPY), new ItemStack(Material.RED_DYE)}, new CustomItem(SlimefunReloadedItems.RAINBOW_CLAY_VALENTINE, 2))
		.register(true, valentine);
     */
    //Alloy Registery
    registerSlimefunReloadedAlloy("reinforced_alloy_ingot", (SlimefunReloadedItemStack) SlimefunReloadedItems.REINFORCED_ALLOY_INGOT, new ItemStack[]{SlimefunReloadedItems.DAMASCUS_STEEL_INGOT, SlimefunReloadedItems.HARDENED_METAL_INGOT, SlimefunReloadedItems.CORINTHIAN_BRONZE_INGOT, SlimefunReloadedItems.SOLDER_INGOT, SlimefunReloadedItems.BILLON_INGOT, SlimefunReloadedItems.GOLD_24K, null, null, null});
    registerSlimefunReloadedAlloy("hardened_metal_ingot", (SlimefunReloadedItemStack) SlimefunReloadedItems.HARDENED_METAL_INGOT, new ItemStack[]{SlimefunReloadedItems.DAMASCUS_STEEL_INGOT, SlimefunReloadedItems.DURALUMIN_INGOT, SlimefunReloadedItems.COMPRESSED_CARBON, SlimefunReloadedItems.ALUMINUM_BRONZE_INGOT, null, null, null, null, null});
    registerSlimefunReloadedAlloy("damascus_steel_ingot", (SlimefunReloadedItemStack) SlimefunReloadedItems.DAMASCUS_STEEL_INGOT, new ItemStack[]{SlimefunReloadedItems.STEEL_INGOT, SlimefunReloadedItems.IRON_DUST, SlimefunReloadedItems.CARBON, new ItemStack(Material.IRON_INGOT), null, null, null, null, null});
    registerSlimefunReloadedAlloy("steel_ingot", (SlimefunReloadedItemStack) SlimefunReloadedItems.STEEL_INGOT, new ItemStack[]{SlimefunReloadedItems.IRON_DUST, SlimefunReloadedItems.CARBON, new ItemStack(Material.IRON_INGOT), null, null, null, null, null, null});
    registerSlimefunReloadedAlloy("bronze_ingot", (SlimefunReloadedItemStack) SlimefunReloadedItems.BRONZE_INGOT, new ItemStack[]{SlimefunReloadedItems.COPPER_DUST, SlimefunReloadedItems.TIN_DUST, SlimefunReloadedItems.COPPER_INGOT, null, null, null, null, null, null});
    registerSlimefunReloadedAlloy("duralumin_ingot", (SlimefunReloadedItemStack) SlimefunReloadedItems.DURALUMIN_INGOT, new ItemStack[]{SlimefunReloadedItems.ALUMINUM_DUST, SlimefunReloadedItems.COPPER_DUST, SlimefunReloadedItems.ALUMINUM_INGOT, null, null, null, null, null, null});
    registerSlimefunReloadedAlloy("billion_ingot", (SlimefunReloadedItemStack) SlimefunReloadedItems.BILLON_INGOT, new ItemStack[]{SlimefunReloadedItems.SILVER_DUST, SlimefunReloadedItems.COPPER_DUST, SlimefunReloadedItems.SILVER_INGOT, null, null, null, null, null, null});
    registerSlimefunReloadedAlloy("brass_ingot", (SlimefunReloadedItemStack) SlimefunReloadedItems.BRASS_INGOT, new ItemStack[]{SlimefunReloadedItems.COPPER_DUST, SlimefunReloadedItems.ZINC_DUST, SlimefunReloadedItems.COPPER_INGOT, null, null, null, null, null, null});
    registerSlimefunReloadedAlloy("aluminum_brass_ingot", (SlimefunReloadedItemStack) SlimefunReloadedItems.ALUMINUM_BRASS_INGOT, new ItemStack[]{SlimefunReloadedItems.ALUMINUM_DUST, SlimefunReloadedItems.BRASS_INGOT, SlimefunReloadedItems.ALUMINUM_INGOT, null, null, null, null, null, null});
    registerSlimefunReloadedAlloy("aluminum_bronze_ingot", (SlimefunReloadedItemStack) SlimefunReloadedItems.ALUMINUM_BRONZE_INGOT, new ItemStack[]{SlimefunReloadedItems.ALUMINUM_DUST, SlimefunReloadedItems.BRONZE_INGOT, SlimefunReloadedItems.ALUMINUM_INGOT, null, null, null, null, null, null});
    registerSlimefunReloadedAlloy("corinthian_bronze_ingot", (SlimefunReloadedItemStack) SlimefunReloadedItems.CORINTHIAN_BRONZE_INGOT, new ItemStack[]{SlimefunReloadedItems.SILVER_DUST, SlimefunReloadedItems.GOLD_DUST, SlimefunReloadedItems.COPPER_DUST, SlimefunReloadedItems.BRONZE_INGOT, null, null, null, null, null});
    registerSlimefunReloadedAlloy("solder_ingot", (SlimefunReloadedItemStack) SlimefunReloadedItems.SOLDER_INGOT, new ItemStack[]{SlimefunReloadedItems.LEAD_DUST, SlimefunReloadedItems.TIN_DUST, SlimefunReloadedItems.LEAD_INGOT, null, null, null, null, null, null});
    /*
    new ReplacingAlloy(SlimefunReloadedItems.SYNTHETIC_SAPPHIRE, "SYNTHETIC_SAPPHIRE",
		new ItemStack[] {SlimefunReloadedItems.ALUMINUM_DUST, new ItemStack(Material.GLASS), new ItemStack(Material.GLASS_PANE), SlimefunReloadedItems.ALUMINUM_INGOT, new ItemStack(Material.LAPIS_LAZULI), null, null, null, null})
		.register(true);

		new ReplacingItem(RESOURCES, SlimefunReloadedItems.SYNTHETIC_DIAMOND, "SYNTHETIC_DIAMOND", RecipeType.PRESSURE_CHAMBER,
		new ItemStack[] {SlimefunReloadedItems.CARBON_CHUNK, null, null, null, null, null, null, null, null})
		.register(true);
     */
    registerSlimefunReloadedAlloy("raw_carbonado", (SlimefunReloadedItemStack) SlimefunReloadedItems.RAW_CARBONADO, new ItemStack[]{SlimefunReloadedItems.SYNTHETIC_DIAMOND, SlimefunReloadedItems.CARBON_CHUNK, new ItemStack(Material.GLASS_PANE), null, null, null, null, null, null});
    registerSlimefunReloadedAlloy("nickel_ingot", (SlimefunReloadedItemStack) SlimefunReloadedItems.NICKEL_INGOT, new ItemStack[]{SlimefunReloadedItems.IRON_DUST, new ItemStack(Material.IRON_INGOT), SlimefunReloadedItems.COPPER_DUST, null, null, null, null, null, null});
    registerSlimefunReloadedAlloy("cobalt_ingot", (SlimefunReloadedItemStack) SlimefunReloadedItems.COBALT_INGOT, new ItemStack[]{SlimefunReloadedItems.IRON_DUST, SlimefunReloadedItems.COPPER_DUST, SlimefunReloadedItems.NICKEL_INGOT, null, null, null, null, null, null});
    registerSlimefunReloadedAlloy("ferrosilicon", (SlimefunReloadedItemStack) SlimefunReloadedItems.FERROSILICON, new ItemStack[]{new ItemStack(Material.IRON_INGOT), SlimefunReloadedItems.IRON_DUST, SlimefunReloadedItems.SILICON, null, null, null, null, null, null});
    registerSlimefunReloadedAlloy("gilded_iron", (SlimefunReloadedItemStack) SlimefunReloadedItems.GILDED_IRON, new ItemStack[]{SlimefunReloadedItems.GOLD_24K, SlimefunReloadedItems.IRON_DUST, null, null, null, null, null, null, null});
    /*
		new ReplacingAlloy(SlimefunReloadedItems.SYNTHETIC_EMERALD, "SYNTHETIC_EMERALD",
		new ItemStack[] {SlimefunReloadedItems.SYNTHETIC_SAPPHIRE, SlimefunReloadedItems.ALUMINUM_DUST, SlimefunReloadedItems.ALUMINUM_INGOT, new ItemStack(Material.GLASS_PANE), null, null, null, null, null})
		.register(true);

     */
    //Jetpack Registery
    registerJetpack("duralumin_jetpack", (SlimefunReloadedItemStack) SlimefunReloadedItems.DURALUMIN_JETPACK, new ItemStack[]{SlimefunReloadedItems.DURALUMIN_INGOT, null, SlimefunReloadedItems.DURALUMIN_INGOT, SlimefunReloadedItems.DURALUMIN_INGOT, SlimefunReloadedItems.POWER_CRYSTAL, SlimefunReloadedItems.DURALUMIN_INGOT, SlimefunReloadedItems.STEEL_THRUSTER, SlimefunReloadedItems.SMALL_CAPACITOR, SlimefunReloadedItems.STEEL_THRUSTER}, 0.35);
    registerJetpack("solder_jetpack", (SlimefunReloadedItemStack) SlimefunReloadedItems.SOLDER_JETPACK, new ItemStack[]{SlimefunReloadedItems.SOLDER_INGOT, null, SlimefunReloadedItems.SOLDER_INGOT, SlimefunReloadedItems.SOLDER_INGOT, SlimefunReloadedItems.POWER_CRYSTAL, SlimefunReloadedItems.SOLDER_INGOT, SlimefunReloadedItems.STEEL_THRUSTER, SlimefunReloadedItems.SMALL_CAPACITOR, SlimefunReloadedItems.STEEL_THRUSTER}, 0.4);
    registerJetpack("billion_jetpack", (SlimefunReloadedItemStack) SlimefunReloadedItems.BILLON_JETPACK, new ItemStack[]{SlimefunReloadedItems.BILLON_INGOT, null, SlimefunReloadedItems.BILLON_INGOT, SlimefunReloadedItems.BILLON_INGOT, SlimefunReloadedItems.POWER_CRYSTAL, SlimefunReloadedItems.BILLON_INGOT, SlimefunReloadedItems.STEEL_THRUSTER, SlimefunReloadedItems.SMALL_CAPACITOR, SlimefunReloadedItems.STEEL_THRUSTER}, 0.45);
    registerJetpack("steel_jetpack", (SlimefunReloadedItemStack) SlimefunReloadedItems.STEEL_JETPACK, new ItemStack[]{SlimefunReloadedItems.STEEL_INGOT, null, SlimefunReloadedItems.STEEL_INGOT, SlimefunReloadedItems.STEEL_INGOT, SlimefunReloadedItems.POWER_CRYSTAL, SlimefunReloadedItems.STEEL_INGOT, SlimefunReloadedItems.STEEL_THRUSTER, SlimefunReloadedItems.SMALL_CAPACITOR, SlimefunReloadedItems.STEEL_THRUSTER}, 0.5);
    registerJetpack("damascus_steel_jetpack", (SlimefunReloadedItemStack) SlimefunReloadedItems.DAMASCUS_STEEL_JETPACK, new ItemStack[]{SlimefunReloadedItems.DAMASCUS_STEEL_INGOT, null, SlimefunReloadedItems.DAMASCUS_STEEL_INGOT, SlimefunReloadedItems.DAMASCUS_STEEL_INGOT, SlimefunReloadedItems.POWER_CRYSTAL, SlimefunReloadedItems.DAMASCUS_STEEL_INGOT, SlimefunReloadedItems.STEEL_THRUSTER, SlimefunReloadedItems.SMALL_CAPACITOR, SlimefunReloadedItems.STEEL_THRUSTER}, 0.55);
    registerJetpack("reinforced_alloy_jetpack", (SlimefunReloadedItemStack) SlimefunReloadedItems.REINFORCED_ALLOY_JETPACK, new ItemStack[]{SlimefunReloadedItems.REINFORCED_ALLOY_INGOT, null, SlimefunReloadedItems.REINFORCED_ALLOY_INGOT, SlimefunReloadedItems.REINFORCED_ALLOY_INGOT, SlimefunReloadedItems.POWER_CRYSTAL, SlimefunReloadedItems.REINFORCED_ALLOY_INGOT, SlimefunReloadedItems.STEEL_THRUSTER, SlimefunReloadedItems.MEDIUM_CAPACITOR, SlimefunReloadedItems.STEEL_THRUSTER}, 0.6);
    registerJetpack("carbonado_jetpack", (SlimefunReloadedItemStack) SlimefunReloadedItems.CARBONADO_JETPACK, new ItemStack[]{SlimefunReloadedItems.CARBON_CHUNK, null, SlimefunReloadedItems.CARBON_CHUNK, SlimefunReloadedItems.CARBONADO, SlimefunReloadedItems.POWER_CRYSTAL, SlimefunReloadedItems.CARBONADO, SlimefunReloadedItems.STEEL_THRUSTER, SlimefunReloadedItems.LARGE_CAPACITOR, SlimefunReloadedItems.STEEL_THRUSTER}, 0.7);
    /*
 Armor sets
 SlimefunManager.registerArmorSet(new ItemStack(Material.GLOWSTONE), new ItemStack[] {SlimefunReloadedItems.GLOWSTONE_HELMET, SlimefunReloadedItems.GLOWSTONE_CHESTPLATE, SlimefunReloadedItems.GLOWSTONE_LEGGINGS, SlimefunReloadedItems.GLOWSTONE_BOOTS}, "GLOWSTONE",
		new PotionEffect[][] {new PotionEffect[] {new PotionEffect(PotionEffectType.NIGHT_VISION, 600, 0)}, new PotionEffect[] {new PotionEffect(PotionEffectType.NIGHT_VISION, 600, 0)}, new PotionEffect[] {new PotionEffect(PotionEffectType.NIGHT_VISION, 600, 0)}, new PotionEffect[] {new PotionEffect(PotionEffectType.NIGHT_VISION, 600, 0)}}, true, true);

		SlimefunManager.registerArmorSet(SlimefunReloadedItems.DAMASCUS_STEEL_INGOT, new ItemStack[] {SlimefunReloadedItems.DAMASCUS_STEEL_HELMET, SlimefunReloadedItems.DAMASCUS_STEEL_CHESTPLATE, SlimefunReloadedItems.DAMASCUS_STEEL_LEGGINGS, SlimefunReloadedItems.DAMASCUS_STEEL_BOOTS}, "DAMASCUS_STEEL", true, false);

		SlimefunManager.registerArmorSet(SlimefunReloadedItems.REINFORCED_ALLOY_INGOT, new ItemStack[] {SlimefunReloadedItems.REINFORCED_ALLOY_HELMET, SlimefunReloadedItems.REINFORCED_ALLOY_CHESTPLATE, SlimefunReloadedItems.REINFORCED_ALLOY_LEGGINGS, SlimefunReloadedItems.REINFORCED_ALLOY_BOOTS}, "REINFORCED_ALLOY", true, false);

		SlimefunManager.registerArmorSet(new ItemStack(Material.CACTUS), new ItemStack[] {SlimefunReloadedItems.CACTUS_HELMET, SlimefunReloadedItems.CACTUS_CHESTPLATE, SlimefunReloadedItems.CACTUS_LEGGINGS, SlimefunReloadedItems.CACTUS_BOOTS}, "CACTUS", true, false);
SlimefunManager.registerArmorSet(SlimefunReloadedItems.CHAIN, new ItemStack[] {new ItemStack(Material.CHAINMAIL_HELMET), new ItemStack(Material.CHAINMAIL_CHESTPLATE), new ItemStack(Material.CHAINMAIL_LEGGINGS), new ItemStack(Material.CHAINMAIL_BOOTS)}, "CHAIN", true, true);
SlimefunManager.registerArmorSet(SlimefunReloadedItems.GILDED_IRON, new ItemStack[] {SlimefunReloadedItems.GILDED_IRON_HELMET, SlimefunReloadedItems.GILDED_IRON_CHESTPLATE, SlimefunReloadedItems.GILDED_IRON_LEGGINGS, SlimefunReloadedItems.GILDED_IRON_BOOTS}, "GILDED_IRON", true, false);
SlimefunManager.registerArmorSet(SlimefunReloadedItems.GOLD_12K, new ItemStack[] {SlimefunReloadedItems.GOLD_HELMET, SlimefunReloadedItems.GOLD_CHESTPLATE, SlimefunReloadedItems.GOLD_LEGGINGS, SlimefunReloadedItems.GOLD_BOOTS}, "GOLD_12K", true, false);

     */
 /*
 new EnhancedCraftingTable().register();
new GrindStone().register();
		new ArmorForge().register();
		new OreCrusher().register();
		new Compressor().register();
 new Smeltery().register();
		new PressureChamber().register();
 new OreWasher().register();
 new TableSaw().register();
 new AutomatedPanningMachine().register();
		new MagicWorkbench().register();
 new Juicer().register();
     */
 /*
 Multi-tool
 String[] multiToolItems = new String[] {"PORTABLE_CRAFTER", "MAGIC_EYE_OF_ENDER", "STAFF_ELEMENTAL_WIND", "GRAPPLING_HOOK"};

		new MultiTool((SlimefunReloadedItemStack) SlimefunReloadedItems.DURALUMIN_MULTI_TOOL, RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {SlimefunReloadedItems.DURALUMIN_INGOT, null, SlimefunReloadedItems.DURALUMIN_INGOT, SlimefunReloadedItems.DURALUMIN_INGOT, SlimefunReloadedItems.SMALL_CAPACITOR, SlimefunReloadedItems.DURALUMIN_INGOT, null, SlimefunReloadedItems.DURALUMIN_INGOT, null},
		multiToolItems)
		.register(true);

		new MultiTool((SlimefunReloadedItemStack) SlimefunReloadedItems.SOLDER_MULTI_TOOL, RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {SlimefunReloadedItems.SOLDER_INGOT, null, SlimefunReloadedItems.SOLDER_INGOT, SlimefunReloadedItems.SOLDER_INGOT, SlimefunReloadedItems.SMALL_CAPACITOR, SlimefunReloadedItems.SOLDER_INGOT, null, SlimefunReloadedItems.SOLDER_INGOT, null},
		multiToolItems)
		.register(true);

		new MultiTool((SlimefunReloadedItemStack) SlimefunReloadedItems.BILLON_MULTI_TOOL, RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {SlimefunReloadedItems.BILLON_INGOT, null, SlimefunReloadedItems.BILLON_INGOT, SlimefunReloadedItems.BILLON_INGOT, SlimefunReloadedItems.SMALL_CAPACITOR, SlimefunReloadedItems.BILLON_INGOT, null, SlimefunReloadedItems.BILLON_INGOT, null},
		multiToolItems)
		.register(true);

		new MultiTool((SlimefunReloadedItemStack) SlimefunReloadedItems.STEEL_MULTI_TOOL, RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {SlimefunReloadedItems.STEEL_INGOT, null, SlimefunReloadedItems.STEEL_INGOT, SlimefunReloadedItems.STEEL_INGOT, SlimefunReloadedItems.SMALL_CAPACITOR, SlimefunReloadedItems.STEEL_INGOT, null, SlimefunReloadedItems.STEEL_INGOT, null},
		multiToolItems)
		.register(true);

		new MultiTool((SlimefunReloadedItemStack) SlimefunReloadedItems.DAMASCUS_STEEL_MULTI_TOOL, RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {SlimefunReloadedItems.DAMASCUS_STEEL_INGOT, null, SlimefunReloadedItems.DAMASCUS_STEEL_INGOT, SlimefunReloadedItems.DAMASCUS_STEEL_INGOT, SlimefunReloadedItems.SMALL_CAPACITOR, SlimefunReloadedItems.DAMASCUS_STEEL_INGOT, null, SlimefunReloadedItems.DAMASCUS_STEEL_INGOT, null},
		multiToolItems)
		.register(true);

		new MultiTool((SlimefunReloadedItemStack) SlimefunReloadedItems.REINFORCED_ALLOY_MULTI_TOOL, RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {SlimefunReloadedItems.REINFORCED_ALLOY_INGOT, null, SlimefunReloadedItems.REINFORCED_ALLOY_INGOT, SlimefunReloadedItems.REINFORCED_ALLOY_INGOT, SlimefunReloadedItems.MEDIUM_CAPACITOR, SlimefunReloadedItems.REINFORCED_ALLOY_INGOT, null, SlimefunReloadedItems.REINFORCED_ALLOY_INGOT, null},
		multiToolItems)
		.register(true);

		new MultiTool((SlimefunReloadedItemStack) SlimefunReloadedItems.CARBONADO_MULTI_TOOL, RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {SlimefunReloadedItems.CARBONADO, null, SlimefunReloadedItems.CARBONADO, SlimefunReloadedItems.CARBONADO, SlimefunReloadedItems.LARGE_CAPACITOR, SlimefunReloadedItems.CARBONADO, null, SlimefunReloadedItems.CARBONADO, null},
		"PORTABLE_CRAFTER", "MAGIC_EYE_OF_ENDER", "STAFF_ELEMENTAL_WIND", "GRAPPLING_HOOK", "GOLD_PAN", "NETHER_GOLD_PAN")
		.register(true);
     */
 /*
 new Talisman((SlimefunReloadedItemStack) SlimefunReloadedItems.TALISMAN_ANVIL,
		new ItemStack[] {SlimefunReloadedItems.MAGIC_LUMP_3, null, SlimefunReloadedItems.MAGIC_LUMP_3, new ItemStack(Material.ANVIL), SlimefunReloadedItems.TALISMAN, new ItemStack(Material.ANVIL), SlimefunReloadedItems.MAGIC_LUMP_3, null, SlimefunReloadedItems.MAGIC_LUMP_3},
		true, false, "anvil")
		.register(true);

		new Talisman((SlimefunReloadedItemStack) SlimefunReloadedItems.TALISMAN_MINER,
		new ItemStack[] {SlimefunReloadedItems.MAGIC_LUMP_3, null, SlimefunReloadedItems.MAGIC_LUMP_3, SlimefunReloadedItems.SYNTHETIC_SAPPHIRE, SlimefunReloadedItems.TALISMAN, SlimefunReloadedItems.SIFTED_ORE, SlimefunReloadedItems.MAGIC_LUMP_3, null, SlimefunReloadedItems.MAGIC_LUMP_3},
		false, false, "miner", 20)
		.register(true);

		new HunterTalisman((SlimefunReloadedItemStack) SlimefunReloadedItems.TALISMAN_HUNTER,
		new ItemStack[] {SlimefunReloadedItems.MAGIC_LUMP_3, null, SlimefunReloadedItems.MAGIC_LUMP_3, SlimefunReloadedItems.SYNTHETIC_SAPPHIRE, SlimefunReloadedItems.TALISMAN, SlimefunReloadedItems.MONSTER_JERKY, SlimefunReloadedItems.MAGIC_LUMP_3, null, SlimefunReloadedItems.MAGIC_LUMP_3},
		false, false, "hunter", 20)
		.register(true);

		new Talisman((SlimefunReloadedItemStack) SlimefunReloadedItems.TALISMAN_LAVA,
		new ItemStack[] {SlimefunReloadedItems.MAGIC_LUMP_3, null, SlimefunReloadedItems.MAGIC_LUMP_3, SlimefunReloadedItems.LAVA_CRYSTAL, SlimefunReloadedItems.TALISMAN, new ItemStack(Material.LAVA_BUCKET), SlimefunReloadedItems.MAGIC_LUMP_3, null, SlimefunReloadedItems.MAGIC_LUMP_3},
		true, true, "lava", new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 3600, 4))
		.register(true);

		new Talisman((SlimefunReloadedItemStack) SlimefunReloadedItems.TALISMAN_WATER,
		new ItemStack[] {SlimefunReloadedItems.MAGIC_LUMP_3, null, SlimefunReloadedItems.MAGIC_LUMP_3, new ItemStack(Material.WATER_BUCKET), SlimefunReloadedItems.TALISMAN, new ItemStack(Material.FISHING_ROD), SlimefunReloadedItems.MAGIC_LUMP_3, null, SlimefunReloadedItems.MAGIC_LUMP_3},
		true, true, "water", new PotionEffect(PotionEffectType.WATER_BREATHING, 3600, 4))
		.register(true);

		new Talisman((SlimefunReloadedItemStack) SlimefunReloadedItems.TALISMAN_ANGEL,
		new ItemStack[] {SlimefunReloadedItems.MAGIC_LUMP_3, null, SlimefunReloadedItems.MAGIC_LUMP_3, new ItemStack(Material.FEATHER), SlimefunReloadedItems.TALISMAN, new ItemStack(Material.FEATHER), SlimefunReloadedItems.MAGIC_LUMP_3, null, SlimefunReloadedItems.MAGIC_LUMP_3},
		false, true, "angel", 75)
		.register(true);

		new Talisman((SlimefunReloadedItemStack) SlimefunReloadedItems.TALISMAN_FIRE,
		new ItemStack[] {SlimefunReloadedItems.MAGIC_LUMP_3, null, SlimefunReloadedItems.MAGIC_LUMP_3, SlimefunReloadedItems.LAVA_CRYSTAL, SlimefunReloadedItems.TALISMAN, SlimefunReloadedItems.LAVA_CRYSTAL, SlimefunReloadedItems.MAGIC_LUMP_3, null, SlimefunReloadedItems.MAGIC_LUMP_3},
		true, true, "fire", new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 3600, 4))
		.register(true);

		new Talisman((SlimefunReloadedItemStack) SlimefunReloadedItems.TALISMAN_MAGICIAN,
		new ItemStack[] {SlimefunReloadedItems.ENDER_LUMP_3, null, SlimefunReloadedItems.ENDER_LUMP_3, new ItemStack(Material.ENCHANTING_TABLE), SlimefunReloadedItems.TALISMAN, new ItemStack(Material.ENCHANTING_TABLE), SlimefunReloadedItems.ENDER_LUMP_3, null, SlimefunReloadedItems.ENDER_LUMP_3},
		false, false, "magician", 80)
		.register(true);

		new Talisman((SlimefunReloadedItemStack) SlimefunReloadedItems.TALISMAN_TRAVELLER,
		new ItemStack[] {SlimefunReloadedItems.MAGIC_LUMP_3, null, SlimefunReloadedItems.MAGIC_LUMP_3, SlimefunReloadedItems.STAFF_WIND, SlimefunReloadedItems.TALISMAN_ANGEL, SlimefunReloadedItems.STAFF_WIND, SlimefunReloadedItems.MAGIC_LUMP_3, null, SlimefunReloadedItems.MAGIC_LUMP_3},
		false, false, "traveller", 60, new PotionEffect(PotionEffectType.SPEED, 3600, 2))
		.register(true);

		new Talisman((SlimefunReloadedItemStack) SlimefunReloadedItems.TALISMAN_WARRIOR,
		new ItemStack[] {SlimefunReloadedItems.MAGIC_LUMP_3, null, SlimefunReloadedItems.MAGIC_LUMP_3, SlimefunReloadedItems.REINFORCED_ALLOY_INGOT, SlimefunReloadedItems.TALISMAN, SlimefunReloadedItems.REINFORCED_ALLOY_INGOT, SlimefunReloadedItems.MAGIC_LUMP_3, null, SlimefunReloadedItems.MAGIC_LUMP_3},
		true, true, "warrior", new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 3600, 2))
		.register(true);

		new Talisman((SlimefunReloadedItemStack) SlimefunReloadedItems.TALISMAN_KNIGHT,
		new ItemStack[] {SlimefunReloadedItems.MAGIC_LUMP_3, null, SlimefunReloadedItems.MAGIC_LUMP_3, SlimefunReloadedItems.GILDED_IRON, SlimefunReloadedItems.TALISMAN_WARRIOR, SlimefunReloadedItems.GILDED_IRON, SlimefunReloadedItems.MAGIC_LUMP_3, null, SlimefunReloadedItems.MAGIC_LUMP_3},
		"knight", 30, new PotionEffect(PotionEffectType.REGENERATION, 100, 3))
		.register(true);
 new Talisman((SlimefunReloadedItemStack) SlimefunReloadedItems.TALISMAN_WHIRLWIND,
		new ItemStack[] {SlimefunReloadedItems.MAGIC_LUMP_3, null, SlimefunReloadedItems.MAGIC_LUMP_3, SlimefunReloadedItems.STAFF_WIND, SlimefunReloadedItems.TALISMAN_TRAVELLER, SlimefunReloadedItems.STAFF_WIND, SlimefunReloadedItems.MAGIC_LUMP_3, null, SlimefunReloadedItems.MAGIC_LUMP_3}
		, false, true, "whirlwind", 60)
		.register(true);

		new Talisman((SlimefunReloadedItemStack) SlimefunReloadedItems.TALISMAN_WIZARD,
		new ItemStack[] {SlimefunReloadedItems.ENDER_LUMP_3, null, SlimefunReloadedItems.ENDER_LUMP_3, SlimefunReloadedItems.MAGIC_EYE_OF_ENDER, SlimefunReloadedItems.TALISMAN_MAGICIAN, SlimefunReloadedItems.MAGIC_EYE_OF_ENDER, SlimefunReloadedItems.ENDER_LUMP_3, null, SlimefunReloadedItems.ENDER_LUMP_3},
		false, false, "wizard", 60)
		.register(true);
     */
    //JetBoots Registery
    registerJetBoots("duralumin_jetboots", (SlimefunReloadedItemStack) SlimefunReloadedItems.DURALUMIN_JETBOOTS, new ItemStack[]{null, null, null, SlimefunReloadedItems.DURALUMIN_INGOT, SlimefunReloadedItems.POWER_CRYSTAL, SlimefunReloadedItems.DURALUMIN_INGOT, SlimefunReloadedItems.STEEL_THRUSTER, SlimefunReloadedItems.SMALL_CAPACITOR, SlimefunReloadedItems.STEEL_THRUSTER}, 0.35);
    registerJetBoots("solder_jetboots", (SlimefunReloadedItemStack) SlimefunReloadedItems.SOLDER_JETBOOTS, new ItemStack[]{null, null, null, SlimefunReloadedItems.SOLDER_INGOT, SlimefunReloadedItems.POWER_CRYSTAL, SlimefunReloadedItems.SOLDER_INGOT, SlimefunReloadedItems.STEEL_THRUSTER, SlimefunReloadedItems.SMALL_CAPACITOR, SlimefunReloadedItems.STEEL_THRUSTER}, 0.4);
    registerJetBoots("billion_jetboots", (SlimefunReloadedItemStack) SlimefunReloadedItems.BILLON_JETBOOTS, new ItemStack[]{null, null, null, SlimefunReloadedItems.BILLON_INGOT, SlimefunReloadedItems.POWER_CRYSTAL, SlimefunReloadedItems.BILLON_INGOT, SlimefunReloadedItems.STEEL_THRUSTER, SlimefunReloadedItems.SMALL_CAPACITOR, SlimefunReloadedItems.STEEL_THRUSTER}, 0.45);
    registerJetBoots("steel_jetboots", (SlimefunReloadedItemStack) SlimefunReloadedItems.STEEL_JETBOOTS, new ItemStack[]{null, null, null, SlimefunReloadedItems.STEEL_INGOT, SlimefunReloadedItems.POWER_CRYSTAL, SlimefunReloadedItems.STEEL_INGOT, SlimefunReloadedItems.STEEL_THRUSTER, SlimefunReloadedItems.SMALL_CAPACITOR, SlimefunReloadedItems.STEEL_THRUSTER}, 0.5);
    registerJetBoots("damascus_steel_jetboots", (SlimefunReloadedItemStack) SlimefunReloadedItems.DAMASCUS_STEEL_JETBOOTS, new ItemStack[]{null, null, null, SlimefunReloadedItems.DAMASCUS_STEEL_INGOT, SlimefunReloadedItems.POWER_CRYSTAL, SlimefunReloadedItems.DAMASCUS_STEEL_INGOT, SlimefunReloadedItems.STEEL_THRUSTER, SlimefunReloadedItems.SMALL_CAPACITOR, SlimefunReloadedItems.STEEL_THRUSTER}, 0.55);
    registerJetBoots("reinforced_alloy_jetboots", (SlimefunReloadedItemStack) SlimefunReloadedItems.REINFORCED_ALLOY_JETBOOTS, new ItemStack[]{null, null, null, SlimefunReloadedItems.REINFORCED_ALLOY_INGOT, SlimefunReloadedItems.POWER_CRYSTAL, SlimefunReloadedItems.REINFORCED_ALLOY_INGOT, SlimefunReloadedItems.STEEL_THRUSTER, SlimefunReloadedItems.MEDIUM_CAPACITOR, SlimefunReloadedItems.STEEL_THRUSTER}, 0.6);
    registerJetBoots("carbonado_jetboots", (SlimefunReloadedItemStack) SlimefunReloadedItems.CARBONADO_JETBOOTS, new ItemStack[]{null, null, null, SlimefunReloadedItems.CARBONADO, SlimefunReloadedItems.POWER_CRYSTAL, SlimefunReloadedItems.CARBONADO, SlimefunReloadedItems.STEEL_THRUSTER, SlimefunReloadedItems.LARGE_CAPACITOR, SlimefunReloadedItems.STEEL_THRUSTER}, 0.7);
    registerJetBoots("armored_jetboots", (SlimefunReloadedItemStack) SlimefunReloadedItems.ARMORED_JETBOOTS, new ItemStack[]{null, null, null, SlimefunReloadedItems.STEEL_PLATE, SlimefunReloadedItems.POWER_CRYSTAL, SlimefunReloadedItems.STEEL_PLATE, SlimefunReloadedItems.STEEL_THRUSTER, SlimefunReloadedItems.MEDIUM_CAPACITOR, SlimefunReloadedItems.STEEL_THRUSTER}, 0.45);
    //EnchancedFurnace Registery
    registerEnhancedFurnace("enchanced_furnace", (SlimefunReloadedItemStack) SlimefunReloadedItems.ENHANCED_FURNACE, new ItemStack[]{null, SlimefunReloadedItems.BASIC_CIRCUIT_BOARD, null, SlimefunReloadedItems.HEATING_COIL, new ItemStack(Material.FURNACE), SlimefunReloadedItems.HEATING_COIL, null, SlimefunReloadedItems.ELECTRIC_MOTOR, null}, 1, 1, 1);
    registerEnhancedFurnace("enhanced_furnace_2", (SlimefunReloadedItemStack) SlimefunReloadedItems.ENHANCED_FURNACE_2, new ItemStack[]{null, SlimefunReloadedItems.BASIC_CIRCUIT_BOARD, null, SlimefunReloadedItems.HEATING_COIL, SlimefunReloadedItems.ENHANCED_FURNACE, SlimefunReloadedItems.HEATING_COIL, null, SlimefunReloadedItems.ELECTRIC_MOTOR, null}, 2, 1, 1);
    registerEnhancedFurnace("enhanced_furnace_3", (SlimefunReloadedItemStack) SlimefunReloadedItems.ENHANCED_FURNACE_3, new ItemStack[]{null, SlimefunReloadedItems.BASIC_CIRCUIT_BOARD, null, SlimefunReloadedItems.HEATING_COIL, SlimefunReloadedItems.ENHANCED_FURNACE_2, SlimefunReloadedItems.HEATING_COIL, null, SlimefunReloadedItems.ELECTRIC_MOTOR, null}, 2, 2, 1);
    registerEnhancedFurnace("enhanced_furnace_4", (SlimefunReloadedItemStack) SlimefunReloadedItems.ENHANCED_FURNACE_4, new ItemStack[]{null, SlimefunReloadedItems.BASIC_CIRCUIT_BOARD, null, SlimefunReloadedItems.HEATING_COIL, SlimefunReloadedItems.ENHANCED_FURNACE_3, SlimefunReloadedItems.HEATING_COIL, null, SlimefunReloadedItems.ELECTRIC_MOTOR, null}, 3, 2, 1);
    registerEnhancedFurnace("enhanced_furnace_5", (SlimefunReloadedItemStack) SlimefunReloadedItems.ENHANCED_FURNACE_5, new ItemStack[]{null, SlimefunReloadedItems.BASIC_CIRCUIT_BOARD, null, SlimefunReloadedItems.HEATING_COIL, SlimefunReloadedItems.ENHANCED_FURNACE_4, SlimefunReloadedItems.HEATING_COIL, null, SlimefunReloadedItems.ELECTRIC_MOTOR, null}, 3, 2, 2);
    registerEnhancedFurnace("enhanced_furnace_6", (SlimefunReloadedItemStack) SlimefunReloadedItems.ENHANCED_FURNACE_6, new ItemStack[]{null, SlimefunReloadedItems.BASIC_CIRCUIT_BOARD, null, SlimefunReloadedItems.HEATING_COIL, SlimefunReloadedItems.ENHANCED_FURNACE_5, SlimefunReloadedItems.HEATING_COIL, null, SlimefunReloadedItems.ELECTRIC_MOTOR, null}, 3, 3, 2);
    registerEnhancedFurnace("enhanced_furnace_7", (SlimefunReloadedItemStack) SlimefunReloadedItems.ENHANCED_FURNACE_7, new ItemStack[]{null, SlimefunReloadedItems.BASIC_CIRCUIT_BOARD, null, SlimefunReloadedItems.HEATING_COIL, SlimefunReloadedItems.ENHANCED_FURNACE_6, SlimefunReloadedItems.HEATING_COIL, null, SlimefunReloadedItems.ELECTRIC_MOTOR, null}, 4, 3, 2);
    registerEnhancedFurnace("enhanced_furnace_8", (SlimefunReloadedItemStack) SlimefunReloadedItems.ENHANCED_FURNACE_8, new ItemStack[]{null, SlimefunReloadedItems.BASIC_CIRCUIT_BOARD, null, SlimefunReloadedItems.HEATING_COIL, SlimefunReloadedItems.ENHANCED_FURNACE_7, SlimefunReloadedItems.HEATING_COIL, null, SlimefunReloadedItems.ELECTRIC_MOTOR, null}, 4, 4, 2);
    registerEnhancedFurnace("enhanced_furnace_9", (SlimefunReloadedItemStack) SlimefunReloadedItems.ENHANCED_FURNACE_9, new ItemStack[]{null, SlimefunReloadedItems.BASIC_CIRCUIT_BOARD, null, SlimefunReloadedItems.HEATING_COIL, SlimefunReloadedItems.ENHANCED_FURNACE_8, SlimefunReloadedItems.HEATING_COIL, null, SlimefunReloadedItems.ELECTRIC_MOTOR, null}, 5, 4, 2);
    registerEnhancedFurnace("enhanced_furnace_10", (SlimefunReloadedItemStack) SlimefunReloadedItems.ENHANCED_FURNACE_10, new ItemStack[]{null, SlimefunReloadedItems.BASIC_CIRCUIT_BOARD, null, SlimefunReloadedItems.HEATING_COIL, SlimefunReloadedItems.ENHANCED_FURNACE_9, SlimefunReloadedItems.HEATING_COIL, null, SlimefunReloadedItems.ELECTRIC_MOTOR, null}, 5, 5, 2);
    registerEnhancedFurnace("enhanced_furnace_11", (SlimefunReloadedItemStack) SlimefunReloadedItems.ENHANCED_FURNACE_11, new ItemStack[]{null, SlimefunReloadedItems.BASIC_CIRCUIT_BOARD, null, SlimefunReloadedItems.HEATING_COIL, SlimefunReloadedItems.ENHANCED_FURNACE_10, SlimefunReloadedItems.HEATING_COIL, null, SlimefunReloadedItems.ELECTRIC_MOTOR, null}, 5, 5, 3);
    registerEnhancedFurnace("reinforced_furnace", (SlimefunReloadedItemStack) SlimefunReloadedItems.REINFORCED_FURNACE, new ItemStack[]{SlimefunReloadedItems.REINFORCED_ALLOY_INGOT, SlimefunReloadedItems.BASIC_CIRCUIT_BOARD, SlimefunReloadedItems.REINFORCED_ALLOY_INGOT, SlimefunReloadedItems.HEATING_COIL, SlimefunReloadedItems.ENHANCED_FURNACE_11, SlimefunReloadedItems.HEATING_COIL, SlimefunReloadedItems.REINFORCED_ALLOY_INGOT, SlimefunReloadedItems.ELECTRIC_MOTOR, SlimefunReloadedItems.REINFORCED_ALLOY_INGOT}, 10, 10, 3);
    registerEnhancedFurnace("carbonado_edged_furnace", (SlimefunReloadedItemStack) SlimefunReloadedItems.CARBONADO_EDGED_FURNACE, new ItemStack[]{SlimefunReloadedItems.CARBONADO, SlimefunReloadedItems.BASIC_CIRCUIT_BOARD, SlimefunReloadedItems.CARBONADO, SlimefunReloadedItems.HEATING_COIL, SlimefunReloadedItems.REINFORCED_FURNACE, SlimefunReloadedItems.HEATING_COIL, SlimefunReloadedItems.CARBONADO, SlimefunReloadedItems.ELECTRIC_MOTOR, SlimefunReloadedItems.CARBONADO}, 20, 10, 3);
  }

  public static void registerEnhancedFurnace(String namespace, ItemStack item, ItemStack[] recipe, int speed, int efficiency, int fortune) {
    register(new EnchancedFurnace(new NamespacedKey(plugin, namespace), item, recipe, speed, efficiency, fortune));
  }

  public static void registerJuice(String namespace, Category category, ItemStack item, RecipeType type,
   ItemStack[] recipe) {
    register(new SlimefunReloadedJuice(new NamespacedKey(plugin, namespace), category, item, type, recipe));
  }

  public static void registerMeatJerky(String namespace, Category category, ItemStack item, RecipeType type,
   ItemStack[] recipe) {
    register(new MeatJerky(new NamespacedKey(plugin, namespace), category, item, type, recipe, 0));
  }

  public static void registerBackpack(String namespace, Category category, SlimefunReloadedItemStack item, RecipeType type,
   ItemStack[] recipe, int size) {
    register(new SlimefunReloadedBackpack(new NamespacedKey(plugin, namespace), category, item, recipe, size));
  }

  public static void registerSoulboundItem(String namespace, Category category, SlimefunReloadedItemStack item,
   ItemStack[] recipe) {
    register(new SoulboundItem(new NamespacedKey(plugin, namespace), category, item, recipe));
  }

  private static void registerSoulboundItem(String namespace, Category category, ItemStack item,
   RecipeType recipeType, ItemStack[] recipe) {
    register(new SoulboundItem(new NamespacedKey(plugin, namespace), category, item, recipeType, recipe));
  }

  public static void registerSimpleSlimefunReloadedItem(String namespace, Category category, ItemStack item, RecipeType type,
   ItemStack[] recipe, String[] keys, Object[] values) {
    register(new SimpleSlimefunReloadedItem(new NamespacedKey(plugin, namespace), category, item, type, recipe, keys, values));
  }

  public static void registerSimpleSlimefunReloadedItem(String namespace, Category category, ItemStack item, RecipeType type,
   ItemStack[] recipe) {
    register(new SimpleSlimefunReloadedItem(new NamespacedKey(plugin, namespace), category, item, type, recipe));
  }

  public static void registerSimpleSlimefunReloadedItem(String namespace, Category category, ItemStack item, RecipeType type,
   ItemStack[] recipe, CustomItem customItem) {
    register(new SimpleSlimefunReloadedItem(new NamespacedKey(plugin, namespace), category, item, type, recipe, customItem));
  }

  public static void registerSlimefunReloadedArmorPiece(String namespace, Category category, ItemStack item, RecipeType type,
   ItemStack[] recipe, PotionEffect[] effects) {
    register(new SlimefunReloadedArmorPiece(new NamespacedKey(plugin, namespace), category, item, type, recipe, effects));
  }

  public static void registerSlimefunReloadedAlloy(String namespace, ItemStack item, ItemStack[] recipe) {
//    register(new Alloy(new NamespacedKey(plugin, namespace), item, recipe));
  }

  private static void registerSlimefunReloadedAlloy(String namespace, Category category, ItemStack itemStack,
   ItemStack[] recipe) {
    register(new Alloy(new NamespacedKey(plugin, namespace), category, itemStack, RecipeType.MAGIC_WORKBENCH, recipe));
  }

  public static void registerJetBoots(String namespace, ItemStack item, ItemStack[] recipe, double speed) {
    register(new JetBoots(new NamespacedKey(plugin, namespace), item, recipe, speed));
  }

  public static void registerJetpack(String namespace, ItemStack item, ItemStack[] recipe, double speed) {
    register(new Jetpack(new NamespacedKey(plugin, namespace), item, recipe, speed));
  }

  public static void register(SlimefunReloadedComponent component) {
    COMPONENT_MANAGER.addComponent(component);
  }

}
