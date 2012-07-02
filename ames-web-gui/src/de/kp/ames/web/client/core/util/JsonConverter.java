package de.kp.ames.web.client.core.util;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class JsonConverter {

	/**
	 * @param record
	 * @param keys
	 * @return
	 */
	public static JSONObject recordToJson(ListGridRecord record, String[] keys) {
		
		JSONObject jRecord = new JSONObject();
		
		for (String key:keys) {
			jRecord.put(key, new JSONString(record.getAttributeAsString(key)));
		}
		
		return jRecord;
		
	}
	
}
