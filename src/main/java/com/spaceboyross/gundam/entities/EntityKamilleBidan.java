package com.spaceboyross.gundam.entities;

import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.world.World;

public class EntityKamilleBidan extends EntityMob {
	
	public EntityKamilleBidan(World worldIn) {
		super(worldIn);
		this.setSize(1.0F,2.0F);
	}
	
	@Override
	protected void initEntityAI() {
		this.tasks.addTask(0,new EntityAISwimming(this));
		this.tasks.addTask(8,new EntityAILookIdle(this));
		this.applyEntityAI();
	}
	
	private void applyEntityAI() {
		this.tasks.addTask(6,new EntityAIMoveThroughVillage(this,1.0D,false));
	}
}
