package de.kp.ames.web.client.openlayers.event;


/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface VectorFeatureAddedListener extends EventListener {

	class FeatureAddedEvent extends VectorFeatureEvent {

		public FeatureAddedEvent(EventObject eventObject) {
			super(eventObject.getJSObject());
		}

	}

	public void onFeatureAdded(FeatureAddedEvent eventObject);
}
