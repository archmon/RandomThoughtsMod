package net.archmon.RandomThoughtsMod.world.gen;

import java.util.Random;

import net.archmon.RandomThoughtsMod.init.ModBlocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGeneratorFlag implements IWorldGenerator{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		//this is the method that is called each time a new chunk generates
		//random=controlled by world seed
		world.setBlock(chunkX*16, 30, chunkZ*16, ModBlocks.flag, 0, 2);//0=meta-data, 2=what happens to the block
		
	}

}
