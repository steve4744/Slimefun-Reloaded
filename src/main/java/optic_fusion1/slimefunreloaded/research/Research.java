package optic_fusion1.slimefunreloaded.research;

import java.util.List;
import org.bukkit.NamespacedKey;

public class Research {

  private NamespacedKey key;
  private int cost;
//  private List<SlimefunItem> items;
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
  
  public boolean isEnabled(){
    return enabled;
  }

}
