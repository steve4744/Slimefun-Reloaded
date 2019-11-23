package optic_fusion1.slimefunreloaded.listener;

import java.util.List;
import nl.rutgerkok.blocklocker.profile.PlayerProfile;
import optic_fusion1.slimefunreloaded.Slimefun;
import optic_fusion1.slimefunreloaded.SlimefunReloaded;
import optic_fusion1.slimefunreloaded.item.SlimefunReloadedItem;
import optic_fusion1.slimefunreloaded.item.food.impl.Juice;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BackpackListener implements Listener {

  public BackpackListener(SlimefunReloaded plugin) {
    plugin.getServer().getPluginManager().registerEvents(this, plugin);
  }

  @EventHandler
  public void onClose(InventoryCloseEvent e) {
    if (SlimefunReloaded.getUtilities().enchanting.containsKey(e.getPlayer().getUniqueId())) {
      SlimefunReloaded.getUtilities().enchanting.remove(e.getPlayer().getUniqueId());
    }

    if (SlimefunReloaded.getUtilities().backpack.containsKey(e.getPlayer().getUniqueId())) {
      ((Player) e.getPlayer()).playSound(e.getPlayer().getLocation(), Sound.ENTITY_HORSE_ARMOR, 1F, 1F);
      PlayerProfile.getBackpack(SlimefunReloaded.getUtilities().backpack.get(e.getPlayer().getUniqueId())).markDirty();
      SlimefunReloaded.getUtilities().backpack.remove(e.getPlayer().getUniqueId());
    }
  }

  @EventHandler
  public void onItemDrop(PlayerDropItemEvent e) {
    if (SlimefunReloaded.getUtilities().backpack.containsKey(e.getPlayer().getUniqueId())) {
      ItemStack item = e.getItemDrop().getItemStack();
      SlimefunReloadedItem sfItem = SlimefunReloadedItem.getByItem(item);
      if (sfItem instanceof SlimefunBackpack) {
        e.setCancelled(true);
      }
    }
  }

  @EventHandler
  public void onClick(InventoryClickEvent e) {
    ItemStack item = SlimefunReloaded.getUtilities().backpack.get(e.getWhoClicked().getUniqueId());
    if (item != null) {
      if (e.getClick() == ClickType.NUMBER_KEY) {
        ItemStack hotbarItem = e.getWhoClicked().getInventory().getItem(e.getHotbarButton());
        SlimefunReloadedItem sfItem = SlimefunReloadedItem.getByItem(hotbarItem);
        if ((hotbarItem != null && hotbarItem.getType().toString().contains("SHULKER_BOX"))
         || sfItem instanceof SlimefunBackpack) {
          e.setCancelled(true);
        }
      } else if (e.getCurrentItem() != null && e.getCurrentItem().getType() != Material.AIR) {
        SlimefunReloadedItem sfItem = SlimefunReloadedItem.getByItem(e.getCurrentItem());
        if ((SlimefunManager.isItemSimiliar(item, SlimefunReloadedItems.COOLER, false) && !(sfItem instanceof Juice))
         || e.getCurrentItem().getType().toString().contains("SHULKER_BOX")
         || sfItem instanceof SlimefunBackpack) {
          e.setCancelled(true);
        }
      }
    }
  }

  public static void openBackpack(Player p, ItemStack item, SlimefunBackpack backpack) {
    if (item.getAmount() == 1) {
      if (Slimefun.hasUnlocked(p, backpack, true)) {
        if (!PlayerProfile.get(p, profile -> openBackpack(item, profile, backpack.getSize()))) {
          Slimefun.getLocal().sendMessage(p, "messages.opening-backpack");
        }
      }
    } else {
      SlimefunReloaded.getLocal().sendMessage(p, "backpack.no-stack", true);
    }
  }

  private static void openBackpack(ItemStack item, PlayerProfile profile, int size) {
    Player p = profile.getPlayer();
    for (int line = 0; line < item.getItemMeta().getLore().size(); line++) {
      if (item.getItemMeta().getLore().get(line).equals(ChatColor.translateAlternateColorCodes('&', "&7ID: <ID>"))) {
        BackpackInventory backpack = profile.createBackpack(size);

        setBackpackId(p, item, line, backpack.getID());
        break;
      }
    }

    if (!SlimefunReloaded.getUtilities().backpack.containsValue(item)) {
      p.playSound(p.getLocation(), Sound.ENTITY_HORSE_ARMOR, 1F, 1F);
      SlimefunReloaded.getUtilities().backpack.put(p.getUniqueId(), item);

      Slimefun.runSync(() -> PlayerProfile.getBackpack(item).open(p));
    } else {
      SlimefunReloaded.getLocal().sendMessage(p, "backpack.already-open", true);
    }
  }

  public static void setBackpackId(Player p, ItemStack item, int line, int id) {
    ItemMeta im = item.getItemMeta();
    List<String> lore = im.getLore();
    lore.set(line, lore.get(line).replace("<ID>", p.getUniqueId() + "#" + id));
    im.setLore(lore);
    item.setItemMeta(im);
  }
}
