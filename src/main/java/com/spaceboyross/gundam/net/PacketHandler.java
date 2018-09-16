package com.spaceboyross.gundam.net;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class PacketHandler {
	private static int packetId = 0;

    public static SimpleNetworkWrapper INSTANCE = null;

    public PacketHandler() {
    }

    public static int nextID() {
        return PacketHandler.packetId++;
    }

    public static void registerMessages(String channelName) {
    	PacketHandler.INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(channelName);
    	PacketHandler.registerMessages();
    }

    public static void registerMessages() {
        PacketHandler.INSTANCE.registerMessage(PacketMobileSuit.Handler.class,PacketMobileSuit.class,PacketHandler.nextID(),Side.SERVER);
        PacketHandler.INSTANCE.registerMessage(PacketHumantype.Handler.class,PacketHumantype.class,PacketHandler.nextID(),Side.CLIENT);
        PacketHandler.INSTANCE.registerMessage(PacketNewtype.Handler.class,PacketNewtype.class,PacketHandler.nextID(),Side.SERVER);
    }
}
