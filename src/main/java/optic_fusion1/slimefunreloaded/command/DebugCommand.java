package optic_fusion1.slimefunreloaded.command;

import optic_fusion1.slimefunreloaded.Slimefun;
import optic_fusion1.slimefunreloaded.category.CategoryManager;
import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.component.ComponentManager;
import optic_fusion1.slimefunreloaded.component.SlimefunReloadedComponent;
import optic_fusion1.slimefunreloaded.research.Research;
import optic_fusion1.slimefunreloaded.research.ResearchManager;
import org.apache.commons.lang.StringUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class DebugCommand implements CommandExecutor {

  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if (!(sender instanceof Player)) {
      sender.sendMessage("You must be a player to run this command");
      return true;
    }
    Player player = (Player) sender;
    if (!player.hasPermission("sfr.debug")) {
      player.sendMessage("You do not have permission to run this command");
      return true;
    }
    switch (args[0]) {
      case "component":
        if (args.length == 1) {
          player.sendMessage("You did not enter enough arguments");
          return true;
        } ComponentManager componentManager = Slimefun.getComponentManager();
        if (args[1].equals("give")) {
          if (args.length == 2) {
            player.sendMessage("You did not enter enough arguments");
            return true;
          }
          String name = args[2];
          SlimefunReloadedComponent component = componentManager.getComponentByNamespace(name);
          if (component == null) {
            player.sendMessage("A component with the name " + name + " doesn't exist");
            return true;
          }
          ItemStack item = component.getItem();
          if (item == null) {
            player.sendMessage("The component " + name + " doesn't have an item");
            return true;
          }
          player.getInventory().addItem(item);
          player.sendMessage("You have been given 1 " + name);
          return true;
        } if (args[1].equals("list")) {
          player.sendMessage(StringUtils.join(componentManager.getComponentNames(), ", "));
          return true;
        } break;
      case "category":
        {
          if (args.length == 1) {
            player.sendMessage("You did not enter enough arguments");
            return true;
          }   CategoryManager categoryManager = Slimefun.getCategoryManager();
          if (args[1].equals("list")) {
            player.sendMessage(StringUtils.join(categoryManager.getCategoryNames(), ", "));
            return true;
          }   String name = args[1];
          Category category = categoryManager.getCategoryByName(name);
          if (category == null) {
            player.sendMessage("A category with the name " + name + " doesn't exist");
            return true;
          }   player.sendMessage("A category with the name " + name + " exists");
          break;
        }
      case "research":
      {
        if (args.length == 1) {
          player.sendMessage("You did not enter enough arguments");
          return true;
        }
        ResearchManager researchManager = Slimefun.getResearchManager();
        if (args[1].equals("list")) {
          player.sendMessage(StringUtils.join(researchManager.getResearchNames(), ", "));
          return true;
        }
        String name = args[1];
        Research research = researchManager.getResearchByNamespace(name);
        if (research == null) {
          player.sendMessage("A research with the name " + name + " doesn't exist");
          return true;
        }
        player.sendMessage("A research with the name " + name + " exists");
        return true;
      }
      default:
        break;
    }
    player.sendMessage("Usage: /debug <component <give <name>|list>|category <list|name>|research <list|name>>");
    player.sendMessage("Examples:");
    player.sendMessage("/debug component give grandmas_walking_stick");
    player.sendMessage("/debug component list");
    player.sendMessage("/debug category Weapons");
    player.sendMessage("/debug category list");
    player.sendMessage("/debug research Walking_Sticks");
    player.sendMessage("/debug research list");
    return true;
  }

}
