package optic_fusion1.slimefunreloaded.item;

import java.util.ArrayList;
import java.util.List;

public class ItemManager {

  private List<SlimefunReloadedItem> items = new ArrayList<>();
  
  public void setupItemSettings(){
  
  }
  
  public void addItem(SlimefunReloadedItem item){
    items.add(item);
  }
  
  public List<SlimefunReloadedItem> getItems(){
    return items;
  }
  
}
