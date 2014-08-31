package net.archmon.RandomThoughtsMod.configuration;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigurationHandler
{
    public static void init(File configFile)
    {
        //Create the configuration object from teh given configuration file
        Configuration configuration = new Configuration(configFile);
        boolean configValue = false; //used to printLn at end.

        try
        {
            //Load the configuration file
            configuration.load();
            //read in properties from configuration file
            /*boolean*/ configValue = configuration.get(Configuration.CATEGORY_GENERAL, "configValue", true, "This is an example config value").getBoolean(true);
            //CATEGORY_GENERAL=
            // #############
            // #general
            // #############
            //B: in file indicates boolean value
            //configValue="configValue="
            //true=default value
            //Stuff in "" = detail statement
            //configuration.get expects a value at end of () with .getBoolean(true)
            //Configuration.CATEGORY_GENERAL can be swapped with any string like "ForgeCraft"

          }
        catch (Exception e)
        {
            //Log the exception
        }
        finally
        {
            //Save the configuration
            configuration.save();
        }

        System.out.println("Configuration Test: " + configValue);  //test line for showing configValue in log.
    }
}
