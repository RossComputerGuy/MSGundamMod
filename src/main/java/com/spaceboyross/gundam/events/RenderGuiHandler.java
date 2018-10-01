package com.spaceboyross.gundam.events;

import com.spaceboyross.gundam.capabilities.human.Human;
import com.spaceboyross.gundam.capabilities.interfaces.IHumanCapability;
import com.spaceboyross.gundam.enums.EnumHumantypes;
import com.spaceboyross.gundam.gui.hud.MobileSuitHUD;
import com.spaceboyross.gundam.gui.hud.NewtypeHUD;
import com.spaceboyross.gundam.ms.MobileSuit;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class RenderGuiHandler {
	@SubscribeEvent
	public static void pre(RenderGameOverlayEvent.Pre event) {
		IHumanCapability human = Human.getHuman(Minecraft.getMinecraft().player);
		if(human.getPlayer().getRidingEntity() != null && human.getPlayer().getRidingEntity() instanceof MobileSuit.MSEntity && event.getType() == ElementType.CHAT) event.setCanceled(true);
	}
	
	@SubscribeEvent
	public static void post(RenderGameOverlayEvent.Post event) {
		IHumanCapability human = Human.getHuman(Minecraft.getMinecraft().player);
		if(human.getHumantype() == EnumHumantypes.NEWTYPE) new NewtypeHUD(Minecraft.getMinecraft(),human);
		if(human.getPlayer().getRidingEntity() != null && human.getPlayer().getRidingEntity() instanceof MobileSuit.MSEntity) new MobileSuitHUD(Minecraft.getMinecraft(),human);
	}
}