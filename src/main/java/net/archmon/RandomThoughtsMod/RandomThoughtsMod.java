package net.archmon.RandomThoughtsMod;

import net.archmon.RandomThoughtsMod.event.RandomThoughtsModEventHandler;
import net.archmon.RandomThoughtsMod.init.ModBlocks;
import net.archmon.RandomThoughtsMod.init.ModItems;
import net.archmon.RandomThoughtsMod.init.ModTileEntities;
import net.archmon.RandomThoughtsMod.init.Recipes;
import net.archmon.RandomThoughtsMod.network.DescriptionHandler;
import net.archmon.RandomThoughtsMod.network.NetworkHandler;
import net.archmon.RandomThoughtsMod.proxy.CommonProxy;
import net.archmon.RandomThoughtsMod.reference.Reference;
import net.archmon.RandomThoughtsMod.tileentity.TileEntityCamoMine;
import net.archmon.RandomThoughtsMod.utility.LogHelper;
import net.archmon.RandomThoughtsMod.world.gen.WorldGeneratorFlag;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.event.FMLInterModComms.IMCEvent;
import cpw.mods.fml.common.event.FMLInterModComms.IMCMessage;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

//F3 eclipse=open declaration
@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class RandomThoughtsMod{

	@Mod.Instance(Reference.MOD_ID)
	public static RandomThoughtsMod instance;

	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event){
		ModItems.init();//registered mod items.
		ModBlocks.init();//registered mod blocks.
		ModTileEntities.init();
		proxy.preInit();
		GameRegistry.registerWorldGenerator(new WorldGeneratorFlag(), 0);//number=priority generator has.
		NetworkHandler.init();
		DescriptionHandler.init();
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
		MinecraftForge.EVENT_BUS.register(new RandomThoughtsModEventHandler());//For registering events from the net.miencraftforge.event package.
		FMLCommonHandler.instance().bus().register(new RandomThoughtsModEventHandler());//minecraft event
		//FMLInterModComms.sendMessage(Reference.MOD_ID, "camoMineBlacklist", new ItemStack(Blocks.hopper));
		FMLInterModComms.sendMessage("Waila", "register", "net.archmon.RandomThoughtsMod.thirdparty.waila.Waila.onWailaCall");
		//ConfigurationHandler.init(event.getSuggestedConfigurationFile());

		//puts time, client thread/info, modID, message.
		//Also, info can be replaced with the different levels from log helper class
		//debug does not show in log, same with trace. Default set to log fatal, error, warn, off, and info.

		LogHelper.info("Pre Initialization Complete!");
	}//end preInit

	@Mod.EventHandler
	public void init(FMLInitializationEvent event){
		Recipes.init();//registers Recipes
		proxy.init();

		LogHelper.info("Initialization Complete!");
	}//end init

	@Mod.EventHandler
	public void onIMCMessages(IMCEvent event){
		for(IMCMessage message : event.getMessages()) {
			if(message.key.equalsIgnoreCase("camoMineBlacklist")) {
				if(message.isItemStackMessage()) {
					ItemStack blacklistedStack = message.getItemStackValue();
					if(blacklistedStack.getItem() != null) {
						TileEntityCamoMine.camouflageBlacklist.add(blacklistedStack);
						LogHelper.info(String.format("Mod %s added %s to be blacklisted as camouflage for the Camo Mine", message.getSender(), blacklistedStack.toString()));
					} else {
						throw new IllegalStateException(String.format("ItemStack tried to be used in registry by the mod %s has a null item.", message.getSender()));
					}
				} else {
					LogHelper.warn(String.format("Mod %s sent a non-ItemStack message, where an ItemStack was expected.", message.getSender()));
				}
			} else {
				LogHelper.warn(String.format("Mod %s used an invalid IMC key: %s", message.getSender(), message.key));
			}
		}
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event){
		proxy.postInit();

		LogHelper.info("Post Initialization Complete!");
	}//end postInit

}//end class file

/* Removed code from PostInit 6/6/15 7:36pm
   for (String oreName : OreDictionary.getOreNames())
        {
            LogHelper.info(oreName);
            OreDictionary.getOres(oreName);
        }//just puts all of the names in log, sounds like debug thing.
        
 */
