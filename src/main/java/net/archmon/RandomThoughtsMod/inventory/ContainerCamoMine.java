package net.archmon.RandomThoughtsMod.inventory;

import net.archmon.RandomThoughtsMod.tileentity.TileEntityCamoMine;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerCamoMine extends Container_RandomThoughtsMod{
	private final TileEntityCamoMine te;

	public ContainerCamoMine(InventoryPlayer playerInventory, TileEntityCamoMine te){
		addSlotToContainer(new Slot(te, 0, 50, 50));
		addSlotToContainer(new Slot(te, 1, 50, 14));
		addSlotToContainer(new Slot(te, 2, 50, 32));
		addSlotToContainer(new Slot(te, 3, 32, 32));
		addSlotToContainer(new Slot(te, 4, 68, 32));
		addSlotToContainer(new Slot(te, 5, 73, 9));

		addPlayerSlots(playerInventory, 8, 84);
		this.te = te;
	}

	@Override
	public boolean canInteractWith(EntityPlayer player){
		return te.isUseableByPlayer(player);
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slot){
		return null;
	}
}
