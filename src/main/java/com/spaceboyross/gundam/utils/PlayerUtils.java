package com.spaceboyross.gundam.utils;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class PlayerUtils {
	public static boolean isMultiplayer(EntityPlayer player) {
		return player instanceof EntityPlayerMP;
	}
	
	public static boolean isSinglePlayer(EntityPlayer player) {
		return player instanceof EntityPlayerSP;
	}
}