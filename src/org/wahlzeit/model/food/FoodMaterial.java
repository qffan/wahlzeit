package org.wahlzeit.model.food;


public class FoodMaterial {
	
	private FoodMaterialType type;
	public FoodMaterial(FoodMaterialType foodType){
		type = foodType;		
	}
	
	public String getName(){
		return type.getName();
	}
	
	public String getDescription(){
		return type.getDescription();
	}
	
	

}
