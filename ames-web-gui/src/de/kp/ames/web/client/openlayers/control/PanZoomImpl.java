package de.kp.ames.web.client.openlayers.control;

import de.kp.ames.web.client.openlayers.util.JSObject;

/**
 * See {@link PanZoom}.
 *
 * @author Edwin Commandeur
 * @since GWT-OL 0.4, OL ...
 *
 */
class PanZoomImpl {

	public static native JSObject create()/*-{
		return new $wnd.OpenLayers.Control.PanZoom();
	}-*/;

	public static native JSObject create(JSObject options)/*-{
		return new $wnd.OpenLayers.Control.PanZoom(options);
	}-*/;

}
