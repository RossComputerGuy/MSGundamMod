package com.spaceboyross.gundam.ms.gundams;

import com.spaceboyross.gundam.ms.MobileSuit;
import com.spaceboyross.gundam.ms.armaments.BeamSaberMSArmament;
import com.spaceboyross.gundam.ms.armaments.VulcanGunMSArmament;

public class RX782GundamMobileSuit extends MobileSuit {
	
	public RX782GundamMobileSuit() {
		super();
		
		this.setModel("RX-78-2");
		this.setName("Gundam");
		
		this.addArmament(new VulcanGunMSArmament(2,60));
		this.addArmament(new BeamSaberMSArmament(2));
		
		this.addRecipeItem("gundam:luna_titanium_ingot",20);
	}
}