package de.kp.ames.web.client.openlayers.control;

import de.kp.ames.web.client.openlayers.util.JSObject;

/**
 * See {@link Attribution}.
 *
 * @author Edwin Commandeur
 *
 */
class AttributionImpl {

	public static native JSObject create()/*-{
		return new $wnd.OpenLayers.Control.Attribution();
	}-*/;

	public static native JSObject create(JSObject options)/*-{
		return new $wnd.OpenLayers.Control.Attribution(options);
	}-*/;

}
