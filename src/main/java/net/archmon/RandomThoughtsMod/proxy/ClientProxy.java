package net.archmon.RandomThoughtsMod.proxy;

import net.archmon.RandomThoughtsMod.client.KeyInputHandler;
import net.archmon.RandomThoughtsMod.client.Keybindings;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.FMLCommonHandler;

public class ClientProxy extends CommonProxy{

	@Override
	public void preInit(){
		registerKeybinds();
	}

	private void registerKeybinds(){
		FMLCommonHandler.instance().bus().register(new KeyInputHandler());
		for(Keybindings key : Keybindings.values()) {
			ClientRegistry.registerKeyBinding(key.getKeybind());
		}
	}

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