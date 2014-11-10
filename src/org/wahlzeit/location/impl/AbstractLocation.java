package org.wahlzeit.location.impl;

import org.wahlzeit.location.Location;

public abstract class AbstractLocation implements Location {
	
	public static double INVALID_VALUE = -10000.0;
	
	protected double longitude = INVALID_VALUE;
	protected double latitude = INVALID_VALUE;
	
	public double getLongitude(){
		return longitude;
	}
	protected void setLongitude( double longitude){
		this.longitude = longitude;
	}
	
	public double getLatitude(){
		return this.latitude;
	}
	protected void setLatitude( double latitude){
		this.latitude = latitude;
	}
	
	/**
	* Returns true if objects are equal.
	* Objects may be of different classes.
	*/
	public boolean isEqual(Location location){
		if( location == null )
			return false;
		
		if( this.getLatitude() == location.getLatitude()
				&& this.getLongitude() == location.getLongitude())
		{
			return true;
		}
		
		return false;
	}
	
	/**
	* Returns true if ? 
	*/
	public boolean isEmpty(){
		if( this.getLatitude() == INVALID_VALUE
				|| this.getLongitude() == INVALID_VALUE)
			return true;
		return false;
	}
	
	/**
	 * 
	 * @return human-readable output for a GUI.
	 */
	public String asString(){
		if( this.isEmpty())
			return "No Location found";
		else {
			return "latitude " + this.getLatitude() + ", longtitude " + this.getLongitude();
		}
	}
	
	public String toString(){
		if( this.isEmpty())
			return "";
		else {
			return this.getLatitude() + ", " + this.getLongitude();
		}
	}

}
