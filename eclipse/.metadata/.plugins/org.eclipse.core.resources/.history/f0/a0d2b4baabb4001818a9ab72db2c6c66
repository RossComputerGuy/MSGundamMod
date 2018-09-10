package com.spaceboyross.gundam.entities.render;

import javax.annotation.Nonnull;

import com.spaceboyross.gundam.entities.EntityDomonKasshu;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderDomonKasshu extends RenderLiving<EntityDomonKasshu> {

	private ResourceLocation texture = new ResourceLocation("gundam:textures/entity/domon_kasshu.png");
	
	public static final Factory FACTORY = new Factory();
	
	public RenderDomonKasshu(RenderManager rendermanagerIn) {
		super(rendermanagerIn,new ModelPlayer(1.0f,false),0.5F);
	}

	@Override
	@Nonnull
	protected ResourceLocation getEntityTexture(@Nonnull EntityDomonKasshu entity) {
		return this.texture;
	}
	
	public static class Factory implements IRenderFactory<EntityDomonKasshu> {
		@Override
		public Render<? super EntityDomonKasshu> createRenderFor(RenderManager manager) {
			return new RenderDomonKasshu(manager);
		}
	}
}
