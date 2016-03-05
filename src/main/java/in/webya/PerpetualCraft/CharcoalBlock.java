package in.webya.PerpetualCraft;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class CharcoalBlock extends Block {

	public CharcoalBlock() {
		super(Material.rock);
		setCreativeTab(CreativeTabs.tabBlock);
		setUnlocalizedName("CharcoalBlock");
		setRegistryName("CharcoalBlock");
		setHardness(1.5F);
		setResistance(1.0F);
		setStepSound(Block.soundTypeStone);
		disableStats();
		setLightOpacity(1);
	}
}
