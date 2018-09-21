package com.spaceboyross.gundam.input;

import com.spaceboyross.gundam.GundamDimensions;
import com.spaceboyross.gundam.GundamItems;
import com.spaceboyross.gundam.GundamMod;
import com.spaceboyross.gundam.ms.MobileSuit;
import com.spaceboyross.gundam.net.PacketHandler;
import com.spaceboyross.gundam.net.server.PacketDimensionServer;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

public class InputHandler {
	@SubscribeEvent
	public void onKeyInput(InputEvent.KeyInputEvent event) {
		if(KeyBindings.runTestFN.isPressed()) {
			if(Minecraft.getMinecraft().player.dimension != GundamDimensions.moonID) PacketHandler.INSTANCE.sendToServer(new PacketDimensionServer(GundamDimensions.moonID));
			else PacketHandler.INSTANCE.sendToServer(new PacketDimensionServer(0));
		}
		if(KeyBindings.useVernier.isPressed() && !Minecraft.getMinecraft().player.isRiding() && Minecraft.getMinecraft().player.inventory.armorItemInSlot(2).getItem() == GundamItems.portableVernier && Minecraft.getMinecraft().player.motionY <= 0.0) {
			Minecraft.getMinecraft().player.addVelocity(0.0,0.5,0.0);
		}
		if(Minecraft.getMinecraft().player.isRiding() && Minecraft.getMinecraft().player.getRidingEntity() instanceof MobileSuit.MSMob) {
			if(KeyBindings.msLeftWeapon.isPressed()) {
				MobileSuit.MSMob mob = (MobileSuit.MSMob)Minecraft.getMinecraft().player.getRidingEntity();
				if(mob.armamentLeftHand > -1) mob.getMSRegistryEntry().getArmament(mob.armamentLeftHand).onSwitch(mob);
			}
			if(KeyBindings.msRightWeapon.isPressed()) {
				MobileSuit.MSMob mob = (MobileSuit.MSMob)Minecraft.getMinecraft().player.getRidingEntity();
				if(mob.armamentRightHand > -1) mob.getMSRegistryEntry().getArmament(mob.armamentRightHand).onSwitch(mob);
			}
			if(KeyBindings.msGrabWeaponLeftIncrease.isPressed()) {
				MobileSuit.MSMob mob = (MobileSuit.MSMob)Minecraft.getMinecraft().player.getRidingEntity();
				if(!(mob.armamentLeftHand+1 == mob.getMSRegistryEntry().getArmamentCount())) {
					mob.armamentLeftHand++;
					mob.getMSRegistryEntry().getArmament(mob.armamentLeftHand).onGrab(mob);
				}
			}
			if(KeyBindings.msGrabWeaponLeftDecrease.isPressed()) {
				MobileSuit.MSMob mob = (MobileSuit.MSMob)Minecraft.getMinecraft().player.getRidingEntity();
				if(!(mob.armamentLeftHand-1 > 0)) {
					mob.armamentLeftHand--;
					mob.getMSRegistryEntry().getArmament(mob.armamentLeftHand).onGrab(mob);
				}
			}
			if(KeyBindings.msGrabWeaponRightIncrease.isPressed()) {
				MobileSuit.MSMob mob = (MobileSuit.MSMob)Minecraft.getMinecraft().player.getRidingEntity();
				if(!(mob.armamentRightHand+1 == mob.getMSRegistryEntry().getArmamentCount())) {
					mob.armamentRightHand++;
					mob.getMSRegistryEntry().getArmament(mob.armamentLeftHand).onGrab(mob);
				}
			}
			if(KeyBindings.msGrabWeaponRightDecrease.isPressed()) {
				MobileSuit.MSMob mob = (MobileSuit.MSMob)Minecraft.getMinecraft().player.getRidingEntity();
				if(!(mob.armamentRightHand-1 > 0)) {
					mob.armamentRightHand--;
					mob.getMSRegistryEntry().getArmament(mob.armamentLeftHand).onGrab(mob);
				}
			}
		}
	}
}