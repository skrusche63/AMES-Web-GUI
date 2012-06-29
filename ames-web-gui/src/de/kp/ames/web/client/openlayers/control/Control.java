package de.kp.ames.web.client.openlayers.control;

import de.kp.ames.web.client.openlayers.OpenLayersEObjectWrapper;
import de.kp.ames.web.client.openlayers.event.ControlActivateListener;
import de.kp.ames.web.client.openlayers.event.ControlDeactivateListener;
import de.kp.ames.web.client.openlayers.event.EventHandler;
import de.kp.ames.web.client.openlayers.event.EventObject;
import de.kp.ames.web.client.openlayers.event.EventType;
import de.kp.ames.web.client.openlayers.event.ControlActivateListener.ControlActivateEvent;
import de.kp.ames.web.client.openlayers.event.ControlDeactivateListener.ControlDeactivateEvent;
import de.kp.ames.web.client.openlayers.util.JSObject;


/**
 *
 * @author Erdem Gunay
 *
 */
public class Control extends OpenLayersEObjectWrapper {

	protected Control(JSObject element) {
		super(element);
	}

	public static Control narrowToControl(JSObject object){
		return new Control(object);
	}

	public boolean activate() {
		return ControlImpl.activate(getJSObject());
	}

	public boolean deactivate() {
		return ControlImpl.deactivate(getJSObject());
	}

	public void addControlActivateListener(final ControlActivateListener listener){
		eventListeners.addListener(this, listener, EventType.CONTROL_ACTIVATE, new EventHandler(){
			public void onHandle(EventObject eventObject) {
				ControlActivateEvent e = new ControlActivateEvent(eventObject);
				listener.onActivate(e);
			}
		 });
	};

	public void addControlDeactivateListener(final ControlDeactivateListener listener){
		eventListeners.addListener(this, listener, EventType.CONTROL_DEACTIVATE, new EventHandler(){
			public void onHandle(EventObject eventObject) {
				ControlDeactivateEvent e = new ControlDeactivateEvent(eventObject);
				listener.onDeactivate(e);
			}
		 });
	};

}
