package org.wahlzeit.location.impl;

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
		
		GPSLocation loc1 = new GPSLocation( 1, 1);
		GPSLocation loc2 = new GPSLocation( 1, 1);
		
		
	}
	
	public void testEquals(){
		GPSLocation loc1 = new GPSLocation( 1, 1);
		GPSLocation loc2 = new GPSLocation( 1, 1);
		assertTrue( loc1.isEqual(loc2));
	}
}
