package com.spaceboyross.gundam.net;

import com.spaceboyross.gundam.net.client.PacketGUI;
import com.spaceboyross.gundam.net.client.PacketHumanClient;
import com.spaceboyross.gundam.net.server.PacketDimensionServer;
import com.spaceboyross.gundam.net.server.PacketEntitySyncServer;
import com.spaceboyross.gundam.net.server.PacketHumanServer;
import com.spaceboyross.gundam.net.server.PacketMobileSuit;

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
        PacketHandler.INSTANCE.registerMessage(PacketDimensionServer.Handler.class,PacketDimensionServer.class,PacketHandler.nextID(),Side.SERVER);
        PacketHandler.INSTANCE.registerMessage(PacketEntitySyncServer.Handler.class,PacketEntitySyncServer.class,PacketHandler.nextID(),Side.SERVER);
        PacketHandler.INSTANCE.registerMessage(PacketHumanServer.Handler.class,PacketHumanServer.class,PacketHandler.nextID(),Side.SERVER);
        PacketHandler.INSTANCE.registerMessage(PacketMobileSuit.Handler.class,PacketMobileSuit.class,PacketHandler.nextID(),Side.SERVER);
        
        PacketHandler.INSTANCE.registerMessage(PacketGUI.Handler.class,PacketGUI.class,PacketHandler.nextID(),Side.CLIENT);
        PacketHandler.INSTANCE.registerMessage(PacketHumanClient.Handler.class,PacketHumanClient.class,PacketHandler.nextID(),Side.CLIENT);
    }
}
