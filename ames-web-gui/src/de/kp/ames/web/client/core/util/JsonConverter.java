package de.kp.ames.web.client.core.util;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.core.util
 *  Module: JsonConverter
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #converter #core #json #util #web
 * </SemanticAssist>
 *
 */


import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.smartgwt.client.data.Record;

public class JsonConverter {

	/**
	 * @param record
	 * @param keys
	 * @return
	 */
	public static JSONObject recordToJson(Record record, String[] keys) {
		
		JSONObject jRecord = new JSONObject();
		
		for (String key:keys) {
			jRecord.put(key, new JSONString(record.getAttributeAsString(key)));
		}
		
		return jRecord;
		
	}
		
}
