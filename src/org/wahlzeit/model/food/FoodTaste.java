package org.wahlzeit.model.food;

import org.wahlzeit.utils.EnumValue;

/**
 * 
 * Collaboration:
 * Value Type FoodTaste
 * 
 */
public enum FoodTaste implements EnumValue {
	
	SOUR(0, "sour"),
	SWEET(1, "sweet"),
	BITTER(2,"bitter"),
	SPICY(3,"spicy"),
	SALTY(4, "salty");
	
	/**
	 * All possible taste of food
	 */
	private static FoodTaste[] allValues = {
		SOUR, SWEET, BITTER, SPICY, SALTY
	};
	
	private int value = 0;
	private String name;
	
	private FoodTaste(int myValue,String name){
		this.value = myValue;
		this.name= name;
	}

	/**
	 * 
	 */
	public static FoodTaste getFromInt(int myValue) throws IllegalArgumentException {
		assertIsValidFoodTasteAsInt(myValue);
		return allValues[myValue];
	}

	/**
	 * 
	 */
	public static void assertIsValidFoodTasteAsInt(int myValue) throws IllegalArgumentException {
		if ((myValue < 0) || (myValue > 4)) {
			throw new IllegalArgumentException("invalid FoodTaste int: " + myValue);
		}
	}
	
	/**
	 * 
	 */
	public static FoodTaste getFromName(String mytaste) throws IllegalArgumentException {
		for( FoodTaste taste: FoodTaste.values() ){
			if( taste.name.equals(mytaste) ) {
				return taste;
			}				
		}	
		
		throw new IllegalArgumentException("invalid FoodTaste name: " + mytaste);
	}


	/**
	 * @methodtype boolean-query
	 */
	public boolean isEqual(FoodTaste taste) {
		return taste == this;
	}
		
	
	@Override
	public int asInt() {
		return value;
	}

	@Override
	public String asString() {
		return allValues[value].name;
	}

	@Override
	public EnumValue[] getAllValues() {
		return allValues;
	}

	@Override
	public String getTypeName() {
		return "FoodTaste";
	}

}
