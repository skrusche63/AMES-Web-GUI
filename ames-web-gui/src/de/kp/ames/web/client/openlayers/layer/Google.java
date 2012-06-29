package de.kp.ames.web.client.openlayers.layer;

import de.kp.ames.web.client.openlayers.LonLat;
import de.kp.ames.web.client.openlayers.util.JSObject;


/**
 *
 * @author Erdem Gunay
 * @author Aaron Novstrup - Stottler Henke Associates, Inc.
 *
 */
public class Google extends Layer {

	//In OpenLayers this class inherits from both EventPane
	// and FixedZoomLevels

	protected Google(JSObject element) {
		super(element);
	}

	public Google(String name) {
		this(GoogleImpl.create(name));
	}

	public Google(String name, GoogleOptions params) {
	   this(GoogleImpl.create(name, params.getJSObject()));
	}

	public LonLat forwardMercator(double lon, double lat)
	{
	   return LonLat.narrowToLonLat(GoogleImpl.forwardMercator(getJSObject(), lon, lat));
	}

}
