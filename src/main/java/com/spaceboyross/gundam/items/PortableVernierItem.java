package com.spaceboyross.gundam.items;

import com.spaceboyross.gundam.GundamMod;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PortableVernierItem extends ItemArmor {

	public PortableVernierItem() {
		super(ArmorMaterial.IRON,10,EntityEquipmentSlot.CHEST);
		this.setRegistryName("portable_vernier");
		this.setUnlocalizedName(GundamMod.MODID+".portable_vernier");
		this.setCreativeTab(GundamMod.tab);
		this.setMaxStackSize(1);
		this.canRepair = true;
	}
	
	@Override
	public CreativeTabs[] getCreativeTabs() {
		return new CreativeTabs[] {
			GundamMod.tab,CreativeTabs.TOOLS,CreativeTabs.TRANSPORTATION
		};
	}
	
	@SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this,0,new ModelResourceLocation(getRegistryName(), "inventory"));
	}

}
