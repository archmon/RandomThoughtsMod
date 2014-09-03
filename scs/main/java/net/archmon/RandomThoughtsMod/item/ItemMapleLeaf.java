package net.archmon.RandomThoughtsMod.item;
//example item class for item Maple Leaf
public class ItemMapleLeaf extends Item_RTM
{
    public ItemMapleLeaf ()
    {
        super();
        //pahimar says that having this class and this public constructor and calling super is all you need to get an item.
        //note, no name/texture/does nothing
        this.setUnlocalizedName("mapleLeaf");  //makes it show on item randomthoughtsmod.mapleLeaf
        //don't forget to go to en_US.lang and ModItems.java
    }


}
