package optic_fusion1.slimefunreloaded.menu.border;

import optic_fusion1.slimefunreloaded.menu.BaseMenu;
import org.bukkit.inventory.ItemStack;

public abstract class BaseBorder {

  private int[] slots;
  private ItemStack itemStack;

  public BaseBorder(int[] slots, ItemStack itemStack) {
    this.slots = slots;
    this.itemStack = itemStack;
  }

  public void applyTo(BaseMenu menu){
    for(int slot : slots){
      menu.setItem(slot, itemStack);
    }
  }
  
  public int[] getSlots() {
    return slots;
  }

  public ItemStack getItemStack() {
    return itemStack;
  }

}
