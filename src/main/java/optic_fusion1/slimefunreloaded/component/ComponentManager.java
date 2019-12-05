package optic_fusion1.slimefunreloaded.component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.Preconditions;
import java.util.Iterator;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

public class ComponentManager {

  private final Map<String, SlimefunReloadedComponent> components = new HashMap<>();
  private final List<TickableComponent<? extends SlimefunReloadedComponent>> tickables = new ArrayList<>(32);

  @SuppressWarnings("unchecked")
  public void registerComponent(SlimefunReloadedComponent component) {
    Preconditions.checkArgument(component != null, "Cannot register null component");
    Preconditions.checkArgument(component.getKey() != null, "Component must not have a null key");
    Preconditions.checkArgument(components.containsKey(component.getKey().toString()), "Component with the key %s already exists", component.getKey());

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

  public SlimefunReloadedComponent getComponentByNamespace(String nameSpace) {
    Iterator it = components.entrySet().iterator();
    while (it.hasNext()) {
      Map.Entry pair = (Map.Entry) it.next();
      SlimefunReloadedComponent component = (SlimefunReloadedComponent) pair.getValue();
      if(component.getKey().getNamespace().equals(nameSpace)){
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

  public Map<String, SlimefunReloadedComponent> getComponents(){
    return components;
  }
  
}
