//package optic_fusion1.slimefunreloaded.listener;
//
//import nl.rutgerkok.blocklocker.profile.PlayerProfile;
//import optic_fusion1.slimefunreloaded.SlimefunReloaded;
//import org.bukkit.event.EventHandler;
//import org.bukkit.event.Listener;
//import org.bukkit.event.player.PlayerQuitEvent;
//
//public class PlayerQuitListener implements Listener {
//
//  public PlayerQuitListener(SlimefunReloaded plugin) {
//    plugin.getServer().getPluginManager().registerEvents(this, plugin);
//  }
//
//  @SuppressWarnings("deprecation")
//  @EventHandler
//  public void onDisconnect(PlayerQuitEvent e) {
//    if (PlayerProfile.isLoaded(e.getPlayer().getUniqueId())) {
//      PlayerProfile.get(e.getPlayer()).markForDeletion();
//    }
//  }
//
//}
