package com.spaceboyross.gundam.ms.zeon;

import com.spaceboyross.gundam.ms.MSRegistry;
import com.spaceboyross.gundam.ms.MobileSuit;
import com.spaceboyross.gundam.ms.gundams.RX782GundamMobileSuit;
import com.spaceboyross.gundam.ms.gundams.RX782GundamMobileSuit.MSEntity;

import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class MS04PrototypeZakuMobileSuit extends MobileSuit {
	
	public MS04PrototypeZakuMobileSuit() {
		this.setHeight(57.415f);
		this.setModel("MS-04");
		this.setName("Prototype Zaku");
		
		this.addRecipeItem("gundam:super_hard_steel_ingot",20);
	}
	
	@Override
	public MSEntity createEntity(World worldIn,Vec3d pos) {
		MSEntity mob = new MS04PrototypeZakuMobileSuit.MSEntity(worldIn);
		mob.setPosition(pos.x,pos.y,pos.z);
		return mob;
	}
	
	public static class MSEntity extends MobileSuit.MSEntity {
		public MSEntity(World worldIn) {
			super(worldIn);
			this.scale = 6.4f;
			this.setSize(1.0f*this.scale,2.0f*this.scale);
		}
		
		@Override
		public MobileSuit getMSRegistryEntry() {
			return MSRegistry.getMobileSuit("MS-04 Prototype Zaku");
		}
	}

}
