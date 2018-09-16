package com.spaceboyross.gundam.blocks;

import com.spaceboyross.gundam.GundamMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MoonRockBlock extends Block {

	public MoonRockBlock() {
		super(Material.CLAY);
		this.setUnlocalizedName(GundamMod.MODID+".moon_rock");
		this.setRegistryName("moon_rock");
		this.setCreativeTab(GundamMod.tab);
	}
	
	@SideOnly(Side.CLIENT)
	public void initModel() {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this),0,new ModelResourceLocation(this.getRegistryName(),"inventory"));
	}

}
