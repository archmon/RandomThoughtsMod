package net.archmon.RandomThoughtsMod.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes{
	public static void init(){
		//shaped recipe
		//s=item
		//GameRegistry.addRecipe(new ItemStack(ModItems.mapleLeaf)," s ","sss"," s ", 's', new ItemStack(Items.stick));
		//GameRegistry.addRecipe(new ItemStack(ModBlocks.flag), new ItemStack(ModItems.mapleLeaf), new ItemStack(ModItems.mapleLeaf));

		//"stickWood"=ore dictionary
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.mapleLeaf), " s ", "sss", " s ", 's', "stickWood"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModBlocks.flag), "stickWood", new ItemStack(ModItems.mapleLeaf)));
	}
}
