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
import com.google.gwt.json.client.JSONValue;
import com.smartgwt.client.data.Record;
import de.kp.ames.web.client.core.activity.Activity;
import de.kp.ames.web.client.core.activity.ActivityImpl;
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
	public void doDelete(HashMap<String,String> attributes, Record record, Activity activity) {

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
	 * Edit product or productor
	 * 
	 * @param attributes
	 * @param record
	 * @param activity
	 */
	public void doEdit(final HashMap<String,String> attributes, final Record record, final Activity afterSendActivity) {

		final ProductWidget self = this;
		
		/*
		 * Specify get activity
		 */
		ActivityImpl afterGetActivity = new ActivityImpl() {
			public void execute(JSONValue jValue) {
				self.buildEditDialog(attributes, jValue, afterSendActivity);
			}			
		};

		/*
		 * Retrieve actual version of product or productor
		 */
		doGet(attributes, record, afterGetActivity);
		
	}

	/**
	 * Get product or productor (metadata)
	 * 
	 * @param attributes
	 * @param record
	 */
	public void doGet(final HashMap<String,String> attributes, final Record record) {

		final ProductWidget self = this;
		
		/*
		 * Specify get activity
		 */
		ActivityImpl afterGetActivity = new ActivityImpl() {
			public void execute(JSONValue jValue) {
				self.buildGetViewer(attributes, jValue);
			}			
		};

		/*
		 * Retrieve actual version of product or productor
		 */
		doGet(attributes, record, afterGetActivity);
		
	}

	public void doView(HashMap<String,String> attributes, Record record) {
		// TODO
	}

	private void doGet(HashMap<String,String> attributes, Record record, ActivityImpl afterGetActivity) {
		// TODO
	}

	/**
	 * Build Accessor Edit Dialog
	 * 
	 * @param jValue
	 */
	private void buildEditDialog(HashMap<String,String> attributes, JSONValue jValue, Activity afterSubmitActivity) {
		// TODO
	}

	private void buildGetViewer(HashMap<String,String> attributes, JSONValue jValue) {
		// TODO
	}

}
