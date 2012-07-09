package de.kp.ames.web.client.function.map.util;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.smartgwt.client.widgets.grid.ListGridRecord;

import de.kp.ames.map.client.MapConfig;
import de.kp.ames.web.client.core.globals.CoreGlobals;
import de.kp.ames.web.shared.JsonConstants;

public class MapUtil {

	/**
	 * A helper method to convert a record into a
	 * MAPConfig representation
	 * 
	 * @param record
	 * @return
	 */
	public static MapConfig buildMapConfig(ListGridRecord record) {

		MapConfig config = new MapConfig();
		config.setWmsLayers(CoreGlobals.WMS_URL);
		
		/*
		 * Bounding Box
		 */
		String bbox = record.getAttributeAsString(JsonConstants.J_BBOX);
		JSONObject jBBox = JSONParser.parseStrict(bbox).isObject();
		
		String minx = jBBox.get(JsonConstants.J_MINX).isString().stringValue();
		String miny = jBBox.get(JsonConstants.J_MINY).isString().stringValue();

		String maxx = jBBox.get(JsonConstants.J_MAXX).isString().stringValue();
		String maxy = jBBox.get(JsonConstants.J_MAXY).isString().stringValue();

		config.setBounds(minx, miny, maxx, maxy);

		/*
		 * WMS Layer (name)
		 */
		String layer = record.getAttributeAsString(JsonConstants.J_NAME);
		config.setWmsLayers(layer);
		
		/*
		 * WMS Name (title)
		 */
		String name = record.getAttributeAsString(JsonConstants.J_TITLE);
		config.setWmsName(name);
		
		/*
		 * SRS
		 */
		String srs = record.getAttributeAsString(JsonConstants.J_SRS);
		config.setSrs(srs);
		
		return config;
		
	}

}
