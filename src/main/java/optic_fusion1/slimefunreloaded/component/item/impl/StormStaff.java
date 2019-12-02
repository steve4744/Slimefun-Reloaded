package optic_fusion1.slimefunreloaded.component.item.impl;

import java.util.List;
import optic_fusion1.slimefunreloaded.Slimefun;
import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.component.RecipeType;
import optic_fusion1.slimefunreloaded.component.item.SlimefunReloadedItem;
import optic_fusion1.slimefunreloaded.protection.ProtectableAction;
import optic_fusion1.slimefunreloaded.util.I18n;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public class StormStaff extends SlimefunReloadedItem {

  public static final int MAX_USES = 8;

  private static final NamespacedKey usageKey = new NamespacedKey(Slimefun.getSlimefunReloaded(), "stormstaff_usage");

  public StormStaff(NamespacedKey key, Category category, ItemStack item, RecipeType recipeType, ItemStack[] recipe) {
    super(key, category, item, recipeType, recipe/*, getCraftedOutput()*/);
  }

  private static ItemStack getCraftedOutput() {
    ItemStack item = SlimefunItems.STAFF_STORM.clone();
    ItemMeta im = item.getItemMeta();
    List<String> lore = im.getLore();

    lore.set(4, ChatColor.translateAlternateColorCodes('&', "&e" + MAX_USES + " Uses &7left"));

    im.setLore(lore);
    item.setItemMeta(im);
    return item;
  }

  @Override
  public boolean onInteract(Player player, ItemStack item, Action action, Block clickedBlock) {
    if (!item.hasItemMeta()) {
      return false;
    }
    ItemMeta itemMeta = item.getItemMeta();
    if (!itemMeta.hasLore()) {
      return false;
    }
    List<String> itemLore = itemMeta.getLore();

    ItemStack sfItem = getItem();
    ItemMeta sfItemMeta = sfItem.getItemMeta();
    List<String> sfItemLore = sfItemMeta.getLore();

    // Index 1 and 3 in SlimefunItems.STAFF_STORM has lores with words and stuff so we check for them.
    if (itemLore.size() < 6 && itemLore.get(1).equals(sfItemLore.get(1)) && itemLore.get(3).equals(sfItemLore.get(3))) {
      if (player.getFoodLevel() >= 4 || player.getGameMode() == GameMode.CREATIVE) {
        // Get a target block with max. 30 blocks of distance
        Location loc = player.getTargetBlock(null, 30).getLocation();

        if (loc.getWorld() != null && loc.getChunk().isLoaded()) {
          if (loc.getWorld().getPVP() && Slimefun.getProtectionManager().hasPermission(player, loc, ProtectableAction.PVP)) {
            loc.getWorld().strikeLightning(loc);

            if (player.getInventory().getItemInMainHand().getType() != Material.SHEARS && player.getGameMode() != GameMode.CREATIVE) {
              FoodLevelChangeEvent event = new FoodLevelChangeEvent(player, player.getFoodLevel() - 4);
              Bukkit.getPluginManager().callEvent(event);
              player.setFoodLevel(event.getFoodLevel());
            }

            int currentUses = itemMeta.getPersistentDataContainer()
             .getOrDefault(usageKey, PersistentDataType.INTEGER, MAX_USES);

            if (currentUses == 1) {
              player.playSound(player.getLocation(), Sound.ENTITY_ITEM_BREAK, 1, 1);
              item.setAmount(0);
            } else {
              itemMeta.getPersistentDataContainer().set(
               usageKey, PersistentDataType.INTEGER, --currentUses
              );
              itemLore.set(4, ChatColor.translateAlternateColorCodes('&',
               "&e" + currentUses + ' ' + (currentUses > 1 ? "Uses" : "Use") + " &7left"));
              itemMeta.setLore(itemLore);
              item.setItemMeta(itemMeta);
            }
            return true;
          } else {
            I18n.tl(player, "messages.no-pvp");
          }
        }
      } else {
        I18n.tl(player, "messages.hungry");
      }
      return true;
    }
    return true;
  }

}
