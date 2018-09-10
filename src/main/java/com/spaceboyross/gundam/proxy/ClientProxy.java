package com.spaceboyross.gundam.proxy;

import com.spaceboyross.gundam.GundamBlocks;
import com.spaceboyross.gundam.GundamEntities;
import com.spaceboyross.gundam.GundamItems;
import com.spaceboyross.gundam.GundamMod;
import com.spaceboyross.gundam.input.InputHandler;
import com.spaceboyross.gundam.input.KeyBindings;

import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {
	@Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
        
        OBJLoader.INSTANCE.addDomain(GundamMod.MODID);
        
        GundamEntities.initModels();
    }
	
	@Override
    public void init(FMLInitializationEvent event) {
		super.init(event);
		
		MinecraftForge.EVENT_BUS.register(new InputHandler());
		KeyBindings.init();
	}
	
	@Override
	public void postInit(FMLPostInitializationEvent event) {
		super.postInit(event);
		GundamBlocks.initItemModels();
	}
	
	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event) {
		GundamBlocks.initModels();
		GundamItems.initModels();
	}
}