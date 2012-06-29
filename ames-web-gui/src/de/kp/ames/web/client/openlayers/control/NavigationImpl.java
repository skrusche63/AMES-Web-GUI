package de.kp.ames.web.client.openlayers.control;

import de.kp.ames.web.client.openlayers.util.JSObject;

/**
 * See {@link Navigation}.
 *
 * @author Edwin Commandeur
 *
 */
class NavigationImpl {

	public static native JSObject create()/*-{
		return new $wnd.OpenLayers.Control.Navigation();
	}-*/;

	public static native JSObject create(JSObject options)/*-{
		return new $wnd.OpenLayers.Control.Navigation(options);
	}-*/;

}
