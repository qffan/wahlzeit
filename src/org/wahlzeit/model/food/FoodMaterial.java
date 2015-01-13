package org.wahlzeit.model.food;

/**
 * 
 * Collaboration:
 * Type Object
 * 
 * Roles:
 * object of type object pattern
 * 
 */
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
	
	public FoodMaterialType getFoodMaterialType(){
		return type;
	}
	

}
