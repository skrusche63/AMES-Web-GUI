package de.kp.ames.web.client.openlayers.handler;

import de.kp.ames.web.client.openlayers.util.JSObject;

class PointHandlerImpl {

	public static native JSObject create() /*-{
		return $wnd.OpenLayers.Handler.Point;
	}-*/;

}