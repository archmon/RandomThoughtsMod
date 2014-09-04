package net.archmon.RandomThoughtsMod.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.archmon.RandomThoughtsMod.block.BlockFlag;
import net.archmon.RandomThoughtsMod.block.Block_RTM;
import net.archmon.RandomThoughtsMod.reference.Reference;

@GameRegistry.ObjectHolder(Reference.MOD_ID)//Makes it so my items stay my items
public class ModBlocks
{
    //creating instance of item
    public static final Block_RTM flag = new BlockFlag();

    //register item
    public static void init()
    {
        GameRegistry.registerBlock(flag, "flag");
    }
}
