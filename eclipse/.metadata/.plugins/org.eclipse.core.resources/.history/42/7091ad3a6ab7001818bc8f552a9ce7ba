package com.spaceboyross.gundam.proxy;

import java.io.File;

import com.spaceboyross.gundam.Config;
import com.spaceboyross.gundam.GundamBlocks;
import com.spaceboyross.gundam.GundamDimensions;
import com.spaceboyross.gundam.GundamEntities;
import com.spaceboyross.gundam.GundamMod;
import com.spaceboyross.gundam.GundamRecipes;
import com.spaceboyross.gundam.blocks.LunaTitaniumBlock;
import com.spaceboyross.gundam.blocks.MSCraftingStationBlock;
import com.spaceboyross.gundam.blocks.tile.MSCraftingStationTileEntity;
import com.spaceboyross.gundam.items.CharAznableMaskItem;
import com.spaceboyross.gundam.items.GControllerItem;
import com.spaceboyross.gundam.items.GundariumAlphaIngotItem;
import com.spaceboyross.gundam.items.GundariumBetaIngotItem;
import com.spaceboyross.gundam.items.GundariumEpsilonIngotItem;
import com.spaceboyross.gundam.items.GundariumGammaIngotItem;
import com.spaceboyross.gundam.items.LunaTitaniumIngotItem;
import com.spaceboyross.gundam.items.PortableVernierItem;
import com.spaceboyross.gundam.ms.MSRegistry;
import com.spaceboyross.gundam.ms.gundams.RX782GundamMobileSuit;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
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
		
		GundamEntities.init();
		GundamDimensions.init();
		
		MSRegistry.register(new RX782GundamMobileSuit());
	}
	
	public void init(FMLInitializationEvent e) {
		NetworkRegistry.INSTANCE.registerGuiHandler(GundamMod.instance,new GUIProxy());
		GundamRecipes.init();
	}
	
	public void postInit(FMLPostInitializationEvent e) {
		if(CommonProxy.config.hasChanged()) CommonProxy.config.save();
	}
	
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		event.getRegistry().register(new LunaTitaniumBlock());
		event.getRegistry().register(new MSCraftingStationBlock());
		
		GameRegistry.registerTileEntity(MSCraftingStationTileEntity.class,GundamMod.MODID+"_ms_crafting_station");
	}
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().register(new CharAznableMaskItem());
		event.getRegistry().register(new GControllerItem());
		event.getRegistry().register(new GundariumAlphaIngotItem());
		event.getRegistry().register(new GundariumBetaIngotItem());
		event.getRegistry().register(new GundariumEpsilonIngotItem());
		event.getRegistry().register(new GundariumGammaIngotItem());
		event.getRegistry().register(new LunaTitaniumIngotItem());
		event.getRegistry().register(new PortableVernierItem());
		
		event.getRegistry().register(new ItemBlock(GundamBlocks.lunaTitaniumBlock).setRegistryName(GundamBlocks.lunaTitaniumBlock.getRegistryName()));
		event.getRegistry().register(new ItemBlock(GundamBlocks.msCraftingStation).setRegistryName(GundamBlocks.msCraftingStation.getRegistryName()));
	}
}