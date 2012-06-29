package de.kp.ames.web.client.openlayers.event;


/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface MapLayerRemovedListener extends EventListener {

	class MapLayerRemovedEvent extends MapLayerEvent {

		public MapLayerRemovedEvent(EventObject eventObject) {
			super(eventObject.getJSObject());
		}

	}

	public void onLayerRemoved(MapLayerRemovedEvent eventObject);
}
