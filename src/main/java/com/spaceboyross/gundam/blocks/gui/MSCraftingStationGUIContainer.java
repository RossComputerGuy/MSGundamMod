package com.spaceboyross.gundam.blocks.gui;

import com.spaceboyross.gundam.GundamMod;
import com.spaceboyross.gundam.blocks.container.MSCraftingStationContainer;
import com.spaceboyross.gundam.blocks.tile.MSCraftingStationTileEntity;
import com.spaceboyross.gundam.ms.MSRegistry;
import com.spaceboyross.gundam.ms.MobileSuit;
import com.spaceboyross.gundam.ms.MobileSuitArmament;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MSCraftingStationGUIContainer extends GuiContainer {
	
	public static final int WIDTH = 180;
    public static final int HEIGHT = 152;
    
    private static final ResourceLocation background = new ResourceLocation(GundamMod.MODID,"textures/gui/ms_crafting_station_background.png");

    private int page = 0;
    
	public MSCraftingStationGUIContainer(MSCraftingStationTileEntity te,MSCraftingStationContainer inventorySlotsIn) {
		super(inventorySlotsIn);
		
		this.xSize = MSCraftingStationGUIContainer.WIDTH;
		this.ySize = MSCraftingStationGUIContainer.HEIGHT;
	}
	
	private void drawGuiMobileSuit() {
		MobileSuit ms = MSRegistry.getMobileSuitFromIndex(this.page);
		
		int name_x = (this.xSize-this.fontRenderer.getStringWidth(ms.getModel()+" "+ms.getName()))/2;
		int name_y = (this.ySize/10);
		
		this.drawString(this.fontRenderer,ms.getModel()+" "+ms.getName(),name_x,name_y,0xFFFFFF);
		
		int armaments_x = (this.xSize/10);
		int armaments_y = name_y+(this.ySize/20)+this.fontRenderer.FONT_HEIGHT;
		
		this.drawString(this.fontRenderer,"Armaments:",armaments_x,armaments_y,0xFFFFFF);
		
		for(int i = 0;i < ms.getArmamentCount();i++) {
			MobileSuitArmament armament = ms.getArmament(i);
			armaments_y += (this.ySize/20)+this.fontRenderer.FONT_HEIGHT;
			this.drawString(this.fontRenderer,(i+1)+". "+armament.toString(),armaments_x,armaments_y,0xFFFFFF);
		}
		
		int recipe_x = (this.xSize/10);
		int recipe_y = armaments_y+(this.ySize/20)+this.fontRenderer.FONT_HEIGHT;
		
		this.drawString(this.fontRenderer,"Required Items:",recipe_x,recipe_y,0xFFFFFF);
		recipe_y += (this.ySize/20)+this.fontRenderer.FONT_HEIGHT;
		
		for(int i = 0;i < ms.getRecipeItemCount();i++) {
			Integer count = ms.getRecipeItemCount(i);
			String id = ms.getRecipeItemID(i);
			String mid = id.split(":")[0];
			id = id.split(":")[1];
			ResourceLocation icon = new ResourceLocation(mid,"textures/items/"+id+".png");
			
			GameRegistry.makeItemStack(mid+":"+id,0,count,"");
			
			this.mc.getTextureManager().bindTexture(icon);
			this.drawTexturedModalRect(recipe_x,recipe_y,0,0,16,16);
			recipe_x += 20;
			this.drawString(this.fontRenderer,count.toString(),recipe_x,recipe_y,0xFFFFFF);
			recipe_x += 20;
		}
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks,int mouseX,int mouseY) {
		this.mc.getTextureManager().bindTexture(MSCraftingStationGUIContainer.background);
		this.drawTexturedModalRect(guiLeft,guiTop,0,0,this.xSize,this.ySize);
	}
	
	@Override
	public void drawGuiContainerForegroundLayer(int mouseX,int mouseY) {
		this.drawGuiMobileSuit();
	}
	
	@Override
    public void drawScreen(int mouseX,int mouseY,float partialTicks) {
        super.drawDefaultBackground();
        super.drawScreen(mouseX,mouseY,partialTicks);
        super.renderHoveredToolTip(mouseX,mouseY);
	}
}