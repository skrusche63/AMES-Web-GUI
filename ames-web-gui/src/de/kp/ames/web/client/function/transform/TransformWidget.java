package de.kp.ames.web.client.function.transform;
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
import com.smartgwt.client.data.Record;
import de.kp.ames.web.client.core.activity.Activity;
import de.kp.ames.web.client.core.globals.GUIGlobals;
import de.kp.ames.web.client.core.service.FrameService;
import de.kp.ames.web.client.core.util.JsonConverter;
import de.kp.ames.web.client.core.widget.viewer.ViewerFactory;
import de.kp.ames.web.shared.ClassificationConstants;
import de.kp.ames.web.shared.FormatConstants;
import de.kp.ames.web.shared.JaxrConstants;
import de.kp.ames.web.shared.MethodConstants;

public class TransformWidget {

	/**
	 * Constructor
	 */
	public TransformWidget() {
	}

	/**
	 * @param attributes
	 * @param activity
	 */
	public void doCreate(HashMap<String,String> attributes, Activity activity) {
		// TODO
	}

	/**
	 * Delete Transformator
	 * 
	 * @param attributes
	 * @param record
	 * @param activity
	 */
	public void doDelete(HashMap<String,String> attributes, Record record, Activity activity) {

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
		TransformService service = new TransformService();
		service.doDelete(attributes, data, activity);
		
	}

	/**
	 * View transformator (XSL file)
	 * 
	 * @param attributes
	 * @param record
	 */
	public void doView(HashMap<String,String> attributes, Record record) {

		/*
		 * View transformator
		 */
		String format = FormatConstants.FNC_FORMAT_ID_File;
		attributes.put(MethodConstants.ATTR_FORMAT, format);

		String type = ClassificationConstants.FNC_ID_Transformator;
		attributes.put(MethodConstants.ATTR_TYPE, type);
		
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
		String title  = GUIGlobals.APP_TITLE + ": Transform Viewer";
		String slogan = "Use this widget to view a certain transformator.";
		
		ViewerFactory.createFrameViewer(title, slogan, uri);

	}

}
