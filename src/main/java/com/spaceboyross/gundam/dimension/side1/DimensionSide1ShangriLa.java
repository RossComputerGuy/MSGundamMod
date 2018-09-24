package com.spaceboyross.gundam.dimension.side1;

import com.spaceboyross.gundam.GundamDimensions;
import com.spaceboyross.gundam.dimension.DimensionMoon.MoonChunkGenerator;
import com.spaceboyross.gundam.world.gen.ColonyChunkGenerator;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.IChunkGenerator;

public class DimensionSide1ShangriLa extends WorldProvider {
	
	@Override
	public Vec3d getCloudColor(float partialTicks) {
		return Vec3d.ZERO;
	}
	
	@Override
	public DimensionType getDimensionType() {
		return GundamDimensions.side1ShangriLa;
	}
	
	@Override
	public String getSaveFolder() {
		return "GUNDAM_SIDE1_SHANGRILA";
	}
	
	@Override
	public IChunkGenerator createChunkGenerator() {
		return new ColonyChunkGenerator(this.world);
	}

}