package optic_fusion1.slimefunreloaded.ancient_altar;

import java.util.ArrayList;
import java.util.List;
import optic_fusion1.slimefunreloaded.Slimefun;
import org.bukkit.inventory.ItemStack;

public class AltarRecipe {

  private ItemStack catalyst;
  private List<ItemStack> input;
  private ItemStack output;

  public AltarRecipe(List<ItemStack> input, ItemStack output) {
    this.catalyst = input.get(4);
    this.input = new ArrayList<>();

    this.input.add(input.get(0));
    this.input.add(input.get(1));
    this.input.add(input.get(2));
    this.input.add(input.get(5));

    this.input.add(input.get(8));
    this.input.add(input.get(7));
    this.input.add(input.get(6));
    this.input.add(input.get(3));

    this.output = output;

    Slimefun.getAltarRecipes().add(this);
  }

  public ItemStack getCatalyst() {
    return this.catalyst;
  }

  public ItemStack getOutput() {
    return this.output;
  }

  public List<ItemStack> getInput() {
    return this.input;
  }

}
