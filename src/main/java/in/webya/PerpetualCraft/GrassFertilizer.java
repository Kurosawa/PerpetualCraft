package in.webya.PerpetualCraft;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.item.ItemDye;

public class GrassFertilizer extends Item {
	public GrassFertilizer() {
		super();
		setCreativeTab(CreativeTabs.tabMaterials);
		setUnlocalizedName("GrassFertilizer");
		setMaxStackSize(64);
	}

	@Override
	public String getItemStackDisplayName(ItemStack itemstack) {
		return "GrassFertilizer";
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side,
			float hitX, float hitY, float hitZ) {
		int blockId = Block.getIdFromBlock(worldIn.getBlockState(pos).getBlock());
		if (blockId == 2 || blockId == 6) {
			ItemDye.applyBonemeal(stack, worldIn, pos, playerIn);
			ItemDye.spawnBonemealParticles(worldIn, pos.add(0, 1, 0), 15);
			return true;
		}
		return false;
	}
}
