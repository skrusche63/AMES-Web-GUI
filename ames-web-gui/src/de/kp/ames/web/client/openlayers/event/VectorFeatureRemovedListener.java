package de.kp.ames.web.client.openlayers.event;


/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface VectorFeatureRemovedListener extends EventListener {

	class FeatureRemovedEvent extends VectorFeatureEvent {

		public FeatureRemovedEvent(EventObject eventObject) {
			super(eventObject.getJSObject());
		}

	}

	public void onFeatureRemoved(FeatureRemovedEvent eventObject);
}
