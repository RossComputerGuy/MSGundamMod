package com.spaceboyross.gundam.capabilities.newtype;

import com.spaceboyross.gundam.GundamMod;
import com.spaceboyross.gundam.capabilities.interfaces.INewtypeCapability;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class NewtypeCapability implements INewtypeCapability {
	
	private boolean shownHumantypeMenu = false;
	
	private EntityPlayer player;
	
	public NewtypeCapability(EntityPlayer player) {
		this.player = player;
	}

	@Override
	public EntityPlayer getPlayer() {
		return this.player;
	}

	@Override
	public boolean hasShownHumantypeMenu() {
		return this.shownHumantypeMenu;
	}

	@Override
	public void setHasShownHumantypeMenu(boolean v) {
		this.shownHumantypeMenu = v;
	}
}