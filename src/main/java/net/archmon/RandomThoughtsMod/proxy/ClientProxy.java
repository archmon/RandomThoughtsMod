package net.archmon.RandomThoughtsMod.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

public class ClientProxy extends CommonProxy{

	@Override
	public void preInit(){
		//registerKeybinds();
	}

	/*private void registerKeybinds(){//removed from preInit above 6/27/15 11:06am
		FMLCommonHandler.instance().bus().register(new KeyInputHandler());
		for(Keybindings key : Keybindings.values()) {
			ClientRegistry.registerKeyBinding(key.getKeybind());
		}
	}*/

	@Override
	public void init(){
		// TODO Auto-generated method stub

	}

	@Override
	public void postInit(){
		// TODO Auto-generated method stub

	}

	@Override
	public EntityPlayer getClientPlayer(){
		return Minecraft.getMinecraft().thePlayer;
	}

}