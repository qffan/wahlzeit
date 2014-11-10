package org.wahlzeit.location;

public interface Location {	
	
	public double getLongitude();
	
	public double getLatitude();
	
	/**
	 * 
	 * @return human-readable output for a GUI.
	 */
	public String asString();
	
	/**
	* Returns true if objects are equal.
	* Objects may be of different classes.
	*/
	public boolean isEqual(Location location);
	
	/**
	* Returns true if the values of longitude and latitude is invalid.
	*/
	public boolean isEmpty();
	
}
