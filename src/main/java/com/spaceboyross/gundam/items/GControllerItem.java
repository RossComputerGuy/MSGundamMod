package com.spaceboyross.gundam.items;

import com.spaceboyross.gundam.GundamMod;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GControllerItem extends Item {

	public GControllerItem() {
		this.setRegistryName("g_controller");
		this.setUnlocalizedName(GundamMod.MODID+".g_controller");
		this.setCreativeTab(GundamMod.tab);
	}
	
	@SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this,0,new ModelResourceLocation(getRegistryName(), "inventory"));
	}

}