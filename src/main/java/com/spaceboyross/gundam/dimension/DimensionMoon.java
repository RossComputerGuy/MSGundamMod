package com.spaceboyross.gundam.dimension;

import java.util.List;
import java.util.Random;

import com.spaceboyross.gundam.GundamDimensions;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.IChunkGenerator;

public class DimensionMoon extends WorldProvider {

	@Override
	public DimensionType getDimensionType() {
		return GundamDimensions.moon;
	}
	
	@Override
	public String getSaveFolder() {
		return "GUNDAM_MOON";
	}
	
	@Override
	public IChunkGenerator createChunkGenerator() {
		return new MoonChunkGenerator(this.world);
	}
	
	public static class MoonChunkGenerator implements IChunkGenerator {
		
		private World world;
		private Random random;
		
		public MoonChunkGenerator(World world) {
			this.world = world;
			long seed = this.world.getSeed();
			this.random = new Random((seed+516)*314);
		}

		@Override
		public Chunk generateChunk(int x,int z) {
			return null;
		}

		@Override
		public void populate(int x,int z) {
		}

		@Override
		public boolean generateStructures(Chunk chunkIn,int x,int z) {
			return false;
		}

		@Override
		public List<SpawnListEntry> getPossibleCreatures(EnumCreatureType creatureType,BlockPos pos) {
			return null;
		}

		@Override
		public BlockPos getNearestStructurePos(World worldIn,String structureName,BlockPos position,boolean findUnexplored) {
			return null;
		}

		@Override
		public void recreateStructures(Chunk chunkIn,int x,int z) {
		}

		@Override
		public boolean isInsideStructure(World worldIn,String structureName,BlockPos pos) {
			return false;
		}
		
	}

}
