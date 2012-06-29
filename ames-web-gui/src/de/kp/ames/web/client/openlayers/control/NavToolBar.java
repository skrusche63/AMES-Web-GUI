package de.kp.ames.web.client.openlayers.control;

import de.kp.ames.web.client.openlayers.util.JSObject;

/**
 * Access the openlayers navtoolbar control.
 *
 * @author Emily Gouge - Refractions Research
 *
 */
public class NavToolBar extends Control{

	protected NavToolBar(JSObject element) {
		super(element);
	}

	public NavToolBar(){
		this(NavToolBarImpl.create());
	}

	public NavToolBar(NavToolBarOptions options) {
		this(NavToolBarImpl.create(options.getJSObject()));
	}

	/*
	//TODO: move to PanZoomBarOptions
		public NavToolBar(Element div){
			super((JSObject)null);
			Options options = new Options();
			options.setAttribute("div", div);
			setJSObject(NavToolBarImpl.create(options.getJSObject()));
		}
	*/

}
