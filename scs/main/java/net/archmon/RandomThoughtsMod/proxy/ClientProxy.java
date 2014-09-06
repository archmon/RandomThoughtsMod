package net.archmon.RandomThoughtsMod.proxy;

import cpw.mods.fml.client.registry.ClientRegistry;
import net.archmon.RandomThoughtsMod.client.settings.Keybindings;

//extends means it is child of CommonProxy
public class ClientProxy extends CommonProxy
{
    @Override
    public void registerKeyBindings()
    {
        ClientRegistry.registerKeyBinding(Keybindings.charge);
        ClientRegistry.registerKeyBinding(Keybindings.release);
    }
}