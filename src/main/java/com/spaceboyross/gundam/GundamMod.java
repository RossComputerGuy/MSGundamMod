package com.spaceboyross.gundam;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

import com.spaceboyross.gundam.proxy.CommonProxy;

@Mod(modid=GundamMod.MODID,name=GundamMod.NAME,version=GundamMod.VERSION,useMetadata=true,guiFactory="com.spaceboyross.gundam.gui.GUIFactory",updateJSON="https://github.com/SpaceboyRoss01/MSGundamMod/raw/master/versionUpdater.json")
public class GundamMod {
	
    public static final String MODID = "gundam";
    public static final String NAME = "MS Gundam";
    public static final String VERSION = "1.0.3";
    
    @SidedProxy(clientSide="com.spaceboyross.gundam.proxy.ClientProxy",serverSide="com.spaceboyross.gundam.proxy.ServerProxy")
    public static CommonProxy proxy;
    
    @Mod.Instance
    public static GundamMod instance;
    
    public static final GundamTab tab = new GundamTab("gundam");
    
    public static Logger logger;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	GundamMod.logger = event.getModLog();
    	GundamMod.proxy.preInit(event);
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
    	GundamMod.proxy.init(event);
    }
    
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        GundamMod.proxy.postInit(event);
    }
}
