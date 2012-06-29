package de.kp.ames.web.client.openlayers.event;


/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface ControlActivateListener extends EventListener {

	class ControlActivateEvent extends ControlEvent {
		public ControlActivateEvent(EventObject eventObject){
			super(eventObject.getJSObject());
		}
	}

	void onActivate(ControlActivateEvent eventObject);
}
