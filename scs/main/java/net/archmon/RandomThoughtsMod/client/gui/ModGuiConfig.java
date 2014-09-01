package net.archmon.RandomThoughtsMod.client.gui;

import net.archmon.RandomThoughtsMod.RandomThoughtsMod;
import net.archmon.RandomThoughtsMod.handler.ConfigurationHandler;
import net.archmon.RandomThoughtsMod.reference.Reference;
import cpw.mods.fml.client.config.GuiConfig;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;


public class ModGuiConfig extends GuiConfig
{

    public ModGuiConfig(GuiScreen guiScreen)
    {
        super (guiScreen,
                new ConfigElement(ConfigurationHandler.configuration.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(),
                Reference.MOD_ID,
                false,
                false,
                GuiConfig.getAbridgedConfigPath(ConfigurationHandler.configuration.toString()));
    }//not sure how it all works, but allows for gui configuration of files.

}
