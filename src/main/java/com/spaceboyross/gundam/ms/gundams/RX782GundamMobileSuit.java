package com.spaceboyross.gundam.ms.gundams;

import com.spaceboyross.gundam.GundamItems;
import com.spaceboyross.gundam.models.ms.gundams.RX782GundamMobileSuitModel;
import com.spaceboyross.gundam.ms.MSRegistry;
import com.spaceboyross.gundam.ms.MobileSuit;

import net.minecraft.client.model.ModelBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RX782GundamMobileSuit extends MobileSuit {
	
	public RX782GundamMobileSuit() {
		this.setHeight(60.696f);
		this.setModel("RX-78-2");
		this.setName("Gundam");
		
		this.addRecipeItem("gundam:luna_titanium_ingot",20);
	}
	
	@Override
	public void init() {
		this.addArmament(GameRegistry.makeItemStack("gundam:ms_armament_vulcans",0,2,"{size:60}"));
		this.addArmament(GameRegistry.makeItemStack("gundam:ms_armament_beam_saber",0,2,""));
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
