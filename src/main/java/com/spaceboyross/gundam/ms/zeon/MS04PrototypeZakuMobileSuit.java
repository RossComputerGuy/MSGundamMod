package com.spaceboyross.gundam.ms.zeon;

import com.spaceboyross.gundam.ms.MobileSuit;

import net.minecraft.world.World;

public class MS04PrototypeZakuMobileSuit extends MobileSuit {
	
	public MS04PrototypeZakuMobileSuit() {
		this.setHeight(57.415f);
		this.setModel("MS-04");
		this.setName("Prototype Zaku");
		
		this.addRecipeItem("gundam:super_hard_steel_ingot",20);
		
		this.MOB = MS04PrototypeZakuMobileSuit.MSMob.class;
	}
	
	public static class MSMob extends MobileSuit.MSMob {
		public MSMob(World worldIn) {
			super(worldIn);
			this.scale = 4.8f;
			this.setSize(1.0f*this.scale,2.0f*this.scale);
		}
	}

}
