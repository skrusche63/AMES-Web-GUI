package de.kp.ames.web.client.function.map;

import java.util.Collection;
import java.util.HashMap;

import de.kp.ames.web.client.core.globals.CoreGlobals;

public class RegisteredMaps {

	private HashMap<String, MapConfig> maps;
	
	private static RegisteredMaps instance = new RegisteredMaps();
	
	private RegisteredMaps() {
		maps = new HashMap<String, MapConfig>();
	}
	
	public static RegisteredMaps getInstance() {
		if (instance == null) instance = new RegisteredMaps();
		return instance;
	}
	
	public Collection<MapConfig> getMaps() {
		return maps.values();		
	}
	
	public MapConfig getMap(String name) {
		if (maps.containsKey(name)) return maps.get(name);
		return null;
	}
	
	public void createAfghanistan() {
		
		/* 
		 * Map Bounds
		 */
		String minx = "61.498";
		String miny = "30.330";
		String maxx = "70.842";
		String maxy = "37.893";
		
		/*
		 * WMS Layer (name)
		 */
		String layer = "afghanistan";
		
		/*
		 * WMS API
		 */
		String name = "afghanistan";
		
		/*
		 * Server URL
		 */
		String server = CoreGlobals.WMS_URL;
		
		/*
		 * Projection
		 */
		String srs = "EPSG:4326";
		
		MapConfig map = new MapConfig();
		
		map.setBounds(minx, miny, maxx, maxy);
		map.setSrs(srs);
		
		map.setWmsName(name);
		map.setWmsServer(server);
		
		map.setWmsLayers(layer);

		maps.put(name, map);
		
	}
}
