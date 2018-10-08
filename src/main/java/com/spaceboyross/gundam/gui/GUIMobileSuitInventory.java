package com.spaceboyross.gundam.gui;

import com.spaceboyross.gundam.ms.MobileSuit;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GUIMobileSuitInventory extends GuiContainer {
	
	public static final int GUI_ID = 3;

	public GUIMobileSuitInventory(MobileSuit.MSEntity entity) {
		super(entity.inventoryContainer);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks,int mouseX,int mouseY) {
	}

}
