package dev.solidsilver.compressor;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.*;

import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.math.BigInteger;
import java.util.ArrayList;

public class Recipies {

    private JavaPlugin plugin;

    private ArrayList<ShapedRecipe> shapedRecipies;
    private ArrayList<ShapelessRecipe> shapelessRecipes;
    private ArrayList<FurnaceRecipe> furnaceRecipes;


    public Recipies(JavaPlugin plugin) {
        this.plugin = plugin;

        this.shapedRecipies = new ArrayList<>();
        shapedRecipies.add(getChainmailBootsRecipe());
        shapedRecipies.add(getChainmailLegsRecipe());
        shapedRecipies.add(getChainmailChestRecipe());
        shapedRecipies.add(getChainmailHelmRecipe());
        shapedRecipies.add(getEmeraldAxeRecipe());
        shapedRecipies.add(getEmeraldSwordRecipe());
        shapedRecipies.add(getObsidianAxeRecipe());
        shapedRecipies.add(getObsidianSwordRecipe());
    }

    public ArrayList<ShapedRecipe> getShapedRecipies() {
        return this.shapedRecipies;
    }


    public SmithingRecipe getChainmailRecipe() {
        ItemStack chainmail = Items.getChainMail();

        NamespacedKey chainmailKey = new NamespacedKey(this.plugin, "chainmail");

        SmithingRecipe chainmailRecipe = new SmithingRecipe(chainmailKey, chainmail, new RecipeChoice.MaterialChoice(Material.CHAIN), new RecipeChoice.MaterialChoice(Material.CHAIN));

        return chainmailRecipe;
    }

//    public ShapedRecipe getChainmailRecipe_old() {
//        ItemStack chainmail = Items.getChainMail();
//
//        NamespacedKey chainmailKey = new NamespacedKey(this.plugin, "chainmail");
//
//        ShapedRecipe chainmailRecipe = new ShapedRecipe(chainmailKey, chainmail);
//
//        chainmailRecipe.shape("CCC", "CCC", "CCC");
//        chainmailRecipe.setIngredient('C', Material.CHAIN);
//
//        return chainmailRecipe;
//    }

        public ShapedRecipe getChainmailBootsRecipe() {
            ItemStack cmBoots = new ItemStack(Material.CHAINMAIL_BOOTS);

            NamespacedKey cmBootsKey = new NamespacedKey(this.plugin, "chainmail_boots");

            ShapedRecipe cmBootsRecipe = new ShapedRecipe(cmBootsKey, cmBoots);
            cmBootsRecipe.shape("C C", "C C");
            cmBootsRecipe.setIngredient('C', new RecipeChoice.ExactChoice(Items.getChainMail()));

            return cmBootsRecipe;
        }

        public ShapedRecipe getChainmailLegsRecipe() {
            ItemStack cmLegs = new ItemStack(Material.CHAINMAIL_LEGGINGS);

            NamespacedKey cmLegsKey = new NamespacedKey(this.plugin, "chainmail_leggings");

            ShapedRecipe cmLegsRecipe = new ShapedRecipe(cmLegsKey, cmLegs);
            cmLegsRecipe.shape("CCC", "C C", "C C");
            cmLegsRecipe.setIngredient('C', new RecipeChoice.ExactChoice(Items.getChainMail()));

            return cmLegsRecipe;
        }

        public ShapedRecipe getChainmailChestRecipe() {
            ItemStack cmChest = new ItemStack(Material.CHAINMAIL_CHESTPLATE);

            NamespacedKey cmChestKey = new NamespacedKey(this.plugin, "chainmail_chestplate");

            ShapedRecipe cmChestRecipe = new ShapedRecipe(cmChestKey, cmChest);
            cmChestRecipe.shape("C C", "CCC", "CCC");
            cmChestRecipe.setIngredient('C', new RecipeChoice.ExactChoice(Items.getChainMail()));

            return cmChestRecipe;
        }

        public ShapedRecipe getChainmailHelmRecipe() {
            ItemStack cmHelm = new ItemStack(Material.CHAINMAIL_HELMET);

            NamespacedKey cmHelmKey = new NamespacedKey(this.plugin, "chainmail_helmet");

            ShapedRecipe cmHelmRecipe = new ShapedRecipe(cmHelmKey, cmHelm);
            cmHelmRecipe.shape("CCC", "C C");
            cmHelmRecipe.setIngredient('C', new RecipeChoice.ExactChoice(Items.getChainMail()));

            return cmHelmRecipe;
        }

        public ShapedRecipe getEmeraldSwordRecipe() {
            ItemStack esword = Items.getEmeraldSword();

            NamespacedKey esKey = new NamespacedKey(this.plugin, "emerald_sword");

            ShapedRecipe esRecipe = new ShapedRecipe(esKey, esword);
            esRecipe.shape("E", "E", "S");
            esRecipe.setIngredient('E', Material.EMERALD);
            esRecipe.setIngredient('S', Material.STICK);

            return esRecipe;
        }

        public ShapedRecipe getEmeraldAxeRecipe() {
            ItemStack eAxe = Items.getEmeraldAxe();

            NamespacedKey eaKey = new NamespacedKey(this.plugin, "emerald_axe");

            ShapedRecipe eaRecipe = new ShapedRecipe(eaKey, eAxe);
            eaRecipe.shape("EE", "SE", "S ");
            eaRecipe.setIngredient('E', Material.EMERALD);
            eaRecipe.setIngredient('S', Material.STICK);

            return eaRecipe;
        }

        public ShapedRecipe getObsidianSwordRecipe() {
            ItemStack osword = Items.getObsidianSword();

            NamespacedKey osKey = new NamespacedKey(this.plugin, "obsidian_sword");

            ShapedRecipe osRecipe = new ShapedRecipe(osKey, osword);
            osRecipe.shape("O", "O", "S");
            osRecipe.setIngredient('O', Material.OBSIDIAN);
            osRecipe.setIngredient('S', Material.STICK);

            return osRecipe;
        }

        public ShapedRecipe getObsidianAxeRecipe() {
            ItemStack oAxe = Items.getObsidianAxe();

            NamespacedKey oaKey = new NamespacedKey(this.plugin, "obsidian_axe");

            ShapedRecipe oaRecipe = new ShapedRecipe(oaKey, oAxe);
            oaRecipe.shape("OO", "SO", "S ");
            oaRecipe.setIngredient('O', Material.OBSIDIAN);
            oaRecipe.setIngredient('S', Material.STICK);

            return oaRecipe;
        }

        public FurnaceRecipe smeltGoldDust() {
            ItemStack gnugs = new ItemStack(Material.GOLD_NUGGET);
            NamespacedKey nskey = new NamespacedKey(this.plugin, "gold_nuggets_from_dust");
            FurnaceRecipe gdRecipe = new FurnaceRecipe(nskey, gnugs, new RecipeChoice.ExactChoice(Items.getGoldDust()), 0f, 20 );
            return gdRecipe;
        }

        public FurnaceRecipe smeltIronDust() {
            ItemStack inugs = new ItemStack(Material.IRON_NUGGET);
            NamespacedKey nskey = new NamespacedKey(this.plugin, "iron_nuggets_from_dust");
            FurnaceRecipe idRecipe = new FurnaceRecipe(nskey, inugs, new RecipeChoice.ExactChoice(Items.getIronDust()), 0f, 20 );
            return idRecipe;
        }



        public ShapedRecipe getCompCobbleRecipe(int level) {
            ItemStack compressedCobble = Items.getCompressedCobble(level);

            String levelKey = Items.getCompressedName(level).toLowerCase().replace(' ', '_') + "cobblestone";

            NamespacedKey compCobbleKey = new NamespacedKey(this.plugin, levelKey);

            ShapedRecipe compCobbleRecipe = new ShapedRecipe(compCobbleKey, compressedCobble);

            compCobbleRecipe.shape("CCC", "CCC", "CCC");

            if (level == 1) {
                compCobbleRecipe.setIngredient('C', Material.COBBLESTONE);
            } else {
                compCobbleRecipe.setIngredient('C', new RecipeChoice.ExactChoice(Items.getCompressedCobble(level - 1)));
            }

            return compCobbleRecipe;

        }


        public ShapelessRecipe getUncompressCobbleRecipe(int level) {
            ItemStack shortCobble = new ItemStack(Material.COBBLESTONE, 9);
            if (level > 1) {
                shortCobble = Items.getCompressedCobble(level - 1, 9);
            }

            NamespacedKey compCobbleKey = new NamespacedKey(this.plugin, "9_stack_cobblestone" + (level - 1));
            ShapelessRecipe shortCobbleStack = new ShapelessRecipe(compCobbleKey, shortCobble);
            shortCobbleStack.addIngredient(new RecipeChoice.ExactChoice(Items.getCompressedCobble(level)));
            return shortCobbleStack;
        }

}
