package de.kp.ames.web.client.openlayers.event;


/**
 * Needs to be implemented to listen to map zoom events.
 *
 * @author Curtis Jensen
 *
 */
public interface MapZoomListener extends EventListener {

	class MapZoomEvent extends MapEvent {
		public MapZoomEvent(EventObject eventObject) {
			super(eventObject.getJSObject());
		}
	}

	void onMapZoom(MapZoomEvent eventObject);

}
