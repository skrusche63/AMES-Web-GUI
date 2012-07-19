package de.kp.ames.web.client.function.group;
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
import de.kp.ames.web.client.core.util.JsonConverter;
import de.kp.ames.web.client.core.widget.viewer.ViewerFactory;
import de.kp.ames.web.client.function.globals.FncGlobals;
import de.kp.ames.web.client.function.group.widget.GroupCreateDialog;
import de.kp.ames.web.client.function.group.widget.GroupEditDialog;
import de.kp.ames.web.client.model.GroupObject;
import de.kp.ames.web.shared.ClassificationConstants;
import de.kp.ames.web.shared.FormatConstants;
import de.kp.ames.web.shared.JaxrConstants;
import de.kp.ames.web.shared.MethodConstants;

public class GroupWidget {
	/**
	 * Constructor
	 */
	public GroupWidget() {
	}

	/**
	 * Create group
	 * 
	 * @param attributes
	 * @param activity
	 */
	public void doCreate(HashMap<String,String> attributes, Activity activity) {

		/*
		 * Create dialog
		 */
		GroupCreateDialog createDialog = new GroupCreateDialog();
		
		/*
		 * Provide request specific information
		 */
		createDialog.setParams(attributes);
		createDialog.addSendActivity(activity);
		
	}

	/**
	 * Delete group
	 * 
	 * @param attributes
	 * @param record
	 * @param activity
	 */
	public void doDelete(final HashMap<String,String> attributes, final Record record, final Activity activity) {

		SC.confirm(FncGlobals.CONFIRM_GROUP_DELETE, new BooleanCallback() {  
 
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
		
		String type = attributes.get(MethodConstants.ATTR_TYPE);
		if (type.equals(ClassificationConstants.FNC_ID_Affiliation)) {

			/*
			 * Prepare data for delete request
			 */
			String[] keys = {
				JaxrConstants.RIM_SOURCE,
				JaxrConstants.RIM_TARGET
			};
			
			JSONObject jRecord = JsonConverter.recordToJson(record, keys);
			String data = jRecord.toString();
			
			/*
			 * Invoke delete request
			 */
			GroupService service = new GroupService();
			service.doDelete(attributes, data, activity);

		} else if (type.equals(ClassificationConstants.FNC_ID_Community)) {
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
			GroupService service = new GroupService();
			service.doDelete(attributes, data, activity);
			
		}

	}

	/**
	 * @param attributes
	 * @param record
	 * @param afterSendActivity
	 */
	public void doEdit(final HashMap<String,String> attributes, final Record record, final Activity afterSendActivity) {

		final GroupWidget self = this;
		
		/*
		 * Specify get activity
		 */
		ActivityImpl afterGetActivity = new ActivityImpl() {
			public void execute(JSONValue jValue) {
				self.buildEditDialog(attributes, jValue, afterSendActivity);
			}			
		};

		/*
		 * Retrieve actual version of group
		 */
		doGet(attributes, record, afterGetActivity);
		
	}

	/**
	 * Get group
	 * 
	 * @param attributes
	 * @param record
	 */
	public void doGet(final HashMap<String,String> attributes, final Record record) {

		final GroupWidget self = this;
		
		/*
		 * Specify get activity
		 */
		ActivityImpl afterGetActivity = new ActivityImpl() {
			public void execute(JSONValue jValue) {
				self.buildGetViewer(attributes, jValue);
			}			
		};

		/*
		 * Retrieve actual version of group
		 */
		doGet(attributes, record, afterGetActivity);
		
	}

	/**
	 * Get Group (metadata)
	 * 
	 * @param attributes
	 * @param record
	 * @param afterGetActivity
	 */
	private void doGet(HashMap<String,String> attributes, Record record, ActivityImpl afterGetActivity) {
		/*
		 * Prepare get request
		 */
		String type = ClassificationConstants.FNC_ID_Community;
		
		String format = FormatConstants.FNC_FORMAT_ID_Object;
		String item = record.getAttributeAsString(JaxrConstants.RIM_ID);
		
		/*
		 * No affiliate provided
		 */
		String source = null;
		
		/*
		 * Invoke get request
		 */
		GroupService service = new GroupService();
		service.doGet(format, type, item, source, afterGetActivity);
	
	}

	/**
	 * Build Group Edit Dialog
	 * 
	 * @param jValue
	 */
	private void buildEditDialog(HashMap<String,String> attributes, JSONValue jValue, Activity afterSendActivity) {

		GroupEditDialog dialog = new GroupEditDialog(jValue);
		dialog.addSendActivity(afterSendActivity);
	
	}

	/**
	 * Build Group (Metadata) Viewer
	 * 
	 * @param jValue
	 */
	private void buildGetViewer(HashMap<String,String> attributes, JSONValue jValue) {

		String html = new GroupObject().toHtml(jValue);
		
		String title  = FncGlobals.GROUP_G_TITLE;
		String slogan = FncGlobals.GROUP_G_SLOGAN;
		
		ViewerFactory.createHtmlViewer(title, slogan, html);
		
	}

}
