package de.kp.ames.web.client.openlayers.event;


import de.kp.ames.web.client.openlayers.feature.VectorFeature;
import de.kp.ames.web.client.openlayers.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
class VectorFeatureEvent extends VectorEvent {

	protected VectorFeatureEvent(JSObject eventObject) {
		super(eventObject);
	}

	public VectorFeature getVectorFeature(){
		JSObject object = getJSObject().getProperty("feature");
		return (object!=null)?VectorFeature.narrowToVectorFeature(object):null;
	}

}
