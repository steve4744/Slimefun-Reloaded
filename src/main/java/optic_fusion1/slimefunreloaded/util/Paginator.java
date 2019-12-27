package optic_fusion1.slimefunreloaded.util;

import java.util.Collections;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class Paginator {

  private SortedMap<Integer, String> map = new TreeMap<>(Collections.reverseOrder());
  private String title;

  public void setTitle(String string) {
    this.title = string;
  }

  public void add(String text) {
    map.put(map.size() + 1, text);
  }

  public void paginate(CommandSender sender, int pageNumber) {
    int pageLength = 10;
    sender.sendMessage(title);
    pageNumber--;
    int i = 0, k = 0;
    for (final Entry<Integer, String> e : map.entrySet()) {
      k++;
      if ((((pageNumber * pageLength) + i + 1) == k) && (k != ((pageNumber * pageLength) + pageLength + 1))) {
        i++;
        sender.sendMessage(ChatColor.YELLOW + " - " + e.getValue());
      }
    }
  }

  public int getMaxPages(int pageLength) {
    return (((map.size() % pageLength) == 0) ? map.size() / pageLength : (map.size() / pageLength) + 1);
  }

}
