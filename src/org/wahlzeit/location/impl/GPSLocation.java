package org.wahlzeit.location.impl;

public class GPSLocation extends AbstractLocation {
	
	public GPSLocation(){
		
	}
	
	public GPSLocation(double longitude, double latitude){
		this.setLongitude(longitude);
		this.setLatitude(latitude);		
	}
	
	
}
