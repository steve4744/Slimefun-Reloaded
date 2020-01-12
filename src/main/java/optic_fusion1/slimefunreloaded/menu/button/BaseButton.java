package optic_fusion1.slimefunreloaded.menu.button;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public abstract class BaseButton {

  private int slot;

  public BaseButton(int slot) {
    this.slot = slot;
  }

  public int getSlot() {
    return slot;
  }

  public ItemStack getItemStack() {
    return new ItemStack(Material.STONE);
  }

  public abstract void click();

}
