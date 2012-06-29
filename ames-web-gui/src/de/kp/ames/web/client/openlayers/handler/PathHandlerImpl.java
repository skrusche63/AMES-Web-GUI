package de.kp.ames.web.client.openlayers.handler;

import de.kp.ames.web.client.openlayers.util.JSObject;

class PathHandlerImpl {

	public static native JSObject create() /*-{
		return $wnd.OpenLayers.Handler.Path;
	}-*/;

}