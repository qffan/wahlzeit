package org.wahlzeit.model.food;

import java.util.ArrayList;
import java.util.List;

import org.wahlzeit.services.SysLog;

/**
 * 
 * Collaboration:
 * Manager
 * Factory
 * singleton
 * 
 * Roles:
 * Manager of FoodMaterialType
 * Factory of FoodMaterial
 * Initializer of self
 * 
 */
public class FoodMaterialManager {
	
	// Collaboration:
	// singleton
	private FoodMaterialManager(){
		loadMaterialType();
	}
	
	private static FoodMaterialManager instance = null;
	
	
	
	public static synchronized FoodMaterialManager getInstance() {
		if (instance == null) {
			SysLog.logSysInfo("setting generic FoodMaterialManager");
			instance = new FoodMaterialManager();
		}
		
		return instance;
	}
	
	// Collaboration:
	// Manager
	protected List<FoodMaterialType> types = new ArrayList<FoodMaterialType>();
	
	private void loadMaterialType(){
		
		//TODO load form json file
		FoodMaterialType type = new FoodMaterialType(null, "Vegetable", "Vegetable");		
		types.add(type);
		
		
		FoodMaterialType type1 = new FoodMaterialType(type, "Tomato", "Vegetable");		
		types.add(type1);
		
		type1 = new FoodMaterialType(type, "Potato", "Vegetable");		
		types.add(type1);
		
		type = new FoodMaterialType(null, "Meat", "Meat");		
		types.add(type);
		
		type1 = new FoodMaterialType(type, "Fish", "Fish");		
		types.add(type1);
		
		type1 = new FoodMaterialType(type, "Pork", "Pork");		
		types.add(type1);	
	}
	
	public List< FoodMaterialType> getTopTypes(){
		List<FoodMaterialType> ret = new ArrayList<FoodMaterialType>();
		for(FoodMaterialType type : types ){
			if( type.getParentType() == null ){
				ret.add(type);
			}
		}
		return ret;
	}
	
	public List<FoodMaterialType> getChildTypes(FoodMaterialType mytype){
		List<FoodMaterialType> ret = new ArrayList<FoodMaterialType>();
		for(FoodMaterialType type : types ){
			if( type.getParentType() == mytype ){
				ret.add(type);
			}
		}
		return ret;
	}
	
	public List<FoodMaterialType> getChildTypes(String mytype){
		FoodMaterialType type = this.getFoodMaterialType(mytype);
		if( type != null){
			return this.getChildTypes(type);
		}
		return new ArrayList<FoodMaterialType>(); 
		
	}
	
	public boolean isBottomTypes(FoodMaterialType mytype){		
		List<FoodMaterialType> ret = this.getChildTypes(mytype);
		if( ret.size() == 0)
			return true;
		return false;
	}
	
	protected FoodMaterialType getFoodMaterialType(String name ){
		for( FoodMaterialType mytype : types){
			if( mytype.getName().equals(name))
				return mytype;
		}		
		return null;
	}
	
	// Collaboration:
	// Factory
	public FoodMaterial createFoodMaterial(String name){
		 FoodMaterialType mytype =  getFoodMaterialType (name);
		 if(mytype != null){
			 return new  FoodMaterial(mytype);
		 }
		 return null;
	}
	

}
