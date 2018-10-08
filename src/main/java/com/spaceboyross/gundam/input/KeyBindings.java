package com.spaceboyross.gundam.input;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class KeyBindings {
	
	public static KeyBinding callMobileFighter;
	public static KeyBinding openMSInv;
	public static KeyBinding useVernier;
	public static KeyBinding runTestFN;
	
	public static void init() {
		KeyBindings.callMobileFighter = new KeyBinding("key.call_mobile_fighter",Keyboard.KEY_M,"key.categories.gundam");
		KeyBindings.openMSInv = new KeyBinding("key.open_ms_inv",Keyboard.KEY_I,"key.categories.gundam");
		KeyBindings.useVernier = new KeyBinding("key.use_vernier",Keyboard.KEY_V,"key.categories.gundam");
		KeyBindings.runTestFN = new KeyBinding("key.run_test_fn",Keyboard.KEY_MINUS,"key.categories.gundam");
		
		ClientRegistry.registerKeyBinding(KeyBindings.callMobileFighter);
		ClientRegistry.registerKeyBinding(KeyBindings.openMSInv);
		ClientRegistry.registerKeyBinding(KeyBindings.useVernier);
		ClientRegistry.registerKeyBinding(KeyBindings.runTestFN);
	}
}