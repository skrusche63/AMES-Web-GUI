package de.kp.ames.web.client.openlayers.event;


/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface MarkerBrowserEventListener extends EventListener {

	class MarkerBrowserEvent extends MarkerEvent {

		public MarkerBrowserEvent(EventObject eventObject) {
			super(eventObject.getJSObject());
		}

	}

	public void onBrowserEvent(MarkerBrowserEvent markerBrowserEvent);
}
