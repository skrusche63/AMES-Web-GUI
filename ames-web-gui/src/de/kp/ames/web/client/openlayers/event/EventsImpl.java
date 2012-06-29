package de.kp.ames.web.client.openlayers.event;

import de.kp.ames.web.client.openlayers.util.JSObject;

/**
 *
 * @author Erdem Gunay
 * @author Wayne Fang - Refractions Research
 * @author Edwin Commandeur - Atlis EJS
 *
 *
 */
class EventsImpl {

	public native static JSObject register(JSObject self, String type, JSObject obj, JSObject handler) /*-{
		self.register(type, obj, handler);
	}-*/;

	public native static void unregister(JSObject self, String type, JSObject obj, JSObject handler)/*-{
	   self.unregister(type, obj, handler);
	}-*/;

	public native static JSObject getMousePosition(JSObject self, JSObject evt)/*-{
		return self.getMousePosition(evt);
	}-*/;
}
