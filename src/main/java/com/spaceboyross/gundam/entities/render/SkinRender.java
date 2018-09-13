package com.spaceboyross.gundam.entities.render;

import javax.annotation.Nonnull;

import com.spaceboyross.gundam.entities.EntityAmuroRay;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class SkinRender extends RenderLiving<EntityLiving> {
	
	private ResourceLocation texture;
	
	public SkinRender(RenderManager rendermanagerIn,ResourceLocation texture) {
		super(rendermanagerIn,new ModelPlayer(1.0f,false),0.5F);
		this.texture = texture;
	}

	@Override
	@Nonnull
	protected ResourceLocation getEntityTexture(@Nonnull EntityLiving entity) {
		return this.texture;
	}
	
	public static class Factory implements IRenderFactory<EntityLiving> {
		
		private ResourceLocation texture;
		
		public Factory(ResourceLocation texture) {
			this.texture = texture;
		}
		
		@Override
		public Render<? super EntityLiving> createRenderFor(RenderManager manager) {
			return new SkinRender(manager,this.texture);
		}
	}
}