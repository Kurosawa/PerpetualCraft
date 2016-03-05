package in.webya.PerpetualCraft;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
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
import net.minecraftforge.fml.common.IFuelHandler;
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

@Mod(modid = PerpetualCraft.MOD_ID, name = PerpetualCraft.MOD_NAME, version = PerpetualCraft.MOD_VERSION, dependencies = PerpetualCraft.MOD_DEPENDENCIES, acceptedMinecraftVersions = PerpetualCraft.MOD_ACCEPTED_MC_VERSIONS, useMetadata = true)
public class PerpetualCraft {
	public static final String MOD_ID = "perpetualcraft";
	public static final String MOD_NAME = "PerpetualCraft";
	public static final String MOD_VERSION = "0.0.1";
	public static final String MOD_DEPENDENCIES = "required-after:Forge@[1.8-11.14.0.1239,)";
	public static final String MOD_ACCEPTED_MC_VERSIONS = "[1.8,1.8.9]";

	public static Block ledBlock;
	public static Block charcoalBlock;

	public static Item redPotato;
	public static Item grassFertilizer;

	public static Item excalibur;
	public static Item transparentHelmet;
	public static Item transparentArmor;
	public static Item transparentLeggings;
	public static Item transparentBoots;
	
	public static Item stoneShears;
	public static Item ash;
	

	public static ArmorMaterial TRANSPARENT_MATERIAL = EnumHelper.addArmorMaterial("TRANSPARENT", "TRANSPARENT", 128,
			new int[] { 3, 8, 6, 3 }, 128);

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		MinecraftForge.ORE_GEN_BUS.register(this);

		ledBlock = new LedBlock();
		charcoalBlock = new CharcoalBlock();
		redPotato = new RedPotato();
		grassFertilizer = new GrassFertilizer();

		excalibur = new Excalibur();
		
		stoneShears = new StoneShears();
		ash = new Ash();

		GameRegistry.registerBlock(ledBlock, LedItemBlock.class, "ledblock");
		GameRegistry.registerBlock(charcoalBlock, "charcoalblock");
		GameRegistry.registerItem(redPotato, "redpotato");
		GameRegistry.registerItem(grassFertilizer, "grassfertilizer");
		GameRegistry.registerItem(excalibur, "excalibur");
		GameRegistry.registerItem(stoneShears, "stoneshears");
		GameRegistry.registerItem(ash, "ash");

		GameRegistry.registerItem(
				transparentHelmet = new TransparentArmor("TransparentHelm", TRANSPARENT_MATERIAL, "transparent", 0),
				"TransparentHelm");
		GameRegistry.registerItem(
				transparentArmor = new TransparentArmor("TransparentArmor", TRANSPARENT_MATERIAL, "transparent", 1),
				"TransparentArmor");
		GameRegistry.registerItem(
				transparentLeggings = new TransparentArmor("TransparentLeggings",
				TRANSPARENT_MATERIAL, "transparent", 2), "TransparentLeggings");
		GameRegistry.registerItem(
				transparentBoots = new TransparentArmor("TransparentBoots", TRANSPARENT_MATERIAL, "transparent", 3),
				"TransparentBoots");

		if (event.getSide().isClient()) {

			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ledBlock), 0,
					new ModelResourceLocation(MOD_ID + ":" + "ledblock", "inventory"));
			
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(charcoalBlock), 0,
					new ModelResourceLocation(MOD_ID + ":" + "charcoalblock", "inventory"));
			
			ModelLoader.setCustomModelResourceLocation(excalibur, 0,
					new ModelResourceLocation(MOD_ID + ":" + "excalibur", "inventory"));
			ModelLoader.setCustomModelResourceLocation(redPotato, 0,
					new ModelResourceLocation(MOD_ID + ":" + "redpotato", "inventory"));
			ModelLoader.setCustomModelResourceLocation(grassFertilizer, 0,
					new ModelResourceLocation(MOD_ID + ":" + "grassfertilizer", "inventory"));

			ModelLoader.setCustomModelResourceLocation(transparentHelmet, 0,
					new ModelResourceLocation(MOD_ID + ":" + "transparenthelmet", "inventory"));
			ModelLoader.setCustomModelResourceLocation(transparentArmor, 0,
					new ModelResourceLocation(MOD_ID + ":" + "transparentarmor", "inventory"));
			ModelLoader.setCustomModelResourceLocation(transparentLeggings, 0,
					new ModelResourceLocation(MOD_ID + ":" + "transparentleggings", "inventory"));
			ModelLoader.setCustomModelResourceLocation(transparentBoots, 0,
					new ModelResourceLocation(MOD_ID + ":" + "transparentboots", "inventory"));
			
			ModelLoader.setCustomModelResourceLocation(stoneShears, 0,
					new ModelResourceLocation(MOD_ID + ":" + "stoneshears", "inventory"));
			ModelLoader.setCustomModelResourceLocation(ash, 0,
					new ModelResourceLocation(MOD_ID + ":" + "ash", "inventory"));

		}
	}

	@SubscribeEvent
	public void generateOrePre(OreGenEvent.Pre event) {
		WorldGenerator chrowa3BlockGen = new WorldGenMinable(ledBlock.getDefaultState(), 10);

		if (TerrainGen.generateOre(event.world, event.rand, chrowa3BlockGen, event.pos,
				OreGenEvent.GenerateMinable.EventType.CUSTOM))
			genStandardOre(event.world, event.pos, 2, chrowa3BlockGen, 30, 50, event.rand);
	}

	protected void genStandardOre(World world, BlockPos pos, int size, WorldGenerator generator, int minY, int maxY,
			Random rnd) {
		int l;

		if (maxY < minY) {
			l = minY;
			minY = maxY;
			maxY = l;
		} else if (maxY == minY) {
			if (minY < 255)
				++maxY;
			else
				--minY;
		}

		for (l = 0; l < size; ++l) {
			BlockPos blockpos = pos.add(rnd.nextInt(16), rnd.nextInt(maxY - minY) + minY, rnd.nextInt(16));
			generator.generate(world, rnd, blockpos);
		}
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		GameRegistry.addRecipe(new ItemStack(grassFertilizer, 16),
				"###",
				"###",
				"###",
				'#', Blocks.tallgrass);

		GameRegistry.addRecipe(new ItemStack(excalibur),
				"BBB",
				"DSD",
				"DBD",
				'B', Items.book,
				'D', Items.diamond,
				'S', Items.diamond_sword);
		
		GameRegistry.addRecipe(new ItemStack(redPotato, 8),
				"   ",
				"RPR",
				"   ",
				'R', Items.redstone,
				'P', Items.potato);
		
		GameRegistry.addRecipe(new ItemStack(ledBlock, 8),
				"RRR",
				"RSR",
				"RRR",
				'R', Items.redstone,
				'S', Blocks.cobblestone);
		
		// Transparent Armor Series
		GameRegistry.addRecipe(new ItemStack(transparentHelmet),
				"   ",
				"GGG",
				"G G",
				'G', Blocks.glass);
		
		GameRegistry.addRecipe(new ItemStack(transparentArmor),
				"G G",
				"GGG",
				"GGG",
				'G', Blocks.glass);
		
		GameRegistry.addRecipe(new ItemStack(transparentLeggings),
				"GGG",
				"G G",
				"G G",
				'G', Blocks.glass);
		
		GameRegistry.addRecipe(new ItemStack(transparentBoots),
				"   ",
				"G G",
				"G G",
				'G', Blocks.glass);
		
		GameRegistry.addRecipe(new ItemStack(stoneShears),
				"S S",
				" S ",
				"C C",
				'S', Blocks.stone,
				'C', Blocks.cobblestone);
		
		
		GameRegistry.addRecipe(new ItemStack(Items.coal,32,1),
				"AAA",
				"AAA",
				"AAA",
				'A', ash);
		
		GameRegistry.addRecipe(new ItemStack(charcoalBlock),
				"CCC",
				"CCC",
				"CCC",
				'C', new ItemStack(Items.coal, 1, 1));
		
		GameRegistry.addShapelessRecipe(new ItemStack(Items.diamond),
				charcoalBlock,charcoalBlock,charcoalBlock,
				charcoalBlock,charcoalBlock,charcoalBlock,
				charcoalBlock,charcoalBlock,charcoalBlock);
		
		GameRegistry.addShapelessRecipe(new ItemStack(Items.coal, 9, 1),
				charcoalBlock);
		
		GameRegistry.addSmelting(Blocks.leaves ,new ItemStack(ash),0.1f);
		
		GameRegistry.registerFuelHandler(new IFuelHandler(){
		    @Override
		    public int getBurnTime(ItemStack fuel){
		        if(fuel.getItem().equals(Item.getItemFromBlock(charcoalBlock))){
		                return 50000;
		        }
		        return 0;
		    }
		});
	}
}
