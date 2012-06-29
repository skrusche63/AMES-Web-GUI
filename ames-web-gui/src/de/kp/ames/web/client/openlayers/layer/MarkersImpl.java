package de.kp.ames.web.client.openlayers.layer;

import de.kp.ames.web.client.openlayers.util.JSObject;

/**
 *
 * @author Erdem Gunay
 * @author Wayne Fang - Refractions Research
 * @author Aaron Novstrup - Stottler Henke Associates, Inc.
 *
 */
class MarkersImpl {

	public static native JSObject create(String name)/*-{
		return new $wnd.OpenLayers.Layer.Markers(name);
	}-*/;

	public static native void addMarker(JSObject markers, JSObject marker)/*-{
		markers.addMarker(marker);
	}-*/;

	public static native void removeMarker(JSObject markers, JSObject marker)/*-{
		markers.removeMarker(marker);
	}-*/;

	public static native JSObject getDataExtent(JSObject markers)/*-{
	   return markers.getDataExtent();
	}-*/;

	public static native void destroy(JSObject markers)/*-{
		markers.destroy();
	}-*/;
	
	// __EXTENSION__ Dr. Krusche & Partner PartG
	public static native void clearMarkers(JSObject markers)/*-{
		markers.clearMarkers();
	}-*/;
	
}
