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
public class DebugItem extends Item_RTM{
	public DebugItem(){
		super();
		//pahimar says that having this class and this public constructor and calling super is all you need to get an item.
		//note, no name/texture/does nothing
		setUnlocalizedName("Debug"); //makes it show on item randomthoughtsmod.mapleLeaf
		//don't forget to go to en_US.lang and ModItems.java
		maxStackSize = 1;
		//makes it to where each item is a full stack.
	}

	@Override
	public boolean onItemUse(ItemStack IStack, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10){
		int lightLevel;
		lightLevel = world.getBlockLightValue(x, y, z);

		LogHelper.info(lightLevel);
		if(!world.isRemote) {
			player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.GREEN + "Light level at " + x + ", " + y + ", " + z + " is " + lightLevel));
		}
		return true; // we don't want to use the item.

	}
}
