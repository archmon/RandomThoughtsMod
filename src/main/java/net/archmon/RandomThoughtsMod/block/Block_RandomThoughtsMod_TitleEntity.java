package net.archmon.RandomThoughtsMod.block;

import net.archmon.RandomThoughtsMod.creativetab.CreativeTab_RTM;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;

public abstract class Block_RandomThoughtsMod_TitleEntity extends BlockContainer{
	public Block_RandomThoughtsMod_TitleEntity(Material material){
		super(material);
		setCreativeTab(CreativeTab_RTM.RTM_TAB);
	}

	public Block_RandomThoughtsMod_TitleEntity(){
		this(Material.rock);
	}

}
