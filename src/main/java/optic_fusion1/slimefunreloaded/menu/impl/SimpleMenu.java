package optic_fusion1.slimefunreloaded.menu.impl;

import optic_fusion1.slimefunreloaded.menu.BaseMenu;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.InventoryHolder;

public class SimpleMenu extends BaseMenu {

  public SimpleMenu(InventoryHolder owner, InventoryType inventoryType) {
    super(owner, inventoryType);
  }

  public SimpleMenu(InventoryHolder owner, int size) {
    super(owner, size);
  }

  public SimpleMenu(InventoryHolder owner, InventoryType inventoryType, String title) {
    super(owner, inventoryType, title);
  }

  public SimpleMenu(InventoryHolder owner, String title, int size) {
    super(owner, title, size);
  }

  public SimpleMenu(String title, int size) {
    super(title, size);
  }

  public SimpleMenu(String title) {
    super(title);
  }

}
