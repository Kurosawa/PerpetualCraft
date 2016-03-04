package in.webya.PerpetualCraft;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class LedItemBlock extends ItemBlock
{
    public LedItemBlock(Block block) {
        super(block);
//        if (!(block instanceof IMetaBlockName))
//        {
//            throw new IllegalArgumentException(String.format("The given Block %s is not an instance of ISpecialBlockName!", block.getUnlocalizedName()));
//        }
        //this.setMaxDamage(0);
        //this.setHasSubtypes(false);
        setUnlocalizedName("LED");
        setRegistryName("LED");
    }
//    public int getMetadata(int damage)
//    {
//        return damage;
//    }
//    @Override
//    public String getUnlocalizedName(ItemStack stack)
//    {
//    	return "LED";
//    	//return super.getUnlocalizedName(stack) + "." + ((IMetaBlockName)this.block).getSpecialName(stack);
//    }
}
