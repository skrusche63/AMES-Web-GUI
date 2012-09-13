package de.kp.ames.web.client.fnc.group;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.fnc.group
 *  Module: GroupController
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #controller #fnc #group #web
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

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;

import de.kp.ames.web.client.core.activity.Activity;
import de.kp.ames.web.client.core.activity.ActivityImpl;
import de.kp.ames.web.client.core.util.JsonConverter;
import de.kp.ames.web.client.fnc.globals.FncGlobals;
import de.kp.ames.web.client.fnc.group.widget.GroupCategoryDialog;
import de.kp.ames.web.client.fnc.group.widget.GroupCreateDialog;
import de.kp.ames.web.client.fnc.group.widget.GroupEditDialog;
import de.kp.ames.web.client.fnc.group.widget.GroupGetViewer;
import de.kp.ames.web.shared.constants.ClassificationConstants;
import de.kp.ames.web.shared.constants.FormatConstants;
import de.kp.ames.web.shared.constants.JaxrConstants;
import de.kp.ames.web.shared.constants.MethodConstants;

public class GroupController {
	/**
	 * Constructor
	 */
	public GroupController() {
	}

	/**
	 * Manage community categories
	 * 
	 * @param attributes
	 * @param record
	 * @param afterSendActivity
	 */
	public void doCategory(final HashMap<String,String> attributes, final Activity afterSendActivity) {
		GroupCategoryDialog.create(attributes, afterSendActivity);
	}

	/**
	 * Create group
	 * 
	 * @param attributes
	 * @param activity
	 */
	public void doCreate(HashMap<String,String> attributes, Activity activity) {
		GroupCreateDialog.create(attributes, activity);
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
			 * Prepare data for delete request; note, that a community
			 * is a single registry object and deleted with a reference
			 * to its uid; providing additional 'data' is deprecated
			 * and will be removed in the next version
			 */
			attributes.put(MethodConstants.ATTR_ITEM, record.getAttributeAsString(JaxrConstants.RIM_ID));
			/*
			 * Invoke delete request
			 */
			GroupService service = new GroupService();
			service.doDelete(attributes, activity);
			
		}

	}

	/**
	 * @param attributes
	 * @param record
	 * @param afterSendActivity
	 */
	public void doEdit(final HashMap<String,String> attributes, final Record record, final Activity afterSendActivity) {

		final GroupController self = this;
		
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

		final GroupController self = this;
		
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
		GroupEditDialog.create(attributes, jValue, afterSendActivity);
	}

	/**
	 * Build Group (Metadata) Viewer
	 * 
	 * @param jValue
	 */
	private void buildGetViewer(HashMap<String,String> attributes, JSONValue jValue) {
		GroupGetViewer.create(attributes, jValue);
	}

}
