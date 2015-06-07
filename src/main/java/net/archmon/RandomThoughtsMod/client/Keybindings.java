package net.archmon.RandomThoughtsMod.client;

import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;

public enum Keybindings{

    EXPLODE("key.RandomThoughtsMod.explode", Keyboard.KEY_G),
    EXPLODE_BIG("key.RandomThoughtsMod.explodeBig", Keyboard.KEY_H);

    private final KeyBinding keybinding;

    private Keybindings(String keyName, int defaultKeyCode){
        keybinding = new KeyBinding(keyName, defaultKeyCode, "key.categories.RandomThoughtsMod");
    }

    public KeyBinding getKeybind(){
        return keybinding;
    }

    public boolean isPressed(){
        return keybinding.isPressed();
    }

}