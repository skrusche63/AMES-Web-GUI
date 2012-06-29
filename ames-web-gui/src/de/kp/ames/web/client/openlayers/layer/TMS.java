package de.kp.ames.web.client.openlayers.layer;

import de.kp.ames.web.client.openlayers.util.JSObject;

/**
 * @author Amr Alam - Refractions Research
 *
 */
public class TMS extends Layer {

	protected TMS(JSObject element) {
		super(element);
	}

	public TMS(String name, String url, TMSOptions options) {
		this(TMSImpl.create(name, url, options.getJSObject()));
	}

	public int getNumLoadingTiles(){
		return TMSImpl.getNumLoadingTiles(this.getJSObject());
	}
}
