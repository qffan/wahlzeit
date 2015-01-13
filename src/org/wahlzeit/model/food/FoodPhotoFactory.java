package org.wahlzeit.model.food;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.wahlzeit.model.PhotoFactory;
import org.wahlzeit.model.PhotoId;
import org.wahlzeit.services.SysLog;

/**
 * 
 * Collaboration:
 * Factory
 * singleton
 * 
 * Roles:
 * Factory of FoodPhoto
 * Initializer of self
 * 
 */
public class FoodPhotoFactory extends PhotoFactory {
	
	// Collaboration:
	// singleton

	/**
	 * Hidden singleton instance; needs to be initialized from the outside.
	 */
	private static FoodPhotoFactory instance = null;
	
	/**
	 * Public singleton access method.
	 */
	public static synchronized PhotoFactory getInstance() {
		if (instance == null) {
			SysLog.logSysInfo("setting generic FoodPhotoFactory");
			setInstance(new FoodPhotoFactory());
		}
		
		return instance;
	}
	
	/**
	 * Method to set the singleton instance of FoodPhotoFactory.
	 */
	protected static synchronized void setInstance(FoodPhotoFactory foodPhotoFactory) {
		if (instance != null) {
			throw new IllegalStateException("attempt to initalize FoodPhotoFactory twice");
		}
		
		instance = foodPhotoFactory;
	}
	
	/**
	 * Hidden singleton instance; needs to be initialized from the outside.
	 */
	public static void initialize() {
		getInstance(); // drops result due to getInstance() side-effects
	}
	
	/**
	 * 
	 */
	protected FoodPhotoFactory() {
		// do nothing
	}
	
	// Collaboration:
	// factory
	

	/**
	 * @methodtype factory
	 */
	@Override
	public FoodPhoto createPhoto() {
		return new FoodPhoto();
	}
	
	/**
	 * 
	 */
	@Override
	public FoodPhoto createPhoto(PhotoId id) {
		return new FoodPhoto(id);
	}
	
	/**
	 * 
	 */
	@Override
	public FoodPhoto createPhoto(ResultSet rs) throws SQLException {
		return new FoodPhoto(rs);
	}
	

}
