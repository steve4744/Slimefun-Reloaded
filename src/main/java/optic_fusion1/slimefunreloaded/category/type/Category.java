package optic_fusion1.slimefunreloaded.category.type;

import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Category {

  private String name;
  private ItemStack item;
  //private List<SlimefunItem> items = new ArrayList<>();
  private int tier;
  private boolean enabled = true;

  public Category(String name, ItemStack item) {
    this(name, item, 3);
  }

  public Category(String name, ItemStack item, int tier) {
    this.name = name;
    this.item = item;
    ItemMeta meta = item.getItemMeta();
    meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
    this.item.setItemMeta(meta);
    this.tier = tier;
  }

//  public void add(SlimefunItem item){
//    items.add(item);
//  }

  public ItemStack getItem() {
    return item;
  }

//  public List<SlimefunItem> getItems(){
//    return items;
//  }
  
  public int getTier() {
    return tier;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return "Slimefun Reloaded Category {" + item.getItemMeta().getDisplayName() + ",tier=" + tier + "}";
  }

  public boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(boolean isEnabled) {
    this.enabled = isEnabled;
  }

}
