package com.spaceboyross.gundam.ms.gundams;

import com.spaceboyross.gundam.ms.MSRegistry;
import com.spaceboyross.gundam.ms.MobileSuit;
import com.spaceboyross.gundam.ms.armaments.BeamSaberMSArmament;
import com.spaceboyross.gundam.ms.armaments.VulcanGunMSArmament;
import com.spaceboyross.gundam.ms.gundams.XXXG01DGundamDeathscytheMobileSuit.MSMob;

import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class XXXG01WWingGundamMobileSuit extends MobileSuit {
	
	public XXXG01WWingGundamMobileSuit() {
		this.setHeight(54.79f);
		this.setModel("XXXG-01W");
		this.setName("Wing Gundam");
		
		this.addArmament(new VulcanGunMSArmament(2,60));
		
		this.addRecipeItem("gundam:gundarium_beta_ingot",20);
	}
	
	@Override
	public int getCameraCount() {
		return 12;
	}
	
	@Override
	public MSMob createEntity(World worldIn,Vec3d pos) {
		MSMob mob = new XXXG01WWingGundamMobileSuit.MSMob(worldIn);
		mob.setPosition(pos.x,pos.y,pos.z);
		return mob;
	}
	
	public static class MSMob extends MobileSuit.MSMob {
		public MSMob(World worldIn) {
			super(worldIn);
			this.scale = 5.6333333333f;
			this.setSize(1.0f*this.scale,2.0f*this.scale);
		}
		
		@Override
		public MobileSuit getMSRegistryEntry() {
			return MSRegistry.getMobileSuit("XXXG-01W Wing Gundam");
		}
	}
}
