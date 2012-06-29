package de.kp.ames.web.client.openlayers.control;

import de.kp.ames.web.client.openlayers.util.JSObject;

/**
 *
 * @author Erdem Gunay
 *
 */
public class PanZoomBar extends Control {

	protected PanZoomBar(JSObject element) {
		super(element);
	}

	public PanZoomBar() {
		this(PanZoomBarImpl.create());
	}

	public PanZoomBar(PanZoomBarOptions options){
		this(PanZoomBarImpl.create(options.getJSObject()));
	}

	/*
	public PanZoomBar(Options options) {
		this(PanZoomBarImpl.create(options.getJSObject()));
	}
	*/
}
