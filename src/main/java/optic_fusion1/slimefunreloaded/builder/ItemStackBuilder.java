package optic_fusion1.slimefunreloaded.builder;

import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.chat.ComponentSerializer;
import net.minecraft.server.v1_14_R1.NBTTagCompound;
import net.minecraft.server.v1_14_R1.NBTTagInt;
import net.minecraft.server.v1_14_R1.NBTTagList;
import net.minecraft.server.v1_14_R1.NBTTagLong;
import net.minecraft.server.v1_14_R1.NBTTagString;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_14_R1.inventory.CraftItemStack;

public class ItemStackBuilder {

  private NBTTagCompound baseCompound = new NBTTagCompound();
  private NBTTagCompound displayCompound = new NBTTagCompound();
  private NBTTagList loreList = new NBTTagList();
  private NBTTagCompound tagCompound = new NBTTagCompound();
  private NBTTagList canPlaceOnList = new NBTTagList();
  private NBTTagList canDestroyList = new NBTTagList();
  private NBTTagInt hideFlagsInt = new NBTTagInt(-1);
  private NBTTagList enchantmentList = new NBTTagList();
  private NBTTagList attributeList = new NBTTagList();

  public ItemStackBuilder(Material material) {
    baseCompound.set("id", new NBTTagString("minecraft:" + material.toString().toLowerCase()));
    baseCompound.set("Count", new NBTTagInt(1));
  }

  public NBTTagCompound getBaseCompound() {
    return baseCompound;
  }

  public NBTTagCompound getTagCompound() {
    return tagCompound;
  }

  public ItemStackBuilder setSlot(int count) {
    baseCompound.setInt("Slot", count < 0 ? 0 : count > 26 ? 26 : count);
    return this;
  }

  public ItemStackBuilder setCount(int count) {
    baseCompound.setInt("Count", count < 1 ? 1 : count > 64 ? 64 : count);
    return this;
  }

  public ItemStackBuilder setName(String name) {
    displayCompound.set("Name", new NBTTagString(ComponentSerializer.toString(new TextComponent(ChatColor.translateAlternateColorCodes('&', name)))));
    return this;
  }

  public ItemStackBuilder addLore(String... lores) {
    for (String lore : lores) {
      loreList.add(new NBTTagString(ComponentSerializer.toString(new TextComponent(ChatColor.translateAlternateColorCodes('&', lore)))));
    }
    return this;
  }

  public ItemStackBuilder addCanPlaceOn(Material... materials) {
    for (Material material : materials) {
      canPlaceOnList.add(new NBTTagString("minecraft:" + material.toString().toLowerCase()));
    }
    return this;
  }

  public ItemStackBuilder addCanDestroy(Material... materials) {
    for (Material material : materials) {
      canDestroyList.add(new NBTTagString("minecraft:" + material.toString().toLowerCase()));
    }
    return this;
  }

  public ItemStackBuilder hideFlag(ItemFlag... flags) {
    int value = 0;
    for (ItemFlag flag : flags) {
      value = value + flag.getValue();
    }
    hideFlagsInt = new NBTTagInt(value);
    return this;
  }

  public ItemStackBuilder addEnchantment(String name, int level) {
    NBTTagCompound enchantment = new NBTTagCompound();
    enchantment.set("id", new NBTTagString("minecraft:" + name));
    enchantment.set("lvl", new NBTTagInt(level));
    enchantmentList.add(enchantment);
    return this;
  }

  public ItemStackBuilder addAttributeModifier(Attribute... itemAttributes) {
    for (Attribute itemAttribute : itemAttributes) {
      NBTTagCompound attribute = new NBTTagCompound();
      attribute.set("AttributeName", new NBTTagString("generic." + itemAttribute.getName()));
      attribute.set("Name", new NBTTagString("generic." + itemAttribute.getName()));
      attribute.set("Amount", new NBTTagInt(itemAttribute.getAmount()));
      attribute.set("Operation", new NBTTagInt(itemAttribute.getOperation().getValue()));
      attribute.set("UUIDMost", new NBTTagLong(itemAttribute.getUniqueId().getMostSignificantBits()));
      attribute.set("UUIDLeast", new NBTTagLong(itemAttribute.getUniqueId().getLeastSignificantBits()));
      if (!itemAttribute.getSlot().getValue().equals("any")) {
        attribute.set("Slot", new NBTTagString(itemAttribute.getSlot().getValue()));
      }
      attributeList.add(attribute);
    }
    return this;
  }

  public void update() {
    if (!attributeList.isEmpty()) {
      tagCompound.set("AttributeModifiers", attributeList);
    }
    if (!enchantmentList.isEmpty()) {
      tagCompound.set("Enchantments", enchantmentList);
    }
    if (hideFlagsInt.asInt() != -1) {
      tagCompound.set("HideFlags", hideFlagsInt);
    }
    if (!canPlaceOnList.isEmpty()) {
      tagCompound.set("CanPlaceOn", canPlaceOnList);
    }
    if (!canDestroyList.isEmpty()) {
      tagCompound.set("CanDestroy", canDestroyList);
    }
    if (!loreList.isEmpty()) {
      displayCompound.set("Lore", loreList);
    }
    if (!displayCompound.isEmpty()) {
      tagCompound.set("display", displayCompound);
    }
    if (!tagCompound.isEmpty()) {
      baseCompound.set("tag", tagCompound);
    }
  }

  public net.minecraft.server.v1_14_R1.ItemStack getNMSItemStack() {
    update();
    return net.minecraft.server.v1_14_R1.ItemStack.a(baseCompound);
  }

  public org.bukkit.inventory.ItemStack asBukkitItemStack() {
    update();
    return CraftItemStack.asBukkitCopy(net.minecraft.server.v1_14_R1.ItemStack.a(baseCompound));
  }

  public NBTTagCompound asNBTTagCompound() {
    update();
    return baseCompound;
  }

}
