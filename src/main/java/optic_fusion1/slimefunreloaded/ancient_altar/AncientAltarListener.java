package optic_fusion1.slimefunreloaded.ancient_altar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import optic_fusion1.slimefunreloaded.Slimefun;
import optic_fusion1.slimefunreloaded.SlimefunReloaded;
import optic_fusion1.slimefunreloaded.util.BlockStorage;
import optic_fusion1.slimefunreloaded.util.CustomItem;
import optic_fusion1.slimefunreloaded.util.I18n;
import optic_fusion1.slimefunreloaded.util.SlimefunReloadedItems;
import optic_fusion1.slimefunreloaded.util.StringUtils;
import optic_fusion1.slimefunreloaded.util.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.util.Vector;

public class AncientAltarListener implements Listener {

  private final List<Block> altars = new ArrayList<>();
  private final Set<UUID> removedItems = new HashSet<>();

  public AncientAltarListener(SlimefunReloaded plugin) {
    plugin.getServer().getPluginManager().registerEvents(this, plugin);
  }

  @EventHandler(priority = EventPriority.LOW, ignoreCancelled = true)
  public void onInteract(PlayerInteractEvent e) {
    if (e.getAction() != Action.RIGHT_CLICK_BLOCK) {
      return;
    }
    Block b = e.getClickedBlock();
    String item = BlockStorage.checkID(b);

    if (item != null) {
      if (item.equals("ANCIENT_PEDESTAL")) {
        if (Slimefun.getAltarinuse().contains(b.getLocation())) {
          e.setCancelled(true);
          return;
        }
        e.setCancelled(true);
        Item stack = findItem(b);
        if (stack == null) {
          if (e.getPlayer().getInventory().getItemInMainHand().getType() == Material.AIR) {
            return;
          }

          if (b.getRelative(0, 1, 0).getType() != Material.AIR) {
            I18n.tl(e.getPlayer(), "machines.ANCIENT_PEDESTAL.obstructed");
            return;
          }

          insertItem(e.getPlayer(), b);
        } else if (!removedItems.contains(stack.getUniqueId())) {
          final UUID uuid = stack.getUniqueId();
          removedItems.add(uuid);

          Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Slimefun.getSlimefunReloaded(), () -> removedItems.remove(uuid), 30L);

          stack.remove();
          e.getPlayer().getInventory().addItem(fixItemStack(stack.getItemStack(), stack.getCustomName()));
          e.getPlayer().playSound(b.getLocation(), Sound.ENTITY_ITEM_PICKUP, 1F, 1F);
        }
      } else if (item.equals("ANCIENT_ALTAR")) {
        if (!Slimefun.hasUnlocked(e.getPlayer(), SlimefunReloadedItems.ANCIENT_ALTAR, true) || Slimefun.getAltarinuse().contains(b.getLocation())) {
          e.setCancelled(true);
          return;
        }

        // Make altarinuse simply because that was the last block clicked.
        Slimefun.getAltarinuse().add(b.getLocation());
        e.setCancelled(true);

        ItemStack catalyst = new CustomItem(e.getPlayer().getInventory().getItemInMainHand(), 1);
        List<Block> pedestals = Pedestals.getPedestals(b);

        if (!altars.contains(e.getClickedBlock())) {
          altars.add(e.getClickedBlock());
          if (pedestals.size() == 8) {
            pedestals.forEach(block -> Slimefun.getAltarinuse().add(block.getLocation()));

            if (catalyst.getType() != Material.AIR) {
              List<ItemStack> input = new ArrayList<>();
              for (Block pedestal : pedestals) {
                Item stack = findItem(pedestal);
                if (stack != null) {
                  input.add(fixItemStack(stack.getItemStack(), stack.getCustomName()));
                }
              }

              ItemStack result = Pedestals.getRecipeOutput(catalyst, input);
              if (result != null) {
                if (Slimefun.hasUnlocked(e.getPlayer(), result, true)) {
                  List<ItemStack> consumed = new ArrayList<>();
                  consumed.add(catalyst);

                  if (e.getPlayer().getGameMode() != GameMode.CREATIVE) {
                    Utils.consumeItem(e.getPlayer().getInventory().getItemInMainHand(), false);
                  }

                  Bukkit.getScheduler().scheduleSyncDelayedTask(Slimefun.getSlimefunReloaded(), new RitualAnimation(altars, b, b.getLocation().add(0.5, 1.3, 0.5), result, pedestals, consumed), 10L);
                } else {
                  altars.remove(e.getClickedBlock());

                  pedestals.forEach(block -> Slimefun.getAltarinuse().remove(block.getLocation()));

                  // Item not unlocked, no longer in use.
                  Slimefun.getAltarinuse().remove(b.getLocation());
                }
              } else {
                altars.remove(e.getClickedBlock());
                I18n.tl(e.getPlayer(), "machines.ANCIENT_ALTAR.unknown-recipe");

                pedestals.forEach(block -> Slimefun.getAltarinuse().remove(block.getLocation()));

                // Bad recipe, no longer in use.
                Slimefun.getAltarinuse().remove(b.getLocation());
              }
            } else {
              altars.remove(e.getClickedBlock());
              I18n.tl(e.getPlayer(), "machines.ANCIENT_ALTAR.unknown_catalyst");

              pedestals.forEach(block -> Slimefun.getAltarinuse().remove(block.getLocation()));

              // Unknown catalyst, no longer in use
              Slimefun.getAltarinuse().remove(b.getLocation());
            }
          } else {
            altars.remove(e.getClickedBlock());
            I18n.tl(e.getPlayer(), "machines.ANCIENT_ALTAR.no-enough-pedestals", pedestals.size());

            // Not a valid altar so remove from inuse
            Slimefun.getAltarinuse().remove(b.getLocation());
          }
        }
      }
    }
  }

  public static ItemStack fixItemStack(ItemStack itemStack, String customName) {
    ItemStack stack = itemStack.clone();
    if (customName.equals(StringUtils.formatItemName(new ItemStack(itemStack.getType()), false))) {
      ItemMeta im = stack.getItemMeta();
      im.setDisplayName(null);
      stack.setItemMeta(im);
    } else {
      ItemMeta im = stack.getItemMeta();
      if (!customName.startsWith(String.valueOf(ChatColor.COLOR_CHAR))) {
        customName = ChatColor.RESET + customName;
      }
      im.setDisplayName(customName);
      stack.setItemMeta(im);
    }
    return stack;
  }

  public static Item findItem(Block b) {
    for (Entity n : b.getChunk().getEntities()) {
      if (n instanceof Item && b.getLocation().add(0.5, 1.2, 0.5).distanceSquared(n.getLocation()) < 0.5D && n.getCustomName() != null) {
        return (Item) n;
      }
    }
    return null;
  }

  private void insertItem(Player p, Block b) {
    ItemStack hand = p.getInventory().getItemInMainHand();
    ItemStack stack = new CustomItem(hand, 1);

    if (p.getGameMode() != GameMode.CREATIVE) {
      Utils.consumeItem(hand, false);
    }

    String nametag = StringUtils.formatItemName(stack, false);
    Item entity = b.getWorld().dropItem(b.getLocation().add(0.5, 1.2, 0.5), new CustomItem(stack, "&5&dALTAR &3Probe - &e" + System.nanoTime()));
    entity.setVelocity(new Vector(0, 0.1, 0));
    entity.setMetadata("no_pickup", new FixedMetadataValue(Slimefun.getSlimefunReloaded(), "altar_item"));
    entity.setCustomNameVisible(true);
    entity.setCustomName(nametag);
    p.playSound(b.getLocation(), Sound.ENTITY_ITEM_PICKUP, 0.3F, 0.3F);
  }

  @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
  public void onBlockPlace(BlockPlaceEvent e) {
    Block b = e.getBlockPlaced().getRelative(0, -1, 0);
    String item = BlockStorage.checkID(b);

    if (item != null && item.equalsIgnoreCase("ANCIENT_PEDESTAL")) {
      I18n.tl(e.getPlayer(), "machines.cannot-place");
      e.setCancelled(true);
    }
  }

}
