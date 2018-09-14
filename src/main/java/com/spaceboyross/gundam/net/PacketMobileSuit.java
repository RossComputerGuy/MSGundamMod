package com.spaceboyross.gundam.net;

import java.lang.reflect.InvocationTargetException;

import com.spaceboyross.gundam.ms.MSRegistry;
import com.spaceboyross.gundam.ms.MobileSuit;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketMobileSuit implements IMessage {

	public int index = 0;
	public Vec3d pos = new Vec3d(0.0,0.0,0.0);

    @Override
    public void fromBytes(ByteBuf buf) {
    	this.index = buf.getIntLE(this.index);
    	this.pos = new Vec3d(buf.getDouble(1),buf.getDouble(2),buf.getDouble(3));
    	System.out.println(this.index);
    	System.out.println(this.pos.toString());
    }

    @Override
    public void toBytes(ByteBuf buf) {
    	buf.writeIntLE(this.index);
    	buf.writeDouble(this.pos.x);
    	buf.writeDouble(this.pos.y);
    	buf.writeDouble(this.pos.z);
    }

    public PacketMobileSuit() {
    }

    public static class Handler implements IMessageHandler<PacketMobileSuit,IMessage> {
        @Override
        public IMessage onMessage(PacketMobileSuit message, MessageContext ctx) {
            FMLCommonHandler.instance().getWorldThread(ctx.netHandler).addScheduledTask(() -> handle(message, ctx));
            return null;
        }

        private void handle(PacketMobileSuit message,MessageContext ctx) {
            EntityPlayerMP playerEntity = ctx.getServerHandler().player;
            World world = playerEntity.getEntityWorld();
            MobileSuit ms = MSRegistry.getMobileSuitFromIndex(message.index);
            try {
				MobileSuit.MSMob mob = ms.MOB.getConstructor(World.class).newInstance(world);
				mob.posX = message.pos.x+1.0;
				mob.posY = message.pos.y+1.0;
				mob.posZ = message.pos.z+1.0;
				world.spawnEntity(mob);
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			}
        }
    }
}
