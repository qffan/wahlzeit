package org.wahlzeit.model.food;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.wahlzeit.model.Photo;
import org.wahlzeit.model.PhotoId;

public class FoodPhoto extends Photo {
	
	public FoodPhoto(){
		super();
	}
	
	public FoodPhoto( PhotoId id ){
		super(id);
		
	}
	
	public FoodPhoto( ResultSet rs ) throws SQLException{
		super(rs);
		
	}
	
	
	protected boolean isVegetable;
	
	public boolean isVegetable() {
		return isVegetable;
	}
	public void setVegetable(boolean isVegetable) {
		this.isVegetable = isVegetable;
	}
	
	protected FoodCuisine foodCuisine;
	
	public FoodCuisine getFoodCuisine() {
		return foodCuisine;
	}
	public void setFoodCuisine(FoodCuisine foodCuisine) {
		this.foodCuisine = foodCuisine;
	}
	
	
	

}
