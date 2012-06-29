package de.kp.ames.web.client.openlayers;

import java.util.Set;

import de.kp.ames.web.client.openlayers.event.EventListener;
import de.kp.ames.web.client.openlayers.event.EventListenerCollection;
import de.kp.ames.web.client.openlayers.util.JSObject;

/**
 * Wrapper object for OpenLayer objects.
 *
 * @author Erdem Gunay
 * @author Edwin Commandeur
 */
public class OpenLayersEObjectWrapper extends OpenLayersObjectWrapper {

	protected EventListenerCollection eventListeners = new EventListenerCollection();

	protected OpenLayersEObjectWrapper(JSObject openLayersObject) {
		super(openLayersObject);
	}

	public static OpenLayersEObjectWrapper narrowToOpenLayersEObjectWrapper(JSObject element) {
		return (element == null)?null: new OpenLayersEObjectWrapper(element);
	}

	public void removeListener(EventListener listener){
		eventListeners.removeListener(this, listener);
	};

	public Set<EventListener> getListeners(){
		return eventListeners.getListeners();
	}
}
