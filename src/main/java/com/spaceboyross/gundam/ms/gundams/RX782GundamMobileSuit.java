package com.spaceboyross.gundam.ms.gundams;

import com.spaceboyross.gundam.ms.MobileSuit;
import com.spaceboyross.gundam.ms.MobileSuit.MSMob;
import com.spaceboyross.gundam.ms.armaments.BeamSaberMSArmament;
import com.spaceboyross.gundam.ms.armaments.VulcanGunMSArmament;

import net.minecraft.entity.monster.EntityMob;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class RX782GundamMobileSuit extends MobileSuit {
	
	public RX782GundamMobileSuit() {
		this.setHeight(60.696f);
		this.setModel("RX-78-2");
		this.setName("Gundam");
		
		this.addArmament(new VulcanGunMSArmament(2,60));
		this.addArmament(new BeamSaberMSArmament(2));
		
		this.addRecipeItem("gundam:luna_titanium_ingot",20);
	}
	
	@Override
	public MSMob createEntity(World worldIn,Vec3d pos) {
		MSMob mob = new RX782GundamMobileSuit.MSMob(worldIn);
		mob.setPosition(pos.x,pos.y,pos.z);
		return mob;
	}
	
	public static class MSMob extends MobileSuit.MSMob {
		public MSMob(World worldIn) {
			super(worldIn);
			this.scale = 5.0f;
			this.setSize(1.0f*this.scale,2.0f*this.scale);
		}
	}
}
