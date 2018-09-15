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
    	this.index = buf.readInt();
    	this.pos = new Vec3d(buf.readDouble(),buf.readDouble(),buf.readDouble());
    	System.out.println(this.index);
    	System.out.println(this.pos.toString());
    }

    @Override
    public void toBytes(ByteBuf buf) {
    	buf.writeInt(this.index);
    	buf.writeDouble(this.pos.x);
    	buf.writeDouble(this.pos.y);
    	buf.writeDouble(this.pos.z);
    }

    public PacketMobileSuit() {
    }

    public static class Handler implements IMessageHandler<PacketMobileSuit,IMessage> {
        @Override
        public IMessage onMessage(PacketMobileSuit message,MessageContext ctx) {
            ctx.getServerHandler().player.getServerWorld().addScheduledTask(() -> handle(message,ctx));
            return null;
        }

        private void handle(PacketMobileSuit message,MessageContext ctx) {
            EntityPlayerMP playerEntity = ctx.getServerHandler().player;
            World world = playerEntity.getEntityWorld();
            MobileSuit ms = MSRegistry.getMobileSuitFromIndex(message.index);
			world.spawnEntity(ms.createEntity(world,new Vec3d(message.pos.x+1.0,message.pos.y+1.0,message.pos.z+1.0)));
        }
    }
}
