package dev.solidsilver.testplugin.items.tools;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

import dev.solidsilver.testplugin.utils.ItemUtils;

public class CustomSword extends CustomTool {

  private Material madeFrom;

  public CustomSword(String name, Material madeFrom, int modelData, double attackDamage, double attackSpeed) {
    super(name, Material.DIAMOND_SWORD, modelData, attackDamage, attackSpeed);
    this.madeFrom = madeFrom;
  }

  public CustomSword(Material madeFrom, int modelData, double attackDamage, double attackSpeed) {
    super(ItemUtils.getMaterialName(madeFrom) + " Sword", Material.DIAMOND_SWORD, modelData, attackDamage, attackSpeed);
    this.madeFrom = madeFrom;
  }

  public CustomSword(Material madeFrom, Material backing, int modelData) {
    super(ItemUtils.getMaterialName(madeFrom) + " Sword", backing, modelData);
    this.madeFrom = madeFrom;
  }

  @Override
  public void registerRecipe(JavaPlugin plugin) {
    ShapedRecipe swordRecipe = new ShapedRecipe(ItemUtils.getGenericKey(plugin, this.name), this.item);
    swordRecipe.shape("M", "M", "S");
    swordRecipe.setIngredient('M', this.madeFrom);
    swordRecipe.setIngredient('S', Material.STICK);

    Bukkit.addRecipe(swordRecipe);
  }

}
