package com.spaceboyross.gundam;

import com.spaceboyross.gundam.entities.EntityAmuroRay;
import com.spaceboyross.gundam.entities.EntityBrightNoa;
import com.spaceboyross.gundam.entities.EntityCharAznable;
import com.spaceboyross.gundam.entities.EntityDomonKasshu;
import com.spaceboyross.gundam.entities.EntityFullFrontal;
import com.spaceboyross.gundam.entities.EntityMasterAsia;
import com.spaceboyross.gundam.entities.EntityQuattroBajeena;
import com.spaceboyross.gundam.entities.render.SkinRender;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GundamEntities {
	
	public static int ID = 1;
	
	public static void init() {
		int id = 1;

		EntityRegistry.registerModEntity(new ResourceLocation(GundamMod.MODID,"amuro_ray"),EntityAmuroRay.class,"AmuroRay",id++,GundamMod.instance,64,3,true,0x996600,0x00ff00);
		EntityRegistry.registerModEntity(new ResourceLocation(GundamMod.MODID,"bright_noa"),EntityBrightNoa.class,"BrightNoa",id++,GundamMod.instance,64,3,true,0x996600,0x00ff00);
		EntityRegistry.registerModEntity(new ResourceLocation(GundamMod.MODID,"char_aznable"),EntityCharAznable.class,"CharAznable",id++,GundamMod.instance,64,3,true,0x996600,0x00ff00);
		EntityRegistry.registerModEntity(new ResourceLocation(GundamMod.MODID,"domon_kasshu"),EntityDomonKasshu.class,"DomonKasshu",id++,GundamMod.instance,64,3,true,0x996600,0x00ff00);
		EntityRegistry.registerModEntity(new ResourceLocation(GundamMod.MODID,"full_frontal"),EntityFullFrontal.class,"FullFrontal",id++,GundamMod.instance,64,3,true,0x996600,0x00ff00);
		EntityRegistry.registerModEntity(new ResourceLocation(GundamMod.MODID,"master_asia"),EntityMasterAsia.class,"MasterAsia",id++,GundamMod.instance,64,3,true,0x996600,0x00ff00);
		EntityRegistry.registerModEntity(new ResourceLocation(GundamMod.MODID,"quattro_bajeena"),EntityQuattroBajeena.class,"QuattroBajeena",id++,GundamMod.instance,64,3,true,0x996600,0x00ff00);
		ID = id;
	}
	
	@SideOnly(Side.CLIENT)
	public static void initModels() {
		RenderingRegistry.registerEntityRenderingHandler(EntityAmuroRay.class,new SkinRender.Factory(new ResourceLocation(GundamMod.MODID,"textures/entity/amuro_ray.png")));
		RenderingRegistry.registerEntityRenderingHandler(EntityBrightNoa.class,new SkinRender.Factory(new ResourceLocation(GundamMod.MODID,"textures/entity/bright_noa.png")));
		RenderingRegistry.registerEntityRenderingHandler(EntityCharAznable.class,new SkinRender.Factory(new ResourceLocation(GundamMod.MODID,"textures/entity/char_aznable.png")));
		RenderingRegistry.registerEntityRenderingHandler(EntityDomonKasshu.class,new SkinRender.Factory(new ResourceLocation(GundamMod.MODID,"textures/entity/domon_kasshu.png")));
		RenderingRegistry.registerEntityRenderingHandler(EntityFullFrontal.class,new SkinRender.Factory(new ResourceLocation(GundamMod.MODID,"textures/entity/full_frontal.png")));
		RenderingRegistry.registerEntityRenderingHandler(EntityMasterAsia.class,new SkinRender.Factory(new ResourceLocation(GundamMod.MODID,"textures/entity/master_asia.png")));
		RenderingRegistry.registerEntityRenderingHandler(EntityQuattroBajeena.class,new SkinRender.Factory(new ResourceLocation(GundamMod.MODID,"textures/entity/quattro_bajeena.png")));
	}
}