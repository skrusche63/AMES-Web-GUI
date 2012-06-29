package de.kp.ames.web.client.openlayers.control;

import de.kp.ames.web.client.openlayers.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class OverviewMap extends Control {

	protected OverviewMap(JSObject element) {
		super(element);
	}

	public OverviewMap() {
		this(OverviewMapImpl.create());
	}

	public OverviewMap(OverviewMapOptions options) {
		this(OverviewMapImpl.create(options.getJSObject()));
	}

	//
	// legacy
	//

	/*
	public OverviewMap(Options params) {
		this(OverviewMapImpl.create(params.getJSObject()));
	}
	*/
}
