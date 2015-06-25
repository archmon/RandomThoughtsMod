package net.archmon.RandomThoughtsMod.network;

import io.netty.buffer.ByteBuf;
import net.archmon.RandomThoughtsMod.tileentity.TileEntity_RandomThoughtsMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;

public class MessageHandlerGuiButtonPress extends MessageBase<MessageHandlerGuiButtonPress>{
	private int x, y, z, id;

	public MessageHandlerGuiButtonPress(){}

	public MessageHandlerGuiButtonPress(TileEntity_RandomThoughtsMod te, int id){
		x = te.xCoord;
		y = te.yCoord;
		z = te.zCoord;
		this.id = id;
	}

	@Override
	public void fromBytes(ByteBuf buf){
		x = buf.readInt();
		y = buf.readInt();
		z = buf.readInt();
		id = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf){
		buf.writeInt(x);
		buf.writeInt(y);
		buf.writeInt(z);
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
