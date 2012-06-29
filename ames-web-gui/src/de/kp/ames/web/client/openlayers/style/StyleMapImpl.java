package de.kp.ames.web.client.openlayers.style;

import de.kp.ames.web.client.openlayers.util.JSObject;

public class StyleMapImpl {
	/**
	 * @author Rafael Ceravolo - LOGANN
	 */

    /** Creates a StyleMap JSObject with the default properties */
	public static native JSObject create() /*-{
		return new $wnd.OpenLayers.StyleMap();
	}-*/;


	public static native JSObject create(JSObject style) /*-{
		return new $wnd.OpenLayers.StyleMap(style);
	}-*/;

	public static native JSObject create(JSObject defaultStyle, JSObject selectStyle, JSObject temporaryStyle) /*-{
		return new $wnd.OpenLayers.StyleMap({
				"default" : defaultStyle,
				"select" : selectStyle,
				"temporary" : temporaryStyle
			});
	}-*/;

}

