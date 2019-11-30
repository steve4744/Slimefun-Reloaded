package optic_fusion1.slimefunreloaded.util;

@FunctionalInterface
public interface ItemHandler {

  String toCodename();

  default boolean isPrivate() {
    return false;
  }
}
