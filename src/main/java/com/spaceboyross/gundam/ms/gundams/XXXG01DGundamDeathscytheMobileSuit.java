package com.spaceboyross.gundam.ms.gundams;

import com.spaceboyross.gundam.ms.MSRegistry;
import com.spaceboyross.gundam.ms.MobileSuit;
import com.spaceboyross.gundam.ms.armaments.BeamSaberMSArmament;
import com.spaceboyross.gundam.ms.armaments.VulcanGunMSArmament;
import com.spaceboyross.gundam.ms.gundams.XXXG01HGundamHeavyarmsMobileSuit.MSEntity;

import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class XXXG01DGundamDeathscytheMobileSuit extends MobileSuit {
	
	public XXXG01DGundamDeathscytheMobileSuit() {
		this.setHeight(54.79f);
		this.setModel("XXXG-01D");
		this.setName("Gundam Deathsycthe");
		
		this.addArmament(new VulcanGunMSArmament(2,60));
		
		this.addRecipeItem("gundam:gundarium_beta_ingot",20);
	}
	
	@Override
	public int getCameraCount() {
		return 12;
	}
	
	@Override
	public MSEntity createEntity(World worldIn,Vec3d pos) {
		MSEntity mob = new XXXG01DGundamDeathscytheMobileSuit.MSEntity(worldIn);
		mob.setPosition(pos.x,pos.y,pos.z);
		return mob;
	}
	
	public static class MSEntity extends MobileSuit.MSEntity {
		public MSEntity(World worldIn) {
			super(worldIn);
			this.scale = 5.6333333333f;
			this.setSize(1.0f*this.scale,2.0f*this.scale);
		}
		
		@Override
		public MobileSuit getMSRegistryEntry() {
			return MSRegistry.getMobileSuit("XXXG-01D Gundam Deathsycthe");
		}
	}
}
