package de.kp.ames.web.client.openlayers.event;

import de.kp.ames.web.client.openlayers.control.Control;
import de.kp.ames.web.client.openlayers.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
class ControlEvent extends EventObject {

	protected ControlEvent(JSObject eventObject) {
		super(eventObject);
	}

	public Control getSource(){
		JSObject object = getSourceJSObject();
		return (object!=null)?Control.narrowToControl(object):null;
	}

}
