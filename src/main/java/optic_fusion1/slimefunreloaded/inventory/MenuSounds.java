package optic_fusion1.slimefunreloaded.inventory;

import org.bukkit.Sound;

@Deprecated
public class MenuSounds {

  Sound open, close;

  public MenuSounds(Sound open, Sound close) {
    this.open = open;
    this.close = close;
  }

  public Sound getOpeningSound() {
    return open;
  }

  public Sound getClosingSound() {
    return close;
  }

}
