package net.archmon.RandomThoughtsMod;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid="RandomThoughtsMod", name="Random Thoughts Mod", version="1.7.2-B0.1") //control-b for scs
public class RandomThoughtsMod
{
    @Mod.Instance("RandomThoughtsMod")
    public static RandomThoughtsMod instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)//preInit could be anything, but inside () is important.
    {

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {

    }

}