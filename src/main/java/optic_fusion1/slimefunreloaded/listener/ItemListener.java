package optic_fusion1.slimefunreloaded.listener;

import optic_fusion1.slimefunreloaded.Slimefun;
import optic_fusion1.slimefunreloaded.component.ComponentManager;
import optic_fusion1.slimefunreloaded.util.BlockStorage;
import org.bukkit.Location;
import org.bukkit.block.Hopper;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

//TODO: Re-add debug & onRightClick methods 
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

}
