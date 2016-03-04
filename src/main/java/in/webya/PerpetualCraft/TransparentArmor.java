package in.webya.PerpetualCraft;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class TransparentArmor extends ItemArmor {
	public String textureName;

	public TransparentArmor(String unlocalizedName, ArmorMaterial material, String textureName, int type) {

		super(material, 0, type);
		setCreativeTab(CreativeTabs.tabCombat);
		setUnlocalizedName(unlocalizedName);
		setMaxStackSize(1);
		this.textureName = textureName;
	}

	@Override
	public String getItemStackDisplayName(ItemStack itemstack) {
		String armorName = itemstack.getUnlocalizedName();
		String RegexArmor = "TransparentArmor";
		String RegexLegg = "TransparentLeggings";
		String RegexHelm = "TransparentHelm";
		String RegexBoots = "TransparentBoots";

		Pattern ArmorPat = Pattern.compile(RegexArmor);
		Pattern LeggPat = Pattern.compile(RegexLegg);
		Pattern HelmPat = Pattern.compile(RegexHelm);
		Pattern BootsPat = Pattern.compile(RegexBoots);

		Matcher Armor = ArmorPat.matcher(armorName);
		Matcher Helm = HelmPat.matcher(armorName);
		Matcher Legg = LeggPat.matcher(armorName);
		Matcher Boots = BootsPat.matcher(armorName);

		if (Armor.find())
			return "TransparentArmor";
		if (Boots.find())
			return "TransparentBoots";
		if (Helm.find())
			return "TransparentHelm";
		if (Legg.find())
			return "TransparentLeggings";

		return "UnKnown";
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		return "perpetualcraft:textures/armor/" + this.textureName + "_" + (this.armorType == 2 ? "2" : "1") + ".png";
	}
}
