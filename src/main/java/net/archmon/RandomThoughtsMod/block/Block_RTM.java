package net.archmon.RandomThoughtsMod.block;

import net.archmon.RandomThoughtsMod.creativetab.CreativeTab_RTM;
import net.archmon.RandomThoughtsMod.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Code in large thanks to Phaimar
 */
//Generic class like Item_RTM
public class Block_RTM extends Block{
	public Block_RTM(Material material){
		super(material);
		setCreativeTab(CreativeTab_RTM.RTM_TAB);
	}

	public Block_RTM(){
		this(Material.rock);
	}

	@Override
	public String getUnlocalizedName(){
		return String.format("tile.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister){
		blockIcon = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(getUnlocalizedName())));
	}

	protected String getUnwrappedUnlocalizedName(String unlocalizedName){
		return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
	}
}
