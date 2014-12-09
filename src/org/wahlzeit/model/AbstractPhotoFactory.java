package org.wahlzeit.model;

import java.sql.ResultSet;

public abstract class AbstractPhotoFactory {
	public abstract Photo createPhoto();
	public abstract Photo createPhoto(PhotoId id);
	public abstract Photo createPhoto(ResultSet rs);
	public abstract PhotoFilter createPhotoFilter();
	public abstract PhotoTagCollector createPhotoTagCollector() ;
	 

}
