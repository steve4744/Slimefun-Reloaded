package optic_fusion1.slimefunreloaded.listener;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import optic_fusion1.slimefunreloaded.Slimefun;
import optic_fusion1.slimefunreloaded.component.ComponentManager;
import optic_fusion1.slimefunreloaded.component.NotPlaceable;
import optic_fusion1.slimefunreloaded.component.SlimefunReloadedComponent;
import optic_fusion1.slimefunreloaded.component.UnregisterReason;
import optic_fusion1.slimefunreloaded.component.item.SlimefunReloadedBlock;
import optic_fusion1.slimefunreloaded.component.item.SlimefunReloadedItem;
import optic_fusion1.slimefunreloaded.util.BlockStorage;
import optic_fusion1.slimefunreloaded.util.CustomItem;
import optic_fusion1.slimefunreloaded.util.FireworkShow;
import optic_fusion1.slimefunreloaded.util.I18n;
import optic_fusion1.slimefunreloaded.util.ItemUtils;
import optic_fusion1.slimefunreloaded.util.SlimefunReloadedItems;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Tag;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.block.TileState;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockFromToEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.inventory.ItemStack;

public class ToolListener implements Listener {

  // Materials that require a Block under it, e.g. Pressure Plates
  private final Set<Material> sensitiveMaterials = new HashSet<>();
  private static final ComponentManager COMPONENT_MANAGER = Slimefun.getComponentManager();
  private final List<UUID> cancelPlace = new ArrayList<>();

  public ToolListener() {
    sensitiveMaterials.add(Material.STONE_PRESSURE_PLATE);
    sensitiveMaterials.add(Material.LIGHT_WEIGHTED_PRESSURE_PLATE);
    sensitiveMaterials.add(Material.HEAVY_WEIGHTED_PRESSURE_PLATE);
    sensitiveMaterials.addAll(Tag.SAPLINGS.getValues());
    sensitiveMaterials.addAll(Tag.WOODEN_PRESSURE_PLATES.getValues());
  }

  @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
  public void onBlockRegister(BlockPlaceEvent event) {
    Block placedBlock = event.getBlock();
    if (BlockStorage.hasBlockInfo(placedBlock)) {
      event.setCancelled(true);
      return;
    }
    ItemStack itemStack = event.getItemInHand();
    SlimefunReloadedComponent component = COMPONENT_MANAGER.getComponentByItem(itemStack);
    if (component != null && !component.isDisabled() && !(component instanceof NotPlaceable)) {
      if (!Slimefun.hasUnlocked(event.getPlayer(), component, true)) {
        event.setCancelled(true);
        return;
      }
      BlockState blockState = event.getBlock().getState();
      if (blockState instanceof TileState) {
        Slimefun.getBlockDataService().setBlockData((TileState) blockState, component.getID());
      }
      BlockStorage.addBlockInfo(placedBlock, "id", component.getID(), true);
      if (component instanceof SlimefunReloadedBlock) {
        ((SlimefunReloadedBlock) component).onBlockPlace(event, itemStack, event.getPlayer(), placedBlock, component);
      }

    } else {
      if (component != null && component instanceof SlimefunReloadedBlock) {
        ((SlimefunReloadedBlock) component).onBlockPlace(event, itemStack, event.getPlayer(), placedBlock, component);
      }
    }
  }

  @EventHandler
  public void onBlockPlace(BlockPlaceEvent event) {
    ItemStack itemStack = event.getItemInHand();
    if (cancelPlace.remove(event.getPlayer().getUniqueId())) {
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

  @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
  public void onBlockBreak(BlockBreakEvent event) {
    boolean allow = true;
    List<ItemStack> drops = new ArrayList<>();
    ItemStack itemStack = event.getPlayer().getInventory().getItemInMainHand();
    int fortune = 1;
    Block relativeBlock = event.getBlock().getRelative(BlockFace.UP);
    if (sensitiveMaterials.contains(relativeBlock.getType())) {
      SlimefunReloadedComponent component = BlockStorage.check(event.getBlock().getRelative(BlockFace.UP));
      if (component == null) {
        BlockState blockState = relativeBlock.getState();
        if (blockState instanceof TileState) {
          Optional<String> blockData = Slimefun.getBlockDataService().getBlockData((TileState) blockState);
          if (blockData.isPresent()) {
            component = COMPONENT_MANAGER.getComponentByKey(blockData.get());
          }
        }
      }
      if (component != null && component instanceof SlimefunReloadedBlock) {
        allow = ((SlimefunReloadedBlock) component).onBlockBreak(event, event.getPlayer(), relativeBlock, itemStack, fortune, component, UnregisterReason.PLAYER_BREAK);
        if (!allow) {
          event.setCancelled(true);
          return;
        }
        relativeBlock.getWorld().dropItemNaturally(relativeBlock.getLocation(), BlockStorage.retrieve(relativeBlock));
        relativeBlock.setType(Material.AIR);
      }
    }
    SlimefunReloadedComponent component = BlockStorage.check(event.getBlock());
    if (component == null) {
      BlockState blockState = event.getBlock().getState();
      if (blockState instanceof TileState) {
        Optional<String> blockData = Slimefun.getBlockDataService().getBlockData((TileState) blockState);
        if (blockData.isPresent()) {
          component = COMPONENT_MANAGER.getComponentByKey(blockData.get());
        }
      }
    }
    if (component != null && component instanceof SlimefunReloadedBlock) {
      allow = ((SlimefunReloadedBlock) component).onBlockBreak(event, event.getPlayer(), relativeBlock, itemStack, fortune, component, UnregisterReason.PLAYER_BREAK);
      if (!allow) {
        event.setCancelled(true);
        return;
      }
//      drops.addAll(component.getDrops());
      BlockStorage.clearBlockInfo(event.getBlock());
    } else if (itemStack != null) {
      if (itemStack.getEnchantments().containsKey(Enchantment.LOOT_BONUS_BLOCKS) && !itemStack.getEnchantments().containsKey(Enchantment.SILK_TOUCH)) {
        Random random = ThreadLocalRandom.current();
        fortune = random.nextInt(itemStack.getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) + 2) - 1;
        if (fortune <= 0) {
          fortune = 1;
        }
        fortune = (event.getBlock().getType() == Material.LAPIS_ORE ? 4 + random.nextInt(5) : 1) * (fortune + 1);
      }
      ((SlimefunReloadedItem) component).onBlockBreak(event, event.getPlayer(), relativeBlock, itemStack, fortune, component);
    }
    if (!drops.isEmpty()) {
      event.getBlock().setType(Material.AIR);
      if (event.isDropItems()) {
        for (ItemStack drop : drops) {
          if (drop != null) {
            event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), drop);
          }
        }
      }
    }
  }

  @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
  public void onEntityExplode(EntityExplodeEvent event) {
    Iterator<Block> blocks = event.blockList().iterator();
    while (blocks.hasNext()) {
      Block block = blocks.next();
      String id = BlockStorage.checkID(block);
      if (id != null) {
        blocks.remove();
        if (!id.equalsIgnoreCase("HARDENED_GLASS") && !id.equalsIgnoreCase("WITHER_PROOF_OBSIDIAN") && !id.equalsIgnoreCase("WITHER_PROOF_GLASS") && !id.equalsIgnoreCase("FORCEFIELD_PROJECTOR") && !id.equalsIgnoreCase("FORCEFIELD_RELAY")) {
          boolean success = true;
          SlimefunReloadedComponent component = COMPONENT_MANAGER.getComponentByKey(id);
          success = ((SlimefunReloadedBlock) component).onBlockBreak(null, null, block, null, -1, component, UnregisterReason.EXPLODE);
          if (success) {
            BlockStorage.clearBlockInfo(block);
            block.setType(Material.AIR);
          }
        }
      }
    }
  }

  @EventHandler
  public void onLiquidFlow(BlockFromToEvent event) {
    Block block = event.getToBlock();
    if (BlockStorage.checkID(block) != null) {
      event.setCancelled(true);
    }
  }
}
