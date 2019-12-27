package optic_fusion1.slimefunreloaded.util;

import java.io.File;
import java.util.Iterator;
import java.util.Map;
import optic_fusion1.slimefunreloaded.component.SlimefunReloadedComponent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

public class CustomTextureService {

  private final Config config;

  public CustomTextureService(Plugin plugin) {
    this.config = new Config(new File(plugin.getDataFolder(), "item-models.yml"));
  }

  public void setup(Map<String, SlimefunReloadedComponent> components) {
    config.setDefaultValue("SLIMEFUNRELOADED_GUIDE", 0);
    Iterator it = components.entrySet().iterator();
    while (it.hasNext()) {
      Map.Entry pair = (Map.Entry) it.next();
      SlimefunReloadedComponent component = (SlimefunReloadedComponent) pair.getValue();
      if (component != null && component.getID() != null) {
        config.setDefaultValue(component.getID(), 0);
      }
      it.remove();
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
