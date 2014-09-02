package net.archmon.RandomThoughtsMod.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.archmon.RandomThoughtsMod.item.ItemMapleLeaf;
import net.archmon.RandomThoughtsMod.item.Item_RTM;
//class for registering the mod items.
public class ModItems
{
    public static final Item_RTM mapleLeaf = new ItemMapleLeaf();

    public static void init()
    {
        GameRegistry.registerItem(mapleLeaf, "mapleLeaf");
        //In game give command
        //give ForgeDevName RandomThoughtsMod:mapleLeaf
    }
}
