package optic_fusion1.slimefunreloaded.component;

import optic_fusion1.slimefunreloaded.Slimefun;
import optic_fusion1.slimefunreloaded.category.CategoryManager;

public final class ComponentRegistry {

  private static final ComponentManager COMPONENT_MANAGER = Slimefun.getComponentManager();
  private static final CategoryManager CATEGORY_MANAGER = Slimefun.getCategoryManager();

  private ComponentRegistry() {
  }

  public static void registerComponents() {
  }

  private void register(SlimefunReloadedComponent component) {
    COMPONENT_MANAGER.registerComponent(component);
  }

}
