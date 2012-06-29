package de.kp.ames.web.client.openlayers;

import de.kp.ames.web.client.openlayers.event.EventHandler;
import de.kp.ames.web.client.openlayers.event.EventObject;
import de.kp.ames.web.client.openlayers.event.MarkerBrowserEventListener;
import de.kp.ames.web.client.openlayers.event.MarkerBrowserEventListener.MarkerBrowserEvent;
import de.kp.ames.web.client.openlayers.util.JSObject;

public class LabelMarker extends OpenLayersEObjectWrapper {

	protected LabelMarker(JSObject element) {
		super(element);
	}

	public static LabelMarker narrowToLabelMarker(JSObject element)
	{
		return (element == null)? null: new LabelMarker(element);
	}

	public LabelMarker(LonLat lonlat, Icon icon, String title) {
		this (LabelMarkerImpl.create(lonlat.getJSObject(), icon.getJSObject(), title));
	}

	public LonLat getLonLat() {
		return LonLat.narrowToLonLat(LabelMarkerImpl.getLonLat(getJSObject()));
	}

	public Icon getIcon() {
		return Icon.narrowToIcon(LabelMarkerImpl.getIcon(getJSObject()));
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
