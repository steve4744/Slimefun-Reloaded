package optic_fusion1.slimefunreloaded.listener;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import optic_fusion1.slimefunreloaded.Slimefun;
import optic_fusion1.slimefunreloaded.component.ComponentManager;
import optic_fusion1.slimefunreloaded.component.SlimefunReloadedComponent;
import optic_fusion1.slimefunreloaded.component.item.SlimefunReloadedBackpack;
import optic_fusion1.slimefunreloaded.component.item.SlimefunReloadedJuice;
import optic_fusion1.slimefunreloaded.util.BackpackInventory;
import optic_fusion1.slimefunreloaded.util.I18n;
import optic_fusion1.slimefunreloaded.util.PlayerProfile;
import optic_fusion1.slimefunreloaded.util.SlimefunReloadedItems;
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

  private Map<UUID, Integer> enchanting = new HashMap<>();
  private static Map<UUID, ItemStack> backpack = new HashMap<>();
  private ComponentManager componentManager = Slimefun.getComponentManager();

  @EventHandler
  public void onClose(InventoryCloseEvent event) {
    Player player = (Player) event.getPlayer();
    UUID uniqueId = player.getUniqueId();
    if (enchanting.containsKey(uniqueId)) {
      enchanting.remove(uniqueId);
    }
    if (backpack.containsKey(uniqueId)) {
      player.playSound(player.getLocation(), Sound.ENTITY_HORSE_ARMOR, 1F, 1F);
      PlayerProfile.getBackpack(backpack.get(uniqueId)).markDirty();
      backpack.remove(uniqueId);
    }
  }

  @EventHandler
  public void onItemDrop(PlayerDropItemEvent event) {
    if (backpack.containsKey(event.getPlayer().getUniqueId())) {
      ItemStack itemStack = event.getItemDrop().getItemStack();
      SlimefunReloadedComponent component = componentManager.getComponentByItem(itemStack);
      if (component instanceof SlimefunReloadedBackpack) {
        event.setCancelled(true);
      }
    }
  }

  @EventHandler
  public void onClick(InventoryClickEvent event) {
    ItemStack itemStack = backpack.get(event.getWhoClicked().getUniqueId());
    if (itemStack != null) {
      if (event.getClick() == ClickType.NUMBER_KEY) {
        ItemStack hotbarItem = event.getWhoClicked().getInventory().getItem(event.getHotbarButton());
        SlimefunReloadedComponent component = componentManager.getComponentByItem(hotbarItem);
        if (component != null && hotbarItem.getType().toString().contains("SHULKER_BOX")
         || component instanceof SlimefunReloadedBackpack) {
          event.setCancelled(true);
        }
      } else if (event.getCurrentItem() != null && event.getCurrentItem().getType() != Material.AIR) {
        SlimefunReloadedComponent component = componentManager.getComponentByItem(event.getCurrentItem());
        if (itemStack.isSimilar(SlimefunReloadedItems.COOLER) && !(component instanceof SlimefunReloadedJuice)
         || component instanceof SlimefunReloadedBackpack) {
          event.setCancelled(true);
        }
      }
    }
  }

  //TODO: MOVE THIS TO A DIFFERENT CLASS
  public static void openBackpack(Player player, ItemStack itemStack, SlimefunReloadedBackpack backpack) {
    if (itemStack.getAmount() == 1) {
      if (Slimefun.hasUnlocked(player, backpack, true)) {
        if (!PlayerProfile.get(player, profile -> openBackpack(itemStack, profile, backpack.getSize()))) {
          I18n.tl(player, "messages.opening-backpack");
        }
      }
    } else {
      I18n.tl(player, "backpack.no-stack", true);
    }
  }

  //TODO: MOVE THIS TO A DIFERENT CLASS
  private static void openBackpack(ItemStack itemStack, PlayerProfile profile, int size) {
    Player player = profile.getPlayer();
    for (int line = 0; line < itemStack.getItemMeta().getLore().size(); line++) {
      if (itemStack.getItemMeta().getLore().get(line).equals(ChatColor.translateAlternateColorCodes('&', "&7ID: <ID>"))) {
        BackpackInventory backpack = profile.createBackpack(size);
        setBackpackId(player, itemStack, line, backpack.getID());
        break;
      }
    }
    if (!backpack.containsValue(itemStack)) {
      player.playSound(player.getLocation(), Sound.ENTITY_HORSE_ARMOR, 1F, 1F);
      backpack.put(player.getUniqueId(), itemStack);
      Slimefun.runSync(() -> PlayerProfile.getBackpack(itemStack).open(player));
    } else {
      I18n.tl(player, "backpack.already-open");
    }
  }

  //TODO: MOVE THIS TO A DIFFERENT CLASS
  public static void setBackpackId(Player player, ItemStack itemStack, int line, int id) {
    ItemMeta itemMeta = itemStack.getItemMeta();
    List<String> lore = itemMeta.getLore();
    lore.set(line, lore.get(line).replace("<ID>", player.getUniqueId() + "#" + id));
    itemMeta.setLore(lore);
    itemStack.setItemMeta(itemMeta);
  }
}
