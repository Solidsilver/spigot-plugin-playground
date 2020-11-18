package dev.solidsilver.testplugin.items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class CustomItem {
  protected ItemStack item;

  public ItemStack getItem() {
    return this.item;
  }

  public CustomItem(Material base) {
    this.item = new ItemStack(base);
  }

  public CustomItem(Material base, int number) {
    this.item = new ItemStack(base, number);
  }

  public abstract void registerRecipe(JavaPlugin plugin);

}
