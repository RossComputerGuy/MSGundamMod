package com.spaceboyross.gundam.utils;

import org.apache.commons.lang3.CharSet;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import io.netty.buffer.ByteBuf;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTException;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class InventoryUtils {
	public static IInventory load(NBTTagList list,IInventory inv) {
		for(int i = 0;i < inv.getSizeInventory();i++) inv.setInventorySlotContents(i,ItemStack.EMPTY);
		for(int i = 0;i < list.tagCount();i++) {
			NBTTagCompound item = list.getCompoundTagAt(i);
			int slot = item.getInteger("slot");
			if(slot >= 0 && slot < inv.getSizeInventory()) inv.setInventorySlotContents(slot,new ItemStack(item));
		}
		return inv;
	}
	
	public static ByteBuf toByteBuf(ByteBuf buf,IInventory inv) {
		String str = InventoryUtils.save(inv).toString();
		buf.writeInt(str.length());
		buf.writeBytes(str.getBytes());
		System.out.println(str);
		return buf;
	}
	
	public static IInventory fromByteBuf(ByteBuf buf) throws NBTException {
		IInventory inv = null;
		int nbtLength = buf.readInt();
		NBTTagCompound list = JsonToNBT.getTagFromJson(buf.readBytes(nbtLength).toString());
		System.out.println(list.toString());
		// TODO: determine the size
		// TODO: use the size to create a new inventory object
		// TODO: use InventoryUtils.load to load the new inventory
		return inv;
	}
	
	public static NBTTagList save(IInventory inv) {
		NBTTagList list = new NBTTagList();
		for(int i = 0;i < inv.getSizeInventory();i++) {
			ItemStack stack = inv.getStackInSlot(i);
			if(stack != null) {
				NBTTagCompound item = new NBTTagCompound();
				item.setInteger("slot",i);
				stack.writeToNBT(item);
				list.appendTag(item);
			}
		}
		System.out.println(list.toString());
		return list;
	}
}