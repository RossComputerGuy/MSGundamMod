package com.spaceboyross.gundam.ms.gundams;

import com.spaceboyross.gundam.models.ms.gundams.RX782GundamMobileSuitModel;
import com.spaceboyross.gundam.ms.MSRegistry;
import com.spaceboyross.gundam.ms.MobileSuit;
import com.spaceboyross.gundam.ms.armaments.BeamSaberMSArmament;
import com.spaceboyross.gundam.ms.armaments.VulcanGunMSArmament;

import net.minecraft.client.model.ModelBase;
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
	public ModelBase createModel() {
		return new RX782GundamMobileSuitModel();
	}
	
	@Override
	public int getCameraCount() {
		return 12;
	}
	
	@Override
	public MSEntity createEntity(World worldIn,Vec3d pos) {
		MSEntity mob = new RX782GundamMobileSuit.MSEntity(worldIn);
		mob.setPosition(pos.x,pos.y,pos.z);
		return mob;
	}
	
	public static class MSEntity extends MobileSuit.MSEntity {
		public MSEntity(World worldIn) {
			super(worldIn);
			this.scale = 1.0f;
			this.setSize(10.0f*this.scale,30.0f);
		}
		
		@Override
		public MobileSuit getMSRegistryEntry() {
			return MSRegistry.getMobileSuit("RX-78-2 Gundam");
		}
	}
}
