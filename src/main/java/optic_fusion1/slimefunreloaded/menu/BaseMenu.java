package optic_fusion1.slimefunreloaded.menu;

import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Spliterator;
import java.util.function.Consumer;
import optic_fusion1.slimefunreloaded.Slimefun;
import optic_fusion1.slimefunreloaded.menu.button.BaseButton;
import optic_fusion1.slimefunreloaded.util.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public abstract class BaseMenu implements Listener {

  private Map<Integer, BaseButton> buttons = new HashMap<>();
  private Inventory inventory = null;
  private InventoryHolder owner = null;
  private InventoryType inventoryType = null;
  private String title = "Inventory";
  private int size = 9;

  public BaseMenu(InventoryHolder owner, InventoryType inventoryType) {
    inventory = Bukkit.createInventory(owner, inventoryType);
    this.owner = owner;
    this.inventoryType = inventoryType;
    Bukkit.getPluginManager().registerEvents(this, Slimefun.getSlimefunReloaded());
  }

  public BaseMenu(InventoryHolder owner, int size) {
    inventory = Bukkit.createInventory(owner, size);
    this.owner = owner;
    this.size = size;
    Bukkit.getPluginManager().registerEvents(this, Slimefun.getSlimefunReloaded());
  }

  public BaseMenu(InventoryHolder owner, InventoryType inventoryType, String title) {
    inventory = Bukkit.createInventory(owner, inventoryType, StringUtils.color(title));
    this.owner = owner;
    this.inventoryType = inventoryType;
    this.title = title;
    Bukkit.getPluginManager().registerEvents(this, Slimefun.getSlimefunReloaded());
  }

  public BaseMenu(InventoryHolder owner, String title, int size) {
    inventory = Bukkit.createInventory(owner, size, StringUtils.color(title));
    this.owner = owner;
    this.title = title;
    this.size = size;
    Bukkit.getPluginManager().registerEvents(this, Slimefun.getSlimefunReloaded());
  }

  public BaseMenu(String title, int size) {
    inventory = Bukkit.createInventory(null, size, StringUtils.color(title));
    this.title = title;
    this.size = size;
    Bukkit.getPluginManager().registerEvents(this, Slimefun.getSlimefunReloaded());
  }

  public BaseMenu(String title) {
    inventory = Bukkit.createInventory(null, 9, StringUtils.color(title));
    this.title = title;
    this.size = 9;
    Bukkit.getPluginManager().registerEvents(this, Slimefun.getSlimefunReloaded());
  }

  public Inventory getInventory() {
    return inventory;
  }

  public InventoryHolder getOwner() {
    return owner;
  }

  public InventoryType getInventoryType() {
    return inventoryType;
  }

  public String getTitle() {
    return title;
  }

  public String getColorizedTitle() {
    return ChatColor.translateAlternateColorCodes('&', title);
  }

  public int getSize() {
    return size;
  }

  public void openMenu(Player player) {
    player.openInventory(inventory);
  }

  public void addButton(BaseButton button) {
    buttons.put(button.getSlot(), button);
    inventory.setItem(button.getSlot(), button.getItemStack());
  }

  @EventHandler(priority = EventPriority.HIGHEST)
  public void on(InventoryClickEvent event) {
    if (event.getClickedInventory() != inventory) {
      return;
    }
    event.setCancelled(true);
    BaseButton button = buttons.get(event.getSlot());
    if (button == null) {
      return;
    }
    button.click();
  }

  public int getMaxStackSize() {
    return inventory.getMaxStackSize();
  }

  public void setMaxStackSize(int size) {
    inventory.setMaxStackSize(size);
  }

  public ItemStack getItem(int index) {
    return inventory.getItem(index);
  }

  public void setItem(int index, ItemStack item) {
    inventory.setItem(index, item);
  }

  public HashMap<Integer, ItemStack> addItem(ItemStack... items) throws IllegalArgumentException {
    return inventory.addItem(items);
  }

  public HashMap<Integer, ItemStack> removeItem(ItemStack... items) throws IllegalArgumentException {
    return inventory.removeItem(items);
  }

  public ItemStack[] getContents() {
    return inventory.getContents();
  }

  public void setContents(ItemStack[] items) throws IllegalArgumentException {
    inventory.setContents(items);
  }

  public ItemStack[] getStorageContents() {
    return inventory.getStorageContents();
  }

  public void setStorageContents(ItemStack[] items) throws IllegalArgumentException {
    inventory.setStorageContents(items);
  }

  public boolean contains(Material material) throws IllegalArgumentException {
    return inventory.contains(material);
  }

  public boolean contains(ItemStack item) {
    return inventory.contains(item);
  }

  public boolean contains(Material material, int amount) throws IllegalArgumentException {
    return inventory.contains(material, amount);
  }

  public boolean contains(ItemStack item, int amount) {
    return inventory.contains(item, amount);
  }

  public boolean containsAtLeast(ItemStack item, int amount) {
    return inventory.containsAtLeast(item, amount);
  }

  public HashMap<Integer, ? extends ItemStack> all(Material material) throws IllegalArgumentException {
    return inventory.all(material);
  }

  public HashMap<Integer, ? extends ItemStack> all(ItemStack item) {
    return inventory.all(item);
  }

  public int first(Material material) throws IllegalArgumentException {
    return inventory.first(material);
  }

  public int first(ItemStack item) {
    return inventory.first(item);
  }

  public int firstEmpty() {
    return inventory.firstEmpty();
  }

  public void remove(Material material) throws IllegalArgumentException {
    inventory.remove(material);
  }

  public void remove(ItemStack item) {
    inventory.remove(item);
  }

  public void clear(int index) {
    inventory.clear(index);
  }

  public void clear() {
    inventory.clear();
  }

  public List<HumanEntity> getViewers() {
    return inventory.getViewers();
  }

  public InventoryType getType() {
    return inventory.getType();
  }

  public InventoryHolder getHolder() {
    return inventory.getHolder();
  }

  public ListIterator<ItemStack> iterator() {
    return inventory.iterator();
  }

  public ListIterator<ItemStack> iterator(int index) {
    return inventory.iterator(index);
  }

  public Location getLocation() {
    return inventory.getLocation();
  }

  public void forEach(Consumer<? super ItemStack> action) {
    inventory.forEach(action);
  }

  public Spliterator<ItemStack> spliterator() {
    return inventory.spliterator();
  }

}
