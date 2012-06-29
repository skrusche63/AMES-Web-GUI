package de.kp.ames.web.client.openlayers.control;


import de.kp.ames.web.client.openlayers.layer.KMLLayer;
import de.kp.ames.web.client.openlayers.util.JSObject;

public class SelectKMLLayer extends SelectFeature {

	protected SelectKMLLayer(JSObject element) {
		super(element);
	}

	/**
	 *
	 * @param layer
	 */
	public SelectKMLLayer(KMLLayer layer) {
		this(SelectFeatureImpl.create(layer.getJSObject()));
	}

	/**
	*
	* @param layer
	*/

	public SelectKMLLayer(KMLLayer layer, SelectFeatureOptions options) {
		this(SelectFeatureImpl.create(layer.getJSObject(), options.getJSObject()));
	}

	public void addLayer(KMLLayer layer) {
		SelectFeatureImpl.addLayer(getJSObject(), layer.getJSObject());
	}
	
}
