package in.webya.PerpetualCraft;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Ash extends Item {
	
	public Ash(){
		super();
		setCreativeTab(CreativeTabs.tabMaterials);
		setUnlocalizedName("Ash");
		setMaxStackSize(64);
	}
	
	@Override
	public String getItemStackDisplayName(ItemStack itemstack) {
		return "Ash";
	}
	
}