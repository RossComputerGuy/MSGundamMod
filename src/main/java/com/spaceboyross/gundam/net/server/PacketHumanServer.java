package com.spaceboyross.gundam.net.server;

import java.util.UUID;

import com.spaceboyross.gundam.capabilities.human.Human;
import com.spaceboyross.gundam.capabilities.interfaces.IHumanCapability;
import com.spaceboyross.gundam.enums.EHumantypes;
import com.spaceboyross.gundam.ms.MSRegistry;
import com.spaceboyross.gundam.ms.MobileSuit;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketHumanServer implements IMessage {
	
	private boolean shownHumantypeMenu = false;
	private int humantype = 0;
	private int msID = -1;
	
	public PacketHumanServer() {}
	
	public PacketHumanServer(IHumanCapability nt) {
		this.shownHumantypeMenu = nt.hasShownHumantypeMenu();
		this.humantype = nt.getHumantype().ordinal();
		if(nt.getMS() != null) this.msID = nt.getMS().getEntityId();
	}

    @Override
    public void fromBytes(ByteBuf buf) {
    	this.shownHumantypeMenu = buf.readBoolean();
    	this.humantype = buf.readInt();
    	this.msID = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf) {
    	buf.writeBoolean(this.shownHumantypeMenu);
    	buf.writeInt(this.humantype);
    	buf.writeInt(this.msID);
    }

    public static class Handler implements IMessageHandler<PacketHumanServer,IMessage> {
        @Override
        public IMessage onMessage(PacketHumanServer message,MessageContext ctx) {
            ctx.getServerHandler().player.getServerWorld().addScheduledTask(() -> handle(message,ctx));
            return null;
        }

        private void handle(PacketHumanServer message,MessageContext ctx) {
            EntityPlayerMP playerEntity = ctx.getServerHandler().player;
            World world = playerEntity.getEntityWorld();
            IHumanCapability nt = Human.getHuman(playerEntity);
            nt.setHasShownHumantypeMenu(message.shownHumantypeMenu);
            nt.setHumantype(EHumantypes.values()[message.humantype]);
            if(message.msID != -1) nt.setMS((MobileSuit.MSMob)world.getEntityByID(message.msID));
        }
    }
}