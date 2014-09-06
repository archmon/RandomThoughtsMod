package net.archmon.RandomThoughtsMod.block;

//import net.minecraft.block.Block;

public class superTorch extends Block_RTM
{
    public superTorch()
    {
        super();
        this.setBlockName("Super Torch");
        this.setBlockTextureName("Super Torch");
        this.setHardness(0.0F);
        this.setLightLevel(0.9375F);

    }
   /*@Override
    public Block setLightLevel(float LightLevel)
    {
        this.lightValue = (int)(18.0F * LightLevel);
        return this;
    }*///not working
}
