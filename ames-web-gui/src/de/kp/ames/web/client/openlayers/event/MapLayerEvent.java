package de.kp.ames.web.client.openlayers.event;


import de.kp.ames.web.client.openlayers.layer.Layer;
import de.kp.ames.web.client.openlayers.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
class MapLayerEvent extends MapEvent {

	protected MapLayerEvent(JSObject eventObject) {
		super(eventObject);
	}

	public Layer getLayer(){
		JSObject object = getJSObject().getProperty("layer");
		return (object!=null)? Layer.narrowToLayer(object): null;
	}

}
