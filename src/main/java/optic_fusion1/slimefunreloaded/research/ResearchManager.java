package optic_fusion1.slimefunreloaded.research;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.bukkit.NamespacedKey;

public class ResearchManager {

  private List<Research> researches = new ArrayList<>();

  public boolean researchWithKeyExists(String key) {
    return researches.stream().anyMatch((research) -> (research.getNamespacedKey().getKey().equals(key)));
  }

  public boolean researchWithNamespaceExists(String key) {
    return researches.stream().anyMatch((research) -> (research.getNamespacedKey().getNamespace().equals(key)));
  }
  
  public List<Research> getResearches() {
    return Collections.unmodifiableList(researches);
  }

  public void addResearch(Research research) {
    NamespacedKey key = research.getNamespacedKey();
    if (!researchWithKeyExists(key.getKey()) && !researchWithNamespaceExists(key.getNamespace())) {
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

}
