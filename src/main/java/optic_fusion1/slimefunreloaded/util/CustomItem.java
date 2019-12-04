package optic_fusion1.slimefunreloaded.util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.PotionMeta;

public class CustomItem extends ItemStack {

  public CustomItem(ItemStack item) {
    super(item);
  }

  public CustomItem(Material type) {
    super(type);
  }

  public CustomItem(ItemStack item, int amount){
    this(item);
    item.setAmount(amount);
  }
  
  public CustomItem(ItemStack item, Consumer<ItemMeta> meta) {
    super(item);
    ItemMeta im = getItemMeta();
    meta.accept(im);
    setItemMeta(im);
  }

  public CustomItem(Material type, Consumer<ItemMeta> meta) {
    this(new ItemStack(type), meta);

  }

  public CustomItem(Material type, String name, String... lore) {
    this(new ItemStack(type), name, lore);
  }

  public CustomItem(ItemStack item, String name, String... lore) {
    this(item, im -> {
      if (name != null) {
        im.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
      }

      if (lore.length > 0) {
        List<String> lines = new ArrayList<>();
        for (String line : lore) {
          lines.add(ChatColor.translateAlternateColorCodes('&', line));
        }
        im.setLore(lines);
      }
    });
  }

  public CustomItem(ItemStack item, Color color, String name, String... lore) {
    this(item, im -> {
      if (name != null) {
        im.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
      }

      if (lore.length > 0) {
        List<String> lines = new ArrayList<>();
        for (String line : lore) {
          lines.add(ChatColor.translateAlternateColorCodes('&', line));
        }
        im.setLore(lines);
      }

      if (im instanceof LeatherArmorMeta) {
        ((LeatherArmorMeta) im).setColor(color);
      }
      if (im instanceof PotionMeta) {
        ((PotionMeta) im).setColor(color);
      }
    });
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
