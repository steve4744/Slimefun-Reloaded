package optic_fusion1.slimefunreloaded.util.chat;

import java.util.function.Predicate;

import org.bukkit.entity.Player;

public interface IChatInput extends Predicate<String> {

  void onChat(Player p, String msg);

}
