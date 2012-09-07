package de.kp.ames.web.client.fnc.upload;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.fnc.upload
 *  Module: UploadController
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #controller #fnc #upload #web
 * </SemanticAssist>
 *
 */

/**
 *	Copyright 2012 Dr. Krusche & Partner PartG
 *
 *	AMES-Web-GUI is free software: you can redistribute it and/or 
 *	modify it under the terms of the GNU General Public License 
 *	as published by the Free Software Foundation, either version 3 of 
 *	the License, or (at your option) any later version.
 *
 *	AMES- Web-GUI is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
 * 
 *  See the GNU General Public License for more details. 
 *
 *	You should have received a copy of the GNU General Public License
 *	along with this software. If not, see <http://www.gnu.org/licenses/>.
 *
 */

import java.util.HashMap;

import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;

import de.kp.ames.web.client.core.activity.Activity;
import de.kp.ames.web.client.core.globals.GuiConstants;
import de.kp.ames.web.client.core.service.FrameService;
import de.kp.ames.web.client.core.widget.viewer.ViewerFactory;
import de.kp.ames.web.client.fnc.globals.FncGlobals;
import de.kp.ames.web.client.fnc.upload.widget.UploadCreateDialog;
import de.kp.ames.web.shared.constants.ClassificationConstants;
import de.kp.ames.web.shared.constants.FormatConstants;
import de.kp.ames.web.shared.constants.JsonConstants;
import de.kp.ames.web.shared.constants.MethodConstants;
import de.kp.ames.web.shared.constants.ServiceConstants;

public class UploadController {

	/**
	 * Constructor
	 * 
	 * The target of all the upload widget requests
	 * is the respective transient server cache
	 */
	public UploadController() {
	}

	/**
	 * Delete cache entry
	 * 
	 * @param attributes
	 * @param record
	 * @param activity
	 */
	public void doDelete(final HashMap<String,String> attributes, final Record record, final Activity activity) {

		SC.confirm(FncGlobals.CONFIRM_CACHE_DELETE, new BooleanCallback() {  
 
			public void execute(Boolean value) {  
                if (value != null && value) {  
                	/*
                	 * Delete confirmed
                	 */
                	doDeleteConfirmed(attributes, record, activity);
 
                }  
            }  
        
		});
		
	}

	/**
	 * Delete cache entry
	 * 
	 * @param attributes
	 * @param record
	 * @param activity
	 */
	public void doDeleteConfirmed(HashMap<String,String> attributes, Record record, Activity activity) {
		
		/*
		 * Prepare data for delete request;
		 */
		attributes.put(MethodConstants.ATTR_ITEM, record.getAttributeAsString(JsonConstants.J_KEY));

		/*
		 * Invoke delete request
		 */
		UploadService service = new UploadService();
		service.doDelete(attributes, activity);

	}
	
	/**
	 * Upload local file into server cache
	 * 
	 * @param attributes
	 * @param activity
	 */
	public void doUpload(HashMap<String,String> attributes, Activity activity) {
		
		/*
		 * Create dialog
		 */
		UploadCreateDialog createDialog = new UploadCreateDialog();
		
		/*
		 * Provide request specific information
		 */
		createDialog.setParams(attributes);
		createDialog.addSendActivity(activity);
		
	}
	
	/**
	 * @param attributes
	 * @param record
	 */
	public void doView(HashMap<String,String> attributes, Record record) {

		/*
		 * Prepare data for view request
		 */
		String type = attributes.get(MethodConstants.ATTR_TYPE);

		/*
		 * Redirect service
		 */
		attributes.put(MethodConstants.ATTR_SERVICE, ServiceConstants.UPLOAD_SERVICE_ID);		
		if (type.equals(ClassificationConstants.FNC_ID_Document)) {

			/*
			 * View document in Dms Document Cache
			 */
			String format = FormatConstants.FNC_FORMAT_ID_File;
			attributes.put(MethodConstants.ATTR_FORMAT, format);
			
		} else if (type.equals(ClassificationConstants.FNC_ID_Image)) {

			/*
			 * View image in Dms Image Cache
			 */
			String format = FormatConstants.FNC_FORMAT_ID_Image;
			attributes.put(MethodConstants.ATTR_FORMAT, format);

		} else if (type.equals(ClassificationConstants.FNC_ID_Transformator)) {

			/*
			 * View transformator in Xsl Transformator Cache
			 */
			String format = FormatConstants.FNC_FORMAT_ID_File;
			attributes.put(MethodConstants.ATTR_FORMAT, format);

		}

		/*
		 * Key of cache entry
		 */
		String key = record.getAttributeAsString(JsonConstants.J_KEY);
		attributes.put(MethodConstants.ATTR_ITEM, key);

		/*
		 * Build request uri
		 */
		FrameService service = new FrameService();
		String uri = service.getUri(attributes);

		/*
		 * Build viewer
		 */
		String title  = "Cache Viewer";
		String slogan = "Use this widget to view transient information objects.";
		
		ViewerFactory.createFrameViewer(title, slogan, uri);
		
	}

}
