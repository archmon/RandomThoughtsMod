package net.archmon.RandomThoughtsMod.proxy;

public abstract class CommonProxy
//abstract means this class does not have to implement all of the methods in parent class.
//implements uses the interface IProxy
{
	public abstract void preInit();
	public abstract void init();
	public abstract void postInit();
}