package optic_fusion1.slimefunreloaded.util;

import java.util.Collection;
import optic_fusion1.slimefunreloaded.component.item.SlimefunReloadedItem;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

public class CustomTextureService {

  private final Config config;

  public CustomTextureService(Plugin plugin) {
    this.config = new Config(plugin, "item-models.yml");
  }

  public void setup(Collection<SlimefunReloadedItem> items) {
    config.setDefaultValue("SLIMEFUN_GUIDE", 0);

    for (SlimefunReloadedItem item : items) {
      if (item != null && item.getID() != null) {
        config.setDefaultValue(item.getID(), 0);
      }
    }

    config.save();
  }

  public int getModelData(String id) {
    return config.getInt(id);
  }

  public void setTexture(ItemStack item, String id) {
    ItemMeta im = item.getItemMeta();
    setTexture(im, id);
    item.setItemMeta(im);
  }

  public void setTexture(ItemMeta im, String id) {
    int data = getModelData(id);
    im.setCustomModelData(data == 0 ? null : data);
  }

}
