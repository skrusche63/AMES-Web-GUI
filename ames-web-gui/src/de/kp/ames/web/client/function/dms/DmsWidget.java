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
import com.smartgwt.client.widgets.grid.ListGridRecord;

import de.kp.ames.web.client.core.activity.Activity;
import de.kp.ames.web.client.core.globals.GUIGlobals;
import de.kp.ames.web.client.core.service.FrameService;
import de.kp.ames.web.client.core.util.JsonConverter;
import de.kp.ames.web.client.core.widget.viewer.ViewerFactory;
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
	 * @param activity
	 */
	public void doCreate(HashMap<String,String> attributes, Activity activity) {
	}

	/**
	 * @param attributes
	 * @param record
	 * @param activity
	 */
	public void doDelete(HashMap<String,String> attributes, ListGridRecord record, Activity activity) {
		
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
	public void doEdit(HashMap<String,String> attributes, ListGridRecord record, Activity activity) {
	}

	/**
	 * Get Dms Entry
	 * 
	 * @param attributes
	 * @param record
	 */
	public void doGet(HashMap<String,String> attributes, ListGridRecord record) {
		// TODO
	}

	/**
	 * @param attributes
	 * @param record
	 */
	public void doView(HashMap<String,String> attributes, ListGridRecord record) {

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
	
}
