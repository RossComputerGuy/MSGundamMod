package com.spaceboyross.gundam.gui;

import com.spaceboyross.gundam.GundamMod;
import com.spaceboyross.gundam.blocks.gui.MSCraftingStationGUIContainer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class HumantypeGUI extends GuiScreen {
	
	public static final int GUI_ID = 2;
	
	private EntityPlayer player;
	
	private GuiButton btnNewtype;
	private GuiButton btnOldtype;
	
	public HumantypeGUI() {
		this(Minecraft.getMinecraft().player);
	}
	
	public HumantypeGUI(EntityPlayer player) {
		super();
		
		this.player = player;
	}
	
	@Override
	public void initGui() {
		this.buttonList.clear();
	}
	
	@Override
	public boolean doesGuiPauseGame() {
		return true;
	}
	
	@Override
	public void drawScreen(int mouseX,int mouseY,float partialTicks) {
		super.drawScreen(mouseX,mouseY,partialTicks);
	}
}