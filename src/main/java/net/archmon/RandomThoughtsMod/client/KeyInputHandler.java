package net.archmon.RandomThoughtsMod.client;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import net.archmon.RandomThoughtsMod.utility.LogHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

public class KeyInputHandler{
    private Keybindings getPressedKey(){
        for(Keybindings key : Keybindings.values()) {
            if(key.isPressed()) return key;
        }
        return null;
    }

    @SubscribeEvent
    public void handleKeyInputEvent(InputEvent.KeyInputEvent event){
        Keybindings key = getPressedKey();
        if(key != null) {
            switch(key){
                case EXPLODE:
                    LogHelper.info("Boom!");
                    EntityPlayer player = Minecraft.getMinecraft().thePlayer;
                    player.worldObj.createExplosion(player, player.posX, player.posY-10, player.posZ, 3.0F, true);
                    break;
            }
        }
    }
}