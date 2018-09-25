package com.spaceboyross.gundam.proxy;

import java.io.File;

import com.spaceboyross.gundam.Config;
import com.spaceboyross.gundam.GundamBlocks;
import com.spaceboyross.gundam.GundamDimensions;
import com.spaceboyross.gundam.GundamEntities;
import com.spaceboyross.gundam.GundamMod;
import com.spaceboyross.gundam.GundamRecipes;
import com.spaceboyross.gundam.blocks.LunaTitaniumBlock;
import com.spaceboyross.gundam.blocks.LunaTitaniumOreBlock;
import com.spaceboyross.gundam.blocks.MSCraftingStationBlock;
import com.spaceboyross.gundam.blocks.MoonRockBlock;
import com.spaceboyross.gundam.blocks.TitaniumBlock;
import com.spaceboyross.gundam.blocks.tile.MSCraftingStationTileEntity;
import com.spaceboyross.gundam.capabilities.human.Human;
import com.spaceboyross.gundam.events.BlockHandler;
import com.spaceboyross.gundam.events.EntityHandler;
import com.spaceboyross.gundam.events.RenderGuiHandler;
import com.spaceboyross.gundam.items.armor.CharAznableMaskItem;
import com.spaceboyross.gundam.items.armor.SpaceSuitHelmetItem;
import com.spaceboyross.gundam.items.armor.SpaceSuitPantsItem;
import com.spaceboyross.gundam.items.armor.SpaceSuitShoesItem;
import com.spaceboyross.gundam.items.armor.SpaceSuitTorsoItem;
import com.spaceboyross.gundam.items.materials.ECarbonIngotItem;
import com.spaceboyross.gundam.items.materials.GundariumAlphaIngotItem;
import com.spaceboyross.gundam.items.materials.GundariumBetaIngotItem;
import com.spaceboyross.gundam.items.materials.GundariumEpsilonIngotItem;
import com.spaceboyross.gundam.items.materials.GundariumGammaIngotItem;
import com.spaceboyross.gundam.items.materials.LunaTitaniumIngotItem;
import com.spaceboyross.gundam.items.materials.PortableVernierItem;
import com.spaceboyross.gundam.items.materials.SteelIngotItem;
import com.spaceboyross.gundam.items.materials.SuperHardSteelIngotItem;
import com.spaceboyross.gundam.items.music.GundamMusicItem;
import com.spaceboyross.gundam.items.tools.GControllerItem;
import com.spaceboyross.gundam.items.tools.WrenchItem;
import com.spaceboyross.gundam.ms.MSRegistry;
import com.spaceboyross.gundam.ms.eff.RGM79GGMGroundTypeMobileSuit;
import com.spaceboyross.gundam.ms.eff.RGM79GMMobileSuit;
import com.spaceboyross.gundam.ms.fighters.GF13017NJIIGodGundamMobileFighter;
import com.spaceboyross.gundam.ms.fighters.GF13017NJShiningGundamMobileFighter;
import com.spaceboyross.gundam.ms.gundams.AGE1GundamAGE1NormalMobileSuit;
import com.spaceboyross.gundam.ms.gundams.GN001GundamExiaMobileSuit;
import com.spaceboyross.gundam.ms.gundams.MSZ006ZetaGundamMobileSuit;
import com.spaceboyross.gundam.ms.gundams.RX782GundamMobileSuit;
import com.spaceboyross.gundam.ms.gundams.RX78NT1GundamAlexMobileSuit;
import com.spaceboyross.gundam.ms.gundams.XXXG01DGundamDeathscytheMobileSuit;
import com.spaceboyross.gundam.ms.gundams.XXXG01HGundamHeavyarmsMobileSuit;
import com.spaceboyross.gundam.ms.gundams.XXXG01WWingGundamMobileSuit;
import com.spaceboyross.gundam.ms.zeon.MS04PrototypeZakuMobileSuit;
import com.spaceboyross.gundam.ms.zeon.MS05AZaku1EarlyTypeMobileSuit;
import com.spaceboyross.gundam.ms.zeon.MS07BGoufMobileSuit;
import com.spaceboyross.gundam.ms.zeon.MS09RRickDomMobileSuit;
import com.spaceboyross.gundam.net.PacketHandler;
import com.spaceboyross.gundam.world.gen.GundamWorldGenerator;
import com.spaceboyross.gundam.world.gen.OreGen;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod.EventBusSubscriber
public class CommonProxy {
	
	public static Configuration config;
	
	public void preInit(FMLPreInitializationEvent e) {
		File directory = e.getModConfigurationDirectory();
		CommonProxy.config = new Configuration(new File(directory.getPath(),"gundam.cfg"));
		Config.readConfig();
		
		PacketHandler.registerMessages("gundam");
		
		GundamEntities.init();
		GundamDimensions.init();

		MSRegistry.register(new MS04PrototypeZakuMobileSuit());
		MSRegistry.register(new MS05AZaku1EarlyTypeMobileSuit());
		MSRegistry.register(new MS09RRickDomMobileSuit());
		MSRegistry.register(new RX782GundamMobileSuit());
		MSRegistry.register(new RGM79GMMobileSuit());
		MSRegistry.register(new MS07BGoufMobileSuit());
		MSRegistry.register(new RX78NT1GundamAlexMobileSuit());
		MSRegistry.register(new MSZ006ZetaGundamMobileSuit());
		MSRegistry.register(new RGM79GGMGroundTypeMobileSuit());
		MSRegistry.register(new XXXG01DGundamDeathscytheMobileSuit());
		MSRegistry.register(new XXXG01HGundamHeavyarmsMobileSuit());
		MSRegistry.register(new XXXG01WWingGundamMobileSuit());
		MSRegistry.register(new GN001GundamExiaMobileSuit());
		MSRegistry.register(new AGE1GundamAGE1NormalMobileSuit());
		
		MSRegistry.register(new GF13017NJShiningGundamMobileFighter());
		MSRegistry.register(new GF13017NJIIGodGundamMobileFighter());
		
		Human.register();
	}
	
	public void init(FMLInitializationEvent e) {
		NetworkRegistry.INSTANCE.registerGuiHandler(GundamMod.instance,new GUIProxy());
		GameRegistry.registerWorldGenerator(new GundamWorldGenerator(),0);
		GameRegistry.registerWorldGenerator(new OreGen(),0);
		GundamRecipes.init();
	}
	
	public void postInit(FMLPostInitializationEvent e) {
		if(CommonProxy.config.hasChanged()) CommonProxy.config.save();
		MinecraftForge.EVENT_BUS.register(new BlockHandler());
		MinecraftForge.EVENT_BUS.register(new EntityHandler());
		MinecraftForge.EVENT_BUS.register(new RenderGuiHandler());
	}
	
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		event.getRegistry().register(new LunaTitaniumBlock());
		event.getRegistry().register(new LunaTitaniumOreBlock());
		event.getRegistry().register(new MoonRockBlock());
		event.getRegistry().register(new MSCraftingStationBlock());
		event.getRegistry().register(new TitaniumBlock());
		
		GameRegistry.registerTileEntity(MSCraftingStationTileEntity.class,GundamMod.MODID+"_ms_crafting_station");
	}
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().register(new GundamMusicItem("anime_ja_nai"));
		event.getRegistry().register(new GundamMusicItem("beyond_the_time"));
		event.getRegistry().register(new CharAznableMaskItem());
		event.getRegistry().register(new GundamMusicItem("dreams"));
		event.getRegistry().register(new ECarbonIngotItem());
		event.getRegistry().register(new GundamMusicItem("flying_in_the_sky"));
		event.getRegistry().register(new GControllerItem());
		event.getRegistry().register(new GundamMusicItem("godfinger"));
		event.getRegistry().register(new GundariumAlphaIngotItem());
		event.getRegistry().register(new GundariumBetaIngotItem());
		event.getRegistry().register(new GundariumEpsilonIngotItem());
		event.getRegistry().register(new GundariumGammaIngotItem());
		event.getRegistry().register(new GundamMusicItem("just_communication"));
		event.getRegistry().register(new GundamMusicItem("last_impression"));
		event.getRegistry().register(new LunaTitaniumIngotItem());
		event.getRegistry().register(new PortableVernierItem());
		event.getRegistry().register(new GundamMusicItem("rhythm_emotion"));
		event.getRegistry().register(new GundamMusicItem("shine_through_the_storm"));
		event.getRegistry().register(new GundamMusicItem("the_wings_of_a_boy_that_killed_adolescence"));
		event.getRegistry().register(new GundamMusicItem("the_winner"));
		event.getRegistry().register(new GundamMusicItem("tobe_gundam"));
		event.getRegistry().register(new SpaceSuitHelmetItem());
		event.getRegistry().register(new SpaceSuitPantsItem());
		event.getRegistry().register(new SpaceSuitShoesItem());
		event.getRegistry().register(new SpaceSuitTorsoItem());
		event.getRegistry().register(new SteelIngotItem());
		event.getRegistry().register(new SuperHardSteelIngotItem());
		event.getRegistry().register(new GundamMusicItem("white_reflection"));
		event.getRegistry().register(new WrenchItem());
		event.getRegistry().register(new GundamMusicItem("z_toki_wo_koete"));
		
		event.getRegistry().register(new ItemBlock(GundamBlocks.lunaTitaniumBlock).setRegistryName(GundamBlocks.lunaTitaniumBlock.getRegistryName()));
		event.getRegistry().register(new ItemBlock(GundamBlocks.lunaTitaniumOre).setRegistryName(GundamBlocks.lunaTitaniumOre.getRegistryName()));
		event.getRegistry().register(new ItemBlock(GundamBlocks.moonRock).setRegistryName(GundamBlocks.moonRock.getRegistryName()));
		event.getRegistry().register(new ItemBlock(GundamBlocks.msCraftingStation).setRegistryName(GundamBlocks.msCraftingStation.getRegistryName()));
		event.getRegistry().register(new ItemBlock(GundamBlocks.titaniumBlock).setRegistryName(GundamBlocks.titaniumBlock.getRegistryName()));
	}
}