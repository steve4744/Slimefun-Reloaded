package optic_fusion1.slimefunreloaded.listener;

import java.util.Optional;
import optic_fusion1.slimefunreloaded.Slimefun;
import optic_fusion1.slimefunreloaded.component.SlimefunReloadedComponent;
import optic_fusion1.slimefunreloaded.component.machine.impl.EnhancedFurnace;
import optic_fusion1.slimefunreloaded.recipe.MinecraftRecipe;
import optic_fusion1.slimefunreloaded.util.BlockStorage;
import optic_fusion1.slimefunreloaded.util.CustomItem;
import org.bukkit.block.Furnace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.FurnaceBurnEvent;
import org.bukkit.event.inventory.FurnaceSmeltEvent;
import org.bukkit.inventory.ItemStack;

public class FurnaceListener implements Listener {

  @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
  public void onBurn(FurnaceBurnEvent event) {
    SlimefunReloadedComponent component = BlockStorage.check(event.getBlock());
    if (component != null && component instanceof EnhancedFurnace && ((EnhancedFurnace) component).getFuelEfficiency() > 0) {
      event.setBurnTime(((EnhancedFurnace) component).getFuelEfficiency() * event.getBurnTime());
    }
  }

  @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
  public void onSmelt(FurnaceSmeltEvent event) {
    SlimefunReloadedComponent component = BlockStorage.check(event.getBlock());
    if (component != null && component instanceof EnhancedFurnace) {
      Furnace furnace = (Furnace) event.getBlock().getState();
      int amount = furnace.getInventory().getSmelting().getType().toString().endsWith("_ORE") ? ((EnhancedFurnace) furnace).getOutput() : 1;
      Optional<ItemStack> result = Optional.ofNullable(furnace.getInventory().getResult());
      if (!result.isPresent()) {
        result = Slimefun.getMinecraftRecipes().getRecipeOutput(MinecraftRecipe.FURNACE, furnace.getInventory().getSmelting());
      }
      if (result.isPresent()) {
        ItemStack itemStack = result.get();
        furnace.getInventory().setResult(new CustomItem(itemStack, Math.min(itemStack.getAmount() + amount, itemStack.getMaxStackSize())));
      }
    }
  }
}
