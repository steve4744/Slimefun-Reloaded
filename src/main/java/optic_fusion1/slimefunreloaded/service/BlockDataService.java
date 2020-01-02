package optic_fusion1.slimefunreloaded.service;

import java.util.Optional;
import optic_fusion1.slimefunreloaded.util.PersistentDataAPI;
import org.bukkit.NamespacedKey;
import org.bukkit.block.TileState;
import org.bukkit.plugin.Plugin;

public class BlockDataService {

  private final NamespacedKey namespacedKey;

  public BlockDataService(Plugin plugin, String key) {
    namespacedKey = new NamespacedKey(plugin, key);
  }

  public void setBlockData(TileState tileEntity, String value) {
    PersistentDataAPI.setString(tileEntity, namespacedKey, value);
    tileEntity.update();
  }

  public Optional<String> getBlockData(TileState tileEntity) {
    return PersistentDataAPI.getOptionalString(tileEntity, namespacedKey);
  }

}
