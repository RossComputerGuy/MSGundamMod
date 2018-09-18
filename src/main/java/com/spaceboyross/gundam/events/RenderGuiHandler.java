package com.spaceboyross.gundam.events;

import com.spaceboyross.gundam.capabilities.human.Human;
import com.spaceboyross.gundam.capabilities.interfaces.IHumanCapability;
import com.spaceboyross.gundam.enums.EHumantypes;
import com.spaceboyross.gundam.gui.hud.NewtypeHUD;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class RenderGuiHandler {
	@SubscribeEvent
	public static void onRenderGui(RenderGameOverlayEvent.Post event) {
		IHumanCapability human = Human.getHuman(Minecraft.getMinecraft().player);
		if(human.getHumantype() == EHumantypes.NEWTYPE) new NewtypeHUD(Minecraft.getMinecraft(),human);
	}
}