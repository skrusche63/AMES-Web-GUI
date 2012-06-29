package de.kp.ames.web.client.openlayers.control;

import de.kp.ames.web.client.openlayers.util.JSObject;

/**
 *
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class ScaleLineImpl {

	public static native JSObject create()/*-{
		return new $wnd.OpenLayers.Control.ScaleLine();
	}-*/;

	public static native JSObject create(JSObject options)/*-{
		return new $wnd.OpenLayers.Control.ScaleLine(options);
	}-*/;
}
