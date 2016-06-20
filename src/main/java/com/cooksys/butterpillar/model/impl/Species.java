package com.cooksys.butterpillar.model.impl;

import com.cooksys.butterpillar.model.IButterpillar;
import com.cooksys.butterpillar.model.ICatterfly;
import com.cooksys.butterpillar.model.IGrowthModel;
import com.cooksys.butterpillar.model.ISpecies;

public class Species implements ISpecies{
	private String name;
	private IGrowthModel growthModel;
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public IGrowthModel getGrowthModel() {
		return this.growthModel;
	}
	
	public void setGrowthModel(IGrowthModel growthModel) {
		this.growthModel = growthModel;
	}
	
	public ICatterfly createCatterfly(double wingspan, double weight) {
		ICatterfly c = new Catterfly();
		c.setWingspan(wingspan);
		c.setWeight(weight);
		return c;
	}
	
	public IButterpillar createButterpillar(double length, double leavesEaten) {
		IButterpillar b = new Butterpillar();
		b.setLength(length);
		b.setLeavesEaten(leavesEaten);
		return b;
	}
	
	public ICatterfly[] convert(IButterpillar[] butterpillars) {
		ICatterfly[] cList = new ICatterfly[butterpillars.length];
		for (int i = 0; i < butterpillars.length; i++) 
			cList[i] = growthModel.butterpillarToCatterfly(butterpillars[i]);
		
		return cList;
	}
	
	public IButterpillar[] convert(ICatterfly[] catterflies) {
		IButterpillar[] bList = new IButterpillar[catterflies.length];
		for (int i = 0; i < catterflies.length; i++) 
			bList[i] = growthModel.catterflyToButterpillar(catterflies[i]);
		
		return bList;
	}
}
