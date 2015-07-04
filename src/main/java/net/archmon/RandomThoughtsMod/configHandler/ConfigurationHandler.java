package net.archmon.RandomThoughtsMod.configHandler;

import java.io.File;

import net.archmon.RandomThoughtsMod.reference.Reference;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

/**
 * Code in Large thanks to Pahimar
 */
public class ConfigurationHandler{
	public static Configuration configuration;
	//var declare for configuration file
	public static float BlastFloatSize = 3.0f;

	public static void init(File configFile){
		//Create the configuration object from the given configuration file
		if(configuration == null) {
			configuration = new Configuration(configFile);
			loadConfigurations();
		}
	}

	@SubscribeEvent
	public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event){
		if(event.modID.equalsIgnoreCase(Reference.MOD_ID)) {
			//Resync configs
			loadConfigurations();
		}
	}

	//private static will be only callable within this class.
	private static void loadConfigurations(){
		BlastFloatSize = configuration.getFloat("BlastFloatSize", Configuration.CATEGORY_GENERAL, 3.0f, 0.5f, 20.0f, "This is the size of the blast strength. 3.0=creeper.");

		if(configuration.hasChanged()) {
			configuration.save();
		}
		//System.out.println("Configuration Test: " + testValue);  //test line for showing configValue in log.
	}
}

/*
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
 */
