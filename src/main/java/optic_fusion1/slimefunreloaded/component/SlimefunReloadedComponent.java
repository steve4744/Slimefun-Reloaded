package optic_fusion1.slimefunreloaded.component;

import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import optic_fusion1.slimefunreloaded.Slimefun;
import optic_fusion1.slimefunreloaded.category.CategoryManager;

import org.bukkit.Keyed;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.component.item.VanillaItem;
import optic_fusion1.slimefunreloaded.research.Research;
import optic_fusion1.slimefunreloaded.util.Config;
import org.bukkit.Bukkit;
import org.bukkit.World;

/**
 * Represents a base for all slimefun components in the mod including items, blocks and multiblocks.
 *
 * @author Parker "Choco" Hawke
 * //TODO: Finish & clean this class up see me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem for the Slimefun equivalent of this class
 */
public abstract class SlimefunReloadedComponent implements Keyed {

  private static final Config ITEM_CONFIG = Slimefun.getItemsConfig();
  private static final ComponentManager COMPONENT_MANAGER = Slimefun.getComponentManager();
  private final NamespacedKey key;
  private ComponentState state;
  private final Category category;
  private final ItemStack item;
  private RecipeType recipeType;
  private ItemStack[] recipe;
  private boolean ticking = false;
  private Research research;
  private String[] keys;
  private Object[] values;
  protected boolean enchantable = true;
  protected boolean disenchantable = true;
  protected boolean hidden = false;
  protected boolean useableInWorkbench = false;
  private String permission = "";
  private List<String> noPermissionTooltip;
  private ItemStack recipeOutput;

  protected SlimefunReloadedComponent(NamespacedKey key, Category category, ItemStack item, RecipeType recipeType, ItemStack[] recipe) {
    this.key = key;
    this.category = category;
    this.item = item.clone();
    this.recipeType = recipeType;
    this.recipe = recipe.clone();
    String componentKey = key.getKey();
    if (COMPONENT_MANAGER.getComponentByKey(componentKey) != null) {
      throw new IllegalArgumentException("ID \"" + componentKey + "\" already exists");
    }
    if (this.recipe.length < 9) {
      this.recipe = new ItemStack[]{null, null, null, null, null, null, null, null, null};
    }
    ITEM_CONFIG.setDefaultValue(componentKey + ".enabled", true);
    ITEM_CONFIG.setDefaultValue(componentKey + ".can-be-used-in-workbenches", useableInWorkbench);
    ITEM_CONFIG.setDefaultValue(componentKey + ".hide-in-guide", hidden);
    ITEM_CONFIG.setDefaultValue(componentKey + ".allow-enchanting", enchantable);
    ITEM_CONFIG.setDefaultValue(componentKey + ".allow-disenchanting", disenchantable);
    ITEM_CONFIG.setDefaultValue(componentKey + ".required-permission", permission);
    ITEM_CONFIG.setDefaultValue(componentKey + ".no-permission-tooltip", new String[]{"&4&lLOCKED", "", "&rYou do not have Permission", "&rto access this Item"});
    ITEM_CONFIG.save();
    Config whitelistConfig = Slimefun.getWhitelistConfig();
    for (World world : Bukkit.getWorlds()) {
      whitelistConfig.setDefaultValue(world.getName() + ".enabled", true);
      whitelistConfig.setDefaultValue(world.getName() + ".enabled-items." + componentKey, true);
      whitelistConfig.save();
    }
    if (this.ticking && !Slimefun.getCfg().getBoolean("URID.enable-tickers")) {
      this.state = ComponentState.DISABLED;
      return;
    }
    if (ITEM_CONFIG.getBoolean(componentKey + ".enabled")) {
      CategoryManager categoryManager = Slimefun.getCategoryManager();
      if (!categoryManager.getCategories().contains(category)) {
        if (category != null) {
          categoryManager.addCategory(category);
        }
      }
      this.state = ComponentState.ENABLED;
      this.useableInWorkbench = ITEM_CONFIG.getBoolean(componentKey + ".can-be-used-in-workbenches");
      this.hidden = ITEM_CONFIG.getBoolean(componentKey + ".hide-in-guide");
      this.enchantable = ITEM_CONFIG.getBoolean(componentKey + ".allow-enchanting");
      this.disenchantable = ITEM_CONFIG.getBoolean(componentKey + ".allow-disenchanting");
      this.permission = ITEM_CONFIG.getString(componentKey + ".required-permission");
      this.noPermissionTooltip = ITEM_CONFIG.getStringList(componentKey + ".no-permission-tooltip");
      COMPONENT_MANAGER.addEnabledComponent(this);
    } else {
      if (this instanceof VanillaItem) {
        this.state = ComponentState.VANILLA;
      } else {
        this.state = ComponentState.DISABLED;
      }
    }
    if (Slimefun.getSlimefunReloaded().isPrintOutLoading()) {
      Slimefun.getLogger().log(Level.INFO, "Loaded Item \"{0}\"", key.getKey());
    }
  }

  protected SlimefunReloadedComponent(NamespacedKey key, Category category, ItemStack item, RecipeType recipeType, ItemStack[] recipe, String[] keys, Object[] values) {
    this(key, category, item, recipeType, recipe);
    this.keys = keys;
    this.values = values;
    String componentKey = key.getKey();
    if (this.keys != null && this.values != null) {
      for (int i = 0; i < this.keys.length; i++) {
        ITEM_CONFIG.setDefaultValue(componentKey + '.' + this.keys[i], this.values[i]);
      }
    }
    ITEM_CONFIG.save();
  }

  protected SlimefunReloadedComponent(NamespacedKey key, Category category, ItemStack item, RecipeType recipeType, ItemStack[] recipe, ItemStack recipeOutput) {
    this(key, category, item, recipeType, recipe);
    this.recipeOutput = recipeOutput;
  }

  @Override
  public final NamespacedKey getKey() {
    return key;
  }

  /**
   * Get the category to which this component belongs.
   *
   * @return the component category
   */
  public Category getCategory() {
    return category;
  }

  /**
   * Get the item representation of this component.
   *
   * @return the item
   */
  public ItemStack getItem() {
    return item.clone();
  }

  /**
   * Set the research required in order to discover this item. If set to null, the research will be removed.
   *
   * @param research the research to set. null to remove
   */
  public void setResearch(Research research) {
    if (this.research != null) {
      this.research.removeComponent(this);
    }

    this.research = research;
  }

  /**
   * Get the research required in order to discover this item.
   *
   * @return the required research
   */
  public Research getResearch() {
    return research;
  }

  @Override
  public int hashCode() {
    return Objects.hash(key, category);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }

    if (!(obj instanceof SlimefunReloadedComponent)) {
      return false;
    }

    SlimefunReloadedComponent other = (SlimefunReloadedComponent) obj;
    return Objects.equals(key, other.key) && Objects.equals(category, other.category);
  }

  public RecipeType getRecipeType() {
    return recipeType;
  }

  public ItemStack[] getRecipe() {
    return recipe;
  }

  public boolean isTicking() {
    return ticking;
  }

  public String getID() {
    return key.getKey();
  }

  public ComponentState getState() {
    return state;
  }

  public String[] getKeys() {
    return keys;
  }

  public Object[] getValues() {
    return values;
  }

  public boolean isDisabled() {
    return state != ComponentState.ENABLED;
  }

  public String getPermission() {
    return permission;
  }

  public ItemStack getRecipeOutput() {
    return recipeOutput;
  }

  public void setRecipe(ItemStack[] recipe) {
    this.recipe = recipe;
  }

}
