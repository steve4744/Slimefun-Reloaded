package optic_fusion1.slimefunreloaded.item.gadget.impl;

import java.util.ArrayList;
import java.util.List;
import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.item.gadget.SlimefunReloadedGadget;
import org.bukkit.inventory.ItemStack;

public class Crucible extends SlimefunReloadedGadget {

  public Crucible(Category category, ItemStack item, String id) {
    super(category, item, id);
  }

  @Override
  public List<ItemStack> getDisplayRecipes() {
    return new ArrayList<>();
  }

}
