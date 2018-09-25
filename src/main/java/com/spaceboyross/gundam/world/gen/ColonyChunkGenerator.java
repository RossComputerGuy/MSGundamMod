package com.spaceboyross.gundam.world.gen;

import java.util.List;
import java.util.Random;

import com.spaceboyross.gundam.world.terrain.ColonyTerrainGenerator;
import com.spaceboyross.gundam.world.terrain.MoonTerrainGenerator;
import com.spaceboyross.gundam.world.terrain.NormalTerrainGenerator;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldEntitySpawner;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.IChunkGenerator;

public class ColonyChunkGenerator implements IChunkGenerator {
	
	private World world;
	private Random random;
	private NormalTerrainGenerator terraingen;
	private Biome[] biomesForGeneration;
	
	public ColonyChunkGenerator(World world) {
		this.world = world;
		long seed = this.world.getSeed();
		this.random = new Random((seed+516)*314);
		this.terraingen = new ColonyTerrainGenerator();
		this.terraingen.setup(this.world,this.random);
	}

	@Override
	public Chunk generateChunk(int x,int z) {
		ChunkPrimer chunkprimer = new ChunkPrimer();
		
		this.biomesForGeneration = this.world.getBiomeProvider().getBiomesForGeneration(this.biomesForGeneration,x*4-2,z*4-2,10,10);
		this.terraingen.setBiomesForGeneration(this.biomesForGeneration);
		this.terraingen.generate(x,z,chunkprimer);
		
		this.biomesForGeneration = this.world.getBiomeProvider().getBiomes(this.biomesForGeneration,x*16,z*16,16,16);
		this.terraingen.replaceBiomeBlocks(x,z,chunkprimer,this,this.biomesForGeneration);
		
		Chunk chunk = new Chunk(this.world,chunkprimer,x,z);
		
		byte[] biomeArray = chunk.getBiomeArray();
		for(int i = 0;i < biomeArray.length;i++) biomeArray[i] = (byte)Biome.getIdForBiome(this.biomesForGeneration[i]);
		chunk.generateSkylightMap();
		return chunk;
	}

	@Override
	public void populate(int x,int z) {
		int i = x*16;
        int j = z*16;
        BlockPos blockpos = new BlockPos(i,0,j);
        Biome biome = this.world.getBiome(blockpos.add(16,0,16));
        biome.decorate(this.world,this.random,blockpos);
        WorldEntitySpawner.performWorldGenSpawning(this.world,biome,i+8,j+8,16,16,this.random);
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void recreateStructures(Chunk chunkIn,int x,int z) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isInsideStructure(World worldIn,String structureName,BlockPos pos) {
		// TODO Auto-generated method stub
		return false;
	}

}