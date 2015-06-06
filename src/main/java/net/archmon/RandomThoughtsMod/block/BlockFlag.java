package net.archmon.RandomThoughtsMod.block;

import net.archmon.RandomThoughtsMod.init.ModBlocks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class BlockFlag extends Block_RTM
{
    public BlockFlag()
    {
        super();
        this.setBlockName("flag");
        this.setBlockTextureName("flag");
    }
    
    /**
     * Called upon block activation (right click on the block.)
     */
    /*@Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityPlayer, int side, float hitX, float hitY, float hitZ)
    {
        if (world.isAirBlock(x, y, z)){//allows for equivalent air blocks from mods
    	//if (world.getBlock(x,y+1,z)==Blocks.air){
    	//world.setBlock(x, y+1, z, Blocks.tnt);//do not do the new command for the blocks.
        world.setBlock(x, y+1, z, ModBlocks.flag);//will replace dirt/grass if not inside the if
        //can do absolute cords as well.
        }//end if, if makes it so will only replace if target block is air.
    	return true;//true makes it to where you have to shift-click to place block, useful for when you have gui.
    }*/
}
