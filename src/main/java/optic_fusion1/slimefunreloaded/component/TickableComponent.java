package optic_fusion1.slimefunreloaded.component;

import optic_fusion1.slimefunreloaded.util.Config;
import org.bukkit.block.Block;

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
   * @param block
   * @param component the component being ticked
   * @param data
   */
  public void tick(Block block, T component, Config data);

  public abstract boolean isSynchronized();
  
}
