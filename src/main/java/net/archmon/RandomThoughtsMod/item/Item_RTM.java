package net.archmon.RandomThoughtsMod.item;

import net.archmon.RandomThoughtsMod.creativetab.CreativeTab_RTM;
import net.archmon.RandomThoughtsMod.reference.Reference;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * code in large thanks to Pahimar
 */
//generic class for all my items
public class Item_RTM extends Item{
	public Item_RTM(){
		super();
		setCreativeTab(CreativeTab_RTM.RTM_TAB);
	}

	@Override
	public String getUnlocalizedName(){
		return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}//set item name for single item

	@Override
	public String getUnlocalizedName(ItemStack itemStack){
		return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}//sets item name for stack

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister){
		itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	}//loads textures
		//@sideOnly(Side.CLIENT) says to program code that this is only on the client

	protected String getUnwrappedUnlocalizedName(String unlocalizedName){
		return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
	}//used in this class only
}
