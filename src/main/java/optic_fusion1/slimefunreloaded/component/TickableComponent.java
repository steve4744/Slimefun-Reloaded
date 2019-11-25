package optic_fusion1.slimefunreloaded.component;

/**
 * A component definition to declare a {@link SlimefunReloadedComponent} as one to be ticked
 * every server update (20 times per second).
 *
 * @param <T> the type of component to tick
 *
 * @author Parker "Choco" Hawke
 */
public interface TickableComponent<T extends SlimefunReloadedComponent> {

  /**
   * Tick the component.
   *
   * @param object the object being ticked
   */
  public void tick(T object);

}
