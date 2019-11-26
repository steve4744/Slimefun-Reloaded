package optic_fusion1.slimefunreloaded.builder;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemStackBuilder {

  private ItemStack itemStack = new ItemStack(Material.AIR);
  private ItemMeta itemMeta = itemStack.getItemMeta();
  private List<String> lore = new ArrayList<>();

  public ItemStackBuilder(Material material, String displayName){
    itemStack.setType(material);
    itemMeta.setDisplayName(displayName);
  }
  
  public ItemStackBuilder(Material material) {
    itemStack.setType(material);
  }

  public ItemStackBuilder setDisplayName(String name) {
    itemMeta.setDisplayName(name);
    return this;
  }

  public ItemStackBuilder addLore(String text) {
    lore.add(text);
    return this;
  }

  public ItemStackBuilder addLore(List<String> list) {
    list.forEach((string) -> {
      addLore(string);
    });
    return this;
  }

  public ItemStack build() {
    itemMeta.setLore(lore);
    itemStack.setItemMeta(itemMeta);
    return itemStack;
  }

}
