package de.kp.ames.web.client.openlayers.event;


/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface MapLayerAddedListener extends EventListener {

	class MapLayerAddedEvent extends MapLayerEvent {

		public MapLayerAddedEvent(EventObject eventObject) {
			super(eventObject.getJSObject());
		}

	}

	public void onLayerAdded(MapLayerAddedEvent eventObject);
}
