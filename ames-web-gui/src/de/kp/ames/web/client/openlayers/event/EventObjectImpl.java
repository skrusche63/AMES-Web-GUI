package de.kp.ames.web.client.openlayers.event;

import de.kp.ames.web.client.openlayers.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
class EventObjectImpl {

	public static native JSObject getElement(JSObject eventObject)/*-{
		return (eventObject.element)?(eventObject.element):null;
	}-*/;

	public static native String getType(JSObject eventObject)/*-{
		return (eventObject.type)?(eventObject.type):null;
	}-*/;

	public static native JSObject getObject(JSObject eventObject)/*-{
		return (eventObject.object)?(eventObject.object):null;
	}-*/;

}
