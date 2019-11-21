package optic_fusion1.slimefunreloaded.item;

import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.research.Research;
import org.bukkit.inventory.ItemStack;

public abstract class SlimefunReloadedItem {

  private String id;
  private ItemState state;
  private ItemStack item;
  private Category category;
  private ItemStack[] recipe;
//  private RecipeType recipeType;
  protected ItemStack recipeOutput;
  private Research research;

  protected boolean usableInWorkbench = false;
  
  /*
	protected boolean enchantable = true;
	protected boolean disenchantable = true;
	protected boolean hidden = false;
	protected boolean useableInWorkbench = false;
	
	private boolean addon = false;
	private String permission = "";
	private List<String> noPermissionTooltip;
	private final Set<ItemHandler> itemhandlers = new HashSet<>();
	private boolean ticking = false;
	private BlockTicker blockTicker;
	private EnergyTicker energyTicker;
	private String[] keys;
	private Object[] values;
	private String wiki = null;
   */
  public SlimefunReloadedItem(Category category, ItemStack item, String id) {
    this.category = category;
    this.item = item;
    this.id = id;
  }

  public String getId() {
    return id;
  }

  public ItemState getState() {
    return state;
  }

  public ItemStack getItem() {
    return item;
  }

  public Category getCategory() {
    return category;
  }

}
