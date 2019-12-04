package optic_fusion1.slimefunreloaded.component.item.impl;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.component.RecipeType;
import optic_fusion1.slimefunreloaded.component.item.SlimefunReloadedItem;
import optic_fusion1.slimefunreloaded.research.Research;
import optic_fusion1.slimefunreloaded.util.PlayerProfile;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class KnowledgeTome extends SlimefunReloadedItem {

  public KnowledgeTome(NamespacedKey key, Category category, ItemStack item, RecipeType recipeType, ItemStack[] recipe) {
    super(key, category, item, recipeType, recipe);
  }

  @Override
  public boolean onInteract(Player player, ItemStack item, Action action, Block clickedBlock) {
    if (item.isSimilar(getItem())) {
      List<String> lore = item.getItemMeta().getLore();
      lore.set(0, ChatColor.translateAlternateColorCodes('&', "&7Owner: &b" + player.getName()));
      lore.set(1, ChatColor.BLACK + "" + player.getUniqueId());
      ItemMeta im = item.getItemMeta();
      im.setLore(lore);
      item.setItemMeta(im);
      player.getEquipment().setItemInMainHand(item);
      player.getWorld().playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1F, 1F);
      return true;
    } else {
      PlayerProfile.get(player, profile -> {
        PlayerProfile.fromUUID(UUID.fromString(ChatColor.stripColor(item.getItemMeta().getLore().get(1))), owner -> {
          Set<Research> researches = owner.getResearches();
          researches.forEach(research -> profile.setResearched(research, true));
        });
      });

      if (player.getGameMode() != GameMode.CREATIVE) {
        consumeItem(item, false);
      }
      return true;
    }
  }

}
