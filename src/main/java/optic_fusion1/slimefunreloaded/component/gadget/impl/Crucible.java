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
import optic_fusion1.slimefunreloaded.util.material.MaterialCollections;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.Tag;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.Levelled;
import org.bukkit.block.data.Waterlogged;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemStack;

public class Crucible extends SlimefunReloadedGadget {

  public Crucible(NamespacedKey key, Category category, ItemStack item, RecipeType recipeType, ItemStack[] recipe) {
    super(key, category, item, recipeType, recipe/*, getMachineRecipe()*/);
  }

  private static ItemStack[] getMachineRecipes() {
    List<ItemStack> items = new LinkedList<>();

    items.add(new ItemStack(Material.COBBLESTONE, 16));
    items.add(new ItemStack(Material.LAVA_BUCKET));

    items.add(new ItemStack(Material.NETHERRACK, 16));
    items.add(new ItemStack(Material.LAVA_BUCKET));

    items.add(new ItemStack(Material.STONE, 12));
    items.add(new ItemStack(Material.LAVA_BUCKET));

    items.add(new ItemStack(Material.OBSIDIAN, 1));
    items.add(new ItemStack(Material.LAVA_BUCKET));

    for (Material leave : MaterialCollections.getAllLeaves()) {
      items.add(new ItemStack(leave, 16));
      items.add(new ItemStack(Material.WATER_BUCKET));
    }

    for (Material sapling : MaterialCollections.getAllTerracottaColors()) {
      items.add(new ItemStack(sapling, 12));
      items.add(new ItemStack(Material.LAVA_BUCKET));
    }

    return items.toArray(new ItemStack[0]);
  }

  @Override
  public boolean onInteract(Player player, ItemStack item, Action action, Block clickedBlock) {
    if (clickedBlock != null) {
      String id = BlockStorage.checkID(clickedBlock);
      if (id != null && id.equals("CRUCIBLE")) {
        if (player.hasPermission("slimefunreloaded.inventory.bypass") || Slimefun.getProtectionManager().hasPermission(player, clickedBlock.getLocation(), ProtectableAction.ACCESS_INVENTORIES)) {
          ItemStack input = player.getInventory().getItemInMainHand();
          Block block = clickedBlock.getRelative(BlockFace.UP);
          SlimefunReloadedComponent component = Slimefun.getComponentManager().getComponentByNamespace(id);
          for (ItemStack convert : RecipeType.getRecipeInputs(component)) {
            if (input.isSimilar(convert)) {
              //e.setCancelled(true);
              ItemStack removing = input.clone();
              removing.setAmount(convert.getAmount());
              player.getInventory().removeItem(removing);
              boolean water = Tag.LEAVES.isTagged(input.getType());
              if (block.getType() == (water ? Material.WATER : Material.LAVA)) {
                int level = ((Levelled) block.getBlockData()).getLevel();
                if (level > 7) {
                  level -= 8;
                }
                if (level == 0) {
                  block.getWorld().playSound(block.getLocation(), water ? Sound.ENTITY_PLAYER_SPLASH : Sound.BLOCK_LAVA_POP, 1F, 1F);
                } else {
                  int finalLevel = 7 - level;
                  Slimefun.runSync(() -> runPostTask(block, water ? Sound.ENTITY_PLAYER_SPLASH : Sound.BLOCK_LAVA_POP, finalLevel), 50L);
                }
                return true;
              } else if (block.getType() == (water ? Material.LAVA : Material.WATER)) {
                int level = ((Levelled) block.getBlockData()).getLevel();
                block.setType(level == 0 || level == 8 ? Material.OBSIDIAN : Material.STONE);
                block.getWorld().playSound(block.getLocation(), Sound.BLOCK_LAVA_EXTINGUISH, 1F, 1F);
                return true;
              }
              Slimefun.runSync(() -> {
                if (!block.getType().isAir()) {
                  if (water) {
                    if (block.getBlockData() instanceof Waterlogged) {
                      Waterlogged wl = (Waterlogged) block.getBlockData();
                      wl.setWaterlogged(true);
                      block.setBlockData(wl, false);
                      block.getWorld().playSound(block.getLocation(), Sound.ENTITY_PLAYER_SPLASH, 1F, 1F);
                      return;
                    }
                    block.getWorld().playSound(block.getLocation(), Sound.BLOCK_METAL_BREAK, 1F, 1F);
                    return;
                  }
                  if (BlockStorage.hasBlockInfo(block)) {
                    BlockStorage.clearBlockInfo(block);
                  }
                  block.getWorld().playSound(block.getLocation(), Sound.BLOCK_LAVA_EXTINGUISH, 1F, 1F);
                }
                block.setType(water ? Material.WATER : Material.LAVA);
                runPostTask(block, water ? Sound.ENTITY_PLAYER_SPLASH : Sound.BLOCK_LAVA_POP, 1);
              }, 50L);
            }
          }
        }
      }
    }
    return false;
  }

  private void runPostTask(Block block, Sound sound, int times) {
    if (!(block.getBlockData() instanceof Levelled)) {
      block.getWorld().playSound(block.getLocation(), Sound.BLOCK_METAL_BREAK, 1F, 1F);
      return;
    }

    block.getWorld().playSound(block.getLocation(), sound, 1F, 1F);
    int level = 8 - times;
    Levelled le = (Levelled) block.getBlockData();
    le.setLevel(level);
    block.setBlockData(le, false);

    if (times < 8) {
      Slimefun.runSync(() -> runPostTask(block, sound, times + 1), 50L);
    }
  }

}
