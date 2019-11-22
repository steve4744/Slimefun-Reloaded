package optic_fusion1.slimefunreloaded.research;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import optic_fusion1.slimefunreloaded.item.SlimefunReloadedItem;
import org.bukkit.NamespacedKey;

public class ResearchManager {

  private List<Research> researches = new ArrayList<>();
  private List<UUID> researching = new ArrayList<>();

  public boolean researchWithKeyExists(String key) {
    return researches.stream().anyMatch((research) -> (research.getNamespacedKey().getKey().equals(key)));
  }

  public boolean researchWithNamespaceExists(String key) {
    return researches.stream().anyMatch((research) -> (research.getNamespacedKey().getNamespace().equals(key)));
  }

  public List<Research> getResearches() {
    return Collections.unmodifiableList(researches);
  }

  public void addResearch(Research research, SlimefunReloadedItem... items) {
    NamespacedKey key = research.getNamespacedKey();
    if (!researchWithKeyExists(key.getKey()) && !researchWithNamespaceExists(key.getNamespace())) {
      for (SlimefunReloadedItem item : items) {
        research.addItems(item);
      }
      researches.add(research);
    }
  }

  public Research getResearchByKey(String key) {
    for (Research research : researches) {
      if (research.getNamespacedKey().getKey().equals(key)) {
        return research;
      }
    }
    return null;
  }

  public Research getResearchByNamespace(String namespace) {
    for (Research research : researches) {
      if (research.getNamespacedKey().getNamespace().equals(namespace)) {
        return research;
      }
    }
    return null;
  }

  public List<Research> getAllResearchesWithNamespace(String namespace) {
    List<Research> list = new ArrayList<>();
    researches.stream().filter((research) -> (research.getNamespacedKey().getNamespace().equals(namespace))).forEachOrdered((research) -> {
      list.add(research);
    });
    return list;
  }

  public boolean isPlayerResearching(UUID playerUniqueId) {
    return researching.stream().anyMatch((uuid) -> (uuid == playerUniqueId));
  }

  public void addResearchingPlayer(UUID playerUniqueId) {
    if (isPlayerResearching(playerUniqueId)) {
      return;
    }
    researching.add(playerUniqueId);
  }

  public void removeResearchingPlayer(UUID playerUniqueId) {
    if (!isPlayerResearching(playerUniqueId)) {
      return;
    }
    researching.remove(playerUniqueId);
  }

}
