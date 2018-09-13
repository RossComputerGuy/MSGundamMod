package com.spaceboyross.gundam.ms.zeon;

import com.spaceboyross.gundam.ms.MobileSuit;

import net.minecraft.world.World;

public class MS05AZaku1EarlyTypeMobileSuit extends MobileSuit {
	
	public MS05AZaku1EarlyTypeMobileSuit() {
		this.setHeight(57.415f);
		this.setModel("MS-05A");
		this.setName("Zaku I Early Type");
		
		this.addRecipeItem("gundam:super_hard_steel_ingot",20);
		
		this.MOB = MS05AZaku1EarlyTypeMobileSuit.MSMob.class;
	}
	
	public static class MSMob extends MobileSuit.MSMob {
		public MSMob(World worldIn) {
			super(worldIn);
			this.scale = 4.8f;
			this.setSize(1.0f*this.scale,2.0f*this.scale);
		}
	}
}