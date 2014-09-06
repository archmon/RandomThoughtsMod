package net.archmon.RandomThoughtsMod;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.archmon.RandomThoughtsMod.handler.ConfigurationHandler;
import net.archmon.RandomThoughtsMod.init.ModBlocks;
import net.archmon.RandomThoughtsMod.init.ModItems;
import net.archmon.RandomThoughtsMod.init.Recipes;
import net.archmon.RandomThoughtsMod.proxy.IProxy;
import net.archmon.RandomThoughtsMod.reference.Reference;
import net.archmon.RandomThoughtsMod.utility.LogHelper;
import net.minecraftforge.oredict.OreDictionary;

//control-b for go to scs code
@Mod(modid= Reference.MOD_ID, name=Reference.MOD_NAME, version=Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
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
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
        //register takes the @Subscribe events in it

        ModItems.init();//registered mod items.

        ModBlocks.init();//registered mod blocks.

        LogHelper.info("Pre Initialization Complete!");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        Recipes.init();//registers Recipes
        LogHelper.info("Initialization Complete!");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        /*for (String oreName : OreDictionary.getOreNames())
        {
            LogHelper.info(oreName);
            OreDictionary.getOres(oreName);
        }//just puts all of the names in log, sounds like debug thing.
        */

        LogHelper.info("Post Initialization Complete!");
    }

}