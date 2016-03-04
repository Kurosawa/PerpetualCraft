package in.webya.PerpetualCraft;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.event.terraingen.TerrainGen;

@Mod(modid = PerpetualCraft.MOD_ID, 
name = PerpetualCraft.MOD_NAME, 
version = PerpetualCraft.MOD_VERSION, 
dependencies = PerpetualCraft.MOD_DEPENDENCIES,
acceptedMinecraftVersions = PerpetualCraft.MOD_ACCEPTED_MC_VERSIONS,
useMetadata = true)
public class PerpetualCraft
{
    public static final String MOD_ID = "perpetualcraft";
    public static final String MOD_NAME = "PerpetualCraft";
    public static final String MOD_VERSION = "0.0.1";
    public static final String MOD_DEPENDENCIES = "required-after:Forge@[1.8-11.14.0.1239,)";
    public static final String MOD_ACCEPTED_MC_VERSIONS = "[1.8,1.8.9]";
    
    public static Block ledBlock;
    public static Item redPotato;
    public static Item grassFertilizer;
    
    public static Item excalibur; 
    public static Item transparentHelmet;
    public static Item transparentArmor;
    public static Item transparentLeggings;
    public static Item transparentBoots;
    
    public static ArmorMaterial TRANSPARENT_MATERIAL = EnumHelper.addArmorMaterial("TRANSPARENT","TRANSPARENT", 128, new int[] { 3, 8, 6, 3 }, 128);
    
    @EventHandler 
    public void preInit(FMLPreInitializationEvent event)
    {
    	MinecraftForge.ORE_GEN_BUS.register(this);
    	
    	ledBlock = new LedBlock();
    	redPotato = new RedPotato();
    	grassFertilizer = new GrassFertilizer();
    	
    	excalibur = new Excalibur();
    	
	
        GameRegistry.registerBlock(ledBlock, LedItemBlock.class, "ledblock");
        GameRegistry.registerItem(redPotato, "redpotato");
        GameRegistry.registerItem(grassFertilizer, "grassfertilizer");
        GameRegistry.registerItem(excalibur, "excalibur");
        
        GameRegistry.registerItem(transparentHelmet = new TransparentArmor("TransparentHelm", TRANSPARENT_MATERIAL, "transparent", 0), "TransparentHelm");
        GameRegistry.registerItem(transparentArmor = new TransparentArmor("TransparentArmor", TRANSPARENT_MATERIAL, "transparent", 1), "TransparentArmor");
        GameRegistry.registerItem(transparentLeggings = new TransparentArmor("TransparentLeggings", TRANSPARENT_MATERIAL, "transparent", 2), "TransparentLeggings");
        GameRegistry.registerItem(transparentBoots = new TransparentArmor("TransparentBoots", TRANSPARENT_MATERIAL, "transparent", 3), "TransparentBoots");
        
        
        if (event.getSide().isClient())
        {

            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ledBlock), 0, new ModelResourceLocation(MOD_ID + ":" + "ledblock", "inventory"));
            ModelLoader.setCustomModelResourceLocation(excalibur, 0, new ModelResourceLocation(MOD_ID + ":" + "excalibur", "inventory"));
            ModelLoader.setCustomModelResourceLocation(redPotato, 0, new ModelResourceLocation(MOD_ID + ":" + "redpotato", "inventory"));
            ModelLoader.setCustomModelResourceLocation(grassFertilizer, 0, new ModelResourceLocation(MOD_ID + ":" + "grassfertilizer", "inventory"));
 
            ModelLoader.setCustomModelResourceLocation(transparentHelmet, 0, new ModelResourceLocation(MOD_ID + ":" + "transparenthelmet", "inventory"));
            ModelLoader.setCustomModelResourceLocation(transparentArmor, 0, new ModelResourceLocation(MOD_ID + ":" + "transparentarmor", "inventory"));
            ModelLoader.setCustomModelResourceLocation(transparentLeggings, 0, new ModelResourceLocation(MOD_ID + ":" + "transparentleggings", "inventory"));
            ModelLoader.setCustomModelResourceLocation(transparentBoots, 0, new ModelResourceLocation(MOD_ID + ":" + "transparentboots", "inventory"));
        }
    }
    
    
	@SubscribeEvent
	public void generateOrePre(OreGenEvent.Pre event)
	{
		WorldGenerator chrowa3BlockGen = new WorldGenMinable(ledBlock.getDefaultState(), 30);
		
		if(TerrainGen.generateOre(event.world, event.rand, chrowa3BlockGen, event.pos, OreGenEvent.GenerateMinable.EventType.CUSTOM))
			genStandardOre(event.world, event.pos, 20, chrowa3BlockGen, 0, 96, event.rand);
	}
	
	protected void genStandardOre(World world, BlockPos pos, int size, WorldGenerator generator, int minY, int maxY, Random rnd){
		int l;
 
		if(maxY < minY)
		{
			l = minY;
			minY = maxY;
			maxY = l;
		}
		else if(maxY == minY)
		{
			if(minY < 255)
				++maxY;
			else
				--minY;
		}
 
		for(l = 0; l < size; ++l)
		{
			BlockPos blockpos = pos.add(rnd.nextInt(16), rnd.nextInt(maxY - minY) + minY, rnd.nextInt(16));
			generator.generate(world, rnd, blockpos);
		}
	}
	
    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        GameRegistry.addRecipe(new ItemStack(grassFertilizer,16),
                "###",
                "###",
                "###",
                '#', Blocks.tallgrass
        );
        
        GameRegistry.addRecipe(new ItemStack(excalibur),
        		"BBB",
        		"DSD",
        		"DBD",
        		'B', Items.book,
        		'D', Items.diamond,
        		'S', Items.diamond_sword
        );
        GameRegistry.addRecipe(new ItemStack(redPotato,8),
        		"   ",
        		"RPR",
        		"   ",
        		'R', Items.redstone,
        		'P', Items.potato
        );
    }
}
