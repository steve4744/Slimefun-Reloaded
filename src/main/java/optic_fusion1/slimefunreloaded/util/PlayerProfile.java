package optic_fusion1.slimefunreloaded.util;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import optic_fusion1.slimefunreloaded.Slimefun;
import optic_fusion1.slimefunreloaded.research.Research;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public final class PlayerProfile {

  private String name;
  private UUID uuid;
  private Config cfg;
  private boolean dirty = false;
  private boolean markedForDeletion = false;

  private final Set<Research> researches = new HashSet<>();
  private final Map<Integer, BackpackInventory> backpacks = new HashMap<>();
  private final LinkedList<Object> guideHistory = new LinkedList<>();

  private final HashedArmorpiece[] armor = {
    new HashedArmorpiece(),
    new HashedArmorpiece(),
    new HashedArmorpiece(),
    new HashedArmorpiece()
  };

  private PlayerProfile(OfflinePlayer p) {
    this.uuid = p.getUniqueId();
    this.name = p.getName();

    cfg = new Config(new File("data-storage/Slimefun/Players/" + uuid.toString() + ".yml"));

    for (Research research : Slimefun.getResearchManager().getResearches()) {
      if (cfg.contains("researches." + research.getKey().getNamespace())) {
        researches.add(research);
      }
    }
  }

  private PlayerProfile(UUID uuid) {
    this(Bukkit.getOfflinePlayer(uuid));
  }

  public HashedArmorpiece[] getArmor() {
    return armor;
  }

  public Config getConfig() {
    return cfg;
  }

  public UUID getUUID() {
    return uuid;
  }

  public boolean isMarkedForDeletion() {
    return markedForDeletion;
  }

  public boolean isDirty() {
    return dirty;
  }

  public void save() {
    for (BackpackInventory backpack : backpacks.values()) {
      backpack.save();
    }

    cfg.save();
    dirty = false;
  }

  public void setResearched(Research research, boolean unlock) {
    dirty = true;

    if (unlock) {
      cfg.setValue("researches." + research.getKey().getNamespace(), true);
      researches.add(research);
    } else {
      cfg.setValue("researches." + research.getKey().getNamespace(), null);
      researches.remove(research);
    }
  }

  public boolean hasUnlocked(Research research) {
    return !research.isEnabled() || researches.contains(research);
  }

  public Set<Research> getResearches() {
    return researches;
  }

  public void markForDeletion() {
    this.markedForDeletion = true;
  }

  public void markDirty() {
    this.dirty = true;
  }

  public BackpackInventory createBackpack(int size) {
    IntStream stream = IntStream.iterate(0, i -> i + 1).filter(i -> !cfg.contains("backpacks." + i + ".size"));
    int id = stream.findFirst().getAsInt();

    BackpackInventory backpack = new BackpackInventory(this, id, size);
    backpacks.put(id, backpack);

    return backpack;
  }

  public BackpackInventory getBackpack(int id) {
    BackpackInventory backpack = backpacks.get(id);

    if (backpack != null) {
      return backpack;
    } else {
      backpack = new BackpackInventory(this, id);
      backpacks.put(id, backpack);
      return backpack;
    }
  }

  public String getTitle() {
    List<String> titles = Slimefun.getResearchesTitles();

    float fraction = (float) researches.size() / Slimefun.getResearchManager().getResearches().size();
    int index = (int) (fraction * (titles.size() - 1));

    return titles.get(index);
  }

  public void sendStats(CommandSender sender) {
    Set<Research> researched = getResearches();
    int levels = researched.stream().mapToInt(Research::getCost).sum();

    String progress = String.valueOf(Math.round(((researched.size() * 100.0F) / Slimefun.getResearchManager().getResearches().size()) * 100.0F) / 100.0F);
    if (Float.parseFloat(progress) < 16.0F) {
      progress = "&4" + progress + " &r% ";
    } else if (Float.parseFloat(progress) < 32.0F) {
      progress = "&c" + progress + " &r% ";
    } else if (Float.parseFloat(progress) < 48.0F) {
      progress = "&6" + progress + " &r% ";
    } else if (Float.parseFloat(progress) < 64.0F) {
      progress = "&e" + progress + " &r% ";
    } else if (Float.parseFloat(progress) < 80.0F) {
      progress = "&2" + progress + " &r% ";
    } else {
      progress = "&a" + progress + " &r% ";
    }

    sender.sendMessage("");
    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7Statistics for Player: &b" + name));
    sender.sendMessage("");
    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7Title: &b" + getTitle()));
    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7Research Progress: " + progress + "&e(" + researched.size() + " / " + Slimefun.getResearchManager().getResearches().size() + ")"));
    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7Total XP Levels spent: &b" + levels));
  }

  public Player getPlayer() {
    return Bukkit.getPlayer(getUUID());
  }

  public LinkedList<Object> getGuideHistory() {
    return guideHistory;
  }

  public static PlayerProfile fromUUID(UUID uuid) {
    PlayerProfile profile = Slimefun.getProfiles().get(uuid);

    if (profile == null) {
      profile = new PlayerProfile(uuid);
      Slimefun.getProfiles().put(uuid, profile);
    } else {
      profile.markedForDeletion = false;
    }

    return profile;
  }

  public static boolean fromUUID(UUID uuid, Consumer<PlayerProfile> callback) {
    PlayerProfile profile = Slimefun.getProfiles().get(uuid);

    if (profile != null) {
      callback.accept(profile);
      return true;
    }

    Bukkit.getScheduler().runTaskAsynchronously(Slimefun.getSlimefunReloaded(), () -> {
      PlayerProfile pp = new PlayerProfile(uuid);
      Slimefun.getProfiles().put(uuid, pp);
      callback.accept(pp);
    });
    return false;
  }

  public static PlayerProfile get(OfflinePlayer p) {
    PlayerProfile profile = Slimefun.getProfiles().get(p.getUniqueId());

    if (profile == null) {
      profile = new PlayerProfile(p);
      Slimefun.getProfiles().put(p.getUniqueId(), profile);
    } else {
      profile.markedForDeletion = false;
    }

    return profile;
  }

  public static boolean get(OfflinePlayer p, Consumer<PlayerProfile> callback) {
    PlayerProfile profile = Slimefun.getProfiles().get(p.getUniqueId());
    if (profile != null) {
      callback.accept(profile);
      return true;
    }

    Bukkit.getScheduler().runTaskAsynchronously(Slimefun.getSlimefunReloaded(), () -> {
      PlayerProfile pp = new PlayerProfile(p);
      Slimefun.getProfiles().put(p.getUniqueId(), pp);
      callback.accept(pp);
    });
    return false;
  }

  public static boolean isLoaded(UUID uuid) {
    return Slimefun.getProfiles().containsKey(uuid);
  }

  public static Optional<PlayerProfile> find(OfflinePlayer p) {
    return Optional.ofNullable(Slimefun.getProfiles().get(p.getUniqueId()));
  }

  public static Iterator<PlayerProfile> iterator() {
    return Slimefun.getProfiles().values().iterator();
  }

  public static BackpackInventory getBackpack(ItemStack item) {
    if (item == null || !item.hasItemMeta() || !item.getItemMeta().hasLore()) {
      return null;
    }

    Optional<Integer> id = Optional.empty();
    String uuid = "";

    for (String line : item.getItemMeta().getLore()) {
      if (line.startsWith(ChatColor.translateAlternateColorCodes('&', "&7ID: ")) && line.contains("#")) {
        try {
          id = Optional.of(Integer.parseInt(line.split("#")[1]));
          uuid = line.split("#")[0].replace(ChatColor.translateAlternateColorCodes('&', "&7ID: "), "");
        } catch (NumberFormatException x) {
          return null;
        }
      }
    }

    if (id.isPresent()) {
      return PlayerProfile.fromUUID(UUID.fromString(uuid)).getBackpack(id.get());
    } else {
      return null;
    }
  }

  @Override
  public String toString() {
    return "PlayerProfile {" + uuid + "}";
  }

}
