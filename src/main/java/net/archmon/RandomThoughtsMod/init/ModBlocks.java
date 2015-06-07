package net.archmon.RandomThoughtsMod.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.archmon.RandomThoughtsMod.block.BlockCamoMine;
import net.archmon.RandomThoughtsMod.block.BlockFlag;
import net.archmon.RandomThoughtsMod.block.Block_RTM;
import net.archmon.RandomThoughtsMod.reference.Reference;
import net.archmon.RandomThoughtsMod.utility.Names;
import net.minecraft.block.Block;

@GameRegistry.ObjectHolder(Reference.MOD_ID)//Makes it so my items stay my items
public class ModBlocks
{

    //creating instance of block
    public static final Block_RTM flag = new BlockFlag();
    public static final Block camoMine = new BlockCamoMine();

    //register item
    public static void init()
    {
        GameRegistry.registerBlock(flag, Names.Blocks.FLAG);
        GameRegistry.registerBlock(camoMine, Names.Blocks.CAMO_MINE);
        
    }
}
