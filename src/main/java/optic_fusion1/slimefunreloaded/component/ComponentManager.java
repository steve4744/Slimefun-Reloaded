package optic_fusion1.slimefunreloaded.component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.Iterator;
import java.util.logging.Level;
import optic_fusion1.slimefunreloaded.Slimefun;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

public class ComponentManager {

  private Map<String, SlimefunReloadedComponent> components = new HashMap<>();
  private Map<String, SlimefunReloadedComponent> enabledComponents = new HashMap<>();
  private List<TickableComponent<? extends SlimefunReloadedComponent>> tickables = new ArrayList<>(32);

  public void registerComponent(SlimefunReloadedComponent component) {
    Preconditions.checkArgument(component != null, "Cannot register null component");
    Preconditions.checkArgument(component.getKey() != null, "Component must not have a null key");
    if (components.containsKey(component.getKey().toString())) {
      Slimefun.getLogger().log(Level.WARNING, "Component with key {0} already exists", component.getKey());
      return;
    }
    this.components.put(component.getKey().toString(), component);

    if (component instanceof TickableComponent) {
      this.tickables.add((TickableComponent<? extends SlimefunReloadedComponent>) component);
    }
  }

  public SlimefunReloadedComponent getComponent(NamespacedKey key) {
    Preconditions.checkArgument(key != null, "Expected namespaced key, received null");
    return getComponent(key.toString());
  }

  public SlimefunReloadedComponent getComponent(String key) {
    Preconditions.checkArgument(key != null, "Expected namespaced key, received null");
    return components.get(key);
  }

  public SlimefunReloadedComponent getComponentByItem(ItemStack item) {
    Preconditions.checkArgument(item != null, "Expected ItemStack, received null");
    Iterator it = components.entrySet().iterator();
    while (it.hasNext()) {
      Map.Entry pair = (Map.Entry) it.next();
      SlimefunReloadedComponent component = (SlimefunReloadedComponent) pair.getValue();
      if (item.isSimilar(component.getItem())) {
        return component;
      }
      it.remove();
    }
    return null;
  }

  public SlimefunReloadedComponent getComponentByKey(String key) {
    Preconditions.checkArgument(key != null, "Expected String, received null");
    Iterator it = components.entrySet().iterator();
    while (it.hasNext()) {
      Map.Entry pair = (Map.Entry) it.next();
      SlimefunReloadedComponent component = (SlimefunReloadedComponent) pair.getValue();
      if (component.getKey().getKey().toLowerCase().equals(key.toLowerCase())) {
        return component;
      }
      it.remove();
    }
    return null;
  }

  public void unregisterAllComponents() {
    this.components.clear();
    this.tickables.clear();
  }

  public Map<String, SlimefunReloadedComponent> getComponents() {
    return components;
  }

  public Map<String, SlimefunReloadedComponent> getEnabledComponents() {
    return enabledComponents;
  }

  public void addEnabledComponent(SlimefunReloadedComponent component) {
    enabledComponents.put(component.getID(), component);
  }

}
