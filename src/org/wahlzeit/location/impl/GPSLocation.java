package org.wahlzeit.location.impl;

import org.wahlzeit.location.LocationException;

public class GPSLocation extends AbstractLocation {
	
	public GPSLocation(){
		
	}
	
	public GPSLocation(double longitude, double latitude) throws LocationException{
		this.setLongitude(longitude);
		this.setLatitude(latitude);		
	}
	
	
}
