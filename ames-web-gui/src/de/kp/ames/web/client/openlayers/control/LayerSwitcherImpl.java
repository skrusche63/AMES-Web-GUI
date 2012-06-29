package de.kp.ames.web.client.openlayers.control;

import de.kp.ames.web.client.openlayers.util.JSObject;

/**
 *
 * @author Erdem Gunay
 *
 */
class LayerSwitcherImpl {

	public static native JSObject create()/*-{
		return new $wnd.OpenLayers.Control.LayerSwitcher();
	}-*/;

	public static native JSObject create(JSObject options)/*-{
		return new $wnd.OpenLayers.Control.LayerSwitcher(options);
	}-*/;

}
