package net.archmon.RandomThoughtsMod.entity.item;

import static net.minecraftforge.common.util.ForgeDirection.EAST;
import static net.minecraftforge.common.util.ForgeDirection.NORTH;
import static net.minecraftforge.common.util.ForgeDirection.SOUTH;
import static net.minecraftforge.common.util.ForgeDirection.WEST;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;

public class EntityTorchSlingshot extends EntityThrowable{

	public EntityTorchSlingshot(World world, EntityLivingBase livingbase){
		super(world, livingbase);
	}

	/**
	 * Called when this EntityThrowable hits a block or entity.
	 */
	@Override
	protected void onImpact(MovingObjectPosition direction){
		if(direction.entityHit != null) {
			direction.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, getThrower()), 0.0F);
		}

		/*for(int i = 0; i < 32; ++i) {
			worldObj.spawnParticle("portal", posX, posY, posZ, rand.nextGaussian(), 0.0D, rand.nextGaussian());
			//Not sure if there is a missing texture for portal or not, I assume so.
		}*/

		if(!worldObj.isRemote) {
			if(getThrower() != null && getThrower() instanceof EntityPlayerMP) {
				EntityPlayerMP player = (EntityPlayerMP)getThrower();

				if(player.playerNetServerHandler.func_147362_b().isChannelOpen() && player.worldObj == worldObj) {
					EnderTeleportEvent event = new EnderTeleportEvent(player, posX, posY, posZ, 5.0F);
					if(!MinecraftForge.EVENT_BUS.post(event)) {
						int x = (int)Math.round(event.targetX);
						int y = (int)Math.round(event.targetY);
						int z = (int)Math.round(event.targetZ);

						/*
						 * Thanks MineMaarten for idea how to get show chat messages
						 */
						//player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.RED + "x=" + posX + " y= " + posY + " z= " + posZ));
						player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.GREEN + "x=" + x + " y= " + y + " z= " + z));
						if(worldObj.isAirBlock(x, y, z)) {
							if(canPlaceBlockAt(worldObj, x, y, z)) {
								worldObj.setBlock(x, y, z, Blocks.torch, 0, 2);
							} else {
								worldObj.setBlock(x, y, z, Blocks.glowstone, 0, 2);
							}
							//worldObj.setBlock(x, y, z, Blocks.glowstone, 0, 2);
							player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.BLUE + "Normal"));
						} else {
							ItemStack torch = new ItemStack(Blocks.torch);
							//dropBlockAsItem(worldObj, x, y, z, torch);
							worldObj.setBlock(x, y, z, Blocks.glowstone, 0, 2);
							player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.BLUE + "failed"));
						}
					}
				}
			}

			setDead();
		}
	}

	/**
	 * Checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z
	 */
	public boolean canPlaceBlockAt(World world, int x, int y, int z){
		return world.isSideSolid(x - 1, y, z, EAST, true) || world.isSideSolid(x + 1, y, z, WEST, true) || world.isSideSolid(x, y, z - 1, SOUTH, true) || world.isSideSolid(x, y, z + 1, NORTH, true) || func_150107_m(world, x, y - 1, z);
	}

	private boolean func_150107_m(World world, int x, int y, int z){
		if(World.doesBlockHaveSolidTopSurface(world, x, y, z)) {
			return true;
		} else {
			Block block = world.getBlock(x, y, z);
			return block.canPlaceTorchOnTop(world, x, y, z);
		}
	}

	/**
	 * Drops the specified block items
	 */
	protected void dropBlockAsItem(World world, int x, int y, int z, ItemStack stack){
		if(!world.isRemote && world.getGameRules().getGameRuleBooleanValue("doTileDrops") && !world.restoringBlockSnapshots) // do not drop items while restoring blockstates, prevents item dupe
		{
			float f = 0.7F;
			double d0 = world.rand.nextFloat() * f + (1.0F - f) * 0.5D;
			double d1 = world.rand.nextFloat() * f + (1.0F - f) * 0.5D;
			double d2 = world.rand.nextFloat() * f + (1.0F - f) * 0.5D;
			EntityItem entityitem = new EntityItem(world, x + d0, y + d1, z + d2, stack);
			entityitem.delayBeforeCanPickup = 10;
			world.spawnEntityInWorld(entityitem);
		}
	}
}