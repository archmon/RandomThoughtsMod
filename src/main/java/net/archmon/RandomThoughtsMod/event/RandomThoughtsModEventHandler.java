package net.archmon.RandomThoughtsMod.event;


public class RandomThoughtsModEventHandler{

}

/* Example code on how to code events
 * Removed 6/27/15 10:47am
 * @mod start prep
 
   /**
	 * Using the LivingDropsEvent. Note that this is from  net.minecraftforge.event, 
	 * so to make this method be called, this class needs to be registered at 
	 * MinecraftForge.EVENT_BUS.register(new RandomThoughtsModEventHandler()).
	 * @param event
	 /
	@SubscribeEvent
	public void addPigDrops(LivingDropsEvent event){
		if(event.entityLiving instanceof EntityPig && event.entityLiving.getRNG().nextInt(3) == 0) {
			ItemStack stack = new ItemStack(ModBlocks.flag);
			event.drops.add(new EntityItem(event.entityLiving.worldObj, event.entityLiving.posX, event.entityLiving.posY, event.entityLiving.posZ, stack));
		}
	}

	/**
	 * Using the PlayerTickEvent. Note that this is from cpw.mods.fml.common.gameevent, 
	 * so to make this method be called, this class needs to be registered at 
	 * FMLCommonHandler.instance().bus().register(new RandomThoughtsModEventHandler()).
	 * @param event
	 /
	@SubscribeEvent
	public void onPlayerTick(PlayerTickEvent event){
		if(event.side == Side.SERVER && event.phase == TickEvent.Phase.END) {
			//LogHelper.info("Player " + event.player.getCommandSenderName() + " ticked" + event.phase);
			List<Entity> entities = event.player.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, AxisAlignedBB.getBoundingBox(event.player.posX - 3, event.player.posY - 3, event.player.posZ - 3, event.player.posX + 3, event.player.posY + 3, event.player.posZ + 3));
			for(Entity entity : entities) {
				if(entity != event.player) {
					//entity.setVelocity(0, 1, 0); //This will crash when run on a dedicated server, because Entity#setVelocity is marked with @SideOnly(Side.CLIENT), and therefore stripped from a dedicated server instance.
					entity.motionX = 0;//The solution is to do this.
					entity.motionY = 1;
					entity.motionZ = 0;
				}
			}
		}
	}
 */
