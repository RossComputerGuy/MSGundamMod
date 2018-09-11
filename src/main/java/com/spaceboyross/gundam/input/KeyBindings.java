package com.spaceboyross.gundam.input;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class KeyBindings {
	
	public static KeyBinding callMobileFighter;
	public static KeyBinding useVernier;
	
	public static void init() {
		KeyBindings.callMobileFighter = new KeyBinding("key.call_mobile_fighter",Keyboard.KEY_M,"key.categories.gundam");
		KeyBindings.useVernier = new KeyBinding("key.use_vernier",Keyboard.KEY_V,"key.categories.gundam");
		
		ClientRegistry.registerKeyBinding(KeyBindings.callMobileFighter);
		ClientRegistry.registerKeyBinding(KeyBindings.useVernier);
	}
}