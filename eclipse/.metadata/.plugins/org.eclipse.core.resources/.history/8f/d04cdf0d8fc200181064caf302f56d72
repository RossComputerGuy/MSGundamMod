package com.spaceboyross.gundam.ms.gundams;

import com.spaceboyross.gundam.ms.MSRegistry;
import com.spaceboyross.gundam.ms.MobileSuit;
import com.spaceboyross.gundam.ms.armaments.BeamSaberMSArmament;
import com.spaceboyross.gundam.ms.armaments.VulcanGunMSArmament;
import com.spaceboyross.gundam.ms.gundams.GN001GundamExiaMobileSuit.MSMob;

import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ASWG08GundamBarbatosLupusMobileSuit extends MobileSuit {
	
	public ASWG08GundamBarbatosLupusMobileSuit() {
		this.setHeight(62.336f);
		this.setModel("ASW-G-08");
		this.setName("Gundam Barbatos Lupus");
		
		this.addRecipeItem("gundam:nanolaminate_armor",20);
	}
	
	@Override
	public int getCameraCount() {
		return 12;
	}
	
	@Override
	public MSMob createEntity(World worldIn,Vec3d pos) {
		MSMob mob = new ASWG08GundamBarbatosLupusMobileSuit.MSMob(worldIn);
		mob.setPosition(pos.x,pos.y,pos.z);
		return mob;
	}
	
	public static class MSMob extends MobileSuit.MSMob {
		public MSMob(World worldIn) {
			super(worldIn);
			this.scale = 6.9f;
			this.setSize(1.0f*this.scale,2.0f*this.scale);
		}
		
		@Override
		public MobileSuit getMSRegistryEntry() {
			return MSRegistry.getMobileSuit("ASW-G-08 Gundam Barbatos Lupus");
		}
	}
}
