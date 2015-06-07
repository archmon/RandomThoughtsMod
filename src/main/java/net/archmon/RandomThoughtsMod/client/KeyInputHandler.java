package net.archmon.RandomThoughtsMod.client;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import net.archmon.RandomThoughtsMod.network.MessageExplode;
import net.archmon.RandomThoughtsMod.network.NetworkHandler;
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
                    NetworkHandler.sendToServer(new MessageExplode(3));
                    break;
                case EXPLODE_BIG:
                	NetworkHandler.sendToServer(new MessageExplode(30));
                	break;
                
                
            }
        }
    }
}
/* Rubish client side only code 6/7/15 7:39am
 EntityPlayer player = Minecraft.getMinecraft().thePlayer;
player.worldObj.createExplosion(player, player.posX, player.posY-10, player.posZ, 3.0F, true);
 */