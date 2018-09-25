package com.spaceboyross.gundam.ms.eff;

import com.spaceboyross.gundam.ms.MSRegistry;
import com.spaceboyross.gundam.ms.MobileSuit;
import com.spaceboyross.gundam.ms.armaments.BeamSaberMSArmament;
import com.spaceboyross.gundam.ms.armaments.VulcanGunMSArmament;
import com.spaceboyross.gundam.ms.eff.RGM79GGMGroundTypeMobileSuit.MSMob;

import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class RGM79GMMobileSuit extends MobileSuit {
	
	public RGM79GMMobileSuit() {
		this.setHeight(59.055f);
		this.setModel("RGM-79");
		this.setName("GM");

		this.addArmament(new VulcanGunMSArmament(2,60));
		this.addArmament(new BeamSaberMSArmament(2));
		
		this.addRecipeItem("gundam:luna_titanium_ingot",20);
	}
	
	@Override
	public int getCameraCount() {
		return 12;
	}
	
	@Override
	public MSMob createEntity(World worldIn,Vec3d pos) {
		MSMob mob = new RGM79GMMobileSuit.MSMob(worldIn);
		mob.setPosition(pos.x,pos.y,pos.z);
		return mob;
	}
	
	public static class MSMob extends MobileSuit.MSMob {
		public MSMob(World worldIn) {
			super(worldIn);
			this.scale = 6.65333333333f;
			this.setSize(1.0f*this.scale,2.0f*this.scale);
		}
		
		@Override
		public MobileSuit getMSRegistryEntry() {
			return MSRegistry.getMobileSuit("RGM-79 GM");
		}
	}
}