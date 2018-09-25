package com.spaceboyross.gundam.net.server;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketEntitySyncServer implements IMessage {
	
	private int id = 0;
	private int air = 0;
	
	public PacketEntitySyncServer() {}
	
	public PacketEntitySyncServer(Entity entity) {
		this.id = entity.getEntityId();
		this.air = entity.getAir();
	}

    @Override
    public void fromBytes(ByteBuf buf) {
    	this.id = buf.readInt();
    	this.air = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf) {
    	buf.writeInt(this.id);
    	buf.writeInt(this.air);
    }

    public static class Handler implements IMessageHandler<PacketEntitySyncServer,IMessage> {
        @Override
        public IMessage onMessage(PacketEntitySyncServer message,MessageContext ctx) {
            ctx.getServerHandler().player.getServerWorld().addScheduledTask(() -> handle(message,ctx));
            return null;
        }

        private void handle(PacketEntitySyncServer message,MessageContext ctx) {
            World world = ctx.getServerHandler().player.getServerWorld();
            Entity entity = world.getEntityByID(message.id);
            if(entity != null) entity.setAir(message.air);
        }
    }
}