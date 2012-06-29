package de.kp.ames.web.client.openlayers.event;


/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface ControlDeactivateListener extends EventListener {

	class ControlDeactivateEvent extends ControlEvent {
		public ControlDeactivateEvent(EventObject eventObject){
			super(eventObject.getJSObject());
		}
	}

	void onDeactivate(ControlDeactivateEvent eventObject);
}
