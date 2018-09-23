package com.spaceboyross.gundam.capabilities.human;

import java.util.List;

import com.spaceboyross.gundam.capabilities.interfaces.IHumanCapability;
import com.spaceboyross.gundam.enums.EHumantypes;
import com.spaceboyross.gundam.ms.MobileSuit;
import com.spaceboyross.gundam.ms.MobileSuit.MSMob;
import com.spaceboyross.gundam.net.PacketHandler;
import com.spaceboyross.gundam.net.client.PacketHumanClient;
import com.spaceboyross.gundam.net.server.PacketHumanServer;
import com.spaceboyross.gundam.utils.NetworkUtils;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;

public class HumanCapability implements IHumanCapability {
	
	private boolean shownHumantypeMenu = false;
	private EHumantypes humantype = EHumantypes.OLDTYPE;
	private EntityPlayer player;
	private MobileSuit.MSMob ms;
	private int mobileFighterID = -1;
	
	public HumanCapability(EntityPlayer player) {
		this.player = player;
	}
	
	@Override
	public void setMobileFighterID(int id) {
		this.mobileFighterID = id;
	}
	
	@Override
	public int getMobileFighterID() {
		return this.mobileFighterID;
	}
	
	@Override
	public void setMS(MobileSuit.MSMob ms) {
		this.ms = ms;
	}
	
	@Override
	public MobileSuit.MSMob getMS() {
		if(this.ms == null && this.player != null && this.player.getRidingEntity() != null && this.player.getRidingEntity() instanceof MobileSuit.MSMob) return (MobileSuit.MSMob)this.player.getRidingEntity();
		return this.ms;
	}
	
	@Override
	public List<Entity> getEntitiesWithinRange() {
		return this.player.getEntityWorld().getEntitiesWithinAABBExcludingEntity(this.player,new AxisAlignedBB(
			new Vec3d(this.player.posX,this.player.posY,this.player.posZ),
			new Vec3d(this.player.posX,this.player.posY,this.player.posZ)
		).expand(20.0,20.0,20.0));
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

	@Override
	public EHumantypes getHumantype() {
		return this.humantype;
	}

	@Override
	public void setHumantype(EHumantypes v) {
		this.humantype = v;
	}
	
	@Override
	public void syncToServer() {
		PacketHandler.INSTANCE.sendToServer(new PacketHumanServer(this));
	}
	
	@Override
	public void syncToClient() {
		NetworkUtils.sendToClient(new PacketHumanClient(this),this.player);
	}

}
