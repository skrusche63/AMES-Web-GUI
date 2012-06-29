package de.kp.ames.web.client.openlayers.handler;

import de.kp.ames.web.client.openlayers.util.JSObject;

class PolygonHandlerImpl {

	public static native JSObject create() /*-{
		return $wnd.OpenLayers.Handler.Polygon;
	}-*/;

}