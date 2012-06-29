package de.kp.ames.web.client.openlayers.control;

import de.kp.ames.web.client.openlayers.util.JSObject;

/**
 *
 * @author Curtis Jensen
 *
 */
public class MouseDefaults extends Control {

	protected MouseDefaults(JSObject element) {
		super(element);
	}

	public MouseDefaults() {
		this(MouseToolbarImpl.create());
	}

	public MouseDefaults(MouseDefaultsOptions options) {
		this(MouseDefaultsImpl.create(options.getJSObject()));
	}

}
