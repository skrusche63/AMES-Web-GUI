package de.kp.ames.web.client.openlayers.popup;

import de.kp.ames.web.client.openlayers.popup.Popup.CloseListener;
import de.kp.ames.web.client.openlayers.util.JSObject;

/**
 *
 * @author Erdem Gunay
 * @author Curtis Jensen
 *
 */
class PopupImpl {

	public static native JSObject create(String id, JSObject lonlat, JSObject size, String html, boolean closeBox) /*-{
		return new $wnd.OpenLayers.Popup(id, lonlat, size, html, closeBox);
	}-*/;

	public static native void addCloseListener(JSObject popup, CloseListener callback) /*-{
		function closebox(evt) {
			callback.@de.kp.ames.web.client.openlayers.popup.Popup.CloseListener::onPopupClose(Lde/kp/ames/web/client/openlayers/util/JSObject;)(evt);
		}

		popup.addCloseBox(closebox);
	}-*/;
}
