package de.kp.ames.web.client.openlayers;

import de.kp.ames.web.client.openlayers.util.JSObject;

public class StyleMap extends OpenLayersObjectWrapper{

	protected StyleMap(JSObject element) {
		super(element);
	}

	public StyleMap(Style defaultStyle) {
		this(StyleMapImpl.create(defaultStyle.getJSObject()));
	}

}
