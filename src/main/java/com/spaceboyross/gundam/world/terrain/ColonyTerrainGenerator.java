package com.spaceboyross.gundam.world.terrain;

import com.spaceboyross.gundam.GundamBlocks;

import net.minecraft.init.Blocks;
import net.minecraft.world.chunk.ChunkPrimer;

public class ColonyTerrainGenerator extends NormalTerrainGenerator {
	
	public ColonyTerrainGenerator() {
		super();
	}
	
	@Override
	public void generate(int chunkX,int chunkZ,ChunkPrimer primer) {
        this.generateHeightmap(chunkX*4,0,chunkZ*4);
        byte waterLevel = 63;
        for(int x4 = 0;x4 < 4;x4++) {
            int l = x4*5;
            int i1 = (x4+1)*5;
            for(int z4 = 0;z4 < 4;z4++) {
                int k1 = (l+z4)*33;
                int l1 = (l+z4+1)*33;
                int i2 = (i1+z4)*33;
                int j2 = (i1+z4+1)*33;
                for(int height32 = 0;height32 < 32;height32++) {
                    double d0 = 0.125D;
                    double d1 = heightMap[k1+height32];
                    double d2 = heightMap[l1+height32];
                    double d3 = heightMap[i2+height32];
                    double d4 = heightMap[j2+height32];
                    double d5 = (heightMap[k1+height32+1]-d1)*d0;
                    double d6 = (heightMap[l1+height32+1]-d2)*d0;
                    double d7 = (heightMap[i2+height32+1]-d3)*d0;
                    double d8 = (heightMap[j2+height32+1]-d4)*d0;
                    for(int h = 0;h < 8;h++) {
                        double d9 = 0.25D;
                        double d10 = d1;
                        double d11 = d2;
                        double d12 = (d3-d1)*d9;
                        double d13 = (d4-d2)*d9;
                        int height = (height32*8)+h;
                        for(int x = 0;x < 4;x++) {
                            double d14 = 0.25D;
                            double d16 = (d11-d10)*d14;
                            double d15 = d10-d16;
                            for(int z = 0;z < 4;z++) {
                            	double val = (d15 += d16);
                                if(height >= 0 && height <= 6) primer.setBlockState(x4*4+x,height32*8+h,z4*4+z,Blocks.AIR.getDefaultState());
                                else if(val > 0.0D) primer.setBlockState(x4*4+x,height32*8+h,z4*4+z,Blocks.STONE.getDefaultState());
                            }
                            d10 += d12;
                            d11 += d13;
                        }
                        d1 += d5;
                        d2 += d6;
                        d3 += d7;
                        d4 += d8;
                    }
                }
            }
        }
    }
}
