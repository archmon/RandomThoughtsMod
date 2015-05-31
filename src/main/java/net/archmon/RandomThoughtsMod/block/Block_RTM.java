package net.archmon.RandomThoughtsMod.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
//import net.archmon.RandomThoughtsMod.creativetab.CreativeTab_RTM;
import net.archmon.RandomThoughtsMod.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

//Generic class like Item_RTM
public class Block_RTM extends Block
{
    //This is apparelling a constructor for the above class
    public Block_RTM(Material material)
    {
        super(material);
        //this.setCreativeTab(CreativeTab_RTM.RTM_TAB);
    }

    //This is also a constructor that takes no perimeters.
    public Block_RTM()
    {
        this(Material.rock);
    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format("tile.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }
    //same as item except block=tile

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        blockIcon = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
}
