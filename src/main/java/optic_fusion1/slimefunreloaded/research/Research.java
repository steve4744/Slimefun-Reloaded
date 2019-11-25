package optic_fusion1.slimefunreloaded.research;

import java.util.Collection;
import java.util.Set;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;

import org.bukkit.Keyed;
import org.bukkit.NamespacedKey;

import optic_fusion1.slimefunreloaded.Slimefun;
import optic_fusion1.slimefunreloaded.component.SlimefunReloadedComponent;

public class Research implements Keyed {

  private int cost;
  private boolean enabled = true;
  private Set<SlimefunReloadedComponent> components;

  private final NamespacedKey key;

  public Research(NamespacedKey key, int cost) {
    this.key = key;
    this.cost = cost;
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
