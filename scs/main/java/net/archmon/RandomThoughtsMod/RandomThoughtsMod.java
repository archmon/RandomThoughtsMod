package net.archmon.RandomThoughtsMod;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.archmon.RandomThoughtsMod.handler.ConfigurationHandler;
import net.archmon.RandomThoughtsMod.proxy.IProxy;
import net.archmon.RandomThoughtsMod.reference.Reference;
import net.archmon.RandomThoughtsMod.utility.LogHelper;


@Mod(modid= Reference.MOD_ID, name=Reference.MOD_NAME, version=Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
//control-b for go to scs code
public class RandomThoughtsMod
{
    @Mod.Instance(Reference.MOD_ID)
    public static RandomThoughtsMod instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)//preInit could be anything, but inside () is important.
    {
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
        //puts time, client thread/info, modID, message.
        //Also, info can be replaced with teh different levels from log helper class
        //debug does not show in log, same with trace. Default set to log fatal, error, warn, off, and info.
        LogHelper.info("Pre Initialization Complete!");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        LogHelper.info("Initialization Complete!");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        LogHelper.info("Post Initialization Complete!");
    }

}