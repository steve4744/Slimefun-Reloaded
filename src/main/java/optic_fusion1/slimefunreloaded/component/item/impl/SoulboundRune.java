package optic_fusion1.slimefunreloaded.component.item.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import optic_fusion1.slimefunreloaded.Slimefun;
import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.component.RecipeType;
import optic_fusion1.slimefunreloaded.component.item.SlimefunReloadedItem;
import optic_fusion1.slimefunreloaded.util.I18n;
import optic_fusion1.slimefunreloaded.util.SlimefunReloadedItems;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SoulboundRune extends SlimefunReloadedItem {

  public SoulboundRune(NamespacedKey key, Category category, ItemStack item, RecipeType recipeType, ItemStack[] recipe) {
    super(key, category, item, recipeType, recipe);
  }

  @Override
  public boolean onDrop(Player player, Item item) {
    if (!Slimefun.hasUnlocked(player, SlimefunReloadedItems.RUNE_SOULBOUND, true)) {
      return true;
    }

    Bukkit.getScheduler().scheduleSyncDelayedTask(Slimefun.getSlimefunReloaded(), () -> {
      // Being sure the entity is still valid and not picked up or whatsoever.
      if (!item.isValid()) {
        return;
      }

      Location l = item.getLocation();
      Collection<Entity> entites = l.getWorld().getNearbyEntities(l, 1.5, 1.5, 1.5,
       entity -> entity instanceof Item && !SlimefunManager.isItemSoulbound(((Item) entity).getItemStack())
       && !SlimefunManager.isItemSimiliar(((Item) entity).getItemStack(), SlimefunReloadedItems.RUNE_SOULBOUND, true)
      );

      if (entites.isEmpty()) {
        return;
      }

      Entity entity = entites.stream().findFirst().get();
      ItemStack ench = ((Item) entity).getItemStack();
      Item ent = (Item) entity;

      if (ench.getAmount() == 1) {
        //e.setCancelled(true);
        ItemMeta enchMeta = ench.getItemMeta();
        List<String> lore = enchMeta.hasLore() ? enchMeta.getLore() : new ArrayList<>();

        // This lightning is just an effect, it deals no damage.
        l.getWorld().strikeLightningEffect(l);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Slimefun.getSlimefunReloaded(), () -> {

          // Being sure entities are still valid and not picked up or whatsoever.
          if (item.isValid() && ent.isValid()) {

            l.getWorld().createExplosion(l, 0.0F);
            l.getWorld().playSound(l, Sound.ENTITY_GENERIC_EXPLODE, 0.3F, 1F);

            lore.add(ChatColor.GRAY + "Soulbound");

            enchMeta.setLore(lore);
            ench.setItemMeta(enchMeta);

            ent.remove();
            item.remove();
            l.getWorld().dropItemNaturally(l, ench);
            I18n.tl(player, "messages.soulbound-rune.success");
          }
        }, 10L);
      } else {
        I18n.tl(player, "messages.soulbound-rune.sucess");
      }
    }, 20L);

    return true;
  }

}
