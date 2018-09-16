package com.spaceboyross.gundam.gui;

import com.spaceboyross.gundam.GundamMod;
import com.spaceboyross.gundam.blocks.gui.MSCraftingStationGUIContainer;
import com.spaceboyross.gundam.capabilities.interfaces.INewtypeCapability;
import com.spaceboyross.gundam.capabilities.newtype.Newtype;
import com.spaceboyross.gundam.enums.EHumantypes;
import com.spaceboyross.gundam.utils.CapabilityUtils;
import com.spaceboyross.gundam.utils.UIUtils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class HumantypeGUI extends GuiScreen {
	
	public static final int GUI_ID = 2;
	
	private EntityPlayer player;
	private INewtypeCapability nt;
	
	private GuiButton btnNewtype;
	private GuiButton btnOldtype;
	
	public HumantypeGUI() {
		this(Minecraft.getMinecraft().player);
	}
	
	public HumantypeGUI(EntityPlayer player) {
		super();
		
		this.player = player;
		this.nt = CapabilityUtils.getCapability(this.player,Newtype.MAX_NEWTYPE_CAPABILITY,Newtype.DEFAULT_FACING);
	}
	
	@Override
	public void initGui() {
		this.buttonList.clear();
		
		int buttons_x = UIUtils.divideScreenWidthI18N(this.fontRenderer,this.width,"gui.gundam.humantype.newtype","gui.gundam.humantype.oldtype");
		int buttons_y = UIUtils.divideScreenHeight(this.fontRenderer,this.height,1);
		
		this.btnNewtype = this.addButton(UIUtils.makeButtonI18N(this.fontRenderer,0,buttons_x,buttons_y,"gui.gundam.humantype.newtype"));
		buttons_x += this.btnNewtype.width;
		this.btnOldtype = this.addButton(UIUtils.makeButtonI18N(this.fontRenderer,1,buttons_x,buttons_y,"gui.gundam.humantype.oldtype"));
	}
	
	@Override
	public void actionPerformed(GuiButton button) {
		if(button.id >= this.btnNewtype.id && button.id <= this.btnOldtype.id) {
			if(button.id == this.btnNewtype.id) this.nt.setHumantype(EHumantypes.NEWTYPE);
			if(button.id == this.btnOldtype.id) this.nt.setHumantype(EHumantypes.OLDTYPE);
			this.mc.displayGuiScreen(null);
			this.nt.setHasShownHumantypeMenu(true);
		}
	}
	
	@Override
	public boolean doesGuiPauseGame() {
		return true;
	}
	
	@Override
	public void drawScreen(int mouseX,int mouseY,float partialTicks) {
		super.drawScreen(mouseX,mouseY,partialTicks);
		int buttons_x = UIUtils.divideScreenWidthI18N(this.fontRenderer,this.width,"gui.gundam.humantype.select")+10;
		this.drawString(this.fontRenderer,I18n.format("gui.gundam.humantype.select"),buttons_x,this.height/3,0xFFFFFF);
	}
}