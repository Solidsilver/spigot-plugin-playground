package dev.solidsilver.testplugin.items.tools;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

import dev.solidsilver.testplugin.utils.ItemUtils;

public class FancyRapier extends CustomTool {

  private Material madeFrom;

  public FancyRapier(Material madeFrom, int modelData, double attackDamage, double attackSpeeds) {
    super("Fancy " + ItemUtils.getMaterialName(madeFrom) + " Rapier", Material.IRON_SWORD, modelData);
    this.madeFrom = madeFrom;
  }

  @Override
  public void registerRecipe(JavaPlugin plugin) {
    ShapedRecipe swordRecipe = new ShapedRecipe(ItemUtils.getGenericKey(plugin, this.name), this.item);
    swordRecipe.shape("  M", " M ", "SS ");
    swordRecipe.setIngredient('M', this.madeFrom);
    swordRecipe.setIngredient('S', Material.STICK);

    Bukkit.addRecipe(swordRecipe);

  }

}
