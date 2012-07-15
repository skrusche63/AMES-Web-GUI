package de.kp.ames.web.client.function.upload;
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
import de.kp.ames.web.client.function.product.ProductService;
import de.kp.ames.web.shared.ClassificationConstants;
import de.kp.ames.web.shared.FormatConstants;
import de.kp.ames.web.shared.JsonConstants;
import de.kp.ames.web.shared.MethodConstants;
import de.kp.ames.web.shared.ServiceConstants;

public class UploadWidget {

	/*
	 * The target of all the upload widget requests
	 * is the respective transient cache
	 */	
	public UploadWidget() {
	}

	/**
	 * @param attributes
	 * @param record
	 * @param activity
	 */
	public void doDelete(HashMap<String,String> attributes, Record record, Activity activity) {
		
		/*
		 * Prepare data for delete request;
		 */
		String[] keys = {
			JsonConstants.J_KEY
		};
		
		JSONObject jRecord = JsonConverter.recordToJson(record, keys);
		String data = jRecord.toString();

		/*
		 * Invoke delete request
		 */
		ProductService service = new ProductService();
		service.doDelete(attributes, data, activity);

	}
	
	/**
	 * @param attributes
	 * @param activity
	 */
	public void doUpload(HashMap<String,String> attributes, Activity activity) {
		// TODO
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
		String title  = GUIGlobals.APP_TITLE + ": Cache Viewer";
		String slogan = "Use this widget to view transient information objects.";
		
		ViewerFactory.createFrameViewer(title, slogan, uri);
		
	}

}
