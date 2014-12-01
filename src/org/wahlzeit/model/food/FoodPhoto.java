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
		incWriteCount();
	}
	
	protected FoodCuisine foodCuisine;
	
	public FoodCuisine getFoodCuisine() {
		return foodCuisine;
	}
	public void setFoodCuisine(FoodCuisine foodCuisine) {
		
		assert(foodCuisine!=null);
		doSetFoodCuisine(foodCuisine);
		assert(this.foodCuisine == foodCuisine);
		
	}
	
	protected void doSetFoodCuisine(FoodCuisine foodCuisine) {
		this.foodCuisine = foodCuisine;
		incWriteCount();
	}
	
	protected FoodTaste foodTaste;

	public FoodTaste getFoodTaste() {
		return foodTaste;
	}

	public void setFoodTaste(FoodTaste foodTaste) {
		assert(foodTaste!=null);
		doSetFoodTaste(foodTaste);
		
		this.foodTaste = foodTaste;
	}
	
	
	protected void doSetFoodTaste(FoodTaste foodTaste) {
		this.foodTaste = foodTaste;
		incWriteCount();		
	}
	
	
	/**
	 * 
	 */
	public void readFrom(ResultSet rset) throws SQLException {
	 super.readFrom(rset);
	 //todo
	 
	}
	
	public void writeOn(ResultSet rset) throws SQLException {
		super.writeOn(rset);
		//todo
	}
	

}
