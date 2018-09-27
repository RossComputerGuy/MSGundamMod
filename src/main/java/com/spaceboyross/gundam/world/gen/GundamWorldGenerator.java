package com.spaceboyross.gundam.world.gen;

import java.util.Random;

import com.spaceboyross.gundam.GundamDimensions;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraftforge.fml.common.IWorldGenerator;

public class GundamWorldGenerator extends WorldGenerator implements IWorldGenerator {

	@Override
	public void generate(Random random,int chunkX,int chunkZ,World world,IChunkGenerator chunkGenerator,IChunkProvider chunkProvider) {
		int blockX = chunkX*16;
		int blockZ = chunkZ*16;
		switch(world.provider.getDimension()) {
			default:
				if(world.provider.getDimension() == GundamDimensions.side1ShangriLaID || world.provider.getDimension() == GundamDimensions.side2IslandIffishID) this.generateSide1(world,random,blockX+8,blockZ+8);
				break;
		}
	}
	
	private void generateSide1(World world,Random random,int blockX,int blockZ) {
		BlockPos pos = new BlockPos(blockX,0,blockZ);
		WorldGenerator structure = new ColonyMaintenanceTunnelWorldGenerator();
		structure.generate(world,random,pos);
	}
	
	public static int getGroundFromAbove(World world,int x,int z) {
		int y = 255;
		boolean foundGround = false;
		while(!foundGround && y-- >= 31) {
			Block blockAt = world.getBlockState(new BlockPos(x,y,z)).getBlock();
			foundGround =  blockAt == Blocks.WATER || blockAt == Blocks.FLOWING_WATER || blockAt == Blocks.GRASS || blockAt == Blocks.SAND || blockAt == Blocks.SNOW || blockAt == Blocks.SNOW_LAYER || blockAt == Blocks.GLASS || blockAt == Blocks.MYCELIUM;
		}
		return y;
	}
	
	public static boolean canSpawnHere(Template template,World world,BlockPos posAboveGround) {
		int zwidth = template.getSize().getZ();
		int xwidth = template.getSize().getX();
		boolean corner1 = isCornerValid(world,posAboveGround);
		boolean corner2 = isCornerValid(world,posAboveGround.add(xwidth,0,zwidth));
		return posAboveGround.getY() > 31 && corner1 && corner2;
	}
	
	public static boolean isCornerValid(World world,BlockPos pos) {
		int variation = 3;
		int highestBlock = getGroundFromAbove(world,pos.getX(),pos.getZ());
		if(highestBlock > pos.getY()-variation && highestBlock < pos.getY()+variation) return true;
		return false;
	}

	@Override
	public boolean generate(World worldIn,Random rand,BlockPos position) {
		return false;
	}

}
