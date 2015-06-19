package net.archmon.RandomThoughtsMod.proxy;

import net.minecraft.entity.player.EntityPlayer;

public abstract class CommonProxy
//abstract means this class does not have to implement all of the methods in parent class.
//implements uses the interface IProxy
{
	public abstract void preInit();
	public abstract void init();
	public abstract void postInit();
	public abstract EntityPlayer getClientPlayer();
}
