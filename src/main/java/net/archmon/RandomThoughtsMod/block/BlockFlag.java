package net.archmon.RandomThoughtsMod.block;

import java.util.Random;

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
        this.setTickRandomly(true);
    }
    
    
    @Override
    public void updateTick(World world, int x, int y, int z, Random random){
    	//world.scheduleBlockUpdate(p_147464_1_, p_147464_2_, p_147464_3_, p_147464_4_, p_147464_5_);//sound like repeater appearlntly
    	world.playSoundEffect(x, y, z, "mob.enderdragon.wings", 2.0F, random.nextFloat()+0.5F);
    }
    
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, 
    		float hitX, float hitY, float hitZ){
		//world.playSoundEffect(x, y, z, "RandomThoughtsMod:flagFlap.ogg", 1.0F, player.getRNG().nextFloat()+0.5F);
		//1.0F=default sound level for the 5 slot, 6slot=pitch
    	if(!world.isRemote){
    		world.createExplosion(player, x, y, z, 3, true);
    		//above if makes createExplosion only on the server side
    		/*FMLCommonHandler.instance().getEffectiveSide() == Side.SERVER
    		 * above statement can be used if no access to world is avaliable
    		 */
    	}
    	return true;
    	
    }
}
/*old code 6/6/15 2:40pm (Watching minemaarten video "part4 sounds" at the time
 * code for making blocks appear when clicked
 *
 **
     * Called upon block activation (right click on the block.)
     *
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityPlayer, int side, float hitX, float hitY, float hitZ)
    {
        if (world.isAirBlock(x, y, z)){//allows for equivalent air blocks from mods
    	//if (world.getBlock(x,y+1,z)==Blocks.air){
    	//world.setBlock(x, y+1, z, Blocks.tnt);//do not do the new command for the blocks.
        world.setBlock(x, y+1, z, ModBlocks.flag);//will replace dirt/grass if not inside the if
        //can do absolute cords as well.
        }//end if, if makes it so will only replace if target block is air.
    	return true;//true makes it to where you have to shift-click to place block, useful for when you have gui.
    }
 */
