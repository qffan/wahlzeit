package org.wahlzeit.location.impl;

import java.util.List;

import org.wahlzeit.location.LocationException;

import com.mapcode.*;

public class MapcodeLocation extends AbstractLocation {

	private List<Mapcode> mapcodes;

	public MapcodeLocation() {
		this.mapcodes = new java.util.ArrayList<Mapcode>();
	}

	public MapcodeLocation(double latitude, double longitude) throws LocationException {
		this.setLongitude(longitude);
		this.setLatitude(latitude);
		mapcodes = MapcodeCodec.encode(this.getLatitude(), this.getLongitude());
	}

	public MapcodeLocation(String firstDigital, String secondDigital) 
			throws UnknownMapcodeException, LocationException {
		this.mapcodes = new java.util.ArrayList<Mapcode>();
		String code = firstDigital + "." + secondDigital;
		mapcodes.add(new Mapcode(code, null));
		Point p = MapcodeCodec.decode(code);
		this.setLongitude(p.getLonDeg());
		this.setLatitude(p.getLatDeg());
	}

	public MapcodeLocation(String state, String firstDigital, String secondDigital) throws UnknownMapcodeException,
			UnknownTerritoryException, LocationException {
		this.mapcodes = new java.util.ArrayList<Mapcode>();
		final String code = firstDigital + "." + secondDigital;
		final Territory territory = Territory.fromString(state);
		mapcodes.add(new Mapcode(code, territory));
		Point p = MapcodeCodec.decode(code, territory);
		this.setLongitude(p.getLonDeg());
		this.setLatitude(p.getLatDeg());
	}

	public String asMapcodeString() {
		String ret = "";
		if (mapcodes != null) {
			for (final Mapcode code : mapcodes) {
				ret += code.asInternationalFullName() + "\n";
			}
		}
		return ret;
	}

}
