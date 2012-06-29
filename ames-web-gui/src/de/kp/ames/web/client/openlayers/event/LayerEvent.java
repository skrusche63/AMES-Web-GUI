package de.kp.ames.web.client.openlayers.event;


import de.kp.ames.web.client.openlayers.layer.Layer;
import de.kp.ames.web.client.openlayers.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
class LayerEvent extends EventObject {

	protected LayerEvent(JSObject eventObject) {
		super(eventObject);
	}

	public Layer getSource(){
		JSObject object = getSourceJSObject();
		return (object!=null)?Layer.narrowToLayer(object):null;
	}

}
