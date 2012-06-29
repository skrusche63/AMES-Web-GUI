package de.kp.ames.web.client.openlayers.event;

import de.kp.ames.web.client.openlayers.LonLat;
import de.kp.ames.web.client.openlayers.Map;
import de.kp.ames.web.client.openlayers.Pixel;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface MapClickListener extends EventListener {

	class MapClickEvent extends MapEvent {

		public MapClickEvent(EventObject eventObject) {
			super(eventObject.getJSObject());
		}

		public LonLat getLonLat(){
			Map map = Map.narrowToMap(this.getSourceJSObject());
			Pixel pixel = Pixel.narrowToPixel(getJSObject().getProperty("xy"));
			return (pixel != null)? map.getLonLatFromPixel(pixel):null;
		}
	}

	public void onClick(MapClickEvent mapClickEvent);
}
