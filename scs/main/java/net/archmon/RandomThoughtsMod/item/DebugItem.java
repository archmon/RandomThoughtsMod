package net.archmon.RandomThoughtsMod.item;


public class DebugItem extends Item_RTM
{
    public DebugItem ()
    {
        super();
        //pahimar says that having this class and this public constructor and calling super is all you need to get an item.
        //note, no name/texture/does nothing
        this.setUnlocalizedName("Debug");  //makes it show on item randomthoughtsmod.mapleLeaf
        //don't forget to go to en_US.lang and ModItems.java
        this.maxStackSize = 1;
        //makes it to where each item is a full stack.
        //this.setCreativeTab(CreativeTab_RTM.RTM_TAB);  //moved to generic class
    }
}