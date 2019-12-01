package optic_fusion1.slimefunreloaded.util;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CustomItem extends ItemStack {

  public CustomItem(ItemStack item) {
    super(item);
  }

  public CustomItem(ItemStack item, String name) {
    super(item);
    ItemMeta im = getItemMeta();
    im.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
    setItemMeta(im);
  }

  public CustomItem(ItemStack item, String name, String... lore) {
    super(item);
    ItemMeta im = getItemMeta();
    im.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
    List<String> lines = new ArrayList<String>();
    for (String line : lore) {
      lines.add(ChatColor.translateAlternateColorCodes('&', line));
    }
    im.setLore(lines);
    setItemMeta(im);
  }

  public CustomItem(ItemStack item, int amount) {
    super(item.clone());
    setAmount(amount);
  }

  public CustomItem(Material type, String name, String... lore) {
    this(new ItemStack(type), name, lore);
  }

  public List<String> getLore() {
    if (!hasItemMeta()) {
      return new ArrayList<String>();
    } else if (!getItemMeta().hasLore()) {
      return new ArrayList<String>();
    } else {
      return getItemMeta().getLore();
    }
  }

  public String getDisplayName() {
    if (!hasItemMeta()) {
      return "";
    } else if (!getItemMeta().hasDisplayName()) {
      return "";
    } else {
      return getItemMeta().getDisplayName();
    }
  }

  public boolean hasEnchantment(Enchantment enchantment) {
    return getEnchantments().containsKey(enchantment);
  }

  public int getEnchantmentLevel(Enchantment enchantment) {
    return hasEnchantment(enchantment) ? getEnchantmentLevel(enchantment) : 0;
  }

}
