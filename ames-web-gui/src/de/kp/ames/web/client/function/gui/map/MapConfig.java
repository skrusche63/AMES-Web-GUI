package de.kp.ames.web.client.function.gui.map;
/**
 * This file is part of the AMES Web GUI.
 *
 * AMES Web GUI is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * AMES Web GUI is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY 
 * or FITNESS FOR A PARTICULAR PURPOSE.  
 * 
 * See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with the AMES Web GUI.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright (C) 2012 Dr. Krusche & Partner PartG <team@dr-kruscheundpartner.de>
 *
 */

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;

import de.kp.ames.web.client.openlayers.Bounds;

public class MapConfig extends JSONObject {

	private static String GEO_NAME   = "name";
	private static String GEO_SRS    = "srs";
	private static String GEO_LAYERS = "layer";
	private static String GEO_SERVER = "server";

	private static String GEO_MINX = "minx";
	private static String GEO_MINY = "miny";
	private static String GEO_MAXX = "maxx";
	private static String GEO_MAXY = "maxy";

	private JSONObject jBBox;
	
	public MapConfig() {		
	}
	
	/*
	 * Layers
	 */
	public String getWmsLayers() {
		return this.get(GEO_LAYERS).isString().stringValue();
	}

	public void setWmsLayers(String name) {
		this.put(GEO_LAYERS, new JSONString(name));		
	}

	/*
	 * Server 
	 */
	public String getWmsName() {
		return this.get(GEO_NAME).isString().stringValue();
	}

	public void setWmsName(String name) {
		this.put(GEO_NAME, new JSONString(name));
	}
	
	public String getWmsServer() {
		return this.get(GEO_SERVER).isString().stringValue() + "/wms";		
	}
	
	public void setWmsServer(String server) {
		this.put(GEO_SERVER, new JSONString(server));		
	}
	
	/*
	 * Projection
	 */

	/**
	 * Get Projection
	 * 
	 * @return
	 */
	public String getSrs() {
		return this.get(GEO_SRS).isString().stringValue();
	}
	
	/**
	 * Set projection
	 * 
	 * @param srs
	 */
	public void setSrs(String srs) {
		this.put(GEO_SRS, new JSONString(srs));
	}
	
	/**
	 * Get Bounding Box
	 * 
	 * @return
	 */
	public Bounds getBounds() {

		double minx = Float.parseFloat(jBBox.get(GEO_MINX).isString().stringValue());
		double miny = Float.parseFloat(jBBox.get(GEO_MINY).isString().stringValue());
		double maxx = Float.parseFloat(jBBox.get(GEO_MAXX).isString().stringValue());
		double maxy = Float.parseFloat(jBBox.get(GEO_MAXY).isString().stringValue());

		return new Bounds(minx, miny, maxx, maxy);
		
	}

	/**
	 * Set Bounding Box
	 * 
	 * @param minx
	 * @param miny
	 * @param maxx
	 * @param maxy
	 */
	public void setBounds(String minx, String miny, String maxx, String maxy) {
		
		jBBox = new JSONObject();
		
		jBBox.put(GEO_MINX, new JSONString(minx));		
		jBBox.put(GEO_MINY, new JSONString(miny));
		jBBox.put(GEO_MAXX, new JSONString(maxx));
		jBBox.put(GEO_MAXY, new JSONString(maxy));

	}
}
