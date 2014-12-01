package org.wahlzeit.model.food;

import org.wahlzeit.utils.EnumValue;

public enum FoodCuisine  implements EnumValue {
	LU(0, "lu", "shangdong", "salty and fresh"),
	SU(1, "su", "jiangsu", "sweet"),
	YUE(2, "yue", "liangguang", "fresh and light"),
	CHUAN(3, "chuang", "sichuan", "spicy and pungent");
	
	
	
	/**
	 * The four main cuisine of chinese food.
	 */
	private static FoodCuisine[] allValues = {
		LU, SU, YUE, CHUAN
	};
	
	private int value = 0;
	private String name;
	private String province;
	private String taste;
	
	
	
	private FoodCuisine(int myValue,String name, String province, String taste){
	
		this.value = myValue;
		this.name= name;
		this.province = province;
		this.taste = taste;
	}
	
	/**
	 * 
	 */
	public static FoodCuisine getFromInt(int myValue) throws IllegalArgumentException {
		assertIsValidFoodCuisineAsInt(myValue);
		return allValues[myValue];
	}

	/**
	 * 
	 */
	public static void assertIsValidFoodCuisineAsInt(int myValue) throws IllegalArgumentException {
		if ((myValue < 0) || (myValue > 4)) {
			throw new IllegalArgumentException("invalid FoodCuisine int: " + myValue);
		}
	}
	
	/**
	 * 
	 */
	public static FoodCuisine getFromNmae(String myCuisine) throws IllegalArgumentException {
		for( FoodCuisine cuisine: FoodCuisine.values() ){
			if( cuisine.name.equals(myCuisine) ) {
				return cuisine;
			}				
		}	
		
		throw new IllegalArgumentException("invalid FoodCuisine name: " + myCuisine);
	}
	

	/**
	 * 
	 */
	public int asInt() {
		return value;
	}
	
	/**
	 * 
	 */
	public FoodCuisine[] getAllValues() {
		return allValues;
	}
	
	/**
	 * 
	 */
	public String getTypeName() {
		return "FoodCuisine";
	}

	/**
	 * @methodtype boolean-query
	 */
	public boolean isEqual(FoodCuisine cuisine) {
		return cuisine == this;
	}
	
	/**
	 * 
	 */
	public String asString() {
		return allValues[value].name;
	}
	
	public String getProvince()
	{
		return province;
	}
	
	public String getTaste(){
		return taste;
	}
}
