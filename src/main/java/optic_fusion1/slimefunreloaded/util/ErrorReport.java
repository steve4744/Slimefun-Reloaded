package optic_fusion1.slimefunreloaded.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.stream.IntStream;
import optic_fusion1.slimefunreloaded.Slimefun;
import optic_fusion1.slimefunreloaded.component.ComponentManager;
import optic_fusion1.slimefunreloaded.component.SlimefunReloadedComponent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class ErrorReport {

  private File file;
  private static final ComponentManager COMPONENT_MANAGER = Slimefun.getComponentManager();
  
  public ErrorReport(Throwable throwable, Consumer<PrintStream> printer) {
    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Slimefun.getSlimefunReloaded(), () -> {
      String path = "plugins/SlimefunReloaded/error-reports/" + new SimpleDateFormat("yyyy-MM-dd-HH-mm").format(new Date());
      file = new File(path + ".err");

      if (file.exists()) {
        IntStream stream = IntStream.iterate(1, i -> i + 1).filter(i -> !new File(path + " (" + i + ").err").exists());
        int id = stream.findFirst().getAsInt();

        file = new File(path + " (" + id + ").err");
      }

      try (PrintStream stream = new PrintStream(file)) {
        stream.println();
        stream.println("Java Environment:");
        stream.println("  Operating System: " + System.getProperty("os.name"));
        stream.println("  Java Version: " + System.getProperty("java.version"));
        stream.println();
        stream.println("Server Software: " + Bukkit.getName());
        stream.println("  Build: " + Bukkit.getVersion());
        stream.println("  Minecraft: " + Bukkit.getBukkitVersion());
        stream.println();
        stream.println("Slimefun Environment:");
        stream.println("  Slimefun v" + Slimefun.getVersion());
        stream.println();

        List<String> plugins = new ArrayList<>();
        List<String> addons = new ArrayList<>();

        for (Plugin p : Bukkit.getPluginManager().getPlugins()) {
          if (Bukkit.getPluginManager().isPluginEnabled(p)) {
            plugins.add("  + " + p.getName() + ' ' + p.getDescription().getVersion());
            if (p.getDescription().getDepend().contains("Slimefun") || p.getDescription().getSoftDepend().contains("Slimefun")) {
              addons.add("  + " + p.getName() + ' ' + p.getDescription().getVersion());
            }
          } else {
            plugins.add("  - " + p.getName() + ' ' + p.getDescription().getVersion());
            if (p.getDescription().getDepend().contains("Slimefun") || p.getDescription().getSoftDepend().contains("Slimefun")) {
              addons.add("  - " + p.getName() + ' ' + p.getDescription().getVersion());
            }
          }
        }

        stream.println("Installed Addons (" + addons.size() + ")");
        addons.forEach(stream::println);

        stream.println();

        stream.println("Installed Plugins (" + plugins.size() + "):");
        plugins.forEach(stream::println);

        stream.println();

        printer.accept(stream);

        stream.println("Stacktrace:");
        stream.println();
        throwable.printStackTrace(stream);

        Slimefun.getLogger().log(Level.WARNING, "");
        Slimefun.getLogger().log(Level.WARNING, "An Error occured! It has been saved as: ");
        Slimefun.getLogger().log(Level.WARNING, "/plugins/SlimefunReloaded/error-reports/" + file.getName());
        Slimefun.getLogger().log(Level.WARNING, "Please consider sending this File to the developer(s) of Slimefun Reloaded, this message does not have to be included.");
        Slimefun.getLogger().log(Level.WARNING, "You can put the file on Pastebin and then post it here: https://github.com/OpticFusion1/Slimefun-Reloaded/issues");
        Slimefun.getLogger().log(Level.WARNING, "");
      } catch (FileNotFoundException x) {
        Slimefun.getLogger().log(Level.SEVERE, "An Error occured while saving an Error-Report for Slimefun Reloaded " + Slimefun.getVersion(), x);
      }
    });
  }

  public ErrorReport(Throwable throwable, TickerTask task, Location l, SlimefunReloadedComponent item) {
    this(throwable, stream -> {
      stream.println("Block Info:");
      stream.println("  World: " + l.getWorld().getName());
      stream.println("  X: " + l.getBlockX());
      stream.println("  Y: " + l.getBlockY());
      stream.println("  Z: " + l.getBlockZ());
      stream.println("  Material: " + l.getBlock().getType());
      stream.println("  State: " + l.getBlock().getState().getClass().getName());
      stream.println();
      stream.println("Ticker-Info:");
//      stream.println("  Type: " + (item.getBlockTicker().isSynchronized() ? "Synchronized" : "Asynchronous"));
      stream.println("  Object Dump: " + task.toString());
      stream.println();
      stream.println("Slimefun Data:");
      stream.println("  ID: " + item.getID());
      stream.println("  Inventory: " + BlockStorage.getStorage(l.getWorld()).hasInventory(l));
      stream.println("  Data: " + BlockStorage.getBlockInfoAsJson(l));
      stream.println();
    });
  }

  public ErrorReport(Throwable throwable, Player p) {
    this(throwable, stream -> {
      stream.println("Player Info:");
      stream.println("  ID: " + p.getUniqueId() + " (" + p.getName() + ")");
      stream.println("  World: " + p.getWorld().getName());
      stream.println("  X: " + p.getLocation().getX());
      stream.println("  Y: " + p.getLocation().getY());
      stream.println("  Z: " + p.getLocation().getZ());
      stream.println("  Profile in RAM? " + PlayerProfile.isLoaded(p.getUniqueId()));
      stream.println();
      stream.println("Item in Main Hand:");
      stream.println(p.getInventory().getItemInMainHand());
      stream.println(COMPONENT_MANAGER.getComponentByItem(p.getInventory().getItemInMainHand()));
      stream.println();
      stream.println("Item in Off Hand:");
      stream.println(p.getInventory().getItemInOffHand());
      stream.println(COMPONENT_MANAGER.getComponentByItem(p.getInventory().getItemInOffHand()));
      stream.println();
      stream.println("Helmet:");
      stream.println(p.getInventory().getHelmet());
      stream.println(COMPONENT_MANAGER.getComponentByItem(p.getInventory().getHelmet()));
      stream.println();
      stream.println("Chestplate:");
      stream.println(p.getInventory().getChestplate());
      stream.println(COMPONENT_MANAGER.getComponentByItem(p.getInventory().getChestplate()));
      stream.println();
      stream.println("Leggings:");
      stream.println(p.getInventory().getLeggings());
      stream.println(COMPONENT_MANAGER.getComponentByItem(p.getInventory().getLeggings()));
      stream.println();
      stream.println("Boots:");
      stream.println(p.getInventory().getBoots());
      stream.println(COMPONENT_MANAGER.getComponentByItem(p.getInventory().getBoots()));
      stream.println();
    });
  }

  public File getFile() {
    return file;
  }

  public static void tryCatch(Function<Exception, ErrorReport> function, Runnable runnable) {
    try {
      runnable.run();
    } catch (Exception x) {
      function.apply(x);
    }
  }

}
