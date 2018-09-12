package com.spaceboyross.gundam.ms;

import java.util.HashMap;
import java.util.Map;

public class MSRegistry {
	
	private static Map<String,MobileSuit> registry = new HashMap<>();
	
	public static void register(MobileSuit ms) {
		if(MSRegistry.registry.containsKey(ms.getModel())) return;
		MSRegistry.registry.put(ms.getModel(),ms);
	}
	
	public static MobileSuit getMobileSuit(String name) {
		return MSRegistry.registry.get(name);
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