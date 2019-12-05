package optic_fusion1.slimefunreloaded.util;

import java.util.Iterator;
import java.util.Map;
import optic_fusion1.slimefunreloaded.Slimefun;
import optic_fusion1.slimefunreloaded.component.SlimefunReloadedComponent;
import org.bukkit.inventory.ItemStack;

public final class SlimefunReloadedRecipes {

  private SlimefunReloadedRecipes() {
  }

  public static void registerMachineRecipe(String machine, int seconds, ItemStack[] input, ItemStack[] output) {
    for (Map.Entry<String, SlimefunReloadedComponent> entry : Slimefun.getComponentManager().getComponents().entrySet()) {
      SlimefunReloadedComponent component = entry.getValue();
      if (component instanceof AContainer && ((AContainer) item).getMachineIdentifier().equals(machine)) {
        ((AContainer) item).registerRecipe(seconds, input, output);      
      }
    }
  }

}
