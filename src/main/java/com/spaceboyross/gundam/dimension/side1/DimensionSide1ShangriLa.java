package com.spaceboyross.gundam.dimension.side1;

import com.spaceboyross.gundam.GundamDimensions;

import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;

public class DimensionSide1ShangriLa extends WorldProvider {

	@Override
	public DimensionType getDimensionType() {
		return GundamDimensions.side1ShangriLa;
	}
	
	@Override
	public String getSaveFolder() {
		return "GUNDAM_SIDE1_SHANGRILA";
	}

}