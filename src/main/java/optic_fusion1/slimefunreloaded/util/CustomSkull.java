package optic_fusion1.slimefunreloaded.util;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import java.util.Collection;
import java.util.UUID;
import net.minecraft.server.v1_15_R1.BlockPosition;
import net.minecraft.server.v1_15_R1.TileEntity;
import net.minecraft.server.v1_15_R1.TileEntitySkull;
import optic_fusion1.slimefunreloaded.Slimefun;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_15_R1.CraftWorld;
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

  public static String getTexture(Block block) {
    CraftWorld world = (CraftWorld) block.getWorld();
    TileEntity tile = world.getHandle().getTileEntity(new BlockPosition(block.getX(), block.getY(), block.getZ()));
    if (tile == null) {
      return "";
    }
    GameProfile profile = (GameProfile) ReflectionUtils.getValue(tile, "gameProfile");
    if (profile != null) {
      Collection<Property> collection = (Collection<Property>) profile.getProperties().get("textures");
      for (Property property : collection) {
        if(property.getName().equals("textures")){
          return property.getValue();
        }
      }
    }
    return "";
  }

  public static void setSkull(Block block, String texture) {
    if (getTexture(block).equals(texture)) {
      return;
    }
    if (!(block.getType().equals(Material.PLAYER_HEAD) || block.getType().equals(Material.PLAYER_WALL_HEAD))) {
      throw new IllegalArgumentException("Block is not a Skull");
    }
    GameProfile profile = createProfile(texture);
    CraftWorld world = (CraftWorld) block.getWorld();
    TileEntity tile = world.getHandle().getTileEntity(new BlockPosition(block.getX(), block.getY(), block.getZ()));
    if (tile != null) {
      TileEntitySkull skull = (TileEntitySkull) tile;
      skull.gameProfile = profile;
      block.getState().update(true);
    }
  }
}
