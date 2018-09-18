package com.spaceboyross.gundam.world;

import java.util.Random;

import com.google.common.base.Predicate;
import com.spaceboyross.gundam.GundamBlocks;
import com.spaceboyross.gundam.GundamDimensions;

import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class OreGen implements IWorldGenerator {

	@Override
	public void generate(Random random,int chunkX,int chunkZ,World world,IChunkGenerator chunkGenerator,IChunkProvider chunkProvider) {
		switch(world.provider.getDimension()) {
			default:
				if(world.provider.getDimension() == GundamDimensions.moonID) {
					this.runGenerator(GundamBlocks.lunaTitaniumOre.getDefaultState(),7,10,12,50,BlockMatcher.forBlock(GundamBlocks.moonRock),world,random,chunkX,chunkZ);
				}
				break;
		}
	}
	
	private void runGenerator(IBlockState blockToGen,int blockAmount,int chancesToSpawn,int minHeight,int maxHeight,Predicate<IBlockState> blockToReplace,World world,Random rand,int chunk_X,int chunk_Z) {
		if(minHeight < 0 || maxHeight > 256 || minHeight > maxHeight) throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");
		WorldGenMinable generator = new WorldGenMinable(blockToGen,blockAmount,blockToReplace);
		int heightdiff = maxHeight-minHeight+1;
		for(int i = 0;i < chancesToSpawn;i++) {
			int x = chunk_X*16+rand.nextInt(16);
			int y = minHeight+rand.nextInt(heightdiff);
			int z = chunk_Z*16+rand.nextInt(16);
			generator.generate(world,rand,new BlockPos(x,y,z));
		}
	}
}
