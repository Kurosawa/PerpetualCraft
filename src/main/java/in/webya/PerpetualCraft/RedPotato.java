package in.webya.PerpetualCraft;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

public class RedPotato extends ItemFood
{
	public RedPotato()
	{
		super(30, 30, false);
		setCreativeTab(CreativeTabs.tabFood);
		setUnlocalizedName("RedPotato");
		setMaxStackSize(64);
	}
	
    @Override
    public String getItemStackDisplayName(ItemStack itemstack){
        return "RedPotato";
    }
}
