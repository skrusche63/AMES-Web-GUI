package de.kp.ames.web.client.openlayers.layer;

import de.kp.ames.web.client.openlayers.util.JSObject;

/**
 *
 * @author Erdem Gunay
 *
 */
class CanvasImpl {

	public static native JSObject create(String name)/*-{
		return new $wnd.OpenLayers.Layer.Canvas(name);
	}-*/;

	public static native void drawLine(JSObject self, JSObject p1, JSObject p2)/*-{
		self.drawLine(p1, p2);
	}-*/;
}
