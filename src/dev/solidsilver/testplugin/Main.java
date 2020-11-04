package dev.solidsilver.testplugin;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.*;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Recipies rp = new Recipies(this);

        for (int i = 1; i <= 128; i++) {
            Bukkit.addRecipe(rp.getCompCobbleRecipe(i));
            Bukkit.addRecipe(rp.getUncompressCobbleRecipe(i));
        }
        Bukkit.addRecipe(rp.smeltGoldDust());
        Bukkit.addRecipe(rp.smeltIronDust());
        Bukkit.addRecipe(rp.getChainmailRecipe());

        for (ShapedRecipe recipe : rp.getShapedRecipies()) {
            Bukkit.addRecipe(recipe);
        }

        this.getServer().getPluginManager().registerEvents(this, this);
        this.getServer().getPluginManager().registerEvents(new JoinEvent(), this);
    }

    @Override
    public void onDisable() {
        // Fired when the server stops and disables all plugins
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command");
            return false;
        }

        Player player = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("compressedCobble")) {
            ItemStack cobbleStack = new ItemStack(Material.COBBLESTONE);
            if (args.length > 0) {
                int compressionLevel = Integer.parseInt(args[0]);
                if (compressionLevel > 0 && compressionLevel <= 128) {
                    cobbleStack = Items.getCompressedCobble(compressionLevel);
                    player.getInventory().addItem(cobbleStack);
                    return true;
                } else {
                    player.sendMessage("Level must be in range 1-16");
                    return false;
                }
            }
        }

        return true;
    }

    @EventHandler
    public void onMine(BlockBreakEvent event) {
        Block block = event.getBlock();
        if (block.getDrops(event.getPlayer().getInventory().getItemInMainHand()).size() > 0) {
            if (event.isDropItems()) {
                if (block.getType() == Material.GOLD_ORE) {
                    event.setDropItems(false);
                    event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(),
                            Items.getGoldOreDrop());
                } else if (block.getType() == Material.IRON_ORE) {
                    event.setDropItems(false);
                    event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(),
                            Items.getIronOreDrop());
                }
            }
        }
    }

}
