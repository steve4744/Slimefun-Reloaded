package optic_fusion1.slimefunreloaded.protection;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import optic_fusion1.slimefunreloaded.protection.logger.CoreProtectLogger;
import optic_fusion1.slimefunreloaded.protection.logger.LogBlockLogger;
import optic_fusion1.slimefunreloaded.protection.modules.ASkyBlockProtectionModule;
import optic_fusion1.slimefunreloaded.protection.modules.BentoBoxProtectionModule;
import optic_fusion1.slimefunreloaded.protection.modules.BlockLockerProtectionModule;
import optic_fusion1.slimefunreloaded.protection.modules.FactionsProtectionModule;
import optic_fusion1.slimefunreloaded.protection.modules.FactionsUUIDProtectionModule;
import optic_fusion1.slimefunreloaded.protection.modules.GriefPreventionProtectionModule;
import optic_fusion1.slimefunreloaded.protection.modules.LWCProtectionModule;
import optic_fusion1.slimefunreloaded.protection.modules.LocketteProtectionModule;
import optic_fusion1.slimefunreloaded.protection.modules.PlotSquaredProtectionModule;
import optic_fusion1.slimefunreloaded.protection.modules.PreciousStonesProtectionModule;
import optic_fusion1.slimefunreloaded.protection.modules.RedProtectProtectionModule;
import optic_fusion1.slimefunreloaded.protection.modules.TownyProtectionModule;
import optic_fusion1.slimefunreloaded.protection.modules.WorldGuardProtectionModule;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.Server;
import org.bukkit.block.Block;
import org.checkerframework.checker.nullness.qual.NonNull;

public final class ProtectionManager {

  private final Set<ProtectionModule> protectionModules = new HashSet<>();
  private final Set<ProtectionLogger> protectionLoggers = new HashSet<>();
  private final Logger logger;

  public ProtectionManager(Server server) {
    logger = getLogger(server);

    logger.log(Level.INFO, "Loading Protection Modules...");
    logger.log(Level.INFO, "This may happen more than once.");

    if (server.getPluginManager().isPluginEnabled("WorldGuard") && server.getPluginManager().isPluginEnabled("WorldEdit")) {
      registerModule(new WorldGuardProtectionModule());
    }
    if (server.getPluginManager().isPluginEnabled("Factions")) {
      if (server.getPluginManager().getPlugin("Factions").getDescription().getDepend().contains("MassiveCore")) {
        registerModule(new FactionsProtectionModule());
      } else {
        registerModule(new FactionsUUIDProtectionModule());
      }
    }
    if (server.getPluginManager().isPluginEnabled("Towny")) {
      registerModule(new TownyProtectionModule());
    }
    if (server.getPluginManager().isPluginEnabled("GriefPrevention")) {
      registerModule(new GriefPreventionProtectionModule());
    }
    if (server.getPluginManager().isPluginEnabled("ASkyBlock")) {
      registerModule(new ASkyBlockProtectionModule());
    }
    if (server.getPluginManager().isPluginEnabled("LWC")) {
      registerModule(new LWCProtectionModule());
    }
    if (server.getPluginManager().isPluginEnabled("PreciousStones")) {
      registerModule(new PreciousStonesProtectionModule());
    }
    if (server.getPluginManager().isPluginEnabled("Lockette")) {
      registerModule(new LocketteProtectionModule());
    }
    if (server.getPluginManager().isPluginEnabled("PlotSquared")) {
      registerModule(new PlotSquaredProtectionModule());
    }
    if (server.getPluginManager().isPluginEnabled("RedProtect")) {
      registerModule(new RedProtectProtectionModule());
    }
    if (server.getPluginManager().isPluginEnabled("BentoBox")) {
      registerModule(new BentoBoxProtectionModule());
    }
    if (server.getPluginManager().isPluginEnabled("BlockLocker")) {
      registerModule(new BlockLockerProtectionModule());
    }

    /*
		 * The following Plugins are logging plugins, not protection plugins
     */
    if (server.getPluginManager().isPluginEnabled("CoreProtect")) {
      registerLogger(new CoreProtectLogger());
    }
    if (server.getPluginManager().isPluginEnabled("LogBlock")) {
      registerLogger(new LogBlockLogger());
    }

    /*
		 * The following Plugins work by utilising one of the above listed
		 * Plugins in the background.
		 * We do not need a module for them, but let us make the server owner
		 * aware that this compatibility exists.
     */
    if (server.getPluginManager().isPluginEnabled("ProtectionStones")) {
      loadModuleMSG("ProtectionStones");
    }
    if (server.getPluginManager().isPluginEnabled("uSkyblock")) {
      loadModuleMSG("uSkyblock");
    }
  }

  private Logger getLogger(Server server) {
    Logger customLogger = new Logger("CS-CoreLib2", null) {

      @Override
      public void log(@NonNull LogRecord logRecord) {
        logRecord.setMessage("[CS-CoreLib2 - Protection]" + logRecord.getMessage());
        super.log(logRecord);
      }

    };
    customLogger.setParent(server.getLogger());
    customLogger.setLevel(Level.ALL);

    return customLogger;
  }

  public void registerModule(String name, ProtectionModule module) {
    protectionModules.add(module);
    loadModuleMSG(name);
  }

  public void registerLogger(String name, ProtectionLogger module) {
    protectionLoggers.add(module);
    loadModuleMSG(name);
  }

  public void registerModule(ProtectionModule module) {
    try {
      module.load();
      registerModule(module.getName(), module);
    } catch (Exception x) {
      logger.log(Level.SEVERE, "An Error occured while registering the Protection Module: \"" + module.getName() + "\"", x);
    }
  }

  public void registerLogger(ProtectionLogger module) {
    try {
      module.load();
      registerLogger(module.getName(), module);
    } catch (Exception x) {
      logger.log(Level.SEVERE, "An Error occured while registering the Protection Module: \"" + module.getName() + "\"", x);
    }
  }

  private void loadModuleMSG(String module) {
    logger.log(Level.INFO, "Loaded Protection Module \"{0}\"", module);
  }

  public boolean hasPermission(@NonNull OfflinePlayer p, @NonNull Block b, @NonNull ProtectableAction action) {
    return hasPermission(p, b.getLocation(), action);
  }

  public boolean hasPermission(@NonNull OfflinePlayer p, @NonNull Location l, @NonNull ProtectableAction action) {
    for (ProtectionModule module : protectionModules) {
      try {
        if (!module.hasPermission(p, l, action)) {
          return false;
        }
      } catch (Exception x) {
        logger.log(Level.SEVERE, "An Error occured while querying the Protection Module: \"" + module.getName() + "\"", x);
        return false;
      }
    }

    return true;
  }

  public void logAction(@NonNull OfflinePlayer p, @NonNull Block b, @NonNull ProtectableAction action) {
    for (ProtectionLogger module : protectionLoggers) {
      try {
        module.logAction(p, b, action);
      } catch (Exception x) {
        logger.log(Level.SEVERE, "An Error occured while logging for the Protection Module: \"" + module.getName() + "\"", x);
      }
    }
  }

  public boolean canBuild(UUID uuid, Block b) {
    return this.canBuild(uuid, b, false);
  }

  public boolean canAccessChest(UUID uuid, Block b) {
    return this.canAccessChest(uuid, b, false);
  }

  public boolean canBuild(UUID uuid, Block b, boolean message) {
    return hasPermission(Bukkit.getOfflinePlayer(uuid), b.getLocation(), ProtectableAction.PLACE_BLOCK);
  }

  public boolean canAccessChest(UUID uuid, Block b, boolean message) {
    return hasPermission(Bukkit.getOfflinePlayer(uuid), b.getLocation(), ProtectableAction.ACCESS_INVENTORIES);
  }

}
