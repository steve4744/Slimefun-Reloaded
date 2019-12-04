package optic_fusion1.slimefunreloaded.inventory;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Deprecated
public class Maps {

  public Map<UUID, String> inv;
  public Map<UUID, ChestMenu> menus;
  public Map<UUID, MenuSounds> sounds;

  public static Maps instance;

  public Maps() {
    inv = new HashMap<>();
    sounds = new HashMap<>();
    menus = new HashMap<>();
    instance = this;
  }

  public static Maps getInstance() {
    return instance;
  }

}
