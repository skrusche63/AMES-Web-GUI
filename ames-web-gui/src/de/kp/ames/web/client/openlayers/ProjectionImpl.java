package de.kp.ames.web.client.openlayers;

import de.kp.ames.web.client.openlayers.util.JSObject;

/**
 *
 * @author Evgeny Gazdovsky
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class ProjectionImpl {

	public static native JSObject create(String projection)/*-{
		return new $wnd.OpenLayers.Projection(projection);
	}-*/;

	public static native String getProjectionCode(JSObject self)/*-{
		return self.getCode();
	}-*/;
}
