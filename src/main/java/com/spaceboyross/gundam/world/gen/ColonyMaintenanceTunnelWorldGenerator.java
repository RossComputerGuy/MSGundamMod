package com.spaceboyross.gundam.world.gen;

import java.util.Map;
import java.util.Random;

import com.spaceboyross.gundam.GundamMod;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;

public class ColonyMaintenance﻿TunnelWorldGenerator extends WorldGenerator {
	@Override
	public boolean generate(World world,Random rand,BlockPos position) {
		WorldServer worldserver = (WorldServer)world;
		MinecraftServer minecraftserver = world.getMinecraftServer();
		TemplateManager templatemanager = worldserver.getStructureTemplateManager();
		Template template = templatemanager.getTemplate(minecraftserver,new ResourceLocation(GundamMod.MODID+":colony_maintenance_tunnel"+rand.nextInt(5)));
		if(template == null) return false;
		IBlockState iblockstate = world.getBlockState(position);
		world.notifyBlockUpdate(position,iblockstate,iblockstate,3);
		PlacementSettings placementsettings = (new PlacementSettings()).setMirror(Mirror.NONE).setRotation(Rotation.NONE).setIgnoreEntities(false).setChunk((ChunkPos)null).setReplacedBlock((Block)null).setIgnoreStructureBlock(false);			
		template.getDataBlocks(position,placementsettings);
		template.addBlocksToWorld(world,position,placementsettings);
		Map<BlockPos,String> map = template.getDataBlocks(position,placementsettings);
		for(Map.Entry<BlockPos,String> entry : map.entrySet()) {
		}
		return true;
	}
}