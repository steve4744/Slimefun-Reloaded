package optic_fusion1.slimefunreloaded.listener;

import optic_fusion1.slimefunreloaded.util.BackpackInventory;
import optic_fusion1.slimefunreloaded.util.PlayerProfile;
import optic_fusion1.slimefunreloaded.util.SlimefunReloadedItems;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;

public class CoolerListener implements Listener {

  @EventHandler
  public void onStarve(FoodLevelChangeEvent event) {
    Player player = (Player) event.getEntity();
    if (event.getFoodLevel() < player.getFoodLevel()) {
      for (ItemStack itemStack : player.getInventory().getContents()) {
        if (itemStack != null && itemStack.isSimilar(SlimefunReloadedItems.COOLER)) {
          BackpackInventory backpack = PlayerProfile.getBackpack(itemStack);
          if (backpack != null) {
            Inventory inventory = backpack.getInventory();
            int slot = -1;
            for (int i = 0; i < inventory.getSize(); i++) {
              ItemStack item = inventory.getItem(i);
              if (item != null && item.getType() == Material.POTION && item.hasItemMeta() && item.getItemMeta().hasDisplayName()) {
                slot = i;
                break;
              }
            }
            if (slot >= 0) {
              PotionMeta im = (PotionMeta) inventory.getItem(slot).getItemMeta();

              for (PotionEffect effect : im.getCustomEffects()) {
                player.addPotionEffect(effect);
              }

              player.setSaturation(6F);
              player.playSound(player.getLocation(), Sound.ENTITY_GENERIC_DRINK, 1F, 1F);
              inventory.setItem(slot, null);
              backpack.markDirty();
              break;
            }
          }
        }
      }
    }
  }

}
