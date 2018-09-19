package com.spaceboyross.gundam.ms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

import com.spaceboyross.gundam.Config;
import com.spaceboyross.gundam.GundamMod;
import com.spaceboyross.gundam.capabilities.human.Human;
import com.spaceboyross.gundam.capabilities.interfaces.IHumanCapability;
import com.spaceboyross.gundam.gui.hud.MobileSuitHUD;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.client.model.b3d.B3DModel;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.client.model.obj.OBJModel;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public abstract class MobileSuit {

	private List<MobileSuitArmament> armaments;
	private String name;
	private String model;
	private Map<String,Integer> recipeIDs;
	private float height;
	
	private boolean initedHUD3D = false;
	private OBJModel hud3DModel;
	
	public MobileSuit.MSRender.Factory FACTORY = new MobileSuit.MSRender.Factory(this);
	
	public MobileSuit() {
		this.armaments = new ArrayList<>();
		this.recipeIDs = new HashMap<>();
		this.height = 0.0f;
	}
	
	private void initHUD3D() {
		try {
			this.hud3DModel = (OBJModel)OBJLoader.INSTANCE.loadModel(new ResourceLocation(GundamMod.MODID,"model/gui/ms_hud.obj"));
			this.initedHUD3D = true;
		} catch(Exception e) {
			e.printStackTrace();
			Config.use3DMSHud = false;
			this.initedHUD3D = false;
		}
	}
	
	public void drawHUD(MobileSuitHUD hud) {
		Config.readConfig();
		if(Config.use3DMSHud) {
			if(!this.initedHUD3D) this.initHUD3D();
		} else {
		}
	}
	
	public void setHeight(float height) {
		this.height = height;
	}
	
	public float getHeight() {
		return this.height;
	}
	
	public ResourceLocation getBaseResourceLocation() {
		return new ResourceLocation(GundamMod.MODID,"textures/entity/"+(this.model+"_"+this.name).replaceAll(" ","_"));
	}
	
	public MSMob createEntity(World worldIn,Vec3d pos) {
		MSMob mob = new MSMob(worldIn);
		mob.setPosition(pos.x,pos.y,pos.z);
		return mob;
	}
	
	public void addRecipeItem(String id,int count) {
		this.recipeIDs.put(id,new Integer(count));
	}
	
	public int getRecipeItemCount() {
		return this.recipeIDs.size();
	}
	
	public String getRecipeItemID(int i) {
		String ids[] = new String[this.recipeIDs.keySet().size()];
		ids = this.recipeIDs.keySet().toArray(ids);
		return ids[i];
	}
	
	public Integer getRecipeItemCount(String id) {
		return this.recipeIDs.get(id);
	}
	
	public Integer getRecipeItemCount(int i) {
		return this.getRecipeItemCount(this.getRecipeItemID(i));
	}
	
	public void addArmament(MobileSuitArmament armament) {
		this.armaments.add(armament);
	}
	
	public MobileSuitArmament getArmament(int i) {
		return this.armaments.get(i);
	}
	
	public int getArmamentCount() {
		return this.armaments.size();
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public String getModel() {
		return this.model;
	}
	
	public static class MSMob extends EntityMob {
		
		public float scale = 1.0f;
		private EntityPlayer pilot;
		
		public List<Framebuffer> cameras = new ArrayList<>();
		
		public MSMob(World worldIn) {
			super(worldIn);
			this.heal(Float.MAX_VALUE);
		}
		
		@Override
		public boolean processInteract(EntityPlayer player,EnumHand hand) {
			if(player.inventory.getStackInSlot(player.inventory.currentItem).getItem().getUnlocalizedName().equals("item."+GundamMod.MODID+".wrench")) {
				// TODO: show customization interface
			} else {
				this.pilot = player;
				this.pilot.startRiding(this);
				IHumanCapability human = Human.getHuman(this.pilot);
				human.setMS(this);
			}
			return true;
		}
		
		public EntityPlayer getPilot() {
			return this.pilot;
		}
		
		public MobileSuit getMSRegistryEntry() {
			return MSRegistry.getMobileSuit(this.getName());
		}
		
		@Override
		public boolean canRiderInteract() {
			return true;
		}
		
		@Override
		public boolean canBeSteered() {
			return true;
		}
		
		private void updateRiderPosition(Entity entity) {
			if(entity != null) {
				entity.setPosition(this.posX,this.posY+(getMountedYOffset()+entity.getYOffset())/2,this.posZ);
			}
		}
		
		@Override
		public void updatePassenger(Entity passenger) {
			this.updateRiderPosition(passenger);
			passenger.setInvisible(true);
		}
		
		@Override
		public void removePassenger(Entity passenger) {
			if(passenger != null) passenger.setPosition(this.posX,this.posY,this.posZ);
			super.removePassenger(passenger);
			passenger.setInvisible(false);
			IHumanCapability human = Human.getHuman((EntityPlayer)passenger);
			human.setMS(null);
			this.pilot = null;
			human.syncToServer();
		}
	}
	
	public static class MSRender extends RenderLiving<MSMob> {
		
		private MobileSuit ms;
		
		public MSRender(RenderManager rendermanagerIn,MobileSuit ms) {
			super(rendermanagerIn,new ModelPlayer(1.0f,false),0.5f);
			this.ms = ms;
		}
		
		@Override
		public void preRenderCallback(MSMob mob,float par2) {
			this.scale(mob,par2);
		}
		
		protected void scale(MSMob mob,float par2) {
			this.shadowSize = mob.scale/2.0f;
			GL11.glScalef(mob.scale,mob.scale,mob.scale);
		}

		@Override
		protected ResourceLocation getEntityTexture(MSMob entity) {
			return new ResourceLocation(this.ms.getBaseResourceLocation()+".png");
		}
		
		public static class Factory implements IRenderFactory<MSMob> {
			
			private MobileSuit ms;
			
			public Factory(MobileSuit ms) {
				this.ms = ms;
			}
			
			@Override
			public Render<? super MSMob> createRenderFor(RenderManager manager) {
				return new MSRender(manager,this.ms);
			}
		}
	}
}
