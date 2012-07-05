package de.kp.ames.web.client.function.group;

import java.util.HashMap;

import com.google.gwt.json.client.JSONObject;
import com.smartgwt.client.widgets.grid.ListGridRecord;

import de.kp.ames.web.client.core.activity.Activity;
import de.kp.ames.web.client.core.util.JsonConverter;
import de.kp.ames.web.shared.ClassificationConstants;
import de.kp.ames.web.shared.JaxrConstants;
import de.kp.ames.web.shared.MethodConstants;

public class GroupWidget {
	/**
	 * Constructor
	 */
	public GroupWidget() {
	}

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
	 * @param activity
	 */
	public void doEdit(HashMap<String,String> attributes, ListGridRecord record, Activity activity) {
		// TODO
	}

	/**
	 * Get group
	 * 
	 * @param attributes
	 * @param record
	 */
	public void doGet(HashMap<String,String> attributes, ListGridRecord record) {
		// TODO
	}

}
