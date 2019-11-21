package optic_fusion1.slimefunreloaded.util.player;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public final class PlayerList {

  private PlayerList() {
  }

  /**
   * This method returns a Stream containing all online Players
   *
   * @return	A Stream of online Players
   */
  public static Stream<Player> stream() {
    return Bukkit.getOnlinePlayers().stream().map(p -> (Player) p);
  }

  /**
   * This method returns an Optional that describes whether a Player with the given Name is currently online or not.
   *
   * @param name	The name of the Player
   * @return	An Optional describing the player (or an empty Optional)
   */
  public static Optional<Player> findByName(String name) {
    Objects.requireNonNull(name);
    return stream()
     .filter(p -> p.getName().equalsIgnoreCase(name))
     .findAny();
  }

  /**
   * This method returns a Set of online Players that have the specified Permission.
   *
   * @param permission	The permission the Players should have
   * @return	A Set of Players
   */
  public static Set<Player> findPermitted(String permission) {
    Objects.requireNonNull(permission);
    return stream()
     .filter(p -> p.hasPermission(permission))
     .collect(Collectors.toSet());
  }

  /**
   * This method checks if a Player with the given name is currently online on the server.
   *
   * @param name	The Name of the Player
   * @return	Whether the Player is online
   */
  public static boolean isOnline(String name) {
    Objects.requireNonNull(name);
    return findByName(name).isPresent();
  }

}
