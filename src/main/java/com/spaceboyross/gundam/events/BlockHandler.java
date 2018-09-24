package com.spaceboyross.gundam.events;

import com.spaceboyross.gundam.GundamDimensions;

import net.minecraft.init.Blocks;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class BlockHandler {
	@SubscribeEvent
	public static void onPlace(BlockEvent.PlaceEvent event) {
		if(event.getPlayer().dimension == GundamDimensions.moonID) {
			if(event.getWorld().getBlockState(event.getPos()).getBlock() == Blocks.TORCH) {
				event.getWorld().getBlockState(event.getPos()).getBlock().removedByPlayer(event.getWorld().getBlockState(event.getPos()),event.getWorld(),event.getPos(),event.getPlayer(),true);
			}
		}
	}
}