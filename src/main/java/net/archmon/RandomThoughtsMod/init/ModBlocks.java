package net.archmon.RandomThoughtsMod.init;

import net.archmon.RandomThoughtsMod.block.BlockCamoMine;
import net.archmon.RandomThoughtsMod.reference.Names;
import net.archmon.RandomThoughtsMod.reference.Reference;
import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * code in large thanks to MineMaarten and Pahimar
 */
@GameRegistry.ObjectHolder(Reference.MOD_ID)
//Makes it so my items stay my items
public class ModBlocks{

	//creating instance of block

	public static final Block camoMine = new BlockCamoMine();

	//register item
	public static void init(){
		GameRegistry.registerBlock(camoMine, Names.Blocks.CAMO_MINE);

	}
}

/**Removed block 6/29/15 2:50pm
 * //removed from instances of block
 * public static final Block_RTM flag = new BlockFlag();
 * 
 *  //removed from init()
 *  GameRegistry.registerBlock(flag, Names.Blocks.FLAG);
 */
