package org.wahlzeit.location.impl;

import org.wahlzeit.location.LocationException;

import junit.framework.TestCase;

public class GPSLocationTest extends TestCase {

	/**
	 * 
	 * @param name
	 */
	public GPSLocationTest(String name) {
		super(name);
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(final String[] args) {
		junit.textui.TestRunner.run(GPSLocationTest.class);
	}
	
	public void testConstructor(){
		GPSLocation loc = new GPSLocation();
		assertTrue( loc.isEmpty());
		try {
		
		GPSLocation loc1 = new GPSLocation( 1, 1);
		GPSLocation loc2 = new GPSLocation( 1, 1);
		
		} catch (LocationException exp ) {
			exp.printStackTrace();
		}
		
	}
	
	public void testEquals(){
		try {
		GPSLocation loc1 = new GPSLocation( 1, 1);
		GPSLocation loc2 = new GPSLocation( 1, 1);
		assertTrue( loc1.isEqual(loc2));
		} catch (LocationException exp ) {
			exp.printStackTrace();
		}
	}
}
