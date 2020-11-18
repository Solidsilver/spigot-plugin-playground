package dev.solidsilver.testplugin.utils;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

public class ItemUtils {

  public static NamespacedKey getGenericKey(JavaPlugin plug, String name) {
    return new NamespacedKey(plug, name.toLowerCase().replace(' ', '_'));
  }

  public static String getMaterialName(Material m) {
    String baseName = m.toString().replace('_', ' ');
    return baseName.substring(0, 1) + baseName.substring(1).toLowerCase();
  }

}
