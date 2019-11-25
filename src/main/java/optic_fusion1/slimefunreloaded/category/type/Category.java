package optic_fusion1.slimefunreloaded.category.type;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.ImmutableList;

import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import optic_fusion1.slimefunreloaded.component.SlimefunReloadedComponent;

public class Category {

  private String name;
  private ItemStack item;
  private List<SlimefunReloadedComponent> components = new ArrayList<>();
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

  public void add(SlimefunReloadedComponent component) {
    this.components.add(component);
  }

  public ItemStack getItem() {
    return item;
  }

  public List<SlimefunReloadedComponent> getComponents() {
    return ImmutableList.copyOf(components);
  }

  public int getTier() {
    return tier;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return "Slimefun Reloaded Category {name=" + name + ",itemdisplayname=" + item.getItemMeta().getDisplayName() + ",tier=" + tier + "}";
  }

  public boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(boolean isEnabled) {
    this.enabled = isEnabled;
  }

}
