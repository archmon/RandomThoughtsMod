package net.archmon.RandomThoughtsMod.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.archmon.RandomThoughtsMod.item.ItemMapleLeaf;
import net.archmon.RandomThoughtsMod.item.Item_RTM;
import net.archmon.RandomThoughtsMod.reference.Reference;

//class for registering the mod items.
@GameRegistry.ObjectHolder(Reference.MOD_ID)//Makes it so my items stay my items
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
