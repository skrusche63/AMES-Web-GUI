package de.kp.ames.web.client.openlayers.event;

import de.kp.ames.web.client.openlayers.util.JSObject;

public class EventHandlerImpl {

	public native static JSObject createHandler(EventHandler self)/*-{
		var handler = function(eo){
			var eventObject = @de.kp.ames.web.client.openlayers.event.EventObject::narrowToEventObject(Lde/kp/ames/web/client/openlayers/util/JSObject;)(eo);
			self.@de.kp.ames.web.client.openlayers.event.EventHandler::onHandle(Lde/kp/ames/web/client/openlayers/event/EventObject;)(eventObject);
		}
		return handler;
	 }-*/;

}
