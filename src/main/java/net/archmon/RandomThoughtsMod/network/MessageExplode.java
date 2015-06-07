package net.archmon.RandomThoughtsMod.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageExplode extends MessageBase<MessageExplode> {

	private float explosionSize;
	public MessageExplode(){}
	//MineMaarten says game will crash without empty constructor because server doesn't know it needs to give it a float
	public MessageExplode(float explosionSize){
		this.explosionSize=explosionSize;
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		explosionSize= buf.readFloat();
		//MineMaarten says for every info you add, it needs to be in order
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeFloat(explosionSize);
		//MineMaarten says for every info you add, it needs to be in order
	}

	@Override
	public void handleClientSide(MessageExplode message, EntityPlayer player) {
		
	}

	@Override
	public void handleServerSide(MessageExplode message, EntityPlayer player) {
		player.worldObj.createExplosion(player, player.posX, player.posY-10, player.posZ, message.explosionSize, true);
		//3.0F=as big as creeper and true=break blocks
		
	}

}
