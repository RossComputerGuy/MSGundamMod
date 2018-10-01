package com.spaceboyross.gundam.items.armor;

import com.spaceboyross.gundam.GundamMod;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CharAznableMaskItem extends ItemArmor {

	public CharAznableMaskItem() {
		super(ArmorMaterial.IRON,10,EntityEquipmentSlot.HEAD);
		this.setRegistryName("char_aznable_mask");
		this.setUnlocalizedName(GundamMod.MODID+".char_aznable_mask");
		this.setCreativeTab(GundamMod.tab);
		this.setMaxStackSize(1);
		this.canRepair = true;
	}
	
	@Override
	public CreativeTabs[] getCreativeTabs() {
		return new CreativeTabs[] {
			GundamMod.tab,CreativeTabs.COMBAT
		};
	}
	
	@SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this,0,new ModelResourceLocation(getRegistryName(),"inventory"));
	}

}
