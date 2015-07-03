package net.archmon.RandomThoughtsMod.item;

import net.archmon.RandomThoughtsMod.entity.item.EntityTorchSlingshot;
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

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player){

		//--stack.stackSize;
		world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

		if(!world.isRemote) {
			world.spawnEntityInWorld(new EntityTorchSlingshot(world, player));
		}
		LogHelper.info(player);
		return stack;

	}
}
