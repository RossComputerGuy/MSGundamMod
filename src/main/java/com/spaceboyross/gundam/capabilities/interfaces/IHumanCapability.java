package com.spaceboyross.gundam.capabilities.interfaces;

import java.util.List;

import com.spaceboyross.gundam.enums.EnumHumantypes;
import com.spaceboyross.gundam.ms.MobileSuit;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public interface IHumanCapability {
	// Mobile Fighter stuff
	void setMobileFighterID(int id);
	int getMobileFighterID();
	
	// MS Pilot
	void setMS(MobileSuit.MSMob ms);
	MobileSuit.MSMob getMS();
	
	// Newtype
	// TODO: add newtype events
	
	List<Entity> getEntitiesWithinRange();
	
	EntityPlayer getPlayer();
	
	boolean hasShownHumantypeMenu();
	void setHasShownHumantypeMenu(boolean v);
	
	EnumHumantypes getHumantype();
	void setHumantype(EnumHumantypes v);
	
	void syncToServer();
	void syncToClient();
}
