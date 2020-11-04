package dev.solidsilver.compressor;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

public class Items {

    public static ItemStack getGoldDust(int number) {
        ItemStack goldDust = new ItemStack(Material.GLOWSTONE_DUST, number);
        ItemMeta gdMeta = goldDust.getItemMeta();
        gdMeta.setDisplayName("Gold Dust");
        gdMeta.setCustomModelData(5001);
        goldDust.setItemMeta(gdMeta);
        return goldDust;
    }

    public static ItemStack getGoldDust() {
        return getGoldDust(1);
    }

    public static ItemStack getIronDust(int number) {
        ItemStack ironDust = new ItemStack(Material.SUGAR, number);
        ItemMeta idMeta = ironDust.getItemMeta();
        idMeta.setDisplayName("Iron Dust");
        idMeta.setCustomModelData(5002);
        ironDust.setItemMeta(idMeta);
        return ironDust;
    }

    public static ItemStack getIronDust() {
        return getIronDust(1);
    }


    public static ItemStack getGoldOreDrop() {
        int num = new Random().nextInt(3) + 2;
        return getGoldDust(num);

    }

    public static ItemStack getIronOreDrop() {
        int num = new Random().nextInt(3) + 2;
        return getIronDust(num);

    }

    public static ItemStack getChainMail() {
        return getChainMail(1);
    }

    public static ItemStack getChainMail(int number) {
        ItemStack chainMail = new ItemStack(Material.IRON_INGOT, number);
        ItemMeta cmMeta = chainMail.getItemMeta();
        cmMeta.setDisplayName("Chainmail");
        cmMeta.setCustomModelData(5003);
        chainMail.setItemMeta(cmMeta);
        return chainMail;
    }

    public static ItemStack getEmeraldSword() {
        return getEmeraldSword(1);
    }

    public static ItemStack getEmeraldSword(int number) {
        ItemStack emeraldSword = new ItemStack(Material.DIAMOND_SWORD, number);
        ItemMeta esMeta = emeraldSword.getItemMeta();
        esMeta.setDisplayName(ChatColor.RESET + "Emerald Sword");
        esMeta.setCustomModelData(5004);
        esMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", 3, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND));
        esMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 10, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND));
        emeraldSword.setItemMeta(esMeta);
        return emeraldSword;
    }

    public static ItemStack getEmeraldAxe() {
        return getEmeraldAxe(1);
    }

    public static ItemStack getEmeraldAxe(int number) {
        ItemStack emeraldAxe = new ItemStack(Material.DIAMOND_AXE, number);
        ItemMeta eaMeta = emeraldAxe.getItemMeta();
        eaMeta.setDisplayName(ChatColor.RESET + "Emerald Axe");
        eaMeta.setCustomModelData(5004);
//        eaMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", 3, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND));
//        eaMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 10, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND));
        emeraldAxe.setItemMeta(eaMeta);
        return emeraldAxe;
    }


    public static ItemStack getObsidianSword() {
        return getObsidianSword(1);
    }

    public static ItemStack getObsidianSword(int number) {
        ItemStack obsidianSword = new ItemStack(Material.DIAMOND_SWORD, number);
        ItemMeta osMeta = obsidianSword.getItemMeta();
        osMeta.setDisplayName(ChatColor.RESET + "Obsidian Sword");
        osMeta.setCustomModelData(5005);
        osMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", 6, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND));
        osMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 12, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND));
        obsidianSword.setItemMeta(osMeta);
        return obsidianSword;
    }

    public static ItemStack getObsidianAxe() {
        return getObsidianAxe(1);
    }

    public static ItemStack getObsidianAxe(int number) {
        ItemStack obsidianAxe = new ItemStack(Material.DIAMOND_AXE, number);
        ItemMeta oaMeta = obsidianAxe.getItemMeta();
        oaMeta.setDisplayName(ChatColor.RESET + "Obsidian Axe");
        oaMeta.setCustomModelData(5005);
//        esMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", 6, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND));
//        esMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 12, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND));
        obsidianAxe.setItemMeta(oaMeta);
        return obsidianAxe;
    }

    public static ItemStack getCompressedCobble(int level) {
        return getCompressedCobble(level, 1);
    }

    public static ItemStack getCompressedCobble(int level, int number) {
        ItemStack compressedCobble = new ItemStack(Material.COBBLESTONE, number);
        ItemMeta compCobbleMeta = compressedCobble.getItemMeta();
        compCobbleMeta.setDisplayName(getCompressedName(level) + "Cobblestone");
//        compCobbleMeta.setCustomModelData(5001);
        ArrayList<String> compLore = new ArrayList<>();
        String realCobbleCount = (new BigInteger("9")).pow(level).toString();
        compLore.add("Contains " + realCobbleCount + " blocks of Cobblestone");
        compCobbleMeta.setLore(compLore);
        compressedCobble.setItemMeta(compCobbleMeta);
        return compressedCobble;
    }

    public static String getCompressedName(int lvl) {
        String toRet = "";
        switch (lvl) {
            case 0: return "";
            case 1: return "Compressed ";
            case 2: toRet += "Double"; break;
            case 3: toRet += "Triple"; break;
            case 4: toRet += "Quadruple"; break;
            case 5: toRet += "Quintuple"; break;
            case 6: toRet += "Sextuple"; break;
            default: toRet += lvl + "x";
        }
        return toRet + " Compressed ";
    }
}
