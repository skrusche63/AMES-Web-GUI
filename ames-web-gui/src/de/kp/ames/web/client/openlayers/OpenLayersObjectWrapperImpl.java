package de.kp.ames.web.client.openlayers;

import de.kp.ames.web.client.openlayers.util.JSObject;

/**
 * See {@OpenLayersObjectWrapper}.
 *
 * @author Erdem Gunay
 * @author Edwin Commandeur
 */
class OpenLayersObjectWrapperImpl {

	public static native JSObject getEvents(JSObject self)/*-{
		var events = self.events;
		return (events === undefined) ? null : events;
	}-*/;

	public static native String getClassName(JSObject self)/*-{
		var className = self.CLASS_NAME;
		return (className === undefined) ? null : className;
	}-*/;
}
