package optic_fusion1.slimefunreloaded.util;

import com.mojang.authlib.GameProfile;
import java.util.UUID;
import optic_fusion1.slimefunreloaded.Slimefun;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CustomSkull {

  private static final Config CONFIG = Slimefun.getCfg();

  private static GameProfile createProfile(String texture) {
    if (!CONFIG.contains("skulls.uuids." + texture)) {
      CONFIG.setValue("skulls.uuids." + texture, UUID.randomUUID().toString());
      CONFIG.save();
    }
    GameProfile profile = new GameProfile(UUID.fromString(CONFIG.getString("skulls.uuids." + texture)), "Slimefun-Reloaded");
    return profile;
  }

  public static ItemStack getItem(String texture) {
    GameProfile profile = createProfile(texture);
    ItemStack item = new ItemStack(Material.PLAYER_HEAD);
    ItemMeta itemMeta = item.getItemMeta();
    ReflectionUtils.setValue(item, "profile", profile);
    item.setItemMeta(itemMeta);
    return item;
  }

}
