package optic_fusion1.slimefunreloaded.gps;

import java.util.Set;
import java.util.UUID;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import optic_fusion1.slimefunreloaded.Slimefun;
import optic_fusion1.slimefunreloaded.inventory.ChestMenu;
import optic_fusion1.slimefunreloaded.util.BlockStorage;
import optic_fusion1.slimefunreloaded.util.CustomItem;
import optic_fusion1.slimefunreloaded.util.I18n;
import optic_fusion1.slimefunreloaded.util.chat.ChatInput;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public final class Elevator {

  private Elevator() {
  }

  public static void openEditor(Player p, final Block b) {
    ChestMenu menu = new ChestMenu("Elevator Settings");

    menu.addItem(4, new CustomItem(new ItemStack(Material.NAME_TAG), "&7Floor Name &e(Click to edit)", "", "&r" + ChatColor.translateAlternateColorCodes('&', BlockStorage.getLocationInfo(b.getLocation(), "floor"))));
    menu.addMenuClickHandler(4, (pl, slot, item, action) -> {
      pl.closeInventory();
      pl.sendMessage("");
      pl.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4&l>> &ePlease enter a Name for this Floor in your Chat!"));
      pl.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4&l>> &e(Chat Colors are supported!"));
      pl.sendMessage("");

      ChatInput.waitForPlayer(Slimefun.getSlimefunReloaded(), pl, message -> {
        BlockStorage.addBlockInfo(b, "floor", message.replace(ChatColor.COLOR_CHAR, '&'));

        pl.sendMessage("");
        pl.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4&l>> &eSuccessfully named this Floor:"));
        pl.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4&l>> &r" + ChatColor.translateAlternateColorCodes('&', message)));
        pl.sendMessage("");

        openEditor(pl, b);
      });

      return false;
    });

    menu.open(p);
  }

  public static void openDialogue(Player p, Block b) {
    Set<UUID> elevatorUsers = Slimefun.getElevatorUsers();

    if (elevatorUsers.contains(p.getUniqueId())) {
      elevatorUsers.remove(p.getUniqueId());
      return;
    }
    TextComponent message = new TextComponent("&3- Pick a Destination-\n\n");
    int index = 1;
    for (int y = b.getWorld().getMaxHeight(); y > 0; y--) {
      Block block = b.getWorld().getBlockAt(b.getX(), y, b.getZ());
      if (BlockStorage.check(block, "ELEVATOR_PLATE")) {
        String floor = ChatColor.translateAlternateColorCodes('&', BlockStorage.getLocationInfo(block.getLocation(), "floor"));
        if (block.getY() == b.getY()) {
          message.addExtra("&7> " + index + ". &r" + floor + "\n");
          message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, TextComponent.fromLegacyText("\n&eThis is the Floor you are currently on:\n&r" + floor + "\n")));
        } else {
          message.addExtra("&7" + index + ". &r" + floor + "\n");
          message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, TextComponent.fromLegacyText("\n&eClick to teleport to this Floor\n&r" + floor + "\n")));
          message.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/sf elevator " + block.getX() + ' ' + block.getY() + ' ' + block.getZ() + " "));
        }

        index++;
      }
    }
    if (index > 2) {
      new CustomBookOverlay("Elevator", "Slimefun", tellraw).open(p);
    } else {
      I18n.tl(p, "machines.ELEVATOR.no-destinations");
    }
  }

}
