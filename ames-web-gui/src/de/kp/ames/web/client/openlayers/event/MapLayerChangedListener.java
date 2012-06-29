package de.kp.ames.web.client.openlayers.event;


/**
 * Listens to 'changelayer' event that fires on:
 *  a name change, an order change, or a visibility change of a layer
 *
 * Listening to visibility changes can be done at the layer level
 * with a LayerVisibilityChangedListener.
 *
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface MapLayerChangedListener extends EventListener {

	class MapLayerChangedEvent extends MapLayerEvent {

		public MapLayerChangedEvent(EventObject eventObject) {
			super(eventObject.getJSObject());
		}

	}

	public void onLayerChanged(MapLayerChangedEvent eventObject);
}
