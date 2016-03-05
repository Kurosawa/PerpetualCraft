package in.webya.PerpetualCraft;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemShears;
import net.minecraft.item.ItemStack;

public class StoneShears extends ItemShears {
	
	public StoneShears(){
		super();
        this.setMaxStackSize(1);
        this.setMaxDamage(5000);
        this.setCreativeTab(CreativeTabs.tabTools);
	}
	@Override
	public String getItemStackDisplayName(ItemStack itemstack) {
		return "StoneShaears";
	}
}
