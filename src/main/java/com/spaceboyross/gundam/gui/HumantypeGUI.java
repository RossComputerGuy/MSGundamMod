package com.spaceboyross.gundam.gui;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class HumantypeGUI extends GuiScreen {
	
	public static final int GUI_ID = 2;
	
	private EntityPlayer player;
	
	public HumantypeGUI(EntityPlayer player) {
		super();
		this.player = player;
	}
	
	@Override
	public void initGui() {
		this.buttonList.clear();
	}
	
	@Override
	public void drawScreen(int mouseX,int mouseY,float partialTicks) {
		this.drawDefaultBackground();
		super.drawScreen(mouseX,mouseY,partialTicks);
	}
}