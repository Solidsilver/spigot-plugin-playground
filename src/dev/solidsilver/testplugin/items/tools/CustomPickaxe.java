package dev.solidsilver.testplugin.items.tools;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

import dev.solidsilver.testplugin.utils.ItemUtils;

public class CustomPickaxe extends CustomTool {

  private Material madeFrom;

  public CustomPickaxe(String name, Material madeFrom, int modelData, double attackDamage, double attackSpeed) {
    super(name, Material.DIAMOND_PICKAXE, modelData, attackDamage, attackSpeed);
    this.madeFrom = madeFrom;
  }

  public CustomPickaxe(Material madeFrom, int modelData, double attackDamage, double attackSpeed) {
    super(ItemUtils.getMaterialName(madeFrom) + " Pickaxe", Material.DIAMOND_PICKAXE, modelData, attackDamage,
        attackSpeed);
    this.madeFrom = madeFrom;
  }

  public CustomPickaxe(Material madeFrom, Material backing, int modelData) {
    super(ItemUtils.getMaterialName(madeFrom) + " Pickaxe", backing, modelData);
    this.madeFrom = madeFrom;
  }

  @Override
  public void registerRecipe(JavaPlugin plugin) {

    ShapedRecipe pickRecipe = new ShapedRecipe(ItemUtils.getGenericKey(plugin, this.name), this.item);
    pickRecipe.shape("MMM", " S ", " S ");
    pickRecipe.setIngredient('M', this.madeFrom);
    pickRecipe.setIngredient('S', Material.STICK);

    Bukkit.addRecipe(pickRecipe);

  }

}
