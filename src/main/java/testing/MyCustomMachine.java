package testing;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import optic_fusion1.slimefunreloaded.Slimefun;
import optic_fusion1.slimefunreloaded.builder.ItemStackBuilder;
import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.component.machine.SlimefunReloadedMachine;

public final class MyCustomMachine extends SlimefunReloadedMachine<MyCustomMachineState> {

  private static final Category CATEGORY = Slimefun.getCategoryManager().getCategoryByName("Machines");
  private static final ItemStack ITEM = new ItemStackBuilder(Material.IRON_INGOT).setDisplayName("My Custom Machine!").build();

  public MyCustomMachine(JavaPlugin plugin) {
    super(new NamespacedKey(plugin, "my_custom_machine"), CATEGORY, ITEM);
  }

  @Override
  public void initState(MyCustomMachineState state, Player player) {
    state.setSomeValue(69);
    state.setContainsThisItem(new ItemStack(Material.DIAMOND));
  }

  @Override
  public boolean onInteract(MyCustomMachineState state, Player player, EquipmentSlot hand, BlockFace face) {
    player.getInventory().addItem(state.getContainsThisItem());
    return true; // true if success, false otherwise
  }

  @Override
  public boolean onAction(MyCustomMachineState state, Player player, BlockFace face) {
    player.sendMessage("Hey! Don't punch me :( I have a value of " + state.getSomeValue() + ", okay!?");
    return true; // true if success, false otherwise
  }

  @Override
  public void onDestroy(MyCustomMachineState state, Player player, ItemStack item, BlockFace face) {
    if (!state.hasItem()) {
      return;
    }

    Block block = state.getBlock();
    block.getWorld().dropItemNaturally(block.getLocation().add(0.5, 0.5, 0.5), state.getContainsThisItem());
  }

  @Override
  public MyCustomMachineState createState(Block block) {
    return new MyCustomMachineState(this, block);
  }

}
