package de.kp.ames.web.client.openlayers;

import de.kp.ames.web.client.openlayers.event.EventHandler;
import de.kp.ames.web.client.openlayers.event.EventObject;
import de.kp.ames.web.client.openlayers.event.MarkerBrowserEventListener;
import de.kp.ames.web.client.openlayers.event.MarkerBrowserEventListener.MarkerBrowserEvent;
import de.kp.ames.web.client.openlayers.util.JSObject;


/**
 *
 * @author Erdem Gunay
 *
 */
public class Marker extends OpenLayersEObjectWrapper {

	protected Marker(JSObject element) {
		super(element);
	}

	public static Marker narrowToMarker(JSObject element)
	{
		return (element == null)? null: new Marker(element);
	}

	public Marker(LonLat lonlat) {
		this (MarkerImpl.create(lonlat.getJSObject()));
	}

	public Marker(LonLat lonlat, Icon icon) {
		this (MarkerImpl.create(lonlat.getJSObject(), icon.getJSObject()));
	}

	public LonLat getLonLat() {
		return LonLat.narrowToLonLat(MarkerImpl.getLonLat(getJSObject()));
	}

	public Icon getIcon() {
		return Icon.narrowToIcon(MarkerImpl.getIcon(getJSObject()));
	}

	public void addBrowserEventListener(String browserEvent, final MarkerBrowserEventListener listener){
		eventListeners.addListener(this, listener, browserEvent, new EventHandler (){
			public void onHandle(EventObject eventObject) {
				MarkerBrowserEvent e = new MarkerBrowserEvent(eventObject);
				listener.onBrowserEvent(e);
			}
		});
	};

}
