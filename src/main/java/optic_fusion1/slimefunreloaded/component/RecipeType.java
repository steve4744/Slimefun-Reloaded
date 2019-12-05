package optic_fusion1.slimefunreloaded.component;

import java.util.ArrayList;
import java.util.List;
import optic_fusion1.slimefunreloaded.Slimefun;
import optic_fusion1.slimefunreloaded.component.ComponentManager;
import optic_fusion1.slimefunreloaded.component.SlimefunReloadedComponent;
import optic_fusion1.slimefunreloaded.component.item.SlimefunReloadedGadget;
import optic_fusion1.slimefunreloaded.component.machine.SlimefunReloadedMachine;
import optic_fusion1.slimefunreloaded.recipe.MinecraftRecipe;
import optic_fusion1.slimefunreloaded.util.CustomItem;
import optic_fusion1.slimefunreloaded.util.SlimefunReloadedItemStack;
import optic_fusion1.slimefunreloaded.util.SlimefunReloadedItems;
import optic_fusion1.slimefunreloaded.util.SlimefunReloadedRecipes;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class RecipeType {

  public static final RecipeType MULTIBLOCK = new RecipeType(new CustomItem(Material.BRICKS, "&bMultiBlock", "", "&a&oBuild it in the World"));
  public static final RecipeType ARMOR_FORGE = new RecipeType((SlimefunReloadedItemStack) SlimefunReloadedItems.ARMOR_FORGE, "", "&a&oCraft it in an Armor Forge");
  public static final RecipeType GRIND_STONE = new RecipeType((SlimefunReloadedItemStack) SlimefunReloadedItems.GRIND_STONE, "", "&a&oGrind it using the Grind Stone");
  public static final RecipeType MOB_DROP = new RecipeType(new CustomItem(Material.IRON_SWORD, "&bMob Drop", "", "&a&oKill the specified Mob to obtain this Item"));
  public static final RecipeType SMELTERY = new RecipeType((SlimefunReloadedItemStack) SlimefunReloadedItems.SMELTERY, "", "&a&oSmelt it using a Smeltery");
  public static final RecipeType ORE_CRUSHER = new RecipeType((SlimefunReloadedItemStack) SlimefunReloadedItems.ORE_CRUSHER, "", "&a&oCrush it using the Ore Crusher");
  public static final RecipeType GOLD_PAN = new RecipeType((SlimefunReloadedItemStack) SlimefunReloadedItems.GOLD_PAN, "", "&a&oUse a Gold Pan on Gravel to obtain this Item");
  public static final RecipeType COMPRESSOR = new RecipeType((SlimefunReloadedItemStack) SlimefunReloadedItems.COMPRESSOR, "", "&a&oCompress it using the Compressor");
  public static final RecipeType PRESSURE_CHAMBER = new RecipeType((SlimefunReloadedItemStack) SlimefunReloadedItems.PRESSURE_CHAMBER, "", "&a&oCompress it using the Pressure Chamber");
  public static final RecipeType MAGIC_WORKBENCH = new RecipeType((SlimefunReloadedItemStack) SlimefunReloadedItems.MAGIC_WORKBENCH, "", "&a&oCraft it in a Magic Workbench");
  public static final RecipeType ORE_WASHER = new RecipeType((SlimefunReloadedItemStack) SlimefunReloadedItems.ORE_WASHER, "", "&a&oWash it in an Ore Washer");
  public static final RecipeType ENHANCED_CRAFTING_TABLE = new RecipeType((SlimefunReloadedItemStack) SlimefunReloadedItems.ENHANCED_CRAFTING_TABLE, "", "&a&oA regular Crafting Table cannot", "&a&ohold this massive Amount of Power...");
  public static final RecipeType JUICER = new RecipeType((SlimefunReloadedItemStack) SlimefunReloadedItems.JUICER, "", "&a&oUsed for Juice Creation");
  public static final RecipeType ANCIENT_ALTAR = new RecipeType((SlimefunReloadedItemStack) SlimefunReloadedItems.ANCIENT_ALTAR, "", "&dYou will need to craft this Item", "&dby performing an Ancient Altar Ritual");
  public static final RecipeType HEATED_PRESSURE_CHAMBER = new RecipeType((SlimefunReloadedItemStack) SlimefunReloadedItems.HEATED_PRESSURE_CHAMBER, "", "&a&oCraft this Item in a", "&a&oHeated Pressure Chamber");

  public static final RecipeType SHAPED_RECIPE = new RecipeType(new CustomItem(Material.CRAFTING_TABLE, "&eShaped Recipe", "", "&a&oJust a standard Recipe in the Workbench..."));
  public static final RecipeType SHAPELESS_RECIPE = new RecipeType(new CustomItem(Material.CRAFTING_TABLE, "&eShapeless Recipe", "", "&a&oJust a standard Recipe in the Workbench..."));
  public static final RecipeType FURNACE = new RecipeType(new CustomItem(Material.FURNACE, "&eFurnace Recipe", "", "&a&oJust smelt it in a regular Furnace"));
  public static final RecipeType NULL = new RecipeType((ItemStack) null);
  private static final ComponentManager COMPONENT_MANAGER = Slimefun.getComponentManager();

  private final ItemStack item;
  private final String machine;

  public RecipeType(ItemStack item, String machine) {
    this.item = item;
    this.machine = machine;
  }

  public RecipeType(SlimefunReloadedItemStack slimefunItem, String... lore) {
    this.item = new CustomItem(slimefunItem, null, lore);
    this.machine = slimefunItem.getItemID();
  }

  public RecipeType(ItemStack item) {
    this(item, "");
  }

  public RecipeType(MinecraftRecipe<?> recipe) {
    this(new ItemStack(recipe.getMachine()));
  }

  public RecipeType(String machine, int seconds, ItemStack[] input, ItemStack[] output) {
    this.machine = machine;
    this.item = getMachine().getItem();

    SlimefunReloadedRecipes.registerMachineRecipe(machine, seconds, input, output);
  }

  public ItemStack toItem() {
    return this.item;
  }

  public SlimefunReloadedComponent getMachine() {
    return COMPONENT_MANAGER.getComponentByNamespace(machine);
  }

  public static List<ItemStack> getRecipeInputs(SlimefunReloadedComponent machine) {
    if (machine == null) {
      return new ArrayList<>();
    }
    List<ItemStack[]> recipes = (machine instanceof SlimefunReloadedMachine ? ((SlimefunReloadedMachine) machine).getRecipes() : ((SlimefunReloadedGadget) machine).getRecipes());
    List<ItemStack> convertible = new ArrayList<>();
    for (int i = 0; i < recipes.size(); i++) {
      if (i % 2 == 0) {
        convertible.add(recipes.get(i)[0]);
      }
    }
    return convertible;
  }

  public static List<ItemStack[]> getRecipeInputList(SlimefunReloadedComponent machine) {
    if (machine == null) {
      return new ArrayList<>();
    }
    List<ItemStack[]> recipes = (machine instanceof SlimefunReloadedMachine ? ((SlimefunReloadedMachine) machine).getRecipes() : ((SlimefunReloadedGadget) machine).getRecipes());
    List<ItemStack[]> convertible = new ArrayList<>();
    for (int i = 0; i < recipes.size(); i++) {
      if (i % 2 == 0) {
        convertible.add(recipes.get(i));
      }
    }
    return convertible;
  }

  public static ItemStack getRecipeOutput(SlimefunReloadedComponent machine, ItemStack input) {
    List<ItemStack[]> recipes = (machine instanceof SlimefunReloadedMachine ? ((SlimefunReloadedMachine) machine).getRecipes() : ((SlimefunReloadedGadget) machine).getRecipes());
    return recipes.get(((getRecipeInputs(machine).indexOf(input) * 2) + 1))[0].clone();
  }

  public static ItemStack getRecipeOutputList(SlimefunReloadedComponent machine, ItemStack[] input) {
    List<ItemStack[]> recipes = (machine instanceof SlimefunReloadedMachine ? ((SlimefunReloadedMachine) machine).getRecipes() : ((SlimefunReloadedGadget) machine).getRecipes());
    return recipes.get(((getRecipeInputList(machine).indexOf(input) * 2) + 1))[0];
  }
}
