package optic_fusion1.slimefunreloaded.menu.button.impl;

import optic_fusion1.slimefunreloaded.menu.button.BaseButton;

public class ClickableButton extends BaseButton {

  private Runnable runnable;
  
  public ClickableButton(int slot, Runnable runnable) {
    super(slot);
    this.runnable = runnable;
  }

  @Override
  public void click() {
    runnable.run();
  }

}
