package optic_fusion1.slimefunreloaded.util;

import java.util.Optional;
import optic_fusion1.slimefunreloaded.component.item.SlimefunReloadedArmorPiece;
import optic_fusion1.slimefunreloaded.component.item.SlimefunReloadedItem;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;

public final class HashedArmorpiece {

  private int hash;
  private Optional<SlimefunReloadedArmorPiece> item;

  protected HashedArmorpiece() {
    this.hash = 0;
    this.item = Optional.empty();
  }

  public void update(ItemStack stack, SlimefunReloadedItem item) {
    if (stack == null) {
      this.hash = 0;
    } else {
      ItemStack copy = stack.clone();
      ItemMeta meta = copy.getItemMeta();
      ((Damageable) meta).setDamage(0);
      copy.setItemMeta(meta);
      this.hash = copy.hashCode();
    }

    if (item instanceof SlimefunReloadedArmorPiece) {
      this.item = Optional.of((SlimefunReloadedArmorPiece) item);
    } else {
      this.item = Optional.empty();
    }
  }

  public boolean hasDiverged(ItemStack stack) {
    if (stack == null) {
      return hash == 0;
    } else {
      ItemStack copy = stack.clone();
      ItemMeta meta = copy.getItemMeta();
      ((Damageable) meta).setDamage(0);
      copy.setItemMeta(meta);
      return copy.hashCode() != hash;
    }
  }

  public Optional<SlimefunReloadedArmorPiece> getItem() {
    return item;
  }

}
