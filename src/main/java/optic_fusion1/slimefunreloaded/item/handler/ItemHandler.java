package optic_fusion1.slimefunreloaded.item.handler;

public interface ItemHandler {

  String toCodename();

  default boolean isPrivate() {
    return false;
  }
}
