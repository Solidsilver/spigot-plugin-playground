package dev.solidsilver.testplugin.items.tools;

import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.meta.ItemMeta;

import dev.solidsilver.testplugin.items.CustomItem;

public abstract class CustomTool extends CustomItem {

  protected String name;

  public CustomTool(String name, Material base, int modelData, double attackDamage, double attackSpeed) {
    super(base);
    ItemMeta esMeta = this.item.getItemMeta();
    this.name = name;
    esMeta.setDisplayName(ChatColor.RESET + name);
    esMeta.setCustomModelData(modelData);
    esMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier(UUID.randomUUID(),
        "generic.attackSpeed", attackSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND));
    esMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(UUID.randomUUID(),
        "generic.attackDamage", attackDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND));
    this.item.setItemMeta(esMeta);
  }

  public CustomTool(String name, Material base, int modelData) {
    super(base);
    ItemMeta esMeta = this.item.getItemMeta();
    this.name = name;
    esMeta.setDisplayName(ChatColor.RESET + name);
    esMeta.setCustomModelData(modelData);
    this.item.setItemMeta(esMeta);
  }

}
