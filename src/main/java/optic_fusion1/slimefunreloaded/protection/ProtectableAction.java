package optic_fusion1.slimefunreloaded.protection;

public enum ProtectableAction {

  BREAK_BLOCK(true),
  PLACE_BLOCK(true),
  ACCESS_INVENTORIES(true),
  PVP(false);

  private boolean block;

  private ProtectableAction(boolean block) {
    this.block = block;
  }

  public boolean isBlockAction() {
    return block;
  }

}
