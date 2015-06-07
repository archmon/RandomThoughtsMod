package net.archmon.RandomThoughtsMod.block;

import net.archmon.RandomThoughtsMod.reference.Reference;
import net.archmon.RandomThoughtsMod.tileentity.TileEntityCamoMine;
import net.archmon.RandomThoughtsMod.utility.Names;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockCamoMine extends Block_RandomThoughtsMod_TitleEntity {

	public BlockCamoMine(){
		this.setBlockName(Names.Blocks.CAMO_MINE);
        this.setBlockTextureName(Reference.MOD_ID_LOWER + ":" + Names.Blocks.CAMO_MINE);
	}
	
	
	
	
	@Override
	public TileEntity createNewTileEntity(World world, int metadata) {
		return new TileEntityCamoMine();
	}

}
