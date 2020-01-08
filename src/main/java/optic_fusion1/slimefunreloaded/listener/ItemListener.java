package optic_fusion1.slimefunreloaded.listener;

import optic_fusion1.slimefunreloaded.Slimefun;
import optic_fusion1.slimefunreloaded.component.ComponentManager;
import optic_fusion1.slimefunreloaded.component.SlimefunReloadedComponent;
import optic_fusion1.slimefunreloaded.component.item.SlimefunReloadedConsumeable;
import optic_fusion1.slimefunreloaded.component.item.SlimefunReloadedItem;
import optic_fusion1.slimefunreloaded.component.item.SlimefunReloadedJuice;
import optic_fusion1.slimefunreloaded.util.BlockStorage;
import optic_fusion1.slimefunreloaded.util.SlimefunReloadedItems;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BrewingStand;
import org.bukkit.block.Hopper;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wither;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.BrewerInventory;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

//TODO: Re-add debug and onRightClick methods
public class ItemListener implements Listener {

  private ComponentManager componentManager = Slimefun.getComponentManager();

  @EventHandler
  public void onIgnitionChamberItemMOve(InventoryMoveItemEvent event) {
    if (event.getInitiator().getHolder() instanceof Hopper && BlockStorage.check(((Hopper) event.getInitiator().getHolder()).getBlock(), "IGNITION_CHAMBER")) {
      event.setCancelled(true);
    }
  }

  @EventHandler
  public void onGrindstone(InventoryClickEvent event) {
    if (event.getRawSlot() == 2 && event.getWhoClicked() instanceof Player && event.getInventory().getType() == InventoryType.GRINDSTONE) {
      ItemStack slot0 = event.getInventory().getContents()[0];
      ItemStack slot1 = event.getInventory().getContents()[1];
      if (componentManager.getComponentByItem(slot0) != null && !componentManager.getComponentByItem(slot0).isDisabled()) {
        event.setCancelled(true);
      }
      if (componentManager.getComponentByItem(slot1) != null && !componentManager.getComponentByItem(slot1).isDisabled()) {
        event.setCancelled(true);
      }
      /*
      if (SlimefunManager.isItemSimilar(slot0, SlimefunGuide.getItem(SlimefunGuideLayout.BOOK), true))
				e.setCancelled(true);
			else if (SlimefunManager.isItemSimilar(slot0, SlimefunGuide.getItem(SlimefunGuideLayout.CHEST), true))
				e.setCancelled(true);

			if (SlimefunManager.isItemSimilar(slot1, SlimefunGuide.getItem(SlimefunGuideLayout.BOOK), true))
				e.setCancelled(true);
			else if (SlimefunManager.isItemSimilar(slot1, SlimefunGuide.getItem(SlimefunGuideLayout.CHEST), true))
				e.setCancelled(true);
       */
    }
  }

  @EventHandler
  public void enabledCheck(PlayerInteractEvent event) {
    if (event.getAction() != Action.LEFT_CLICK_AIR && event.getAction() != Action.LEFT_CLICK_BLOCK) {
      return;
    }
    ItemStack item = event.getItem();
    if (item != null && componentManager.getComponentByItem(item) != null && !componentManager.getComponentByItem(item).isDisabled()) {
      event.setCancelled(true);
    }
  }

  @EventHandler
  public void onBucketUse(PlayerBucketEmptyEvent event) {
    Location location = event.getBlockClicked().getRelative(event.getBlockFace()).getLocation();
    if (BlockStorage.hasBlockInfo(location)) {
      event.setCancelled(true);
    }
  }

  private boolean canPlaceCargoNodes(Player player, ItemStack item, Block block) {
    if (canPlaceBlock(player, block)) {
      if (item.isSimilar(SlimefunReloadedItems.CARGO_INPUT)) {
        return true;
      } else if (item.isSimilar(SlimefunReloadedItems.CARGO_OUTPUT)) {
        return true;
      } else if (item.isSimilar(SlimefunReloadedItems.CARGO_OUTPUT_ADVANCED)) {
        return true;
      } else if (item.isSimilar(SlimefunReloadedItems.CT_IMPORT_BUS)) {
        return true;
      } else if (item.isSimilar(SlimefunReloadedItems.CT_EXPORT_BUS)) {
        return true;
      }
    }
    return false;
  }

  private boolean canPlaceBlock(Player player, Block relative) {
    return player.isSneaking() && relative.getType() == Material.AIR;
  }

  @EventHandler
  public void onEat(PlayerItemConsumeEvent event) {
    Player player = event.getPlayer();
    ItemStack itemStack = event.getItem();
    if (itemStack == null) {
      return;
    }
    SlimefunReloadedComponent component = componentManager.getComponentByItem(itemStack);
    if (component != null) {
      if (!Slimefun.hasUnlocked(player, component, true)) {
        event.setCancelled(true);
        return;
      }
      if (!(component instanceof SlimefunReloadedJuice) && component instanceof SlimefunReloadedConsumeable) {
        ((SlimefunReloadedConsumeable) component).onConsume(player, itemStack);
        return;
      }
      //Fix for Saturation on potions is no longer working
      for (PotionEffect effect : ((PotionMeta) itemStack.getItemMeta()).getCustomEffects()) {
        if (effect.getType().equals(PotionEffectType.SATURATION)) {
          player.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, effect.getDuration(), effect.getAmplifier()));
          break;
        }
      }
      //Determine from which hand the juice is being drunk, and its amount
      int mode = 0;
      if (itemStack.isSimilar(player.getInventory().getItemInMainHand()) && player.getInventory().getItemInMainHand().getAmount() != 1) {
        mode = 2;
      } else if (itemStack.isSimilar(player.getInventory().getItemInOffHand())) {
        if (player.getInventory().getItemInOffHand().getAmount() == 1) {
          mode = 1;
        } else {
          mode = 2;
        }
      }
      final int m = mode;
      Slimefun.runSync(() -> {
        if (m == 0) {
          player.getEquipment().getItemInMainHand().setAmount(0);
        } else if (m == 1) {
          player.getEquipment().getItemInOffHand().setAmount(0);
        } else if (m == 2) {
          player.getInventory().removeItem(new ItemStack(Material.GLASS_BOTTLE, 1));
        }
      }, 0L);
    }
  }

  @EventHandler
  public void onCraft(CraftItemEvent event) {
    for (ItemStack item : event.getInventory().getContents()) {
      SlimefunReloadedComponent component = componentManager.getComponentByItem(item);
//      if(component != null && !component.isUseableInWorkbench()){
//        event.setCancelled(true);
//        I18n.tl((Player) event.getWhoClicked(), "workbench.not-enchanced");
//        break;
//      }
    }
  }

  @EventHandler
  public void onPrepareCraft(PrepareItemCraftEvent event) {
//    for(ItemStack item : event.getInventory().getContents()){
//      SlimefunReloadedComponent component = componentManager.getComponentByItem(item);
//      if(component != null && !component.isUsableInWorkbench()){
//        event.getInventory().setResult(null);
//        break;
//      }
//    }
  }

  @EventHandler(priority = EventPriority.LOWEST)
  public void onEntityChangeBlock(EntityChangeBlockEvent event) {
    if (event.getEntity() instanceof FallingBlock) {
      if (Slimefun.getBlocks().contains(event.getEntity().getUniqueId())) {
        event.setCancelled(true);
        event.getEntity().remove();
      }
    } else if (event.getEntity() instanceof Wither) {
      String id = BlockStorage.checkID(event.getBlock());
      if (id != null && id.startsWith("WITHER_PROOF_")) {
        event.setCancelled(true);
      }
    }
  }

  @EventHandler
  public void onAnvil(InventoryClickEvent event) {
    if (event.getRawSlot() == 2 && event.getWhoClicked() instanceof Player && event.getInventory().getType() == InventoryType.ANVIL) {
      ItemStack slot0 = event.getInventory().getContents()[0];
      ItemStack slot1 = event.getInventory().getContents()[1];
      if (slot0.isSimilar(SlimefunReloadedItems.ELYTRA)) {
        return;
      }
//      if (SlimefunItem.getByItem(slot0) != null && !SlimefunItem.isDisabled(slot0)
//       || SlimefunItem.getByItem(slot1) != null && !SlimefunItem.isDisabled(slot1)
//       || SlimefunManager.isItemSimilar(slot0, SlimefunGuide.getItem(SlimefunGuideLayout.BOOK), true)
//       || SlimefunManager.isItemSimilar(slot0, SlimefunGuide.getItem(SlimefunGuideLayout.CHEST), true)
//       || SlimefunManager.isItemSimilar(slot1, SlimefunGuide.getItem(SlimefunGuideLayout.BOOK), true)
//       || SlimefunManager.isItemSimilar(slot1, SlimefunGuide.getItem(SlimefunGuideLayout.CHEST), true)) {
//
//        e.setCancelled(true);
//        SlimefunPlugin.getLocal().sendMessage((Player) e.getWhoClicked(), "anvil.not-working", true);
//      }
    }
  }

  @EventHandler(ignoreCancelled = true)
  public void onPreBrew(InventoryClickEvent event) {
    Inventory inventory = event.getInventory();
    if (inventory instanceof BrewerInventory && inventory.getHolder() instanceof BrewingStand && event.getRawSlot() < inventory.getSize()) {
      event.setCancelled(componentManager.getComponentByItem(event.getCursor()) != null);
    }
  }

  @EventHandler
  public void onItemDrop(PlayerDropItemEvent event) {
    SlimefunReloadedComponent component = componentManager.getComponentByItem(event.getItemDrop().getItemStack());
    if (component != null && component instanceof SlimefunReloadedItem) {
      ((SlimefunReloadedItem) component).onDrop(event.getPlayer(), event.getItemDrop());
    }
  }

}
