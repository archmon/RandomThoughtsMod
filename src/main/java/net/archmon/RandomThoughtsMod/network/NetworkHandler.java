package net.archmon.RandomThoughtsMod.network;

import net.archmon.RandomThoughtsMod.reference.Reference;
import net.minecraft.entity.player.EntityPlayerMP;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.NetworkRegistry.TargetPoint;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class NetworkHandler{
	private static SimpleNetworkWrapper INSTANCE;

	public static void init(){
		INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MOD_ID);

		INSTANCE.registerMessage(MessageExplode.class, MessageExplode.class, 0, Side.SERVER);
		//discriminator aka third slot =id of packet|Side.SERVER is side that receives packet 
		INSTANCE.registerMessage(MessageHandlerGuiButtonPress.class, MessageHandlerGuiButtonPress.class, 1, Side.SERVER);
	}

	public static void sendToServer(IMessage message){
		INSTANCE.sendToServer(message);
	}

	public static void sendTo(IMessage message, EntityPlayerMP player){
		INSTANCE.sendTo(message, player);
	}

	public static void sendToAllAround(IMessage message, TargetPoint point){
		INSTANCE.sendToAllAround(message, point);
	}

	public static void sendToAll(IMessage message){
		INSTANCE.sendToAll(message);
	}

	public static void sendToDimension(IMessage message, int dimensionId){
		INSTANCE.sendToDimension(message, dimensionId);
	}
}
