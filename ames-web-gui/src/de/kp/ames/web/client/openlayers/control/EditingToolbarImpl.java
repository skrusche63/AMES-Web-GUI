package de.kp.ames.web.client.openlayers.control;

import de.kp.ames.web.client.openlayers.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class EditingToolbarImpl {

	public static native JSObject create(JSObject vectorLayer)/*-{
		return new $wnd.OpenLayers.Control.EditingToolbar(vectorLayer);
	}-*/;

	public static native JSObject create(JSObject vectorLayer, JSObject options)/*-{
		return new $wnd.OpenLayers.Control.EditingToolbar(vectorLayer, options);
	}-*/;

}
