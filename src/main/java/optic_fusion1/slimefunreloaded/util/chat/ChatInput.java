package optic_fusion1.slimefunreloaded.util.chat;

import com.google.common.base.Preconditions;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import optic_fusion1.slimefunreloaded.util.Utils;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public final class ChatInput {

  protected static ChatInputListener listener;

  private ChatInput() {
  }

  /**
   * This method waits for the Player to write something in chat. Afterwards the given callback will be invoked.
   *
   * @param plugin	The Plugin performing this action
   * @param p	The Player that we are waiting for
   * @param handler	A callback to invoke when the Player has entered some text
   */
  public static void waitForPlayer(Plugin plugin, Player p, Consumer<String> handler) {
    Preconditions.checkArgument(plugin != null, "Expected Plugin, received null");
    Preconditions.checkArgument(p != null, "Expected Player, received null");
    Preconditions.checkArgument(handler != null, "Expected Consumer<String>, received null");
    waitForPlayer(plugin, p, s -> true, handler);
  }

  /**
   * This method waits for the Player to write something in chat. Afterwards the given callback will be invoked. With the predicate you can filter out unwanted inputs. Like commands for example.
   *
   * @param plugin	The Plugin performing this action
   * @param p	The Player that we are waiting for
   * @param predicate	A Filter for the messages the Player types in
   * @param handler	A callback to invoke when the Player has entered some text
   */
  public static void waitForPlayer(Plugin plugin, Player p, Predicate<String> predicate, Consumer<String> handler) {
    Preconditions.checkArgument(plugin != null, "Expected Plugin, received null");
    Preconditions.checkArgument(p != null, "Expected Player, received null");
    Preconditions.checkArgument(predicate != null, "Expected Predicate<String>, receieve null");
    Preconditions.checkArgument(handler != null, "Expected Consumer<String>, received null");
    if (listener == null) {
      listener = new ChatInputListener(plugin);
    }
    listener.handlers.put(p.getUniqueId(), new IChatInput() {

      @Override
      public boolean test(String msg) {
        return predicate.test(msg);
      }

      @Override
      public void onChat(Player p, String msg) {
        handler.accept(msg);
      }

    });
  }

  /**
   * This method waits for the Player to write something in chat. Afterwards the given callback will be invoked.
   *
   * @param plugin	The Plugin performing this action
   * @param p	The Player that we are waiting for
   * @param handler	A callback to invoke when the Player has entered some text
   */
  public static void waitForPlayer(Plugin plugin, Player p, BiConsumer<Player, String> handler) {
    Preconditions.checkArgument(plugin != null, "Expected Plugin, received null");
    Preconditions.checkArgument(p != null, "Expected Player, received null");
    Preconditions.checkArgument(handler != null, "Expected Consumer<String>, received null");
    waitForPlayer(plugin, p, s -> true, handler);
  }

  /**
   * This method waits for the Player to write something in chat. Afterwards the given callback will be invoked. With the predicate you can filter out unwanted inputs. Like commands for example.
   *
   * @param plugin	The Plugin performing this action
   * @param p	The Player that we are waiting for
   * @param predicate	A Filter for the messages the Player types in
   * @param handler	A callback to invoke when the Player has entered some text
   */
  public static void waitForPlayer(Plugin plugin, Player p, Predicate<String> predicate, BiConsumer<Player, String> handler) {
    Preconditions.checkArgument(plugin != null, "Expected Plugin, received null");
    Preconditions.checkArgument(p != null, "Expected Player, received null");
    Preconditions.checkArgument(predicate != null, "Expected Predicate<String>, received null");
    Preconditions.checkArgument(handler != null, "Expected BiConsumer<Player, String>, received null");
    if (listener == null) {
      listener = new ChatInputListener(plugin);
    }
    listener.handlers.put(p.getUniqueId(), new IChatInput() {

      @Override
      public boolean test(String msg) {
        return predicate.test(msg);
      }

      @Override
      public void onChat(Player p, String msg) {
        handler.accept(p, msg);
      }

    });
  }

}
