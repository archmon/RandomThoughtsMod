package net.archmon.RandomThoughtsMod.creativetab;

import net.archmon.RandomThoughtsMod.init.ModItems;
import net.archmon.RandomThoughtsMod.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTab_RTM
{
    public static final CreativeTabs RTM_TAB = new CreativeTabs(Reference.MOD_ID.toLowerCase())
    {
        @Override
        public Item getTabIconItem()
        {
            return ModItems.Debug;
        }//Sets Icon for tab


    };
}
