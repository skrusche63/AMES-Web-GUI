package de.kp.ames.web.client.openlayers;

import de.kp.ames.web.client.openlayers.util.JSObject;

public class LabelMarkerImpl {

	public static native JSObject create(JSObject lonlat, JSObject icon, String title)/*-{
		return new $wnd.OpenLayers.Marker.LabelMarker(lonlat, icon, title);
	}-*/;

	public static native JSObject getLonLat(JSObject self)/*-{
		return self.lonlat;
	}-*/;

	public static native JSObject getIcon(JSObject self)/*-{
		return self.icon;
	}-*/;

}
