package in.webya.PerpetualCraft;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;

public class Excalibur extends ItemSword
{
	// 武器用素材：オリハルコンの追加
	public static ToolMaterial Orichalcum  = EnumHelper.addToolMaterial("ORICHALCUM", 3, 3000, 20.0F, 20.0F, 30);
	
	public Excalibur()
	{
		super(Orichalcum);
		
		// TODO : カスタムタブを追加しそこに設定する
        setCreativeTab(CreativeTabs.tabCombat);
        setUnlocalizedName("Excalibur");
        setFull3D();
        setMaxStackSize(1);
	}
	
    @Override
    public String getItemStackDisplayName(ItemStack itemstack){
        return "Excalibur";
    }
}
