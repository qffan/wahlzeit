package org.wahlzeit.model.food;

public class FoodMaterialType {
	
	public FoodMaterialType(FoodMaterialType parent, String name, String description){
		this.parentType = parent;
		this.name = name;
		this.description = description;		
	}
	
	private String name ;
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	private String alias;
	public String getAlias() {
		return alias;
	}


	public void setAlias(String alias) {
		this.alias = alias;
	}


	private String description;
	
	
	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	private FoodMaterialType parentType;
	public FoodMaterialType getParentType() {
		return parentType;
	}


	public void setParentType(FoodMaterialType parentType) {
		this.parentType = parentType;
	}
	

}
