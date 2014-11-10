package org.wahlzeit.location.impl;

import java.util.List;

import com.mapcode.Mapcode;
import com.mapcode.MapcodeCodec;
import com.mapcode.Point;
import com.mapcode.Territory;
import com.mapcode.UnknownMapcodeException;
import com.mapcode.UnknownTerritoryException;

import junit.framework.TestCase;

public class MapcodeLocationTest extends TestCase {

	/**
	 * 
	 * @param name
	 */
	public MapcodeLocationTest(String name) {
		super(name);
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(final String[] args) {
		junit.textui.TestRunner.run(MapcodeLocationTest.class);
	}

	public void testConstructor() throws UnknownTerritoryException,
			UnknownMapcodeException {
		MapcodeLocation loc = new MapcodeLocation();
		assertTrue(loc.isEmpty());

		MapcodeLocation loc2 = new MapcodeLocation("NLD", "49", "4V");
		System.out.println(loc2.toString());
		System.out.println(loc2.asMapcodeString());
		MapcodeLocation loc3 = new MapcodeLocation("PQ0PF", "5M1H");
		System.out.println(loc3.toString());
		System.out.println(loc3.asMapcodeString());

		MapcodeLocation loc4 = new MapcodeLocation(26.87016, 75.847);
		System.out.println(loc4.toString());
		System.out.println(loc4.asMapcodeString());
	}

}
