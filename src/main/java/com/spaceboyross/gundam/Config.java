package com.spaceboyross.gundam;

import com.spaceboyross.gundam.proxy.CommonProxy;

import net.minecraftforge.common.config.Configuration;

public class Config {
	
	public static final String CATEGORY_GENERAL = "general";
	
	public static boolean use3DMSHud = true;
	
	public static void readConfig() {
		Configuration cfg = CommonProxy.config;
		try {
			cfg.load();
			Config.initGeneralConfig(cfg);
		} catch(Exception ex) {
			GundamMod.logger.error("Problem loading config file",ex);
		} finally {
			if(cfg.hasChanged()) cfg.save();
		}
	}
	
	private static void initGeneralConfig(Configuration cfg) {
		cfg.addCustomCategoryComment(Config.CATEGORY_GENERAL,"General configuration");
		Config.use3DMSHud = cfg.get(Config.CATEGORY_GENERAL,"Use 3D MS HUD",Config.use3DMSHud,"Enables a more advanced design of the HUD for Mobile Suits").getBoolean(true);
		cfg.save();
	}
}