package net.archmon.RandomThoughtsMod.init;

import net.archmon.RandomThoughtsMod.tileentity.TileEntityCamoMine;
import net.archmon.RandomThoughtsMod.utility.Names;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModTileEntities{
	public static void init(){
		GameRegistry.registerTileEntity(TileEntityCamoMine.class, Names.TileEntities.CAMO_MINE);
	}
}
