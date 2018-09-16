package com.spaceboyross.gundam.blocks;

import com.spaceboyross.gundam.GundamMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class LunaTitaniumBlock extends Block {
	
	public LunaTitaniumBlock() {
		super(Material.IRON);
		this.setUnlocalizedName(GundamMod.MODID+".luna_titanium_block");
		this.setRegistryName("luna_titanium_block");
		this.setCreativeTab(GundamMod.tab);
	}
	
	@SideOnly(Side.CLIENT)
	public void initModel() {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this),0,new ModelResourceLocation(this.getRegistryName(),"inventory"));
	}
}