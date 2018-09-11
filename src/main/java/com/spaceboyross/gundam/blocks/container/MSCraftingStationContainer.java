package com.spaceboyross.gundam.blocks.container;

import com.spaceboyross.gundam.blocks.tile.MSCraftingStationTileEntity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;

public class MSCraftingStationContainer extends Container {
	
	private MSCraftingStationTileEntity te;
	
	public MSCraftingStationContainer(IInventory playerInventory,MSCraftingStationTileEntity te) {
		this.te = te;
	}

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return this.te.canInteractWith(playerIn);
	}

}
