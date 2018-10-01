package com.spaceboyross.gundam.ms.gundams;

import com.spaceboyross.gundam.ms.MSRegistry;
import com.spaceboyross.gundam.ms.MobileSuit;
import com.spaceboyross.gundam.ms.armaments.BeamSaberMSArmament;
import com.spaceboyross.gundam.ms.armaments.VulcanGunMSArmament;
import com.spaceboyross.gundam.ms.gundams.RX178GundamMkIIMobileSuit.MSEntity;

import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ZGMFX09AJusticeGundamMobileSuit extends MobileSuit {
	
	public ZGMFX09AJusticeGundamMobileSuit() {
		this.setHeight(60.892f);
		this.setModel("ZGMF-X09A");
		this.setName("Justice Gundam");
		
		this.addArmament(new VulcanGunMSArmament(2,60));
		
		this.addRecipeItem("gundam:phase_shift_armor",20);
	}
	
	@Override
	public int getCameraCount() {
		return 12;
	}
	
	@Override
	public MSEntity createEntity(World worldIn,Vec3d pos) {
		MSEntity mob = new ZGMFX09AJusticeGundamMobileSuit.MSEntity(worldIn);
		mob.setPosition(pos.x,pos.y,pos.z);
		return mob;
	}
	
	public static class MSEntity extends MobileSuit.MSEntity {
		public MSEntity(World worldIn) {
			super(worldIn);
			this.scale = 6.666687f;
			this.setSize(1.0f*this.scale,2.0f*this.scale);
		}
		
		@Override
		public MobileSuit getMSRegistryEntry() {
			return MSRegistry.getMobileSuit("ZGMF-X09A Justice Gundam");
		}
	}
}
