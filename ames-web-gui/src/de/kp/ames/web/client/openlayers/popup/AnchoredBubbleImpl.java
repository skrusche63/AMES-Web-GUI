package de.kp.ames.web.client.openlayers.popup;

import de.kp.ames.web.client.openlayers.util.JSObject;

/**
 *
 * @author Erdem Gunay
 *
 */
class AnchoredBubbleImpl {

	public static native JSObject create(String id, JSObject lonlat, JSObject size, String html, JSObject anchor, boolean closeBox) /*-{
		return new $wnd.OpenLayers.Popup.AnchoredBubble(id, lonlat, size, html, anchor, closeBox);
	}-*/;

}
