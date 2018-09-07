package com.spaceboyross.gundam;

import net.minecraft.item.Item;

/**
 * This is the base class for items.
 */
public abstract class AbstractItem extends Item {
	
	public AbstractItem(String name) {
		this.setRegistryName(name);
		this.setUnlocalizedName(GundamMod.MODID+"."+name);
	}
}