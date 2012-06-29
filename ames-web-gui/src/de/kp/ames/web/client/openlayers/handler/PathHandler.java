package de.kp.ames.web.client.openlayers.handler;

import de.kp.ames.web.client.openlayers.util.JSObject;

/**
 *
 *
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class PathHandler extends PointHandler {

	protected PathHandler(JSObject element) {
		super(element);
	}

	public PathHandler(){
		this(PathHandlerImpl.create());
	}
}
