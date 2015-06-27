package net.archmon.RandomThoughtsMod.world.gen;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGeneratorFlag implements IWorldGenerator{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider){
		int x = chunkX * 16;
		int z = chunkZ * 16;
		switch(world.provider.dimensionId){
			case 0:
				generateSurface(world, x, z, random);
				break;
			case -1:
				generateNether(world, x, z, random);
				break;
			case 1:
				generateEnd(world, x, z, random);
				break;
			default:
				generateSurface(world, x, z, random);
		}
	}

	private void generateEnd(World world, int x, int z, Random random){

	}

	private void generateNether(World world, int x, int z, Random random){

	}

	private void generateSurface(World world, int x, int z, Random random){

	}

}

/* Example code for world structures gen
 * Removed 6/27/15 10:208am 
 * @Mod start prep
 * 
 * private void generateSurface(World world, int x, int z, Random random){
		if(random.nextInt(10) == 0) {
			int randX = x + random.nextInt(16);
			int randZ = z + random.nextInt(16);
			int randY = world.getHeightValue(randX, randZ);

			if(randY <= world.getHeight() - 10 && world.getBiomeGenForCoords(randX, randZ) != BiomeGenBase.river && world.getBiomeGenForCoords(randX, randZ) != BiomeGenBase.ocean) {
				Block block = world.getBlock(randX, randY - 1, randZ);
				//if(block != Blocks.water && block != Blocks.lava && block != Blocks.flowing_water && block != Blocks.flowing_lava) {
				if(!(block instanceof BlockLiquid || FluidRegistry.lookupFluidForBlock(block) != null)) {
					generateFlag(world, randX, randY, randZ);
				}
			}
		}

	}

	private void generateFlag(World world, int x, int y, int z){
		for(int i = 0; i < 10; i++) {
			world.setBlock(x, y + i, z, Blocks.fence, 0, 2);
		}
		for(int dx = 0; dx < 3; dx++) {
			for(int dy = 0; dy < 3; dy++) {
				world.setBlock(x + 1 + dx, y + 10 - 3 + dy, z, ModBlocks.flag, 0, 2);
			}
		}
	}
 */

//------------------------------------------------------------------

/* Example code for world ore gen
 * Removed 6/27/15 10:18am 
 * @Mod start prep
 * 
 * private final WorldGenMinable flagGen = new WorldGenMinable(ModBlocks.flag, 32);//oreGen
   private void generateSurface(World world, int x, int z, Random random){

		for(int i = 0; i < 5; i++) {
			int randX = x + random.nextInt(16);
			int randY = 20 + random.nextInt(40);
			int randZ = z + random.nextInt(16);
			flagGen.generate(world, random, randX, randY, randZ);
		}
	}
 */

//----------------------------------------------

/*Old code 6/6/15 2:07pm     [outdated]
  @Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) 
	{
		//this is the method that is called each time a new chunk generates
		//random=controlled by world seed
		//world.setBlock(chunkX*16, 30, chunkZ*16, ModBlocks.flag, 0, 2);//0=meta-data, 2=what happens to the block
		
		int dimensionID = world.provider.dimensionId;
		if(dimensionID!= 1 && dimensionID !=-1)
		{
			if(random.nextInt(10)==0)
			{
				//runs only 1-10 chunks
				int x= chunkX*16 + random.nextInt(16);
				int z= chunkZ*16 + random.nextInt(16);
				int y=30;
				generateFlag(world, x,y,z);
			}
		}
	}

	private void generateFlag(World world, int x, int y, int z)
	{
		for(int i=0; i<10; i++)
		{
			world.setBlock(x, y+1, z, Blocks.fence, 0,2);
		}
		for(int dx=0; dx<3; dx++)
		{
			for(int dy=0; dy<3; dy++)
			{
			world.setBlock(x+1+dx, y+7+dy, z, ModBlocks.flag, 0,2);
			}
		}
	}
 */
