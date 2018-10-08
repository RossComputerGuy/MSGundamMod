package com.spaceboyross.gundam.utils;

import java.util.Map;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import net.minecraft.nbt.NBTTagCompound;

public class NBTUtilities {
	
	public static Object[] nbtToObjectArray(NBTTagCompound nbt) {
		Object[] obj = new Object[nbt.getKeySet().size()];
		JsonParser parser = new JsonParser();
		JsonElement elem = parser.parse(nbt.toString());
		int i = 0;
		for(Map.Entry<String,JsonElement> e : elem.getAsJsonObject().entrySet()) {
			obj[i++] = e.getValue().getAsString();
		}
		return obj;
	}
}