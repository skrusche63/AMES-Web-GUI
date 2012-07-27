package de.kp.ames.web.client.fnc.map.util;
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

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.smartgwt.client.widgets.grid.ListGridRecord;

import de.kp.ames.map.client.MapConfig;
import de.kp.ames.web.client.core.globals.CoreGlobals;
import de.kp.ames.web.shared.constants.JsonConstants;

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
