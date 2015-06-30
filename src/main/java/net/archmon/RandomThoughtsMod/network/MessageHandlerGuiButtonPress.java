package net.archmon.RandomThoughtsMod.network;

import io.netty.buffer.ByteBuf;
import net.archmon.RandomThoughtsMod.tileentity.TileEntity_RandomThoughtsMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;

/**
 * code in large thanks to MineMaarten
 */
public class MessageHandlerGuiButtonPress extends MessageXYZ<MessageHandlerGuiButtonPress>{
	private int id;

	public MessageHandlerGuiButtonPress(){}

	public MessageHandlerGuiButtonPress(TileEntity_RandomThoughtsMod te, int id){
		super(te);
		this.id = id;
	}

	@Override
	public void fromBytes(ByteBuf buf){
		super.fromBytes(buf);
		id = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf){
		super.toBytes(buf);
		buf.writeInt(id);
	}

	@Override
	public void handleClientSide(MessageHandlerGuiButtonPress message, EntityPlayer player){

	}

	@Override
	public void handleServerSide(MessageHandlerGuiButtonPress message, EntityPlayer player){
		TileEntity te = player.worldObj.getTileEntity(message.x, message.y, message.z);
		if(te instanceof TileEntity_RandomThoughtsMod) {
			((TileEntity_RandomThoughtsMod)te).onGuiButtonPress(message.id);
		}
	}

}
