package optic_fusion1.slimefunreloaded.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.ItemStack;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import optic_fusion1.slimefunreloaded.Slimefun;
import optic_fusion1.slimefunreloaded.component.ComponentManager;
import optic_fusion1.slimefunreloaded.component.SlimefunReloadedComponent;
import optic_fusion1.slimefunreloaded.component.item.SlimefunReloadedItem;

public class BlockStorage {

  private static final String path_blocks = "plugins/SlimefunReloaded/data-storage/stored-blocks/";
  private static final String path_chunks = "plugins/SlimefunReloaded/data-storage/stored-chunks/";

  private World world;
  private Map<Location, Config> storage = new HashMap<>();
  private Map<Location, BlockMenu> inventories = new HashMap<>();
  private Map<String, Config> blocksCache = new HashMap<>();
  private static final ComponentManager COMPONENT_MANAGER = Slimefun.getComponentManager();

  public static BlockStorage getStorage(World world) {
    return Slimefun.getWorlds().get(world.getName());
  }

  public static BlockStorage getForcedStorage(World world) {
    return isWorldRegistered(world.getName()) ? Slimefun.getWorlds().get(world.getName()) : new BlockStorage(world);
  }

  private static String serializeLocation(Location l) {
    return l.getWorld().getName() + ';' + l.getBlockX() + ';' + l.getBlockY() + ';' + l.getBlockZ();
  }

  private static String serializeChunk(Chunk chunk) {
    return chunk.getWorld().getName() + ";Chunk;" + chunk.getX() + ';' + chunk.getZ();
  }

  private static String locationToChunkString(Location l) {
    return l.getWorld().getName() + ";Chunk;" + (l.getBlockX() >> 4) + ';' + (l.getBlockZ() >> 4);
  }

  private static Location deserializeLocation(String l) {
    try {
      String[] components = l.split(";");
      if (components.length != 4) {
        return null;
      }

      World w = Bukkit.getWorld(components[0]);
      if (w != null) {
        return new Location(w, Integer.parseInt(components[1]), Integer.parseInt(components[2]), Integer.parseInt(components[3]));
      }
    } catch (NumberFormatException x) {
      Slimefun.getLogger().log(Level.WARNING, "Could not parse Number", x);
    }
    return null;
  }

  public BlockStorage(final World w) {
    if (Slimefun.getWorlds().containsKey(w.getName())) {
      return;
    }
    this.world = w;

    Slimefun.getLogger().log(Level.INFO, "Loading Blocks for World \"" + w.getName() + "\"");
    Slimefun.getLogger().log(Level.INFO, "This may take a long time...");

    File f = new File(path_blocks + w.getName());
    if (f.exists()) {
      long total = f.listFiles().length;
      long start = System.currentTimeMillis();
      long done = 0;
      long timestamp = System.currentTimeMillis();
      long totalBlocks = 0;

      try {
        for (File file : f.listFiles()) {
          if (file.getName().equals("null.sfb")) {
            Slimefun.getLogger().log(Level.WARNING, "Corrupted file detected!");
            Slimefun.getLogger().log(Level.WARNING, "Slimefun will simply skip this File, but you");
            Slimefun.getLogger().log(Level.WARNING, "should maybe look into it!");
            Slimefun.getLogger().log(Level.WARNING, file.getPath());
          } else if (file.getName().endsWith(".sfb")) {
            if (timestamp + Slimefun.getBlocksInfoLoadingDelay() < System.currentTimeMillis()) {
              Slimefun.getLogger().log(Level.INFO, "Loading Blocks... " + Math.round((((done * 100.0F) / total) * 100.0F) / 100.0F) + "% done (\"" + w.getName() + "\")");
              timestamp = System.currentTimeMillis();
            }

            FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
            for (String key : cfg.getKeys(false)) {
              Location l = deserializeLocation(key);
              String chunkString = locationToChunkString(l);
              try {
                totalBlocks++;
                String json = cfg.getString(key);
                Config blockInfo = parseBlockInfo(l, json);
                if (blockInfo == null || !blockInfo.contains("id")) {
                  continue;
                }
                if (storage.containsKey(l)) {
                  // It should not be possible to have two blocks on the same location. Ignore the
                  // new entry if a block is already present and print an error to the console.

                  Slimefun.getLogger().log(Level.INFO, "Ignoring duplicate block @ " + l.getBlockX() + ", " + l.getBlockY() + ", " + l.getBlockZ());
                  Slimefun.getLogger().log(Level.INFO, "Old block data: " + serializeBlockInfo(storage.get(l)));
                  Slimefun.getLogger().log(Level.INFO, "New block data (" + key + "): " + json);
                  continue;
                }
                storage.put(l, blockInfo);

                if (SlimefunReloadedItem.isTicking(file.getName().replace(".sfb", ""))) {
                  Set<Location> locations = Slimefun.getTickingChunks().getOrDefault(chunkString, new HashSet<>());
                  locations.add(l);
                  Slimefun.getTickingChunks().put(chunkString, locations);

                  if (!Slimefun.getLoadedTickers().contains(chunkString)) {
                    Slimefun.getLoadedTickers().add(chunkString);
                  }
                }
              } catch (Exception x) {
                Slimefun.getLogger().log(Level.WARNING, "Failed to load " + file.getName() + '(' + key + ") for Slimefun " + Slimefun.getVersion(), x);
              }
            }
            done++;
          }
        }
      } finally {
        long time = (System.currentTimeMillis() - start);
        Slimefun.getLogger().log(Level.INFO, "Loading Blocks... 100% (FINISHED - " + time + "ms)");
        Slimefun.getLogger().log(Level.INFO, "Loaded a total of " + totalBlocks + " Blocks for World \"" + world.getName() + "\"");

        if (totalBlocks > 0) {
          Slimefun.getLogger().log(Level.INFO, "Avg: " + DoubleHandler.fixDouble((double) time / (double) totalBlocks, 3) + "ms/Block");
        }
      }
    } else {
      f.mkdirs();
    }

    File chunks = new File(path_chunks + "chunks.sfc");
    if (chunks.exists()) {
      FileConfiguration cfg = YamlConfiguration.loadConfiguration(chunks);
      for (String key : cfg.getKeys(false)) {
        try {
          if (world.getName().equals(key.split(";")[0])) {
            Slimefun.getMapChunks().put(key, new BlockInfoConfig(parseJSON(cfg.getString(key))));
          }
        } catch (Exception x) {
          Slimefun.getLogger().log(Level.WARNING, "Failed to load " + chunks.getName() + " in World " + world.getName() + '(' + key + ") for Slimefun " + Slimefun.getVersion(), x);
        }
      }
    }

    Slimefun.getWorlds().put(world.getName(), this);
    for (File file : new File("plugins/SlimefunReloaded/data-storage-stored-inventories").listFiles()) {
      if (file.getName().startsWith(w.getName()) && file.getName().endsWith(".sfi")) {
        Location l = deserializeLocation(file.getName().replace(".sfi", ""));
        Config cfg = new Config(file);

        try {
          BlockMenuPreset preset = BlockMenuPreset.getPreset(cfg.getString("preset"));
          if (preset == null) {
            preset = BlockMenuPreset.getPreset(checkID(l));
          }

          if (preset != null) {
            inventories.put(l, new BlockMenu(preset, l, cfg));
          }
        } catch (Exception x) {
          Slimefun.getLogger().log(Level.SEVERE, "An Error occured while loading this Inventory: " + file.getName(), x);
        }
      }
    }

    for (File file : new File("data-storage/SlimefunReloaded/universal-inventories").listFiles()) {
      if (file.getName().endsWith(".sfi")) {
        Config cfg = new Config(file);
        BlockMenuPreset preset = BlockMenuPreset.getPreset(cfg.getString("preset"));

        if (preset != null) {
          Slimefun.getUniversalInventories().put(preset.getID(), new UniversalBlockMenu(preset, cfg));
        }
      }
    }
  }

  private static int chunkChanges = 0;
  private int changes = 0;

  public void computeChanges() {
    changes = blocksCache.size() + chunkChanges;

    Map<Location, BlockMenu> inventories2 = new HashMap<>(inventories);
    for (Map.Entry<Location, BlockMenu> entry : inventories2.entrySet()) {
      changes += entry.getValue().getUnsavedChanges();
    }

    Map<String, UniversalBlockMenu> universalInventories2 = new HashMap<>(Slimefun.getUniversalInventories());
    for (Map.Entry<String, UniversalBlockMenu> entry : universalInventories2.entrySet()) {
      changes += entry.getValue().getUnsavedChanges();
    }
  }

  public int getChanges() {
    return changes;
  }

  public void save(boolean remove) {
    this.save(true, remove);
  }

  public void save(boolean computeChanges, boolean remove) {
    if (computeChanges) {
      computeChanges();
    }
    if (changes == 0) {
      return;
    }

    Slimefun.getLogger().log(Level.INFO, "Saving Blocks for World \"" + world.getName() + "\" (" + changes + " Change(s) queued)");

    Map<String, Config> cache = new HashMap<>(blocksCache);

    for (Map.Entry<String, Config> entry : cache.entrySet()) {
      blocksCache.remove(entry.getKey());
      Config cfg = entry.getValue();

      if (cfg.getKeys().isEmpty()) {
        if (!cfg.getFile().delete()) {
          Slimefun.getLogger().log(Level.WARNING, "Could not delete File: " + cfg.getFile().getName());
        }
      } else {
        File tmpFile = new File(cfg.getFile().getParentFile(), cfg.getFile().getName() + ".tmp");
        cfg.save(tmpFile);

        try {
          Files.move(tmpFile.toPath(), cfg.getFile().toPath(), StandardCopyOption.ATOMIC_MOVE);
        } catch (IOException x) {
          Slimefun.getLogger().log(Level.SEVERE, "An Error occured while copying a temporary File for Slimefun " + Slimefun.getVersion(), x);
        }
      }
    }

    Map<Location, BlockMenu> inventories2 = new HashMap<>(inventories);

    for (Map.Entry<Location, BlockMenu> entry : inventories2.entrySet()) {
      entry.getValue().save(entry.getKey());
    }

    Map<String, UniversalBlockMenu> universalInventories2 = new HashMap<>(Slimefun.getUniversalInventories());

    for (Map.Entry<String, UniversalBlockMenu> entry : universalInventories2.entrySet()) {
      entry.getValue().save();
    }

    if (chunkChanges > 0) {
      File chunks = new File(path_chunks + "chunks.sfc");
      Config cfg = new Config(path_chunks + "chunks.temp");

      for (Map.Entry<String, BlockInfoConfig> entry : Slimefun.getMapChunks().entrySet()) {
        cfg.setValue(entry.getKey(), entry.getValue().toJSON());
      }

      cfg.save(chunks);

      if (remove) {
        Slimefun.getWorlds().remove(world.getName());
      }
    }

    changes = 0;
    chunkChanges = 0;
  }

  public static void store(Block block, ItemStack item) {
    SlimefunReloadedComponent component = COMPONENT_MANAGER.getComponentByItem(item);
    if (component != null) {
      addBlockInfo(block, "id", component.getID(), true);
    }
  }

  public static void store(Block block, String item) {
    addBlockInfo(block, "id", item, true);
  }

  /**
   * Retrieves the SlimefunReloadedItem's ItemStack from the specified Block. If the specified Block is registered in BlockStorage, its data will be erased from it, regardless of the returned value.
   *
   * @param block the block to retrieve the ItemStack from
   * @return the SlimefunReloadedItem's ItemStack corresponding to the block if it has one, otherwise null
   *
   * @since 4.0
   */
  public static ItemStack retrieve(Block block) {
    if (!hasBlockInfo(block)) {
      return null;
    } else {
      final SlimefunReloadedComponent item = COMPONENT_MANAGER.getComponentByNamespace(getLocationInfo(block.getLocation(), "id"));
      clearBlockInfo(block);
      if (item == null) {
        return null;
      } else {
        return item.getItem();
      }
    }
  }

  public static Config getLocationInfo(Location l) {
    BlockStorage storage = getStorage(l.getWorld());
    Config cfg = storage.storage.get(l);
    return cfg == null ? new BlockInfoConfig() : cfg;
  }

  private static Map<String, String> parseJSON(String json) {
    Map<String, String> map = new HashMap<>();

    if (json != null && json.length() > 2) {
      JsonParser parser = new JsonParser();
      JsonObject obj = parser.parse(json).getAsJsonObject();
      for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
        map.put(entry.getKey(), entry.getValue().getAsString());
      }
    }
    return map;
  }

  private static BlockInfoConfig parseBlockInfo(Location l, String json) {
    try {
      return new BlockInfoConfig(parseJSON(json));
    } catch (Exception x) {
      Logger logger = Slimefun.getLogger();
      logger.log(Level.WARNING, x.getClass().getName());
      logger.log(Level.WARNING, "Failed to parse BlockInfo for Block @ " + l.getBlockX() + ", " + l.getBlockY() + ", " + l.getBlockZ());
      logger.log(Level.WARNING, json);
      logger.log(Level.WARNING, "");
      logger.log(Level.WARNING, "IGNORE THIS ERROR UNLESS IT IS SPAMMING");
      logger.log(Level.WARNING, "");
      logger.log(Level.SEVERE, "An Error occured while parsing Block Info for Slimefun " + Slimefun.getVersion(), x);
      return null;
    }
  }

  private static String serializeBlockInfo(Config cfg) {
    JsonObject json = new JsonObject();
    for (String key : cfg.getKeys()) {
      json.add(key, new JsonPrimitive(cfg.getString(key)));
    }
    return json.toString();
  }

  private static String getJSONData(Chunk chunk) {
    if (chunk == null) {
      return null;
    }
    return Slimefun.getMapChunks().get(serializeChunk(chunk)).toJSON();
  }

  public static String getLocationInfo(Location l, String key) {
    return getLocationInfo(l).getString(key);
  }

  public static void addBlockInfo(Location l, String key, String value) {
    addBlockInfo(l, key, value, false);
  }

  public static void addBlockInfo(Block block, String key, String value) {
    addBlockInfo(block.getLocation(), key, value);
  }

  public static void addBlockInfo(Block block, String key, String value, boolean updateTicker) {
    addBlockInfo(block.getLocation(), key, value, updateTicker);
  }

  public static void addBlockInfo(Location l, String key, String value, boolean updateTicker) {
    Config cfg = hasBlockInfo(l) ? getLocationInfo(l) : new BlockInfoConfig();
    cfg.setValue(key, value);
    setBlockInfo(l, cfg, updateTicker);
  }

  public static boolean hasBlockInfo(Block block) {
    return hasBlockInfo(block.getLocation());
  }

  public static boolean hasBlockInfo(Location l) {
    BlockStorage storage = getStorage(l.getWorld());
    return storage != null && storage.storage.containsKey(l) && getLocationInfo(l, "id") != null;
  }

  public static void setBlockInfo(Block block, Config cfg, boolean updateTicker) {
    setBlockInfo(block.getLocation(), cfg, updateTicker);
  }

  public static void setBlockInfo(Location l, Config cfg, boolean updateTicker) {
    BlockStorage storage = getStorage(l.getWorld());
    storage.storage.put(l, cfg);
    if (BlockMenuPreset.isInventory(cfg.getString("id"))) {
      if (BlockMenuPreset.isUniversalInventory(cfg.getString("id"))) {
        if (!Slimefun.getUniversalInventories().containsKey(cfg.getString("id"))) {
          storage.loadUniversalInventory(BlockMenuPreset.getPreset(cfg.getString("id")));
        }
      } else if (!storage.hasInventory(l)) {
        File file = new File("plugins/SlimefunReloaded/data-storage/stored-inventories/" + serializeLocation(l) + "/sfi");

        if (file.exists()) {
          storage.inventories.put(l, new BlockMenu(BlockMenuPreset.getPreset(cfg.getString("id")), l, new Config(file)));
        } else {
          storage.loadInventory(l, BlockMenuPreset.getPreset(cfg.getString("id")));
        }
      }
    }
    refreshCache(getStorage(l.getWorld()), l, cfg.getString("id"), serializeBlockInfo(cfg), updateTicker);
  }

  public static void setBlockInfo(Block b, String json, boolean updateTicker) {
    setBlockInfo(b.getLocation(), json, updateTicker);
  }

  public static void setBlockInfo(Location l, String json, boolean updateTicker) {
    Config blockInfo = json == null ? new BlockInfoConfig() : parseBlockInfo(l, json);
    if (blockInfo == null) {
      return;
    }
    setBlockInfo(l, blockInfo, updateTicker);
  }

  public static void clearBlockInfo(Block block) {
    clearBlockInfo(block.getLocation());
  }

  public static void clearBlockInfo(Location l) {
    clearBlockInfo(l, true);
  }

  public static void clearBlockInfo(Block b, boolean destroy) {
    clearBlockInfo(b.getLocation(), destroy);
  }

  public static void clearBlockInfo(Location l, boolean destroy) {
    SlimefunPlugin.getTicker().delete.put(l, destroy);
  }

  public static void _integrated_removeBlockInfo(Location l, boolean destroy) {
    BlockStorage storage = getStorage(l.getWorld());
    if (hasBlockInfo(l)) {
      refreshCache(storage, l, getLocationInfo(l).getString("id"), null, destroy);
      storage.storage.remove(l);
    }

    if (destroy) {
      if (storage.hasInventory(l)) {
        storage.clearInventory(l);
      }
      if (storage.hasUniversalInventory(l)) {
        storage.getUniversalInventory(l).close();
        storage.getUniversalInventory(l).save();
      }
      String chunkString = locationToChunkString(l);
      if (Slimefun.getTickingChunks().containsKey(chunkString)) {
        Set<Location> locations = Slimefun.getTickingChunks().get(chunkString);
        locations.remove(l);
        if (locations.isEmpty()) {
          Slimefun.getTickingChunks().remove(chunkString);
          Slimefun.getLoadedTickers().remove(chunkString);
        } else {
          Slimefun.getTickingChunks().put(chunkString, locations);
        }
      }
    }
  }

  public static void moveBlockInfo(Location from, Location to) {
    SlimefunPlugin.getTicker().move.put(from, to);
  }

  public static void _integrated_moveLocationInfo(Location from, Location to) {
    if (!hasBlockInfo(from)) {
      return;
    }
    BlockStorage storage = getStorage(from.getWorld());

    setBlockInfo(to, getLocationInfo(from), true);
    if (storage.inventories.containsKey(from)) {
      BlockMenu menu = storage.inventories.get(from);
      storage.inventories.put(to, menu);
      storage.clearInventory(from);
      menu.move(to);
    }

    refreshCache(storage, from, getLocationInfo(from).getString("id"), null, true);
    storage.storage.remove(from);

    String chunkString = locationToChunkString(from);
    if (Slimefun.getTickingChunks().containsKey(chunkString)) {
      Set<Location> locations = Slimefun.getTickingChunks().get(chunkString);
      locations.remove(from);
      if (locations.isEmpty()) {
        Slimefun.getTickingChunks().remove(chunkString);
        Slimefun.getLoadedTickers().remove(chunkString);
      } else {
        Slimefun.getTickingChunks().put(chunkString, locations);
      }
    }
  }

  private static void refreshCache(BlockStorage storage, Location l, String key, String value, boolean updateTicker) {
    Config cfg = storage.blocksCache.computeIfAbsent(key, k -> new Config(path_blocks + l.getWorld().getName() + '/' + key + ".sfb"));
    cfg.setValue(serializeLocation(l), value);

    if (updateTicker) {
      SlimefunReloadedItem item = COMPONENT_MANAGER.getComponentByNamespace(key);
      if (item != null && item.isTicking()) {
        String chunkString = locationToChunkString(l);
        if (value != null) {
          Set<Location> locations = Slimefun.getTickingChunks().get(chunkString);
          if (locations == null) {
            locations = new HashSet<>();
          }

          locations.add(l);
          Slimefun.getTickingChunks().put(chunkString, locations);
          Slimefun.getLoadedTickers().add(chunkString);
        }
      }
    }
  }

  public static SlimefunReloadedItem check(Block block) {
    return check(block.getLocation());
  }

  public static SlimefunReloadedItem check(Location l) {
    if (!hasBlockInfo(l)) {
      return null;
    }
    return SlimefunReloadedItem.getByID(getLocationInfo(l, "id"));
  }

  public static String checkID(Block block) {
    return checkID(block.getLocation());
  }

  public static boolean check(Block block, String SlimefunReloadedItem) {
    return check(block.getLocation(), SlimefunReloadedItem);
  }

  public static String checkID(Location l) {
    if (!hasBlockInfo(l)) {
      return null;
    }
    return getLocationInfo(l, "id");
  }

  public static boolean check(Location l, String SlimefunReloadedItem) {
    if (!hasBlockInfo(l)) {
      return false;
    }
    try {
      String id = getLocationInfo(l, "id");
      return id != null && id.equalsIgnoreCase(SlimefunReloadedItem);
    } catch (NullPointerException x) {
      return false;
    }
  }

  public static boolean isWorldRegistered(String name) {
    return Slimefun.getWorlds().containsKey(name);
  }

  public static Set<String> getTickingChunks() {
    return new HashSet<>(Slimefun.getLoadedTickers());
  }

  public static Set<Location> getTickingLocations(Chunk chunk) {
    return getTickingLocations(chunk.toString());
  }

  public static Set<Location> getTickingLocations(String chunk) {
    return new HashSet<>(Slimefun.getTickingChunks().get(chunk));
  }

  public BlockMenu loadInventory(Location l, BlockMenuPreset preset) {
    BlockMenu menu = new BlockMenu(preset, l);
    inventories.put(l, menu);
    return menu;
  }

  public void loadUniversalInventory(BlockMenuPreset preset) {
    Slimefun.getUniversalInventories().put(preset.getID(), new UniversalBlockMenu(preset));
  }

  public void clearInventory(Location l) {
    BlockMenu menu = getInventory(l);

    if (menu != null) {
      for (HumanEntity human : new ArrayList<>(menu.toInventory().getViewers())) {
        // Prevents "java.lang.IllegalStateException: Asynchronous entity add!" when closing inventory while holding an item
        Bukkit.getScheduler().scheduleSyncDelayedTask(Slimefun.getSlimefunReloaded(), human::closeInventory);
      }

      inventories.get(l).delete(l);
      inventories.remove(l);
    }
  }

  public boolean hasInventory(Location l) {
    return inventories.containsKey(l);
  }

  public boolean hasUniversalInventory(String id) {
    return Slimefun.getUniversalInventories().containsKey(id);
  }

  public UniversalBlockMenu getUniversalInventory(Block block) {
    return getUniversalInventory(block.getLocation());
  }

  public UniversalBlockMenu getUniversalInventory(Location l) {
    String id = checkID(l);
    return id == null ? null : getUniversalInventory(id);
  }

  public UniversalBlockMenu getUniversalInventory(String id) {
    return Slimefun.getUniversalInventories().get(id);
  }

  public static BlockMenu getInventory(Block b) {
    return getInventory(b.getLocation());
  }

  public static BlockMenu getInventory(Location l) {
    BlockStorage storage = getStorage(l.getWorld());
    if (storage == null) {
      return null;
    }
    if (!storage.hasInventory(l)) {
      return storage.loadInventory(l, BlockMenuPreset.getPreset(checkID(l)));
    } else {
      return storage.inventories.get(l);
    }
  }

  public static Config getChunkInfo(Chunk chunk) {
    try {
      BlockInfoConfig cfg = Slimefun.getMapChunks().get(serializeChunk(chunk));
      return cfg == null ? new BlockInfoConfig() : cfg;
    } catch (Exception x) {
      Slimefun.getLogger().log(Level.SEVERE, "Failed to parse ChunkInfo for Chunk: " + (chunk == null ? "?" : chunk.getX()) + ", " + (chunk == null ? "?" : chunk.getZ()) + " (" + getJSONData(chunk) + ") for Slimefun " + Slimefun.getVersion(), x);
      return new BlockInfoConfig();
    }
  }

  public static boolean hasChunkInfo(Chunk chunk) {
    return Slimefun.getMapChunks().containsKey(serializeChunk(chunk));
  }

  public static void setChunkInfo(Chunk chunk, String key, String value) {
    BlockInfoConfig cfg = Slimefun.getMapChunks().get(serializeChunk(chunk));

    if (cfg == null) {
      cfg = new BlockInfoConfig();
      Slimefun.getMapChunks().put(serializeChunk(chunk), cfg);
    }

    cfg.setValue(key, value);

    chunkChanges++;
  }

  public static String getChunkInfo(Chunk chunk, String key) {
    return getChunkInfo(chunk).getString(key);
  }

  public static boolean hasChunkInfo(Chunk chunk, String key) {
    return getChunkInfo(chunk, key) != null;
  }

  public static void clearChunkInfo(Chunk chunk) {
    Slimefun.getMapChunks().remove(serializeChunk(chunk));
  }

  public static String getBlockInfoAsJson(Block block) {
    return getBlockInfoAsJson(block.getLocation());
  }

  public static String getBlockInfoAsJson(Location l) {
    return serializeBlockInfo(getLocationInfo(l));
  }

  public boolean hasUniversalInventory(Block block) {
    return hasUniversalInventory(block.getLocation());
  }

  public boolean hasUniversalInventory(Location l) {
    String id = checkID(l);
    return id != null && hasUniversalInventory(id);
  }
}
