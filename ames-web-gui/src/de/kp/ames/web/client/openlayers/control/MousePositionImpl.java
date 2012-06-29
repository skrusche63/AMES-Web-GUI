package de.kp.ames.web.client.openlayers.control;

import de.kp.ames.web.client.openlayers.util.JSObject;

/**
 *
 * @author Erdem Gunay
 * @author Edwin Commandeur - Atlis Information Systems
 *
 */
class MousePositionImpl {

	public static native JSObject create()/*-{
		return new $wnd.OpenLayers.Control.MousePosition();
	}-*/;

	public static native JSObject create(JSObject options)/*-{
		return new $wnd.OpenLayers.Control.MousePosition(options);
	}-*/;

	public static native JSObject formatOutput(MousePositionOutput output)/*-{
		var outputFn = function(lonLat){
			var out = ""
			var lonLatObj = @de.kp.ames.web.client.openlayers.LonLat::narrowToLonLat(Lde/kp/ames/web/client/openlayers/util/JSObject;)(lonLat);
			var mapObj = @de.kp.ames.web.client.openlayers.Map::narrowToMap(Lde/kp/ames/web/client/openlayers/util/JSObject;)(this.map);

			out = output.@de.kp.ames.web.client.openlayers.control.MousePositionOutput::format(Lde/kp/ames/web/client/openlayers/LonLat;Lde/kp/ames/web/client/openlayers/Map;)(lonLatObj,mapObj);

			return out;
		}
		return outputFn;
	}-*/;

}
