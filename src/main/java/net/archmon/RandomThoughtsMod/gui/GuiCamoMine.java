package net.archmon.RandomThoughtsMod.gui;

import net.archmon.RandomThoughtsMod.inventory.ContainerCamoMine;
import net.archmon.RandomThoughtsMod.tileentity.TileEntityCamoMine;
import net.minecraft.entity.player.InventoryPlayer;

public class GuiCamoMine extends Gui_RandomThoughtsMod{

	public GuiCamoMine(InventoryPlayer playerInventory, TileEntityCamoMine te){
		super(new ContainerCamoMine(playerInventory, te));
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_){

	}
}
