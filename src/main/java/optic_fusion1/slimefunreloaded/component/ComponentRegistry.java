package optic_fusion1.slimefunreloaded.component;

import optic_fusion1.slimefunreloaded.Slimefun;
import optic_fusion1.slimefunreloaded.SlimefunReloaded;
import optic_fusion1.slimefunreloaded.category.CategoryManager;
import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.component.item.SlimefunReloadedBackpack;
import optic_fusion1.slimefunreloaded.component.item.impl.PortableCrafter;
import optic_fusion1.slimefunreloaded.component.item.impl.SimpleSlimefunReloadedItem;
import optic_fusion1.slimefunreloaded.component.item.impl.SoulboundItem;
import optic_fusion1.slimefunreloaded.component.item.impl.Vitamins;
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
    registerBackpack("backpack_small", PORTABLE, (SlimefunReloadedItemStack) SlimefunReloadedItems.BACKPACK_SMALL, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{new ItemStack(Material.LEATHER), null, new ItemStack(Material.LEATHER), SlimefunReloadedItems.GOLD_6K, new ItemStack(Material.CHEST), SlimefunReloadedItems.GOLD_6K, new ItemStack(Material.LEATHER), new ItemStack(Material.LEATHER), new ItemStack(Material.LEATHER)}, 9);
    registerBackpack("backpack_medium", PORTABLE, (SlimefunReloadedItemStack) SlimefunReloadedItems.BACKPACK_MEDIUM, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{new ItemStack(Material.LEATHER), null, new ItemStack(Material.LEATHER), SlimefunReloadedItems.GOLD_10K, SlimefunReloadedItems.BACKPACK_SMALL, SlimefunReloadedItems.GOLD_10K, new ItemStack(Material.LEATHER), new ItemStack(Material.LEATHER), new ItemStack(Material.LEATHER)}, 18);
    registerBackpack("backpack_large", PORTABLE, (SlimefunReloadedItemStack) SlimefunReloadedItems.BACKPACK_MEDIUM, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{new ItemStack(Material.LEATHER), null, new ItemStack(Material.LEATHER), SlimefunReloadedItems.GOLD_14K, SlimefunReloadedItems.BACKPACK_MEDIUM, SlimefunReloadedItems.GOLD_14K, new ItemStack(Material.LEATHER), new ItemStack(Material.LEATHER), new ItemStack(Material.LEATHER)}, 27);
    registerBackpack("backpack_cloth", PORTABLE, (SlimefunReloadedItemStack) SlimefunReloadedItems.BACKPACK_MEDIUM, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{SlimefunReloadedItems.CLOTH, null, SlimefunReloadedItems.CLOTH, SlimefunReloadedItems.GOLD_16K, SlimefunReloadedItems.BACKPACK_LARGE, SlimefunReloadedItems.GOLD_16K, SlimefunReloadedItems.CLOTH, SlimefunReloadedItems.CLOTH, SlimefunReloadedItems.CLOTH}, 36);
    registerBackpack("backpack_gilded", PORTABLE, (SlimefunReloadedItemStack) SlimefunReloadedItems.BACKPACK_MEDIUM, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{SlimefunReloadedItems.GOLD_22K, null, SlimefunReloadedItems.GOLD_22K, new ItemStack(Material.LEATHER), SlimefunReloadedItems.WOVEN_BACKPACK, new ItemStack(Material.LEATHER), SlimefunReloadedItems.GOLD_22K, null, SlimefunReloadedItems.GOLD_22K}, 45);
    registerBackpack("backpack_radiant", PORTABLE, (SlimefunReloadedItemStack) SlimefunReloadedItems.BACKPACK_MEDIUM, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{SlimefunReloadedItems.GOLD_24K, null, SlimefunReloadedItems.GOLD_24K, new ItemStack(Material.LEATHER), SlimefunReloadedItems.GILDED_BACKPACK, new ItemStack(Material.LEATHER), SlimefunReloadedItems.GOLD_24K, null, SlimefunReloadedItems.GOLD_24K}, 54);
    register(new Vitamins(new NamespacedKey(plugin, "vitamins"), PORTABLE, (SlimefunReloadedItemStack) SlimefunReloadedItems.VITAMINS, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {SlimefunReloadedItems.CAN, new ItemStack(Material.APPLE), new ItemStack(Material.RED_MUSHROOM), new ItemStack(Material.SUGAR), null, null, null, null, null}));
    /*
		new SlimefunItem(Categories.PORTABLE, (SlimefunItemStack) SlimefunReloadedItems.MEDICINE, RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {SlimefunReloadedItems.VITAMINS, new ItemStack(Material.GLASS_BOTTLE), SlimefunReloadedItems.HEAVY_CREAM, null, null, null, null, null, null})
		.register(true, new ItemConsumptionHandler() {
			
			@Override
			public boolean onConsume(PlayerItemConsumeEvent e, Player p, ItemStack item) {
				if (SlimefunManager.isItemSimiliar(item, SlimefunReloadedItems.MEDICINE, true)) {
					if (p.hasPotionEffect(PotionEffectType.POISON)) p.removePotionEffect(PotionEffectType.POISON);
					if (p.hasPotionEffect(PotionEffectType.WITHER)) p.removePotionEffect(PotionEffectType.WITHER);
					if (p.hasPotionEffect(PotionEffectType.SLOW)) p.removePotionEffect(PotionEffectType.SLOW);
					if (p.hasPotionEffect(PotionEffectType.SLOW_DIGGING)) p.removePotionEffect(PotionEffectType.SLOW_DIGGING);
					if (p.hasPotionEffect(PotionEffectType.WEAKNESS)) p.removePotionEffect(PotionEffectType.WEAKNESS);
					if (p.hasPotionEffect(PotionEffectType.CONFUSION)) p.removePotionEffect(PotionEffectType.CONFUSION);
					if (p.hasPotionEffect(PotionEffectType.BLINDNESS)) p.removePotionEffect(PotionEffectType.BLINDNESS);
					
					p.setFireTicks(0);
					return true;
				}
				else return false;
			}
		});

     */
 /*
    new SlimefunItem(Categories.PORTABLE, (SlimefunItemStack) SlimefunReloadedItems.SPLINT, RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {null, new ItemStack(Material.IRON_INGOT), null, new ItemStack(Material.STICK), new ItemStack(Material.STICK), new ItemStack(Material.STICK), null, new ItemStack(Material.IRON_INGOT), null},
		new CustomItem(SlimefunReloadedItems.SPLINT, 4), new String[] {"enable-broken-legs"}, new Boolean[] {true})
		.register(true, new ItemInteractionHandler() {

			@Override
			public boolean onRightClick(ItemUseEvent e, Player p, ItemStack item) {
				if (SlimefunManager.isItemSimiliar(item, SlimefunReloadedItems.SPLINT, true)) {
					if (p.getGameMode() != GameMode.CREATIVE) ItemUtils.consumeItem(item, false);
					p.getWorld().playSound(p.getLocation(), Sound.ENTITY_SKELETON_HURT, 1, 1);
					p.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 1, 0));
					return true;
				}
				else return false;
			}
		});
     */
 /*
    new SlimefunItem(Categories.PORTABLE, (SlimefunItemStack) SlimefunReloadedItems.BANDAGE, RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {SlimefunReloadedItems.RAG, new ItemStack(Material.STRING), SlimefunReloadedItems.RAG, null, null, null, null, null, null},
		new CustomItem(SlimefunReloadedItems.BANDAGE, 4), new String[] {"enable-bleeding"}, new Boolean[] {true})
		.register(true, new ItemInteractionHandler() {

			@Override
			public boolean onRightClick(ItemUseEvent e, Player p, ItemStack item) {
				if (SlimefunManager.isItemSimiliar(item, SlimefunReloadedItems.BANDAGE, true)) {
					if (p.getGameMode() != GameMode.CREATIVE) ItemUtils.consumeItem(item, false);
					p.getWorld().playEffect(p.getLocation(), Effect.STEP_SOUND, Material.WHITE_WOOL);
					p.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 1, 1));
					p.setFireTicks(0);
					return true;
				}
				else return false;
			}
		});
     */
 /*
    new SlimefunItem(Categories.PORTABLE, (SlimefunItemStack) SlimefunReloadedItems.RAG, RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {SlimefunReloadedItems.CLOTH, SlimefunReloadedItems.CLOTH, SlimefunReloadedItems.CLOTH, new ItemStack(Material.STRING), null, new ItemStack(Material.STRING), SlimefunReloadedItems.CLOTH, SlimefunReloadedItems.CLOTH, SlimefunReloadedItems.CLOTH})
		.register(true, new ItemInteractionHandler() {

			@Override
			public boolean onRightClick(ItemUseEvent e, Player p, ItemStack item) {
				if (SlimefunManager.isItemSimiliar(item, SlimefunReloadedItems.RAG, true)) {
					if (p.getGameMode() != GameMode.CREATIVE) ItemUtils.consumeItem(item, false);
					p.getWorld().playEffect(p.getLocation(), Effect.STEP_SOUND, Material.WHITE_WOOL);
					p.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 1, 0));
					p.setFireTicks(0);
					return true;
				}
				else return false;
			}
		});
     */
 /*
    
		new PortableDustbin(Categories.PORTABLE, (SlimefunItemStack) SlimefunReloadedItems.PORTABLE_DUSTBIN, RecipeType.ENHANCED_CRAFTING_TABLE,
		new ItemStack[] {new ItemStack(Material.IRON_INGOT), new ItemStack(Material.IRON_INGOT), new ItemStack(Material.IRON_INGOT), new ItemStack(Material.IRON_INGOT), null, new ItemStack(Material.IRON_INGOT), new ItemStack(Material.IRON_INGOT), new ItemStack(Material.IRON_INGOT), new ItemStack(Material.IRON_INGOT)})
		.register(true);
     */
  }

  private static void registerBackpack(String namespace, Category category, SlimefunReloadedItemStack item, RecipeType type, ItemStack[] recipe, int size) {
    register(new SlimefunReloadedBackpack(new NamespacedKey(plugin, namespace), category, item, type, recipe, size));
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

  private static void register(SlimefunReloadedComponent component) {
    COMPONENT_MANAGER.registerComponent(component);
  }

}
