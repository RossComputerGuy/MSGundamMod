package com.spaceboyross.gundam.ms.gundams;

import com.spaceboyross.gundam.GundamItems;
import com.spaceboyross.gundam.ms.MSRegistry;
import com.spaceboyross.gundam.ms.MobileSuit;

import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class GX9901DXGundamDoubleXMobileSuit extends MobileSuit {
	
	public GX9901DXGundamDoubleXMobileSuit() {
		this.setHeight(55.774f);
		this.setModel("GX-9901-DX");
		this.setName("Gundam Double X");
		
		this.addRecipeItem("gundam:luna_titanium_ingot",20);
	}
	
	@Override
	public int getCameraCount() {
		return 12;
	}
	
	@Override
	public MSEntity createEntity(World worldIn,Vec3d pos) {
		MSEntity mob = new GX9901DXGundamDoubleXMobileSuit.MSEntity(worldIn);
		mob.setPosition(pos.x,pos.y,pos.z);
		return mob;
	}
	
	@Override
	public ItemStack getRequiredItemToPilot() {
		return GundamItems.gController.getDefaultInstance();
	}
	
	public static class MSEntity extends MobileSuit.MSEntity {
		public MSEntity(World worldIn) {
			super(worldIn);
			this.scale = 6.55f;
			this.setSize(1.0f*this.scale,2.0f*this.scale);
		}
		
		@Override
		public MobileSuit getMSRegistryEntry() {
			return MSRegistry.getMobileSuit("GX-9901-DX Gundam Double X");
		}
	}
}
