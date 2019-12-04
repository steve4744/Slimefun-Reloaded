package optic_fusion1.slimefunreloaded.inventory;

@Deprecated
public class ClickAction {

  private boolean right;
  private boolean shift;

  public ClickAction(boolean rightClicked, boolean shiftClicked) {
    this.right = rightClicked;
    this.shift = shiftClicked;
  }

  public boolean isRightClicked() {
    return right;
  }

  public boolean isShiftClicked() {
    return shift;
  }

}
