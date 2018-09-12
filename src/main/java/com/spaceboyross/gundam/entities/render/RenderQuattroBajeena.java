package com.spaceboyross.gundam.entities.render;

import net.minecraft.client.model.ModelPlayer;

import javax.annotation.Nonnull;

import com.spaceboyross.gundam.entities.EntityQuattroBajeena;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderQuattroBajeena extends RenderLiving<EntityQuattroBajeena> {

	private ResourceLocation texture = new ResourceLocation("gundam:textures/entity/quattro_bajeena.png");
	
	public static final Factory FACTORY = new Factory();
	
	public RenderQuattroBajeena(RenderManager rendermanagerIn) {
		super(rendermanagerIn,new ModelPlayer(1.0f,false),0.5F);
	}

	@Override
	@Nonnull
	protected ResourceLocation getEntityTexture(@Nonnull EntityQuattroBajeena entity) {
		return this.texture;
	}
	
	public static class Factory implements IRenderFactory<EntityQuattroBajeena> {
		@Override
		public Render<? super EntityQuattroBajeena> createRenderFor(RenderManager manager) {
			return new RenderQuattroBajeena(manager);
		}
	}
}