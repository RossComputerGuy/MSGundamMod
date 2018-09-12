package com.spaceboyross.gundam;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class GundamTab extends CreativeTabs {

	public GundamTab(String label) {
		super(label);
	}

	@Override
	public ItemStack getTabIconItem() {
		return GundamItems.lunaTitaniumIngot.getDefaultInstance();
	}

}