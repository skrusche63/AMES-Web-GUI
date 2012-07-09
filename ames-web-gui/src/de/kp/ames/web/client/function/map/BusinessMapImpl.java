package de.kp.ames.web.client.function.map;
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

import java.util.ArrayList;

import com.smartgwt.client.data.Record;

import de.kp.ames.map.client.BaseMapImpl;
import de.kp.ames.map.client.MapConfig;
import de.kp.ames.map.client.listener.MapListener;
import de.kp.ames.map.client.openlayers.LonLat;
import de.kp.ames.map.client.openlayers.feature.VectorFeature;
import de.kp.ames.map.client.openlayers.geometry.Point;

public class BusinessMapImpl extends BaseMapImpl {

	/**
	 * Constructor
	 * 
	 * @param jGeoInfo
	 * @param listener
	 */
	public BusinessMapImpl(MapConfig jGeoInfo, MapListener listener) {
		super(jGeoInfo, listener);
	}
	
	/**
	 * Add vector feature
	 * 
	 * @param record
	 */
	public void addFeature(Record record) {
		
		/* 
		 * Retrieve lat & lon from the center coordinate
		 */
		LonLat center = map.getCenter();

		double lat = center.lat();
		double lon = center.lon();
		
		/*
		 * Key
		 */
		String key = record.getAttributeAsString("key");
		
		if (featureKeys == null) featureKeys = new ArrayList<String>();
		if (featureKeys.contains(key)) return;

		// register feature key
		featureKeys.add(key);

		double res = map.getResolution();

		double x = lon + res*18;
		double y = lat;

		VectorFeature feature = new VectorFeature(new Point(x,y));		
		feature.setPluginStyle();

		/*
		 * Icon
		 */
		String icon = record.getAttributeAsString("icon");
		feature.setExternalGraphic(icon, true);

		// key (common to all objects, see drag&drop)
		feature.setAttributeAsString(FEA_ATTR_KEY, key);
	
		/*
		 * Name
		 */
		String title = record.getAttributeAsString("name");		
		feature.setAttributeAsString(FEA_ATTR_NAME, title);

		/*
		 * Description
		 */
		StringBuffer description = new StringBuffer();
		description.append(record.getAttributeAsString("desc"));		
		
		feature.setAttributeAsString(FEA_ATTR_DESC, description.toString());

		feature.setLabel(title);

		featureLayer.addFeature(feature);		
		featureLayer.drawFeature(feature);
		
	}

	/**
	 * Set vector feature
	 * 
	 * @param record
	 */
	public void setRegistry(Record record) {

		/*
		 * Coordinates
		 */
		String lon = record.getAttributeAsString("lon");
		String lat = record.getAttributeAsString("lat");

		if ((lat == null) || (lon == null)) return;
		if (lat.equals("null") || lon.equals("null")) return;
		
		/*
		 * Key
		 */
		String key = record.getAttributeAsString("key");
		
		if (featureKeys == null) featureKeys = new ArrayList<String>();
		if (featureKeys.contains(key)) return;

		// register feature key
		featureKeys.add(key);

		double res = map.getResolution();

		double x = Double.valueOf(lon) + res*18;
		double y = Double.valueOf(lat);

		VectorFeature feature = new VectorFeature(new Point(x,y));		
		feature.setPluginStyle();

		/*
		 * Icon
		 */
		String icon = record.getAttributeAsString("icon");
		feature.setExternalGraphic(icon, true);

		// key (common to all objects, see drag&drop)
		feature.setAttributeAsString(FEA_ATTR_KEY, key);

		/*
		 * Name
		 */
		String title = record.getAttributeAsString("name");		
		feature.setAttributeAsString(FEA_ATTR_NAME, title);

		/*
		 * Description
		 */
		StringBuffer description = new StringBuffer();
		description.append(record.getAttributeAsString("desc"));		

		feature.setAttributeAsString(FEA_ATTR_DESC, description.toString());

		feature.setLabel(title);

		featureLayer.addFeature(feature);		
		featureLayer.drawFeature(feature);
		
	}

}
