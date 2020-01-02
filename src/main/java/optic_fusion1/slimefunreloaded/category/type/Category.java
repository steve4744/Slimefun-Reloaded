package optic_fusion1.slimefunreloaded.category.type;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import optic_fusion1.slimefunreloaded.component.SlimefunReloadedComponent;
import org.bukkit.Keyed;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Category implements Keyed {

  private NamespacedKey key;
  private ItemStack itemStack;
  private int tier;
  private List<SlimefunReloadedComponent> components = new ArrayList<>();
  private boolean isEnabled;

  public Category(NamespacedKey key, ItemStack item, int tier) {
    this.key = key;
    this.itemStack = item;
    ItemMeta meta = itemStack.getItemMeta();
    meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
    this.itemStack.setItemMeta(meta);
    this.tier = tier;
    this.isEnabled = true;
  }

  @Override
  public NamespacedKey getKey() {
    return key;
  }

  public ItemStack getItem() {
    return itemStack;
  }

  public int getTier() {
    return tier;
  }

  public boolean isEnabled() {
    return isEnabled;
  }

  public void setEnabled(boolean isEnabled) {
    this.isEnabled = isEnabled;
  }

  public void add(SlimefunReloadedComponent... components) {
    this.components.addAll(Arrays.asList(components));
  }

  public List<SlimefunReloadedComponent> getComponents() {
    return Collections.unmodifiableList(components);
  }

  @Override
  public String toString() {
    return "Slimefun Reloaded Category {key=" + key + ",itemdisplayname=" + itemStack.getItemMeta().getDisplayName() + ",tier" + tier + "}";
  }

}
