package com.spaceboyross.gundam.ms.gundams;

import com.spaceboyross.gundam.ms.MSRegistry;
import com.spaceboyross.gundam.ms.MobileSuit;

import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ZGMFX10AFreedomGundamMobileSuit extends MobileSuit {
	
	public ZGMFX10AFreedomGundamMobileSuit() {
		this.setHeight(59.154f);
		this.setModel("ZGMF-X10A");
		this.setName("Freedom Gundam");
		
		this.addRecipeItem("gundam:phase_shift_armor",20);
	}
	
	@Override
	public int getCameraCount() {
		return 12;
	}
	
	@Override
	public MSEntity createEntity(World worldIn,Vec3d pos) {
		MSEntity mob = new ZGMFX10AFreedomGundamMobileSuit.MSEntity(worldIn);
		mob.setPosition(pos.x,pos.y,pos.z);
		return mob;
	}
	
	public static class MSEntity extends MobileSuit.MSEntity {
		public MSEntity(World worldIn) {
			super(worldIn);
			this.scale = 6.65f;
			this.setSize(1.0f*this.scale,2.0f*this.scale);
		}
		
		@Override
		public MobileSuit getMSRegistryEntry() {
			return MSRegistry.getMobileSuit("ZGMF-X10A Freedom Gundam");
		}
	}
}
