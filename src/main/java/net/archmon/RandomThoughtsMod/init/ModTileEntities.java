package net.archmon.RandomThoughtsMod.init;

import net.archmon.RandomThoughtsMod.reference.Names;
import net.archmon.RandomThoughtsMod.tileentity.TileEntityCamoMine;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * code in large thanks to MineMaarten
 */
public class ModTileEntities{
	public static void init(){
		GameRegistry.registerTileEntity(TileEntityCamoMine.class, Names.TileEntities.CAMO_MINE);
	}
}
