package optic_fusion1.slimefunreloaded.component;

import java.util.Objects;

import org.bukkit.Keyed;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

import optic_fusion1.slimefunreloaded.category.type.Category;
import optic_fusion1.slimefunreloaded.research.Research;

/**
 * Represents a base for all slimefun components in the mod including items, blocks and
 * multiblocks.
 *
 * @author Parker "Choco" Hawke
 */
public abstract class SlimefunReloadedComponent implements Keyed {

  private final NamespacedKey key;
  private final Category category;
  private final ItemStack item;

  private Research research;

  protected SlimefunReloadedComponent(NamespacedKey key, Category category, ItemStack item) {
    this.key = key;
    this.category = category;
    this.item = item.clone();
  }

  @Override
  public final NamespacedKey getKey() {
    return key;
  }

  /**
   * Get the category to which this component belongs.
   *
   * @return the component category
   */
  public Category getCategory() {
    return category;
  }

  /**
   * Get the item representation of this component.
   *
   * @return the item
   */
  public ItemStack getItem() {
    return item.clone();
  }

  /**
   * Set the research required in order to discover this item. If set to null, the research
   * will be removed.
   *
   * @param research the research to set. null to remove
   */
  public void setResearch(Research research) {
    if (this.research != null) {
      this.research.removeComponent(this);
    }

    this.research = research;
  }

  /**
   * Get the research required in order to discover this item.
   *
   * @return the required research
   */
  public Research getResearch() {
    return research;
  }

  @Override
  public int hashCode() {
    return Objects.hash(key, category);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }

    if (!(obj instanceof SlimefunReloadedComponent)) {
      return false;
    }

    SlimefunReloadedComponent other = (SlimefunReloadedComponent) obj;
    return Objects.equals(key, other.key) && Objects.equals(category, other.category);
  }

}
