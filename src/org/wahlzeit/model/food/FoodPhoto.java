package org.wahlzeit.model.food;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.wahlzeit.model.Photo;
import org.wahlzeit.model.PhotoId;

/**
 * 
 * Collaboration:
 * Concrete Photo
 * 
 */
public class FoodPhoto extends Photo {
	
	public static final String CUISINE = "cuisine";
	public static final String TASTE = "taste";
	public static final String IS_VEGETABLE = "isVegetable";
	
	public static final String MAIN_MATERIAL = "mainMaterial";
	
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
	
	
	private FoodMaterial mainMaterial = null;
	
	
	public FoodMaterial getMainMaterial() {
		return mainMaterial;
	}

	public void setMainMaterial(FoodMaterial mainMaterial) {
		this.mainMaterial = mainMaterial;
	}

	/**
	 * 
	 */
	public void readFrom(ResultSet rset) throws SQLException {
	 super.readFrom(rset);
	 this.isVegetable = rset.getBoolean("is_vegetable");
	 this.foodCuisine = FoodCuisine.getFromName(rset.getString("cuisine"));
	 this.foodTaste = FoodTaste.getFromName(rset.getString("taste"));
	 this.mainMaterial = FoodMaterialManager.getInstance().createFoodMaterial(rset.getString("main_material"));
	}
	
	public void writeOn(ResultSet rset) throws SQLException {
		super.writeOn(rset);
		rset.updateBoolean("is_vegetable", this.isVegetable);
		rset.updateString("cuisine", this.foodCuisine.asString());
		rset.updateString("taste", this.foodTaste.asString());
		
		rset.updateString("main_material", "" );//this.mainMaterial.getName());
	}
	

}
