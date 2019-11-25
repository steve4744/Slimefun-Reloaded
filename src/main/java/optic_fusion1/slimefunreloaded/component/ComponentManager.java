package optic_fusion1.slimefunreloaded.component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.Preconditions;

import org.bukkit.NamespacedKey;

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

  public void unregisterAllComponents() {
    this.components.clear();
    this.tickables.clear();
  }

}
