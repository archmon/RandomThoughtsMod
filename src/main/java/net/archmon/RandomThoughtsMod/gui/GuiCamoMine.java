package net.archmon.RandomThoughtsMod.gui;

import net.archmon.RandomThoughtsMod.inventory.ContainerCamoMine;
import net.archmon.RandomThoughtsMod.network.MessageHandlerGuiButtonPress;
import net.archmon.RandomThoughtsMod.network.NetworkHandler;
import net.archmon.RandomThoughtsMod.tileentity.TileEntityCamoMine;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;

public class GuiCamoMine extends Gui_RandomThoughtsMod{
	private final TileEntityCamoMine te;

	public GuiCamoMine(InventoryPlayer playerInventory, TileEntityCamoMine te){
		super(new ContainerCamoMine(playerInventory, te), "camoMine", te);
		this.te = te;
	}

	@Override
	public void initGui(){
		super.initGui();
		GuiButton button = new GuiButton(0, guiLeft + 5, guiTop + 37, 40, 20, I18n.format("gui.randomthoughtsmod.camoMine.button.reset"));
		buttonList.add(button);
	}

	@Override
	protected void actionPerformed(GuiButton button){
		if(button.id == 0) NetworkHandler.sendToServer(new MessageHandlerGuiButtonPress(te, 0));
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY){
		super.drawGuiContainerForegroundLayer(mouseX, mouseY);
		fontRendererObj.drawString(I18n.format("gui.randomthoughtsmod.camoMine.timer", te.getTimer()), 5, 25, 0xFF000000);
		//0x tells java that value=hex.|0xAARRGGBB
		//AA digits=how transparent
		//R=red,g=green,b=blue
	}
}
