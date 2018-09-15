package com.spaceboyross.gundam.entities.render;

import net.minecraft.client.model.ModelPlayer;

import javax.annotation.Nonnull;

import com.spaceboyross.gundam.entities.EntityFullFrontal;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderFullFrontal extends RenderLiving<EntityFullFrontal> {

	private ResourceLocation texture = new ResourceLocation("gundam:textures/entity/full_frontal.png");
	
	public static final Factory FACTORY = new Factory();
	
	public RenderFullFrontal(RenderManager rendermanagerIn) {
		super(rendermanagerIn,new ModelPlayer(1.0f,false),0.5F);
	}

	@Override
	@Nonnull
	protected ResourceLocation getEntityTexture(@Nonnull EntityFullFrontal entity) {
		return this.texture;
	}
	
	public static class Factory implements IRenderFactory<EntityFullFrontal> {
		@Override
		public Render<? super EntityFullFrontal> createRenderFor(RenderManager manager) {
			return new RenderFullFrontal(manager);
		}
	}
}
