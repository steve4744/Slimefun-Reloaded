package optic_fusion1.slimefunreloaded.item;

/**
 * Defines whether a SlimefunReloadedItem is enabled, disabled or fall-back to its vanilla behavior.
 *
 * @since 4.1.10
 */
public enum ItemState {
  /**
   * This SlimefunReloadedItem is enabled.
   */
  ENABLED,
  /**
   * This SlimefunReloadedItem is disabled and is not a {@link VanillaItem}.
   */
  DISABLED,
  /**
   * This SlimefunReloadedItem is fall-back to its vanilla behavior, because it is disabled and is a {@link VanillaItem}.
   */
  VANILLA
}
