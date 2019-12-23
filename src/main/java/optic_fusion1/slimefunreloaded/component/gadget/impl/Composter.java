package optic_fusion1.slimefunreloaded.component.gadget.impl;

import java.util.LinkedList;
import java.util.List;
import optic_fusion1.slimefunreloaded.Slimefun;
import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.component.RecipeType;
import optic_fusion1.slimefunreloaded.component.SlimefunReloadedComponent;
import optic_fusion1.slimefunreloaded.component.item.SlimefunReloadedGadget;
import optic_fusion1.slimefunreloaded.protection.ProtectableAction;
import optic_fusion1.slimefunreloaded.util.BlockStorage;
import optic_fusion1.slimefunreloaded.util.I18n;
import optic_fusion1.slimefunreloaded.util.material.MaterialCollections;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemStack;

public class Composter extends SlimefunReloadedGadget {

  public Composter(NamespacedKey key, Category category, ItemStack item, RecipeType recipeType, ItemStack[] recipe) {
    super(key, category, item, recipeType, recipe, getGadgetRecipes());
  }

  private static ItemStack[] getGadgetRecipes() {
    List<ItemStack> items = new LinkedList<>();

    for (Material leave : MaterialCollections.getAllLeaves()) {
      items.add(new ItemStack(leave, 8));
      items.add(new ItemStack(Material.DIRT));
    }

    for (Material sapling : MaterialCollections.getAllSaplings()) {
      items.add(new ItemStack(sapling, 8));
      items.add(new ItemStack(Material.DIRT));
    }

    items.add(new ItemStack(Material.STONE, 4));
    items.add(new ItemStack(Material.NETHERRACK));

    items.add(new ItemStack(Material.SAND, 2));
    items.add(new ItemStack(Material.SOUL_SAND));

    items.add(new ItemStack(Material.WHEAT, 4));
    items.add(new ItemStack(Material.NETHER_WART));

    return items.toArray(new ItemStack[0]);
  }

  @Override
  public boolean onInteract(Player player, ItemStack item, Action action, Block clickedBlock) {
    if (clickedBlock != null) {
      String id = BlockStorage.checkID(clickedBlock);
      if (id != null && id.equals(getID())) {
        if (player.hasPermission("slimefunreloaded.inventory.bypass") || Slimefun.getProtectionManager().hasPermission(player, clickedBlock, ProtectableAction.ACCESS_INVENTORIES)) {
          ItemStack input = player.getInventory().getItemInMainHand();
          SlimefunReloadedComponent machine = Slimefun.getComponentManager().getComponentByNamespace(id);
          for (ItemStack convert : RecipeType.getRecipeInputs(machine)) {
            if (convert != null && input.isSimilar(convert)) {
              ItemStack removing = input.clone();
              removing.setAmount(convert.getAmount());
              player.getInventory().removeItem(removing);
              ItemStack adding = RecipeType.getRecipeOutput(machine, convert);
              for (int i = 1; i < 12; i++) {
                int j = i;

                Bukkit.getScheduler().runTaskLater(Slimefun.getSlimefunReloaded(), () -> {
                  if (j < 11) {
                    clickedBlock.getWorld().playEffect(clickedBlock.getLocation(), Effect.STEP_SOUND, input.getType().isBlock() ? input.getType() : Material.HAY_BLOCK);
                  } else {
                    player.getWorld().playSound(player.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 1F, 1F);
                    clickedBlock.getWorld().dropItemNaturally(clickedBlock.getRelative(BlockFace.UP).getLocation(), adding);
                  }
                }, i * 30L);
              }
              return true;
            }
          }
          I18n.tl(player, "messages.wrong-item");
          return true;
        }
        return true;
      }
    }
    return false;
  }

}
