package net.archmon.RandomThoughtsMod.gui;

import net.archmon.RandomThoughtsMod.inventory.ContainerCamoMine;
import net.archmon.RandomThoughtsMod.tileentity.TileEntityCamoMine;
import net.minecraft.entity.player.InventoryPlayer;

public class GuiCamoMine extends Gui_RandomThoughtsMod{

	public GuiCamoMine(InventoryPlayer playerInventory, TileEntityCamoMine te){
		super(new ContainerCamoMine(playerInventory, te), "camoMine", te);
	}

}
