package com.spaceboyross.gundam;

import javax.annotation.Nullable;

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

		EntityRegistry.registerModEntity(new ResourceLocation(GundamMod.MODID,"amuro_ray"),EntityAmuroRay.class,GundamMod.MODID+".AmuroRay",id++,GundamMod.instance,64,3,true,0x996600+(id-1),0x00ff00+(id-1));
		EntityRegistry.registerModEntity(new ResourceLocation(GundamMod.MODID,"bright_noa"),EntityBrightNoa.class,GundamMod.MODID+".BrightNoa",id++,GundamMod.instance,64,3,true,0x996600+(id-1),0x00ff00+(id-1));
		EntityRegistry.registerModEntity(new ResourceLocation(GundamMod.MODID,"char_aznable"),EntityCharAznable.class,GundamMod.MODID+".CharAznable",id++,GundamMod.instance,64,3,true,0x996600+(id-1),0x00ff00+(id-1));
		EntityRegistry.registerModEntity(new ResourceLocation(GundamMod.MODID,"domon_kasshu"),EntityDomonKasshu.class,GundamMod.MODID+".DomonKasshu",id++,GundamMod.instance,64,3,true,0x996600+(id-1),0x00ff00+(id-1));
		EntityRegistry.registerModEntity(new ResourceLocation(GundamMod.MODID,"full_frontal"),EntityFullFrontal.class,GundamMod.MODID+".FullFrontal",id++,GundamMod.instance,64,3,true,0x996600+(id-1),0x00ff00+(id-1));
		EntityRegistry.registerModEntity(new ResourceLocation(GundamMod.MODID,"master_asia"),EntityMasterAsia.class,GundamMod.MODID+".MasterAsia",id++,GundamMod.instance,64,3,true,0x996600+(id-1),0x00ff00+(id-1));
		EntityRegistry.registerModEntity(new ResourceLocation(GundamMod.MODID,"quattro_bajeena"),EntityQuattroBajeena.class,GundamMod.MODID+".QuattroBajeena",id++,GundamMod.instance,64,3,true,0x996600+(id-1),0x00ff00+(id-1));
		GundamEntities.ID = id;
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