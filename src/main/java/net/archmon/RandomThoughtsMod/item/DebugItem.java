package net.archmon.RandomThoughtsMod.item;

/**
 * code by archmon
 */
public class DebugItem extends Item_RTM{
	public DebugItem(){
		super();
		//pahimar says that having this class and this public constructor and calling super is all you need to get an item.
		//note, no name/texture/does nothing
		setUnlocalizedName("Debug"); //makes it show on item randomthoughtsmod.mapleLeaf
		//don't forget to go to en_US.lang and ModItems.java
		maxStackSize = 1;
		//makes it to where each item is a full stack.
	}
}
