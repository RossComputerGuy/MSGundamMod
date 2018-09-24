package com.spaceboyross.gundam.ms.fighters;

import com.spaceboyross.gundam.ms.MSRegistry;
import com.spaceboyross.gundam.ms.MobileFighter;
import com.spaceboyross.gundam.ms.MobileSuit;
import com.spaceboyross.gundam.ms.armaments.VulcanGunMSArmament;
import com.spaceboyross.gundam.ms.fighters.GF13017NJIIGodGundamMobileFighter.MSMob;

import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class GF13017NJShiningGundamMobileFighter  extends MobileFighter {
	
	public GF13017NJShiningGundamMobileFighter() {
		this.setHeight(54.462f);
		this.setModel("GF13-017NJ");
		this.setName("Shining Gundam");
		
		this.addArmament(new VulcanGunMSArmament(2,60));
		
		this.addRecipeItem("gundam:gundarium_beta_ingot",20);
	}
	
	@Override
	public int getCameraCount() {
		return 12;
	}
	
	@Override
	public MSMob createEntity(World worldIn,Vec3d pos) {
		MSMob mob = new GF13017NJShiningGundamMobileFighter.MSMob(worldIn);
		mob.setPosition(pos.x,pos.y,pos.z);
		return mob;
	}
	
	public static class MSMob extends MobileFighter.MSMob {
		public MSMob(World worldIn) {
			super(worldIn);
			this.scale = 6.5f;
			this.setSize(1.0f*this.scale,2.0f*this.scale);
		}
		
		@Override
		public MobileSuit getMSRegistryEntry() {
			return MSRegistry.getMobileSuit("GF13-017NJ Shining Gundam");
		}
	}
}
