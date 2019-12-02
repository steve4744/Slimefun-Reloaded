package optic_fusion1.slimefunreloaded.util;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionType;

public class CustomPotion extends CustomItem {

  public CustomPotion(String name, PotionType type, PotionEffect effect, String... lore) {
    super(Material.POTION, name, lore);
    PotionMeta meta = (PotionMeta) getItemMeta();
    meta.setBasePotionData(new PotionData(type));
    meta.addCustomEffect(effect, true);
    setItemMeta(meta);
  }

  public CustomPotion(String name, Color color, PotionEffect effect, String... lore) {
    super(Material.POTION, name, lore);
    PotionMeta meta = (PotionMeta) getItemMeta();
    meta.setColor(color);
    meta.addCustomEffect(effect, true);
    setItemMeta(meta);
  }

}
