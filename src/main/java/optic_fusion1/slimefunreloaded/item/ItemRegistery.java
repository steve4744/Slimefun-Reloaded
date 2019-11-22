package optic_fusion1.slimefunreloaded.item;

import optic_fusion1.slimefunreloaded.Slimefun;

public class ItemRegistery {

  private static final ItemManager ITEM_MANAGER = Slimefun.getItemManager();

  public void registerItems() {
  }

  private void register(SlimefunReloadedItem item) {
    ITEM_MANAGER.addItem(item);
  }

}
