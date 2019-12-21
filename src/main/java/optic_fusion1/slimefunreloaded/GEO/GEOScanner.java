package optic_fusion1.slimefunreloaded.GEO;

import java.util.logging.Level;
import optic_fusion1.slimefunreloaded.Slimefun;
import optic_fusion1.slimefunreloaded.inventory.ChestMenu;
import optic_fusion1.slimefunreloaded.util.CustomItem;
import optic_fusion1.slimefunreloaded.util.I18n;
import optic_fusion1.slimefunreloaded.util.SkullItem;
import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public final class GEOScanner {

  private static final int[] geoscan_border = new int[]{0, 1, 2, 3, 5, 6, 7, 8, 9, 17, 18, 26, 27, 35, 36, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53};

  private GEOScanner() {
  }

  public static void scanChunk(Player p, Chunk chunk) {
    if (Slimefun.getGPSNetwork().getNetworkComplexity(p.getUniqueId()) < 600) {
      I18n.tl(p, "gps.insufficient-complexity", msg -> msg.replace("%complexity%", "600"));
      return;
    }

    ChestMenu menu = new ChestMenu("&4GEO-Scan Results");
    for (int slot : geoscan_border) {
      menu.addItem(slot, new CustomItem(new ItemStack(Material.GRAY_STAINED_GLASS_PANE), " "),
       (pl, slotn, item, action) -> false
      );
    }

    try {
      menu.addItem(4, new CustomItem(SkullItem.fromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODQ0OWI5MzE4ZTMzMTU4ZTY0YTQ2YWIwZGUxMjFjM2Q0MDAwMGUzMzMyYzE1NzQ5MzJiM2M4NDlkOGZhMGRjMiJ9fX0="), "&eScanned Chunk", "", "&8\u21E8 &7World: " + chunk.getWorld().getName(), "&8\u21E8 &7X: " + chunk.getX() + " Z: " + chunk.getZ()), (pl, slot, stack, action) -> false);
    } catch (Exception e) {
      Slimefun.getLogger().log(Level.SEVERE, "Error while scanning a chunk for Slimefun " + Slimefun.getVersion(), e);
    }

    int index = 10;
    for (OreGenResource resource : OreGenSystem.listResources()) {
      int supply = OreGenSystem.getSupplies(resource, chunk, true);

      ItemStack item = new CustomItem(resource.getItem(), "&r" + resource.getName(), "&8\u21E8 &e" + supply + ' ' + resource.getMeasurementUnit());

      if (supply > 1) {
        item.setAmount(supply > item.getMaxStackSize() ? item.getMaxStackSize() : supply);
      }

      menu.addItem(index, item, (pl, slot, stack, action) -> false);
      index++;

      if (index % 9 == 8) {
        index += 2;
      }
    }

    menu.open(p);
  }

}
