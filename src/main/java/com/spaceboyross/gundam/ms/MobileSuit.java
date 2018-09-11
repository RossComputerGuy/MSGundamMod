package com.spaceboyross.gundam.ms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class MobileSuit {

	private List<MobileSuitArmament> armaments;
	private String name;
	private String model;
	private Map<String,Integer> recipeIDs;
	
	public MobileSuit() {
		this.armaments = new ArrayList<>();
		this.recipeIDs = new HashMap<>();
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
}
