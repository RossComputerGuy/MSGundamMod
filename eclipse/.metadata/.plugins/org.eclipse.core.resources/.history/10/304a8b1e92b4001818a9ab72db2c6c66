package com.spaceboyross.gundam;

import com.spaceboyross.gundam.proxy.CommonProxy;

import net.minecraftforge.common.config.Configuration;

public class Config {
	
	private static final String CATEGORY_GENERAL = "general";
	
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
	}
}