package optic_fusion1.slimefunreloaded.listener;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import optic_fusion1.slimefunreloaded.Slimefun;
import optic_fusion1.slimefunreloaded.component.ComponentManager;
import optic_fusion1.slimefunreloaded.component.NotPlaceable;
import optic_fusion1.slimefunreloaded.component.SlimefunReloadedComponent;
import optic_fusion1.slimefunreloaded.component.item.SlimefunReloadedBlock;
import optic_fusion1.slimefunreloaded.util.BlockStorage;
import optic_fusion1.slimefunreloaded.util.CustomItem;
import optic_fusion1.slimefunreloaded.util.FireworkShow;
import optic_fusion1.slimefunreloaded.util.I18n;
import optic_fusion1.slimefunreloaded.util.ItemUtils;
import optic_fusion1.slimefunreloaded.util.SlimefunReloadedItems;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.TileState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockFromToEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

//TODO: Re-Add the onEntityExplode method
public class ToolListener implements Listener {

  private ComponentManager componentManager = Slimefun.getComponentManager();
  
  @EventHandler
  public void on(BlockBreakEvent event) {
    List<ItemStack> drops = new ArrayList<>();
    ItemStack item = event.getPlayer().getInventory().getItemInMainHand();
    int fortune = 1;

    SlimefunReloadedComponent component = BlockStorage.check(event.getBlock());
    if (component instanceof SlimefunReloadedBlock) {
      SlimefunReloadedBlock componentBlock = (SlimefunReloadedBlock) component;
      componentBlock.onBlockBreak(event, event.getPlayer(), event.getBlock(), item, fortune, component);
    }
  }

  //TODO: FULLY RE-ADD the onBlockRegister method
  @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
  public void onBlockRegister(BlockPlaceEvent event) {
    if (BlockStorage.hasBlockInfo(event.getBlock())) {
      event.setCancelled(true);
      return;
    }
    ItemStack item = event.getItemInHand();
    SlimefunReloadedComponent component = componentManager.getComponentByItem(item);
    if (component != null && !component.isDisabled() && !(component instanceof NotPlaceable)) {
      if (!Slimefun.hasUnlocked(event.getPlayer(), component, true)) {
        event.setCancelled(true);
        return;
      }
      BlockState blockState = event.getBlock().getState();
      boolean supportsPersistentData = blockState instanceof TileState;
      if (supportsPersistentData) {
        Slimefun.getBlockDataService().setBlockData((TileState) blockState, component.getID());
      }
      BlockStorage.addBlockInfo(event.getBlock(), "id", component.getID(), true);
      if (component instanceof SlimefunReloadedBlock) {
        ((SlimefunReloadedBlock) component).onBlockPlace(event, item, event.getPlayer(), event.getBlock(), component);
      }
    } else {
      if (component instanceof SlimefunReloadedBlock) {
        ((SlimefunReloadedBlock) component).onBlockPlace(event, item, event.getPlayer(), event.getBlock(), component);
      }
    }
  }

  @EventHandler
  public void onBlockPlace(BlockPlaceEvent event) {
    ItemStack itemStack = event.getItemInHand();
    if (Slimefun.getCancelPlace().remove(event.getPlayer().getUniqueId())) {
      event.setCancelled(true);
    }
    //Clean this up
    if (itemStack.isSimilar(SlimefunReloadedItems.BASIC_CIRCUIT_BOARD)) {
      event.setCancelled(true);
    } else if (itemStack.isSimilar(SlimefunReloadedItems.ADVANCED_CIRCUIT_BOARD)) {
      event.setCancelled(true);
    } else if (itemStack.isSimilar(SlimefunReloadedItems.PORTABLE_CRAFTER)) {
      event.setCancelled(true);
    } else if (itemStack.isSimilar(SlimefunReloadedItems.PORTABLE_DUSTBIN)) {
      event.setCancelled(true);
    } else if (itemStack.isSimilar(SlimefunReloadedItems.BACKPACK_SMALL)) {
      event.setCancelled(true);
    } else if (itemStack.isSimilar(SlimefunReloadedItems.BACKPACK_MEDIUM)) {
      event.setCancelled(true);
    } else if (itemStack.isSimilar(SlimefunReloadedItems.BACKPACK_LARGE)) {
      event.setCancelled(true);
    } else if (itemStack.isSimilar(SlimefunReloadedItems.WOVEN_BACKPACK)) {
      event.setCancelled(true);
    } else if (itemStack.isSimilar(SlimefunReloadedItems.GILDED_BACKPACK)) {
      event.setCancelled(true);
    } else if (itemStack.isSimilar(SlimefunReloadedItems.RADIANT_BACKPACK)) {
      event.setCancelled(true);
    } else if (itemStack.isSimilar(SlimefunReloadedItems.BOUND_BACKPACK)) {
      event.setCancelled(true);
    } else if (itemStack.isSimilar(SlimefunReloadedItems.COOLER)) {
      event.setCancelled(true);
    } else if (itemStack.isSimilar(SlimefunReloadedItems.ENDER_BACKPACK)) {
      event.setCancelled(true);
    } else if (itemStack.isSimilar(SlimefunReloadedItems.CARBON)) {
      event.setCancelled(true);
    } else if (itemStack.isSimilar(SlimefunReloadedItems.COMPRESSED_CARBON)) {
      event.setCancelled(true);
    } else if (itemStack.isSimilar(SlimefunReloadedItems.CARBON_CHUNK)) {
      event.setCancelled(true);
    } else if (itemStack.isSimilar(SlimefunReloadedItems.ANDROID_MEMORY_CORE)) {
      event.setCancelled(true);
    } else if (itemStack.isSimilar(SlimefunReloadedItems.LAVA_CRYSTAL)) {
      event.setCancelled(true);
    } else if (itemStack.isSimilar(SlimefunReloadedItems.TINY_URANIUM)) {
      event.setCancelled(true);
    } else if (itemStack.isSimilar(SlimefunReloadedItems.SMALL_URANIUM)) {
      event.setCancelled(true);
    } else if (itemStack.isSimilar(SlimefunReloadedItems.BROKEN_SPAWNER)) {
      event.setCancelled(true);
    } else if (itemStack.isSimilar(SlimefunReloadedItems.GPS_MARKER_TOOL)) {
      event.setCancelled(true);
      Slimefun.getGPSNetwork().addWaypoint(event.getPlayer(), event.getBlock().getLocation());
    } else if (itemStack.isSimilar(SlimefunReloadedItems.CHRISTMAS_PRESENT)) {
      event.setCancelled(true);
      if (event.getPlayer().getGameMode() != GameMode.CREATIVE) {
        ItemUtils.consumeItem(itemStack, false);
      }
      FireworkShow.launchRandom(event.getPlayer(), 3);
      List<ItemStack> gifts = new ArrayList<>();
      gifts.add(new CustomItem(SlimefunReloadedItems.CHRISTMAS_HOT_CHOCOLATE, 1));
      gifts.add(new CustomItem(SlimefunReloadedItems.CHRISTMAS_CHOCOLATE_APPLE, 4));
      gifts.add(new CustomItem(SlimefunReloadedItems.CHRISTMAS_CARAMEL_APPLE, 4));
      gifts.add(new CustomItem(SlimefunReloadedItems.CHRISTMAS_CAKE, 4));
      gifts.add(new CustomItem(SlimefunReloadedItems.CHRISTMAS_COOKIE, 8));
      gifts.add(new CustomItem(SlimefunReloadedItems.CHRISTMAS_PRESENT, 1));
      gifts.add(new CustomItem(SlimefunReloadedItems.CHRISTMAS_EGG_NOG, 1));
      gifts.add(new CustomItem(SlimefunReloadedItems.CHRISTMAS_MILK, 1));
      gifts.add(new CustomItem(SlimefunReloadedItems.CHRISTMAS_APPLE_CIDER, 1));
      gifts.add(new CustomItem(SlimefunReloadedItems.CHRISTMAS_FRUIT_CAKE, 4));
      gifts.add(new CustomItem(SlimefunReloadedItems.CHRISTMAS_APPLE_PIE, 4));
      gifts.add(new ItemStack(Material.EMERALD));

      event.getBlockPlaced().getWorld().dropItemNaturally(event.getBlockPlaced().getLocation(), gifts.get(ThreadLocalRandom.current().nextInt(gifts.size())));
    } else if (itemStack.isSimilar(SlimefunReloadedItems.CARGO_INPUT)) {
      if (event.getBlock().getY() != event.getBlockAgainst().getY()) {
        I18n.tl(event.getPlayer(), "machines.CARGO_NODES.must-be-placed");
        event.setCancelled(true);
      }
    } else if (itemStack.isSimilar(SlimefunReloadedItems.CARGO_OUTPUT)) {
      if (event.getBlock().getY() != event.getBlockAgainst().getY()) {
        I18n.tl(event.getPlayer(), "machines.CARGO_NODES.must-be-placed");
        event.setCancelled(true);
      }
    } else if (itemStack.isSimilar(SlimefunReloadedItems.CARGO_OUTPUT_ADVANCED)) {
      if (event.getBlock().getY() != event.getBlockAgainst().getY()) {
        I18n.tl(event.getPlayer(), "machines.CARGO_NODES.must-be-placed");
        event.setCancelled(true);
      }
    } else if (itemStack.isSimilar(SlimefunReloadedItems.CT_IMPORT_BUS)) {
      if (event.getBlock().getY() != event.getBlockAgainst().getY()) {
        I18n.tl(event.getPlayer(), "machines.CARGO_NODES.must-be-placed");
        event.setCancelled(true);
      }
    }
  }

  @EventHandler
  public void onLiquidFlow(BlockFromToEvent event) {
    Block block = event.getToBlock();
    String item = BlockStorage.checkID(block);
    if (item != null) {
      event.setCancelled(true);
    }
  }

  
}
