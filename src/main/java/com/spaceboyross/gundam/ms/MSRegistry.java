package com.spaceboyross.gundam.ms;

import java.util.HashMap;
import java.util.Map;

import com.spaceboyross.gundam.GundamEntities;
import com.spaceboyross.gundam.GundamMod;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class MSRegistry {
	
	private static Map<String,MobileSuit> registry = new HashMap<>();
	
	public static void register(MobileSuit ms) {
		if(MSRegistry.registry.containsKey(ms.getModel())) return;
		MSRegistry.registry.put(ms.getModel(),ms);
		
		EntityRegistry.registerModEntity(new ResourceLocation(GundamMod.MODID,(ms.getModel()+" "+ms.getName()).replaceAll(" ","_").toLowerCase()),ms.createEntity(null,new Vec3d(0.0,0.0,0.0)).getClass(),(ms.getModel()+"_"+ms.getName()).replaceAll(" ","_"),GundamEntities.ID++,GundamMod.instance,64,3,true,0x996600+(GundamEntities.ID-1),0x00ff00+(GundamEntities.ID-1));
		EntityRegistry.registerEgg(new ResourceLocation(GundamMod.MODID,""),0x996600+(GundamEntities.ID-1),0x00ff00+(GundamEntities.ID-1));
		RenderingRegistry.registerEntityRenderingHandler(ms.createEntity(null,new Vec3d(0.0,0.0,0.0)).getClass(),ms.FACTORY);
	}
	
	public static MobileSuit getMobileSuit(String name) {
		return MSRegistry.registry.get(name);
	}
	
	public static int getMobileSuitIndex(MobileSuit ms) {
		String keys[] = new String[MSRegistry.registry.keySet().size()];
		keys = MSRegistry.registry.keySet().toArray(keys);
		for(int i = 0;i < MSRegistry.registry.size();i++) {
			if(keys[i].equals(ms.getModel())) return i;
		}
		return -1;
	}
	
	public static MobileSuit getMobileSuitFromIndex(int i) {
		MobileSuit ms[] = new MobileSuit[MSRegistry.registry.values().size()];
		ms = MSRegistry.registry.values().toArray(ms);
		return ms[i];
	}
	
	public static int getCount() {
		return MSRegistry.registry.size();
	}
}
