package de.kp.ames.web.client.fnc.dms;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.fnc.dms
 *  Module: DmsController
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #controller #dms #fnc #web
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

import com.google.gwt.json.client.JSONValue;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;

import de.kp.ames.web.client.core.activity.Activity;
import de.kp.ames.web.client.core.activity.ActivityImpl;
import de.kp.ames.web.client.core.controller.ControllerImpl;
import de.kp.ames.web.client.core.globals.GuiConstants;
import de.kp.ames.web.client.core.service.FrameService;
import de.kp.ames.web.client.core.widget.viewer.ViewerFactory;
import de.kp.ames.web.client.fnc.dms.widget.DmsCreateDialog;
import de.kp.ames.web.client.fnc.dms.widget.DmsEditDialog;
import de.kp.ames.web.client.fnc.dms.widget.DmsGetViewer;
import de.kp.ames.web.client.fnc.globals.FncGlobals;
import de.kp.ames.web.shared.constants.ClassificationConstants;
import de.kp.ames.web.shared.constants.FormatConstants;
import de.kp.ames.web.shared.constants.JaxrConstants;
import de.kp.ames.web.shared.constants.MethodConstants;
import de.kp.ames.web.shared.constants.ServiceConstants;

public class DmsController extends ControllerImpl {
	
	/**
	 * Constructor
	 */
	public DmsController() {
	}


	public void doCreate(HashMap<String,String> attributes, Activity afterSendActivity) {
		DmsCreateDialog.create(attributes, afterSendActivity);
	}

	/**
	 * @param attributes
	 * @param record
	 * @param activity
	 */
	public void doDelete(final HashMap<String,String> attributes, final Record record, final Activity activity) {

		SC.confirm(FncGlobals.CONFIRM_DMS_DELETE, new BooleanCallback() {  
 
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
	 * @param attributes
	 * @param record
	 * @param activity
	 */
	public void doDeleteConfirmed(HashMap<String,String> attributes, Record record, Activity activity) {

		/*
		 * Prepare data for delete request
		 */
		attributes.put(MethodConstants.ATTR_ITEM, record.getAttributeAsString(JaxrConstants.RIM_ID));

		/*
		 * Invoke delete request
		 */
		DmsService service = new DmsService();
		service.doDelete(attributes, activity);
		
	}

	/**
	 * @param attributes
	 * @param record
	 * @param activity
	 */
	public void doDownload(HashMap<String,String> attributes, Record record, Activity activity) {
		/*
		 * Prepare data for download request
		 */
		attributes.put(MethodConstants.ATTR_ITEM, record.getAttributeAsString(JaxrConstants.RIM_ID));

		/*
		 * Invoke download request
		 */
		DmsService service = new DmsService();
		service.doDownload(attributes, activity);
		
	}
	
	/**
	 * @param attributes
	 * @param record
	 * @param activity
	 */
	public void doEdit(final HashMap<String,String> attributes, final Record record, final Activity afterSendActivity) {

		final DmsController self = this;
		
		/*
		 * Specify get activity
		 */
		ActivityImpl afterGetActivity = new ActivityImpl() {
			public void execute(JSONValue jValue) {
				self.buildEditDialog(attributes, jValue, afterSendActivity);
			}			
		};

		/*
		 * Retrieve actual version of accessor
		 */
		doGet(attributes, record, afterGetActivity);

	}

	/**
	 * Get Dms Entry
	 * 
	 * @param attributes
	 * @param record
	 */
	public void doGet(final HashMap<String,String> attributes, final Record record) {

		final DmsController self = this;
		
		/*
		 * Specify get activity
		 */
		ActivityImpl afterGetActivity = new ActivityImpl() {
			public void execute(JSONValue jValue) {
				self.buildGetViewer(attributes, jValue);
			}			
		};

		/*
		 * Retrieve actual version of accessor or remote object
		 */
		doGet(attributes, record, afterGetActivity);
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
		attributes.put(MethodConstants.ATTR_SERVICE, ServiceConstants.DMS_SERVICE_ID);
		
		if (type.equals(ClassificationConstants.FNC_ID_Document)) {

			/*
			 * View Dms document
			 */
			String format = FormatConstants.FNC_FORMAT_ID_File;
			attributes.put(MethodConstants.ATTR_FORMAT, format);
			
		} else if (type.equals(ClassificationConstants.FNC_ID_Image)) {

			/*
			 * View Dms image
			 */
			String format = FormatConstants.FNC_FORMAT_ID_Image;
			attributes.put(MethodConstants.ATTR_FORMAT, format);
			
		}

		/*
		 * Reference to the registry object to be viewed
		 */
		String item = record.getAttributeAsString(JaxrConstants.RIM_ID);
		attributes.put(MethodConstants.ATTR_ITEM, item);

		/*
		 * Build request uri
		 */
		FrameService service = new FrameService();
		String uri = service.getUri(attributes);

		/*
		 * Build viewer
		 */
		String title  = GuiConstants.APP_TITLE + ": Dms Viewer";
		String slogan = "Use this widget to view Dms information objects.";
		
		ViewerFactory.createFrameViewer(title, slogan, uri);
		
	}

	/**
	 * Get Dms Entry (metadata)
	 * 
	 * @param attributes
	 * @param record
	 * @param afterGetActivity
	 */
	private void doGet(HashMap<String,String> attributes, Record record, ActivityImpl afterGetActivity) {

		/*
		 * Prepare get request
		 */
		String format = FormatConstants.FNC_FORMAT_ID_Object;
		String item = record.getAttributeAsString(JaxrConstants.RIM_ID);

		String type = attributes.get(MethodConstants.ATTR_TYPE);
		
		/*
		 * Invoke get request
		 */
		DmsService service = new DmsService();
		service.doGet(format, type, item, afterGetActivity);

	
	}

	/**
	 * Build Dms Edit Dialog
	 * 
	 * @param jValue
	 */
	private void buildEditDialog(HashMap<String,String> attributes, JSONValue jValue, Activity afterSendActivity) {
		DmsEditDialog.create(attributes, jValue, afterSendActivity);
	}

	/**
	 * Build Dms Viewer
	 * 
	 * @param jValue
	 */
	private void buildGetViewer(HashMap<String,String> attributes, JSONValue jValue) {
		DmsGetViewer.create(attributes, jValue);
	}

}
