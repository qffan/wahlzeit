package org.wahlzeit.location.impl;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(GPSLocationTest.class);
		suite.addTestSuite(MapcodeLocationTest.class);
		//$JUnit-END$
		return suite;
	}

}
