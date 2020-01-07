package optic_fusion1.slimefunreloaded.command;

import optic_fusion1.slimefunreloaded.Slimefun;
import optic_fusion1.slimefunreloaded.component.ComponentManager;
import optic_fusion1.slimefunreloaded.component.SlimefunReloadedComponent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ComponentCommand implements CommandExecutor {
  
//  private Paginator paginator = Slimefun.getComponentManager().getPaginator();
//  
  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if (!(sender instanceof Player)) {
      sender.sendMessage("You must be a player to run this command");
      return true;
    }
    Player player = (Player) sender;
    if (!player.hasPermission("sfr.command.component")) {
      player.sendMessage("You do not have permission to run this command");
      return true;
    }
    if(args.length == 0){
      player.sendMessage("You did not enter enough arguments");
      player.sendMessage("Usage: /component <list [number]|give <component name>>");
      player.sendMessage("Examples:");
      player.sendMessage("/component list 1");
      player.sendMessage("/component give grandmas_walking_stick");
      return true;
    }
//    if (args[0].equalsIgnoreCase("list")) {
//      if (args.length == 1) {
//        player.sendMessage("Page 0");
//        paginator.paginate(player, 0);
//        player.sendMessage("Page 1");
//        paginator.paginate(player, 1);
//        return true;
//      }
//      if (!Utils.isInteger(args[1])) {
//        player.sendMessage(args[1] + " is not an int");
//        return true;
//      }
//      int page = Integer.valueOf(args[1]);
//      paginator.paginate(player, page);
//    }
    if(args[0].equalsIgnoreCase("give")){
      if(args.length == 1){
        player.sendMessage("You did not enter enough arguments");
        player.sendMessage("Usage: /component give <component>");
        player.sendMessage("Example: /component give grandmas_walking_stick");
        return true;
      }
      SlimefunReloadedComponent component = Slimefun.getComponentManager().getComponentByKey(args[1]);
      if(component == null){
        player.sendMessage("The component " + args[1] + " doesn't exist");
        return true;
      }
      ItemStack item = component.getItem();
      if(item == null){
        player.sendMessage("The component " + args[1] + " exists but doesn't have an item");
        return true;
      }
      player.getInventory().addItem(item);
      player.sendMessage("You have been given 1 " + component.getID());
      return true;
    }
    if(args[0].equalsIgnoreCase("amount")){
      ComponentManager componentManager = Slimefun.getComponentManager();
      player.sendMessage("Components: " + componentManager.getComponents().size() + "(" + componentManager.getEnabledComponents().size() + ")");
    }
    return true;
  }
  
}
