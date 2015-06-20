package net.archmon.RandomThoughtsMod.tileentity;

import io.netty.buffer.ByteBuf;

import java.util.Arrays;
import java.util.List;

import cpw.mods.fml.common.network.ByteBufUtils;
import net.archmon.RandomThoughtsMod.init.ModBlocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class TileEntityCamoMine extends TileEntity_RandomThoughtsMod implements ISidedInventory{
	private int timer=60;//20 ticks in 1 sec
	private ItemStack[] camoStacks = new ItemStack[6];
	
	public void updateEntity(){
		if(timer>0) timer--;
		if(timer ==0 && !worldObj.isRemote){
			List<Entity> entities = worldObj.getEntitiesWithinAABB(EntityPlayer.class, 
					AxisAlignedBB.getBoundingBox(xCoord-1, yCoord-1, zCoord-1, xCoord +2, yCoord +2, zCoord +2));
			if(entities.size()>0){
				worldObj.createExplosion(null, xCoord+0.5, yCoord+0.5, zCoord+0.5, 3.0F, true);
			}
		}
	}
	
	public void setCamouflage(ItemStack stack, int side){
		setInventorySlotContents(side,stack);
	}
	
	public ItemStack getCamouflage(int side){
		return getStackInSlot(side);
	}
	
	public void writeToPacket(ByteBuf buf){
		for(ItemStack stack : camoStacks)
			ByteBufUtils.writeItemStack(buf, stack);
	}
	
	public void readFromPacket(ByteBuf buf){
		for(int i=0; i<camoStacks.length; i++)
			camoStacks[i] = ByteBufUtils.readItemStack(buf);
		worldObj.markBlockRangeForRenderUpdate(xCoord, yCoord, zCoord, xCoord, yCoord, zCoord);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound tag){
		super.readFromNBT(tag);
		timer = tag.getInteger("timer");
		
		camoStacks = new ItemStack[6];
		NBTTagList camoStackTag =tag.getTagList("camoStacks", 10);
		
		for(int i=0;i<camoStackTag.tagCount(); i++){
			NBTTagCompound t= camoStackTag.getCompoundTagAt(i);
			int index = t.getByte("index");
			if(index >=0 && index<camoStacks.length){
				camoStacks[index]=ItemStack.loadItemStackFromNBT(t);
			}
		}
	}
	
	@Override
	public void writeToNBT(NBTTagCompound tag){
		super.writeToNBT(tag);
		tag.setInteger("timer", timer);
		
		NBTTagList camoStackTag = new NBTTagList();
		for(int i=0; i<camoStacks.length; i++){
			ItemStack stack= camoStacks[i];
			if(stack !=null){
				NBTTagCompound t = new NBTTagCompound();
				stack.writeToNBT(t);
				t.setByte("index", (byte) i);
				camoStackTag.appendTag(t);
			}
		}
		tag.setTag("camoStacks", camoStackTag);
	}
	
	//--------------------------------------------------------------------------------------------
	/**
     * Returns the number of slots in the inventory.
     */
    public int getSizeInventory()
    {
        return camoStacks.length;
    }

    /**
     * Returns the stack in slot i
     */
    public ItemStack getStackInSlot(int slot)
    {
        return this.camoStacks[slot];
    }

    /**
     * Removes from an inventory slot (first arg) up to a specified number (second arg) of items and returns them in a
     * new stack.
     */
    public ItemStack decrStackSize(int slot, int decreaseAmount){
        if (this.camoStacks[slot] != null){
            ItemStack itemstack;

            if (this.camoStacks[slot].stackSize <= decreaseAmount){
                itemstack = this.camoStacks[slot];
                setInventorySlotContents(slot, null);
                this.markDirty();
                return itemstack;
            }else{
                itemstack = this.camoStacks[slot].splitStack(decreaseAmount);

                if (this.camoStacks[slot].stackSize == 0){
                	setInventorySlotContents(slot, null);
                }

                this.markDirty();
                return itemstack;
            }
        }
        else{
            return null;
        }
    }

    /**
     * When some containers are closed they call this on each slot, then drop whatever it returns as an EntityItem -
     * like when you close a workbench GUI.
     */
    public ItemStack getStackInSlotOnClosing(int slot)
    {
        if (this.camoStacks[slot] != null)
        {
            ItemStack itemstack = this.camoStacks[slot];
            this.camoStacks[slot] = null;
            return itemstack;
        }
        else
        {
            return null;
        }
    }

    /**
     * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
     */
    public void setInventorySlotContents(int slot, ItemStack stack)
    {
        this.camoStacks[slot] = stack;

        if (stack != null && stack.stackSize > this.getInventoryStackLimit())
        {
            stack.stackSize = this.getInventoryStackLimit();
        }

        this.markDirty();
        worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
    }

    /**
     * Returns the name of the inventory
     */
    public String getInventoryName()
    {
        return ModBlocks.camoMine.getUnlocalizedName()+".name";
    }

    /**
     * Returns if the inventory is named
     */
    public boolean hasCustomInventoryName()
    {
        return false;
    }

    /**
     * Returns the maximum stack size for a inventory slot.
     */
    public int getInventoryStackLimit()
    {
        return 1;
    }

    /**
     * Do not make give this method the name canInteractWith because it clashes with Container
     */
    public boolean isUseableByPlayer(EntityPlayer player)
    {
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : player.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
    }

    public void openInventory() {}

    public void closeInventory() {}

    /**
     * Returns true if automation is allowed to insert the given stack (ignoring stack size) into the given slot.
     */
    public boolean isItemValidForSlot(int slot, ItemStack stack)
    {
        return stack != null && stack.getItem() instanceof ItemBlock;
    }

    //--------------ISidedInventory--------------------------------
    
	@Override
	public int[] getAccessibleSlotsFromSide(int side) {
		return new int[]{side};
	}

	@Override
	public boolean canInsertItem(int slot, ItemStack stack, int side) {
		return isItemValidForSlot(slot,stack);
	}

	@Override
	public boolean canExtractItem(int p_102008_1_, ItemStack p_102008_2_, int p_102008_3_) {
		return true;
	}
}
