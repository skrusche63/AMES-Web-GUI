package de.kp.ames.web.client.fnc.access;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.fnc.access
 *  Module: AccessController
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #access #client #controller #fnc #web
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
import de.kp.ames.web.client.core.grid.Grid;
import de.kp.ames.web.client.fnc.access.widget.AccessorCreateDialog;
import de.kp.ames.web.client.fnc.access.widget.AccessorEditDialog;
import de.kp.ames.web.client.fnc.access.widget.AccessorGetViewer;
import de.kp.ames.web.client.fnc.access.widget.RemoteGetViewer;
import de.kp.ames.web.client.fnc.globals.FncGlobals;
import de.kp.ames.web.shared.constants.ClassificationConstants;
import de.kp.ames.web.shared.constants.FormatConstants;
import de.kp.ames.web.shared.constants.JaxrConstants;
import de.kp.ames.web.shared.constants.MethodConstants;

public class AccessController extends ControllerImpl {
	
	/**
	 * Constructor
	 */
	public AccessController() {
	}
	
	/**
	 * Create Accessor
	 * 
	 * @param attributes
	 * @param activity
	 */
	public void doCreate(HashMap<String,String> attributes, Grid grid, Activity activity) {
		AccessorCreateDialog.create(attributes, grid, activity);
	}

	/**
	 * Delete accessor
	 * 
	 * @param attributes
	 * @param record
	 * @param activity
	 */
	public void doDelete(final HashMap<String,String> attributes, final Grid grid, final Record record, final Activity activity) {

		SC.confirm(FncGlobals.CONFIRM_ACCESSOR_DELETE, new BooleanCallback() {  
 
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
	 * Delete accessor
	 * 
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
		AccessService service = new AccessService();
		service.doDelete(attributes, activity);

	}

	/**
	 * Edit accessor
	 * 
	 * @param attributes
	 * @param record
	 * @param afterSendActivity
	 */
	public void doEdit(final HashMap<String,String> attributes, final Record record, final Activity afterSendActivity) {

		final AccessController self = this;
		
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
	 * Get accessor or remote object
	 * 
	 * @param attributes
	 * @param record
	 */
	public void doGet(final HashMap<String,String> attributes, final Record record) {

		String type = attributes.get(MethodConstants.ATTR_TYPE);
		if (type.equals(ClassificationConstants.FNC_ID_Accessor)) {
			
			/*
			 * Specify get activity
			 */
			ActivityImpl afterGetActivity = new ActivityImpl() {
				public void execute(JSONValue jValue) {
					AccessorGetViewer.create(attributes, jValue);
				}			
			};
	
			/*
			 * Retrieve actual version of accessor
			 */
			doGet(attributes, record, afterGetActivity);
			
		} else {
			/*
			 * Retrieve a single remote object
			 */
			RemoteGetViewer.create(attributes, record);

		}
		
	}

	/**
	 * Get accessor
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
		AccessService service = new AccessService();
		service.doGet(format, type, item, afterGetActivity);
		
	}

	/**
	 * Build Accessor Edit Dialog
	 * 
	 * @param jValue
	 */
	private void buildEditDialog(HashMap<String,String> attributes, JSONValue jValue, Activity afterSendActivity) {
		AccessorEditDialog.create(attributes, jValue, afterSendActivity);
	}

}
