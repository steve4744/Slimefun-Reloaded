package optic_fusion1.slimefunreloaded.research;

import java.util.List;
import optic_fusion1.slimefunreloaded.item.SlimefunReloadedItem;
import org.bukkit.NamespacedKey;

public class Research {

  private static final int[] research_progress = {23, 44, 57, 92};
  private NamespacedKey key;
  private int cost;
  private List<SlimefunReloadedItem> items;
  private boolean enabled = true;

  public Research(NamespacedKey key, int cost) {
    this.key = key;
    this.cost = cost;
  }

  public NamespacedKey getNamespacedKey() {
    return key;
  }

  public int getCost() {
    return cost;
  }

  public void setCost(int cost) {
    this.cost = cost;
  }

  public boolean isEnabled() {
    return /*SlimefunPlugin.getSettings().researchesEnabled &&*/ enabled;
  }

  public void addItems(SlimefunReloadedItem... items) {
    for (SlimefunReloadedItem item : items) {
      if (item != null) {
//        item.bindToResearch(this);
      }
    }
  }

  public List<SlimefunReloadedItem> getAffectedItems() {
    return items;
  }

  @Override
  public String toString() {
    return "Research {" + key.getNamespace() + "," + key.getKey() + "}";
  }
}