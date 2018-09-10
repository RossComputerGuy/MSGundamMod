package com.spaceboyross.gundam.entities.render;

import javax.annotation.Nonnull;

import com.spaceboyross.gundam.entities.EntityMasterAsia;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderMasterAsia extends RenderLiving<EntityMasterAsia> {

	private ResourceLocation texture = new ResourceLocation("gundam:textures/entity/master_asia.png");
	
	public static final Factory FACTORY = new Factory();
	
	public RenderMasterAsia(RenderManager rendermanagerIn) {
		super(rendermanagerIn,new ModelPlayer(1.0f,false),0.5F);
	}

	@Override
	@Nonnull
	protected ResourceLocation getEntityTexture(@Nonnull EntityMasterAsia entity) {
		return this.texture;
	}
	
	public static class Factory implements IRenderFactory<EntityMasterAsia> {
		@Override
		public Render<? super EntityMasterAsia> createRenderFor(RenderManager manager) {
			return new RenderMasterAsia(manager);
		}
	}
}
