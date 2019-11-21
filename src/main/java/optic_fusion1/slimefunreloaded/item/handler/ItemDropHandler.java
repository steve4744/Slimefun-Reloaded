package optic_fusion1.slimefunreloaded.item.handler;

import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerDropItemEvent;

public interface ItemDropHandler extends ItemHandler {

  boolean onItemDrop(PlayerDropItemEvent e, Player p, Item item);

  default String toCodename() {
    return "ItemDropHandler";
  }
}
