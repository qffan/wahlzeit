/*
 * Copyright (c) 2006-2009 by Dirk Riehle, http://dirkriehle.com
 *
 * This file is part of the Wahlzeit photo rating application.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */

package org.wahlzeit.handlers;

import java.util.*;
import java.io.*;

import org.wahlzeit.model.*;
import org.wahlzeit.model.food.FoodCuisine;
import org.wahlzeit.model.food.FoodPhoto;
import org.wahlzeit.model.food.FoodTaste;
import org.wahlzeit.services.*;
import org.wahlzeit.utils.*;
import org.wahlzeit.webparts.*;

/**
 * 
 * @author dirkriehle
 *
 */
public class UploadPhotoFormHandler extends AbstractWebFormHandler {
	
	/**
	 *
	 */
	public UploadPhotoFormHandler() {
		initialize(PartUtil.UPLOAD_PHOTO_FORM_FILE, AccessRights.USER);
	}
	
	/**
	 * 
	 */
	protected void doMakeWebPart(UserSession us, WebPart part) {
		Map<String, Object> args = us.getSavedArgs();
		part.addStringFromArgs(args, UserSession.MESSAGE);

		part.maskAndAddStringFromArgs(args, Photo.TAGS);
		
		String cuisines = "";
		for (FoodCuisine t : FoodCuisine.values())
		{
			cuisines += "<option>";
			cuisines += t.asString();
			cuisines += "</option>";
		}
		part.addString(FoodPhoto.CUISINE, cuisines);
		
		String tastes ="";
		
		for (FoodTaste t : FoodTaste.values())
		{			
			tastes += "<option>";
			tastes += t.asString();
			tastes += "</option>";
		}
		part.addString(FoodPhoto.TASTE, tastes);
		
		String isVegatables ="";	
		isVegatables += "<option>True</option>";	
		isVegatables += "<option>False</option>";		
		
		part.addString(FoodPhoto.IS_VEGETABLE, isVegatables);
		
	}
		
		
	
	/**
	 * 
	 */
	protected String doHandlePost(UserSession us, Map args) {
		String tags = us.getAndSaveAsString(args, Photo.TAGS);
		String cuisine = us.getAndSaveAsString(args, FoodPhoto.CUISINE);
		String taste = us.getAndSaveAsString(args, FoodPhoto.TASTE);
		String veg = us.getAndSaveAsString(args, FoodPhoto.IS_VEGETABLE);
		boolean vegb = veg.equals("True")? true: false;
		

		if (!StringUtil.isLegalTagsString(tags)) {
			us.setMessage(us.cfg().getInputIsInvalid());
			return PartUtil.UPLOAD_PHOTO_PAGE_NAME;
		}

		try {
			PhotoManager pm = PhotoManager.getInstance();
			String sourceFileName = us.getAsString(args, "fileName");
			File file = new File(sourceFileName);
			Photo photo = pm.createPhoto(file);

			String targetFileName = SysConfig.getBackupDir().asString() + photo.getId().asString();
			createBackup(sourceFileName, targetFileName);
		
			User user = (User) us.getClient();
			user.addPhoto(photo); 
			
			photo.setTags(new Tags(tags));
			
			if( photo instanceof FoodPhoto){				
				FoodPhoto foodPhoto = (FoodPhoto)photo;
				foodPhoto.setFoodCuisine(FoodCuisine.getFromName(cuisine));
				foodPhoto.setFoodTaste(FoodTaste.getFromName(taste));
				foodPhoto.setVegetable(vegb);
			}

			pm.savePhoto(photo);

			StringBuffer sb = UserLog.createActionEntry("UploadPhoto");
			UserLog.addCreatedObject(sb, "Photo", photo.getId().asString());
			UserLog.log(sb);
			
			us.setTwoLineMessage(us.cfg().getPhotoUploadSucceeded(), us.cfg().getKeepGoing());
		} catch (Exception ex) {
			SysLog.logThrowable(ex);
			us.setMessage(us.cfg().getPhotoUploadFailed());
		}
		
		return PartUtil.UPLOAD_PHOTO_PAGE_NAME;
	}
	
	/**
	 * 
	 */
	protected void createBackup(String sourceName, String targetName) {
		try {
			File sourceFile = new File(sourceName);
			InputStream inputStream = new FileInputStream(sourceFile);
			File targetFile = new File(targetName);
			OutputStream outputStream = new FileOutputStream(targetFile);
			// @FIXME IO.copy(inputStream, outputStream);
		} catch (Exception ex) {
			SysLog.logSysInfo("could not create backup file of photo");
			SysLog.logThrowable(ex);			
		}
	}
}
