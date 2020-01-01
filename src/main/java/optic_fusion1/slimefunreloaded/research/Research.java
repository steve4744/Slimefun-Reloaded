package optic_fusion1.slimefunreloaded.research;

import java.util.Collection;
import java.util.Set;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;

import org.bukkit.Keyed;
import org.bukkit.NamespacedKey;

import optic_fusion1.slimefunreloaded.Slimefun;
import optic_fusion1.slimefunreloaded.component.SlimefunReloadedComponent;
import optic_fusion1.slimefunreloaded.component.item.SlimefunReloadedItem;
import optic_fusion1.slimefunreloaded.util.Config;

//TODO: Finish & clean this class up see me.mrCookieSlime.Slimefun.Objects.Research for the Slimefun equivalent of this class
public class Research implements Keyed {

  private int cost;
  private boolean enabled = true;
  private Set<SlimefunReloadedComponent> components = new HashSet<>();
  private List<SlimefunReloadedItem> items = new ArrayList<>();

  private NamespacedKey key;
  private final Config RESEARCH_CONFIG = Slimefun.getResearchesConfig();

  public Research(NamespacedKey key, int cost) {
    this.key = key;
    this.cost = cost;
    RESEARCH_CONFIG.setDefaultValue("enable-researching", true);
    if (RESEARCH_CONFIG.contains(key.getKey() + ".enabled") && !RESEARCH_CONFIG.getBoolean(key.getKey() + ".enabled")) {
      Iterator<SlimefunReloadedItem> itemIterator = items.iterator();
      while (itemIterator.hasNext()) {
        SlimefunReloadedItem item = itemIterator.next();
        if (item != null) {
          item.setResearch(null);
        }
        itemIterator.remove();
      }
      Iterator<SlimefunReloadedComponent> componentIterator = components.iterator();
      while (componentIterator.hasNext()) {
        SlimefunReloadedComponent component = componentIterator.next();
        if (component != null) {
          component.setResearch(null);
        }
        componentIterator.remove();
      }
    }
    RESEARCH_CONFIG.setDefaultValue(key.getKey() + ".name", key.getKey());
    RESEARCH_CONFIG.setDefaultValue(key.getKey() + ".cost", cost);
    RESEARCH_CONFIG.setDefaultValue(key.getKey() + ".enabled", true);
    RESEARCH_CONFIG.save();
    this.key = new NamespacedKey(Slimefun.getSlimefunReloaded(), RESEARCH_CONFIG.getString(key.getKey() + ".name"));
    this.cost = RESEARCH_CONFIG.getInt(key.getKey() + ".cost");
    this.enabled = RESEARCH_CONFIG.getBoolean(key.getKey() + ".enabled");
    if (Slimefun.isPrintOutLoading()) {
      Slimefun.getLogger().log(Level.INFO, "Loaded Research \"{0}\"", key.getKey());
    }
  }

  public void setCost(int cost) {
    this.cost = cost;
  }

  public int getCost() {
    return cost;
  }

  public boolean isEnabled() {
    return Slimefun.isResearchesEnabled() && enabled;
  }

  public void addItems(SlimefunReloadedItem... items) {
    for (SlimefunReloadedItem item : items) {
      if (item != null) {
        item.setResearch(this);
      }
    }
  }

  public List<SlimefunReloadedItem> getAffectedItems() {
    return items;
  }

  public void addComponent(SlimefunReloadedComponent component) {
    Preconditions.checkArgument(component != null, "Cannot add null component to research");

    if (components.add(component)) {
      component.setResearch(this);
    }
  }

  public void addComponents(SlimefunReloadedComponent... components) {
    for (SlimefunReloadedComponent component : components) {
      this.addComponent(component);
    }
  }

  public void addComponents(Collection<SlimefunReloadedComponent> components) {
    components.forEach(this::addComponent);
  }

  public boolean removeComponent(SlimefunReloadedComponent component) {
    boolean removed = components.remove(component);

    if (removed) {
      component.setResearch(null);
    }

    return removed;
  }

  public Set<SlimefunReloadedComponent> getComponents() {
    return ImmutableSet.copyOf(components);
  }

  @Override
  public String toString() {
    return "Research {" + key + "}";
  }

  @Override
  public NamespacedKey getKey() {
    return key;
  }

}
