package in.webya.PerpetualCraft;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class LedBlock extends Block {
	public enum EnumType implements IStringSerializable {

		LED(0, "led");

		private int ID;
		private String name;

		private EnumType(int ID, String name) {
			this.ID = ID;
			this.name = name;
		}

		@Override
		public String getName() {
			return name;
		}

		public int getID() {
			return ID;
		}

		@Override
		public String toString() {
			return getName();
		}
	}

	public static final PropertyEnum TYPE = PropertyEnum.create("type", LedBlock.EnumType.class);

	public LedBlock() {
		super(Material.rock);
		setCreativeTab(CreativeTabs.tabBlock);
		setUnlocalizedName("LED");
		setHardness(1.5F);
		setResistance(1.0F);
		setStepSound(Block.soundTypeStone);
		disableStats();
		setLightOpacity(1);
		setLightLevel(1.0F);
		this.setRegistryName("LED");
		this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, EnumType.LED));
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return getDefaultState().withProperty(TYPE, EnumType.LED);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		EnumType type = (EnumType) state.getValue(TYPE);
		return type.getID();
	}

	@Override
	public int damageDropped(IBlockState state) {
		return getMetaFromState(state);
	}

	@Override
	protected BlockState createBlockState() {
		return new BlockState(this, new IProperty[] { TYPE });
	}
	// @Override
	// public String getSpecialName(ItemStack stack) {
	// return "LED";
	// }
	// @Override
	// public ItemStack getPickBlock(MovingObjectPosition target, World world,
	// BlockPos pos) {
	// return new ItemStack(Item.getItemFromBlock(this), 1,
	// this.getMetaFromState(world.getBlockState(pos)));
	// }
	// @Override
	// public void getSubBlocks(Item itemIn, CreativeTabs tab, List list) {
	// list.add(new ItemStack(itemIn, 1, 0)); //Meta 0
	// }
}
