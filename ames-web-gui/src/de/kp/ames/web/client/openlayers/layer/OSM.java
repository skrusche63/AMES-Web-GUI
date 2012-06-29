package de.kp.ames.web.client.openlayers.layer;

import de.kp.ames.web.client.openlayers.util.JSObject;

/**
 * The javascript implementation of the class OSM is defined in a small add-on
 * javascript library for OpenStreetMap.
 *
 * See: http://openstreetmap.org/openlayers/OpenStreetMap.js
 */
public class OSM extends Layer {

	protected OSM(JSObject element) {
		super(element);
	}

	public static OSM Mapnik (String name){
		return new OSM(OSMImpl.Mapnik(name));
	}

	public static OSM Mapnik (String name, OSMOptions options){
		return new OSM(OSMImpl.Mapnik(name, options.getJSObject()));
	}

	public static OSM Osmarender (String name){
		return new OSM(OSMImpl.Osmarender(name));
	}

	public static OSM Osmarender (String name, OSMOptions options){
		return new OSM(OSMImpl.Osmarender(name, options.getJSObject()));
	}

	public static OSM CycleMap (String name){
		return new OSM(OSMImpl.CycleMap(name));
	}

	public static OSM CycleMap (String name, OSMOptions options){
		return new OSM(OSMImpl.CycleMap(name, options.getJSObject()));
	}

	public static OSM Maplint (String name){
		return new OSM(OSMImpl.Maplint(name));
	}

	public static OSM Maplint (String name, OSMOptions options){
		return new OSM(OSMImpl.Maplint(name, options.getJSObject()));
	}


}
