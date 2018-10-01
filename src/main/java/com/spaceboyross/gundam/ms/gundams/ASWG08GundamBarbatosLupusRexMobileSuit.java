package com.spaceboyross.gundam.ms.gundams;

import com.spaceboyross.gundam.ms.MSRegistry;
import com.spaceboyross.gundam.ms.MobileSuit;
import com.spaceboyross.gundam.ms.gundams.ASWG08GundamBarbatosLupusMobileSuit.MSEntity;

import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ASWG08GundamBarbatosLupusRexMobileSuit extends MobileSuit {
	
	public ASWG08GundamBarbatosLupusRexMobileSuit() {
		this.setHeight(62.336f);
		this.setModel("ASW-G-08");
		this.setName("Gundam Barbatos Lupus Rex");
		
		this.addRecipeItem("gundam:nanolaminate_armor",20);
	}
	
	@Override
	public int getCameraCount() {
		return 12;
	}
	
	@Override
	public MSEntity createEntity(World worldIn,Vec3d pos) {
		MSEntity mob = new ASWG08GundamBarbatosLupusRexMobileSuit.MSEntity(worldIn);
		mob.setPosition(pos.x,pos.y,pos.z);
		return mob;
	}
	
	public static class MSEntity extends MobileSuit.MSEntity {
		public MSEntity(World worldIn) {
			super(worldIn);
			this.scale = 6.9f;
			this.setSize(1.0f*this.scale,2.0f*this.scale);
		}
		
		@Override
		public MobileSuit getMSRegistryEntry() {
			return MSRegistry.getMobileSuit("ASW-G-08 Gundam Barbatos Lupus Rex");
		}
	}
}
