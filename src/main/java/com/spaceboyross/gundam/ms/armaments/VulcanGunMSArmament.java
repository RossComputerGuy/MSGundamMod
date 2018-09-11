package com.spaceboyross.gundam.ms.armaments;

import com.spaceboyross.gundam.ms.MobileSuitArmament;

public class VulcanGunMSArmament extends MobileSuitArmament {
	
	private int mm;
	
	public VulcanGunMSArmament(int count,int mm) {
		super(count);
		
		this.setName("Vulcan Gun");
		this.mm = mm;
	}
	
	public int getAmmoSize() {
		return this.mm;
	}
	
	public String toString() {
		return this.getCount()+" × "+this.getAmmoSize()+"mm "+this.getName();
	}
}