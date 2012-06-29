package de.kp.ames.web.client.openlayers.handler;

import de.kp.ames.web.client.openlayers.util.JSObject;

/**
 *
 *
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class PolygonHandler extends PointHandler {

	protected PolygonHandler(JSObject element) {
		super(element);
	}

	public PolygonHandler(){
		this(PolygonHandlerImpl.create());
	}

}
