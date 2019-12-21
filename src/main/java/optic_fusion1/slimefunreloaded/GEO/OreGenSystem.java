package optic_fusion1.slimefunreloaded.GEO;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import optic_fusion1.slimefunreloaded.Slimefun;
import optic_fusion1.slimefunreloaded.util.BlockStorage;
import optic_fusion1.slimefunreloaded.util.Config;
import org.bukkit.Chunk;
import org.bukkit.block.Biome;

public final class OreGenSystem {

  private static final Map<String, OreGenResource> resources = new HashMap<>();
  private static final Map<String, Config> resourceConfigs = new HashMap<>();
  
  private OreGenSystem() {
  }

  public static Collection<OreGenResource> listResources() {
    return resources.values();
  }

  public  void registerResource(OreGenResource resource) {
    Config cfg = new Config("plugins/Slimefun/generators/" + resource.getName() + ".yml");
    cfg.setDefaultValue("enabled", true);

    for (Biome biome : Biome.values()) {
      cfg.setDefaultValue("spawn-rates." + biome.toString(), resource.getDefaultSupply(biome));
    }

    cfg.save();

    if (cfg.getBoolean("enabled")) {
      Slimefun.getLogger().log(Level.INFO, "Registering Ore Gen: " + resource.getName());
      resources.put(resource.getName(), resource);
      resourceConfigs.put(resource.getName(), cfg);
    }
  }

  public static OreGenResource getResource(String name) {
    return resources.get(name);
  }

  private static int getDefault(OreGenResource resource, Biome biome) {
    if (resource == null) {
      return 0;
    } else {
      int supply = resourceConfigs.get(resource.getName()).getInt("spawn-rates." + biome.toString());
      return supply > 0 ? (supply + ThreadLocalRandom.current().nextInt(3)) : 0;
    }
  }

  public static void setSupplies(OreGenResource resource, Chunk chunk, int amount) {
    if (resource != null) {
      BlockStorage.setChunkInfo(chunk, "resources_" + resource.getName().toUpperCase(), String.valueOf(amount));
    }
  }

  public static int generateSupplies(OreGenResource resource, Chunk chunk) {
    if (resource == null) {
      return 0;
    }

    int supplies = getDefault(resource, chunk.getBlock(7, 60, 7).getBiome());
    BlockStorage.setChunkInfo(chunk, "resources_" + resource.getName().toUpperCase(), String.valueOf(supplies));
    return supplies;
  }

  public static int getSupplies(OreGenResource resource, Chunk chunk, boolean generate) {
    if (resource == null) {
      return 0;
    }

    String supply = BlockStorage.getChunkInfo(chunk, "resources_" + resource.getName().toUpperCase());
    if (supply != null) {
      return Integer.parseInt(supply);
    } else if (!generate) {
      return 0;
    } else {
      return generateSupplies(resource, chunk);
    }
  }

  public static boolean wasResourceGenerated(OreGenResource resource, Chunk chunk) {
    if (resource == null) {
      return false;
    }
    return BlockStorage.hasChunkInfo(chunk, "resources_" + resource.getName().toUpperCase());
  }

}
