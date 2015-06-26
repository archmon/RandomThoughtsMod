package net.archmon.RandomThoughtsMod.thirdparty.waila;

import mcp.mobius.waila.api.IWailaRegistrar;
import net.archmon.RandomThoughtsMod.block.BlockCamoMine;

public class Waila{
	public static void onWailaCall(IWailaRegistrar registrar){
		registrar.registerStackProvider(new WailaCamoHandler(), BlockCamoMine.class);
		registrar.registerBodyProvider(new WailaCamoHandler(), BlockCamoMine.class);
		registrar.registerNBTProvider(new WailaCamoHandler(), BlockCamoMine.class);
	}
}
