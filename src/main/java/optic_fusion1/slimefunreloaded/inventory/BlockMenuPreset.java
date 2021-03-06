package optic_fusion1.slimefunreloaded.inventory;

import java.util.HashSet;
import java.util.Set;
import optic_fusion1.slimefunreloaded.Slimefun;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

@Deprecated
public abstract class BlockMenuPreset extends ChestMenu {

  private String inventoryTitle;
  private Set<Integer> occupied = new HashSet<>();
  private String id;
  private int size = -1;
  private boolean universal;

  private ItemManipulationEvent event;

  public BlockMenuPreset(String id, String inventoryTitle) {
    super(inventoryTitle);
    this.id = id;
    this.inventoryTitle = inventoryTitle;
    this.init();
    this.universal = false;
    Slimefun.getBlockMenuPresets().put(id, this);
  }

  public void registerEvent(ItemManipulationEvent event) {
    this.event = event;
  }

  public BlockMenuPreset(String id, String inventoryTitle, boolean universal) {
    super(inventoryTitle);
    this.id = id;
    this.inventoryTitle = inventoryTitle;
    this.init();
    this.universal = universal;
    Slimefun.getBlockMenuPresets().put(id, this);
  }

  public abstract void init();

  public abstract boolean canOpen(Block b, Player p);

//  public abstract int[] getSlotsAccessedByItemTransport(ItemTransportFlow flow);

  public void newInstance(BlockMenu menu, Block b) {
    // This method can optionally be overridden by implementations
  }

//  public int[] getSlotsAccessedByItemTransport(BlockMenu menu, ItemTransportFlow flow, ItemStack item) {
//    // This method will default to this method, can be overridden though
//    return this.getSlotsAccessedByItemTransport(flow);
//  }
//
//  public int[] getSlotsAccessedByItemTransport(UniversalBlockMenu menu, ItemTransportFlow flow, ItemStack item) {
//    // This method will default to this method, can be overridden though
//    return this.getSlotsAccessedByItemTransport(flow);
//  }

  @Override
  public ChestMenu addItem(int slot, ItemStack item) {
    occupied.add(slot);
    return super.addItem(slot, item);
  }

  public ChestMenu setSize(int size) {
    this.size = size;
    return this;
  }

  public int getSize() {
    return size;
  }

  public String getTitle() {
    return inventoryTitle;
  }

  public Set<Integer> getPresetSlots() {
    return occupied;
  }

  public Set<Integer> getInventorySlots() {
    Set<Integer> empty = new HashSet<>();
    if (size > -1) {
      for (int i = 0; i < size; i++) {
        if (!occupied.contains(i)) {
          empty.add(i);
        }
      }
    } else {
      for (int i = 0; i < toInventory().getSize(); i++) {
        if (!occupied.contains(i)) {
          empty.add(i);
        }
      }
    }
    return empty;
  }

  public static BlockMenuPreset getPreset(String id) {
    return id == null ? null : Slimefun.getBlockMenuPresets().get(id);
  }

  public static boolean isInventory(String id) {
    return Slimefun.getBlockMenuPresets().containsKey(id);
  }

  public static boolean isUniversalInventory(String id) {
    BlockMenuPreset preset = Slimefun.getBlockMenuPresets().get(id);
    return preset != null && preset.isUniversal();
  }

  public boolean isUniversal() {
    return this.universal;
  }

  public void clone(final BlockMenu menu) {
    menu.setPlayerInventoryClickable(true);

    for (int slot : occupied) {
      menu.addItem(slot, getItemInSlot(slot));
    }

    if (size > -1) {
      menu.addItem(size - 1, null);
    }

    newInstance(menu, menu.getLocation());
    for (int slot = 0; slot < 54; slot++) {
      if (getMenuClickHandler(slot) != null) {
        menu.addMenuClickHandler(slot, getMenuClickHandler(slot));
      }
    }

    menu.addMenuOpeningHandler(getMenuOpeningHandler());
    menu.addMenuCloseHandler(getMenuCloseHandler());
    menu.registerEvent(event);
  }

  public void clone(UniversalBlockMenu menu) {
    menu.setPlayerInventoryClickable(true);

    for (int slot : occupied) {
      menu.addItem(slot, getItemInSlot(slot));
    }

    if (size > -1) {
      menu.addItem(size - 1, null);
    }
    for (int slot = 0; slot < 54; slot++) {
      if (getMenuClickHandler(slot) != null) {
        menu.addMenuClickHandler(slot, getMenuClickHandler(slot));
      }
    }

    menu.addMenuOpeningHandler(getMenuOpeningHandler());
    menu.addMenuCloseHandler(getMenuCloseHandler());
    menu.registerEvent(this.event);
  }

  public String getID() {
    return id;
  }

  public void newInstance(final BlockMenu menu, final Location l) {
    Bukkit.getScheduler().runTask(Slimefun.getSlimefunReloaded(), () -> newInstance(menu, l.getBlock()));
  }

}
