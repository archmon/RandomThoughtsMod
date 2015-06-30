package net.archmon.RandomThoughtsMod.proxy;

import net.minecraft.entity.player.EntityPlayer;

/**
 * code in large thanks to Pahimar, updated by MineMaarten
 */
public abstract class CommonProxy{
	public abstract void preInit();

	public abstract void init();

	public abstract void postInit();

	public abstract EntityPlayer getClientPlayer();
}
