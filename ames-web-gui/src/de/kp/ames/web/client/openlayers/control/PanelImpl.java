package de.kp.ames.web.client.openlayers.control;

import de.kp.ames.web.client.openlayers.util.JSObject;

/**
 *
 * @author Curtis Jensen
 *
 */
class PanelImpl {

	public static native JSObject create(JSObject options) /*-{
		return new $wnd.OpenLayers.Control.MouseDefaults(options);
	}-*/;

	public static native void addControls(JSObject panel, JSObject controls) /*-{
		panel.addControls(controls);
	}-*/;
}
