package de.kp.ames.web.client.openlayers.layer;

import de.kp.ames.web.client.openlayers.util.JSObject;
import de.kp.ames.web.client.openlayers.util.JStringArray;

public class TileCache extends Layer {

	protected TileCache(JSObject element) {
		super(element);
	}

	public TileCache(String name, JStringArray url, double maxResolution) {
		this(TileCacheImpl.create(name, url.getJSObject(), maxResolution));
	}
}
