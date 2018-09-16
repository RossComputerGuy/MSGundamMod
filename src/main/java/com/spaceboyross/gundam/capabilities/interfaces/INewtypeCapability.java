package com.spaceboyross.gundam.capabilities.interfaces;

import com.spaceboyross.gundam.enums.EHumantypes;

import net.minecraft.entity.player.EntityPlayer;

public interface INewtypeCapability {
	// TODO: add newtype events
	
	EntityPlayer getPlayer();
	
	boolean hasShownHumantypeMenu();
	void setHasShownHumantypeMenu(boolean v);
	
	EHumantypes getHumantype();
	void setHumantype(EHumantypes v);
	
	void syncToServer();
}