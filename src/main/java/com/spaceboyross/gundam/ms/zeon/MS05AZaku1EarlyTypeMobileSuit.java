package com.spaceboyross.gundam.ms.zeon;

import com.spaceboyross.gundam.ms.MSRegistry;
import com.spaceboyross.gundam.ms.MobileSuit;
import com.spaceboyross.gundam.ms.zeon.MS04PrototypeZakuMobileSuit.MSMob;

import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class MS05AZaku1EarlyTypeMobileSuit extends MobileSuit {
	
	public MS05AZaku1EarlyTypeMobileSuit() {
		this.setHeight(57.415f);
		this.setModel("MS-05A");
		this.setName("Zaku I Early Type");
		
		this.addRecipeItem("gundam:super_hard_steel_ingot",20);
	}
	
	@Override
	public MSMob createEntity(World worldIn,Vec3d pos) {
		MSMob mob = new MS05AZaku1EarlyTypeMobileSuit.MSMob(worldIn);
		mob.setPosition(pos.x,pos.y,pos.z);
		return mob;
	}
	
	public static class MSMob extends MobileSuit.MSMob {
		public MSMob(World worldIn) {
			super(worldIn);
			this.scale = 6.4f;
			this.setSize(1.0f*this.scale,2.0f*this.scale);
		}
		
		@Override
		public MobileSuit getMSRegistryEntry() {
			return MSRegistry.getMobileSuit("MS-05A Zaku I Early Type");
		}
	}
}