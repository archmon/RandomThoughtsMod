package net.archmon.RandomThoughtsMod.event;

import net.archmon.RandomThoughtsMod.init.ModBlocks;
import net.archmon.RandomThoughtsMod.utility.LogHelper;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;
import cpw.mods.fml.relauncher.Side;

public class RandomThoughtsModEventHandler{
	@SubscribeEvent
	public void addPigDrops(LivingDropsEvent event){
		if(event.entityLiving instanceof EntityPig && event.entityLiving.getRNG().nextInt(3) == 0) {
			ItemStack stack = new ItemStack(ModBlocks.flag);
			event.drops.add(new EntityItem(event.entityLiving.worldObj, event.entityLiving.posX, event.entityLiving.posY, event.entityLiving.posZ, stack));
		}
	}

	@SubscribeEvent
	public void onPlayerTick(PlayerTickEvent event){
		if(event.side == Side.SERVER && event.phase == TickEvent.Phase.END) {
			LogHelper.info("Player " + event.player.getCommandSenderName() + " ticked" + event.phase);
		}
	}
}
