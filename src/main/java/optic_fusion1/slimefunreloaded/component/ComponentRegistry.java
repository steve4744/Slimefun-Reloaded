package optic_fusion1.slimefunreloaded.component;

import optic_fusion1.slimefunreloaded.Slimefun;

public final class ComponentRegistry {

  private static final ComponentManager COMPONENT_MANAGER = Slimefun.getComponentManager();

  private ComponentRegistry() { }

  public static void registerComponents() {

  }

  private void register(SlimefunReloadedComponent component) {
    COMPONENT_MANAGER.registerComponent(component);
  }

}
