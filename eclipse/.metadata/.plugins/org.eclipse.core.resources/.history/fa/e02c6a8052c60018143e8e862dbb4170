package com.spaceboyross.gundam.ms.eff;

import com.spaceboyross.gundam.ms.MSRegistry;
import com.spaceboyross.gundam.ms.MobileSuit;
import com.spaceboyross.gundam.ms.armaments.BeamSaberMSArmament;
import com.spaceboyross.gundam.ms.armaments.VulcanGunMSArmament;
import com.spaceboyross.gundam.ms.gundams.RX782GundamMobileSuit;

import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class RGM79GGMGroundTypeMobileSuit extends MobileSuit {
	
	public RGM79GGMGroundTypeMobileSuit() {
		this.setHeight(59.055f);
		this.setModel("RGM-79 [G]");
		this.setName("GM Ground Type");
		
		this.addArmament(new BeamSaberMSArmament(2));
		
		this.addRecipeItem("gundam:luna_titanium_ingot",20);
	}
	
	@Override
	public int getCameraCount() {
		return 12;
	}
	
	@Override
	public MSEntity createEntity(World worldIn,Vec3d pos) {
		MSEntity mob = new RGM79GGMGroundTypeMobileSuit.MSEntity(worldIn);
		mob.setPosition(pos.x,pos.y,pos.z);
		return mob;
	}
	
	public static class MSEntity extends MobileSuit.MSEntity {
		public MSEntity(World worldIn) {
			super(worldIn);
			this.scale = 6.65333333333f;
			this.setSize(1.0f*this.scale,2.0f*this.scale);
		}
		
		@Override
		public MobileSuit getMSRegistryEntry() {
			return MSRegistry.getMobileSuit("RGM-79 [G] GM Ground Type");
		}
	}
}
