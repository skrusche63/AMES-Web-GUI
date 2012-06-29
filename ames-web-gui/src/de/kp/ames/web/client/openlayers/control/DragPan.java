package de.kp.ames.web.client.openlayers.control;

import de.kp.ames.web.client.openlayers.util.JSObject;

/**
 * DragPan control wrapper.
 *
 * @author Aaron Novstrup - Stottler Henke Associates, Inc.
 *
 */
public class DragPan extends Control {
	protected DragPan(JSObject element) {
		super(element);
	}

	public DragPan() {
		this(DragPanImpl.create());
	}

}
