package com.spaceboyross.gundam.gui;

import com.spaceboyross.gundam.Config;
import com.spaceboyross.gundam.GundamMod;
import com.spaceboyross.gundam.proxy.CommonProxy;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModConfig extends GuiConfig {
	
	public ModConfig(GuiScreen parent) {
		super(parent,new ConfigElement(CommonProxy.config.getCategory(Config.CATEGORY_GENERAL)).getChildElements(),GundamMod.MODID,false,false,"");
	}
	
	@Override
	public void actionPerformed(GuiButton btn) {
		super.actionPerformed(btn);
		if(btn.id == 2000) CommonProxy.config.save();
	}
}
