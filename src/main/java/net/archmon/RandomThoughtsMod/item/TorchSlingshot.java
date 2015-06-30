package net.archmon.RandomThoughtsMod.item;

import net.archmon.RandomThoughtsMod.utility.LogHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
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
	* Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
	*/
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player){
		LogHelper.info(player);
		return stack;
	}
}
