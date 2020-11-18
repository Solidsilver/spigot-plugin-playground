package dev.solidsilver.testplugin.items.tools;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

import dev.solidsilver.testplugin.utils.ItemUtils;

public class CustomShovel extends CustomTool {

  private Material madeFrom;

  public CustomShovel(String name, Material madeFrom, int modelData, double attackDamage, double attackSpeed) {
    super(name, Material.DIAMOND_SHOVEL, modelData, attackDamage, attackSpeed);
    this.madeFrom = madeFrom;
  }

  public CustomShovel(Material madeFrom, int modelData, double attackDamage, double attackSpeed) {
    super(ItemUtils.getMaterialName(madeFrom) + " Shovel", Material.DIAMOND_SHOVEL, modelData, attackDamage,
        attackSpeed);
    this.madeFrom = madeFrom;
  }

  public CustomShovel(Material madeFrom, Material backing, int modelData) {
    super(ItemUtils.getMaterialName(madeFrom) + " Shovel", backing, modelData);
    this.madeFrom = madeFrom;
  }

  @Override
  public void registerRecipe(JavaPlugin plugin) {

    ShapedRecipe pickRecipe = new ShapedRecipe(ItemUtils.getGenericKey(plugin, this.name), this.item);
    pickRecipe.shape("M", "S", "S");
    pickRecipe.setIngredient('M', this.madeFrom);
    pickRecipe.setIngredient('S', Material.STICK);

    Bukkit.addRecipe(pickRecipe);

  }

}
