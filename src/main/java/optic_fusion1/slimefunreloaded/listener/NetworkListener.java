//package optic_fusion1.slimefunreloaded.listener;
//
//import com.google.common.graph.Network;
//import optic_fusion1.slimefunreloaded.SlimefunReloaded;
//import org.bukkit.event.EventHandler;
//import org.bukkit.event.EventPriority;
//import org.bukkit.event.Listener;
//import org.bukkit.event.block.BlockBreakEvent;
//import org.bukkit.event.block.BlockPlaceEvent;
//
//public class NetworkListener implements Listener {
//
//  public NetworkListener(SlimefunReloaded plugin) {
//    plugin.getServer().getPluginManager().registerEvents(this, plugin);
//  }
//
//  @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
//  public void onBlockBreak(BlockBreakEvent e) {
//    Network.handleAllNetworkLocationUpdate(e.getBlock().getLocation());
//  }
//
//  @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
//  public void onPlaceBreak(BlockPlaceEvent e) {
//    Network.handleAllNetworkLocationUpdate(e.getBlock().getLocation());
//  }
//}
