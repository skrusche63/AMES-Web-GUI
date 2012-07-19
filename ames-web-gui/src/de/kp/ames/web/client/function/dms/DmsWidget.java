package de.kp.ames.web.client.function.dms;
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

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;

import de.kp.ames.web.client.core.activity.Activity;
import de.kp.ames.web.client.core.activity.ActivityImpl;
import de.kp.ames.web.client.core.globals.GUIGlobals;
import de.kp.ames.web.client.core.service.FrameService;
import de.kp.ames.web.client.core.util.JsonConverter;
import de.kp.ames.web.client.core.widget.viewer.ViewerFactory;
import de.kp.ames.web.client.function.dms.widget.DmsCreateDialog;
import de.kp.ames.web.client.function.globals.FncGlobals;
import de.kp.ames.web.client.function.user.UserService;
import de.kp.ames.web.shared.ClassificationConstants;
import de.kp.ames.web.shared.FormatConstants;
import de.kp.ames.web.shared.JaxrConstants;
import de.kp.ames.web.shared.MethodConstants;
import de.kp.ames.web.shared.ServiceConstants;

public class DmsWidget {
	
	/**
	 * Constructor
	 */
	public DmsWidget() {
	}

	/**
	 * @param attributes
	 * @param afterSendActivity
	 */
	public void doCreate(HashMap<String,String> attributes, Activity afterSendActivity) {
		
		/*
		 * Create dialog
		 */
		DmsCreateDialog createDialog = new DmsCreateDialog();
		
		/*
		 * Provide request specific information
		 */
		createDialog.setParams(attributes);
		createDialog.addSendActivity(afterSendActivity);

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
		String[] keys = {
			JaxrConstants.RIM_ID
		};
		
		JSONObject jRecord = JsonConverter.recordToJson(record, keys);
		String data = jRecord.toString();

		/*
		 * Invoke delete request
		 */
		DmsService service = new DmsService();
		service.doDelete(attributes, data, activity);
		
	}

	/**
	 * @param attributes
	 * @param record
	 * @param activity
	 */
	public void doEdit(final HashMap<String,String> attributes, final Record record, final Activity afterSendActivity) {

		final DmsWidget self = this;
		
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

		final DmsWidget self = this;
		
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
		String title  = GUIGlobals.APP_TITLE + ": Dms Viewer";
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

		// TODO
	

		/*
		 * Prepare get request
		 */
		String format = FormatConstants.FNC_FORMAT_ID_Object;
		String item = record.getAttributeAsString(JaxrConstants.RIM_ID);
		
		/*
		 * Invoke get request
		 */
		UserService service = new UserService();
		service.doGet(format, item, afterGetActivity);

	
	}

	/**
	 * Build Dms Edit Dialog
	 * 
	 * @param jValue
	 */
	private void buildEditDialog(HashMap<String,String> attributes, JSONValue jValue, Activity afterSubmitActivity) {
		// TODO
	}

	/**
	 * Build Dms Viewer
	 * 
	 * @param jValue
	 */
	private void buildGetViewer(HashMap<String,String> attributes, JSONValue jValue) {
		// TODO
	}

}
