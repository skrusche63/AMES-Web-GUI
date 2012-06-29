package de.kp.ames.web.client.openlayers.layer;

import de.kp.ames.web.client.openlayers.LonLat;
import de.kp.ames.web.client.openlayers.util.JSObject;


/**
 *
 * comment: no such layer in OpenLayers 2.x
 *
 * @author Erdem Gunay
 *
 */
public class Canvas extends Layer {

	protected Canvas(JSObject element) {
		super(element);
	}

	public Canvas(String name) {
		this(CanvasImpl.create(name));
	}

	public void drawLine(LonLat p1, LonLat p2) {
		CanvasImpl.drawLine(getJSObject(), p1.getJSObject(), p2.getJSObject());
	}
}
