package net.archmon.RandomThoughtsMod.gui;

import net.archmon.RandomThoughtsMod.inventory.ContainerCamoMine;
import net.archmon.RandomThoughtsMod.network.MessageHandleTextUpdate;
import net.archmon.RandomThoughtsMod.network.MessageHandlerGuiButtonPress;
import net.archmon.RandomThoughtsMod.network.NetworkHandler;
import net.archmon.RandomThoughtsMod.tileentity.TileEntityCamoMine;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;

import org.lwjgl.opengl.GL11;

public class GuiCamoMine extends Gui_RandomThoughtsMod{
	private final TileEntityCamoMine te;
	private GuiButton resetButton;
	private GuiTextField textField;

	public GuiCamoMine(InventoryPlayer playerInventory, TileEntityCamoMine te){
		super(new ContainerCamoMine(playerInventory, te), "camoMine", te);
		this.te = te;
	}

	@Override
	public void initGui(){
		super.initGui();
		resetButton = new GuiButton(0, guiLeft + 5, guiTop + 37, 40, 20, "");
		buttonList.add(resetButton);

		textField = new GuiTextField(fontRendererObj, guiLeft + 100, guiTop + 65, 70, 12);
		textField.setMaxStringLength(40);
		textField.setText(te.getTarget());
	}

	@Override
	public void onTextfieldUpdate(int id){
		if(id == 0) textField.setText(te.getTarget());
	}

	/**
	 * Fired when a key is typed. This is the equivalent of KeyListener.keyTyped(KeyEvent e).
	 */
	@Override
	protected void keyTyped(char chr, int keyCode){
		if(textField.textboxKeyTyped(chr, keyCode)) {
			NetworkHandler.sendToServer(new MessageHandleTextUpdate(te, 0, textField.getText()));
		} else {
			super.keyTyped(chr, keyCode);
		}
	}

	/**
	 * Called when the mouse is clicked.
	 */
	@Override
	protected void mouseClicked(int mouseX, int mouseY, int button){
		super.mouseClicked(mouseX, mouseY, button);
		textField.mouseClicked(mouseX, mouseY, button);
	}

	/**
	 * Draws the screen and all the components in it.
	 */
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTick){
		super.drawScreen(mouseX, mouseY, partialTick);
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_BLEND);
		textField.drawTextBox();
	}

	@Override
	protected void actionPerformed(GuiButton button){
		if(button.id == 0) NetworkHandler.sendToServer(new MessageHandlerGuiButtonPress(te, 0));
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY){
		super.drawGuiContainerForegroundLayer(mouseX, mouseY);
		fontRendererObj.drawString(I18n.format("gui.randomthoughtsmod.camoMine.target", te.getTimer()), 120, 55, 0xFF444444);
		if(te.getTimer() >= 0) {
			fontRendererObj.drawString(I18n.format("gui.randomthoughtsmod.camoMine.timer", te.getTimer()), 5, 25, 0xFF000000);
		}
		//0x tells java that value=hex.|0xAARRGGBB
		//AA digits=how transparent
		//R=red,g=green,b=blue
	}

	/**
	 * Called from the main game loop to update the screen.
	 */
	@Override
	public void updateScreen(){
		super.updateScreen();
		resetButton.displayString = I18n.format("gui.randomthoughtsmod.camoMine.button." + (te.getTimer() == -1 ? "restart" : "reset"));
	}
}
