package optic_fusion1.slimefunreloaded.util;

import java.util.function.Consumer;
import java.util.logging.Level;
import optic_fusion1.slimefunreloaded.Slimefun;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SlimefunReloadedItemStack extends CustomItem {

  private String id;

  public SlimefunReloadedItemStack(String id, Material type, String name, String... lore) {
    super(type, name, lore);

    setID(id);
  }

  public SlimefunReloadedItemStack(String id, Material type, Color color, String name, String... lore) {
    super(new ItemStack(type), color, name, lore);

    setID(id);
  }

  public SlimefunReloadedItemStack(String id, ItemStack item, String name, String... lore) {
    super(item, name, lore);

    setID(id);
  }

  public SlimefunReloadedItemStack(String id, ItemStack item) {
    super(item);

    setID(id);
  }

  public SlimefunReloadedItemStack(String id, ItemStack item, Consumer<ItemMeta> consumer) {
    super(item, consumer);

    setID(id);
  }

  public SlimefunReloadedItemStack(String id, String texture, String name, String... lore) {
    super(getSkull(texture), name, lore);

    setID(id);
  }

  private void setID(String id) {
    this.id = id;

    ItemMeta meta = getItemMeta();

    Slimefun.getItemDataService().setItemData(meta, id);
    Slimefun.getItemTextureService().setTexture(meta, id);

    setItemMeta(meta);
  }

  private static ItemStack getSkull(String texture) {
    try {
      return CustomSkull.getItem(texture);
    } catch (Exception x) {
      Slimefun.getLogger().log(Level.SEVERE, "An Error occurred while initializing the Items for Slimefun " + Slimefun.getVersion(), x);

      return new ItemStack(Material.PLAYER_HEAD);
    }
  }

  public String getItemID() {
    return id;
  }

}
