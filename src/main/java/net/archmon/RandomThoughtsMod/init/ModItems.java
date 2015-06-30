package net.archmon.RandomThoughtsMod.init;

import net.archmon.RandomThoughtsMod.item.DebugItem;
import net.archmon.RandomThoughtsMod.item.Item_RTM;
import net.archmon.RandomThoughtsMod.item.TorchSlingshot;
import net.archmon.RandomThoughtsMod.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * code in large thanks to Pahimar
 */
//class for registering the mod items.
@GameRegistry.ObjectHolder(Reference.MOD_ID)
//Makes it so my items stay my items
public class ModItems{

	public static final Item_RTM Debug = new DebugItem();
	public static final Item_RTM TorchSlingshot = new TorchSlingshot();

	public static void init(){

		//In game give command
		//give ForgeDevName RandomThoughtsMod:mapleLeaf
		GameRegistry.registerItem(Debug, "Debug");
		GameRegistry.registerItem(TorchSlingshot, "TorchSlingshot");
	}
}

/*removed 6/29/15 3:16pm
 * preparing for modstart
 * removed from modItems
 * public static final Item_RTM mapleLeaf = new ItemMapleLeaf();
 * 
 * removed fron init()
 * GameRegistry.registerItem(mapleLeaf, "mapleLeaf");
 */
