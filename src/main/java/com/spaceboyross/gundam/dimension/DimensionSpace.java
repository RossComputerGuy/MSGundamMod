package com.spaceboyross.gundam.dimension;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.spaceboyross.gundam.GundamDimensions;
import com.spaceboyross.gundam.world.terrain.MoonTerrainGenerator;
import com.spaceboyross.gundam.world.terrain.NormalTerrainGenerator;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.WorldEntitySpawner;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.IChunkGenerator;

public class DimensionSpace extends WorldProvider {
	
	@Override
	public void init() {
		super.init();
		this.doesWaterVaporize = true;
		this.hasSkyLight = false;
	}
	
	@Override
	public void updateWeather() {
		this.world.getWorldInfo().setRainTime(0);
        this.world.getWorldInfo().setRaining(false);
        this.world.getWorldInfo().setThunderTime(0);
        this.world.getWorldInfo().setThundering(false);
        this.world.rainingStrength = 0.0F;
        this.world.thunderingStrength = 0.0F;
	}
	
	@Override
	public Vec3d getCloudColor(float partialTicks) {
		return Vec3d.ZERO;
	}

	@Override
	public DimensionType getDimensionType() {
		return GundamDimensions.space;
	}
	
	@Override
	public boolean canSnowAt(BlockPos pos,boolean checkLight) {
		return false;
	}
	
	@Override
	public boolean isDaytime() {
		return false;
	}
	
	@Override
    public boolean canDoLightning(Chunk chunk) {
        return false;
    }
	
	@Override
    public boolean canDoRainSnowIce(Chunk chunk) {
        return false;
	}
	
	@Override
	public String getSaveFolder() {
		return "GUNDAM_SPACE";
	}
	
	@Override
	public IChunkGenerator createChunkGenerator() {
		return new SpaceChunkGenerator(this.world);
	}
	
	public static class SpaceChunkGenerator implements IChunkGenerator {
		
		private World world;
		
		public SpaceChunkGenerator(World world) {
			this.world = world;
		}

		@Override
		public Chunk generateChunk(int x,int z) {
			ChunkPrimer chunkprimer = new ChunkPrimer();
			Chunk chunk = new Chunk(this.world,chunkprimer,x,z);
			return chunk;
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
			return new ArrayList<>();
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
