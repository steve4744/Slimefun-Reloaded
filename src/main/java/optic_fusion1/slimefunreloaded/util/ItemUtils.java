package optic_fusion1.slimefunreloaded.util;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import optic_fusion1.slimefunreloaded.Slimefun;
import optic_fusion1.slimefunreloaded.util.material.MaterialCollections;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.checkerframework.checker.nullness.qual.NonNull;

@Deprecated
public final class ItemUtils {

  private ItemUtils() {
  }

  private static Method copy;
  private static Method getName;
  private static Method toString;

  static {
    try {
      copy = ReflectionUtils.getClass(PackageName.OBC, "inventory.CraftItemStack").getMethod("asNMSCopy", ItemStack.class);
      getName = ReflectionUtils.getClass(PackageName.NMS, "ItemStack").getMethod("getName");
      toString = ReflectionUtils.getClass(PackageName.NMS, "IChatBaseComponent").getMethod("getString");
    } catch (Exception x) {
      x.printStackTrace();
    }
  }

  /**
   * This method returns a human-readable version of this item's name. If the specified {@link ItemStack} has a Custom Display Name, it will return that. Otherwise it will return the english name of it's {@link Material}
   *
   * @param item	The Item to format
   * @return	The formatted Item Name
   */
  public static String getItemName(ItemStack item) {
    if (item == null) {
      return "null";
    }

    if (item.hasItemMeta() && item.getItemMeta().hasDisplayName()) {
      return item.getItemMeta().getDisplayName();
    }

    try {
      Object instance = copy.invoke(null, item);
      return (String) toString.invoke(getName.invoke(instance));
    } catch (Exception e) {
      e.printStackTrace();
      return "ERROR";
    }
  }

  /**
   * This method compares two instances of {@link ItemStack} and checks whether their {@link Material} and {@link ItemMeta} match.
   *
   * @param a	{@link ItemStack} One
   * @param b {@link ItemStack} Two
   * @return	Whether the two instances of {@link ItemStack} are similiar and can be stacked.
   */
  public static boolean canStack(ItemStack a, ItemStack b) {
    if (a == null || b == null) {
      return false;
    }

    if (a.getType() != b.getType()) {
      return false;
    }
    if (a.hasItemMeta() != b.hasItemMeta()) {
      return false;
    }

    if (a.hasItemMeta()) {
      ItemMeta aMeta = a.getItemMeta();
      ItemMeta bMeta = b.getItemMeta();

      // Item Damage
      if (aMeta instanceof Damageable != bMeta instanceof Damageable) {
        return false;
      }
      if (aMeta instanceof Damageable) {
        if (((Damageable) aMeta).getDamage() != ((Damageable) bMeta).getDamage()) {
          return false;
        }
      }

      // Leather Armor Color
      if (aMeta instanceof LeatherArmorMeta != bMeta instanceof LeatherArmorMeta) {
        return false;
      }
      if (aMeta instanceof LeatherArmorMeta) {
        if (!((LeatherArmorMeta) aMeta).getColor().equals(((LeatherArmorMeta) bMeta).getColor())) {
          return false;
        }
      }

      // Custom Model Data
      if (aMeta.hasCustomModelData() != bMeta.hasCustomModelData()) {
        return false;
      }
      if (aMeta.hasCustomModelData()) {
        if (aMeta.getCustomModelData() != bMeta.getCustomModelData()) {
          return false;
        }
      }

      // Enchantments
      if (!aMeta.getEnchants().equals(bMeta.getEnchants())) {
        return false;
      }

      // Display Name
      if (aMeta.hasDisplayName() != bMeta.hasDisplayName()) {
        return false;
      }
      if (aMeta.hasDisplayName()) {
        if (!aMeta.getDisplayName().equals(bMeta.getDisplayName())) {
          return false;
        }
      }

      // Lore
      if (aMeta.hasLore() != bMeta.hasLore()) {
        return false;
      }
      if (aMeta.hasLore()) {
        if (aMeta.getLore().size() != bMeta.getLore().size()) {
          return false;
        }

        for (int i = 0; i < aMeta.getLore().size(); i++) {
          if (!aMeta.getLore().get(i).equals(bMeta.getLore().get(i))) {
            return false;
          }
        }
      }
    }

    return true;
  }

  /**
   * This method damages the specified Item by 1. If ignoredEnchantments is set to false, it will factor in the "Unbreaking" Enchantment.
   *
   * @param item	The Item to damage
   * @param ignoreEnchantments	Whether the Unbreaking Enchantment should be ignored
   */
  public static void damageItem(@NonNull ItemStack item, boolean ignoreEnchantments) {
    damageItem(item, 1, ignoreEnchantments);
  }

  /**
   * This method damages the specified Item by the given amount. If ignoredEnchantments is set to false, it will factor in the "Unbreaking" Enchantment.
   *
   * @param item	The Item to damage
   * @param damage	The amount of damage to apply
   * @param ignoreEnchantments	Whether the Unbreaking Enchantment should be ignored
   */
  public static void damageItem(@NonNull ItemStack item, int damage, boolean ignoreEnchantments) {
    if (item != null && item.getType() != Material.AIR && item.getAmount() > 0) {
      int remove = damage;

      if (!ignoreEnchantments && item.getEnchantments().containsKey(Enchantment.DURABILITY)) {
        int level = item.getEnchantmentLevel(Enchantment.DURABILITY);
        for (int i = 0; i < damage; i++) {
          if (Math.random() * 100 <= (60 + Math.floorDiv(40, (level + 1)))) {
            remove--;
          }
        }
      }

      ItemMeta meta = item.getItemMeta();
      Damageable damageable = (Damageable) meta;

      if (damageable.getDamage() + remove > item.getType().getMaxDurability()) {
        item.setAmount(0);
      } else {
        damageable.setDamage(damageable.getDamage() + remove);
        item.setItemMeta(meta);
      }
    }
  }

  public static void consumeItem(ItemStack item, boolean replaceConsumables) {
    consumeItem(item, 1, replaceConsumables);
  }

  public static void consumeItem(ItemStack item, int amount, boolean replaceConsumables) {
    Objects.requireNonNull(item, "Required item, received null instead");
    if (item.getType() != Material.AIR && item.getAmount() > 0) {
      if (MaterialCollections.getAllFilledBuckets().contains(item.getType()) && replaceConsumables) {
        item.setType(Material.BUCKET);
        item.setAmount(1);
      } else if (item.getType() == Material.POTION && replaceConsumables) {
        item.setType(Material.GLASS_BOTTLE);
        item.setAmount(1);
      } else if (item.getAmount() <= amount) {
        item.setAmount(0);
      } else {
        item.setAmount(item.getAmount() - amount);
      }
    }
  }

  public static boolean isItemSimilar(ItemStack item, ItemStack sfitem, boolean checkLore) {
    if (item == null) {
      return sfitem == null;
    }
    if (sfitem == null) {
      return false;
    }

    if (item instanceof SlimefunReloadedItemStack && sfitem instanceof SlimefunReloadedItemStack) {
      return ((SlimefunReloadedItemStack) item).getItemID().equals(((SlimefunReloadedItemStack) sfitem).getItemID());
    }

    if (item.getType() == sfitem.getType() && item.getAmount() >= sfitem.getAmount()) {
      if (!item.hasItemMeta() && !sfitem.hasItemMeta()) {
        return true;
      } else {
        ItemMeta itemMeta = item.getItemMeta();

        if (sfitem instanceof SlimefunReloadedItemStack) {
          Optional<String> id = Slimefun.getItemDataService().getItemData(itemMeta);

          if (id.isPresent()) {
            return id.get().equals(((SlimefunReloadedItemStack) sfitem).getItemID());
          }

          ImmutableItemMeta meta = ((SlimefunReloadedItemStack) sfitem).getImmutableMeta();

          Optional<String> displayName = meta.getDisplayName();

          if (itemMeta.hasDisplayName() && displayName.isPresent()) {
            if (itemMeta.getDisplayName().equals(displayName.get())) {
              Optional<List<String>> itemLore = meta.getLore();

              if (checkLore) {
                if (itemMeta.hasLore() && itemLore.isPresent()) {
                  return equalsLore(itemMeta.getLore(), itemLore.get());
                } else {
                  return !itemMeta.hasLore() && !itemLore.isPresent();
                }
              } else {
                return true;
              }
            } else {
              return false;
            }
          } else if (!itemMeta.hasDisplayName() && !displayName.isPresent()) {
            Optional<List<String>> itemLore = meta.getLore();

            if (checkLore) {
              if (itemMeta.hasLore() && itemLore.isPresent()) {
                return equalsLore(itemMeta.getLore(), itemLore.get());
              } else {
                return !itemMeta.hasLore() && !itemLore.isPresent();
              }
            } else {
              return true;
            }
          } else {
            return false;
          }
        } else {
          ItemMeta sfitemMeta = sfitem.getItemMeta();

          if (itemMeta.hasDisplayName() && sfitemMeta.hasDisplayName()) {
            if (itemMeta.getDisplayName().equals(sfitemMeta.getDisplayName())) {
              if (checkLore) {
                if (itemMeta.hasLore() && sfitemMeta.hasLore()) {
                  return equalsLore(itemMeta.getLore(), sfitemMeta.getLore());
                } else {
                  return !itemMeta.hasLore() && !sfitemMeta.hasLore();
                }
              } else {
                return true;
              }
            } else {
              return false;
            }
          } else if (!itemMeta.hasDisplayName() && !sfitemMeta.hasDisplayName()) {
            if (checkLore) {
              if (itemMeta.hasLore() && sfitemMeta.hasLore()) {
                return equalsLore(itemMeta.getLore(), sfitemMeta.getLore());
              } else {
                return !itemMeta.hasLore() && !sfitemMeta.hasLore();
              }
            } else {
              return true;
            }
          } else {
            return false;
          }
        }
      }
    } else {
      return false;
    }
  }

  private static boolean equalsLore(List<String> lore, List<String> lore2) {
    StringBuilder string1 = new StringBuilder();
    StringBuilder string2 = new StringBuilder();

    String colors = ChatColor.YELLOW.toString() + ChatColor.YELLOW.toString() + ChatColor.GRAY.toString();

    for (String string : lore) {
      if (!string.equals(ChatColor.GRAY + "Soulbound") && !string.startsWith(colors)) {
        string1.append("-NEW LINE-").append(string);
      }
    }

    for (String string : lore2) {
      if (!string.equals(ChatColor.GRAY + "Soulbound") && !string.startsWith(colors)) {
        string2.append("-NEW LINE-").append(string);
      }
    }

    return string1.toString().equals(string2.toString());
  }

}
