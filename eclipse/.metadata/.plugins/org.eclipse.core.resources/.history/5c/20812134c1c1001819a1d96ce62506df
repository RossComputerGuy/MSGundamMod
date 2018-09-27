package com.spaceboyross.gundam.input;

import com.spaceboyross.gundam.GundamDimensions;
import com.spaceboyross.gundam.GundamItems;
import com.spaceboyross.gundam.GundamMod;
import com.spaceboyross.gundam.capabilities.human.Human;
import com.spaceboyross.gundam.capabilities.interfaces.IHumanCapability;
import com.spaceboyross.gundam.ms.MobileFighter;
import com.spaceboyross.gundam.ms.MobileSuit;
import com.spaceboyross.gundam.net.PacketHandler;
import com.spaceboyross.gundam.net.server.PacketDimensionServer;

import net.minecraft.client.Minecraft;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

public class InputHandler {
	@SubscribeEvent
	public void onKeyInput(InputEvent.KeyInputEvent event) {
		if(KeyBindings.runTestFN.isPressed()) {
			if(Minecraft.getMinecraft().player.dimension != GundamDimensions.side1ShangriLaID) PacketHandler.INSTANCE.sendToServer(new PacketDimensionServer(GundamDimensions.side1ShangriLaID));
			else PacketHandler.INSTANCE.sendToServer(new PacketDimensionServer(0));
		}
		if(KeyBindings.callMobileFighter.isPressed()) {
			IHumanCapability human = Human.getHuman(Minecraft.getMinecraft().player);
			if(human.getMobileFighterID() >= 0) {
				MobileFighter.MSMob mobileFighter = (MobileFighter.MSMob)human.getPlayer().getEntityWorld().getEntityByID(human.getMobileFighterID());
				mobileFighter.setPosition(human.getPlayer().posX,human.getPlayer().posY,human.getPlayer().posZ);
				mobileFighter.applyPlayerInteraction(human.getPlayer(),new Vec3d(human.getPlayer().posX,human.getPlayer().posY,human.getPlayer().posZ),EnumHand.MAIN_HAND);
			}
		}
		if(KeyBindings.useVernier.isPressed() && !Minecraft.getMinecraft().player.isRiding() && Minecraft.getMinecraft().player.inventory.armorItemInSlot(2).getItem() == GundamItems.portableVernier && Minecraft.getMinecraft().player.motionY <= 0.0) {
			Minecraft.getMinecraft().player.addVelocity(0.0,0.5,0.0);
		}
	}
}