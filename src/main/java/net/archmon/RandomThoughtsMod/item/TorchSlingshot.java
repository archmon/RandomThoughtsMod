package net.archmon.RandomThoughtsMod.item;

import net.archmon.RandomThoughtsMod.utility.LogHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

/**
 * code by archmon
 */
public class TorchSlingshot extends Item_RTM{
	public TorchSlingshot(){
		super();
		setUnlocalizedName("TorchSlingshot");
		maxStackSize = 1;
	}

	/**
	 * Thanks MineMaarten for idea how to get pos and how to show chat messages
	 */
	@Override
	public boolean onItemUse(ItemStack IStack, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10){
		LogHelper.info("x=" + x + " y=" + y + " z=" + z);
		if(!world.isRemote) {
			player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.GREEN + "[GPS Tool] Set Coordinates to " + x + ", " + y + ", " + z + "."));
		}
		return true; // we don't want to use the item.

	}

	/**
	 * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
	 */
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player){

		return stack;
	}
}
