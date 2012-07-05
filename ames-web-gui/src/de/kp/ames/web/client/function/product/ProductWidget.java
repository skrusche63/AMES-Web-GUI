package de.kp.ames.web.client.function.product;
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
import de.kp.ames.web.client.core.util.JsonConverter;
import de.kp.ames.web.shared.ClassificationConstants;
import de.kp.ames.web.shared.JaxrConstants;
import de.kp.ames.web.shared.MethodConstants;

public class ProductWidget {

	public ProductWidget() {
	}
	
	/**
	 * @param attributes
	 * @param activity
	 */
	public void doCreate(HashMap<String,String> attributes, Activity activity) {
		// TODO
	}

	/**
	 * @param attributes
	 * @param record
	 * @param activity
	 */
	public void doDelete(HashMap<String,String> attributes, ListGridRecord record, Activity activity) {

		String type = attributes.get(MethodConstants.ATTR_TYPE);
		if (type.equals(ClassificationConstants.FNC_ID_Product)) {
			
			// TODO
			
		} else if (type.equals(ClassificationConstants.FNC_ID_Productor)) {
			
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
			ProductService service = new ProductService();
			service.doDelete(attributes, data, activity);
			
		}
		
	}
	
	/**
	 * @param attributes
	 * @param record
	 * @param activity
	 */
	public void doEdit(HashMap<String,String> attributes, ListGridRecord record, Activity activity) {
		// TODO
	}

	public void doGet(HashMap<String,String> attributes, ListGridRecord record) {
		// TODO
	}

	public void doView(HashMap<String,String> attributes, ListGridRecord record) {
		// TODO
	}

}
