package net.archmon.RandomThoughtsMod.handler;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.archmon.RandomThoughtsMod.reference.Reference;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigurationHandler
{
    public static Configuration configuration;
    //var declare for configuration file
    public static boolean testValue = false;
    public static void init(File configFile)
    {
        //Create the configuration object from teh given configuration file
        if (configuration == null)
        {
            configuration = new Configuration(configFile);
            loadConfigurations();
        }
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if (event.modID.equalsIgnoreCase(Reference.MOD_ID))
        {
            //Resync configs
            loadConfigurations();
        }
    }

    //private static will be only callable within this class.
    private static void loadConfigurations()
    {
        testValue = configuration.getBoolean("configValue", Configuration.CATEGORY_GENERAL, false, "This is an example configuration value");
//        //CATEGORY_GENERAL=
//        // #############
//        // #general
//        // #############
//        //B: in file indicates boolean value
//        //configValue="configValue="
//        //true=default value
//        //Stuff in "" = detail statement
//        //configuration.get expects a value at end of () with .getBoolean(true)
//        //Configuration.CATEGORY_GENERAL can be swapped with any string like "ForgeCraft"
        if (configuration.hasChanged())
        {
            configuration.save();
        }
        //System.out.println("Configuration Test: " + testValue);  //test line for showing configValue in log.
    }
}

