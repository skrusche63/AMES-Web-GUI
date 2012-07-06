package de.kp.ames.web.client.function.access;
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
import com.smartgwt.client.widgets.grid.ListGridRecord;

import de.kp.ames.web.client.core.activity.Activity;
import de.kp.ames.web.client.core.activity.ActivityImpl;
import de.kp.ames.web.client.core.globals.GUIGlobals;
import de.kp.ames.web.client.core.service.FrameService;
import de.kp.ames.web.client.core.widget.viewer.ViewerFactory;
import de.kp.ames.web.client.function.access.widget.AccessorEditDialog;
import de.kp.ames.web.shared.ClassificationConstants;
import de.kp.ames.web.shared.FormatConstants;
import de.kp.ames.web.shared.JaxrConstants;
import de.kp.ames.web.shared.MethodConstants;

public class AccessWidget {

	/**
	 * Constructor
	 */
	public AccessWidget() {
	}
	
	/**
	 * Create Accessor
	 * 
	 * @param attributes
	 * @param activity
	 */
	public void doCreate(HashMap<String,String> attributes, Activity activity) {
		// TODO
	}

	/**
	 * Delete accessor
	 * 
	 * @param attributes
	 * @param record
	 * @param activity
	 */
	public void doDelete(HashMap<String,String> attributes, ListGridRecord record, Activity activity) {
		// TODO
	}

	/**
	 * Edit accessor
	 * 
	 * @param attributes
	 * @param record
	 * @param afterSendActivity
	 */
	public void doEdit(final HashMap<String,String> attributes, final ListGridRecord record, final Activity afterSendActivity) {

		final AccessWidget self = this;
		
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
	public void doGet(final HashMap<String,String> attributes, final ListGridRecord record) {

		final AccessWidget self = this;
		
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
	 * View remote object
	 * 
	 * @param attributes
	 * @param record
	 */
	public void doView(HashMap<String,String> attributes, ListGridRecord record) {

		/*
		 * Reference to the remote object to be viewed
		 */
		String source = record.getAttributeAsString(JaxrConstants.RIM_ID);
		attributes.put(MethodConstants.ATTR_SOURCE, source);

		/*
		 * The retrieval of remote information objects is
		 * actually restricted to office documents
		 */
		String format = FormatConstants.FNC_FORMAT_ID_File;
		attributes.put(MethodConstants.ATTR_FORMAT, format);

		/*
		 * Build request uri
		 */
		FrameService service = new FrameService();
		String uri = service.getUri(attributes);

		/*
		 * Build viewer
		 */
		String title  = GUIGlobals.APP_TITLE + ": Remote Viewer";
		String slogan = "Use this widget to view a certain remote object.";
		
		ViewerFactory.createFrameViewer(title, slogan, uri);

	
	}

	/**
	 * Get accessor or remote object
	 * 
	 * @param attributes
	 * @param record
	 * @param afterGetActivity
	 */
	private void doGet(HashMap<String,String> attributes, ListGridRecord record, ActivityImpl afterGetActivity) {
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
		AccessorEditDialog dialog = new AccessorEditDialog(jValue);
		dialog.addSendActivity(afterSendActivity);
	}

	/**
	 * Build Accessor or Remote Viewer
	 * 
	 * @param jValue
	 */
	private void buildGetViewer(HashMap<String,String> attributes, JSONValue jValue) {

		String type = attributes.get(MethodConstants.ATTR_TYPE);
		if (type.equals(ClassificationConstants.FNC_ID_Accessor)) {
			// TODO
		
		} else {
			// TDO
		}
	}

}
