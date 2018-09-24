package com.spaceboyross.gundam.net.server;

import com.spaceboyross.gundam.capabilities.human.Human;
import com.spaceboyross.gundam.capabilities.interfaces.IHumanCapability;
import com.spaceboyross.gundam.enums.EHumantypes;
import com.spaceboyross.gundam.ms.MobileSuit;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketDimensionServer implements IMessage {
	
	private int id = 0;
	
	public PacketDimensionServer() {}
	
	public PacketDimensionServer(int id) {
		this.id = id;
	}

    @Override
    public void fromBytes(ByteBuf buf) {
    	this.id = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf) {
    	buf.writeInt(this.id);
    }

    public static class Handler implements IMessageHandler<PacketDimensionServer,IMessage> {
        @Override
        public IMessage onMessage(PacketDimensionServer message,MessageContext ctx) {
            ctx.getServerHandler().player.getServerWorld().addScheduledTask(() -> handle(message,ctx));
            return null;
        }

        private void handle(PacketDimensionServer message,MessageContext ctx) {
            EntityPlayerMP playerEntity = ctx.getServerHandler().player;
            playerEntity.changeDimension(message.id);
        }
    }
}
