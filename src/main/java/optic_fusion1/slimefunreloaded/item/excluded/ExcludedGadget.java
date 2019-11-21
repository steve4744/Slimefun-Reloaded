package optic_fusion1.slimefunreloaded.item.excluded;

import java.util.List;
import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.item.NotPlaceable;
import optic_fusion1.slimefunreloaded.item.gadget.SlimefunReloadedGadget;
import optic_fusion1.slimefunreloaded.util.NotImplementedException;
import org.bukkit.inventory.ItemStack;

public class ExcludedGadget extends SlimefunReloadedGadget implements NotPlaceable {

  public ExcludedGadget(Category category, ItemStack item, String id) {
    super(category, item, id);
  }

  @Override
  public List<ItemStack> getDisplayRecipes() {
    throw new NotImplementedException();
  }

  @Override
  public String getRecipeSectionLabel() {
    throw new NotImplementedException();
  }

}
