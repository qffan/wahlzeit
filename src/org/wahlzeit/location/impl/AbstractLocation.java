package org.wahlzeit.location.impl;

import org.wahlzeit.location.Location;
import org.wahlzeit.location.LocationException;

public abstract class AbstractLocation implements Location {
	
	public static double EMPTY_VALUE = -10000.0;
	
	protected double longitude = EMPTY_VALUE;
	protected double latitude = EMPTY_VALUE;
	
	public double getLongitude(){
		return longitude;
	}
	protected void setLongitude( double longitude) throws LocationException{
		assertIsValidLongitude( longitude );
		doSetLongitude( longitude);
		
	}
	
	 protected final void assertIsValidLongitude(double longitude) throws LocationException{
		 if (longitude != EMPTY_VALUE && ( !(longitude >= -180 && longitude <= 180))){
				throw new LocationException("The value "+longitude+ " is not a valid longitude!");
			}
	 }
	 
	 protected void doSetLongitude( double longitude){
		 this.longitude = longitude;
	 }
	
	public double getLatitude(){
		return this.latitude;
	}
	
	protected final void assertIsValidLatitude(double latitude) throws LocationException{
		if (latitude != EMPTY_VALUE && ( !(latitude >= -180 && latitude <= 180))){
			throw new LocationException("The value "+latitude+ " is not a valid latitude!");
		}
	}
	
	protected void setLatitude( double latitude) throws LocationException{
		assertIsValidLatitude(latitude);
		doSetLatitude( latitude);
	}
	
	protected void doSetLatitude( double latitude){
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
		if( this.getLatitude() == EMPTY_VALUE
				|| this.getLongitude() == EMPTY_VALUE)
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
