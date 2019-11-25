package optic_fusion1.slimefunreloaded.research;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import com.google.common.base.Preconditions;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;

import optic_fusion1.slimefunreloaded.component.SlimefunReloadedComponent;

public class ResearchManager {

  private List<Research> researches = new ArrayList<>();
  private Set<UUID> researching = new HashSet<>();

  public boolean researchWithKeyExists(String key) {
    return researches.stream().anyMatch((research) -> (research.getKey().getKey().equals(key)));
  }

  public boolean researchWithNamespaceExists(String key) {
    return researches.stream().anyMatch((research) -> (research.getKey().getNamespace().equals(key)));
  }

  public List<Research> getResearches() {
    return Collections.unmodifiableList(researches);
  }

  public void addResearch(Research research, SlimefunReloadedComponent... components) {
    NamespacedKey key = research.getKey();
    if (!researchWithKeyExists(key.getKey()) && !researchWithNamespaceExists(key.getNamespace())) {
      research.addComponents(components);
      this.researches.add(research);
    }
  }

  public Research getResearchByKey(String key) {
    for (Research research : researches) {
      if (research.getKey().getKey().equals(key)) {
        return research;
      }
    }

    return null;
  }

  public Research getResearchByNamespace(String namespace) {
    for (Research research : researches) {
      if (research.getKey().getNamespace().equals(namespace)) {
        return research;
      }
    }

    return null;
  }

  public List<Research> getAllResearchesWithNamespace(String namespace) {
    List<Research> list = new ArrayList<>();
    this.researches.stream().filter((research) -> (research.getKey().getNamespace().equals(namespace))).forEach(list::add);
    return list;
  }

  public boolean isPlayerResearching(Player player) {
    Preconditions.checkArgument(player != null, "Cannot check research status of null player");
    return isPlayerResearching(player.getUniqueId());
  }

  public boolean isPlayerResearching(UUID playerUniqueId) {
    Preconditions.checkArgument(playerUniqueId != null, "Cannot check research status of null player");
    return researching.contains(playerUniqueId);
  }

  public void addResearchingPlayer(Player player) {
    Preconditions.checkArgument(player != null, "Cannot add null player to research");
    this.addResearchingPlayer(player.getUniqueId());
  }

  public void addResearchingPlayer(UUID playerUniqueId) {
    Preconditions.checkArgument(playerUniqueId != null, "Cannot add null player to research");
    this.researching.add(playerUniqueId);
  }

  public void removeResearchingPlayer(Player player) {
    Preconditions.checkArgument(player != null, "Cannot remove null player from research");
    this.removeResearchingPlayer(player.getUniqueId());
  }

  public void removeResearchingPlayer(UUID playerUniqueId) {
    Preconditions.checkArgument(playerUniqueId != null, "Cannot remove null player from research");
    this.researching.remove(playerUniqueId);
  }

}
